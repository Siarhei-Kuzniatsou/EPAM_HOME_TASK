package automationHomework.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bla {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        String dateString = format.format(new Date());
        System.out.println(dateString);
    }
}
