package com.example.android.camera2basic.ImageBrowser;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.camera2basic.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 17-8-15.
 */

public class AlbumsAdapter extends BaseAdapter{
    private final static String TAG = AlbumsAdapter.class.getSimpleName();

    private List<PhotoUpImageBucket> arrayList;
    private LayoutInflater mLayoutInflater;
    private ImageLoader mImageLoader= ImageLoader.getInstance();
    private DisplayImageOptions options;

    public AlbumsAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        arrayList = new ArrayList<PhotoUpImageBucket>();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .memoryCacheExtraOptions(96, 120)
                .build();
        // Initialize ImageLoader with configuration
        mImageLoader.init(configuration);

        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.album_default_loading_pic) // Setting photos between loading
                .showImageForEmptyUri(R.drawable.album_default_loading_pic)
                .showImageOnFail(R.drawable.album_default_loading_pic)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .build();

    };



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = mLayoutInflater.inflate(R.layout.ablums_adapter_item, parent, false);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.count = (TextView) convertView.findViewById(R.id.count);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.count.setText("" + arrayList.get(position).getCount());
        holder.name.setText(arrayList.get(position).getBucketName());
        mImageLoader.displayImage("file://"+arrayList.get(position).getImageList().get(0).getImagePath(), holder.image, options);

        return convertView;
    }

    private class Holder {
        ImageView image;
        TextView name;
        TextView count;
    }
    public void setArrayList(List<PhotoUpImageBucket> arrayList) {
        this.arrayList = arrayList;
    }
}


























