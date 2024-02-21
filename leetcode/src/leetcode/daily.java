public class daily {
    //20feb  231easy Power of Two
 public boolean isPowerOfTwo(int n) {
        // return n < 1 ? false : (n & (n - 1)) == 0 ? true : false;
        if (n <= 0) {
        return false; 
        }
        // If n is non-positive, it cannot be a power of two
    // }
    // Keep dividing n by 2 until it becomes 1 or odd
    while (n > 1) {
        if (n % 2 != 0) {
            return false; // If n is not divisible by 2, it's not a power of two
        }
        n /= 2;
    }
    return true;
    }

    // or
    // return n < 1 ? false : (n & (n - 1)) == 0 ? true : false;
//21 feb 268missing number

public int missingNumber(int[] nums) {
        int n = nums.length;
    // Calculate the sum of all numbers from 0 to n
    int expectedSum = n * (n + 1) / 2;
    
    // Calculate the sum of the elements in the array
    int actualSum = 0;
    for (int num : nums) {
        actualSum += num;
    }
    
    // The missing number is the difference between expected sum and actual sum
    return expectedSum - actualSum;
    }

}
