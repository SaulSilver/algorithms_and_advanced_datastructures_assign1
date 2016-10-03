package Exercise4;

import Exercise2.StackADT;
import Exercise3.TreeNode;
import Exercise4.A1Tree;

/**
 *
 * Created by hatem on 2016-10-01.
 */
public class Tree<E> implements A1Tree {
    private TreeNode root;
    private int size = 0;

    public Tree() {
        root = new TreeNode<>(null);
    }

    @Override
    public TreeNode root() {
        return root;
    }

    @Override
    public void addChild(TreeNode parent, TreeNode child) {
        //If the root is null then make the child the root
        if (size == 0)
            root = child;
        else parent.addChild(child);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printTree() {
        preorder(root);
    }

    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.getValue() + ", ");
            StackADT<TreeNode> children = node.getChildren();
            if (children != null) {
                for (int i = 0; i < children.size(); i++)
                    preorder((TreeNode) children.pop());
            }
        }
    }
}
