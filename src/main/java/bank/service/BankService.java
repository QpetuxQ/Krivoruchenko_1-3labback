package bank.service;

import bank.entity.Bank;

import java.util.List;

/**
 * Интерфейс для управления банками.
 */
public interface BankService {

    Bank createBank(String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfClients);

    void updateBank(int bankId, String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfClients);

    void deleteBank(int bankId);

    Bank getBankById(int bankId);



    public String getName(int bankId) ;

    public List<Bank> getAllBanks();
}


