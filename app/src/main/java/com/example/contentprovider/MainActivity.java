package com.example.contentprovider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyManHinhDanhBa();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyManHinhTinNhan();
            }
        });
    }

    private void xulyManHinhTinNhan() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{""+"android.permission.READ_SMS"}, REQUEST_SMS_ASK_PERMISSIONS);
        }else{
            Intent intent = new Intent(MainActivity.this, DocTinNhan.class);
            startActivity(intent);
        }
    }

    private void xulyManHinhDanhBa() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{""+"android.permission.READ_CONTACTS"}, REQUEST_CONTACTS_ASK_PERMISSIONS);
        }else{
            Intent intent = new Intent(this,DanhBa.class);
            extracted(intent);
        }

    }

    private void extracted(Intent intent) {
        startActivity(intent);
    }

    private void addControl() {
        btn1= findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }
}