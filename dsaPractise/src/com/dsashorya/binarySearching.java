package com.dsashorya;

public class binarySearching {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,11,15};
        int ans=search(arr,7);
        int ansTwo=searchRecursion(arr,11,0, arr.length);
        int ansThree=linearSearch(arr,15);
        System.out.println(ans);
        System.out.println(ansTwo);
        System.out.println(ansThree);
    }
    static int search(int[] arr,int target){
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
    static int searchRecursion(int[]arr,int target,int start,int end){
        if(start>end){
            return -1;
        }
        int middle=start+(end-start)/2;
        if(arr[middle]==target){
            return middle;
        }
        if (target<arr[middle]){
            return searchRecursion(arr, target, start, middle-1);
        }
        else {
            return searchRecursion(arr, target, middle+1, end);
        }
    }
    static int linearSearch(int[] arr,int target){
        if (arr.length==0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
