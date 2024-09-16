package bank.service.impl;

import bank.entity.Bank;
import bank.entity.PaymentAccount;
import bank.entity.User;
import bank.service.PaymentAccountService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private Map<Integer, PaymentAccount> paymentAccounts;

    public PaymentAccountServiceImpl() {
        this.paymentAccounts = new HashMap<>();
    }

    @Override
    public PaymentAccount createPaymentAccount(int id, User user, double amount) {
        // Создаем платежный счет с пустым названием банка, чтобы пройти проверку компилятора
        PaymentAccount newPaymentAccount = new PaymentAccount(id, user, null, amount); // Заменяем "" на null
        paymentAccounts.put(id, newPaymentAccount);
        System.out.println("Платежный счет успешно создан.");
        return newPaymentAccount;
    }

    @Override
    public void updatePaymentAccount(int id, User user, double amount) {
        if (paymentAccounts.containsKey(id)) {
            PaymentAccount paymentAccountToUpdate = paymentAccounts.get(id);
            paymentAccountToUpdate.setUser(user);
            paymentAccountToUpdate.setAmount(amount);
            System.out.println("Платежный счет успешно обновлен.");
        }
    }

    @Override
    public void deletePaymentAccount(int id) {
        paymentAccounts.remove(id);
        System.out.println("Платежный счет успешно удален.");
    }

    @Override
    public PaymentAccount getPaymentAccountById(int id) {
        PaymentAccount paymentAccount = paymentAccounts.get(id);
        if (paymentAccount == null) {
            System.out.println("Ошибка: Платежный счет с таким идентификатором не найден.");
        }
        return paymentAccount;
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccountsByUser(User user) {
        List<PaymentAccount> userPaymentAccounts = new ArrayList<>();
        for (PaymentAccount account : paymentAccounts.values()) {
            if (account.getUser().equals(user)) {
                userPaymentAccounts.add(account);
            }
        }
        return userPaymentAccounts;
    }

    @Override
    public PaymentAccount[] getPaymentAccounts() {
        return paymentAccounts.values().toArray(new PaymentAccount[paymentAccounts.size()]);
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccounts() {
        return new ArrayList<>(paymentAccounts.values());
    }
}
