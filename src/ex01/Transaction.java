package ex01;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction {
    LocalDate createdAt;
    TransactionType transactionType;
    BigDecimal value;
    BigDecimal balance;
    Integer targetAccountNumber;

    Transaction(
        LocalDate createdAt,
        TransactionType transactionType,
        BigDecimal value,
        BigDecimal balance,
        Integer targetAccount
    ) {
        this.createdAt = createdAt;
        this.transactionType = transactionType;
        this.value = value;
        this.balance = balance;
        this.targetAccountNumber = targetAccount;
    }

    Transaction(
        LocalDate createdAt,
        TransactionType transactionType,
        BigDecimal value,
        BigDecimal balance
    ) {
        this.createdAt = createdAt;
        this.transactionType = transactionType;
        this.value = value;
        this.balance = balance;
    }
}