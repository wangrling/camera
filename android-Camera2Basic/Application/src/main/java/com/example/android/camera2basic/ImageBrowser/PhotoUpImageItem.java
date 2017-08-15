package com.example.android.camera2basic.ImageBrowser;

import java.io.Serializable;

/**
 * Created by wang on 17-8-15.
 */

public class PhotoUpImageItem implements Serializable{
    private String imageId;
    private String imagePath;
    private boolean isSelected = false;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
