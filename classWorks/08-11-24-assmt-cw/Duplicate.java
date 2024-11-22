import java.util.Arrays;

public class Duplicate {
	public static void main(String... args) {
		int[] number = {14, 67, 12, 12, 56, 6, 12, 67, 15, 8, 14, 9, 22, 6};
		int check = 0;
		int count = 0;
		int duplicate = 0;

		for (int row = 0; row < number.length; row++) {
			check = number[row];
			for (int counter = row + 1; counter < number.length; counter++) {
				if (number[counter] == check) {
					number[counter] = 0;
					duplicate++;
				}
			}
		} 

		for (int counter = 0; counter < number.length; counter++) {
			if (number[counter] != 0) {
				count += 1;
			}
		}

		int[] newNumber = new int[count];

		for (int counter = 0; counter < newNumber.length; counter++) {
			for (int checker : number) {
				if (checker != 0) {
					newNumber[counter] = checker;
				}
			}
		}
		System.out.printf("Number of duplicates is: %d%n", duplicate);
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(newNumber));
	}
}