package shoryabinary;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class leetcode34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 7, 7, 8, 8, 10};
        int target = 7;
        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        // check for first occurrence of target first
        int start=search(nums,target,true);
        int end=search(nums,target,false);

        ans[0]=start;
        ans[1]=end;
        return ans;
    }
    //this function just returns the index value of target
    static int search(int[] nums, int target, boolean findStartInex){
        int ans =-1;
        // check for first occurrence of target first
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                //potential answer found
                ans=mid;
                if(findStartInex){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }

        }
        return ans;
    }
}


