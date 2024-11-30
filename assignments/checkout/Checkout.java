import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.text.DecimalFormat;

public class Checkout{
  private static ArrayList<String> productNames = new ArrayList<>();
  private static ArrayList<Integer> numberOfPieces = new ArrayList<>();
  private static ArrayList<Double> productPrices = new ArrayList<>();
  
  private static Scanner scan = new Scanner(System.in);
  
  public static void main(String... args){
    String addProductReponse = "yes";
    while (addProductReponse.equals("yes")){
      addProduct();
      
      prompt("Add more items? \n> ");
      addProductReponse = scan.next();      
    }
    
    double subt = getSubTotal(productPrices, numberOfPieces);
    double disc = getDiscount(getSubTotal(productPrices, numberOfPieces), 8);
    double vat = getVAT(subt, disc, 17.5);
    double billTotal = getBillTotal(subt, vat, disc);
    
    System.out.println(productNames +" "+ numberOfPieces +" "+ productPrices );
    System.out.println("SubTotal: "+ subt +" Discount: "+ disc +" VAT @ 7.5%: " + vat +" Bill Total: "+ billTotal);
    checkout(billTotal);
    
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
    addNumberOfPieces();
    addProductPrice();
  }
  
  private static void addProductName(){
    prompt("What did the user buy? \n> ");
    String productName = scan.next();
    productNames.add(productName);
  }
  
  private static void addProductPrice(){
    prompt("How much per unit? \n> ");
    double productPrice = scan.nextDouble();
    productPrices.add(productPrice);
  }
  
  private static void addNumberOfPieces(){
    prompt("How many pieces? \n> ");
    int productPieceCount = scan.nextInt();
    numberOfPieces.add(productPieceCount);
  }
  
  private static void prompt(String text){
    System.out.print(text);
  }
}
