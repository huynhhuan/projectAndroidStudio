package com.example.bahuankt;

public class Book {
    private String link_avatar_img, content;

    public Book(String link_avatar_img, String content) {
        this.link_avatar_img = link_avatar_img;
        this.content = content;
    }

    public String getLink_avatar_img() {
        return link_avatar_img;
    }

    public void setLink_avatar_img(String link_avatar_img) {
        this.link_avatar_img = link_avatar_img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
