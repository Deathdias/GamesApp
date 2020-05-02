package com.example.my_project.Fragments;

import android.os.Bundle;
import android.text.style.BulletSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_project.Application.MyApplication;
import com.example.my_project.LoginActivity;
import com.example.my_project.R;
import com.example.my_project.database.Login;
import com.example.my_project.database.LoginDao;
import com.example.my_project.database.MyDatabase;

import org.w3c.dom.Text;

import java.util.List;

public class Profile extends Fragment {
    private Button update,delete;
    private TextView name;
    private LoginActivity loginActivity;
    private int id;
    MyDatabase database;
    LoginDao loginDao;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_profile,container,false);
        name = view.findViewById(R.id.profile_name);
        update = view.findViewById(R.id.profile_update_button);
        delete = view.findViewById(R.id.profile_delete_button);
        database = MyApplication.getInstance().getDatabase();
        loginDao = database.loginDao();
        Bundle bundle = new Bundle();

//        id = loginActivity.getId();
//
//        List<Login> logins = loginDao.getAll();
//        for (Login login : logins){
//            if(login.ID == id){
//                name.setText(login.Name);
//                Log.e("Profile","setName: OK");
//            }
//        }

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Profile","Update: OK");
                PwdDialog pwdDialog = new PwdDialog();
                FragmentManager fragmentTransaction =getFragmentManager();
                pwdDialog.show(fragmentTransaction,"missiles");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteDialog deleteDialog = new DeleteDialog();
                FragmentManager fragmentTransaction =getFragmentManager();
                deleteDialog.show(fragmentTransaction,"missiles");
                Log.e("Profile","Delete: OK");
            }
        });
        return view;
    }
}
