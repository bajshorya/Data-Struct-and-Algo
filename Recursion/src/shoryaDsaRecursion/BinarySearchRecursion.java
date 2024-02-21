package shoryaDsaRecursion;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int ans=bSearch(arr,3,0,arr.length-1);
        System.out.println(ans);
    }
    static int bSearch(int[] arr,int val,int start,int end){
        if(start>end){
            return -1;
        }
        int middle=start+(end-start)/2;
        if(arr[middle]==val){
            return middle;
        }
        if(val<arr[middle]){
            return bSearch(arr,val,start,middle-1);
        }
        return bSearch(arr,val,middle+1,end);
    }
}
