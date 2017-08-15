package com.example.android.camera2basic.ImageBrowser;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang on 17-8-15.
 */

public class PhotoUpImageBucket implements Serializable{
    public int count;
    public String bucketName;
    public List<PhotoUpImageItem> imageList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public List<PhotoUpImageItem> getImageList() {
        return imageList;
    }

    public void setImageList(List<PhotoUpImageItem> imageList) {
        this.imageList = imageList;
    }
}
