import Exercise1.QueueADT;
import Exercise4.Tree;
import Exercise5.Main;


/**
 *
 * Created by hatem on 2016-10-04.
 */
public class testClass {
    public static void main(String[] args) {
        Main main = new Main();
        QueueADT<String> queue = main.constructQueue("/test.json");
        Tree<String> tree = main.constructTree(queue);
        main.printTree(tree);
    }
}
