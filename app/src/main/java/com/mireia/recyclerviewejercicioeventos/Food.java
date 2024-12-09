package com.mireia.recyclerviewejercicioeventos;

public class Food {

    private int image;
    private String title;
    private Boolean getit;

    public Food(int image, String title, Boolean getit){
        this.image = image;
        this.title = title;
        this.getit = getit;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getGetit() {
        return getit;
    }

    public void setGetit(Boolean getit) {
        this.getit = getit;
    }

    @Override
    public String toString() {
        return "Food{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", getit=" + getit +
                '}';
    }
}
