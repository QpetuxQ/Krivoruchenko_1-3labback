package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 * Интерфейс для управления сотрудниками банка.
 */
public interface EmployeeService {


    Employee createEmployee(int id, String name, LocalDate birthDate, String position, Bank workBank, boolean onsite, BankOffice workOffice, boolean canIssueCredit, double salary);

    void updateEmployee(int id, String name, LocalDate birthDate, String position, Bank workBank, boolean onsite, BankOffice workOffice, boolean canIssueCredit, double salary);

    void deleteEmployee(int id);

    Employee getEmployeeById(int id);

    Collection<Employee> getAllEmployees(Bank bank);
}
