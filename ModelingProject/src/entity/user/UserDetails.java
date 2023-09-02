package entity.user;

public class UserDetails {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String photo;
    private Role role;

    public UserDetails() {
        name = "";
        email = "";
        password = "";
        phone = "";
        address = "";
        photo = "";
        role = Role.TRAINEE;
    }

    public UserDetails(String name, String email, String password, String phone, String address, String photo, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.photo = photo;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
