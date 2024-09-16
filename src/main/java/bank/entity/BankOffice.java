package bank.entity;

import java.util.ArrayList;
import java.util.List;

public class BankOffice {
    private BankAtm atm; // Поле для хранения банкомата в офисе
    private int id; // Идентификатор офиса
    private String name; // Название офиса
    private String address; // Адрес офиса
    private boolean status; // Статус офиса
    private boolean atmPlacement; // Можно ли разместить банкомат
    private int numOfAtms; // Кол-во банкоматов в офисе
    private boolean creditService; // Можно ли оформить кредит
    private boolean cashWithdrawal; // Работает ли на выдачу денег
    private boolean cashDeposit; // Можно ли внести деньги
    private double moneyAmount; // Кол-во денег в офисе
    private double rentCost; // Стоимость аренды банковского офиса
    private Bank bank; // Принадлежность к банку
    private List<Employee> employees; // Список сотрудников офиса
    private List<BankAtm> atms; // Список банкоматов офиса

    public BankOffice(int id, String name, String address, boolean status, boolean atmPlacement, int numOfAtms, boolean creditService, boolean cashWithdrawal, boolean cashDeposit, double moneyAmount, double rentCost, Bank bank) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.atmPlacement = atmPlacement;
        this.numOfAtms = numOfAtms;
        this.creditService = creditService;
        this.cashWithdrawal = cashWithdrawal;
        this.cashDeposit = cashDeposit;
        this.moneyAmount = moneyAmount;
        this.rentCost = rentCost;
        this.bank = bank;
        this.employees = new ArrayList<>();
        this.atms = new ArrayList<>();
    }
    private List<BankAtm> bankAtms;

    // Другие поля и методы класса

    public List<BankAtm> getBankAtms() {
        if (bankAtms == null) {
            bankAtms = new ArrayList<>(); // Создаем новый список, если он не был инициализирован
        }
        return bankAtms;
    }
    public void addBankAtm(BankAtm atm) {
        if (bankAtms == null) {
            bankAtms = new ArrayList<>();
        }
        bankAtms.add(atm);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAtmPlacement() {
        return atmPlacement;
    }

    public void setAtmPlacement(boolean atmPlacement) {
        this.atmPlacement = atmPlacement;
    }

    public int getNumOfAtms() {
        return numOfAtms;
    }

    public void setNumOfAtms(int numOfAtms) {
        this.numOfAtms = numOfAtms;
    }

    public boolean isCreditService() {
        return creditService;
    }

    public void setCreditService(boolean creditService) {
        this.creditService = creditService;
    }

    public boolean isCashWithdrawal() {
        return cashWithdrawal;
    }

    public void setCashWithdrawal(boolean cashWithdrawal) {
        this.cashWithdrawal = cashWithdrawal;
    }

    public boolean isCashDeposit() {
        return cashDeposit;
    }

    public void setCashDeposit(boolean cashDeposit) {
        this.cashDeposit = cashDeposit;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<BankAtm> getAtms() {
        return atms;
    }

    public void setAtms(List<BankAtm> atms) {
        this.atms = atms;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addAtm(BankAtm atm) {
        atms.add(atm);
    }

    @Override
    public String toString() {
        return "Банковский офис:{" +
                "идентификатор=" + id +
                ", название='" + name + '\'' +
                ", адрес='" + address + '\'' +
                ", статус=" + (status ? "открыт" : "закрыт") +
                ", банк=" + (bank != null ? bank.getName() : "Отсутствует") +
                '}';
    }

    public String getEmployeesInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Список сотрудников в офисе ").append(name).append(":\n");
        for (Employee employee : employees) {
            info.append(employee.toString()).append("\n");
        }
        return info.toString();
    }

    public String getAtmsInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Список банкоматов в офисе ").append(name).append(":\n");
        for (BankAtm atm : atms) {
            info.append(atm.toString()).append("\n");
        }
        return info.toString();
    }

    // Метод для установки банкомата в офисе
    public void setAtm(BankAtm atm) {
        this.atm = atm;
    }

    // Метод для получения банкомата из офиса
    public BankAtm getAtm() {
        return atm;
    }

    public void removeBankAtm(BankAtm atm) {
        atms.remove(atm);
    }

}
