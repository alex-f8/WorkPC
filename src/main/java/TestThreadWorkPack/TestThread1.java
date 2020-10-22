package TestThreadWorkPack;

//testing
// isInterrupted, interrupt
//join
//priority

public class TestThread1 {
    public static void main(String[] args) {

        System.out.printf("---- %s FLOW STARTED ----", Thread.currentThread().getName());
        
        Thread[] threads = new Thread[3];
        for(int i = 0 ; i < 3; i++){
            threads[i] = new Thread(new Potok(), String.valueOf(i + 1));
            threads[i].start();
        }

        //stops main thread to waiting while threa Potok 1,2,3 something printing
        try {
            Thread.currentThread().sleep(10);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

        for(int i = 0; i <3 ; i++)
            threads[i].interrupt();


        System.out.println(" ------------------------------------------ ");


        // Xoroshay zadacha na prioriteti ! ! !
        Thread potok1 = new Thread(new Potok2(), "1");
        Thread potok2 = new Thread(new Potok2(), "2");
        Thread potok3 = new Thread(new Potok2(), "3");
        potok1.start();
        potok2.start();
        potok3.start();
        potok1.setPriority(1);
        potok3.setPriority(10);
        try {
            potok1.join();
            potok2.join();
            potok3.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        // Xoroshay zadacha na prioriteti ! ! !
        
        
        

        System.out.printf("---- %s FLOW ENDED ----", Thread.currentThread().getName());
    }
}




class Potok3 extends Thread{
    Potok3(String name){
        super(name);
    }
    public void run(){

    }
}


class Potok implements Runnable{
    public void run(){
        System.out.printf("\n<Flow %s: Start>\n", Thread.currentThread().getName());
        while(!Thread.currentThread().isInterrupted()){
/*            try{
                Thread.sleep(1500);
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }*/
            System.out.printf("%s ", Thread.currentThread().getName());
        }
        System.out.printf("\n<Flow %s: End>\n", Thread.currentThread().getName());
    }
}



// Xoroshay zadacha na prioriteti ! ! !
class Potok2 implements Runnable{
    public void run(){
        System.out.printf("\nFlow %s: Start\n", Thread.currentThread().getName());

        for(int i = 1; i <= 100; i++)
            System.out.printf("%s ", Thread.currentThread().getName());

        System.out.printf("\nFlow %s: End\n", Thread.currentThread().getName());
    }
}
