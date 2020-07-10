package com.example.fbu_instagram;

import android.widget.ImageView;

import org.parceler.Parcel;

@Parcel
public class PostDetail {
    public String username;
    public String caption;
    public String image;
    public String time;

    public PostDetail() {}

    public PostDetail(String username, String caption, String image, String time) {
        this.username = username;
        this.caption = caption;
        this.image = image;
        this.time = time;
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
}
