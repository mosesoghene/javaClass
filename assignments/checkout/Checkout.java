import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Checkout{
  private static ArrayList<String> productNames = new ArrayList<>();
  private static ArrayList<Integer> quantities = new ArrayList<>();
  private static ArrayList<Double> productPrices = new ArrayList<>();
  
  private static Scanner scan = new Scanner(System.in);
  
  public static void main(String... args){
  
    prompt("What is the customer's name? > ");
    String customerName = scan.nextLine();
    
    String addProductReponse = "yes";
    
    while (addProductReponse.equals("yes")){
      addProduct();
      
      prompt("Add more items? > ");
      addProductReponse = scan.nextLine().trim();      
    }
    
    scan.nextLine();
    prompt("What is your name? > ");
    String cashierName = scan.nextLine();
    
    String headerInfo = """
    SEMICOLON STORE
    MAIN BRANCH
    LOCATION: 312 HERBERT MACAULAY WAY, YABA, LAGOS.
    TEL: 09876543213
    Date: %s
    Cashier: %s
    Customer's Name: %s
    """;
    
    prompt("How much discount will he/she get? > ");
    double discountAmount = scan.nextDouble();
    
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy h:mm:ss a");
    String formattedDateTime = now.format(formatter);
    
    System.out.printf(headerInfo, formattedDateTime, cashierName, customerName);  
    printInvoice(productNames, quantities, productPrices, customerName, cashierName);
    
    prompt("How much did the customer give to you? > ");
    double amount  = scan.nextDouble();
    
    
    System.out.printf(headerInfo, formattedDateTime, cashierName, customerName);
    printReceipt(productNames, quantities, productPrices, customerName, cashierName, amount);
  }
  
  private static void printInvoice(ArrayList<String> products, ArrayList<Integer> quantities, ArrayList<Double> productPrices, String customerName, String cashierName) {
    System.out.println("+-----------------+------------+------------+------------+");
    System.out.printf("| %-15s | %10s | %10s | %10s |%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
    System.out.println("+-----------------+------------+------------+------------+");
    
    for (int i = 0; i < products.size(); i++){      
    System.out.printf("| %-15s | %10d | %10.2f | %10.2f |%n", products.get(i), quantities.get(i), productPrices.get(i), (quantities.get(i) * productPrices.get(i)));    
    System.out.println("+-----------------+------------+------------+------------+");
    }   
    
    double subt = getSubTotal(productPrices, quantities);
    double disc = getDiscount(getSubTotal(productPrices, quantities), 8);
    double vat = getVAT(subt, disc, 17.5);
    double billTotal = getBillTotal(subt, vat, disc);
    
    System.out.printf("|  %40s | %10.2f |%n", "Sub Total", subt);
    System.out.printf("|  %40s | %10.2f |%n", "Discount", disc);
    System.out.printf("|  %40s | %10.2f |%n", "VAT @ 17.5", vat);
    System.out.println("+-------------------------------------------+------------+");    
    System.out.printf("|  %40s | %10.2f |%n", "Bill Total", billTotal );
    System.out.println("+--------------------------------------------------------+");    
    System.out.printf("|  %17s  %5.2f %10s |%n", "THIS IS NOT A RECEIPT, KINDLY PAY", billTotal, " ");
    System.out.println("+--------------------------------------------------------+");

  }
  
  private static void printReceipt(ArrayList<String> products, ArrayList<Integer> quantities, ArrayList<Double> productPrices, String customerName, String cashierName, double amountPaid) {
    System.out.println("+-----------------+------------+------------+------------+");
    System.out.printf("| %-15s | %10s | %10s | %10s |%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
    System.out.println("+-----------------+------------+------------+------------+");
    
    for (int i = 0; i < products.size(); i++){      
    System.out.printf("| %-15s | %10d | %10.2f | %10.2f |%n", products.get(i), quantities.get(i), productPrices.get(i), (quantities.get(i) * productPrices.get(i)));    
    System.out.println("+-----------------+------------+------------+------------+");
    }   
    
    double subt = getSubTotal(productPrices, quantities);
    double disc = getDiscount(getSubTotal(productPrices, quantities), 8);
    double vat = getVAT(subt, disc, 17.5);
    double billTotal = getBillTotal(subt, vat, disc);
    
    System.out.printf("|  %40s | %10.2f |%n", "Sub Total", subt);
    System.out.printf("|  %40s | %10.2f |%n", "Discount", disc);
    System.out.printf("|  %40s | %10.2f |%n", "VAT @ 17.5", vat);
    System.out.println("+-------------------------------------------+------------+");    
    System.out.printf("|  %40s | %10.2f |%n", "VAT @ 17.5", billTotal ); 
    System.out.printf("|  %40s | %10.2f |%n", "Amount Paid", amountPaid ); 
    System.out.printf("|  %40s | %10.2f |%n", "Balance", (amountPaid - billTotal) );
    System.out.println("+--------------------------------------------------------+");    
    System.out.printf("|  %19s  %23s |%n", "THANK YOU FOR YOUR PATRONAGE", " ");
    System.out.println("+--------------------------------------------------------+");

  }
  
  private static void checkout(double billTotal){
    prompt("How much did they give you?");
    double amountPaid = scan.nextDouble();
    prompt("Total Balance " + (amountPaid - billTotal));
  }
  
  private static double getBillTotal(double subTotal, double vat, double discount){
    double billTotal =  subTotal + vat - discount;
    return billTotal;
  } 
  
  private static double getSubTotal(ArrayList<Double> prices, ArrayList<Integer> cartCounts){
    return IntStream.range(0, prices.size())
                    .mapToDouble((i) -> prices.get(i).doubleValue() * cartCounts.get(i).doubleValue())
                    .reduce(0.0, Double::sum);
  }
  
  private static double getDiscount(double subTotal, double discount){
    return subTotal * (discount / 100);
  }
  
  private static double getVAT(double subTotal, double discount, double vat){
    String result = new DecimalFormat("#.##").format(subTotal * (vat / 100));
    return Double.valueOf(result);
  }
  
  private static void addProduct(){
    addProductName();
    addquantities();
    addProductPrice();
  }
  
  private static void addProductName(){
    prompt("What did the user buy? > ");
    String productName = scan.nextLine();
    productNames.add(productName);
  }
  
  private static void addProductPrice(){
    prompt("How much per unit? > ");
    String input = scan.nextLine();
    double productPrice = Double.parseDouble(input);
    productPrices.add(productPrice);
  }
  
  private static void addquantities(){
    prompt("How many pieces? > ");
    String input = scan.nextLine();
    int productPieceCount = Integer.parseInt(input);
    quantities.add(productPieceCount);
  }
  
  private static void prompt(String text){
    System.out.println(text);
  }
}
