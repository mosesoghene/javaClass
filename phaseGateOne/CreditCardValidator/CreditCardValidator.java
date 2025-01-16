import java.util.Scanner;

public class CreditCardValidator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter credit card number: ");
    String cardNumber = input.nextLine();
    
    if (!isValidLength(cardNumber)) {
      System.out.println("Invalid card number length. Must be between 13 and 16 digits.");
    }
    
    String cardType = determineCardType(cardNumber);
    boolean isValid = isValidCard(cardNumber);
    
    
    System.out.println("*******************************************************");
    System.out.printf("**Card Type: %s%n", cardType);
    System.out.printf("**Card Number: %s%n", cardNumber);
    System.out.printf("**Card Length: %d%n", cardNumber.length());
    System.out.printf("**Card Validity: %s%n", isValid ? "Valid" : "Invalid");
    System.out.println("*******************************************************");
  }
  
  public static boolean isValidLength(String cardNumber) {
    int length = cardNumber.length();
    return length >= 13 && length <= 16;
  }

  public static String determineCardType(String cardNumber) {
    if (cardNumber.startsWith("4")) {
      return "Visa Card";
    } else if (cardNumber.startsWith("5")) {
      return "MasterCard";
    } else if (cardNumber.startsWith("37")) {
      return "American Express Card";
    } else if (cardNumber.startsWith("6")) {
      return "Discover Card";
    }
    return "Invalid Card Type";
  }
  
  public static boolean isValidCard(String cardNumber) {
    int sumOfDoubleEvenPlace = sumOfDoubleEvenPlace(cardNumber);
    int sumOfOddPlace = sumOfOddPlace(cardNumber);
    int totalSum = sumOfDoubleEvenPlace + sumOfOddPlace;
    
    return totalSum % 10 == 0;
  }
  
  public static int sumOfDoubleEvenPlace(String cardNumber) {
    int sum = 0;
    for (int i = cardNumber.length() - 2; i >= 0; i -= 2) {
      int digit = Character.getNumericValue(cardNumber.charAt(i));
      int doubledDigit = digit * 2;
      sum += doubledDigit > 9 ? (doubledDigit / 10 + doubledDigit % 10) : doubledDigit;
    }
    return sum;
  }
    
    public static int sumOfOddPlace(String cardNumber) {
      int sum = 0;
      for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
        sum += Character.getNumericValue(cardNumber.charAt(i));
      }
      return sum;
  }
}

