package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.service.BankOfficeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankOfficeServiceImpl implements BankOfficeService {
    private Map<Integer, BankOffice> bankOffices;

    public BankOfficeServiceImpl() {
        this.bankOffices = new HashMap<>();
    }

    @Override
    public BankOffice createBankOffice(int id, String name, String address, boolean status, boolean atmPlacement, int numOfAtms, boolean creditService, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double rentCost, Bank bank) {
        if (bankOffices.containsKey(id)) {
            throw new IllegalArgumentException("Банковский офис с таким идентификатором уже существует.");
        }

        BankOffice bankOffice = new BankOffice(id, name, address, status, atmPlacement, numOfAtms, creditService, cashWithdrawal, cashDeposit, moneyAmount, rentCost, bank);
        bankOffices.put(id, bankOffice);
        return bankOffice;
    }

    @Override
    public void updateBankOffice(int id, String name, String address, boolean status, boolean atmPlacement, int numOfAtms, boolean creditService, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double rentCost, Bank bank) {
        BankOffice bankOffice = bankOffices.get(id);
        if (bankOffice != null) {
            bankOffice.setName(name);
            bankOffice.setAddress(address);
            bankOffice.setStatus(status);
            bankOffice.setAtmPlacement(atmPlacement);
            bankOffice.setNumOfAtms(numOfAtms);
            bankOffice.setCreditService(creditService);
            bankOffice.setCashWithdrawal(cashWithdrawal);
            bankOffice.setCashDeposit(cashDeposit);
            bankOffice.setMoneyAmount(moneyAmount);
            bankOffice.setRentCost(rentCost);
            bankOffice.setBank(bank);
        } else {
            System.out.println("Ошибка: Банковский офис с таким идентификатором не найден.");
        }
    }

    @Override
    public void deleteBankOffice(int id) {
        if (bankOffices.containsKey(id)) {
            bankOffices.remove(id);
        } else {
            System.out.println("Ошибка: Банковский офис с таким идентификатором не найден.");
        }
    }

    @Override
    public BankOffice getBankOffice(int id) {
        BankOffice bankOffice = bankOffices.get(id);
        if (bankOffice == null) {
            System.out.println("Ошибка: Банковский офис с таким идентификатором не найден.");
        }
        return bankOffice;
    }

    @Override
    public List<BankOffice> getAllBankOffices(Bank bank) {
        List<BankOffice> bankOfficesOfBank = new ArrayList<>();
        for (BankOffice bankOffice : bankOffices.values()) {
            if (bankOffice.getBank().equals(bank)) {
                bankOfficesOfBank.add(bankOffice);
            }
        }
        return bankOfficesOfBank;
    }

}
