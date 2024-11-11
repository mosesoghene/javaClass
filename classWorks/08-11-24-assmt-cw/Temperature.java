import java.util.Scanner;

public class Temperature {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter temperature in celcius:\n> ");
		int temperature = input.nextInt();

		System.out.println((temperature < 10) ? "Cold" : (temperature >= 10 && temperature <= 25) ? "Warm" : "Hot");
	}
}
