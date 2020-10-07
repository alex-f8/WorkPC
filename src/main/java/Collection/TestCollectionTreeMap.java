package Collection;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class TestCollectionTreeMap {
    public static void main(String ...args){
        TreeMap<String, Integer> cCode = new TreeMap<String, Integer>();
        cCode.put("USA", 1);
        cCode.put("Germany", 49);
        cCode.put("Russia", 7);
        cCode.put("Georgia", 995);
        cCode.put("Ukraine", 380);
        cCode.put("France", 33);
        print(cCode);
        if(!cCode.containsKey("Austira"))
            cCode.put("Australia", 43);
        print(cCode);

        if(!cCode.containsKey("Spain"))
            cCode.put("Spain", 34);
        print(cCode);

        TreeMap<String, String> countryCode = new TreeMap<String, String>();
        String path1 = "C:\\LAB\\java_code\\PROJECTS\\workPC\\src\\main\\resources\\";
        String path2 = "C:\\PROJECT_FOLDER\\labs\\Study\\src\\main\\resources\\";
        String filename = "countrycode.txt";
        String tmp = null;
        String[] tmpArr = null;
        try {
            FileReader fileReader = new FileReader(path2 + filename);
            Scanner scanner = new Scanner(fileReader);
            while(scanner.hasNextLine()){
                tmpArr = scanner.nextLine().split("\t");
                countryCode.put(tmpArr[0], tmpArr[1]);
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        print2(countryCode);
    }

    public static void print(TreeMap<String, Integer> treeMap){
        for(Map.Entry<String, Integer> item : treeMap.entrySet())
            System.out.printf("%s (%d);  ", item.getKey(), item.getValue());
        System.out.println();
    }

    public static void print2(TreeMap<String, String> treeMap){
        for(Map.Entry<String, String> item : treeMap.entrySet())
            System.out.printf("%s (%s)\n", item.getKey().replace("_", " "),
                    item.getValue().replace("_", " "));
        System.out.println();
    }
}
