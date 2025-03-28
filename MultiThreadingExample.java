class MyThread extends Thread {
    private final Object lock;

    public MyThread(String name, Object lock) {
        this.setName(name);
        this.lock = lock;
    }

    public void display() {
        System.out.println(getName() + " - Unsync method starts(Thread)");

        for (int i = 0; i <= 5; i++) {
            System.out.println(getName() + " - Unsync: " + i);

            try {
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(getName() + " - Unsync ending(Thread)");
    }

    synchronized public void syncDisplay() {
        System.out.println(getName() + " - Sync started(thread)");

        for (int i = 0; i <= 5; i++) {
            System.out.println(getName() + " - Sync: " + i);
            try {
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(getName() + " - Sync ending(Thread)");
    }

    public void run() {
        display();
        syncDisplay();

        synchronized (lock) {
            System.out.println(getName() + " - Starting thread");

            for (int i = 1; i <= 5; i++) {
                System.out.println(getName() + " - Count: " + '*');
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

            System.out.println(getName() + " - Finished counting.");

            // Notify waiting thread
            lock.notify();
        }
    }
}

class MyRunnable implements Runnable {
    private final Object lock;

    public MyRunnable(Object lock) {
        this.lock = lock;
    }

    public void print() {
        System.out.println(Thread.currentThread().getName() + " - Unsync start(Runnable)");

        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Unsync: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println(Thread.currentThread().getName() + " - Unsync ending(Runnable)");
    }

    synchronized public void syncPrint() {
        System.out.println(Thread.currentThread().getName() + " - Sync start(Runnable)");

        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Sync: " + i);

            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Sync ending(Runnable)");
    }

    public void run() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " - Waiting for notification...");

            try {
                lock.wait(); // Wait until notified
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            System.out.println(Thread.currentThread().getName() + " - Got notified, resuming...");

            print();
            syncPrint();
        }
    }
}

public class MultiThreadingExample {
    public static void main(String[] args) {
        Object lock = new Object();

        // Creating MyThread instances
        MyThread t1 = new MyThread("Thread-1", lock);
        MyThread t2 = new MyThread("Thread-2", lock);

        // Creating MyRunnable instances
        MyRunnable mr = new MyRunnable(lock);
        Thread t3 = new Thread(mr, "Runnable-1");
        Thread t4 = new Thread(mr, "Runnable-2");

        // Setting priorities
        t1.setPriority(Thread.MAX_PRIORITY); // Priority 10
        t2.setPriority(Thread.MIN_PRIORITY); // Priority 1
        t3.setPriority(Thread.NORM_PRIORITY); // Priority 5
        t4.setPriority(Thread.NORM_PRIORITY); // Priority 5

        System.out.println("\nTHREADS STARTED:");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("\nTHREAD FINISHED!");
    }
}
