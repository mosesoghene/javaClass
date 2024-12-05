public class PrimeNumbers{
  public boolean isPrime(int number){
    if (number <= 1) return false;
    if (number == 2) return true;
    for (int i = 2; i < number; i++){
      if (number % i == 0) return false;
    }
    
    return true;
  }
  public int getPrimesCount(int number){
    int count = 0;
    for (int i = 1; i < number; i++){
      if (isPrime(i)) count++; 
    }
    return count;
  }
  public int[] getPrimesOf(int number){
    if (number <= 1) {
      String message = String.format("Invalid number input: %d greater than 1", number);
      throw new IllegalArgumentException(message);
    }
    
    int[] primes = new int[getPrimesCount(number)];
    int index = 0;
    for (int i = 1; i < number; i++){
      if (isPrime(i)) primes[index++] = i;
    }
    return primes;
  }
}
