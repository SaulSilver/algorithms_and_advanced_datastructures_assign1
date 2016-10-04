package Exercise4;

import Exercise1.QueueADT;
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
    private String whiteSpaceCounter = "";
    QueueADT<String> elseLine = new QueueADT<>();

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
        if (parent == null)
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
            //For the correct indentation
            if (node.isJsonObject() || node.isJsonArray()) {
                while (elseLine.length() != 0)
                    System.out.print(elseLine.dequeue());
                System.out.println(whiteSpaceCounter + node.getValue());
                whiteSpaceCounter += "\t";
            } else if (node.getValue().equals("]") || node.getValue().equals("}")) {
                if (elseLine.length() != 0) {
                    while (elseLine.length() != 0)
                        System.out.print(elseLine.dequeue());
                    System.out.println();
                }
                whiteSpaceCounter = whiteSpaceCounter.replaceFirst("\t", "");
                System.out.println(whiteSpaceCounter + node.getValue());
            } else {
                if(node.getValue().equals(",")) {
                    elseLine.enqueue(node.getValue());
                    while (elseLine.length() != 0)
                        System.out.print(elseLine.dequeue());
                    System.out.println();
                }
                else {
                    if (elseLine.length() == 0)
                        elseLine.enqueue(whiteSpaceCounter + node.getValue());
                    else  elseLine.enqueue(" " + node.getValue());
                }
            }
            QueueADT<TreeNode> children = node.getChildren();
            if (children != null) {
                int childrenLength = children.length();
                for (int i = 0; i < childrenLength; i++) {
                    preorder((TreeNode) children.dequeue());
                }
            }

        }
    }
}