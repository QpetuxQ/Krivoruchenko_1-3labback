package bank.service.impl;

import bank.entity.Bank;
import bank.service.BankService;

import java.util.ArrayList;
import java.util.List;

public class BankServiceImpl implements BankService {
    private List<Bank> banks;

    public BankServiceImpl() {
        this.banks = new ArrayList<>();
    }

    @Override
    public Bank createBank(String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfClients) {
        Bank newBank = new Bank(name, numOfOffices, numOfAtms, numOfEmployees, numOfClients);
        this.banks.add(newBank);
        System.out.println("Банк успешно создан.");
        return newBank;
    }

    @Override
    public void updateBank(int bankId, String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfClients) {
        Bank bankToUpdate = getBankById(bankId);
        if (bankToUpdate != null) {
            bankToUpdate.setName(name);
            bankToUpdate.setNumOfOffices(numOfOffices);
            bankToUpdate.setNumOfAtms(numOfAtms);
            bankToUpdate.setNumOfEmployees(numOfEmployees);
            bankToUpdate.setNumOfClients(numOfClients);
            System.out.println("Банк успешно обновлен.");
        } else {
            System.out.println("Ошибка: Банк не найден.");
        }
    }

    @Override
    public void deleteBank(int bankId) {
        Bank bankToDelete = getBankById(bankId);
        if (bankToDelete != null) {
            this.banks.remove(bankToDelete);
            System.out.println("Банк успешно удален.");
        } else {
            System.out.println("Ошибка: Банк не найден.");
        }
    }

    @Override
    public Bank getBankById(int bankId) {
        for (Bank bank : banks) {
            if (bank.getId() == bankId) {
                return bank;
            }
        }
        System.out.println("Ошибка: Банк не найден.");
        return null;
    }


    @Override
    public String getName(int bankId) {
        Bank bank = getBankById(bankId);
        return (bank != null) ? bank.getName() : null;
    }

    @Override
    public List<Bank> getAllBanks() {
        return banks;
    }
}
