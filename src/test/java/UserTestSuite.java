import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import user.FileReader;
import user.User;
import user.UserService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class UserTestSuite {
    @Before
    public void given() {
        FileReader fileReader = new FileReader();
        fileReader.processFile();
    }

    @After
    public void clear(){
        UserService.getUsers().clear();
    }

    @Test
    public void shouldReturn6UsersAllUsersFromFile(){
        //When
        List<User> users = UserService.getUsers();

        //then
        assertEquals(6,users.size());
    }

    @Test
    public void shouldReturn10yearsOld(){
        //Given
        User user = new User.UserBuilder().birthDay(LocalDate.of(2009,06,05)).build();

        //when
        int age = user.getAge();

        //then
        assertEquals(10,age);
    }

    @Test
    public void shouldReturn9yearsOld(){
        //Given
        User user = new User.UserBuilder().birthDay(LocalDate.of(2009,10,10)).build();

        //when
        int age = user.getAge();

        //then
        assertEquals(9,age);
    }



    @Test
    public void shouldReturn4UsersWithPhoneNumbers() {
        //When
        List<User> usersWithPhoneNumber = UserService.getUsersWithPhoneNumber();

        //Then
        assertEquals(4,usersWithPhoneNumber.size());
    }

    @Test
    public void shouldReturnDateYear1970Mont06Day08() {
        //when
        LocalDate theOldestBirthDate = UserService.getTheOldestBirthDateAmongUserWithPhoneNumbers();

        //then
        assertEquals("1970-06-08", theOldestBirthDate.toString());
    }

    @Test
    public void shouldReturnTheOldestUserMarylStreep() {
        //when
        List<User> theOldestUsers = UserService.getTheOldestUsers();

        //then
        assertEquals(1,theOldestUsers.size());
        assertEquals("Maryl", theOldestUsers.get(0).getFirstName());
        assertEquals("Streep", theOldestUsers.get(0).getLastName());
        assertEquals(49,theOldestUsers.get(0).getAge());
        assertEquals("2131231231",theOldestUsers.get(0).getPhoneNumber());
    }
}