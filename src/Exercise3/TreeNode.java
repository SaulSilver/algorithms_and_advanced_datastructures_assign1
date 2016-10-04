package Exercise3;

import Exercise1.QueueADT;
import Exercise2.StackADT;
import org.json.*;
import java.util.Stack;

/**
 *
 * Created by hatem on 2016-09-25.
 */
public class TreeNode<E> implements A1TreeNode {

    private Object value;
    private QueueADT<TreeNode> children = new QueueADT<>();
    private TreeNode parent;

    public TreeNode(Object data){
        value = data;
    }

    public void addChild(TreeNode newNode) {
        children.enqueue(newNode);
        newNode.setParent(this);
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public QueueADT<TreeNode> getChildren() {
        return children;
    }

    @Override
    public boolean isJsonObject() {
        return ((String) value).contains("{");
    }

    @Override
    public boolean isJsonArray() {
        return ((String) value).contains("[");
    }

    @Override
    public boolean isJsonPrimitive() {
        String val = (String) value;
        return !(val.contains("[") || val.contains("{") || val.contains("}") || val.contains("]"));
    }

}
