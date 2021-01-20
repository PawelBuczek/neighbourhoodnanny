package pl.sdacademy.neighbourhoodnanny.users;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserBabysitterDTO {
    @Size(min = 3, max = 15, message = "has to be between 3 and 15 characters")
    private String username;
    @Size(min = 5, message = "has to be at least 5 characters")
    private String password;
    @Size(min = 1,max = 100, message = "has to be between 1 and 100 characters")
    private String firstName;
    @Size(min = 1,max = 100, message = "has to be between 1 and 100 characters")
    private String lastName;
    @Size(min = 3,max = 15, message = "has to be between 3 and 15 digits")
    private String phoneNumber;
    @Size(min = 1,max = 300, message = "has to be between 1 and 300 characters")
    @Email(message = "has to be a valid email address")
    private String email;

    public UserBabysitterDTO() {
    }

    public UserBabysitterDTO(String username, String password, String firstName, String lastName, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
