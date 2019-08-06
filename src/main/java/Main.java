import user.FileReader;
import user.UserService;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.processFile();
        System.out.println("Number Of users: "+ UserService.getUsers().size());
        System.out.println("The oldest user from file who has got phone number: ");
        UserService.printTheOldestUser();
    }
}
