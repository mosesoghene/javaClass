import java.util.Arrays;

public class ReverseArray{
  public static void main(String[] args){
    int[] arr = {1,2,3,4,5,6,8,7};
    System.out.println(Arrays.toString(arr));
    
    int newArray[] = new int[arr.length];
    newArray = reverseArray(arr);
    
    for (int i = 0; i < newArray.length; i++){
      arr[i] = newArray[i];
    }
    
    System.out.println(Arrays.toString(arr));
  }
  
  public static int[] reverseArray(int[] array){
    int[] reversedArray = new int[array.length];
    for (int i = 0; i < array.length; i++){
      reversedArray[i] = array[array.length - 1 - i];
    }
    return reversedArray;
  }
}
