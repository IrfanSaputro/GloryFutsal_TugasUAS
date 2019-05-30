package com.example.futsalglory;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Transaksi2 extends AppCompatActivity {
    private ImageView imageHolder;
    Button save;
    Button checkout;
    private EditText nama;
    private EditText telepon;
    private EditText tanggal;
    private TextView harga;
    private final int requestCode = 1;

    BitmapDrawable drawable;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi2);
        //button send data
        nama =(EditText)findViewById(R.id.editTextNama);
        telepon =(EditText)findViewById(R.id.editTextNo);
        tanggal =(EditText)findViewById(R.id.editTextTanggal);
        final Spinner spinner = (Spinner) findViewById(R.id.Spinner01);
        harga = (TextView) findViewById(R.id.textharga);

        //spinner
        final String[] arraySpinner = new String[] {
                "Lama Sewa Lapangan", "1 Jam", "2 Jam", "3 Jam", "4 Jam", "5 Jam", "6 Jam"
        };
        final Spinner s = (Spinner) findViewById(R.id.Spinner01);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        //camera api
        ActivityCompat.requestPermissions(Transaksi2.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        imageHolder = (ImageView)findViewById(R.id.captured_photo);
        save = (Button)findViewById(R.id.Save);
        Button capturedImageButton = (Button)findViewById(R.id.take_picture);
        capturedImageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, requestCode);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable = (BitmapDrawable)imageHolder.getDrawable();
                bitmap = drawable.getBitmap();

                FileOutputStream outputStream = null;

                File sdCard = Environment.getExternalStorageDirectory();

                File directory = new File(sdCard.getAbsolutePath() + "/YourFolderName");
                directory.mkdirs();
                String fileName = String.format("%d.jpg", System.currentTimeMillis());
                File outFile = new File(directory, fileName);

                Toast.makeText(Transaksi2.this, "Foto berhasil disimpan", Toast.LENGTH_SHORT).show();

                try {
                    outputStream = new FileOutputStream(outFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    outputStream.flush();
                    outputStream.close();

                    Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    intent.setData(Uri.fromFile(outFile));
                    sendBroadcast(intent);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        checkout = (Button) findViewById(R.id.btnbok);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Transaksi2.this, Checkout2.class);
                intent.putExtra("nama", nama.getText().toString());
                intent.putExtra("telepon", telepon.getText().toString());
                intent.putExtra("tanggal", tanggal.getText().toString());
                intent.putExtra("data",String.valueOf(spinner.getSelectedItem()));
                int index = s.getSelectedItemPosition();
                if(index>0)
                {
                    String spiner = arraySpinner[index];
                    if ( spiner.equals("1 Jam")) {
                        harga.setText("Rp. 120.000");
                        intent.putExtra("harga", harga.getText());
                    }
                    else if (spiner.equals("2 Jam")){
                        harga.setText("Rp. 240.000");
                        intent.putExtra("harga", harga.getText());

                    } else if (spiner.equals("3 Jam")){
                        harga.setText("Rp. 360.000");
                        intent.putExtra("harga", harga.getText());

                    } else if (spiner.equals("4 Jam")){
                        harga.setText("Rp. 480.000");
                        intent.putExtra("harga", harga.getText());

                    } else if (spiner.equals("5 Jam")){
                        harga.setText("Rp. 600.000");
                        intent.putExtra("harga", harga.getText());

                    } else if (spiner.equals("6 Jam")){
                        harga.setText("Rp. 720.000");
                        intent.putExtra("harga", harga.getText());

                    }
                }
//                intent.putExtra("harga", harga.getText());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.requestCode == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }


}

