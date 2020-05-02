package com.example.my_project.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// аннотация
@Entity
public class Login {
    @PrimaryKey(autoGenerate = true)
    public int ID;
    public String Name;
    public String Password;
}
