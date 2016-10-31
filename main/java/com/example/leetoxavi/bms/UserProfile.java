package com.example.leetoxavi.bms;

/**
 * Created by leetoxavi on 10/30/2016.
 */
public class UserProfile {

    public String userName;
    public String userPhoneNumbers;
    public String userEmail;
    public String userPassword;
    public UserCredit userCredit = new UserCredit();
    public UserHistory userHistory = new UserHistory();

    public UserProfile(String userName, String userPhoneNumbers, String userEmail, String userPassword){

        this.userName = userName;
        this.userPhoneNumbers = userPhoneNumbers;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public UserProfile(){

    }

}
