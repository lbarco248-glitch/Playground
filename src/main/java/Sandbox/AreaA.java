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
    static ArrayList<AreaB> transactions = new ArrayList<>();


public static void time()
{
    LocalDate originalDate = LocalDate.now();
    DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    date = originalDate.format(formattedDate);
    LocalTime originalTime = LocalTime.now();
    DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("hh:mm:ss a");
    time = originalTime.format(formattedTime);
}

private static ArrayList<AreaB> getTransactions()
{
    try
    {
        FileReader fReader = new FileReader("TransactionsCopy.csv");
        BufferedReader bReader = new BufferedReader(fReader);
        String keyboard;
        bReader.readLine();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("kk:mm:ss");
        while ((keyboard = bReader.readLine()) != null)
        {
            String[] bankInfo = keyboard.split("\\|");
            AreaB newInfo = new AreaB();
            newInfo.setDate(LocalDate.parse(bankInfo[0],formatter1));
            newInfo.setTime(LocalTime.parse(bankInfo[1],formatter2));
            newInfo.setDescription(bankInfo[2]);
            newInfo.setVendor(bankInfo[3]);
            newInfo.setAmount(Float.parseFloat(bankInfo[4]));
            transactions.add(newInfo);
        }
    }
    catch (IOException e)
    {
        System.out.println("Error found.");
        e.printStackTrace();
    }
    return transactions;
}


    public AreaA() throws IOException {
    }

    public static void main(String[] args) throws IOException {
            boolean AppRun = true;
            //Home Screen
            while (AppRun)
            {
                System.out.println("D) Add Deposit\nP) Make Payment\nL) Access Ledger\nX) Exit");
                char selection = input.next().charAt(0);
                switch(selection) {
                    case 'D', 'd' -> compiledData();
                    case 'P', 'p' -> makePayment();
                    case 'l', 'L' -> ledgerMenu();
                    case 'X', 'x' -> AppRun = false;
                    default -> System.out.println("Invalid selection. Please try again.");
                }
            }
            input.close();
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
        data = String.format("%s | %s | %s | %s | %.2f\n", date, time, description, vendor, amount);
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
        data = String.format("%s | %s | %s | %s | -%.2f\n", date, time, category, Type, payment);
        bWriter.write(data);
        bWriter.close();
  }
  public static void ledgerMenu() throws IOException {
  boolean inLedgerMenu = true;
    while (inLedgerMenu)
      {
          System.out.println("""
                  A) Display all transaction entries
                  D) Display all deposits
                  P) Display all payments
                  R) Display custom report
                  H) Return to home page
                  """);

          char selection = input.next().charAt(0);
          switch (selection) {
              case 'A', 'a' -> ledgerAll();
              case 'D', 'd' -> ledgerDeposits();
              case 'P', 'p' -> ledgerPayments();
              case 'R', 'r' -> ledgerReport();
              case 'H', 'h' -> inLedgerMenu = false;
              default -> System.out.println("Invalid selection.");
          }
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
    private static void ledgerDeposits()
    {
        /*Loop through file backwards to help sort*/
        getTransactions();
        for(AreaB transaction:transactions)
        {
            if(transaction.getAmount() > 0)
                System.out.println((String.format("%s|%s|%s|%s|%.2f\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount())));
        }
    }
    
    private static void ledgerPayments()
    {
        /*Loop through file backwards to help sort*/
        getTransactions();
        for(AreaB transaction:transactions)
        {
            if(transaction.getAmount() < 0)
                System.out.println((String.format("%s|%s|%s|%s|%.2f\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount())));
        }
    }
    
    private static void ledgerReport()
    {
        boolean inLedgerReport = true;
        System.out.println("""
                1) Month to Date
                2) Previous Month
                3) Year to Date
                4) Previous Year
                5) Search by Vendor
                0) Back
                """);
        while (inLedgerReport) {
            int selection = input.nextInt();
            switch (selection)
            {
                case 1 -> monthToDate();
                case 2 -> previousMonth();
                case 3 -> yearToDate();
                case 4 -> previousYear();
                case 5 -> searchVendor();
                case 0 -> inLedgerReport = false;
                default -> System.out.println("Invalid selection.");
            }
        }
    }
    
    private static void monthToDate()
    {
        getTransactions();
        System.out.println("Please input the initial month to review. (Please use the following format: YYYY-MM)");
        input.nextLine();
        LocalDate givenDate = LocalDate.parse(input.nextLine() + "-01");
        for(AreaB transaction:transactions)
        {
            LocalDate storedDate = transaction.getDate();
            if (givenDate.isBefore(storedDate))
            {
            System.out.println((String.format("%s|%s|%s|%s|%.2f\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount())));
            }
        }
    }
    private static void previousMonth()
    {
        getTransactions();
        input.nextLine();
        for(AreaB transaction:transactions)
        {
            LocalDate storedDate = transaction.getDate();
            LocalDate givenDate = LocalDate.now().minusMonths(1);
            if (givenDate.isBefore(storedDate))
            {
                System.out.println((String.format("%s|%s|%s|%s|%.2f\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount())));
            }
        }
    }

    private static void yearToDate()
    {
        getTransactions();
        System.out.println("Please input the initial year to review. (Please use the following format: YYYY)");
        input.nextLine();
        LocalDate givenYear = LocalDate.parse(input.nextLine() + "-01-01");
        for(AreaB transaction:transactions)
        {
            LocalDate storedDate = transaction.getDate();
            if (givenYear.isBefore(storedDate))
            {
                System.out.println((String.format("%s|%s|%s|%s|%.2f\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount())));
            }
        }
    }
    private static void previousYear()
    {
        getTransactions();
        input.nextLine();
        for(AreaB transaction:transactions)
        {
            LocalDate storedDate = transaction.getDate();
            LocalDate givenDate = LocalDate.now().minusYears(1);
            if (givenDate.isBefore(storedDate))
            {
                System.out.println((String.format("%s|%s|%s|%s|%.2f\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount())));
            }
        }
    }

    private static void searchVendor()
    {
        getTransactions();
        input.nextLine();
        System.out.println("Please type which vendor you would like to see entries for: ");
        String Vendor = input.nextLine().toLowerCase();
        for(AreaB transaction:transactions)
        {
            if (transaction.getVendor().toLowerCase().equals(Vendor))
            {
                System.out.println((String.format("%s|%s|%s|%s|%.2f\n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount())));
            }
        }
    }
}