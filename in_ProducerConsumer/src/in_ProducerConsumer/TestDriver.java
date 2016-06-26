package in_ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestDriver {

    private static class Producer implements Runnable {
        public Producer(ArrayMultiPutBlockingBoundedQueue<String> queue, int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                while (counter < COUNTER_MAX) {
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        counter++;
                        final String msg = "Producer[" + id + "] : Message #: " + counter;
                        System.out.format("inserting: %s %n", msg); // DEBUG
                        queue.put(msg);
                    } else {
                        final int count = ThreadLocalRandom.current().nextInt(1, 4);
                        final List<String> msgs = new ArrayList<String>(count);
                        final String msgPrefix = "Producer[" + id + "] : Message #: ";
                        for (int i = 0; i < count; i++) {
                            counter++;
                            msgs.add(msgPrefix + counter);
                        }
                        System.out.format("inserting: %sfrom %d to %d %n", msgPrefix, counter - count + 1, counter); // DEBUG
                        queue.multiput(msgs);
                    }
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

        private final ArrayMultiPutBlockingBoundedQueue<String> queue;
        private final int id;
        private int counter = 0;
        private static final int COUNTER_MAX = 32;
    }

    private static class Consumer implements Runnable {
        public Consumer(ArrayMultiPutBlockingBoundedQueue<String> queue, int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    final String msg = queue.get();
                    System.out.format("Consumer[%d] extracted msg: %s %n", id, msg); // DEBUG
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

        private final ArrayMultiPutBlockingBoundedQueue<String> queue;
        private final int id;
    }

    public static void main(String[] args) throws Exception {
        int num = 0;
        final int MIN_THREADS = 3;
        final int MAX_THREAD = 8;
        final int QUEUE_CAPACITY = 32;

        if (args.length >= 0) {
            try {
                num = Integer.parseInt(args[0]);
            } catch (final Exception e) {
            }
        }
        if (num < MIN_THREADS)
            num = MIN_THREADS;
        if (num > MAX_THREAD)
            num = MAX_THREAD;

        final ArrayMultiPutBlockingBoundedQueue<String> queue = new ArrayMultiPutBlockingBoundedQueue<String>();
        queue.init(QUEUE_CAPACITY);
        Thread.sleep(1000);

        for (int i = 0; i < num; i++) {
            (new Thread(new Producer(queue, i))).start();
            (new Thread(new Consumer(queue, i))).start();
        }
    }

}
