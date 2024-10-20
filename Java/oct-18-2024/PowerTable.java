public class PowerTable{
  public static void main(String[] args){
    int baseNumber = 1;
    int exponent = 2;
    
    int initialPower = 1;
    int totalPower = 1;
    
    int loopCount = 1;
    System.out.print("a\tb\tpow(a, b)\n");
    System.out.println("-------------------------");
    
    while (loopCount <= 5){
      while (initialPower <= exponent){
        totalPower *= baseNumber;
        initialPower += 1;
      }
      System.out.printf("%d\t%d\t%d%n", baseNumber, exponent, totalPower);
      
      baseNumber += 1;
      exponent += 1;
      
      initialPower = 1;
      totalPower = 1;
      
      loopCount += 1;
    }
  }
}
