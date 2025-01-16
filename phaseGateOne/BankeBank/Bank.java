import java.util.Random;

public class Bank {
    private final String bankName;
    private final String bankCode;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankCode = generateBankCode();
    }

    private String generateBankCode() {
        StringBuilder bankCode = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++){
            bankCode.append(random.nextInt(0, 10));
        }
        return bankCode.toString();
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    @Override
    public String toString() {
        return getBankName();
    }
}
