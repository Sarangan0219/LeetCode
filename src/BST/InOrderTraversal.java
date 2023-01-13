package BST;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root != null) {
            visit(root, out);
        }
        return out;
    }

    public static void visit(TreeNode node, List<Integer> out) {
        if (node != null ) {
            if (node.left != null) {
                visit(node.left, out);
            }
            out.add(node.val);
            if (node.right != null) {
                visit(node.right, out);
            }
        }
    }
}
