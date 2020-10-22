package TestThreats;

public class TestTreatsExtendsThreat {
    public static void main(String[] args) {
        for(int i = 1; i <=3; i++)
            new Potok("Potok" + i, i).start();

            int j = 3;
    while(j > 0){
        System.out.println(0);
        --j;
    }

    }

}

class Potok extends Thread{
    private boolean stop = false;
    private int id;
    Potok(String name, int id){
        super(name);
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