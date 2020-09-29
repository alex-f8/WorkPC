package Studing02_Наследование;

public class TestNasl2 {
    public static void main(String[] args) {
        test03 tst = new test03("Text");
        System.out.println(tst.str1 + tst.str2 + tst.str3);

        Object obj  = new test03("bla bla bla ");
        //obj.display(); // error
        System.out.println(obj.toString());
        System.out.println(obj.hashCode());
        test03 tst03 = (test03) obj;
        tst03.display();
        System.out.println(obj.toString());
        System.out.println(obj.hashCode());

    }
}

class test01{
    String str1 = "text 1\t";
    test01(String str){
        str1 = str;
        System.out.println(str1 + " 1 \t");
    }
}

class test02 extends test01{
    String str2 = "text 2\t";
    test02(String str){
        super(str);
        str2 = str;
        System.out.println(str2+ " 2 \t");
    }
}

class test03 extends test02{
    String str3 = "text 3\t";
    test03(String str){
        super(str);
        str3 = str;
        System.out.println(str3+ " 3 \t");
    }
    public void display(){
        System.out.println("method display()");
    }

    public String toString(){
        return super.toString() + " " + str3;
        }
}