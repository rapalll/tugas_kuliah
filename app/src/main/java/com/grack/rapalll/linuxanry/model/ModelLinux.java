package com.grack.rapalll.linuxanry.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelLinux implements Parcelable {
    private String namaPerintah, penjelasan;

    public ModelLinux(String namaPerintah, String penjelasan){
        this.namaPerintah = namaPerintah;
        this.penjelasan = penjelasan;
    }

    public ModelLinux(){

    }
    protected ModelLinux(Parcel in){
        this.namaPerintah = in.readString();
        this.penjelasan = in.readString();
    }

    public static final Creator<ModelLinux> CREATOR = new Creator<ModelLinux>() {
        @Override
        public ModelLinux createFromParcel(Parcel source) {
            return new ModelLinux((source));
        }

        @Override
        public ModelLinux[] newArray(int size) {
            return new ModelLinux[size];
        }
    };

    public String getNamaPerintah(){
        return namaPerintah;
    }

    public void setNamaPerintah(String namaPerintah) {
        this.namaPerintah = namaPerintah;
    }

    public String getPenjelasan(){
        return getPenjelasan();
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namaPerintah);
        dest.writeString(penjelasan);

    }
}
