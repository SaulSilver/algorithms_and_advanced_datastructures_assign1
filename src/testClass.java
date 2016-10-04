import Exercise1.QueueADT;
import Exercise4.Tree;
import Exercise5.Main;


/**
 *
 * Created by hatem on 2016-10-04.
 */
public class testClass {
    public static void main(String[] args) {
        Main a7a = new Main();
        QueueADT<String> kharaQueue = a7a.constructQueue("/test.json");
        Tree<String> shagara = a7a.constructTree(kharaQueue);
        a7a.printTree(shagara);
    }
}
