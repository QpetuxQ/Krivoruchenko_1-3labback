package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.EmployeeService;

import java.time.LocalDate;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    private Map<Integer, Employee> employees; // Коллекция для хранения сотрудников

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>(); // Инициализация коллекции сотрудников
    }

    @Override
    public Employee createEmployee(int id, String name, LocalDate birthDate, String position, Bank workBank, boolean onsite, BankOffice workOffice, boolean canIssueCredit, double salary) {
        if (!employees.containsKey(id)) {
            Employee newEmployee = new Employee(id, name, birthDate, position, workBank, onsite, workOffice, canIssueCredit, salary);
            employees.put(id, newEmployee); // Добавляем нового сотрудника в коллекцию
            System.out.println("Сотрудник успешно добавлен.");
            return newEmployee;
        } else {
            System.out.println("Ошибка: Сотрудник уже существует.");
            return null;
        }
    }

    @Override
    public void updateEmployee(int id, String name, LocalDate birthDate, String position, Bank workBank, boolean onsite, BankOffice workOffice, boolean canIssueCredit, double salary) {
        Employee existingEmployee = employees.get(id);
        if (existingEmployee != null) {
            existingEmployee.setName(name);
            existingEmployee.setBirthDate(birthDate);
            existingEmployee.setPosition(position);
            existingEmployee.setWorkBank(workBank);
            existingEmployee.setOnsite(onsite);
            existingEmployee.setWorkOffice(workOffice);
            existingEmployee.setCanIssueCredit(canIssueCredit);
            existingEmployee.setSalary(salary);
            System.out.println("Сотрудник успешно обновлен.");
        } else {
            System.out.println("Ошибка: Сотрудник не найден.");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
            System.out.println("Сотрудник успешно удален.");
        } else {
            System.out.println("Ошибка: Сотрудник не найден.");
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee existingEmployee = employees.get(id);
        if (existingEmployee != null) {
            return existingEmployee;
        } else {
            System.out.println("Ошибка: Сотрудник не найден.");
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees(Bank bank) {
        List<Employee> employeesOfBank;
        employeesOfBank = new ArrayList<>();
        for (Employee employee : employees.values()) {
            if (employee.getWorkBank().equals(bank)) {
                employeesOfBank.add(employee);
            }
        }
        return employeesOfBank;
    }

}
