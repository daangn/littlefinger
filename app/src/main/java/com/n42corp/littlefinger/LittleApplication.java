package com.n42corp.littlefinger;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;

/**
 * Created by seapy on 2015. 8. 11..
 */
public class LittleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseCrashReporting.enable(this);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, BuildConfig.PARSE_APPLICATION_ID, BuildConfig.PARSE_CLIENT_KEY);

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(false);
        defaultACL.setPublicWriteAccess(false);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
