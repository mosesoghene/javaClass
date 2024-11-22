public class TaskFourWhile{
  public static void main(String[] args){
    int i = 1;
    int stop = 10;
    while (i <= stop){
      System.out.print((i % 4 == 0) ? i : " ");
      i++;
    }
  }
}
