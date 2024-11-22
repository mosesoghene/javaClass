import java.util.Scanner;

public class AnnualIncomePercentage {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter annual income: \n> ");
		int annualIncome = scan.nextInt();

		if (annualIncome > 0 && annualIncome <= 9875) {
		  System.out.println("10%");
		} else if (annualIncome >= 9876 && annualIncome <= 40125) {
		  System.out.println("12%");
		} else if (annualIncome >= 40126 && annualIncome <= 85525) {
		  System.out.println("22%");
		}	else if (annualIncome >= 85526) {
		  System.out.println("24%");
		}
	}
}
