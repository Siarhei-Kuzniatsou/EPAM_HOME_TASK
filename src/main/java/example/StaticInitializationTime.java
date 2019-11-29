package example;

public class StaticInitializationTime {

    static {
        System.out.println("First?");
    }

    {
        C staticInitializationTime = new C();
        System.out.println("Second?");
    }

    public StaticInitializationTime() {
        System.out.println("Consrtuct?");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Before class loading");
//        Class.forName(StaticInitializationTime.class.getName());
        System.out.println("After class loading");
    }
}

class C extends StaticInitializationTime {
    static int i = value();

    static {
        System.out.println("!!!!");
    }

    static int value() {
        System.out.println("C.i initialized");
        return 1;
    }
}