package com.grack.rapalll.linuxanry.ListLinux;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.Toast;

import com.grack.rapalll.linuxanry.Adapter.AdapterPengertian;
import com.grack.rapalll.linuxanry.model.ModelLinux;
import com.grack.rapalll.linuxanry.R;

import java.util.ArrayList;
import java.util.List;

public class ListLinuxActivity extends AppCompatActivity implements LinuxView {

    private RecyclerView recyclerView;
    private AdapterPengertian adapterPengertian;
    private  List<ModelLinux> modelLinuxes = new ArrayList<>();
    private  LinuxPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengertian);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.rv_pengertian);
        progressDialog = new ProgressDialog(this);
        presenter = new LinuxPresenterImp(this);
        setupData();
        presenter.loadListLinux();
    }
    private void setupData(){
        adapterPengertian = new AdapterPengertian(modelLinuxes, ListLinuxActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterPengertian);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate menu to add items to action bar if it is present.
        inflater.inflate(R.menu.search_menu, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(ListLinuxActivity.this, "Pencarian Berhasil", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public void showLoading() {
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(true);
        progressDialog.show();

    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();

    }

    @Override
    public void showListLinux(List<ModelLinux> listLinux) {
        modelLinuxes.clear();
        modelLinuxes.addAll(listLinux);
        adapterPengertian.notifyDataSetChanged();

    }
}
