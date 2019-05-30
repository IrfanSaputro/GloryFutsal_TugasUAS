package com.example.futsalglory;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class Home extends AppCompatActivity {
    private int[] mImages = new int[]{
            R.drawable.futsal1,R.drawable.futsal2,R.drawable.futsal3,R.drawable.futsal4
    };
    private String[] mImagesTitle = new String[]{
            "Lapangan 1","Lapangan 2","Lapangan 3","Lapangan 4"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        VideoView video = (VideoView)findViewById(R.id.video);
        Uri letakVideo = Uri.parse("android.resource://"+ getPackageName()+"/"+R.raw.video1);
        video.setVideoURI(letakVideo);
        video.start();

        CarouselView carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);

            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(Home.this, mImagesTitle[position],Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goToAnActivity2(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}
