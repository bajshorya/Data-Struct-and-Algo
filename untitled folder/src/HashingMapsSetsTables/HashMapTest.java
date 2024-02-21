package HashingMapsSetsTables;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<String,Integer> m=new HashMap<String,Integer>();
        set.add(1);
        set.add(2);
        if (set.contains(1)){
            System.out.println("Set contains 1");
        }else{
            System.out.println("It does not have 1 !");
        }
        m.put("JECRC",10);
        m.put("ide",15);
        m.put("courses",20);


        System.out.println(m);
        System.out.println(m.size());
        for (Map.Entry<String ,Integer> e : m.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
        if(m.containsKey("ide")){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
        m.remove("ide");

        System.out.println(m);

        if (m.containsValue(15)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
        System.out.println(m.get("JECRC"));
        System.out.println(m.get("bhavesh"));
    }
}
