package com.example.l176310_a3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

    @Dao
    public interface DBsql {
        @Query("SELECT * FROM ContactPer")
        List<ContactPer> getAll();

        @Insert
        void insert(ContactPer newContactPer);

        @Delete
        void delete(ContactPer oldContactPer);
    }
