package Exercise3;

import Exercise2.StackADT;
import org.json.*;
import java.util.Stack;

/**
 *
 * Created by hatem on 2016-09-25.
 */
public class TreeNode<E> implements A1TreeNode {

    private Object value;
    private StackADT<TreeNode> children;
    private TreeNode parent;

    public TreeNode(Object data){
        value = data;
    }

    public void addChild(TreeNode newNode) {
        children.push(newNode);
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

    @Override
    public boolean isJsonObject() {
        return value instanceof JSONObject;
    }

    @Override
    public boolean isJsonArray() {
        return value instanceof JSONArray;
    }

    @Override
    public boolean isJsonPrimitive() {
        return value instanceof Integer;
    }

}
