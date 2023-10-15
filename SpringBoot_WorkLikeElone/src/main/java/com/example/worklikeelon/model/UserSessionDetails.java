package com.example.worklikeelon.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class UserSessionDetails implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @JsonInclude(Include.NON_NULL)
    private String userName;
    @JsonInclude(Include.NON_NULL)
    private String password;
    @JsonInclude(Include.NON_NULL)
    private boolean validateUser;

    public UserSessionDetails(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public UserSessionDetails(boolean validateUser) {
        super();
        this.validateUser = validateUser;
    }

    public boolean isValidateUser() {
        return validateUser;
    }

    public void setValidateUser(boolean validateUser) {
        this.validateUser = validateUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
