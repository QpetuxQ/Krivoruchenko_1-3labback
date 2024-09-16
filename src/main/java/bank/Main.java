package bank;

import bank.entity.*;
import bank.service.*;
import bank.service.impl.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        UserService userService = new UserServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        BankAtmService bankAtmService = new BankAtmServiceImpl();

        List<Bank> banks = Arrays.asList(
                bankService.createBank("Сбербанк", 125, 150, 275, 7456563), //0
                bankService.createBank("Т-банк", 125, 150, 275, 36521),//1
                bankService.createBank("ГазпромБанк", 125, 150, 275, 1453599)//2
        );

        List<BankOffice> bankOffices = Arrays.asList(
                bankOfficeService.createBankOffice(1, "Главный офис 1", "ул. Победы, д. 47, кв. 5", true, true, 45, false, true, true, 20, 45000, banks.get(0)),
                bankOfficeService.createBankOffice(2, "Главный офис 2", "ул. Буденого, д. 10, кв. 5", true, true, 75, true, true, true, 3500, 33000, banks.get(1)),
                bankOfficeService.createBankOffice(3, "Главный офис 3", "ул. Губкина, д. 10, кв. 5", true, true, 120, true, true, true, 1777832000, 20000, banks.get(2))
        );

        List<Employee> employees = Arrays.asList(
                employeeService.createEmployee(1, "Толик Яцко", LocalDate.of(1985, 1, 15), "Менеджер", banks.get(0), true, bankOffices.get(0), true, 75000),
                employeeService.createEmployee(2, "Михаил Круг", LocalDate.of(1985, 1, 15), "Менеджер", banks.get(1), true, bankOffices.get(1), true, 75000),
                employeeService.createEmployee(3, "Даша Корейка", LocalDate.of(2001, 8, 20), "Менеджер", banks.get(1), true, bankOffices.get(1), true, 35000),
                employeeService.createEmployee(4, "Удачин Григорий", LocalDate.of(1976, 5, 1), "Менеджер", banks.get(2), true, bankOffices.get(2), true, 50000),
                employeeService.createEmployee(5, "Гахова Нина", LocalDate.of(1976, 5, 1), "Менеджер", banks.get(2), true, bankOffices.get(2), true, 50000)
        );

        List<User> users = Arrays.asList(
                userService.createUser(1, "Каторжной Родион", LocalDate.of(1990, 8, 8), "ул. Ленина, д. 15, кв. 31", banks.get(1)),
                userService.createUser(2, "Криворученко Олег", LocalDate.of(1993, 10, 5), "ул. Ленина, д. 15, кв. 3", banks.get(2)),
                userService.createUser(3, "Григорий Лепс", LocalDate.of(1987, 12, 20), "ул. Пушкина, д. 5, кв. 10", banks.get(0))
        );

        List<PaymentAccount> paymentAccounts = Arrays.asList(
                paymentAccountService.createPaymentAccount(1, users.get(1), 10000),
                paymentAccountService.createPaymentAccount(2, users.get(0), 175896),
                paymentAccountService.createPaymentAccount(3, users.get(2), 7845653)
        );

        List<CreditAccount> creditAccounts = Arrays.asList(
                creditAccountService.createCreditAccount(1, users.get(2), banks.get(0).getName(), "2024-11-28", "2025-03-28", 48, 1563000.0, 0.0, 25.0, employees.get(2), paymentAccounts.get(0)),
                creditAccountService.createCreditAccount(2, users.get(1), banks.get(1).getName(), "2024-03-28", "2036-03-28", 36, 137890.0, 14500.0, 12.0, employees.get(1), paymentAccounts.get(1)),
                creditAccountService.createCreditAccount(3, users.get(0), banks.get(2).getName(), "2020-04-28", "2040-03-01", 12, 5000.0, 0.0, 33.0, employees.get(0), paymentAccounts.get(2))
        );

        List<BankAtm> bankAtms = Arrays.asList(
                bankAtmService.createBankAtm(1, "Банкомат с деньгами", "1", bankOffices.get(0), "ул. Красноармейская, д. 20", employees.get(0), true, true, 100, 10000),
                bankAtmService.createBankAtm(2, "Банкомат пустой", "1", bankOffices.get(1), "ул. Кировская, д. 20", employees.get(2), true, true, 100, 999000),
                bankAtmService.createBankAtm(3, "Банкомат, где много денег", "1", bankOffices.get(2), "ул. Карасева, д. 20", employees.get(4), true, true, 100, 900000)
        );

        for (User user : users) {
            Bank bank = selectBestBank(user, banks);
            BankOffice chosenBankOffice = selectBestBankOffice(user, bankOffices);
            Employee employee = selectBestEmployee(user, employees);
            BankAtm chosenBankAtm = selectBestBankAtm(user, chosenBankOffice.getBankAtms());

            double requestedAmount = calculateCreditAmount(user);
            checkAndIssueCredit(user, banks, bankOfficeService, employeeService, paymentAccountService, creditAccountService, bankAtmService, employee, requestedAmount);

        }
    }

    private static Bank selectBestBank(User user, List<Bank> banks) {
        Bank bestBank = null;
        int maxATMs = 0;
        int maxEmployees = 0;
        double minInterestRate = Double.MAX_VALUE;

        for (Bank bank : banks) {
            // Получаем количество банкоматов в банке
            int numATMs = bank.getBankAtms().size();
            if (numATMs > maxATMs) {
                maxATMs = numATMs;
                bestBank = bank;
            } else if (numATMs == maxATMs) {
                // Если количество банкоматов одинаковое, сравниваем количество сотрудников
                int numEmployees = bank.getEmployees().size();
                if (numEmployees > maxEmployees) {
                    maxEmployees = numEmployees;
                    bestBank = bank;
                } else if (numEmployees == maxEmployees) {
                    // Если количество сотрудников одинаковое, сравниваем процентную ставку
                    double interestRate = bank.getInterestRate();
                    if (interestRate < minInterestRate) {
                        minInterestRate = interestRate;
                        bestBank = bank;
                    }
                }
            }
        }

        return bestBank;
    }



    private static BankOffice selectBestBankOffice(User user, List<BankOffice> bankOffices) {
        BankOffice bestBankOffice = null;
        double maxLoanAmount = 0;

        for (BankOffice bankOffice : bankOffices) {
            // Проверяем, доступен ли кредит в данном офисе
            if (bankOffice.isCreditService()) {
                // Получаем максимальную сумму кредита, которую можно получить в этом офисе
                double loanAmount = bankOffice.getMoneyAmount();
                if (loanAmount > maxLoanAmount) {
                    maxLoanAmount = loanAmount;
                    bestBankOffice = bankOffice;
                }
            }
        }

        return bestBankOffice;
    }

    private static Employee selectBestEmployee(User user, List<Employee> employees) {
        Employee bestEmployee = null;
        for (Employee employee : employees) {
            // Проверяем, может ли сотрудник выдавать кредиты
            if (employee.isCanIssueCredit()) {
                // Если да, то выбираем этого сотрудника
                bestEmployee = employee;
                break; // Прерываем цикл после нахождения первого подходящего сотрудника
            }
        }
        return bestEmployee;
    }

    private static BankAtm selectBestBankAtm(User user, List<BankAtm> bankAtms) {
        BankAtm bestBankAtm = null;
        double maxMoneyAmount = 0;

        for (BankAtm bankAtm : bankAtms) {
            // Проверяем, есть ли достаточное количество денег в данном банкомате
            if (bankAtm.getMoneyAmount() > maxMoneyAmount) {
                maxMoneyAmount = bankAtm.getMoneyAmount();
                bestBankAtm = bankAtm;
            }
        }

        return bestBankAtm;
    }


    private static void checkAndIssueCredit(User user, List<Bank> banks, BankOfficeService bankOfficeService, EmployeeService employeeService,
                                            PaymentAccountService paymentAccountService, CreditAccountService creditAccountService,
                                            BankAtmService bankAtmService, Employee employee, double requestedAmount) {

        Bank bestBank = null;
        double bestInterestRate = Double.MAX_VALUE;

        for (Bank bank : banks) {
            System.out.println("Процентная ставка в банке " + bank.getName() + ": " + bank.getInterestRate() + "%");
            if (bank.getInterestRate() < bestInterestRate) {
                bestInterestRate = bank.getInterestRate();
                bestBank = bank;
            }
        }

        if (bestBank == null) {
            throw new RuntimeException("Не удалось найти банк с наименьшей процентной ставкой.");
        }

        List<BankOffice> bankOffices = bankOfficeService.getAllBankOffices(bestBank);
        Optional<BankOffice> chosenBankOfficeOpt = bankOffices.stream().findFirst();

        Bank finalBestBank = bestBank;
        BankOffice chosenBankOffice = chosenBankOfficeOpt.orElseThrow(() -> new BankOfficeNotFoundException("Нет доступных банковских офисов для выбранного банка " + finalBestBank.getName()));

        List<Employee> employees = (List<Employee>) employeeService.getAllEmployees(bestBank);

        Employee chosenEmployee = employees.stream()
                .filter(Employee::isCanIssueCredit)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Нет доступных сотрудников для выдачи кредита в банке " + finalBestBank.getName()));

        PaymentAccount paymentAccount = paymentAccountService.getPaymentAccountById(user.getId());
        if (paymentAccount == null) {
            throw new PaymentAccountNotFoundException("Платежный счет не найден для клиента " + user.getFullName() + " в банке " + bestBank.getName());
        }

        CreditAccount creditAccount = creditAccountService.getCreditAccountByUserId(user.getId());
        if (creditAccount == null) {
            throw new CreditAccountNotFoundException("Кредитный счет не найден для клиента " + user.getFullName() + " в банке " + bestBank.getName());
        }

        if (user.getCreditRating() < 5000 && bestBank.getRating() > 50) {
            throw new CreditRatingTooLowException("Кредитный рейтинг клиента " + user.getFullName() + " в банке " + bestBank.getName() + " слишком низкий, кредит не может быть выдан.");
        }

        BankAtm chosenBankAtm = chosenBankOffice.getBankAtms().stream()
                .filter(atm -> atm.getMoneyAmount() >= requestedAmount)
                .findFirst()
                .orElseThrow(() -> new InsufficientFundsException("Недостаточно средств в банкоматах для выдачи кредита клиенту " + user.getFullName() + " в банке " + finalBestBank.getName()));

        updateAfterCreditIssuance(paymentAccountService, creditAccountService, bankAtmService,
                paymentAccount, chosenBankAtm, user, requestedAmount);

        System.out.println("Выбран наилучший банк: " + bestBank.getName());
        System.out.println("Процентная ставка в выбранном банке: " + bestInterestRate + "%");
        System.out.println("Кредит успешно выдан клиенту " + user.getFullName() + " в банке " + bestBank.getName() + " в размере " + requestedAmount + " рублей.");
        System.out.println("Кредитный рейтинг клиента: " + user.getCreditRating());
        System.out.println("Кредит одобрен через банковский офис " + chosenBankOffice.getName() + " с использованием банкомата " + chosenBankAtm.getName() + ". Выдавал кредит сотрудник: " + chosenEmployee.getName());
    }



    private static double calculateCreditAmount(User user) {
        return 17000;
    }

    private static void updateAfterCreditIssuance(PaymentAccountService paymentAccountService, CreditAccountService creditAccountService,
                                                  BankAtmService bankAtmService, PaymentAccount paymentAccount, BankAtm bankAtm,
                                                  User user, double amount) {
        paymentAccountService.updatePaymentAccount(paymentAccount.getId(), user, paymentAccount.getAmount() + amount);
        bankAtmService.updateBankAtm(bankAtm.getId(), bankAtm.getBankOffice(), bankAtm.getMoneyAmount() - amount);
    }

    static class CreditRatingTooLowException extends RuntimeException {
        public CreditRatingTooLowException(String message) {
            super(message);
        }
    }

    static class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    static class BankOfficeNotFoundException extends RuntimeException {
        public BankOfficeNotFoundException(String message) {
            super(message);
        }
    }

    static class EmployeeNotFoundException extends RuntimeException {
        public EmployeeNotFoundException(String message) {
            super(message);
        }
    }

    static class PaymentAccountNotFoundException extends RuntimeException {
        public PaymentAccountNotFoundException(String message) {
            super(message);
        }
    }

    public static class CreditAccountNotFoundException extends RuntimeException {
        public CreditAccountNotFoundException(String message) {
            super(message);
        }
    }
}
