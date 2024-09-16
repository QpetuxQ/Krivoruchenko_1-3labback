package bank.service.impl;

import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.BankAtmService;
import java.util.*;

public class BankAtmServiceImpl implements BankAtmService {

    private Map<Integer, BankAtm> bankAtms;

    public BankAtmServiceImpl() {
        this.bankAtms = new HashMap<>();
    }

    @Override
    public List<BankAtm> getAllBankAtm() {
        return new ArrayList<>(bankAtms.values());
    }

    @Override
    public BankAtm createBankAtm(int id, String name, String status, BankOffice bankOffice, String location, Employee servicingEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenance, double moneyAmount) {
        if (bankOffice != null && bankOffice.getBank() != null && bankOffice.getAtm() == null) {
            String atmStatus;
            if (status.equals("1")) {
                atmStatus = "Работает";
            } else if (status.equals("2")) {
                atmStatus = "Нет денег";
            } else if (status.equals("3")) {
                atmStatus = "Не работает";
            } else {
                throw new IllegalArgumentException("Некорректный статус банкомата");
            }

            BankAtm atm = new BankAtm(name, location, atmStatus, bankOffice.getBank(), bankOffice, servicingEmployee, cashWithdrawal, cashDeposit, maintenance, moneyAmount);
            atm.setId(id);
            bankOffice.setAtm(atm); // Добавляем банкомат к офису
            bankOffice.addBankAtm(atm); // Добавляем банкомат к списку банкоматов офиса
            bankAtms.put(id, atm); // Используем метод put для добавления в Map
            System.out.println("Банкомат успешно создан: " + atm);
            return atm;
        } else {
            System.out.println("Ошибка: Невозможно создать банкомат.");
            return null;
        }
}


    @Override
    public void deleteBankAtm(int id) {
        BankAtm atm = getBankAtmById(id);
        if (atm != null) {
            atm.getBankOffice().removeBankAtm(atm); // Удаляем банкомат из списка банкоматов офиса
            atm.getBankOffice().setAtm(null);
            atm.getBankOffice().getBank().decrementQuantityATM();
            bankAtms.remove(id); // Удаляем банкомат из Map по его ID
            System.out.println("Банкомат успешно удален.");
        } else {
            System.out.println("Ошибка: Банкомат не найден.");
        }
    }

    @Override
    public void updateBankAtm(int id, String name, String status, BankOffice bankOffice, Employee serviceEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost) {
        BankAtm atm = getBankAtmById(id);
        if (atm != null) {
            atm.setName(name);
            atm.setStatus(status);
            atm.setBankOffice(bankOffice);
            atm.setServiceEmployee(serviceEmployee);
            atm.setCashWithdrawal(cashWithdrawal);
            atm.setCashDeposit(cashDeposit);
            atm.setMaintenanceCost(maintenanceCost);
            System.out.println("Банкомат успешно обновлен.");
        } else {
            System.out.println("Ошибка: Банкомат не найден.");
        }
    }

    @Override
    public BankAtm getBankAtmById(int id) {
        return bankAtms.get(id); // Возвращаем значение из Map по ключу (ID)
    }

    @Override
    public void updateBankAtm(int id, BankOffice bankOffice, double newAmount) {
        // Найдите банкомат по его идентификатору
        BankAtm bankAtm = null;
        for (BankAtm atm : bankOffice.getBankAtms()) {
            if (atm.getId() == id) {
                bankAtm = atm;
                break;
            }
        }

        // Если банкомат не найден, вы можете выбрасывать исключение или выполнять другую логику
        if (bankAtm == null) {
            throw new RuntimeException("Банкомат с указанным идентификатором не найден.");
        }

        // Обновите сумму денег в банкомате
        bankAtm.setMoneyAmount(newAmount);
    }

}
