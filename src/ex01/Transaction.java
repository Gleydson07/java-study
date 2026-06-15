package ex01;

import java.time.LocalDate;

public class Transaction {
    private LocalDate createdAt;
    private TransactionType transactionType;
    private Double value;
    private Double balance;
    private Integer targetAccountNumber;

    public Transaction(
        LocalDate createdAt,
        TransactionType transactionType,
        Double value,
        Double balance,
        Integer targetAccount
    ) {
        this.createdAt = createdAt;
        this.transactionType = transactionType;
        this.value = value;
        this.balance = balance;
        this.targetAccountNumber = targetAccount;
    }

    public Transaction(
        LocalDate createdAt,
        TransactionType transactionType,
        Double value,
        Double balance
    ) {
        this.createdAt = createdAt;
        this.transactionType = transactionType;
        this.value = value;
        this.balance = balance;
    }
}