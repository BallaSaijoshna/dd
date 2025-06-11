public class Solution {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 3, 5, 6};
        int target = 5;

        int result = sol.searchInsert(nums, target);
        System.out.println("Index to insert target " + target + " is: " + result);

        // Try another test
        target = 2;
        result = sol.searchInsert(nums, target);
        System.out.println("Index to insert target " + target + " is: " + result);

        // Target greater than all elements
        target = 7;
        result = sol.searchInsert(nums, target);
        System.out.println("Index to insert target " + target + " is: " + result);
    }
}
