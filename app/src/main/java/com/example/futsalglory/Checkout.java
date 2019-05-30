package com.example.futsalglory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Checkout extends AppCompatActivity {

    private static final android.os.Environment Environment = null ;
    private static final android.util.Log Log = null ;
    private static final String LOG_TAG = null ;
    Button ss;
    Button kembali;
    private TextView nama;
    private TextView telepon;
    private TextView tanggal;
    private TextView harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        nama = (TextView) findViewById(R.id.textnama);
        telepon = (TextView) findViewById(R.id.texttelepon);
        tanggal = (TextView) findViewById(R.id.texttanggal);
        harga = (TextView) findViewById(R.id.textharga);


        nama.setText(getIntent().getStringExtra("nama"));
        telepon.setText(getIntent().getStringExtra("telepon"));
        tanggal.setText(getIntent().getStringExtra("tanggal"));
        harga.setText(getIntent().getStringExtra("harga"));
        TextView textView=(TextView) findViewById(R.id.textjam);
        Bundle bundle=getIntent().getExtras();
        String data=bundle.get("data").toString();
        textView.setText(data);


        kembali = (Button) findViewById(R.id.btnhome);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Checkout.this, Menu.class);
                startActivity(intent);
            }
        });

        ss = (Button) findViewById(R.id.btntrs);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = takeScreenshot();
                saveBitmap(bitmap);
            }
        });

    }
    public Bitmap takeScreenshot() {
        View rootView = findViewById(android.R.id.content).getRootView();
        rootView.setDrawingCacheEnabled(true);
        return rootView.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap) {
        File imagePath = new File(Environment.getExternalStorageDirectory() + "/screenshot.png");
        FileOutputStream fos;
        Toast.makeText(Checkout.this, "Bukti Transaksi Berhasil Di Simpan, Coba Cek Bukti Di Galeri ", Toast.LENGTH_LONG).show();
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }


}
