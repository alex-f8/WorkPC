package Strings;

public class TestString {
    public static void main(String[] args) {
        char[] ch = {'a', 's', 'w', 't', 'k', 'z', 'b', 'v', 'y', 'u', 'q'};
        String str1 = "Hello world";
        String str2 = new String (ch);
        String str3 = new String (ch, 5, 6);
        String str4 = "Java";
        System.out.println(str1 + " " + str2 + " " + str3);
        System.out.println(str1.length());
        char[] chArr = str1.toCharArray();
        for(char c : chArr)
            System.out.println(c);
        System.out.println(str1.isEmpty()?"empty":"full");
        System.out.println(str1.concat(str4));
        System.out.println(str1.join(", ", str1, str4));
        System.out.println(String.join(", ", str1, str4));
        for(String strTmp : str1.split(" "))
            System.out.println(strTmp);
        System.out.println(str1.compareTo("Hello world1")); //-1
        System.out.println(str1.compareToIgnoreCase("Hello WORLD"));//0
        System.out.println(str1.charAt(4));// o
        System.out.println(str1.charAt(4));// o
        char[] chGetChars = new char[5];
        str1.getChars(6, 10, chGetChars, 0);
        System.out.println(chGetChars);
        System.out.println(str1.equals("Hello World"));//false
        System.out.println(str1.equalsIgnoreCase("Hello World"));//true
        System.out.println(str1.regionMatches(6, "world", 0, 5));
        System.out.println(str1.indexOf(" "));
        System.out.println(str1.lastIndexOf("l"));
        System.out.println(str1.startsWith("H"));
        System.out.println(str1.endsWith("d"));
        System.out.println(str1.replace("world", str4));
        String str5 = "    Java programming language     \t\t";
        System.out.println(str5 + str1);
        System.out.println(str5.trim() + str1);
        System.out.println(str1.substring(5, str1.length() ));
        System.out.println(str1.toLowerCase());
        System.out.println(str1.toUpperCase());
        System.out.println(str1.matches("(\\w*)ello(\\w*)(\\s*)(\\w*)"));//true
    }
}
