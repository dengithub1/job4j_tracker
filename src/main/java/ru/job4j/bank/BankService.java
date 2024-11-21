package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает основной фунцикионал банковских операций
 */
public class BankService {
    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает один параметр: пользователь
     * Добавляет пользователя если такой не найден
     * @param user пользователь которого необходимо добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод выполняет удаление пользователя
     * На вход принимает уникальный номер пользователя
     * @param passport уникальный номер пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает уникальный номер пользователя и счет который теребуется добавить
     * В случае если пользователь найден, выполняется поиск счета у данного пользвотеля
     * и добавления счета пользователю, если такой не найден
     * @param passport уникальный номер пользователя
     * @param account счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод принимает на вход уникальный номер пользователя
     * и осуществляет поиск по нему. если номер найден, то метод
     * возвращает пользователя чей номер был передан в метод
     * @param passport уникальный номер пользователя
     * @return возврвщает пользователя если номер найден, либо null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход уникальный номер пользователя и реквизиты счета
     * Выполняется поиск пользвателя по уникальному номеру
     * если пользователь найден то выпольняется по поиск счета у данного пользователя
     * по реквизитам этого счета
     * Если реквизиты найдены, то метод возвращает данный объект счет
     * @param passport уникальный номер пользователя
     * @param requisite реквизиты(одно их полей объекта счет)
     * @return возращает объект счет в случае если реквизиты найдены
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * метод предназначен для перечисления денег с одного счёта на другой счёт
     * метод принимает уникальный номер отправителя и его реквзит счета,
     * уникальный номер получателя и его реквизит счета, так же сумму для перевода
     * Если отправитель, получатель и их реквизиты найдены, то вылполняется проверка
     * баланса на счете списания, если баланс больше чем сумма перевода, то осуществляется перевод
     * @param sourcePassport уникальный номер отправителя
     * @param sourceRequisite реквизит счет отправителя
     * @param destinationPassport уникалный номер получателя
     * @param destinationRequisite реквизит счет получателя
     * @param amount сумма для перевода
     * @return возращает true если перевод выполнен
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account account1 = findByRequisite(sourcePassport, sourceRequisite);
        Account account2 = findByRequisite(destinationPassport, destinationRequisite);
        if (account1 != null && account1.getBalance() >= amount && account2 != null) {
            account1.setBalance(account1.getBalance() - amount);
            account2.setBalance(account2.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод возвращает список счетов пользователя
     * принимает на вход пользователя по которому тебеуется найти счета
     * @param user пользователь
     * @return возвазает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}