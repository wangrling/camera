package com.example.android.camera2basic.ImageBrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.camera2basic.R;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang on 17-8-15.
 */

public class ImageBrowserActivity extends Activity {
    private GridView gridView;
    private AlbumsAdapter adapter;
    private PhotoUpAlbumHelper mPhotoUpAlbumHelper;
    private List<PhotoUpImageBucket> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_browser_image);
        init();
        loadData();
        onItemClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void onItemClick() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ImageBrowserActivity.this, AlbumItemActivity.class);
                intent.putExtra("imagelist", list.get(position));
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        mPhotoUpAlbumHelper =PhotoUpAlbumHelper.getHelper();
        mPhotoUpAlbumHelper.init(ImageBrowserActivity.this);
        mPhotoUpAlbumHelper.setGetAlbumList(new PhotoUpAlbumHelper.GetAlbumList() {
            @Override
            public void getAlbumList(List<PhotoUpImageBucket> list) {
                adapter.setArrayList(list);
                adapter.notifyDataSetChanged();
                ImageBrowserActivity.this.list = list;
            }
        });
        mPhotoUpAlbumHelper.execute(false);
    }


    private void init() {
        gridView = (GridView) findViewById(R.id.album_grid);
        adapter = new AlbumsAdapter(ImageBrowserActivity.this);
        gridView.setAdapter(adapter);
    }
}






















