import java.util.Scanner;

public class WeekDay {
	public static void main(String[] args) {
	  for (int i = 1; i <= 9; i++){
	    for (int j = 1; j <= 9; j++ ){
	      System.out.print("%d x %d = %d\t", j, i, j * i);
	    }
	  }
	}
}
