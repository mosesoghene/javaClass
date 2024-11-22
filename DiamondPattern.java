public class DiamondPattern{
  public static void main(String[] args){
    int maxLength = 3;
    
    for (int row = maxLength; row >= 1; row--){
      for (int space = row / 2; space >= row / 2; space++){
        System.out.print("");
      }
      System.out.print("*");
    }
  }
}
