package homeWork7;

import java.util.TreeSet;

public interface IHandler {
    TreeSet<String> process(String text);
    void printResult(TreeSet<String> treeSet);

}
