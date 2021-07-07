package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("9WnV4iSpyCeJhDv3ExPN5gfEJM1kPnfjGyrumWVU")
                .clientKey("iwLxFdokovp43tQxMFJxsGSAfnuaJfVIBaNnjrEA")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
