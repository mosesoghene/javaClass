import java.util.Scanner;

public class NumberTriangle{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    System.out.print("Enter number between 1 and 10 \n>  ");
    int length = scan.nextInt();
    
    if (length > 0 && length <= 10){
      for (int rowA = 1; rowA <= length; rowA++) {
			  for (int colA = 1; colA <= rowA; colA++) {
				  System.out.print(colA);
			  }
			  System.out.println();
		  }
		  
		  for (int rowA = length-1; rowA >= 1; rowA--) {
			  for (int colA = 1; colA <= rowA; colA++) {
				  System.out.print(colA);
			  }
			  System.out.println();
		  }
		  
		} else {
		  System.out.println("NUMBER Out of range");
		}
		
    
  }
}
