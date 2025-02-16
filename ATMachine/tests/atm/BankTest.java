package atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {
    private Bank bank;

    @BeforeEach
    void createNewBank() {
        bank = new Bank();
    }

    @Test
    public void addAccountX_findAccountX_returnsAccountX_bankTest(){
        bank.addAccount("Moses Oghene", AccountType.SAVINGS);
        assertEquals("Moses Oghene", bank.findAccount());
    }
}
