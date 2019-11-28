package homeWork5;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;

class Cat implements Serializable {
    int a = 10;

    @Override
    public String toString() {
        return "Cat{" +
                "a=" + a +
                '}';
    }
}

public class HomeWork5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("Cat.txt");
        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        Cat cat = new Cat();
        cat.a = 0;
        oo.writeObject(cat);
        oo.close();
        File file1 = new File("Cat.txt");
        FileInputStream fi = new FileInputStream(file1);
        ObjectInputStream oi = new ObjectInputStream(fi);
        Cat newCat = (Cat) oi.readObject();
        System.out.println(newCat);

    }
}
