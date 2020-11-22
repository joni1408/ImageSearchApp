package com.example.imagesearchapp.ui.imageDetails;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.imagesearchapp.R;
import com.example.imagesearchapp.databinding.ActivityImageDetailsBinding;
import com.example.imagesearchapp.db.ImageDatabase;
import com.example.imagesearchapp.models.Data;
import com.example.imagesearchapp.utils.Toaster;
import com.example.imagesearchapp.viewmodelfactory.ImageViewModelFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageDetailsActivity extends AppCompatActivity {

    private Data imageData = null;
    private ActivityImageDetailsBinding mBinding = null;
    private int position = 0;

    private ImageDetailsRepository imageDetailsRepository;
    private ImageDetailsViewModel imageDetailsViewModel;
    private static final int NUMBER_OF_THREADS = 1;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    @Override
    protected void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_image_details);
        ImageDatabase instance = ImageDatabase.Companion.invoke(this);
        imageDetailsRepository = new ImageDetailsRepository(instance);

        ImageViewModelFactory viewModelFactory = new ImageViewModelFactory(imageDetailsRepository);
        imageDetailsViewModel = new ViewModelProvider(this, viewModelFactory).get(ImageDetailsViewModel.class);

        setSupportActionBar(mBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mBinding.toolbar.setNavigationOnClickListener(v -> finish());

        if (getIntent().hasExtra("data")) {
            imageData = (Data) getIntent().getSerializableExtra("data");
            position = getIntent().getIntExtra("position", 0);
            getSupportActionBar().setTitle(imageData.getTitle());
            if (imageData != null) {
                Glide.with(this).load(String.format("https://i.imgur.com/%ss.jpg", imageData.is_album() ? imageData.getCover() : imageData.getId())).placeholder(R.drawable.ic_action_image)
                        .into(mBinding.ivImage);
            }
            Data comment = imageDetailsViewModel.getImageCaption(imageData.getAccount_id());
            if(comment !=null && !TextUtils.isEmpty(comment.getDescription()))
            mBinding.etCaption.setText(comment.getDescription());
        }

        mBinding.btnSubmit.setOnClickListener(v -> {
            if (mBinding.etCaption.getText().toString().trim().length() > 0) {
                imageData.setDescription(mBinding.etCaption.getText().toString().trim());
                imageDetailsViewModel.setImageCaption(imageData);
                Toaster.INSTANCE.show(this,"Comment Saved");
            }
        });
    }

}
