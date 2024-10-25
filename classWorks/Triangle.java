import java.util.Scanner;
import java.lang.Math;

public class Triangle {
  public static void main(String[] args){
    System.out.print("Enter the length of the sides and height of the equilateral triangle: ");
    Scanner input = new Scanner(System.in);
    
    double triangle_length = input.nextDouble();
    double triangle_area = (Math.sqrt(3) * (triangle_length * triangle_length)) /4;
    double triangle_volume = triangle_area * triangle_length;
    
    System.out.printf("The area is %.2f %nThe volume of the triangular prism is %.2f%n", triangle_area, triangle_volume);
  }
}

