import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPrimeNumbers{
  @Test
  public void testPrimeNumberReturnCorrectValue(){
    PrimeNumbers primeNumbers = new PrimeNumbers();
    int input = 19;
    int[] actual = primeNumbers.getPrimesOf(input);
    int[] expected = {2,3,5,7,11,13,17};
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void testPrimeNumbersThrowsExceptionForNegativeInput(){
    PrimeNumbers primeNumbers = new PrimeNumbers();
    int input = -19;
    assertThrows(IllegalArgumentException.class, () -> primeNumbers.getPrimesOf(input));
  }
  
}

// java -jar "junit-platform-console-standalone-1.11.3.jar" --class-path . --scan-classpath --include-classname
// javac -cp "junit-platform-console-standalone-1.11.3.jar"
