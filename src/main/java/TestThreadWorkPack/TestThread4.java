package TestThreadWorkPack;

import java.util.concurrent.locks.ReentrantLock;

public class TestThread4 {
    public static void main(String[] args) {
        boolean cicle = true;
        ReentrantLock locker = new ReentrantLock();
        ReentrantLock locker1 = new ReentrantLock();
        MyTread myTread = new MyTread("MyThread", locker);
        myTread.start();

        while(cicle){
            switch (myTread.getState()){
                case RUNNABLE:
                    System.out.printf("MyThread : RUNNABLE\n");
                    break;
                case WAITING:
                    System.out.println("MyThread : WAITING\n");
                    //notify();
                    break;
                case BLOCKED:
                    System.out.println("MyThread : BLOCKED\n");
                    break;
                case TERMINATED:
                    System.out.println("MyThread : TERMINATED\n");
                    cicle = false;
                    break;
            }
        }

        System.out.println("\n---------------NEW_LINE--------------");
        // ReentrantLock
        //lock()
        //unlock()
        new Thread(new FlowControl(locker), "A").start();
        new Thread(new FlowControl(locker), "B").start();
        new Thread(new FlowControl(locker), "C").start();
    }
}


class MyTread extends Thread{
    ReentrantLock lock;
    MyTread(String name, ReentrantLock locker){
        super(name);
        lock = locker;
    }
    public synchronized void run(){
        for(int i = 0; i<1_00; i++){
            System.out.printf("%s ", "a");
            if( i % 50 == 0)
                System.out.println();
        }

        try{
            sleep(100);
        }catch (InterruptedException e){}
/*
        try{
            wait();
        }catch (InterruptedException e){}
*/
        lock.lock();
        for(int i = 0; i <100; i++) {
            System.out.print("A ");
        }
        lock.unlock();

    }
}


// ReentrantLock
//lock()
//unlock()
class FlowControl implements Runnable{
    ReentrantLock locker;
    FlowControl(ReentrantLock l){
        locker = l;
    }
    public void run(){
        locker.lock();
        for(int i = 1; i <= 50; i++){
            System.out.printf("%s ", Thread.currentThread().getName());
            if(i%20 == 0)
                System.out.println();
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}
        }
        System.out.println("\nEnd of FlowControl: " + Thread.currentThread().getName());
        locker.unlock();
    }
}