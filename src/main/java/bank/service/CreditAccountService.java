package bank.service;

import bank.entity.CreditAccount;
import bank.entity.Employee;
import bank.entity.PaymentAccount;
import bank.entity.User;

import java.util.List;

/**
 * Интерфейс для управления кредитными счетами.
 */
public interface CreditAccountService {

    CreditAccount createCreditAccount(int id, User user, String bankName, String startDate, String endDate, int months, double amount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount);

    List<CreditAccount> getAllCreditAccountsByUser(User user);

    void updateCreditAccount(int id, User user, String bankName, String startDate, String endDate, int months, double amount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount);

    void deleteCreditAccount(int id);

    CreditAccount getCreditAccountById(int id);

    List<CreditAccount> getAllCreditAccounts();

    CreditAccount getCreditAccountByUserId(int userId); // Добавлен новый метод
}
