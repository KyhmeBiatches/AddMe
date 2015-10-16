package com.example.maaaarckyo.addme.Models;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class ApplicationStart extends Application
{
    @Override
    public  void onCreate()
    {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        // Parse.enableLocalDatastore(this);
        Parse.initialize(this, "8qh4MmT3iG7ITNMtORvjUngTX2gO8cdFPcWrtoEZ", "v9mQBnHSpAbK1Zc1pmwahWYCsA5gVkNWciu6qQxx");


        ParseUser.enableAutomaticUser();
        ParseACL defACL = new ParseACL();

        defACL.setPublicReadAccess(true);
        defACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defACL, true);


//        Associate device with a user
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put("user", ParseUser.getCurrentUser());
        installation.saveInBackground();
    }
}