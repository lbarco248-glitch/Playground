package Sandbox;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AreaA {
    public static String date = "";
    public static String time = "";
    static Scanner input = new Scanner(System.in);


    public AreaA() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        compiledData();
        makePayment();
    }


 public static void compiledData() throws IOException {
        FileWriter fWriter = new FileWriter("Transactions.txt",true);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        time();
        System.out.println("What kind of deposit will this be?\nA) Check Deposit\nB) Cash Deposit\nC) Direct Transfer\nD) Other ");
        char depositType = input.next().charAt(0);
        String description = "";
        switch (depositType) {
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
        data = String.format("%s | %s | %s | %s |$%.2f\n", date, time, description, vendor, amount);
        bWriter.write(data);
        bWriter.close();
    }



  public static void time()
  {
      LocalDate originalDate = LocalDate.now();
      DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      date = originalDate.format(formattedDate);
      LocalTime originalTime = LocalTime.now();
      DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("hh:mm:ss a");
      time = originalTime.format(formattedTime);
  }
    public static void makePayment() throws IOException {
      FileWriter fWriter = new FileWriter("Transactions.txt");
      BufferedWriter bWriter = new BufferedWriter(fWriter);
      time();
      System.out.println("Payment amount: (Numerical value only)");
      float payment = input.nextFloat();
      System.out.println();
      System.out.println("What is this payment for?\nA) Shopping\nB) Food & Drink\nC) Bills & Utilities\nD) Entertainment\nE) Groceries\nF) Personal\nG) Gas");
      char paymentCat = input.next().charAt(0);
      String category = "";
        switch (paymentCat) {
            case 'A', 'a' -> category = "Shopping";
            case 'B', 'b' -> category = "Food & Drink";
            case 'C', 'c' -> category = "Bills & Utilities";
            case 'D', 'd' -> category = "Entertainment";
            case 'E', 'e' -> category = "Groceries";
            case 'F', 'f' -> category = "Personal";
            case 'G', 'g' -> category = "Gas";
            default -> System.out.println("Invalid selection.");
        }
        System.out.println("What method of payment was used?\nA) Cash\nB) Check\nC) Debit/Credit Card\nD) Other");
        char paymentType = input.next().charAt(0);
        String Type = "";
        switch (paymentType) {
            case 'A', 'a' -> Type = "Cash";
            case 'B', 'b' -> Type = "Check";
            case 'C', 'c' -> Type = "Debit/Credit Card";
            case 'D', 'd' -> Type = "Other";
            default -> System.out.println("Invalid selection.");
        }
        String data;
        data = String.format("%s | %s | %s | %s |$%.2f\n", date, time, category, Type, payment);
        bWriter.write(data);
        bWriter.close();
  }
}