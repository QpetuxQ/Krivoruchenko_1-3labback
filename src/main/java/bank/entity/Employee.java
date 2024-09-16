package bank.entity;

import java.time.LocalDate;

/**
 * Класс, представляющий сотрудника банка.
 */
public class Employee {
    private int id; // Идентификатор сотрудника
    private String name; // Имя сотрудника
    private LocalDate birthDate; // Дата рождения сотрудника
    private String position; // Должность сотрудника
    private Bank workBank; // Банк, в котором работает сотрудник
    private boolean onsite; // Признак нахождения сотрудника на рабочем месте
    private BankOffice workOffice; // Офис, в котором работает сотрудник
    private boolean canIssueCredit; // Возможность выдачи кредита сотрудником
    private double salary; // Зарплата сотрудника

    /**
     * Конструктор класса Employee с параметрами.
     *
     * @param id             Идентификатор сотрудника.
     * @param name           Имя сотрудника.
     * @param birthDate      Дата рождения сотрудника.
     * @param position       Должность сотрудника.
     * @param workBank       Банк, в котором работает сотрудник.
     * @param onsite         Признак нахождения сотрудника на рабочем месте.
     * @param workOffice     Офис, в котором работает сотрудник.
     * @param canIssueCredit Возможность выдачи кредита сотрудником.
     * @param salary         Зарплата сотрудника.
     */
    public Employee(int id, String name, LocalDate birthDate, String position, Bank workBank, boolean onsite, BankOffice workOffice, boolean canIssueCredit, double salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.workBank = workBank;
        this.onsite = onsite;
        this.workOffice = workOffice;
        this.canIssueCredit = canIssueCredit;
        this.salary = salary;
    }
    public Employee(int id,String name) {
        this.id = id;
        this.name = name;
        this.birthDate = LocalDate.now(); // Устанавливаем текущую дату как дату рождения по умолчанию
        this.position = "Unknown"; // Устанавливаем позицию по умолчанию
        this.workBank = null; // Устанавливаем банк по умолчанию как null
        this.onsite = false; // Устанавливаем признак нахождения на месте работы по умолчанию как false
        this.workOffice = null; // Устанавливаем офис по умолчанию как null
        this.canIssueCredit = false; // Устанавливаем возможность выдачи кредита по умолчанию как false
        this.salary = 0.0; // Устанавливаем зарплату по умолчанию как 0
    }


    // Геттеры и сеттеры для полей

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPosition() {
        return position;
    }

    public Bank getWorkBank() {
        return workBank;
    }

    public boolean isOnsite() {
        return onsite;
    }

    public BankOffice getWorkOffice() {
        return workOffice;
    }

    public boolean isCanIssueCredit() {
        return canIssueCredit;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setWorkBank(Bank workBank) {
        this.workBank = workBank;
    }

    public void setOnsite(boolean onsite) {
        this.onsite = onsite;
    }

    public void setWorkOffice(BankOffice workOffice) {
        this.workOffice = workOffice;
    }

    public void setCanIssueCredit(boolean canIssueCredit) {
        this.canIssueCredit = canIssueCredit;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String workBankName = (workBank != null) ? workBank.getName() : "Отсутствует";
        String workOfficeName = (workOffice != null) ? workOffice.getName() : "Отсутствует";

        return "Сотрудник:{" +
                "идентификатор=" + id +
                ", имя='" + name + '\'' +
                ", дата рождения=" + birthDate +
                ", должность='" + position + '\'' +
                ", банк=" + workBankName +
                ", на месте работы=" + onsite +
                ", офис=" + workOfficeName +
                ", имеет право выдавать кредит=" + canIssueCredit +
                ", зарплата=" + salary +
                '}';
    }

}
