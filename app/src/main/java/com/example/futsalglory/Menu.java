package com.example.futsalglory;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;


public class Menu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
//    private int[] mImages = new int[]{
//            R.drawable.futsal1,R.drawable.futsal2,R.drawable.futsal3,R.drawable.futsal4
//    };
//    private String[] mImagesTitle = new String[]{
//            "Lapangan 1","Lapangan 2","Lapangan 3","Lapangan 4"
//    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

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
//                Toast.makeText(Menu.this, mImagesTitle[position],Toast.LENGTH_SHORT).show();
//            }
//        });

        // kita set default nya Home Fragment
        loadFragment(new HomeFragment());
        // inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
//            case R.id.home_menu:
//                fragment = new HomeFragment();
//                break;
            case R.id.list_menu:
                fragment = new ListFragment();
                break;
            case R.id.maps_menu:
                fragment = new HistoryFragment();
                break;
            case R.id.about_us:
                fragment = new AboutFragment() ;
                break;
        }
        return loadFragment(fragment);
    }
}
