package TestThreadWorkPack;

/*
    interrupt(); isInterrupted(); slee() InterruptException resets interrupt from true to false
    syncronized()
*/



public class TestThread2 {
    public static void main(String[] args) {

        //1st Task
/*
        Flow1 flow1 = new Flow1(String.valueOf(1));
        flow1.start();
        Flow1 flow2 = new Flow1(String.valueOf(2));
        flow2.start();
        try{
            Thread.sleep(5000);
            flow1.interrupt();
            flow1.join();
            flow2.interrupt();
            flow2.join();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("----------------------");
*/

        // 2nd Task
/*
        Flow2[] flow2s = new Flow2[3];
        for(int i = 0; i <3; i++){
            flow2s[i] = new Flow2(String.valueOf( i + 10 ), counter);
            flow2s[i].start();
        }
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        try {
            for (int i = 0; i < 3; i++) {
                flow2s[i].interrupt();
                flow2s[i].join();
            }
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n----------------------");
*/
        //3rd Task : with out synchronizied
        // Добавляет к общедоступному объекту по 1, без синхроницации
        Counter counter3 = new Counter();
        for(int i = 1; i <=4; i++){
            Thread t = new Thread(new Flow3(counter3), String.valueOf(i + 10));
            t.start();
        }


        //4rd Task : with synchronizied
        // Добавляет к общедоступному объекту по 1, с синхроницацией взятые в квадратные скобки []
        //так же выводит набор букв без синхронизачии: a, b, c, d
        // а потом с синхронизацией: A, B, C, D
        Counter counter4 = new Counter();
        for(int i = 1; i <=4; i++){
            Thread t = new Thread(new Flow4(counter4), String.valueOf(i + 20));
            t.start();
        }

        //System.out.println("\nEnd of main Thread");
    }
}





/*

    Threads

*/


class Flow1 extends Thread{
    Flow1(String name){
        super(name);
    }
    public void run(){
        while(!isInterrupted()){
            System.out.printf("%s ", Thread.currentThread().getName());
            try{
                sleep(500);
            }
            catch(InterruptedException e){
                System.out.printf("\nExit from Flow %s -> %s", Thread.currentThread().getName(),
                        e.getMessage());
                interrupt();
            }
        }
    }
}

class Flow2 extends Thread{
    Counter counter;
    Flow2(String name, Counter c){
        super(name);
        counter = c;
    }
    public void run(){
        while(!isInterrupted()){
            synchronized (counter) {
                counter.i++;
            }
            try {
                sleep(500);
                System.out.printf("%d ", counter.i);
            } catch (InterruptedException e) {
                System.out.printf("\nExit from Flow %s -> %s\n", Thread.currentThread().getName(),
                        e.getMessage());
                interrupt();
            }
        }
    }
}

class Flow3 implements Runnable{
    Counter con;
    Flow3(Counter c){
        con = c;
    }
    public void run(){
        con.i = 1;
        for(int j = 1; j <= 5; j++) {
            System.out.printf("%d ", con.i);
            con.i++;
            try{
                Thread.currentThread().sleep(500);
            }catch(InterruptedException e){}
        }
        System.out.println("<finish:" + Thread.currentThread().getName()+">");
    }
}


class Flow4 implements Runnable{
    Counter con;
    Flow4(Counter c){
        con = c;
    }
    public void run(){
        synchronized(con){
            con.i = 1;
            for(int j = 1; j <= 5; j++) {
                System.out.printf("[%d] ", con.i );
                con.i++;
                try{
                    Thread.currentThread().sleep(500);
                }catch(InterruptedException e){}
            }
        }
        try{Thread.sleep(2000);}catch(InterruptedException e){}
        notSync();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        sync();
    }
    public void notSync(){
        for(int i = 0; i < 5; i++){
            System.out.printf("%s ", (char)(Integer.valueOf(Thread.currentThread().getName()) + 76));
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){}
        }
    }
    public synchronized void sync(){
        for(int i = 0; i < 5; i++){
            System.out.printf("%s ", (char)(Integer.valueOf(Thread.currentThread().getName()) + 44));
        }
    }
}

class Counter{
    int i;
    Counter(){
        i = 0;
    }
}