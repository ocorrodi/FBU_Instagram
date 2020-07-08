package com.example.fbu_instagram;

import android.app.Application;
import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("fbu--parstagram") // should correspond to APP_ID env variable
                .clientKey("FBUCodepathParstagram")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://fbu--parstagram.herokuapp.com/parse").build());
    }
}
