package Exercise5;

import Exercise1.QueueADT;
import Exercise4.Tree;

public interface A1Main {
	public QueueADT<String> constructQueue(String jsonFilename);
	public Tree<String> constructTree(QueueADT<String> jsonQueue);
	public void printTree(Tree<String> jsonTree);
}
