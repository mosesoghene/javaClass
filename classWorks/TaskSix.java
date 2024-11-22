public class TaskSix{
  public static void main(String[] args){
  long base;
  long newBase = 1;
  
    for (int i = 1; i <= 10; i++){
      if (i % 4 == 0) {
        for (int j = 1; j <= 5; j++) {        
          base = i;
          newBase = 1 * base * newBase;
          System.out.print(newBase + " ");
        }
        newBase = 1;
      }      
    }
    System.out.println();
  }
}
