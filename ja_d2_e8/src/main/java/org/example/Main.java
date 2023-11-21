package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 Client

 String name
 String address
 String email

 DebitBankAccount

 Client client
 double balance
 String accountNumber
 String cardNumber
 double withDrawalLimit

 SavingsBankAccount

 Client client
 double balance
 String accountNumber
 int term

 You need to define a list with at least 10 bank accounts and implement the following
 requirements using Streams API:

 1. Create a method that receives the list of bank accounts and a client email as parameters. It
 returns the number of bank accounts belonging to that client email.
 2. Create a method that receives the list of bank accounts. It prints in the console the name and
 email address of each unique clients.
 3. Create a method that receives the list of bank accounts. It prints in the console the details of
 the savings bank accounts, in the order of their balance, from the highest to the lowest balance.
 4. Create a method that receives the list of bank accounts as parameter. It returns the number
 of bank account hold by each client.
 5. Create a method that receives the list of bank accounts. It prints in the console the details of
 each unique client, ordered by name alphabetically.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static long countBankAccountForClient(List<BankAccount> bankAccounts, String clientEmail) {
        return bankAccounts.stream()
                .filter(a -> a.getClient().email().equalsIgnoreCase(clientEmail))
                .count();
    }

    public static void printUniqueClients(List<BankAccount> bankAccounts) {
        bankAccounts.stream()
                .map(a -> a.getClient())
                .distinct()
                .forEach(c -> System.out.println(c.name() + " " + c.email()));
    }

    public static void printSavingBankAccounts(List<BankAccount> bankAccounts) {

        bankAccounts.stream()
                .filter(a -> a instanceof SavingsBankAccount)
                .map(a -> (SavingsBankAccount) a)
                .sorted(Comparator.comparingDouble(SavingsBankAccount::balance).reversed())
                .forEach(a -> System.out.println(a));

    }

    public static Map<String, Long> countBankAccountsPerClient(List<BankAccount> bankAccounts) {
        return bankAccounts.stream()
                .collect(Collectors.groupingBy(a -> a.getClient().email(),
                                Collectors.counting()));
    }

    public static void printUniqueClientsSorted(List<BankAccount> bankAccounts) {
        bankAccounts.stream()
                .map(a -> a.getClient())
                .distinct()
                .sorted(Comparator.comparing(Client::name))
                .forEach(c -> System.out.println(c));
    }
}