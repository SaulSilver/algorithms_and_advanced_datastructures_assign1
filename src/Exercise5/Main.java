package Exercise5;

import Exercise1.QueueADT;
import Exercise2.StackADT;
import Exercise3.TreeNode;
import Exercise4.Tree;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * Created by hatem on 2016-10-03.
 */
public class Main implements A1Main {

    @Override
    public QueueADT<String> constructQueue(String jsonFilename) {
        QueueADT<String> jsonQueue = new QueueADT<>();
        try {
            String currentLine;
            URL url = this.getClass().getResource(jsonFilename);

            BufferedReader fileReader = new BufferedReader(new FileReader(new File(url.toURI())));

            while ((currentLine = fileReader.readLine()) != null)
                jsonQueue.enqueue(currentLine.trim());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return jsonQueue;
    }

    @Override
    public Tree<String> constructTree(QueueADT<String> jsonQueue) {
        Tree<String> jsonTree = new Tree<>();
        TreeNode<String> parent = new TreeNode<>(null);

        int queueLength = jsonQueue.length();
        for (int i = 0; i < queueLength; i++) {
            TreeNode<String> node = new TreeNode<>(jsonQueue.dequeue());
            //If the tree doesn't have a root
            if (node.isJsonObject() && i == 0) {
                jsonTree.addChild(null, node);
                parent = node;      //Set the root as a parent
            }
            //If the tree isn't empty
            else if (i != 0 && jsonTree.root().isJsonObject()) {
                String nodeValue = (String) node.getValue();
                String parentValue = (String) parent.getValue();
                if (node.isJsonPrimitive())     //If the node isn't jsonObject or jsonArray
                    jsonTree.addChild(parent, node);
                else if (node.isJsonObject() || node.isJsonArray()) {
                    jsonTree.addChild(parent, node);
                    parent = node;      //Set the jsonObject as a parent
                } else if (nodeValue.contains("]") && parentValue.contains("[")) {   //Check for the correct opening and closing of brackets
                    jsonTree.addChild(parent, node);
                    parent = parent.getParent();
                } else if (nodeValue.contains("}") && parentValue.contains("{")) {  //Check for the correct opening and closing of brackets
                    jsonTree.addChild(parent, node);
                    parent = parent.getParent();
                } else try {
                    throw new Exception("There is an error with the syntax, please write the syntax correctly (correct the opening and closing of brackets)");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonTree;
    }

    @Override
    public void printTree(Tree<String> jsonTree) {
        jsonTree.printTree();
    }
}
