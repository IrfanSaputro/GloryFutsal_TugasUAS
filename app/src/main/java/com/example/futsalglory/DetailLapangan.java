package com.example.futsalglory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailLapangan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lapangan);
    }
    public void goToAnActivity(View view) {
        Intent intent = new Intent(this, Transaksi.class);
        startActivity(intent);
    }
}
