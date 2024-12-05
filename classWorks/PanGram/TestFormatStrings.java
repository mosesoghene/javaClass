import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFormatStrings{

  @Test
  public void testThatCapitalizeReturnsCorrectValue(){
    FormatStrings format = new FormatStrings();
    String input = "The quick brown fox juMps over the lazy dog";
    
    String expected = "The Quick Brown Fox Jumps Over The Lazy Dog";
    assertEquals(expected, format.capitalize(input));
  }
  
  @Test
  public void testThatCapitalizeReturnsCorrectValue2(){
    FormatStrings format = new FormatStrings();
    String input = "The quick brown fox jumps over the lazy dog _23";
    
    String expected = "The Quick Brown Fox Jumps Over The Lazy Dog _23";
    assertEquals(expected, format.capitalize(input));
  }
}
