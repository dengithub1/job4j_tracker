package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User usr : users) {
            if (login.equals(usr.getUsername())) {
                user = usr;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("User is not valid");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("User's username is less than 3 symbols");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = new User[]{
                new User("Us", true)
        };

        try {
            validate(findUser(users, "Us"));
        } catch (UserInvalidException uie) {
            uie.printStackTrace();
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        }
    }
}
