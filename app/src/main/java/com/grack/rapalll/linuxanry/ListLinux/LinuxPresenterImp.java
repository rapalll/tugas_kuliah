package com.grack.rapalll.linuxanry.ListLinux;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.grack.rapalll.linuxanry.model.ModelLinux;

import java.util.ArrayList;
import java.util.List;

public class LinuxPresenterImp implements LinuxPresenter {

    private LinuxView linuxView;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Linux");
    private List<ModelLinux> linuxList;
    private String namaPerintah, penjelasan;

    LinuxPresenterImp (LinuxView view){
        this.linuxView = view;
    }

    @Override
    public void loadListLinux() {
        linuxView.showLoading();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                linuxList = new ArrayList<>();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    ModelLinux value = dataSnapshot1.getValue(ModelLinux.class);
                    ModelLinux fire = new ModelLinux();

                    namaPerintah = value.getNamaPerintah();
                    penjelasan = value.getPenjelasan();


                    fire.setNamaPerintah(namaPerintah);
                    fire.setPenjelasan(penjelasan);

                    linuxList.add(fire);
                    linuxView.showListLinux(linuxList);

                }

                linuxView.hideLoading();
                databaseReference.keepSynced(true);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }


            });
    }
}
