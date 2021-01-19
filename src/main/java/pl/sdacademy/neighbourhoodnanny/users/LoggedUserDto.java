package pl.sdacademy.neighbourhoodnanny.users;

public class LoggedUserDto {
    private String username;
    private String role;

    public LoggedUserDto(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
