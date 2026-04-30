package Sandbox;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;


public class AreaA {
    public static String date = "";
    public static String time = "";
    static Scanner input = new Scanner(System.in);
    static String[] depositDataSplit ={};
    static String[] paymentDataSplit = {};

    public static void time()
    {
        LocalDate originalDate = LocalDate.now();
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = originalDate.format(formattedDate);
        LocalTime originalTime = LocalTime.now();
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("hh:mm:ss a");
        time = originalTime.format(formattedTime);
    }

    public static Arrays()
    {
        ArrayList<String> transaction = new ArrayList<>();
        String vendor = "";
        String description = "";
        float amount = 0F;
        transaction.add(String.format("%s | %s | %s | %s | $%.2f\n", date, time, description, vendor, amount));
        System.out.println(transaction);
    }



/*
    public AreaA() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        ArrayList<transaction> transactions = getTransactions();
        compiledData();
        makePayment();
        ledgerMenu();
    }


 public static void compiledData() throws IOException {
        FileWriter fWriter = new FileWriter("TransactionsCopy.csv",true);
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
        data = String.format("%s | %s | %s | %s | $%.2f\n", date, time, description, vendor, amount);
        ArrayList<String> bankInfo = new ArrayList<String>();
        bankInfo.add(data);
        String[] depositDataSplit = data.split("\\|");
        bWriter.write(data);
        bWriter.close();
    }




    public static void makePayment() throws IOException {
      FileWriter fWriter = new FileWriter("TransactionsCopy.csv");
      BufferedWriter bWriter = new BufferedWriter(fWriter);
      time();
      System.out.println("Payment amount: (Numerical value only)");
      float payment = input.nextFloat();
      System.out.println();
      System.out.println("What is this payment for?\nA) Shopping\nB) Food & Drink\nC) Bills & Utilities\nD) Entertainment\nE) Groceries\nF) Personal\nG) Gas");
      // Potentially replace w/ Vendor name for consistency’s sake
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
        data = String.format("%s | %s | %s | %s | -$%.2f\n", date, time, category, Type, payment);
        String[] paymentDataSplit = data.split("\\|");
        bWriter.write(data);
        bWriter.close();
  }
  public static void ledgerMenu() throws IOException {
        System.out.println("""
    A) Display all transaction entries
    B) Display all deposits
    P) Display all payments
    R) Display custom report
    H) Return to home page
    """);
    char selection = input.next().charAt(0);
    switch (selection)
    {
        case 'A', 'a' -> ledgerAll();
        case 'B', 'b' -> System.out.println("Placeholder2");
        case 'P', 'p' -> System.out.println("Placeholder3");
        case 'R', 'r' -> System.out.println("Placeholder4");
        case 'H', 'h' -> System.out.println("Placeholder5");
        default -> System.out.println("Invalid selection.");
    }
    }
    public static void ledgerAll() throws IOException {
        FileReader fReader = new FileReader("TransactionsCopy.csv");
        BufferedReader bReader = new BufferedReader(fReader);
        String information;
        while ((information = bReader.readLine())!= null)
        {
            System.out.println(information);
        }
    }
    public static void ledgerDeposits() throws IOException
    {
        FileReader fReader = new FileReader("TransactionsCopy.csv");
        BufferedReader bReader = new BufferedReader(fReader);
        String information;
        while ((information = bReader.readLine())!= null &&// depositDataSplit
        {
            System.out.println(information);
        }
    }

}