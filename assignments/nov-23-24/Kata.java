import java.util.Arrays;
public class Kata{
  public static void main(String... args){
    int[] array = {1,2,3,5,4};
    String[] stringArray = {"a", "b", "d", "c"};
    
    System.out.println(getArrayMaxNumber(array));
    
    System.out.println(Arrays.toString(reverseArray(array)));
    System.out.println(Arrays.toString(reverseArray(stringArray)));
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
}