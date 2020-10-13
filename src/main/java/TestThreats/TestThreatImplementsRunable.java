package TestThreats;

public class TestThreatImplementsRunable {
    public static void main(String[] args) {
        Thread potok = new Thread(new PotokNew(1), "Ppotok");
        potok.start();
        System.out.println(0);
    }
}


class PotokNew implements Runnable{
    private boolean stop = false;
    private int id;
    PotokNew(int id){
/*
        super(name);
*/
        this.id = id;
    }
    public void run(){
        /*while(!stop){
            System.out.println(id);
        }*/
        for(int i = 1; i <= 3; i++)
            System.out.println(id);
    }
    public void setStop(){
        this.stop = true;
    }
}