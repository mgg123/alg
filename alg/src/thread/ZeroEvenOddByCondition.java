package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOddByCondition {

    private int n;
    private volatile int thread = 0;
    private ReentrantLock lock = new ReentrantLock();
    Condition zero = lock.newCondition();
    Condition even = lock.newCondition();
    Condition odd = lock.newCondition();
    public ZeroEvenOddByCondition(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i++) {
                if(thread != 0) {
                    zero.await();
                }
                printNumber.accept(0);
                if (i % 2 == 1) {
                    thread = 1;
                    odd.signalAll();
                } else {
                    thread = 2;
                    even.signalAll();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 2; i <= n; i += 2) {
                if(thread != 2) {
                    even.await();
                }
                printNumber.accept(i);
                thread = 0;
                zero.signalAll();
            }
        } finally {
            lock.unlock();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= n; i += 2) {
                if(thread != 1) {
                    odd.await();
                }
                printNumber.accept(i);
                thread = 0;
                zero.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOddByCondition zeroEvenOdd = new ZeroEvenOddByCondition(6);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
