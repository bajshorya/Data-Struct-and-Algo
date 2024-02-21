/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
//ques 374

 public class Searching {
//   extends GuessGame {
    // public int guessNumber(int n) {
  
    //     int left = 1;
    //     int right = n;
        
    //     while (left <= right) {
    //         int mid = left + (right - left) / 2;
    //         int result = guess(mid);
    //         if (result == 0) {
    //             return mid;
    //         } else if (result == -1) {
    //             right = mid - 1;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
        
    //     //This return statement is never reached if the picker's pick is within the range 1 to n.
    //     return -1;
    // }
//69sqrroot
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
           return x;
       }
       
       long left = 1; // Start from 1 because the square root of any number is at least 1.
       long right = x; // Start from x because the square root of any number is at most x.
       
       while (left <= right) {
           long mid = left + (right - left) / 2;
           long square = mid * mid;
           
           if (square == x) {
               return (int)mid;
           } else if (square < x) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }
       
       return (int)right; // Return the integer part of the square root rounded down.
   
   }

//278
//    public int firstBadVersion(int n) {
//     int left = 1;
//     int right = n;
    

//     while (left < right) {
//         int mid = left + (right - left) / 2;
//         if (isBadVersion(mid)) {
//             right = mid;
//         } else {
//             left = mid + 1;
//         }
//     }
//     return left;
// }
//744
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < letters[mid]) {
                right=mid-1;
            } else {
                left = mid+1;
            }
        }
        
        // If left is greater than or equal to the length of letters,
        // wrap around to the first character in letters.
        return letters[left % letters.length];
    }

//441
    public int arrangeCoins(int n) {
        int completeRows = 0;
        int coinsNeeded = 1;

        while (n >= coinsNeeded) {
            System.out.println("Adding row with " + coinsNeeded + " coins.");
            completeRows++;
            n -= coinsNeeded;
            coinsNeeded++;
        }

        return completeRows;
    } 

//34 
    public int[] searchRange(int[] nums,int target){
        int[] ans={-1,-1};

        ans[0]=search(nums,target,true);
        if (ans[0]!=-1) {
            ans[1]=search(nums,target,false);
        }
        return ans;
    }
    int search(int[] nums, int target, boolean firstStartIndex) {
        int ans=-1;
        int start=-1;
        int end=nums.length-1;
        while (start<=end) {
            int mid=start +(end-start)/2;
            if (target<nums[mid]) {
                end=mid-1;
            }else if (target>nums[mid]){
                start = mid+1;
            }else{
                ans=mid;
                if (firstStartIndex) {
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
//852Peak Index in a Mountain Array
    public int peakIndexInMountainArray(int[] arr) {
        int start =0;
        int end=arr.length-1;
        while (start<end) {
            int mid=start +(end-start)/2;
            if (arr[mid]>arr[mid+1]) {
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
//1095
    int findInMountainArray(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBS(arr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        // try to search in second half
        return orderAgnosticBS(arr, target, peak+1, arr.length - 1);
    }
    public int orderAgnosticBS(int[] arr, int target, int start, int end) {
        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
    //1351
    public static int countNegatives(int[][] grid) {
        int count=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]<0){
                    count++;
                }
                
            }
        }return count;
    }
    //  
    public static void main(String[] args) {
        // int[][] arr={{5,1,0},{-5,-5,-5}};
        // System.out.println("ans "+countNegatives(arr));
        // int[] arr = {4,5,6,1,2,3};
        int[] arr={1,2,3,4,5,6,7};
        System.out.println(arr[findPivot(arr)]);
    }
    //153
    public static int findMin(int[] nums) {
         int left = 0, right = nums.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[right]) {
            // Minimum element lies to the right of mid
            left = mid + 1;
        } else {
            // Minimum element lies to the left of mid or is equal to nums[mid]
            right = mid;
        }
    }

    // When left == right, it points to the minimum element
    return nums[left];    
    }
    //33
    public static int findPivot(int[]arr){
        int start=0;
        int end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (mid<end && arr[mid]>arr[mid+1]) {
                return mid;
            }
            if (mid>start && arr[mid]<arr[mid-1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end=mid-1;
            } else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
    public static int search(int[] nums, int target){
        int pivot=findPivot(nums);
        
        if (pivot==-1) {
            return binarySearch(nums, target, 0, nums.length-1);
        }
        if (nums[pivot]==target) {
            return pivot;
        }
        if (target>=nums[0]) {
            return binarySearch(nums, target, 0, pivot-1);
        }
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }
    public static int countRotation(int[] nums){
        int pivot=findPivot(nums);
        return pivot+1;
    }
}



  
