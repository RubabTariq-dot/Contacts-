package com.example.l176310_a3;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ContactPer {
    @ColumnInfo(name = "name")
    public String name;

    @PrimaryKey
    public int id;

    @NonNull
    @ColumnInfo(name = "number")
    public String number;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "email")
    public String email;


    public String getContactName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getContactNumber() {
        return number;
    }

    public String getContactPhoto() {
        return image;
    }

    public String getContactEmail() {
        return email;
    }
}

