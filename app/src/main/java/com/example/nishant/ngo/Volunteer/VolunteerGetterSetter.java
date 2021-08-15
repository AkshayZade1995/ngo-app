package com.example.nishant.ngo.Volunteer;

/**
 * Created by Nishant on 4/14/2019.
 */

public class VolunteerGetterSetter {
    String volunteerID;
    String strregistrationName,strregistrationEmail,strregistrationMobileno,strregistrationAge,strregistrationAddress;
    String spinnerMF;

    public VolunteerGetterSetter()
    {

    }

    public VolunteerGetterSetter(String strregistrationName, String strregistrationEmail) {
        this.strregistrationName = strregistrationName;
        this.strregistrationEmail = strregistrationEmail;
    }

    public VolunteerGetterSetter(String volunteerID, String strregistrationName, String strregistrationEmail, String strregistrationMobileno, String strregistrationAge, String strregistrationAddress, String spinnerMF) {
        this.volunteerID = volunteerID;
        this.strregistrationName = strregistrationName;
        this.strregistrationEmail = strregistrationEmail;
        this.strregistrationMobileno = strregistrationMobileno;
        this.strregistrationAge = strregistrationAge;
        this.strregistrationAddress = strregistrationAddress;
        this.spinnerMF = spinnerMF;
    }

    public VolunteerGetterSetter(String volunteerID) {
        this.volunteerID = volunteerID;
    }

    public String getVolunteerID() {
        return volunteerID;
    }

    public String getStrregistrationName() {
        return strregistrationName;
    }

    public String getStrregistrationEmail() {
        return strregistrationEmail;
    }

    public String getStrregistrationMobileno() {
        return strregistrationMobileno;
    }

    public String getStrregistrationAge() {
        return strregistrationAge;
    }

    public String getStrregistrationAddress() {
        return strregistrationAddress;
    }

    public String getSpinnerMF() {
        return spinnerMF;
    }
}
