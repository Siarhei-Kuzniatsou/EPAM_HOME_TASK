package homeWork7;


import java.util.Iterator;
import java.util.TreeSet;

public class Handler implements IHandler{

    @Override
    public TreeSet<String> process(String text) {
        String textLower = text.toLowerCase();
        switch (text.length()) {
            case 0:
                System.out.println("String is empty"); return null;
            default:
                TreeSet<String> treeSet = new TreeSet<>();
                String[] temp = textLower.split("[\\W]");
                for (String str:temp) {
                    if (!str.equals("")) treeSet.add(str);
                }
                return treeSet;
        }

    }

    @Override
    public void printResult(TreeSet<String> treeSet) {
        if (treeSet == null) return;
        char ch, chTemp;
        String str;
        Iterator<String> it = treeSet.iterator();

        str = it.next();
        chTemp = str.charAt(0);
        System.out.print(chTemp + ": " + str + ", ");
        while (it.hasNext()){
            str = it.next();
            if (str.charAt(0) == chTemp) System.out.print(str + ", ");
            else {
                System.out.println();
                chTemp = str.charAt(0);
                System.out.print(chTemp + ": " + str + ", ");
            }

        }
    }

}
