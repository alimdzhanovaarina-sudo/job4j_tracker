package ru.job4j.bank; // Убедись, что пакет соответствует структуре проекта

import java.util.*;

/**
 * Сервис для управления банковскими счетами пользователей.
 * Хранит пользователей и их счета в HashMap.
 */
public class BankService {

    // Основное хранилище данных: Map, где ключ - паспорт пользователя,
    // а значение - объект User, содержащий его данные и список счетов.
    private final Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getPassport(), user); // Добавляем пользователя в Map по его паспорту.
    }

    /**
     * Удаляет пользователя из системы по его паспорту.
     * @param passport Паспорт пользователя для удаления.
     */
    public void deleteUser(String passport) {
        users.remove(passport); // Удаляет пользователя из Map по ключу (паспорту).
    }

    /**
     * Добавляет банковский счет новому пользователю или существующему.
     * @param passport Паспорт пользователя, к которому добавляется счет.
     * @param account Счет для добавления.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport); // Находим пользователя по паспорту.
        if (user != null) { // Если пользователь найден
            // Получаем список его счетов (или создаем новый, если у пользователя еще нет счетов).
            List<Account> accounts = user.getAccounts();
            // Добавляем новый счет, если его еще нет у этого пользователя.
            if (!accounts.contains(account)) { // Проверяем, существует ли уже такой счет.
                accounts.add(account); // Добавляем счет в список.
            }
        }
    }

    public User findByPassport(String passport) {
        // Возвращает пользователя из Map по ключу. Если ключ не найден, вернет null.
        return users.get(passport);
    }

/**
 * Находит счет пользователя по его паспорту и реквизитам (requisite).
 * @param passport Паспорт пользователя.
 * @param requisite Реквизиты счета.
 * @return Объект Account, если найден, иначе null.
 */
public Account findByRequisite(String passport, String requisite) {
    User user = findByPassport(passport); // Находим пользователя.
    if (user != null) { // Если пользователь найден
        // Итерируемся по всем счетам пользователя.
        for (Account account : user.getAccounts()) {
            // Если реквизиты счета совпадают с искомыми, возвращаем счет.
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
    }
    return null; // Если пользователь или счет не найдены, возвращаем null.
}

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = false;

        // Находим исходный и целевой счета.
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        // Проверяем, что оба счета найдены,
        // что у отправителя достаточно средств,
        // и что сумма перевода положительна.
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount && amount > 0) {

            // Списываем сумму со счета отправителя.
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            // Зачисляем сумму на счет получателя.
            destAccount.setBalance(destAccount.getBalance() + amount);

            result = true; // Устанавливаем флаг успешности.
        }
        return result; // Возвращаем результат операции.
    }

    /**
     * Возвращает список всех счетов данного пользователя.
     * @param user Пользователь, чьи счета нужно получить.
     * @return Список счетов пользователя.
     */
    public List<Account> getUserAccounts(User user) {
        // Просто возвращаем список счетов пользователя.
        // В случае, если пользователь null, или у него нет счетов,
        return user != null ? user.getAccounts() : Collections.emptyList();
    }
}


