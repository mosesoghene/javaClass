public class SquareCubeTable {
  public static void main(String[] args) {
    System.out.println("--------------------------");
    System.out.printf("| Number | Square | Cube |%n");
    System.out.println("--------------------------");
    for(int n=0; n <= 10; n++) {
      System.out.printf("| %4d   | %4d   | %4d |%n",  n, n*n, n*n*n);
    }
    
    System.out.println("--------------------------");
  }
}
