package user;

import java.time.LocalDate;

public final class User {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String phoneNumber;

    private User(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.birthDate = userBuilder.birthDate;
        this.phoneNumber = userBuilder.phoneNumber;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private String phoneNumber;


        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder birthDay(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        if (getBirthDate().getDayOfYear() < LocalDate.now().getDayOfYear()) {
            return LocalDate.now().getYear() - getBirthDate().getYear();
        } else {
            return LocalDate.now().getYear() - getBirthDate().getYear() - 1;
        }
    }
}
