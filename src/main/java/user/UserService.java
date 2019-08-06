package user;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static List<User> users = new ArrayList<>();


    public static List<User> getUsersWithPhoneNumber() {
        return users.stream().filter(user -> user.getPhoneNumber() != null)
                .collect(Collectors.toList());
    }

    public static LocalDate getTheOldestBirthDateAmongUserWithPhoneNumbers() {
        List<User> usersWithPhones = getUsersWithPhoneNumber();
        LocalDate theOldestBirthDay = null;
        for (int i = 0; i + 1 < usersWithPhones.size(); i++) {
            if (usersWithPhones.get(i).getBirthDate().compareTo(usersWithPhones.get(i + 1).getBirthDate()) < 0) {
                theOldestBirthDay = usersWithPhones.get(i).getBirthDate();
            } else {
                theOldestBirthDay = usersWithPhones.get(i + 1).getBirthDate();
            }
        }
        return theOldestBirthDay;
    }

    public static List<User> getTheOldestUsers() {
        LocalDate theOldestBirthDay = getTheOldestBirthDateAmongUserWithPhoneNumbers();
        return getUsersWithPhoneNumber().stream()
                .filter(user -> user.getBirthDate().equals(theOldestBirthDay))
                .collect(Collectors.toList());
    }

    public static void printTheOldestUser() {
        getTheOldestUsers().forEach(user ->
                System.out.println("first name: " + user.getFirstName() + ", last name: " + user.getLastName() +
                        ", age: " + user.getAge() + ", phone number: " + user.getPhoneNumber())
        );
    }

    public static List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
