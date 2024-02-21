package shoryaDsaRecursion;

import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,9,6,3};
        System.out.println(findNum(arr,3,0));
        System.out.println(findNumIndex(arr,3,0));
/*
        findAllNumIndex(arr,3,0);
        System.out.println(list);
*/
        System.out.println(findAllNumIndexes(arr,3,0,new ArrayList<>()));
    }
    static boolean findNum(int[] arr,int num,int index){
        if (index== arr.length){
            return false;
        }
        return arr[index]==num || findNum(arr,num,index+1);
    }
    static int findNumIndex(int[] arr,int num,int index){
        if (index== arr.length){
            return -1;
        }
        if (arr[index]==num){
                return index;
        }else {
            return findNumIndex(arr,num,index+1);
        }
    }
    static ArrayList<Integer> list=new ArrayList<>();
    static void findAllNumIndex(int[] arr,int num,int index){
        if (index  == arr.length){
            return ;
        }
        if (arr[index]==num){
            list.add(index);
        }findAllNumIndex(arr,num,index+1);
    }
    static ArrayList<Integer> findAllNumIndexes(int[] arr, int num, int index, ArrayList<Integer> l){
        if (index  == arr.length){
            return l ;
        }
        if (arr[index]==num){
            l.add(index);
        }
        return findAllNumIndexes(arr,num,index+1,l);
    }
    static ArrayList<Integer> findAllNumIndexes2(int[] arr, int num, int index){
        ArrayList<Integer> l=new ArrayList<>();
        if (index  == arr.length){
            return l ;
        }
//        this will contain the answer for that function call only
        if (arr[index]==num){
            l.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = findAllNumIndexes2(arr,num,index+1);
        l.addAll(ansFromBelowCalls);
        return l;
    }
}
