package com.example.l176310_a3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ContactPer.class}, version = 1,exportSchema = true)
public abstract class ContactsDatabase extends RoomDatabase {
    public abstract DBsql DBsql();
}