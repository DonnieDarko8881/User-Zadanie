package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private final static String RELATIVE_PATH = "file/users.txt";
    private Scanner scanner;

    public void openFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        Path path = null;
        if (classLoader.getResource(RELATIVE_PATH) != null) {
            File file = new File(classLoader.getResource(RELATIVE_PATH).getFile());
            path = Paths.get(file.getPath());
        }
        try {
            scanner = new Scanner(new File(String.valueOf(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        UserService userService = new UserService();
        List<User> users = userService.getUsers();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(",");
            if (lineArray.length == 4) {
                users.add(new User.UserBuilder()
                        .firstName(lineArray[0])
                        .lastName(lineArray[1])
                        .birthDay(LocalDate.parse(lineArray[2]))
                        .phoneNumber(lineArray[3])
                        .build());
            } else {
                users.add(new User.UserBuilder()
                        .firstName(lineArray[0])
                        .lastName(lineArray[1])
                        .birthDay(LocalDate.parse(lineArray[2]))
                        .build());
            }
        }
        userService.setUsers(users);
    }

    public void closeFile() {
        scanner.close();
    }

    public void processFile() {
        openFile();
        readFile();
        closeFile();
    }
}
