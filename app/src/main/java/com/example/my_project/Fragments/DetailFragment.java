package com.example.my_project.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.my_project.Application.MyApplication;
import com.example.my_project.Lists.SecondList;
import com.example.my_project.R;
import com.example.my_project.database.LoginDao;
import com.example.my_project.database.MyDatabase;

public class DetailFragment extends Fragment {
    private TextView name,creator, star,download,age,genre,desc;
    ImageView image;
    MyDatabase database;
    LoginDao loginDao;
    private int position;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail,container,false);
        name = view.findViewById(R.id.detail_name);
        creator = view.findViewById(R.id.detail_creator);
        star = view.findViewById(R.id.detail_star);
        download = view.findViewById(R.id.detail_download);
        genre = view.findViewById(R.id.detail_genre);
        age = view.findViewById(R.id.detail_age);
        desc = view.findViewById(R.id.detail_desc);
        image = view.findViewById(R.id.detail_image);

        database = MyApplication.getInstance().getDatabase();
        loginDao = database.loginDao();

        name.setText(SecondList.second_name[position]);



        return view;

    }
}
