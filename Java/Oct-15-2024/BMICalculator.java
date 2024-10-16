import java.util.Scanner;

public class BMICalculator {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter height value(in pounds) >> ");
    int height = scanner.nextInt();
    
    System.out.print("Enter weight value(in inches) >> ");
    int weight = scanner.nextInt();
    
    int bmi = (weight * 703) / (height * height);
    
    System.out.printf("Current BMI: %d%n", bmi);
    
    if (bmi < 18){
      System.out.println("BMI Category: UNDERWEIGHT");
    } else if (bmi > 18 && bmi < 25) {
      System.out.println("BMI Category: NORMAL WEIGHT");
    } else if (bmi > 25 && bmi < 30) {
      System.out.println("BMI Category: OVERWEIGHT");
    } else {
      System.out.println("BMI Category: OBESITY");
    }
  }
}
