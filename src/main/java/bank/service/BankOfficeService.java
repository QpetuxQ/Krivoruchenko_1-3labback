package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс для управления банковскими офисами.
 */
public interface BankOfficeService {


    BankOffice createBankOffice(int id, String name, String address, boolean status, boolean atmPlacement, int numOfAtms, boolean creditService, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double rentCost, Bank bank);

    void updateBankOffice(int id, String name, String address, boolean status, boolean atmPlacement, int numOfAtms, boolean creditService, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double rentCost, Bank bank);

    void deleteBankOffice(int id);

    BankOffice getBankOffice(int id);


    List<BankOffice> getAllBankOffices(Bank bank);
}
