package Strings;

public class TestBuilderBuffer {
    public static void main(String ...args){
        StringBuilder sBuilder = new StringBuilder("New Line");
        StringBuffer sBuffer = new StringBuffer();
        System.out.println(sBuilder);
        System.out.println(sBuffer.capacity());//by default 16 of free
        System.out.println("add string: " + sBuffer.append("abc"));
        System.out.println("capacity: " + sBuffer.capacity());
        sBuffer.ensureCapacity(20);
        System.out.println("new capasity(+20): " + sBuffer.capacity());
        System.out.println("buffer length: " + sBuffer.length());
        sBuffer.setLength(10);
        System.out.println("resize length(+10): " + sBuffer.length( ));
        System.out.println("new length: " + sBuffer.length());
        System.out.println(sBuffer.toString() + "www");
        sBuffer.setLength(2);
        System.out.println("new length(2): " + sBuffer.length() + "=> " + sBuffer);
        sBuffer.setCharAt(1, 'z');
        System.out.println(sBuffer.toString());
        sBuffer.insert(sBuffer.length(), " Hello");
        System.out.println(sBuffer);
        sBuffer.append('\n');
        System.out.println(sBuffer);
        System.out.println(sBuffer.deleteCharAt(1));
        System.out.println(sBuffer.delete(0,2));
        System.out.println(sBuffer.delete(sBuffer.length()-1,sBuffer.length()));
        System.out.println(sBuffer);
        System.out.println(sBuffer.reverse());
        System.out.println(sBuffer);
    }
}
