import java.util.Scanner;

public class CreditCardValidator {
  
  
    public static boolean isValidLength(String cardNumber) {
        int length = cardNumber.length();
        return length >= 13 && length <= 16;
    }


}

