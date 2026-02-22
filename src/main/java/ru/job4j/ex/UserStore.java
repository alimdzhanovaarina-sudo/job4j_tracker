package ru.job4j.ex;

public class UserStore {
    public User findUser(User[] users, String login) throws ElementNotFoundException {
        for (User user : users) {
            if (user != null && user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new ElementNotFoundException("User with login '" + login + "' not found.");
    }

    public boolean validate(User user) throws UserInvalidException {
        if (user == null || user.getUsername().length() <= 3) {
            throw new UserInvalidException("User name must be longer than 3 characters.");
        }
        return user.isValid();

    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        UserStore userStore = new UserStore();
        String loginToFind = "Petr Arsentev";
        String loginNotFound = "Unknown User";
        String invalidUserLogin = "Jo";
        System.out.println("Поиск пользователя");
        try {
            User user = userStore.findUser(users, loginToFind);
            System.out.println("Найден пользователь: " + user.getUsername());
            user = userStore.findUser(users, loginNotFound);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Валидация пользователя");
            try {
                User userToValidate = userStore.findUser(users, loginToFind);
                if (userStore.validate(userToValidate)) {
                    System.out.println("Пользователь '" + userToValidate.getUsername() + "' имеет доступ.");
                } else {
                    System.out.println("Пользователь '" + userToValidate.getUsername() + "' невалиден.");
                }
                User invalidUser = new User(invalidUserLogin, true);
                userStore.validate(invalidUser);

            } catch (ElementNotFoundException e1) {
                System.out.println(e.getMessage());
            } catch (UserInvalidException e2) {
                System.out.println(e.getMessage());
            }
        }
    }
}

