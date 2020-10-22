package TestThreats;

import java.util.concurrent.TimeUnit;

public class TestMnogoPotok1 {
    public static void main(String[] args) {
        System.out.println("Start " + Thread.currentThread().getName());
/*        Thread thread1 = new Thread(new Potok1(), "Potok1");
        Thread thread2 = new Thread(new Potok1(), "Potok2");
        thread1.start();
        thread2.start();
        //thread1.setPriority(10);
        try {
            thread1.join();
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }*/
        System.out.println("\nEnd " + Thread.currentThread().getName());


        //================
        PotokStopTest potokStopTest1 = new PotokStopTest("TestPotok1");
        potokStopTest1.start();
        PotokStopTest potokStopTest2 = new PotokStopTest("TestPotok2");
        potokStopTest2.start();
        potokStopTest2.setStop();
        potokStopTest1.setStop();
    }
}

class Potok1 implements Runnable{
    @Override
    public void run() {
            System.out.printf("%d   ", Thread.currentThread().getId());
            try{
                TimeUnit.SECONDS.sleep(1);
                // or
                Thread.sleep(1000);// 1000 millisecond = 1 second
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        System.out.print("\nEnd " + Thread.currentThread().getName());
    }
}


class PotokStopTest extends Thread{
    private boolean stopThread = false;
    PotokStopTest(String name){
        super(name);
    }
    public void run(){
        while(!stopThread){
            System.out.printf("%d ", Thread.currentThread().getId());
        }
    }
    public void setStop(){
        this.stopThread = true;
    }
}
