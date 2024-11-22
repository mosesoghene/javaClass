public class DiamondPattern{
  public static void main(String[] args){
    int base = 6;
    int row, col;
    
    System.out.println("DIAMOND PATTERN");
    
    for (row = 1; row <= base; row++) {
			for (col = 1; col <= base - row; col++) {
				System.out.print(" ");
			}

			for (col = 1; col <= row * 2 - 1; col++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (row = base - 1; row > 0; row--) {
			for (col = 1; col <= base - row; col++) {
				System.out.print(" ");
			}

			for (col = 1; col <= row * 2 - 1; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
  }
}
