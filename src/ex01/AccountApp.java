package ex01;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountApp {
    static void main() {
        Account contaGley = new Account("Gleydson Albuquerque", LocalDate.parse("1992-02-12"));
        Account contaAll = new Account("Allyne Albuquerque", LocalDate.parse("1990-07-05"));
        Account contaMar = new Account("Maria Heloisa Albuquerque", LocalDate.parse("2013-12-18"));

        contaGley.deposit(BigDecimal.valueOf(1000.99), LocalDate.parse("2026-01-15"));
        contaGley.transfer(BigDecimal.valueOf(300.05), LocalDate.parse("2026-01-17"), contaAll);
        System.out.println(contaGley.getTransactions());

        contaAll.withdraw(BigDecimal.valueOf(50), LocalDate.parse("2026-03-30"));
        contaAll.transfer(BigDecimal.valueOf(150.13), LocalDate.parse("2026-04-03"), contaMar);
        System.out.println(contaAll.getTransactions(LocalDate.parse("2026-01-01"), LocalDate.parse("2026-06-30")));

        System.out.println(contaMar.getTransactions());
    }
}
