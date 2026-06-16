package ex01;

import java.math.BigDecimal;
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
    private BigDecimal balance = BigDecimal.valueOf(0);
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String clientName, LocalDate bornDate) {
        Random random = new Random();

        this.accountNumber = random.nextInt(10000000, 99999999);
        this.agency = random.nextInt(1000, 9999);
        this.isEnabled = true;

        this.clientName = clientName;
        this.bornDate = bornDate;
    }

    public void withdraw(BigDecimal value, LocalDate date) {
        if (this.balance.compareTo(value) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }

        this.balance = this.balance.subtract(value);

        Transaction transaction = new Transaction(
            date,
            TransactionType.WITHDRAW,
            value.multiply(BigDecimal.valueOf(-1)),
            this.balance
        );
        transactions.add(transaction);
    }

    public void deposit(BigDecimal value, LocalDate date) {
        this.balance = this.balance.add(value);

        Transaction transaction = new Transaction(
            date,
            TransactionType.DEPOSIT,
            value,
            this.balance
        );
        transactions.add(transaction);
    }

    public void transfer(BigDecimal value, LocalDate date, Account targetAccount) {
        if (this.balance.compareTo(value) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }

        this.balance = this.balance.subtract(value);

        Transaction transactionOut = new Transaction(
            date,
            TransactionType.WITHDRAW,
            value.multiply(BigDecimal.valueOf(-1)),
            this.balance,
            targetAccount.accountNumber
        );
        transactions.add(transactionOut);

        targetAccount.balance.add(value);
        targetAccount.transactions.add(new Transaction(
            date,
            TransactionType.DEPOSIT,
            value,
            targetAccount.balance,
            this.accountNumber
        ));
    }

    public void deleteAccount(String reason) {
        this.isEnabled = false;
        this.disabledReason = reason;
    }

    public String getAccountNumber() {
        return "Agencia/Conta: " + this.agency + "/" + this.accountNumber;
    }

    public String getTransactions() {
        return this.getTransactions(null, null);
    }

    public String getTransactions(LocalDate startDate, LocalDate endDate) {
        String result = transactions.stream()
            .filter(t -> startDate == null || !t.createdAt.isBefore(startDate))
            .filter(t -> endDate == null || !t.createdAt.isAfter(endDate))
            .map(t -> "Data: " + t.createdAt +
                " | Tipo: " + t.transactionType +
                " | Valor: " + t.value +
                " | Saldo: " + t.balance +
                " | Conta: " + t.targetAccountNumber + "\n")
            .collect(Collectors.joining());

        return "Cliente: " + this.clientName + "\n"+
            "Agencia/Conta: " + this.agency + "/" + this.accountNumber + "\n" +
            result;
    }
}
