package pl.sdacademy.neighbourhoodnanny.services;

public class PasswordTokenDTO {
    private String token;
    private String password;

    public PasswordTokenDTO(String token, String password) {
        this.token = token;
        this.password = password;
    }

    public PasswordTokenDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
