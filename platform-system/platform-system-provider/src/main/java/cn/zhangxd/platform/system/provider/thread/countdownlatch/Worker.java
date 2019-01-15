package cn.zhangxd.platform.system.provider.thread.countdownlatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author zhangyongji
 * @since 2019-01-15.
 */
public class Worker implements Runnable {

    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("doSomeWork()");
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> outputScrapers = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<Thread> workers = Stream.generate(() -> new Thread(new Worker(outputScrapers, countDownLatch)))
                                     .limit(5)
                                     .collect(toList());
        workers.forEach(Thread::start);
        countDownLatch.await();
        outputScrapers.add("Latch released");
        outputScrapers.forEach(outputScraper -> System.out.println(outputScraper));
//        assertThat(outputScraper)
//                .containsExactly(
//                        "Counted down",
//                        "Counted down",
//                        "Counted down",
//                        "Counted down",
//                        "Counted down",
//                        "Latch released"
//                );
    }
}
