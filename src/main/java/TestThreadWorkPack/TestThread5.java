package TestThreadWorkPack;

/*
Reentrantlock and Condition
from lybrary
java.util.concurrent.locks
    java.util.concurrent.locks.Reentrantlock
    java.util.concurrent.locks.Condition
*/


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread5 {
    public static void main(String[] args) {
        ReentrantLock lo = new ReentrantLock();
        SharedBox sharedBox = new SharedBox(lo);

        new Thread( new UserA(sharedBox), "UserA").start();;
        new Thread( new UserB(sharedBox), "UserB").start();;
    }
}

class SharedBox{
    ReentrantLock locker;
    Condition condition;
    public int x;
    SharedBox(ReentrantLock l){
        locker = l;
        condition = locker.newCondition();
        x = 0;
    }
    public void growUp(){
        locker.lock();
        try {
            while (x > 5) {
                condition.await();
            }
            x++;
            System.out.printf("(+1) total: %d\n", x);
            condition.signalAll();
            locker.unlock();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally {
        }
    }

    public void growDown(){
        locker.lock();
        try {
            while (x < 1) {
                condition.await();
            }
            x--;
            condition.signalAll();
            System.out.printf("\t(-1) total: %d\n", x);
            locker.unlock();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
        }
    }
}

class UserA implements Runnable{
    SharedBox sharedBox;
    UserA(SharedBox sharedBox){
        this.sharedBox = sharedBox;
    }
    public void run(){
        for(int i = 0; i <8; i++){
            sharedBox.growDown();
            try{
                Thread.sleep(800);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
class UserB implements Runnable {
    SharedBox sharedBox;
    UserB(SharedBox sharedBox){
        this.sharedBox = sharedBox;
    }
    public void run(){
        for(int i = 0; i <8; i++){
            sharedBox.growUp();
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
