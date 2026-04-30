package Sandbox;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AreaA {
    static Scanner input = new Scanner(System.in);


    public AreaA() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        FileWriter fWriter = new FileWriter("Transactions");
        BufferedWriter bWriter = new BufferedWriter(fWriter);
      //  compiledData();
    }


/*  public static void compiledData() throws IOException {
    FileWriter fWriter = new FileWriter("Transactions");
    BufferedWriter bWriter = new BufferedWriter(fWriter);
    LocalDate originalDate = LocalDate.now();
    DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String date = originalDate.format(formattedDate);
    System.out.println(date);
    LocalTime originalTime= LocalTime.now();
    DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("hh:mm:ss a");
    String time = originalTime.format(formattedTime);
    System.out.println(time);
    System.out.println("What kind of deposit will this be?\nA) Check Deposit\nB) Cash Deposit\nC) Direct Transfer\nD) Other ");
    char depositType = input.next().charAt(0);
    String description = "";
    switch(depositType)
    {
     case 'A', 'a' -> description = "Check Deposit";
     case 'B', 'b' -> description = "Cash Deposit";
     case 'C', 'c' -> description = "Direct Transfer";
     case 'D', 'd' -> description = "Other";
     default -> System.out.println("Invalid selection.");
    }
    System.out.println("Deposit amount: (Numerical value only)");
    float amount = input.nextFloat();
    System.out.println("Please input the source of the deposit: (i.e. John Smith, Walmart, Chargeback, etc.)");
    input.nextLine();
    String vendor = input.nextLine();
    String data;
    data = String.format("%s | %s | %s | %s |$%.2f", date, time, description, vendor, amount);
    bWriter.write(data);
    bWriter.close();

}*/
  public static void makePayment()
}