package com.example.fbu_instagram;

import android.widget.ImageView;

import com.parse.ParseUser;

import org.parceler.Parcel;

@Parcel
public class PostDetail {
    public String username;
    public String caption;
    public String image;
    public String time;
    public String profile;
    public ParseUser user;


    public PostDetail() {}

    public PostDetail(String username, String caption, String image, String time, String profile, ParseUser user) {
        this.username = username;
        this.caption = caption;
        this.image = image;
        this.time = time;
        this.profile = profile;
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public ParseUser getUser() {
        return user;
    }

    public void setUser(ParseUser user) {
        this.user = user;
    }
}
