
public class searchInsertPosition {
    public static void main(String[] args) {
        int[] arr={1,3,5,6};
        int target=2;
        int ans=searchInsert(arr,target);
        System.out.println(ans);
    }
    static int searchInsert(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else {
                return mid;
            }
        }return start;
    }
}