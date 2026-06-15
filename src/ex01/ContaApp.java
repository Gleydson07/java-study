package ex01;

public class ContaApp {
    public static void main(String[] args) {
        Account minhaConta = new Account();

        minhaConta.extrato();

        minhaConta.depositar(100.00);
        minhaConta.extrato();

        minhaConta.sacar(30.25);
        minhaConta.extrato();
    }
}
