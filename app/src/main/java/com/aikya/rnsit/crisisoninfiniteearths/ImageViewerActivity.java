package com.aikya.rnsit.crisisoninfiniteearths;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewerActivity extends Activity {
    public static final String IMAGE_ID="ImageViewerActivity.IMAGE_ID";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        imageView=findViewById(R.id.image_view);
        imageView.setImageResource(getIntent().getIntExtra(IMAGE_ID,0));
    }
}
