public class SumOfNaturalNumbers {
	public static void main(String[] args) {
		int counter = 1;
		int sum = 0;

		while (counter <= 10) {

			sum += counter;
			counter++;
		}

		System.out.println("The sum of first 10 positive natural numbers are: " + sum);
	}
}
