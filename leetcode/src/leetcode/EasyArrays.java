import java.util.Arrays;

public class EasyArrays {
    //1281 Subtract the Product and Sum of Digits of an Int
    public static int subtractProductAndSum(int n) {
        int product=1;
        int sum=0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10; // Remove the rightmost digit
            product*=digit;
            sum+=digit;
        }
        return product-sum;
    }
    //867 transpose matrix
    public int[][] transpose(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] result=new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i]=matrix[i][j];
            }
        }
        return result;
    }
    //832 flipping an image
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image.length;
        for (int i = 0; i < n; i++) {
            int left=0,right=n-1;
            while (left<right) {
                int temp=image[i][left];
                image[i][left]=image[i][right];
                image[i][right]=temp;
                left++;
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] ^= 1; 
            }
        }
        return image;
    }
    //1929 Concatenation of Array
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        // Copy elements of nums to ans
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }
        
        // Copy elements of nums to ans again, starting from position i + n
        for (int i = 0; i < n; i++) {
            ans[i + n] = nums[i];
        }
        
        return ans;
    }

    //1480 running sum :-
    public static int[] runningSum(int[] nums) {
        int n= nums.length;
        int sum=0;
        int[] ans=new int[n];
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
            ans[i]=sum;
        }
        return ans;
    }

    
    //1672 Richest Customer Wealth 
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customerAccounts : accounts) {
            int wealth = 0;
            for (int account : customerAccounts) {
                wealth += account;
            }
            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }

        return maxWealth;
    }
    //1470 Shuffle the array 
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i]; // Place elements from the first half
            result[2 * i + 1] = nums[n + i]; // Place elements from the second half
        }
        
        return result;
    }


  


    public static void main(String[] args) {
        // subtractProductAndSum(212233);
        // int[] nums = {1, 2, 3, 4};
        // int[] result = runningSum(nums);
        
        // // Print the running sum array
        // for (int num : result) {
        //     System.out.print(num + " ");
        // }
        // System.out.println();
        // System.out.println(nums.length);
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][]  target = {{1,1,1},{0,1,0},{0,0,0}};
        // for (int[] is : rotation(mat)) {
        //     System.out.println(Arrays.toString(is));
        // }
        System.out.println(findRotation(mat, target));
       
    }
    public static boolean findRotation(int[][] mat,int[][] target) {
        int[][] result=rotation(rotation(mat));
        return(compareMatrix(result, target));


    }
    public static int[][] rotation(int[][] mat){
        int[] arr1=new int[mat[0].length];
        int[] arr2=new int[mat[0].length];
        int[] arr3=new int[mat[0].length];
        int[][] rotated=new int[mat.length][mat[0].length];
        int count =mat[0].length-1;
        for (int i = 0; i < mat.length; i++) {
            arr1[count]=mat[i][0];
            arr2[count]=mat[i][1];
            arr3[count]=mat[i][2];
            count--;
        }
        rotated[0]=arr3;
        rotated[1]=arr2;
        rotated[2]=arr1;
        
        return rotated;
        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));
        // System.out.println(Arrays.toString(arr3));
    }
    public static boolean compareMatrix(int[][] mat1, int[][] mat2) {

        if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
            return false;
        }
    
        // Check if each element of the matrices is equal
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
    
        // If all elements are equal, return true
        return true;
    }
    //27  remove element
    public int removeElement(int[] nums, int val) {
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val) {
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
    
    
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

