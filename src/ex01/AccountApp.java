package ex01;

import java.time.LocalDate;

public class AccountApp {
    static void main() {
        Account contaA = new Account("Gleydson Albuquerque", LocalDate.parse("1992-02-12"));
        Account contaB = new Account("Allyne Albuquerque", LocalDate.parse("1990-07-05"));
        Account contaC = new Account("Maria Heloisa Albuquerque", LocalDate.parse("2013-12-18"));

        contaA.deposit(1000.00, LocalDate.parse("2026-01-15"));
        contaA.transfer(300.00, LocalDate.parse("2026-01-17"), contaB);
        contaA.getTransactions();

        contaB.withdraw(50.00, LocalDate.parse("2026-03-30"));
        contaB.transfer(150.00, LocalDate.parse("2026-04-03"), contaC);
        contaB.getTransactions(LocalDate.parse("2026-01-01"), LocalDate.parse("2026-06-30"));

        contaC.getTransactions();
    }
}
