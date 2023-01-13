package BST;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

    private static int ans =0;
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> out = new ArrayList<>();
        if (root != null) {
            inorder(root, k, out);
        }
        return ans;
    }

    public static void inorder(TreeNode node, int k, List<Integer>out) {
        if (node.left != null) {
            inorder(node.left, k, out);
        }
        out.add(node.val);
        if (out.size() == k) {
            ans = node.val;
            return;
        }
        if (node.right != null) {
            inorder(node.right, k, out);
        }
    }
}
