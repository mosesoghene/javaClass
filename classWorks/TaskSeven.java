public class TaskSeven{
  public static void main(String[] args){
  long base;
  long newBase = 1;
  int sum = 0;
    for (int i = 1; i <= 10; i++){
      if (i % 4 == 0) {
        for (int j = 1; j <= 5; j++) {        
          base = i;
          newBase = 1 * base * newBase;
          sum += newBase;
        }
        System.out.print(sum + " ");
        sum = 0;
        newBase = 1;
      }      
    }
    System.out.println();
  }
}
