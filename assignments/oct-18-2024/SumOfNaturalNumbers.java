public class SumOfNaturalNumbers{
  public static void main(String[] args){
    int sumOfNumbers = 0;
    
    for (int number = 1; number <= 10; number++){
      sumOfNumbers += number;
    }
    System.out.printf("Sum of first 10 natural numbers => '%d'%n", sumOfNumbers);
  }
}
