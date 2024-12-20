package com.idris.bank.model;

import com.idris.bank.enums.UserTypes;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String gender;
    private String phone;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private UserTypes UserTypes;

    private boolean eligibleForCommission = false;
//    Optional : Used for Waya API Integration
    @Column(unique = true)
    private String apiKey;

    @CreationTimestamp
    private LocalDateTime createdDate=LocalDateTime.now();
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isEligibleForCommission() {
        return eligibleForCommission;
    }

    public void setEligibleForCommission(boolean eligibleForCommission) {
        this.eligibleForCommission = eligibleForCommission;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public com.idris.bank.enums.UserTypes getUserTypes() {
        return UserTypes;
    }

    public void setUserTypes(com.idris.bank.enums.UserTypes userTypes) {
        UserTypes = userTypes;
    }
}
