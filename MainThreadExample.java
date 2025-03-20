class MyThread extends Thread {

    public void display() {
        System.out.println(Thread.currentThread().getName() + " - Unsynchronized method STARTING (Thread Class)");
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Unsynchronized: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Unsynchronized method ENDING (Thread Class)");
    }

    // Synchronized method
    synchronized public void syncDisplay() {
        System.out.println(Thread.currentThread().getName() + " - Synchronized method STARTING (Thread Class)");
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Synchronized: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Synchronized method ENDING (Thread Class)");
    }

    public void run() {
        display();
        syncDisplay();
    }
}

// Class that implements Runnable
class MyRunnable implements Runnable {

    // Unsynchronized method
    public void print() {
        System.out.println(Thread.currentThread().getName() + " - Unsynchronized method STARTING (Runnable Class)");
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Unsynchronized: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Unsynchronized method ENDING (Runnable Class)");
    }

    // Synchronized method
    synchronized public void syncPrint() {
        System.out.println(Thread.currentThread().getName() + " - Synchronized method STARTING (Runnable Class)");
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Synchronized: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Synchronized method ENDING (Runnable Class)");
    }

    public void run() {
        print();
        syncPrint();
    }
}

// Main class with the main method
public class MainThreadExample {
    public static void main(String[] args) {

        // Using the class that extends Thread
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // Using the class that implements Runnable
        MyRunnable myRunnable = new MyRunnable();
        Thread t3 = new Thread(myRunnable);
        Thread t4 = new Thread(myRunnable);

        System.out.println("\n--- Starting Threads ---\n");

        // Start all the threads
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

        System.out.println("\n--- All Threads Finished ---");
    }
}
