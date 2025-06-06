import java.util.*;

public class Solution {

    // TreeNode class with constructor including left and right
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val; this.left = left; this.right = right;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        return build(nums, 0, nums.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private TreeNode build(List<Integer> nums, int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;
        return new TreeNode(nums.get(m), build(nums, l, m - 1), build(nums, m + 1, r));
    }

    // Build tree from level order input (use "null" to represent no node)
    public static TreeNode buildTreeFromLevelOrder(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();
            // left child
            if (!nodes[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i >= nodes.length) break;

            // right child
            if (!nodes[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // Print tree in level order with "null" for missing nodes
    public static List<String> levelOrder(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.add("null");
            } else {
                res.add(String.valueOf(node.val));
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        // trim trailing nulls
        int i = res.size() - 1;
        while (i >= 0 && res.get(i).equals("null")) {
            res.remove(i);
            i--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree nodes in level order, separated by space (use 'null' for missing nodes):");
        String line = sc.nextLine().trim();
        String[] nodes = line.split("\\s+");

        TreeNode root = buildTreeFromLevelOrder(nodes);
        Solution sol = new Solution();
        TreeNode balancedRoot = sol.balanceBST(root);

        List<String> output = levelOrder(balancedRoot);
        System.out.println(output);
    }
}
