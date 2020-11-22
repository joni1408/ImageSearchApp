package com.example.imagesearchapp.ui.imageDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.imagesearchapp.models.Data;

public class ImageDetailsViewModel extends ViewModel {

    private ImageDetailsRepository mImageDetailsRepository;

    private MutableLiveData<Boolean> success = new MutableLiveData();

    public ImageDetailsViewModel(ImageDetailsRepository imageDetailsRepository) {
        mImageDetailsRepository = imageDetailsRepository;
    }

    public void setImageCaption(Data data) {
        mImageDetailsRepository.setCaptionForImage(data);
    }

    public Data getImageCaption(Integer account_id) {
        return mImageDetailsRepository.getCaptionForImage(account_id);
    }


}
