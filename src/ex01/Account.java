package ex01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Account {
    private int accountNumber;
    private int agency;
    private Boolean isEnabled;
    private String disabledReason;
    private String clientName;
    private LocalDate bornDate;
    private Double balance = 0.00;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String clientName, LocalDate bornDate) {
        Random random = new Random();

        this.accountNumber = random.nextInt(10000000, 99999999);
        this.agency = random.nextInt(1000, 99999999);
        this.isEnabled = true;

        this.clientName = clientName;
        this.bornDate = bornDate;
    }

    protected void withdraw(Double value, LocalDate date) {
        if (this.balance >= value) {
            this.balance = this.balance - value;

            Transaction transaction = new Transaction(
                date,
                TransactionType.WITHDRAW,
                value * -1,
                this.balance
            );
            transactions.add(transaction);
        }
    }

    protected void deposit(Double value, LocalDate date) {
        this.balance = this.balance + value;

        Transaction transaction = new Transaction(
            date,
            TransactionType.DEPOSIT,
            value,
            this.balance
        );
        transactions.add(transaction);
    }

    protected void transfer(Double value, LocalDate date, Account targetAccount) {
        if (this.balance >= value) {
            this.balance = this.balance - value;

            Transaction transactionOut = new Transaction(
                date,
                TransactionType.WITHDRAW,
                value * -1,
                this.balance,
                targetAccount.accountNumber
            );
            transactions.add(transactionOut);

            targetAccount.balance += value;
            targetAccount.transactions.add(new Transaction(
                date,
                TransactionType.DEPOSIT,
                value,
                targetAccount.balance,
                this.accountNumber
            ));
        }
    }

    protected void deleteAccount(String reason) {
        this.isEnabled = false;
        this.disabledReason = reason;
    }

    protected String getAccountNumber() {
        return this.agency + "/" + this.accountNumber;
    }

    protected void getTransactions() {
        String result = transactions.stream()
            .map(t -> t.toString())
            .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
