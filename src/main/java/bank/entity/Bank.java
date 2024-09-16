package bank.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
    private int quantityATM; // Поле для хранения количества банкоматов в банке
    private static final Random random = new Random();
    private static int nextId = 1; // Счетчик для генерации уникальных идентификаторов
    private int id; // Идентификатор банка
    private String name; // Название банка
    private int numOfOffices; // Количество офисов банка
    private int numOfAtms; // Количество банкоматов банка
    private int numOfEmployees; // Количество сотрудников банка
    private int numOfUsers; // Количество пользователей банка
    private int rating; // Рейтинг банка
    private double totalMoney; // Общая сумма денег в банке
    private double interestRate; // Процентная ставка банка
    private List<BankOffice> bankOffices;
    private List<BankAtm> bankAtms;
    private List<Employee> employees;
    private List<User> users;

    /**
     * Конструктор класса Bank с параметрами.
     */
    public Bank(String name, int numOfOffices, int numOfAtms, int numOfEmployees, int numOfUsers) {
        this.id = nextId++;
        this.name = name;
        this.numOfOffices = numOfOffices;
        this.numOfAtms = numOfAtms;
        this.numOfEmployees = numOfEmployees;
        this.numOfUsers = numOfUsers;
        this.rating = random.nextInt(101); // Генерация случайного рейтинга от 0 до 100
        this.totalMoney = random.nextDouble() * 1_000_000; // Генерация случайной суммы денег до 1 000 000
        this.interestRate = random.nextDouble() * 60; // Генерация случайной процентной ставки до 20%
        this.bankOffices = new ArrayList<>();
        this.bankAtms = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public Bank(String name) {
        this(name, 0, 0, 0, 0);
    }
    public void addBankAtmToList(BankAtm atm) {
        bankAtms.add(atm);
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfOffices() {
        return numOfOffices;
    }

    public void setNumOfOffices(int numOfOffices) {
        this.numOfOffices = numOfOffices;
    }

    public int getNumOfAtms() {
        return numOfAtms;
    }

    public void setNumOfAtms(int numOfAtms) {
        this.numOfAtms = numOfAtms;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public int getNumOfUsers() {
        return numOfUsers;
    }

    public void setNumOfUsers(int numOfUsers) {
        this.numOfUsers = numOfUsers;
    }

    public int getRating() {
        return rating;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addBankOffice(BankOffice bankOffice) {
        bankOffices.add(bankOffice);
    }

    public List<BankOffice> getBankOffices() {
        return bankOffices;
    }

    public void addBankAtm(BankAtm bankAtm) {
        bankAtms.add(bankAtm);
    }

    public List<BankAtm> getBankAtms() {
        List<BankAtm> atmList = new ArrayList<>();
        for (BankOffice office : bankOffices) {
            atmList.addAll(office.getBankAtms());
        }
        return atmList;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    // Метод для уменьшения количества банкоматов в банке
    public void decrementQuantityATM() {
        if (quantityATM > 0) {
            quantityATM--;
        }
    }

    // Метод для увеличения количества банкоматов в банке
    public void incrementQuantityATM() {
        quantityATM++;
    }

    public void setNumOfClients(int numOfClients) {
        // Здесь можно добавить логику установки количества клиентов банка
    }



    @Override
    public String toString() {
        return "Банк:{" +
                "идентификатор=" + id +
                ", название='" + name + '\'' +
                ", количество офисов=" + numOfOffices +
                ", количество банкоматов=" + numOfAtms +
                ", количество сотрудников=" + numOfEmployees +
                ", количество пользователей=" + numOfUsers +
                ", рейтинг=" + rating +
                ", общая сумма денег=" + totalMoney +
                ", процентная ставка=" + interestRate +
                '}';
    }
}
