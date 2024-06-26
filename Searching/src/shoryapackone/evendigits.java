package shoryapackone;
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class evendigits {
    public static void main(String[] args) {
        int[] nums={12,345,2,6,7896};
        System.out.println(findnumbers(nums));
    }
    static int findnumbers(int[] arr){
        int count=0;
        for (int nums:arr){
            if (even(nums)){
                count++;
        }
    }return count;
    }
    static boolean even(int nums) {
        int numberofdigits=digits(nums);
        if (numberofdigits %2==0){
            return true;
        }return false;
    }
    static int digits(int num){
        if (num<0){
            num=num*-1;
        }
        if (num==0){
            return 1;
        }
        int count=0;
        while(num>0){
            count++;
            num=num/10;
        }return count;
     }
}
