package shoryabinary;
//find the middle element
//if target element >middle element = search in the right
//else if middle element == target element = answer
//else target element is in the left
//total number of comparisions in the worst case == k=log N (N is the size of the array )
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={-18,-12,-10,-5,5,6,8,14,57};
        int target=-10;
        int ans=binarysearch(arr,target);
        System.out.println(ans);

    }
    static int binarysearch(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            } else if (target>arr[mid]) {
                start=mid+1;
            }else {
                return mid;
            }

        }
        return -1;
    }
}



