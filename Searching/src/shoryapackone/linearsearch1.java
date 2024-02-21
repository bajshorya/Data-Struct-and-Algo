package shoryapackone;

public class linearsearch1 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,44,22,};
        int target = 5;
        int ans =linearsearch(nums,target);
        int minimum=min(nums);
        System.out.println(minimum);
        System.out.println(ans);
    }
    static int linearsearch(int[] arr,int target){
        if (arr.length==0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            int element=arr[i];
            if(element == target){
                return i;
            }
        }
        return -1;
    }
    static int min(int[] arr){
        int ans =arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<ans){
                ans=arr[i];
            }
        }
        return ans;
    }
}