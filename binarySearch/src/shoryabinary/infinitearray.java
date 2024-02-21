package shoryabinary;

public class infinitearray {
    public static void main(String[] args) {
        int[] arr={3,5,7,8,9,10,13,
                16,19,25,27,30};
        int target=13;
        System.out.println(ans(arr,target));
    }
    static int ans(int[] arr,int target){
        //find the range first
        //start with a box of size 2
        int start = 0;
        int end = 1;
        //condition for the target to lie in the range
        //if the target element is greater than the end element then it must
        // definitely lie after the next block of elements ,,,so we keep doubling
        // the block till we find that the target is less than the end element of that range
        while (target > arr[end]){
            int temp=end + 1;//taking new start (temp) because we will use the og start again in the upcoming formulae
            //double the box value
            //end=prev end +sizeofbox *2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr,target,start,end);
    }
    static int binarySearch(int[] arr, int target ,int start,int end){

        while(start<=end){
            //int mid=(start+end)/2;
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


//package com.kunal;
//// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//public class InfiniteArray {
//    public static void main(String[] args) {
//        int[] arr = {3, 5, 7, 9, 10, 90,
//                100, 130, 140, 160, 170};
//        int target = 10;
//        System.out.println(ans(arr, target));
//    }
//    static int ans(int[] arr, int target) {
//        // first find the range
//        // first start with a box of size 2
//        int start = 0;
//        int end = 1;
//
//        // condition for the target to lie in the range
//        while (target > arr[end]) {
//            int temp = end + 1; // this is my new start
//            // double the box value
//            // end = previous end + sizeofbox*2
//            end = end + (end - start + 1) * 2;
//            start = temp;
//        }
//        return binarySearch(arr, target, start, end);
//
//    }
//    static int binarySearch(int[] arr, int target, int start, int end) {
//        while(start <= end) {
//            // find the middle element
////            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
//            int mid = start + (end - start) / 2;
//
//            if (target < arr[mid]) {
//                end = mid - 1;
//            } else if (target > arr[mid]) {
//                start = mid + 1;
//            } else {
//                // ans found
//                return mid;
//            }
//        }
//        return -1;
//    }
//}