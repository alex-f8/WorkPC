package Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegexMatcherGroup {
    public static void main(String[] args) {
        String str = "<person userID=\"001\">";
        Pattern patt = Pattern.compile("userID=\"(\\w*)\"");
        Matcher match = patt.matcher(str);
        if(match.find())
            System.out.printf("found: %s", match.group(1));
    }
}
