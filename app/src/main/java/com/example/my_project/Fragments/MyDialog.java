package com.example.my_project.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_project.Lists.SecondList;
import com.example.my_project.LoginActivity;
import com.example.my_project.MainActivity;
import com.example.my_project.R;
import com.example.my_project.database.Login;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyDialog extends Fragment {
    private Button profile,my_games,LogOut;
    private CircleImageView image;
    Context mContext;
    public static MyDialog newInstance(){ return new MyDialog(); }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_dialog, container,false);
        profile =view.findViewById(R.id.dialog_profile);
        my_games = view.findViewById(R.id.dialog_games);
        image = view.findViewById(R.id.dialog_image);
        profile.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                Log.e("Profile","onClick: OK");
                Profile profile = new Profile();
                FragmentManager fragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout_second, profile)
                        .commit();
            }
        });
        my_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("MyDialog","My Games: OK");
            }
        });
//        LogOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GoToLoginActivity();
//                Intent intent = new Intent(this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
        return view;
    }
//    public void GoToLoginActivity(){
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
//    }
}
