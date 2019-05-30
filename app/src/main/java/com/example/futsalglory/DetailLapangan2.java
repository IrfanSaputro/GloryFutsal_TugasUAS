package com.example.futsalglory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailLapangan2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lapangan2);
    }
    public void goToAnActivity2(View view) {
        Intent intent = new Intent(this, Transaksi2.class);
        startActivity(intent);
    }
}
