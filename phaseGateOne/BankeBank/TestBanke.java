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
  
  @Test
  public void testThatGetAccountNumberReturnsAccountNumber(){    
    Account account = new Account("Moses", "Oghene", "1234");
    String accountNumber = account.getAccountNumber();
    assertTrue(accountNumber instanceof String);
  }
  
  @Test
  public void testThatLengthOfAccountNumberIsTen(){
    Account account = new Account("Moses", "Oghene", "1234");
    String accountNumber = account.getAccountNumber();
    assertTrue(accountNumber.length() == 10);
  }
  
  @Test
  public void testThatWithdrawalReturnsSuccessForWithdrawalsLowerThanBalance(){
    Account account = new Account("Moses", "Oghene", "1234");    
    account.deposit(1203.4);
    String response = account.withdraw(500);
    assertEquals(response, "Withdrawal successful");
  }
  
  @Test
  public void testThatWithdrawalReturnsFailureForWithdrawalsHigherThanBalance(){
    Account account = new Account("Moses", "Oghene", "1234");    
    account.deposit(1203.4);
    
    String response = account.withdraw(5000);
    assertEquals(response, "Insufficient account balance");
  }
  
  @Test
  public void testThatChnagePinReturnsFailureForIncorrectOldPin(){
    Account account = new Account("Moses", "Oghene", "1234");    
    String response = account.changePin("1243", "1245");
    assertEquals(response, "Old pin incorrect");
  }
  
  @Test
  public void testThatChangePinReturnsSuccessForCorrectOldPin(){
    Account account = new Account("Moses", "Oghene", "1234");    
    String response = account.changePin("1234", "1245");
    assertEquals(response, "Pin successfully changed");
  }
}
