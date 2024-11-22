public class TaskSixWhile{
  public static void main(String[] args){
    int i = 1;
    int stop = 10;
    
    int j = 1;
    int step = 5;
    
    while (i <= stop){
      while (j <= step){
      
        if (i % 4 == 0) {
          System.out.print(i);
        }
        j++;
      }
      
      i++;
    }
    
  }
}
