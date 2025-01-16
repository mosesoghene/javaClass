import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AccountTest {
    private Account account;
    @BeforeEach
    void setUp() {
        account = new Account("Moses", "Oghene", "1234", new Bank("Access"));
        account.deposit(1000);
    }

    @Test
    void getPin() {
        String pin = account.getPin();
        assertEquals("1234", pin);
    }

    @Test
    void deposit() {
        account.deposit(1000);
        assertEquals(2000, account.getBalance());
    }

    @Test
    void withdraw() {
        account.withdraw(200, "1234");
        assertEquals(800, account.getBalance());
    }

    @Test
    void getBalance() {
        assertEquals(1000, account.getBalance());
    }

    @Test
    void getAccountNumber() {
        assertEquals(10, account.getAccountNumber().length());
    }

    @Test
    void getFirstName() {
        assertTrue(account.getFirstName().equalsIgnoreCase("Moses"));
    }

    @Test
    void getLastName() {
        assertTrue(account.getLastName().equalsIgnoreCase("Oghene"));
    }

    @Test
    void getFullName() {
        assertTrue(account.getFullName().equalsIgnoreCase("Moses Oghene"));
    }

    @Test
    void changePin() {
        account.changePin("1234", "1242");
        assertEquals("1242", account.getPin());
    }
}