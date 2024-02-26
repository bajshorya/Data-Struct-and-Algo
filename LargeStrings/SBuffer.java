package LargeStrings;

public class SBuffer {
    public static void main(String[] args) {
        //constructor 1
        StringBuffer sb=new StringBuffer();

        //constructor 2
        StringBuffer sb2=new StringBuffer("Shorya Baj");

        //Constructor 3
        StringBuffer sb3=new  StringBuffer(30);

        sb.append("WeMakeDevs");
        sb.append(" is great!");
        sb.insert(2, " Shorya ");
        String str=sb.toString();
        System.out.println(str);
    }
}

//String Buffer Advantages:-
//mutable
//Efficient
//Thread Safe-slower
//String Builder is not thread safe
