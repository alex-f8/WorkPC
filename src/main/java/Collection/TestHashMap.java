package Collection;

import java.util.Map;
import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(5, "String 1");
        hm.put(3, "String 2");
        hm.put(3, "String 2");// not add
        hm.put(1, "String 3");
        print(hm);

    }

    public static void print(HashMap<Integer, String> hashMap){
        for(Map.Entry<Integer, String> item : hashMap.entrySet()){
            System.out.println(item.getKey() + " " +item.getValue());
        }
    }
}
