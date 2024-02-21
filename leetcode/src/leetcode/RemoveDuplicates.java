

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr={0,0,1,1,1,2,2,3,3,4};
        int ans=removeDuplicates(arr);
        System.out.println(ans);
    }
    static int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int k = 1; // Initialize the count of unique elements
            int n = nums.length;

            // Loop through the array with two pointers
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[k] = nums[i];
                    k++;
                }
            }

            return k;
        }

}

