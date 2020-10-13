package Strings;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestRegex {
    public static void main(String[] args) {
        String str = "Java is not JavaScript. JavaSE8 is programming language," +
                "and JavaScript script language";
        String fileName = "myFileMyName.exe.exe";
        Pattern comp = Pattern.compile("Java(\\w*)");
        Matcher match = comp.matcher(str);
        while(match.find())
            System.out.println(match.group());

        StringBuffer str2 = new StringBuffer();
        str2.append("Hello world!");
        str2.insert(str2.length(), " Hello JavaScript, ");
        str2.insert(str2.length(), " Hello TypeScript.");
        str2.insert(str2.length(), " Hello VBScript!");
        System.out.println(str2.toString());
        //test start(), end() and other
        Pattern pattern = Pattern.compile("(\\w*)Script");
        Matcher matcher = pattern.matcher(str2);
        System.out.println("Is in string any words with Script? (y/n) : " +
                (matcher.matches() ? " YES" : "NO"));
        while(matcher.find())
            System.out.println(matcher.group() + " index(start): " + matcher.start() +
                     " index(end): " + matcher.end());
        System.out.printf("String length: %d\nString capacity(min +16): %d\n", str2.length(), str2.capacity());


        System.out.println(matcher.replaceAll("HTML"));
        System.out.println(str2);
        System.out.println();

        Pattern patternSpliter = Pattern.compile("\\s*(\\s|!|\\.|,)\\s*");
        String[] words = patternSpliter.split(str2.toString());
        for(String item : words)
            System.out.println(item);

    }
}
