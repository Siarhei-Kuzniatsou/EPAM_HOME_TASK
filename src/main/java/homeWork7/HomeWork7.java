package homeWork7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeWork7 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text = in.readLine();
        IHandler procces = new Handler();
        procces.printResult(procces.process(text));
    }
}
