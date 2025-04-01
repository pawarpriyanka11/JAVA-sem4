class DisplayThread extends Thread {
    public DisplayThread(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println(getName() + " --INCREMENTER--");

        for (int i = 0; i <= 5; i++) {
            System.out.println(getName() + " - Unsync: " + i++);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(getName() + " - Unsync ending(Thread)");
    }
}

class SyncDisplayThread extends Thread {
    public SyncDisplayThread(String name) {
        this.setName(name);
    }

    synchronized public void run() {
        System.out.println(getName() + " --SERIAL-MONITOR--");

        for (int i = 0; i <= 5; i++) {
            System.out.println(getName() + " - Sync: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(getName() + " - Sync ending(Thread)");
    }
}

class PrintThread extends Thread {
    public PrintThread(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println(getName() + " --SQUARE-SERIES--");

        int count = 0;
        for (int i = 0; i <= 5; i++) {
            count += i * i;
            System.out.println(getName() + " - Unsync: " + (i * i));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Sum of square series: " + count);
        System.out.println(getName() + " - Unsync ending(Thread)");
    }
}

class SyncPrintThread extends Thread {
    public SyncPrintThread(String name) {
        this.setName(name);
    }

    synchronized public void run() {
        System.out.println(getName() + " - Sync start(Thread)");

        for (int i = 0; i <= 5; i++) {
            System.out.println("Waiting time is more:");
            System.out.println(getName() + " - Sync: " + i++);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(getName() + " - Sync ending(Thread)");
    }
}

public class MultiThreadingExample {
    public static void main(String[] args) {
        DisplayThread t1 = new DisplayThread("DisplayThread");
        SyncDisplayThread t2 = new SyncDisplayThread("SyncDisplayThread");
        PrintThread t3 = new PrintThread("PrintThread");
        SyncPrintThread t4 = new SyncPrintThread("SyncPrintThread");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.NORM_PRIORITY);

        System.out.println("\nThread Priorities:");
        System.out.println(t1.getName() + " Priority: " + t1.getPriority());
        System.out.println(t2.getName() + " Priority: " + t2.getPriority());
        System.out.println(t3.getName() + " Priority: " + t3.getPriority());
        System.out.println(t4.getName() + " Priority: " + t4.getPriority());

        System.out.println("\nThreads Started:");
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

        System.out.println("\nAll Threads Finished!");
    }
}

