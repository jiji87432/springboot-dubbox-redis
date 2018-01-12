package cn.zhangxd.platform.system.provider.zklock;

import org.apache.zookeeper.KeeperException;

/**
 * A callback object which can be used for implementing retry-able operations in the
 * {@link cn.zhangxd.platform.system.provider.zklock.ProtocolSupport} class
 */
public interface ZooKeeperOperation {

    /**
     * Performs the operation - which may be involved multiple times if the connection
     * to ZooKeeper closes during this operation
     *
     * @return the result of the operation or null
     * @throws KeeperException
     * @throws InterruptedException
     */
    public boolean execute() throws KeeperException, InterruptedException;
}