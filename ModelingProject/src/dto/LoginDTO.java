package dto;

public class LoginDTO {
    private int userId;
    private String password;

    public LoginDTO() {
        this.userId = 0;
        this.password = "";
    }

    public LoginDTO(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
