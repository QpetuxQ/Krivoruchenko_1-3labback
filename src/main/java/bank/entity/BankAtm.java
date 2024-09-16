package bank.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAtm {

    private static final AtomicInteger nextId = new AtomicInteger(1); // Счетчик для генерации уникальных идентификаторов
    private int id; // Идентификатор банкомата
    private String name; // Название банкомата
    private String address; // Адрес банкомата (совпадает с адресом банковского офиса)
    private String status; // Статус банкомата (работает/не работает/нет денег)
    private Bank bank; // Банк, которому принадлежит банкомат
    private BankOffice bankOffice; // Банковский офис, в котором расположен банкомат
    private Employee serviceEmployee; // Обслуживающий сотрудник
    private boolean cashWithdrawal; // Работает ли на выдачу денег? (да/нет)
    private boolean cashDeposit; // Можно ли внести деньги? (да/нет)
    private double moneyAmount; // Количество денег в банкомате (напрямую зависит от поля «Всего денег в банке»)
    private double maintenanceCost; // Стоимость обслуживания банкомата
    private boolean maintenance; // Статус обслуживания банкомата
    /**
     * Конструктор класса BankAtm с параметрами.
     */
    public BankAtm(String name, String address, String status, Bank bank, BankOffice bankOffice, Employee serviceEmployee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost, double moneyAmount) {
        this.id = generateUniqueId();
        this.name = name;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.bankOffice = bankOffice;
        this.serviceEmployee = serviceEmployee;
        this.cashWithdrawal = cashWithdrawal;
        this.cashDeposit = cashDeposit;
        this.maintenanceCost = maintenanceCost;
        this.moneyAmount = moneyAmount;
    }

    private static int generateUniqueId() {
        return nextId.getAndIncrement();
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public Employee getServiceEmployee() {
        return serviceEmployee;
    }

    public void setServiceEmployee(Employee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
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

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Банкомат:{" +
                "идентификатор=" + id +
                ", название='" + name + '\'' +
                ", адрес='" + address + '\'' +
                ", статус='" + status + '\'' +
                ", банк=" + bank.getName() +
                ", банковский офис=" + bankOffice.getName() +
                ", обслуживающий сотрудник=" + (serviceEmployee != null ? serviceEmployee.getName() : "Отсутствует") +
                ", выдача наличных=" + cashWithdrawal +
                ", прием наличных=" + cashDeposit +
                ", количество денег=" + moneyAmount +
                ", стоимость обслуживания=" + maintenanceCost +
                '}';
    }

}
