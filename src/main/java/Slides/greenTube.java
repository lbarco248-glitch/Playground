package Slides;

import java.util.ArrayList;

public class greenTube {
    public static void main(String[] args) {
        String data;
        String date = "1";
        String time = "1";
        String description = "1";
        String vendor = "1";
        float amount = 69.42F;
        data = String.format("%s | %s | %s | %s | $%.2f\n", date, time, description, vendor, amount);
        ArrayList<String> bankInfo = new ArrayList<String>();
        bankInfo.add(data);
        System.out.println(bankInfo);
    }
}
