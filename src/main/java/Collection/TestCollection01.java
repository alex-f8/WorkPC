package Collection;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeSet;

public class TestCollection01 {
    public static void main(String[] args) {
        ArrayList<String> euroList = new ArrayList<String>(20);//defaul 10
        System.out.println("\nsize of the list " + euroList.size());
        euroList.add("Germany");
        euroList.add("Britan");
        euroList.add("Spain");
        euroList.add("France");
        euroList.add("Portugal");
        euroList.add("Italy");
        displayList(euroList);
        System.out.println("size of the list " + euroList.size());
        euroList.add(2, "Norvay");
        displayList(euroList);
        System.out.println("size of the list" + euroList.size());
        euroList.set(6, "Belgium");
        displayList(euroList);
        System.out.println("first index of Italy -> " + euroList.indexOf("France"));
        System.out.println("last index of Italy -> " + euroList.lastIndexOf("France"));

        ArrayList<String> asiaList = new ArrayList<>();
        asiaList.add("China");
        asiaList.add("Japan");
        asiaList.add("South Korea");
        asiaList.add("India");
        displayList(asiaList);
        asiaList.add("Mongolia");

        ArrayList<String> worldList = new ArrayList<String>();
        System.out.println("\nWorld List Collection");
        worldList.addAll(euroList);
        displayList(worldList);
        worldList.addAll(3, asiaList);
        displayList(worldList);

        int i = worldList.indexOf("Spain");
        String str = worldList.get(i);
        System.out.println(str);

        worldList.addAll(euroList);
        displayList(worldList);
        int i_first = worldList.indexOf("Norvay");
        int i_last = worldList.lastIndexOf("Norvay");
        System.out.printf("Country %s first position: %d, last position: %d", worldList.get(i_first), i_first, i_last);
        System.out.println("\n Sort and make unique list");

        System.out.println("\n\nbefore using privestiPoryadok function");
        displayList(worldList);
        worldList = privestiPoryadok(worldList);
        System.out.println("\n\nafter use privestiPoryadok function");
        displayList(worldList);

        /*Collections.sort(worldList);
        displayList(worldList);*/

        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("Spain");
        treeSet.add("Russia");
        treeSet.add("Germany");
        treeSet.add("Austria");
        treeSet.add("Belgium");
        treeSet.add("France");
        treeSet.add("France");
        for(String k : treeSet)
            System.out.printf("%s ", k);
        System.out.println();

    }
    public static void displayList(ArrayList<String> arrayList){
        System.out.println();
        int i = 0;
        for( String a : arrayList)
            System.out.println((i++)+ " " +a);
    }

    public static ArrayList<String> privestiPoryadok(ArrayList<String> arrayList){
        /*
            if indexOf and lastIndexOf are equals, than they look at the same object,
            else list contains two or more separate equals objects, and one of them (last) must be removed.
            After removing cicle must go one step back (--i) and run chekc this object again for dublicates
        */
        //remove dublicates
        String strTmp;
        for(int i = 0; i < arrayList.size(); i++){
            strTmp = arrayList.get(i);
            if( arrayList.indexOf(strTmp) != arrayList.lastIndexOf(strTmp)) {
                arrayList.remove(arrayList.lastIndexOf(strTmp));
                --i;
            }
        }
        strTmp = null;
       //sort
       //Variant No1
        for(int i = 0; i < arrayList.size()-1; i++){
            if( arrayList.get(i).charAt(0) > arrayList.get(i+1).charAt(0) ) {
                strTmp = arrayList.get(i + 1);
                arrayList.set( i+1, arrayList.get(i));
                arrayList.set(i, strTmp);
                i = 0;// ! tolko tak, chtobi cikl ne dopustil oshibki
            }
        }
        return arrayList;
    }




}
