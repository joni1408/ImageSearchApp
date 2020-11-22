package com.example.imagesearchapp.ui.imageDetails;

import android.util.Log;

import com.example.imagesearchapp.db.ImageDatabase;
import com.example.imagesearchapp.models.Data;

public class ImageDetailsRepository {

    private ImageDatabase mImageDatabase;

    public ImageDetailsRepository(ImageDatabase imageDatabase) {
        mImageDatabase = imageDatabase;
    }

    public void setCaptionForImage(Data data) {
        if (mImageDatabase != null)
            mImageDatabase.getImageDao().insertComment(data);
        else
            Log.d("ImageRepo", "database was null");
    }

    public Data getCaptionForImage(Integer account_id) {
        Data  data = null;
        if (mImageDatabase != null)
            data = mImageDatabase.getImageDao().getComment(account_id);
        else
            Log.d("ImageRepo", "database was null");
        return data;
    }
}
