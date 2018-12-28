package com.grack.rapalll.linuxanry;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.grack.rapalll.linuxanry.ListLinux.LinuxPresenter;
import com.grack.rapalll.linuxanry.ListLinux.LinuxView;
import com.grack.rapalll.linuxanry.model.ModelLinux;

import java.util.ArrayList;
import java.util.List;

public class DetailLinuxActivity extends AppCompatActivity  {

    private ModelLinux detail;
    private ProgressDialog progressDialog;
    private FloatingActionButton floatingActionButton;
    private TextView mPerintah, mPenjelasan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_linux);

        init();
        instansiate();
        loadData();

    }

    private void init() {
        mPenjelasan = (TextView) findViewById(R.id.tv_penjelasan);
        mPerintah = (TextView) findViewById(R.id.tv_istilah);

    }

    private void loadData() {
        mPenjelasan.setText(detail.getNamaPerintah());
        mPerintah.setText(detail.getPenjelasan());
    }

    private void instansiate() {
        progressDialog = new ProgressDialog(this);
        detail = new GsonBuilder().create().fromJson(getIntent().getStringExtra("detail"), ModelLinux.class);
        mPerintah.setText(detail.getNamaPerintah());
        mPenjelasan.setText(detail.getPenjelasan());

    }

}