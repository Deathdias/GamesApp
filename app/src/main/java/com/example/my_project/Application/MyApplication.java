package com.example.my_project.Application;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.example.my_project.database.MyDatabase;

public class MyApplication extends Application {
    // Singleton
    public static MyApplication myInstance;
    private MyDatabase database;
    public void onCreate() {
        super.onCreate();
        Log.e("MyApplication", "onCreate");
        myInstance = this;
        database = Room.databaseBuilder(this, MyDatabase.class, "DatabaseLogin")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
    public static MyApplication getInstance(){
        return myInstance;
    }
    public MyDatabase getDatabase(){
        return database;
    }
}
