import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBanke{
  @Test
  public void testThatAccountWasDepositMethodDepositsToAccount(){
    Account account = new Account("Moses", "Oghene", "1234");
    account.deposit(1203.4);
    double expected = account.getBalance();
    assertEquals(expected, 1203.4);
  }
}
