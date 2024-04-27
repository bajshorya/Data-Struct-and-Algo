

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[]arr={4,3,5,1,2};
        quickSort(arr,0, arr.length-1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    static void quickSort(int[] arr,int low,int high){
        if (low<high){
            int pivotIndex=partition(arr,low,high);
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot=arr[high];
        int i =low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=pivot;
        arr[high]=temp;
        return i;
    }
    static void sort(int[] nums, int low, int hi){
        if (low>=hi) {
            return;
        }
        int s=low;
        int e=hi;
        int m=s+(e-s)/2;
        int pivot=nums[m];

        while (s<=e) {
            //also a reason why if its already sorted it will not swap 
           while (nums[s]<pivot) {
            s++;
           }    
           while (nums[e]>pivot) {
            e--;
           }    
           if (s<=e) {
            int temp =nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
           }
           //now pivot is at correct index , please sort tow halves now
           sort(nums,low,e);
           sort(nums,s,hi);
        }
    }
}