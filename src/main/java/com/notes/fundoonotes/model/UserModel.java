package com.notes.fundoonotes.model;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
    public String userId;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phoneNo;
    public String dob;
    public boolean verify = false;
    public String profilePic;
}
