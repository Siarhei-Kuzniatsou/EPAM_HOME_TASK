package homeWork1;

public class Home_Work_1 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        double m1 = Double.parseDouble(args[2]);
        double m2 = Double.parseDouble(args[3]);
        result(a,p,m1,m2);
    }

    private static void result(int a, int p, double m1, double m2) {
        double g;
        g = 4 * Math.PI * Math.pow(a, 3) / (Math.pow(p, 2) * (m1 + m2));
        System.out.println("G=" + g);
    }
}


