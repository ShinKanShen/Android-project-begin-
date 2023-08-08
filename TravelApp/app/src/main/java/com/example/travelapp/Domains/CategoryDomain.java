package com.example.travelapp.Domains;

public class CategoryDomain {
    private String title;
    private String pic_path;

    public CategoryDomain(String title, String pic_path) {
        this.title = title;
        this.pic_path = pic_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path;
    }
}
