package ex01;

import java.time.LocalDate;

enum TransactionType {
    DEPOSIT, WITHDRAW
}

public class Transaction {
    private LocalDate createdAt;
    private TransactionType transactionType;
    private Double value = 0.00;
    private Double balance = 0.00;
    private Account targetAccount;

    protected void setTransaction(
            LocalDate date,
            TransactionType transactionType,
            Double value,
            Double balance,
            Account targetAccount
    ) {
        this.createdAt = date;
        this.transactionType = transactionType;
        this.value = value;
        this.balance = balance;
        this.targetAccount = targetAccount;
    }

    protected String getTransaction() {
        System.out.println("Data: " + this.createdAt);
        System.out.println("Tipo: " + this.transactionType);
        System.out.println("Valor: " + this.value);
        System.out.println("Saldo: " + this.balance);
        System.out.println("Agencia/Conta: " + this.targetAccount.getAccountNumber());
    }
}
