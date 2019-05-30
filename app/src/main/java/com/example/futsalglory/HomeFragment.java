package com.example.futsalglory;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {

//    private int[] mImages = new int[]{
//            R.drawable.futsal1,R.drawable.futsal2,R.drawable.futsal3,R.drawable.futsal4
//    };
//    private String[] mImagesTitle = new String[]{
//            "Lapangan 1","Lapangan 2","Lapangan 3","Lapangan 4"
//    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }
//    @Nullable

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//        VideoView video = (VideoView)findViewById(R.id.video);
//        Uri letakVideo = Uri.parse("android.resource://"+ getPackageName()+"/"+R.raw.video1);
//        video.setVideoURI(letakVideo);
//        video.start();
//
//
//        CarouselView carouselView = findViewById(R.id.carouselView);
//        carouselView.setPageCount(mImages.length);
//        carouselView.setImageListener(new ImageListener() {
//            @Override
//            public void setImageForPosition(int position, ImageView imageView) {
//                imageView.setImageResource(mImages[position]);
//
//            }
//        });
//        carouselView.setImageClickListener(new ImageClickListener() {
//            @Override
//            public void onClick(int position) {
//                Toast.makeText(HomeFragment.this, mImagesTitle[position],Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
