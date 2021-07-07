package com.example.hellofragmentviewpager.fragmentinfragment;

public class Photo {
    private int idResImage;
    private String photoBy;

    public Photo(int idResImage, String photoBy) {
        this.idResImage = idResImage;
        this.photoBy = photoBy;
    }

    public int getIdResImage() {
        return idResImage;
    }

    public void setIdResImage(int idResImage) {
        this.idResImage = idResImage;
    }

    public String getPhotoBy() {
        return photoBy;
    }

    public void setPhotoBy(String photoBy) {
        this.photoBy = photoBy;
    }
}
