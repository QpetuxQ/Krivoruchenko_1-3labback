package bank.service.impl;

import bank.Main;
import bank.entity.CreditAccount;
import bank.entity.Employee;
import bank.entity.PaymentAccount;
import bank.entity.User;
import bank.service.CreditAccountService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditAccountServiceImpl implements CreditAccountService {
    private Map<Integer, CreditAccount> creditAccounts;

    public CreditAccountServiceImpl() {
        this.creditAccounts = new HashMap<>();
    }

    @Override
    public CreditAccount createCreditAccount(int id, User user, String bankName, String startDate, String endDate, int months, double amount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        CreditAccount newCreditAccount = new CreditAccount(id, user, bankName, startDate, endDate, months, amount, monthlyPayment, interestRate, issuingEmployee, paymentAccount);
        creditAccounts.put(id, newCreditAccount);
        System.out.println("Кредитный счет успешно создан.");
        return newCreditAccount;
    }

    @Override
    public List<CreditAccount> getAllCreditAccountsByUser(User user) {
        List<CreditAccount> userCreditAccounts = new ArrayList<>();
        for (CreditAccount account : creditAccounts.values()) {
            if (account.getUser().equals(user)) {
                userCreditAccounts.add(account);
            }
        }
        return userCreditAccounts;
    }

    @Override
    public void updateCreditAccount(int id, User user, String bankName, String startDate, String endDate, int months, double amount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        if (creditAccounts.containsKey(id)) {
            CreditAccount accountToUpdate = creditAccounts.get(id);
            accountToUpdate.setUser(user);
            accountToUpdate.setBankName(bankName);
            accountToUpdate.setStartDate(startDate);
            accountToUpdate.setEndDate(endDate);
            accountToUpdate.setMonths(months);
            accountToUpdate.setAmount(amount);
            accountToUpdate.setMonthlyPayment(monthlyPayment);
            accountToUpdate.setInterestRate(interestRate);
            accountToUpdate.setIssuingEmployee(issuingEmployee);
            accountToUpdate.setPaymentAccount(paymentAccount);
            System.out.println("Кредитный счет успешно обновлен.");
        } else {
            throw new Main.CreditAccountNotFoundException("Кредитный счет с идентификатором " + id + " не найден.");
        }
    }

    @Override
    public void deleteCreditAccount(int id) {
        if (creditAccounts.containsKey(id)) {
            creditAccounts.remove(id);
            System.out.println("Кредитный счет успешно удален.");
        } else {
            throw new Main.CreditAccountNotFoundException("Кредитный счет с идентификатором " + id + " не найден.");
        }
    }

    @Override
    public CreditAccount getCreditAccountById(int id) {
        CreditAccount account = creditAccounts.get(id);
        if (account == null) {
            throw new Main.CreditAccountNotFoundException("Кредитный счет с идентификатором " + id + " не найден.");
        }
        return account;
    }

    @Override
    public List<CreditAccount> getAllCreditAccounts() {
        return new ArrayList<>(creditAccounts.values());
    }

    @Override
    public CreditAccount getCreditAccountByUserId(int userId) {
        for (CreditAccount account : creditAccounts.values()) {
            if (account.getUser().getId() == userId) {
                return account;
            }
        }
        throw new Main.CreditAccountNotFoundException("Кредитный счет для пользователя с идентификатором " + userId + " не найден.");
    }
}
