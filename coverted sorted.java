import java.util.*;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        public static TreeNode helper(int nums[], int st, int end) {
            if (st > end) return null;
            int mid = (st + end) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, st, mid - 1);
            root.right = helper(nums, mid + 1, end);
            return root;
        }

        public static TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
    }

    // Level order traversal with nulls included for missing nodes
    public static List<String> levelOrder(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // Remove trailing "null"s to match output style
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String line = sc.nextLine();
        String[] parts = line.trim().split("\\s+");

        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        TreeNode root = Solution.sortedArrayToBST(nums);

        List<String> output = levelOrder(root);
        System.out.println(output);
    }
}
