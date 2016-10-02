package Exercise4;

import Exercise3.TreeNode;

/**
 *
 * Created by hatem on 2016-10-01.
 */
public class Tree implements A1Tree {
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
        else {
            parent.addChild(child);
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printTree() {

    }
}
