package ra.shopping.dto.request;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


public class SignUpForm {
    private String name;
    private String username;
    private String email;
    private String password;
    private Date dateCreate;
    private boolean userStatus;
    private Set<String> listRoles;

    public SignUpForm(String name, String username, String email, String password, Date dateCreate, boolean userStatus, Set<String> listRoles) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateCreate = dateCreate;
        this.userStatus = userStatus;
        this.listRoles = listRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public Set<String> getListRoles() {
        return listRoles;
    }

    public void setListRoles(Set<String> listRoles) {
        this.listRoles = listRoles;
    }
}
