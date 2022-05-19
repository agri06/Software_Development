package hu.unideb.inf.model;

import javax.persistence.*;

@Entity
@Table(name = "AdminData")
public class AdminData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Basic(optional = false)
    private String username;
    @Basic(optional = false)
    private String emailAddress;
    @Basic(optional = false)
    private String password;

    public AdminData() {
    }

    public AdminData(int Id, String username, String emailAddress, String password) {
        this.Id = Id;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}