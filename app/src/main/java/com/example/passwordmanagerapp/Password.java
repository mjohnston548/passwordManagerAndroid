package com.example.passwordmanagerapp;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.MissingFormatArgumentException;


public class Password {
    private String passwordDigits;
    private Date passwordDateCreated;
    private String websiteApp;
    private String usernameEmail;
    private String passwordCategory;

    public Password(String passwordDigits, String usernameEmail, String websiteApp, String passwordCategory ,Date passwordDateCreated)  {
        setPasswordDigits(passwordDigits);

        setUsernameEmail(usernameEmail);
        setWebsiteApp(websiteApp);
        setPasswordCategory(passwordCategory);
        this.passwordDateCreated=passwordDateCreated;

    }

    public String getPasswordDigits() {
        return passwordDigits;
    }

    public Date getPasswordDateCreated() {
        return passwordDateCreated;
    }

    public String getUsernameEmail() {
        return usernameEmail;
    }

    public String getWebsiteApp() {
        return websiteApp;
    }

    public String getPasswordCategory() {
        return passwordCategory;
    }

    public void setPasswordDigits(String passwordDigits) {
        this.passwordDigits = passwordDigits;
        if (passwordDigits.length()<10){
            throw new IllegalArgumentException("You must fill all password blocks with 2 digits");
        }
    }

    public void setUsernameEmail(String usernameEmail) {
        this.usernameEmail = usernameEmail;
        if (usernameEmail.equals("")){
            throw new IllegalArgumentException("You must enter a username");
        }
    }

    public void setWebsiteApp(String websiteApp) {
        this.websiteApp = websiteApp;
        if (websiteApp.equals("")){
            throw new IllegalArgumentException("You must enter a website or app name");
        }
    }

    public void setPasswordCategory(String passwordCategory) {
        this.passwordCategory = passwordCategory;
    }
}
