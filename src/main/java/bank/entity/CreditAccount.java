package bank.entity;

import java.time.LocalDate;

public class CreditAccount {
    private int id;
    private User user;
    private String bankName;
    private String startDate;
    private String endDate;
    private int months;
    private double amount;
    private double monthlyPayment;
    private double interestRate;
    private Employee issuingEmployee;
    private PaymentAccount paymentAccount;
    /**
     * Конструктор класса CreditAccount с параметрами.
     */
    public CreditAccount(int id, User user, String bankName, String startDate, String endDate, int months, double amount, double monthlyPayment, double interestRate, Employee issuingEmployee, PaymentAccount paymentAccount) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.months = months;
        this.amount = amount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.issuingEmployee = issuingEmployee;
        this.paymentAccount = paymentAccount;
    }
    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Employee getIssuingEmployee() {
        return issuingEmployee;
    }

    public void setIssuingEmployee(Employee issuingEmployee) {
        this.issuingEmployee = issuingEmployee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        return "Кредитный счет:{" +
                "идентификатор=" + id +
                ", пользователь=" + user +
                ", название банка='" + bankName + '\'' +
                ", дата начала='" + startDate + '\'' +
                ", дата окончания='" + endDate + '\'' +
                ", количество месяцев=" + months +
                ", сумма=" + amount +
                ", ежемесячный платеж=" + monthlyPayment +
                ", процентная ставка=" + interestRate +
                ", выдавший сотрудник=" + issuingEmployee +
                ", платежный счет=" + paymentAccount +
                '}';
    }

    public int getCurrentDebt() {
        return (int) (amount - (months * monthlyPayment)); // Если вы хотите вернуть задолженность как целое число, приведите ее к типу int
    }

    public int getBalance() {
        return (int) (amount - (months * monthlyPayment));
    }

}
