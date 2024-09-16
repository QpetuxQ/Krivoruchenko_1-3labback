package bank.service;

import bank.entity.Bank;
import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Интерфейс для управления банкоматами.
 */
public interface BankAtmService {


    List<BankAtm> getAllBankAtm();


    BankAtm createBankAtm(int id, String name, String status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenance, double moneyAmount);

    void deleteBankAtm(int id);

    void updateBankAtm(int id, String name, String status, BankOffice bankOffice, Employee serviceEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost);

    BankAtm getBankAtmById(int id);

    void updateBankAtm(int id, BankOffice bankOffice, double v);
}
