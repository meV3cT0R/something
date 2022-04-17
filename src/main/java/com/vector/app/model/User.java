package com.vector.app.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`user`")
public class User {
    private @GeneratedValue(strategy = GenerationType.IDENTITY) @Id int id;
    private @Column String firstName;
    private @Column String lastName;
    private @Column String userName;
    private @Column String email;
    private @Column String password;
    
    private @Column String gender;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
    // public Date getDateOfBirth() {
    //     return dateOfBirth;
    // }
    // public void setDateOfBirth(Date dateOfBirth) {
    //     this.dateOfBirth = dateOfBirth;
    // }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    
}
