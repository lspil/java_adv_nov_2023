package org.example;

public record DebitBankAccount(
        Client client,
        double balance,
        String accountNumber,
        String cardNumber,
        double withdrawalLimit
) implements BankAccount {
    @Override
    public Client getClient() {
        return client();
    }
}
