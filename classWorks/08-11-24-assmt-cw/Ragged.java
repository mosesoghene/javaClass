import java.util.Arrays;

public class Ragged {
	public static void main(String... args) {

		int[][] myArray = new int[5][5];
		for (int count = 0; count < myArray.length; count++) {
			for (int counter = 0; counter < myArray[count].length; counter++) {
				myArray[count][counter] = (int) (Math.random() * 100);
			}
		}

		for (int count = 0; count < myArray.length; count++) {
			for (int counter = 0; counter < myArray[count].length; counter++) {
				System.out.print(myArray[count][counter] + " ");
			}
		}


		System.out.printf("%s", Arrays.deepToString(myArray));
	}
}