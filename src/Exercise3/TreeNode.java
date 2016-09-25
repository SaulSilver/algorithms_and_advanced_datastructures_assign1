package Exercise3;

import java.lang.reflect.Array;
import java.util.List;

/**
 *
 * Created by hatem on 2016-09-25.
 */
public class TreeNode implements A1TreeNode {
    private Node node;

    @Override
    public boolean isJsonObject() {
        return node.value instanceof Object;
    }

    @Override
    public boolean isJsonArray() {
        return node.value instanceof Array;
    }

    @Override
    public boolean isJsonPrimitive() {
        return node.value instanceof Number;
    }

    private class Node {

        private Object value;
        List<Node> children;

        Node(Object v) {
            value = v;
        }

        void addChild(Node newNode) {
            children.add(newNode);
        }
    }
}
