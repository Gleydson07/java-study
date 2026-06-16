package ex01;

import java.time.LocalDate;

public class Transaction {
    protected LocalDate createdAt;
    protected TransactionType transactionType;
    protected Double value;
    protected Double balance;
    protected Integer targetAccountNumber;

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