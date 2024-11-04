import java.util.Scanner;

public class TwoLargest{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    int largest = 0;
    int nextLargest = 0;
    int count = 10;
    do {
      System.out.print("Enter a number \n>  ");
      int number = scan.nextInt();
      if (number > largest) {
        nextLargest = largest;
        largest = number;
        
      } 
      
      count--;
    } while (count > 0);
    
    System.out.printf("Largest: %d, \nSecond Largest: %d\n", largest, nextLargest);
  }
}
