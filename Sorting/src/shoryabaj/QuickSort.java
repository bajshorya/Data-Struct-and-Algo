package shoryabaj;

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
}