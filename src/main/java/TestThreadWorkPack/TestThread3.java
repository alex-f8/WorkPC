package TestThreadWorkPack;

public class TestThread3 {
    public static void main(String ...args){
        Market market = new Market();
        new Thread(new Client(market),"Client").start();
        new Thread(new Maker(market),"Market").start();


        System.out.println("<End of Main Thread />");
    }
}

class Market{
    int tovar = 0;
    public synchronized void dobavit(){
        if(tovar >= 3){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        tovar++;
        System.out.printf("added (+1), total %d\n", tovar);
        notify();
    }
    public synchronized void kupit(){
        if(tovar < 1){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        tovar--;
        System.out.printf("\tsold (-1): total %d\n", tovar);
        notify();
    }
}

class Client implements Runnable{
    Market  market;
    Client(Market market){
        this.market = market;
    }
    public void run(){
        for(int i = 0; i < 5; i++){
            market.kupit();
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}
        }
    }
}

class Maker implements Runnable{
    Market market;
    Maker(Market market){
        this.market = market;
    }
    public void run(){
        for(int i = 0; i < 5; i++){
            market.dobavit();
            try{
                Thread.sleep(400);
            }catch(InterruptedException e){}
        }
    }
}