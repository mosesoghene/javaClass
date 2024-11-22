public class MultiplicationTables {
	public static void main(String[] args) {
	  for (int i = 1; i <= 9; i++){
	    for (int j = 1; j <= 9; j++ ){
	      System.out.printf("%d x %d = %d\t", j, i, j * i);
	    }
	    System.out.println();
	  }
	  
	  System.out.println("Do while");
	  
	  int number = 1;
	  int times = 1;
	  
	  do {
	    do {
	      System.out.printf("%d x %d = %d\t", times, number, times * number);
	      times++;
	    } while (times <= 9);
	    
	    System.out.println();
	    number++;
	  } while (number <= 9);
	}
}
