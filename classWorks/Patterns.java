public class Patterns{
  public static void main(String[] args){
    System.out.println("Pattern A");
    
    for (int rowA = 1; rowA <= 6; rowA++) {
			for (int colA = 1; colA <= rowA; colA++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
    
    System.out.println("pattern B");
		
		for (int rowB = 1; rowB <= 6; rowB++) {
			for (int colB = 6; colB >= rowB; colB--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("pattern C");
		for (int rowC = 6; rowC >= 1; rowC--) {
			for (int space = 1; space <= 6 - rowC; space++) {
				System.out.print(" ");
      }
            
  		for (int colC = 1; colC <= rowC; colC++) {
     			 System.out.print("*");
 		 }
			System.out.println();
		}
			System.out.println();
			
		System.out.println("pattern D");
		for (int rowD = 1; rowD <= 6; rowD++) {
			for (int spaceD = 1; spaceD <= 6 - rowD; spaceD++) {
				System.out.print(" ");
      }
			for (int colD = 1; colD <= rowD; colD++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
  }
}
