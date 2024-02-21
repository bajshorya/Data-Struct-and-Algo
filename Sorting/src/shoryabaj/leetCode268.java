package shoryabaj;
//https://leetcode.com/problems/missing-number/
//amazon quest
class leetCode268 {
    public static void main(String[] args) {
        int[] arr={1,2,0,4};
        System.out.println(missingNumber(arr));
    }
    public  static int missingNumber(int[] arr){
        int i=0;
        while (i< arr.length){
            //int correct=arr[i]-1;
            if (arr[i]<arr.length && arr[i]!=arr[arr[i]]){
                swap(arr,i,arr[i]);
            }else{
                i++;
            }
        }
        //search for the missing number and return it
        for (int index = 0; index < arr.length; index++) {
            if(arr[index]!=index){
                return index;
            }
        }
        //case 2
        return arr.length;
    }
    static  void swap(int[] arr, int first, int second) {
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
