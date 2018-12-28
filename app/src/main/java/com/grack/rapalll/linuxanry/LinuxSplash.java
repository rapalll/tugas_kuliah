package com.grack.rapalll.linuxanry;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LinuxSplash extends AppCompatActivity {

    private int loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux__splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(LinuxSplash.this, MainActivity.class);
                startActivity(home);
                finish();
            }
        },loading);
    }
}
