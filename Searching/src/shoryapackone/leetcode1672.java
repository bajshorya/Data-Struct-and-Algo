package shoryapackone;
//https://leetcode.com/problems/richest-customer-wealth/
import java.util.*;


public class leetcode1672 {
    public static void main(String[]args){

    }
    public int maxwealth(int[][] accounts){
        int ans=Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++) {
            int rowsum=0;
            for (int account = 0; account < accounts[person].length; account++) {
                rowsum+=accounts[person][account];
            }
            if(rowsum>ans){
                ans=rowsum;
            }
        }return ans;
    }
}
