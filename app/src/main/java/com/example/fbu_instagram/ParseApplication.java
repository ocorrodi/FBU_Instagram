package com.example.fbu_instagram;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("fbu--parstagram") // should correspond to APP_ID env variable
                .clientKey("FBUCodepathParstagram")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://fbu--parstagram.herokuapp.com/parse").build());
    }
}
