package com.example.userservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone", length = 12)
    @Size(min = 11, max = 12) //Учитывая номера, которые начинаются с +7(12) и 8(11)
    private String phoneNumber;

    @Column(name = "iin", length = 12)
    @Size(min = 12, max = 12)
    private String iin;

    @Column(name = "passport_number", length = 9)
    @Size(min = 9, max = 9)
    private String passportNumber;

    //Какой организацией выдан паспорт(Пример - МВД РК)
    @Column(name = "passport_issued_by")
    private String passportIssuedBy;

    //Дата выдачи паспорта
    @Column(name = "passport_issue_date")
    private LocalDate passportIssuedDate;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public User() {

    }

    public User(String email, String passwordHash, String fullName, String phoneNumber, String iin, String passportNumber, String passportIssuedBy, LocalDate passportIssuedDate, String address, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.iin = iin;
        this.passportNumber = passportNumber;
        this.passportIssuedBy = passportIssuedBy;
        this.passportIssuedDate = passportIssuedDate;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(fullName, user.fullName) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(iin, user.iin) && Objects.equals(passportNumber, user.passportNumber) && Objects.equals(passportIssuedBy, user.passportIssuedBy) && Objects.equals(passportIssuedDate, user.passportIssuedDate) && Objects.equals(address, user.address) && Objects.equals(createdAt, user.createdAt) && Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, passwordHash, fullName, phoneNumber, iin, passportNumber, passportIssuedBy, passportIssuedDate, address, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", iin='" + iin + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportIssuedBy='" + passportIssuedBy + '\'' +
                ", passportIssuedDate=" + passportIssuedDate +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportIssuedBy() {
        return passportIssuedBy;
    }

    public void setPassportIssuedBy(String passportIssuedBy) {
        this.passportIssuedBy = passportIssuedBy;
    }

    public LocalDate getPassportIssuedDate() {
        return passportIssuedDate;
    }

    public void setPassportIssuedDate(LocalDate passportIssuedDate) {
        this.passportIssuedDate = passportIssuedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
