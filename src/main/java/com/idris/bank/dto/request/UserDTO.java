package com.idris.bank.dto.request;

import com.idris.bank.enums.UserTypes;


public class UserDTO {
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String businessName;
    private String businessAddress;
    private String contactPerson;
    private UserTypes userTypes;

    private boolean apiIntegrationRequested ;

    private boolean eligibleForCommission;

    public boolean isApiIntegrationRequested() {
        return apiIntegrationRequested;
    }

    public void setApiIntegrationRequested(boolean apiIntegrationRequested) {
        this.apiIntegrationRequested = apiIntegrationRequested;
    }

    public UserTypes getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(UserTypes userTypes) {
        this.userTypes = userTypes;
    }

    public boolean isEligibleForCommission() {
        return eligibleForCommission;
    }

    public void setEligibleForCommission(boolean eligibleForCommission) {
        this.eligibleForCommission = eligibleForCommission;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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
}
