package com.example.tebakgambar.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Gambar implements Parcelable {
    private String name;
    private String imageUrl;

    public Gambar(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private Gambar(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Gambar> CREATOR = new Creator<Gambar>() {
        @Override
        public Gambar createFromParcel(Parcel in) {
            return new Gambar(in);
        }

        @Override
        public Gambar[] newArray(int size) {
            return new Gambar[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.imageUrl);
    }
}
