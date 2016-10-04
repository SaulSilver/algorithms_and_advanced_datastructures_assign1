package Exercise4;

import Exercise1.QueueADT;
import Exercise3.TreeNode;

/**
 *
 * Created by hatem on 2016-10-01.
 */
public class Tree<E> implements A1Tree {
    private TreeNode root;
    private int size = 0;

    private String whiteSpaceCounter = "";                      //A holder of whitespaces used for indentation
    private QueueADT<String> oneLine = new QueueADT<>();        //The line holding elements that don't need a new line (e.g. "cars" : { )

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

    /**
     * A recursive method for printing the tree with indentation
     * @param node: the node to be printed
     */
    private void preorder(TreeNode node) {
        if (node != null) {
            //For the correct indentation
            if (node.isJsonObject() || node.isJsonArray()) {
                while (oneLine.length() != 0)       //Print what is in the queue first
                    System.out.print(oneLine.dequeue());
                System.out.println(whiteSpaceCounter + node.getValue());
                whiteSpaceCounter += "\t";
            } else if (node.getValue().equals("]") || node.getValue().equals("}")) {
                if (oneLine.length() != 0) {
                    while (oneLine.length() != 0)           //Print what is in the queue first
                        System.out.print(oneLine.dequeue());
                    System.out.println();
                }
                whiteSpaceCounter = whiteSpaceCounter.replaceFirst("\t", "");
                System.out.println(whiteSpaceCounter + node.getValue());
            } else {        //If the node is primitive
                if(node.getValue().equals(",")) {
                    oneLine.enqueue(node.getValue());
                    while (oneLine.length() != 0)
                        System.out.print(oneLine.dequeue());
                    System.out.println();
                }
                else {
                    if (oneLine.length() == 0)
                        oneLine.enqueue(whiteSpaceCounter + node.getValue());
                    else  oneLine.enqueue(" " + node.getValue());
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