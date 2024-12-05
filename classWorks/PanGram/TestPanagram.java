import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestPanagram{

  @Test
  public void testThatIsPanagramReturnsTrue(){
    Panagram panagram = new Panagram();
    String input = "The quick brown fox jumps over the lazy dog 123";
    assertTrue(panagram.isPanagram(input));     
  }
  
  @Test
  public void testThatIsPanagramReturnsFalse(){
    Panagram panagram = new Panagram();
    String input = "The quick brown fox jumps over the lzzy dog";
    assertFalse(panagram.isPanagram(input));
  }
}
