package bank.service.impl;

import bank.entity.Bank;
import bank.entity.User;
import bank.service.UserService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private Map<Integer, User> users; // Коллекция для хранения пользователей

    public UserServiceImpl() {
        this.users = new HashMap<>(); // Инициализация коллекции пользователей
    }

    @Override
    public Iterable<User> getAllUsers() {
        return users.values(); // Возвращаем непараметризованную Iterable
    }

    @Override
    public User createUser(int id, String fullName, LocalDate birthDate, String workplace, Bank bank) {
        User newUser = new User(id, fullName, birthDate, workplace, bank);
        users.put(id, newUser); // Добавляем пользователя в Map по его идентификатору
        System.out.println("Пользователь успешно создан.");
        return newUser;
    }

    @Override
    public void updateUser(int userId, String newName, LocalDate birthDate, double newMonthlyIncome, String newBanksUsed) {
        User userToUpdate = users.get(userId); // Получаем пользователя по его идентификатору
        if (userToUpdate != null) {
            // Обновляем данные пользователя
            userToUpdate.setFullName(newName);
            userToUpdate.setBirthDate(birthDate);
            userToUpdate.setMonthlyIncome(newMonthlyIncome);
            userToUpdate.setBanksUsed(newBanksUsed);
            System.out.println("Пользователь успешно обновлен.");
        } else {
            System.out.println("Ошибка: Пользователь не найден.");
        }
    }

    @Override
    public void deleteUser(int userId) {
        User userToDelete = users.remove(userId); // Удаляем пользователя из Map по его идентификатору
        if (userToDelete != null) {
            System.out.println("Пользователь успешно удален.");
        } else {
            System.out.println("Ошибка: Пользователь не найден.");
        }
    }

    @Override
    public User getUserById(int userId) {
        User user = users.get(userId); // Получаем пользователя из Map по его идентификатору
        if (user != null) {
            return user;
        } else {
            System.out.println("Ошибка: Пользователь не найден.");
            return null;
        }
    }
}
