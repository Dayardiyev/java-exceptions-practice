import exceptions.UserNotFoundException;

import java.nio.file.AccessDeniedException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type your login");
        String login = scanner.nextLine();
        System.out.println("Type your password");
        String password = scanner.nextLine();

        validateUser(getUserByLoginAndPassword(login,password));

        System.out.println("Access granted");
    }


    public static User[] getUsers() {
        User user1 = new User("john", "john@gmail.com", "pass", 24);
        User user2 = new User("david", "david@yahoo.com", "1234", 50);
        return new User[]{user1, user2};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18){
            throw new AccessDeniedException("You're not 18 yet.");
        }
    }
}
