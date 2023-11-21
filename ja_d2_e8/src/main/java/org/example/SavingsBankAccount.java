package org.example;

public record SavingsBankAccount(
         Client client,
         double balance,
         String accountNumber,
         int term
) implements BankAccount {

    @Override
    public Client getClient() {
        return client();
    }

    @Override
    public String toString() {
        return "SavingsBankAccount{" +
                "client=" + client +
                ", balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", term=" + term +
                '}';
    }
}
