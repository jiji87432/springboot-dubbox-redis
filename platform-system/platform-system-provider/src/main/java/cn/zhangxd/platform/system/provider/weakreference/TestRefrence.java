package cn.zhangxd.platform.system.provider.weakreference;

import org.junit.Test;

import java.lang.ref.*;
import java.util.Map;
import java.util.WeakHashMap;

import static org.junit.Assert.*;

/**
 * @author zhangyongji
 * @since 2019-01-15.
 */
public class TestRefrence {

    @Test
    public void strongReference() {
        Object referent = new Object();

        /**
         * 通过赋值创建 StrongReference
         */
        Object strongReference = referent;

        assertSame(referent, strongReference);

        referent = null;
        System.gc();

        /**
         * StrongReference 在 GC 后不会被回收
         */
        assertNotNull(strongReference);
    }


    @Test
    public void weakReference() {
        Object referent = new Object();
        WeakReference<Object> weakRerference = new WeakReference<Object>(referent);

        assertSame(referent, weakRerference.get());

        referent = null;
        System.gc();

        /**
         * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收
         */
        assertNull(weakRerference.get());
    }

    @Test
    public void weakHashMap() throws InterruptedException {
        Map<Object, Object> weakHashMap = new WeakHashMap<Object, Object>();
        Object key = new Object();
        Object value = new Object();
        weakHashMap.put(key, value);

        assertTrue(weakHashMap.containsValue(value));

        key = null;
        System.gc();

        /**
         * 等待无效 entries 进入 ReferenceQueue 以便下一次调用 getTable 时被清理
         */
        Thread.sleep(1000);

        /**
         * 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
         */
        System.out.println(weakHashMap.containsValue(value));
        assertFalse(weakHashMap.containsValue(value));
    }


    @Test
    public void softReference() {
        Object referent = new Object();
        SoftReference<Object> softRerference = new SoftReference<Object>(referent);

        assertNotNull(softRerference.get());

        referent = null;
        System.gc();

        /**
         *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用
         */
        assertNotNull(softRerference.get());
    }

    @Test
    public void phantomReferenceAlwaysNull() {
        Object referent = new Object();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(referent, new ReferenceQueue<Object>());

        /**
         * phantom reference 的 get 方法永远返回 null
         */
        assertNull(phantomReference.get());
    }

    /**
     * 当一个 WeakReference 开始返回 null 时， 它所指向的对象已经准备被回收，
     * 这时可以做一些合适的清理工作.   将一个 ReferenceQueue 传给一个 Reference 的构造函数，
     * 当对象被回收时， 虚拟机会自动将这个对象插入到 ReferenceQueue 中，
     * WeakHashMap 就是利用 ReferenceQueue 来清除 key 已经没有强引用的 entries.
     *
     * @throws InterruptedException
     */
    @Test
    public void referenceQueue() throws InterruptedException {
        Object referent = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        WeakReference<Object> weakReference = new WeakReference<Object>(referent, referenceQueue);

        assertFalse(weakReference.isEnqueued());
        Reference<? extends Object> polled = referenceQueue.poll();
        assertNull(polled);

        referent = null;
        System.gc();

        assertTrue(weakReference.isEnqueued());
        Reference<? extends Object> removed = referenceQueue.remove();
        assertNotNull(removed);
    }

}
