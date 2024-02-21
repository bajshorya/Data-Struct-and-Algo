package com.dsashorya;

import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int[] arrOne={1,2,4,3,5};
        int[] arrTwo={5,4,3,2,1};
        int[] arrThree={6,8,7,9};
        int[] arrFour={6,8,7,9};
        int[] arrFive={20,14,6,55,24,87,96,102};
        int[] arrSix={20,14,6,55,24,87,96,102};

        QuickSort(arrSix,0,arrSix.length-1);
        mergeSort(arrFive,0,arrFive.length-1);
        selection(arrOne);
        bubble(arrTwo);
        insertionSort(arrThree);
        linearSort(arrFour);
        int[]arr=mergeSortedArrays(arrTwo,arrThree);

        System.out.println(Arrays.toString(arrSix));
        System.out.println(Arrays.toString(arrOne));
        System.out.println(Arrays.toString(arrTwo));
        System.out.println(Arrays.toString(arrThree));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrFour));
        System.out.println(Arrays.toString(arrFive));
    }
    static void mergeSort(int[] arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }

    static void conquer(int[] arr,int si,int mid,int ei) {
        int[] merged =new int [ei-si+1];

        int idx1=si;
        int idx2=mid+1;
        int x=0;

        while(idx1<=mid && idx2<=ei){
            if (arr[idx1]<=arr[idx2]){
                merged[x++]=arr[idx1++];
            }else{
                merged[x++]=arr[idx2++];
            }
        }
        while (idx1<=mid ){
            merged[x++]=arr[idx1++];
        }
        while (idx2<=ei){
            merged[x++]=arr[idx2++];
        }
        for (int i = 0,j=si; i <merged.length ; i++,j++) {
            arr[j]=merged[i];
        }
    }

    static void QuickSort(int[] arr,int low ,int high){
        if (low<high){
            int pivot=partition(arr,low,high);

            QuickSort(arr,low,pivot-1);
            QuickSort(arr,pivot,high);
        }

    }

    static int partition(int[] arr, int low, int high) {
        int pivot=arr[high];
        int i = low-1;

        for (int j = low; j < high; j++) {
             if (arr[j]<pivot){
                 i++;
                 swap(arr,i,j);
             }
        }
        i++;
        swap(arr,i,high);
        return i;
    }

    static void linearSort (int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n ; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr,i,j);
                }
            }
        }
    }
    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] mergedArray = new int[len1 + len2];

        int i = 0, j = 0, k = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        while (i < len1) {
            mergedArray[k++] = arr1[i++];
        }
        while (j < len2) {
            mergedArray[k++] = arr2[j++];
        }
        return mergedArray;
    }
    static void insertionSort(int[] arr){
        //shifting the element after comparing with all previous elements.
        int j,i;
        for (i = 1; i < arr.length; i++) {
            int n=arr[i];
            for (j = i-1; j >=0 && arr[j]>n ; j--) {
                arr[j+1]=arr[j];
            }
            arr[j+1]=n;
        }
    }
    static void bubble(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
//        int n=arr.length;
//        while(!swapped)
//        {
//            swapped = false;
//            for (int j = 1; j < n; j++) {
//                if (arr[j] < arr[j - 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                    swapped = true;
//                }
//            }
//            n--;
//        }
    }
    static void selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last= arr.length-i-1;
            int maxIndex=getMaxIndex(arr,0,last);
            swap(arr,maxIndex,last);
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max=start;
        for (int i = start; i <= end; i++) {
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
}
