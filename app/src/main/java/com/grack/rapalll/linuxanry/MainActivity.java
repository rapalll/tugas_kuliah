package com.grack.rapalll.linuxanry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.grack.rapalll.linuxanry.ListLinux.ListLinuxActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button pengertian = findViewById(R.id.btnPengertian);
        Button dasar   = findViewById(R.id.btnPerintahDasar);
        Button Lanjutan = findViewById(R.id.btnLanjutan);

    }

    public void pengertian (View view){
        Intent intent = new Intent(MainActivity.this, ListLinuxActivity.class);
        startActivity(intent);
    }
}
