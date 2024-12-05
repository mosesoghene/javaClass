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

