package cn.zhangxd.platform.system.provider.zklock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZookeeperDistributeLock implements DistributedLock {

	private static Logger logger = LoggerFactory.getLogger(ZookeeperDistributeLock.class);

	public static void main(String[] args) throws IOException {
		ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 60000, null);
		ZookeeperDistributeLock myLock = new ZookeeperDistributeLock(zooKeeper, "/test", "lock-");
		while (true) {
			try {
				myLock.lock();
				Thread.sleep(5000);

			} catch (Exception e) {

			} finally {
				myLock.unLock();
			}
		}

	}

	private ZooKeeper zooKeeper;
	private String rootPath;// ��·����
	private String lockNamePre;// ��ǰ׺
	private String currentLockPath;// ���ڱ���ĳ���ͻ�����locker���洴���ɹ���˳��ڵ㣬���ں�����ز���ʹ�ã����жϣ�
	private static int MAX_RETRY_COUNT = 10;// ������Դ���

	public ZookeeperDistributeLock(ZooKeeper zookeeper, String rootPath, String lockNamePre) {
		logger.info("rootPath:{},lockNamePre:{}", rootPath, lockNamePre);
		this.zooKeeper = zookeeper;
		this.rootPath = rootPath;
		this.lockNamePre = lockNamePre;
		init();
	}

	/**
	 * ��ʼ����Ŀ¼
	 */
	private void init() {
		try {
			Stat stat = zooKeeper.exists(rootPath, false);// �ж�һ�¸�Ŀ¼�Ƿ����
			if (stat == null) {
				zooKeeper.create(rootPath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
		} catch (Exception e) {
			logger.error("create rootPath error", e);
		}
	}

	/**
	 * ȡ�����������
	 *
	 * @param str
	 * @param lockName
	 * @return
	 */
	private String getLockNodeNumber(String str, String lockName) {
		int index = str.lastIndexOf(lockName);
		if (index >= 0) {
			index += lockName.length();
			return index <= str.length() ? str.substring(index) : "";
		}
		return str;
	}

	/**
	 * ȡ�����������б�
	 *
	 * @return
	 * @throws Exception
	 */
	private List<String> getSortedChildren() throws Exception {
		List<String> children = zooKeeper.getChildren(rootPath, false);
		if (children != null && !children.isEmpty()) {
			Collections.sort(children, new Comparator<String>() {
				public int compare(String lhs, String rhs) {
					return getLockNodeNumber(lhs, lockNamePre).compareTo(getLockNodeNumber(rhs, lockNamePre));
				}
			});
		}
		logger.info("sort childRen:{}", children);
		return children;
	}

	/**
	 * �÷��������ж��Լ��Ƿ��ȡ�����������Լ�������˳��ڵ���locker�������ӽڵ����Ƿ���С.���û�л�ȡ��������ȴ������ͻ��������ͷţ�
	 * �����Ժ�����ֱ����ȡ�������߳�ʱ
	 *
	 * @param startMillis
	 * @param millisToWait
	 * @param ourPath
	 * @return
	 * @throws Exception
	 */
	private boolean waitToLock(long startMillis, Long millisToWait) throws Exception {

		boolean haveTheLock = false;
		boolean doDelete = false;

		try {
			while (!haveTheLock) {
				logger.info("get Lock Begin");
				// �÷���ʵ�ֻ�ȡlocker�ڵ��µ�����˳��ڵ㣬���Ҵ�С��������,
				List<String> children = getSortedChildren();
				String sequenceNodeName = currentLockPath.substring(rootPath.length() + 1);

				// ����ղſͻ��˴�����˳��ڵ���locker�������ӽڵ�������λ�ã����������Ϊ0�����ʾ��ȡ������
				int ourIndex = children.indexOf(sequenceNodeName);

				/*
				 * �����getSortedChildren��û���ҵ�֮ǰ������[��ʱ]˳��ڵ㣬���ʾ���������������϶�����
				 * Zookeeper��Ϊ���ӶϿ���ɾ�������Ǵ����Ľڵ㣬��ʱ��Ҫ�׳��쳣������һ��ȥ����
				 * ��һ���������ǲ�����쳣������ִ������ָ���Ĵ��� ������� attemptLock����
				 */
				if (ourIndex < 0) {
					logger.error("not find node:{}", sequenceNodeName);
					throw new Exception("�ڵ�û���ҵ�: " + sequenceNodeName);
				}

				// �����ǰ�ͻ��˴����Ľڵ���locker�ӽڵ��б���λ�ô���0����ʾ�����ͻ����Ѿ���ȡ����
				// ��ʱ��ǰ�ͻ�����Ҫ�ȴ������ͻ����ͷ�����
				boolean isGetTheLock = ourIndex == 0;

				// ����ж������ͻ����Ƿ��Ѿ��ͷ����������ӽڵ��б��л�ȡ�����Լ���С���ĸ��ڵ㣬�����佨������
				String pathToWatch = isGetTheLock ? null : children.get(ourIndex - 1);

				if (isGetTheLock) {
					logger.info("get the lock,currentLockPath:{}", currentLockPath);
					haveTheLock = true;
				} else {
					// �����С�Ľڵ㱻ɾ���ˣ����ʾ��ǰ�ͻ��˵Ľڵ�Ӧ������С���ˣ�����ʹ��CountDownLatch��ʵ�ֵȴ�
					String previousSequencePath = rootPath.concat("/").concat(pathToWatch);
					final CountDownLatch latch = new CountDownLatch(1);
					final Watcher previousListener = new Watcher() {
						public void process(WatchedEvent event) {
							if (event.getType() == EventType.NodeDeleted) {
								latch.countDown();
							}
						}
					};

					// ����ڵ㲻���ڻ�����쳣
					zooKeeper.exists(previousSequencePath, previousListener);

					// ����г�ʱʱ�䣬�յ���ʱʱ��ͷ���
					if (millisToWait != null) {
						millisToWait -= (System.currentTimeMillis() - startMillis);
						startMillis = System.currentTimeMillis();
						if (millisToWait <= 0) {
							doDelete = true; // timed out - delete our node
							break;
						}

						latch.await(millisToWait, TimeUnit.MICROSECONDS);
					} else {
						latch.await();
					}
				}
			}
		} catch (Exception e) {
			// �����쳣��Ҫɾ���ڵ�
			logger.error("waitToLock exception", e);
			doDelete = true;
			throw e;
		} finally {
			// �����Ҫɾ���ڵ�
			if (doDelete) {
				unLock();
			}
		}
		logger.info("get Lock end,haveTheLock=" + haveTheLock);
		return haveTheLock;
	}

	/**
	 * createLockNode������locker��basePath�־ýڵ㣩�´����ͻ���Ҫ��ȡ����[��ʱ]˳��ڵ�
	 *
	 * @param path
	 * @return
	 * @throws Exception
	 */
	private String createLockNode(String path) throws Exception {
		Stat stat = zooKeeper.exists(rootPath, false);
		// �ж�һ�¸�Ŀ¼�Ƿ����
		if (stat == null) {
			zooKeeper.create(rootPath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		return zooKeeper.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
	}

	/**
	 * ���Ի�ȡ����������ӳ�ʱʱ�䣬�����ȴ������򣬾��Ǽ��˳�ʱ�������ȴ�
	 *
	 * @param time
	 * @param unit
	 * @return
	 * @throws Exception
	 */
	private Boolean attemptLock(long time, TimeUnit unit) throws Exception {
		final long startMillis = System.currentTimeMillis();
		final Long millisToWait = (unit != null) ? unit.toMillis(time) : null;

		boolean hasTheLock = false;
		boolean isDone = false;
		int retryCount = 0;

		// ����������Ҫ����һ�ԣ�������Դ���MAX_RETRY_COUNT
		while (!isDone) {
			isDone = true;
			try {
				currentLockPath = createLockNode(rootPath.concat("/").concat(lockNamePre));
				hasTheLock = waitToLock(startMillis, millisToWait);

			} catch (Exception e) {
				if (retryCount++ < MAX_RETRY_COUNT) {
					isDone = false;
				} else {
					throw e;
				}
			}
		}

		return hasTheLock;
	}

	public boolean tryLock() throws Exception {
		logger.info("tryLock Lock Begin");
		// �÷���ʵ�ֻ�ȡlocker�ڵ��µ�����˳��ڵ㣬���Ҵ�С��������,
		List<String> children = getSortedChildren();
		String sequenceNodeName = currentLockPath.substring(rootPath.length() + 1);

		// ����ղſͻ��˴�����˳��ڵ���locker�������ӽڵ�������λ�ã����������Ϊ0�����ʾ��ȡ������
		int ourIndex = children.indexOf(sequenceNodeName);

		if (ourIndex < 0) {
			logger.error("not find node:{}", sequenceNodeName);
			throw new Exception("�ڵ�û���ҵ�: " + sequenceNodeName);
		}

		// �����ǰ�ͻ��˴����Ľڵ���locker�ӽڵ��б���λ�ô���0����ʾ�����ͻ����Ѿ���ȡ����
		return ourIndex == 0;
	}

	public void lock() throws Exception {
		// -1,null��ʾ�����ȴ��������ó�ʱʱ��
		attemptLock(-1, null);

	}

	public boolean lock(long time, TimeUnit unit) throws Exception {
		if (time <= 0) {
			throw new Exception("Lock wait for time must greater than 0");
		}

		if (unit == null) {
			throw new Exception("TimeUnit can not be null");
		}

		return attemptLock(time, unit);
	}

	public void unLock() {
		try {
			zooKeeper.delete(currentLockPath, -1);
		} catch (Exception e) {
			logger.error("unLock error", e);

		}

	}

}
