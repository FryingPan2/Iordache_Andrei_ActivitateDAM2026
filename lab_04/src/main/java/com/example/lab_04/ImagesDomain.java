package com.example.lab_04;

import android.graphics.Bitmap;

public class ImagesDomain {

    private String textAfisat;
    private Bitmap image;
    private String link;

    public ImagesDomain(String textAfisat, Bitmap image, String link) {
        this.textAfisat = textAfisat;
        this.image = image;
        this.link = link;
    }

    public String getTextAfisat() {
        return textAfisat;
    }

    public void setTextAfisat(String textAfisat) {
        this.textAfisat = textAfisat;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
