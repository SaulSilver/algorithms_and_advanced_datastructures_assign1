package Exercise3;

import org.json.*;
import java.util.List;

/**
 *
 * Created by hatem on 2016-09-25.
 */
public class TreeNode implements A1TreeNode {
    private Node node;

    @Override
    public boolean isJsonObject() {
        return node.value instanceof JSONObject;
    }

    @Override
    public boolean isJsonArray() {
        return node.value instanceof JSONArray;
    }

    @Override
    public boolean isJsonPrimitive() {
        return node.value instanceof Integer;
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
