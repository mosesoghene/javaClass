import java.util.Arrays;

public class FindArrayDuplicate{
  public static void main(String[] args){
    int[] arr = {1, 2, 3, 4, 3, 6, 2, 3};
    
    for (int i = 0; i < arr.length; i++){
      for (int j = 1; i < arr.length; i++){
        if (arr[i] == arr[j]){
          System.out.println(arr[j]);
        }
      }
    }
    
  }
  

}
