import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCreditCardValidator{
  @Test
  public void testThatIsValidLengthReturnCorrectResponse(){
    CreditCardValidator creditCard = new CreditCardValidator();
    assertTrue(creditCard.isValidLength("12345095678735"));
  }
  
  @Test
  public void testThatDetermineCardTypeReturnCorrectResult(){
    CreditCardValidator creditCard = new CreditCardValidator();
    assertEquals(creditCard.determineCardType("12345095678735"), "Invalid Card Type");
  }
  
  @Test
  public void testThatIsValidCardReturnsCorrectResponse(){
    CreditCardValidator creditCard = new CreditCardValidator();
    assertFalse(creditCard.isValidCard("12345095678735"));
  }

}
