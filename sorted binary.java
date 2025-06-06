import java.util.*;

public class Solution {

    // ListNode definition for the linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // TreeNode definition for the BST
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // Your sortedListToBST method
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        return findNodes(head);
    }

    private TreeNode findNodes(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head.next;
        ListNode prev = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode curr = new TreeNode(slow.val);
        curr.right = findNodes(slow.next);
        prev.next = null;
        curr.left = findNodes(head);
        return curr;
    }

    // Level order print including nulls to match your previous format
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

        // Remove trailing nulls
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }

        return result;
    }
