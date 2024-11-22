public class TaskTwoWhile{
  public static void main(String[] args){
    int i = 1;
    int stop = 10;
    while (i <= stop){
      System.out.print((i % 2 == 0) ? i : " ");
      i++;
    }
  }
}
