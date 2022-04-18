package com.vector.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Employee {
    private @GeneratedValue(strategy=GenerationType.IDENTITY) @Id long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String companyName;
    private String department;
    private String post;
    private String phone;
    private String email;
    private int salary;
    private int age;
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date dob;
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date joinDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addressId")
    private Address address;

    
    public Date getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    @Override
    public String toString() {
        return "Employee [address=" + address + ", age=" + age + ", companyName=" + companyName + ", department="
                + department + ", dob=" + dob + ", email=" + email + ", firstName=" + firstName + ", gender=" + gender
                + ", id=" + id + ", joinDate=" + joinDate + ", lastName=" + lastName + ", phone=" + phone + ", post="
                + post + ", salary=" + salary + "]";
    }

    
}
