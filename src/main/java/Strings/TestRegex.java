package Strings;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestRegex {
    public static void main(String[] args) {
        String str = "Java is not JavaScript. JavaSE8 is programming language," +
                "and JavaScript script language";
        String file = "myFile.exe";
        Pattern comp = Pattern.compile("Java(\\w*)");
        Matcher match = comp.matcher(str);
        while(match.find())
            System.out.println(match.group());

        StringBuffer str2 = new StringBuffer();
        str2.append("Hello world");
        //test start(), end() and other
        Pattern pattern = Pattern.compile()
    }
}
