package Collection;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

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





        // -- read from file country codes and output to display
        TreeMap<String, String> countryCode = new TreeMap<String, String>();
        String path1 = "C:\\LAB\\java_code\\PROJECTS\\workPC\\src\\main\\resources\\";
        String path2 = "C:\\PROJECT_FOLDER\\labs\\Study\\src\\main\\resources\\";
        String filename = "countrycode.txt";
        String tmp = null;
        String[] tmpArr = null;
        try {
            FileReader fileReader = new FileReader(path1 + filename);
            Scanner scanner = new Scanner(fileReader);
            while(scanner.hasNextLine()){
                tmpArr = scanner.nextLine().split("\t");
                countryCode.put(tmpArr[0], tmpArr[1]);
            }
            fileReader.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        print2(countryCode);




        //find values by key
        if(countryCode.containsKey("Georgia"))
            System.out.println(countryCode.get("Georgia"));
        //find key by values
        for(Map.Entry<String, String> item : countryCode.entrySet()){
            if(item.getValue().equals("7"))
                System.out.println(item.getKey());
        }
        System.out.println(countryCode.size());

        // ! ! !
        System.out.println(countryCode);
        System.out.println(countryCode.keySet());

        System.out.println("-------------------------------");



        TreeSet<String> mapKeys = new TreeSet<String>(countryCode.keySet());
        for(String item : mapKeys)
            System.out.printf("%s; ", item);
        System.out.println("\n-------------------------------");
        ArrayList<String> mapKeysAL = new ArrayList<String> (countryCode.keySet());
        for(String item : mapKeysAL)
            System.out.printf("%s; ", item);
        System.out.println("\n-------------------------------");
        TreeSet<String> mapKeys1 = new TreeSet<String>(countryCode.values());
        for(String item : mapKeys1)
            System.out.printf("%s; ", item);
        System.out.println("\n-------------------------------");
        ArrayList<String> mapKeysAL1 = new ArrayList<String>(countryCode.values());
        for(String item : mapKeysAL1)
            System.out.printf("%s; ", item);


        countryCode.clear();
        if(countryCode.isEmpty())
            System.out.println("is empty");
        else
            System.out.println("not empty");

    }

    public static void print(TreeMap<String, Integer> treeMap){
        for(Map.Entry<String, Integer> item : treeMap.entrySet())
            System.out.printf("%s (%d) => hash code: %d;\t\t", item.getKey(), item.getValue(), item.hashCode());
        System.out.println();
    }

    public static void print2(TreeMap<String, String> treeMap){
        for(Map.Entry<String, String> item : treeMap.entrySet())
            System.out.printf("%s (%s)\n", item.getKey().replace("_", " "),
                    item.getValue().replace("_", " "));
        System.out.println();
    }
}
