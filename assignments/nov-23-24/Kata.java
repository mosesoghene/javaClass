import java.util.Arrays;
public class Kata{
  public static void main(String... args){
    int[] array = {1,2,3,5,4};
    double[] dArray = {1.0,2.0,3.0,5.0,4.0};
    String[] stringArray = {"a", "b", "d", "c", "e"};
    
    System.out.println(getArrayMaxNumber(array));
    
    System.out.println(Arrays.toString(reverseArray(array)));
    System.out.println(Arrays.toString(reverseArray(stringArray)));
    System.out.println(existsIn(array, 2));
    System.out.println(existsIn(array, 6));
    System.out.println(existsIn(stringArray, "a"));
    System.out.println(existsIn(stringArray, "f"));
    
    printOddElements(array);
    printOddElements(stringArray);
    printEvenElements(array);
    printEvenElements(stringArray);
    
    System.out.println();
    System.out.println(sumOfArray(dArray));
    
    System.out.println(isPalindrome("toot"));
    
    System.out.println(isPalindrome(45154));
    
    System.out.println(Arrays.toString(joinArray(array, array)));
    System.out.println(Arrays.toString(joinArrayAltElemtnts(array, array)));
    System.out.println(Arrays.toString(toIntArray(2342)));
    
    System.out.println(isEven(2342.0));
    System.out.println(isPrime(4));
    System.out.println(subtract(7, 3));
    System.out.println(factorOf(10));
    System.out.println(isSquare(9));    
    System.out.println(isPalindrome(45155));
    System.out.println(factorialOf(5));
    System.out.println(squareOf(5));
  }
  
  public static int getArrayMaxNumber(int[] array){
    int maxNumber = array[0];
    for(int number: array){
      if (number > maxNumber) maxNumber = number;
    }
    return maxNumber;
  }
  
  public static int[] reverseArray(int[] array){
    int[] reversedArray = new int[array.length];
    for(int i = 0; i < array.length; i++){
      int index = array.length - 1 - i;
      reversedArray[i] = array[index];
    }
    return reversedArray;
  }
  
  public static String[] reverseArray(String[] array){
    String[] reversedArray = new String[array.length];
    for(int i = 0; i < array.length; i++){
      int index = array.length - 1 - i;
      reversedArray[i] = array[index];
    }
    return reversedArray;
  }
  
  public static boolean existsIn(int[] array, int element){
    for(int i = 0; i < array.length; i++){
      if (element == array[i]) return true;
    }
    return false;
  }
  
  public static boolean existsIn(String[] array, String element){
    for(int i = 0; i < array.length; i++){
      if (element == array[i]) return true;
    }
    return false;
  }
  
  public static void printOddElements(int[] array){
    for(int i = 0; i < array.length; i += 2){
      System.out.println(array[i]);
    }
  }
  
  public static void printOddElements(String[] array){
    for(int i = 0; i < array.length; i += 2){
      System.out.println(array[i]);
    }
  }
  
  public static void printEvenElements(int[] array){
    for(int i = 1; i < array.length; i += 2){
      System.out.println(array[i]);
    }
  }
  
  public static void printEvenElements(String[] array){
    for(int i = 1; i < array.length; i += 2){
      System.out.println(array[i]);
    }
  }
  
  public static int sumOfArray(int[] array){
    int total = 0;
    for(int i = 0; i < array.length; i++){
      total += array[i];
    }
    return total;
  }
  
  public static double sumOfArray(double[] array){
    double total = 0.0;
    for(int i = 0; i < array.length; i++){
      total += array[i];
    }
    return total;
  }
  
  public static int sumOfArrayWhile(int[] array){
    int index = 0;
    int total = 0;
    while(index < array.length){
      total += array[index];
      index++;
    }
    return total;
  }
  
  public static double sumOfArrayWhile(double[] array){
    int index = 0;
    double total = 0.0;
    while(index < array.length){
      total += array[index];
      index++;
    }
    return total;
  }
  
  public static int sumOfArrayDoWhile(int[] array){
    int index = 0;
    int total = 0;
    do {
      total += array[index];
      index++;
    }while(index < array.length);
    return total;
  }
  
  public static double sumOfDoWhileArray(double[] array){
    int index = 0;
    double total = 0.0;
    do {
      total += array[index];
      index++;
    }while(index < array.length);
    return total;
  }
  
  public static boolean isPalindrome(String string){
    char[] stringChars = string.toCharArray();
    for (int i = 0; i < stringChars.length; i++){
      if(stringChars[i] != stringChars[stringChars.length - i-1]) return false;
    }
    return true;
  }
  
  public static int[] joinArray(int[] arrayA, int[] arrayB){
    int[] newArray = new int[arrayA.length + arrayB.length];
    for(int i = 0; i < arrayA.length; i++){
      newArray[i] = arrayA[i];
    }
    for(int i = arrayA.length; i < newArray.length; i++){
      newArray[i] = arrayB[i - arrayA.length];
    }
    return newArray;
  }
  
  public static int[] joinArrayAltElemtnts(int[] arrayA, int[] arrayB){
    int[] newArray = new int[arrayA.length + arrayB.length];
    int index = 0;
    for (int i = 0; i < Math.max(arrayA.length, arrayB.length); i++){
      if (i < arrayA.length) newArray[index++] = arrayA[i];
      if (i < arrayB.length) newArray[index++] = arrayB[i];
    }
    return newArray;
  }
  
  public static int[] toIntArray(int number){
    String numberToString = "" + number;
    char[] numbers = numberToString.toCharArray();
    int[] numberArray = new int[numbers.length];
    for(int i = 0; i < numberArray.length; i++) numberArray[i] = Character.digit(numbers[i], 10);
    return numberArray;
  }
  
  public static boolean isEven(int number){
    return (number % 2 == 0) ? true : false;
  }
  
  public static boolean isEven(double number){
    return (number % 2 == 0) ? true : false;
  }
  
  public static boolean isPrime(int number){
    if (number <= 1) return false;
    if (number == 2) return true;
    for (int i = 2; i < number; i++){
      if (number % i == 0) return false;
    }
    return true;
  }
  
  public static int subtract(int x, int y){
    return Math.abs(x - y);
  }
  
  public static int divide(int x, int y){
    if (y == 0) return y;
    return x / y;
  }
  
  public static int factorOf(int number){
    int count = 0;
    for (int i = 1; i <= number; i++) if (number % i == 0) count += 1;
    return count;
  }
  
  public static boolean isSquare(int number){
    for (int i = 1; i < number; i++)
      if (i * i == number) return true;
    return false;
  }
  
  public static boolean isPalindrome(int number){
    String numberToString = "" + number;
    char[] stringChars = numberToString.toCharArray();
    for (int i = 0; i < stringChars.length; i++){
      if(stringChars[i] != stringChars[stringChars.length - i-1]) return false;
    }
    return true;
  }
  
  public static long factorialOf(int number){
    long factorial = 1;
    for (int i = number; i > 0; i--) factorial *= i;
    return factorial;
  }
  
  public static long squareOf(int number){
    return number * number;
  }
}
