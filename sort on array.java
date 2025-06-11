public class Solution {

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int swap = 1;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    swap = 0;
                }
            }
            if (swap == 1) break;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {5, 2, 3, 1};
        int[] sorted = sol.sortArray(nums);

        System.out.print("Sorted array: ");
        for (int num : sorted) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
