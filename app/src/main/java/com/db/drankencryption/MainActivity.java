package com.db.drankencryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void encrypt(View v){
        Intent intent = new Intent(MainActivity.this, Encrypt.class);
        startActivity(intent);
    }

    public void decrypt(View v){
        Intent intent = new Intent(MainActivity.this, Decrypt.class);
        startActivity(intent);
    }
}