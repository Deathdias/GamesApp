package com.example.my_project.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Login.class}, version = 2)
public abstract class MyDatabase extends RoomDatabase {
    public abstract LoginDao loginDao();
//    public abstract GamesDao gamesDao();
}
