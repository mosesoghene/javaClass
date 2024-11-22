public class TaskFiveWhile{
  public static void main(String[] args){
    int i = 1;
    int j = 1;
    
    while (i <= 10){
      if (i % 4 == 0) {
        while (j <= 5){        
          System.out.print(i + "");
          j++;
        }        
      }
      i++;
    }
    
    
  }
}
