import java.util.Scanner;

public class CreditCardValidator {
  
  
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
}

