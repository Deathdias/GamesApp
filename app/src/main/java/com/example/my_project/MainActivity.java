package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.my_project.Application.MyApplication;
import com.example.my_project.Fragments.FirstFragment;
import com.example.my_project.Fragments.MyDialog;
import com.example.my_project.Fragments.Profile;
import com.example.my_project.Fragments.SecondFragment;
import com.example.my_project.database.Games;
import com.example.my_project.database.GamesDao;
import com.example.my_project.database.Login;
import com.example.my_project.database.MyDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    EditText name,creator,star,weight,genre,age,downloaded;
    MyDatabase database;
    GamesDao gamesDao;
    private LoginActivity loginActivity;
    private int Id;
    private ImageView buttonDialog;
    private CircleImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDialog = findViewById(R.id.button_dialog);
        imageView = findViewById(R.id.circleImage_view);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                MyDialog myDialog = new MyDialog();
                fragmentManager2
                        .beginTransaction()
                        .add(R.id.frameLayout_dialog,myDialog)
                        .commit();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("MainActivity","ImageView: onClick: OK");
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                Profile profile = new Profile();
                fragmentManager3
                        .beginTransaction()
                        .replace(R.id.frameLayout_second,profile)
                        .commit();
            }
        });

        FirstFragment firstFragment = new FirstFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.frameLayout_first,firstFragment)
                .commit();

        SecondFragment secondFragment = new SecondFragment();
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        fragmentManager1
                .beginTransaction()
                .add(R.id.frameLayout_second,secondFragment)
                .commit();

    }

}
