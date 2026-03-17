package bai3;

public class TestThread {
    public static void main(String[] args) {
        WorkerThread thread = new WorkerThread();
        thread.start();

        WorkerRunnable runnable = new WorkerRunnable();
        Thread t = new Thread(runnable);
        t.start();
    }
}