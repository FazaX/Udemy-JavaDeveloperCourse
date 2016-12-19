package test;

import com.fazax.udemy.BankAccount;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class BankAccountTest {

    private BankAccount bankAccount;

    @Before
    public void setUp() throws Exception {
        bankAccount = new BankAccount("John","Dow", 1000.0);
    }

    @Test
    public void getBalance() throws Exception {
        assertEquals(1000.00, bankAccount.getBalance(), 0);
    }

    @Test
    public void deposit() throws Exception {
        bankAccount.deposit(200.50, true);
        assertEquals(1200.5, bankAccount.getBalance(), 0);
    }

    @Test
    public void withdraw() throws Exception {
        bankAccount.withdraw(250.00, true);
        assertEquals(750.00, bankAccount.getBalance(), 0);
    }

    @Test
    public void newBankAccountShouldExist() {
        assertNotNull(bankAccount);
    }

}