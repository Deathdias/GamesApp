package com.example.my_project.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LoginDao {
    @Insert
    void insertLogin(Login login);
    @Delete
    void deleteLogin(Login login);
    @Update
    void updateLogin(Login login);

    @Query("SELECT * FROM login")
    List<Login> getAll();
//    @Query("SELECT Name FROM login")
//    List<Login> getName();


}
