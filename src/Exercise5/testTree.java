package Exercise5;

import Exercise1.QueueADT;
import Exercise3.TreeNode;
import Exercise4.Tree;

import java.io.*;

/**
 *
 * Created by hatem on 2016-10-03.
 */
public class testTree implements A1Main {



    @Override
    public QueueADT<String> constructQueue(String jsonFilename) {
        QueueADT<String> jsonQueue = new QueueADT<>();
        try {
            String currentLine;
            BufferedReader fileReader = new BufferedReader(new FileReader(jsonFilename));

            while ((currentLine = fileReader.readLine()) != null)
                jsonQueue.enqueue(currentLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonQueue;
    }

    @Override
    public Tree<String> constructTree(QueueADT<String> jsonQueue) {
        Tree<String> jsonTree = new Tree<>();

        for (int i = 0; i < jsonQueue.length(); i++) {
            TreeNode<String> node = new TreeNode<>(jsonQueue.dequeue());
            if (i == 0)
                jsonTree.addChild(null, node);
            jsonTree.addChild();
        }
        return null;
    }

    @Override
    public void printTree(Tree<String> jsonTree) {

    }
}
