package ex01;

import java.time.LocalDate;
import java.util.Random;

public class Account {
    private Random random = new Random();

    private int accountNumber;
    private int agency;
    private Boolean isEnabled;
    private String disabledReason;
    private String clientName;
    private LocalDate bornDate;
    private Double balance = 0.00;


    public Account(String clientName, LocalDate bornDate) {
        this.accountNumber = random.nextInt(10000000, 99999999);
        this.agency = random.nextInt(1000, 99999999);
        this.isEnabled = true;

        this.clientName = clientName;
        this.bornDate = bornDate;
    }

    protected void withdraw(Double value) {
        if (this.balance >= value) {
            this.balance = this.balance - value;
        }
    }

    protected void deposit(Double value) {
        this.balance = this.balance + value;
    }

    protected void transfer(Double value, Account account) {
        this.withdraw(value);
        account.deposit(value);
    }

    protected void deleteAccount(String reason) {
        this.isEnabled = false;
        this.disabledReason = reason;
    }

    protected String getAccountNumber() {
        return this.agency + "/" + this.accountNumber;
    }
}
