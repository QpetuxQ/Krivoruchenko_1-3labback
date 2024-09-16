package bank.service;

import bank.entity.Bank;
import bank.entity.User;

import java.time.LocalDate;

/**
 * Интерфейс для управления пользователями.
 */
public interface UserService {


    Iterable<User> getAllUsers();

    User createUser(int id, String fullName, LocalDate birthDate, String workplace, Bank bank);

    void updateUser(int userId, String newName, LocalDate birthDate, double newMonthlyIncome, String newBanksUsed);

    void deleteUser(int userId);

    User getUserById(int userId);
}
