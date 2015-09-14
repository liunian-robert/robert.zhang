package com.aqwx.bean;

public class brochure {
    private String id;
    private String name;
    private String image;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
public String toString() {
       return "brochure [id=" + this.id + ", name=" + this.name + ", image=" + this.image + "]";
       }
}
