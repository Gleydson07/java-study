package ex01;

import java.time.LocalDate;

public class AccountApp {
    public static void main(String[] args) {
        Account contaA = new Account("Gleydson Albuquerque", LocalDate.parse("1992-02-12"));
        Account contaB = new Account("Allyne Albuquerque", LocalDate.parse("1990-07-05"));

        contaA.deposit(1000.00, LocalDate.parse("2026-01-15"));
        contaA.getTransactions();
    }
}
