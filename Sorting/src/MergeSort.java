

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={5,2,3,4,1};
        arr=mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2={7,6,8,10,9};
        mergeSortInPlace(arr2,0,arr2.length);
        System.out.println(Arrays.toString(arr2));
    }
    static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid= arr.length/2;
        int[] left=mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix=new int[first.length+ second.length];
        int i=0;
        int j=0;
        int k=0;
        while (i< first.length && j< second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i< first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while (j< second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int mid = (s + e) / 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }

}
// MergeSort(A)
//      n=length(A)
//      if (n<2) return 
//      mid=n/2
//      L=A[0...mid-1]
//      R=A[mid....n-1]
//      for   0<= l <=mid-1
//          L[l]=A[l]
//      for  mid<= r <=n-1
//          R[r-mid]=A[r]
//      MergeSort(L) 
//      MergeSort(R) 
//      Merge(L,R,A)