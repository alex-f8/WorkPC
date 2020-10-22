package TestThreats;

public class TestMnogoPotok2 {
    public static void main(String[] args){
/*

        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getState());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println();
*/
        //new Potoks("Potok",1).start();
        Thread[] name = new Thread[6];
        for(int i = 1; i < 6; i++) {
            name[i] = new Thread(new TestPotok(), String.valueOf(i));
            name[i].start();
            if(i == 5) name[i].setPriority(1);
            if(i == 1) name[i].setPriority(10);
            if(i == 2){
                try{
                    name[i].join();
                }
                catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
}

/*

class Potoks extends Thread{
    private int id = 0;
    Potoks(String name, int id){
        super(name);
        this.id = id;
    }
    public void run(){
        System.out.printf("Threads name: %s\n", Thread.currentThread().getName());
        System.out.printf("Thread priority: %d\n", Thread.currentThread().getPriority());
        System.out.printf("Thread id: %d\n", Thread.currentThread().getId());
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Finish thread #: " + this.id);
    }
}
*/

class TestPotok implements Runnable{
    public void run(){
        try{
            Thread.sleep(4000);
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        for(int i = 0; i < 10; i++)
            System.out.println(Thread.currentThread().getName());
    }
}
