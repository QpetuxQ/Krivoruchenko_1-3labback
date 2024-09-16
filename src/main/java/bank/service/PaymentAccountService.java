package bank.service;

import bank.entity.PaymentAccount;
import bank.entity.User;

import java.util.List;

/**
 * Интерфейс для управления платежными счетами.
 */
public interface PaymentAccountService {


    PaymentAccount createPaymentAccount(int id, User user, double amount);

    void updatePaymentAccount(int id, User user, double amount);

    void deletePaymentAccount(int id);


    PaymentAccount getPaymentAccountById(int id);

    List<PaymentAccount> getAllPaymentAccountsByUser(User user);

    PaymentAccount[] getPaymentAccounts();

    List<PaymentAccount> getAllPaymentAccounts();
}

