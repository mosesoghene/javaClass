import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestBanke{
  @Test
  public void testThatAccountWasDepositMethodDepositsToAccount(){
    Account account = new Account("Moses", "Oghene", "1234", new Bank("Access"));
    account.deposit(1203.4);
    double expected = account.getBalance();
    assertEquals(expected, 1203.4);
  }
  
  @Test
  public void testThatGetAccountNumberReturnsAccountNumber(){    
    Account account = new Account("Moses", "Oghene", "1234", new Bank("Access"));
    String accountNumber = account.getAccountNumber();
    assertTrue(accountNumber instanceof String);
  }
  
  @Test
  public void testThatLengthOfAccountNumberIsTen(){
    Account account = new Account("Moses", "Oghene", "1234", new Bank("Access"));
    String accountNumber = account.getAccountNumber();
    assertTrue(accountNumber.length() == 10);
  }
  
  @Test
  public void testThatWithdrawalReturnsSuccessForWithdrawalsLowerThanBalance(){
    Account account = new Account("Moses", "Oghene", "1234", new Bank("Access"));
    account.deposit(1203.4);
    boolean response = account.withdraw(500, "1234");
      assertTrue(response);
  }
  
  @Test
  public void testThatWithdrawalReturnsFailureForWithdrawalsHigherThanBalance(){
    Account account = new Account("Moses", "Oghene", "1234", new Bank("Access"));
    account.deposit(1203.4);
    
    boolean response = account.withdraw(5000, "1234");
    assertTrue(response);
  }
  
  @Test
  public void testThatChnagePinReturnsFailureForIncorrectOldPin(){
    Account account = new Account("Moses", "Oghene", "1234", new Bank("Access"));
    boolean response = account.changePin("1243", "1245");
    assertFalse(response);
  }
  
  @Test
  public void testThatChangePinReturnsSuccessForCorrectOldPin(){
    Account account = new Account("Moses", "Oghene", "1234", new Bank("Access"));
    boolean response = account.changePin("1234", "1245");
    assertTrue(response);
  }
}
