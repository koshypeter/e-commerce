package com.example.ecommerce.AdminLog;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "admin_table")
@Data
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer adminid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
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

    public AdminModel() {
    }
}
