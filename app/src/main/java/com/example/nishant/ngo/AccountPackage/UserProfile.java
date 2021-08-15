package com.example.nishant.ngo.AccountPackage;



/**
 * Created by mca_dept on 4/25/2019.
 */

class UserProfile {
    String key,userEmail,userPAssword2,userName,userPhone;

    public UserProfile(String key,String userEmail, String userPAssword2, String userName, String userPhone) {
        this.key=key;
        this.userEmail = userEmail;

        this.userPAssword2 = userPAssword2;
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPAssword2() {
        return userPAssword2;
    }

    public void setUserPAssword2(String userPAssword2) {
        this.userPAssword2 = userPAssword2;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
