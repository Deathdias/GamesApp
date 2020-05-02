package com.example.my_project.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.my_project.Application.MyApplication;
import com.example.my_project.R;
import com.example.my_project.database.Login;
import com.example.my_project.database.LoginDao;
import com.example.my_project.database.MyDatabase;

import java.util.List;

public class PwdDialog extends DialogFragment {
    private MyDatabase database;
    private LoginDao loginDao;
    private EditText old_pwd, new_pwd, name;
    private Button cancel,update;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_pwd_dialog, container,false);
        old_pwd = view.findViewById(R.id.old_pwd);
        new_pwd = view.findViewById(R.id.new_pwd);
        name = view.findViewById(R.id.pwd_dialog_name);
        cancel = view.findViewById(R.id.cancel_button_pwd_dialog);
        update = view.findViewById(R.id.update_button);
//        Log.e("Pwd Dialog","onCreateView: " + name + " " + " " + old_pwd + " "+ new_pwd);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = MyApplication.getInstance().getDatabase();
                loginDao = database.loginDao();
                String Old_pwd = old_pwd.getText().toString();
                String New_pwd = new_pwd.getText().toString();
                String Name = name.getText().toString();
                List<Login> logins = loginDao.getAll();
                Log.e("Pwd Dialog","Old: " + Old_pwd + " Name: " + Name);
                for (Login login : logins){
                    if(login.Password.equals(Old_pwd) && login.Name.equals(Name)){
                        login.Password = New_pwd;
                        loginDao.updateLogin(login);
                        Log.e("Pwd Dialog","Update: OK " + login.ID);

                    }
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PwdDialog.this.getDialog().cancel();
            }
        });
        return view;
    }
//    public Dialog onCreateDialog(Bundle savedInstanceState){
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        builder.setView(inflater.inflate(R.layout.activity_pwd_dialog,null))
//                .setPositiveButton(R.string.update, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        database = MyApplication.getInstance().getDatabase();
//                        loginDao = database.loginDao();
//                        old_pwd = inflater.inflate(R.layout.activity_pwd_dialog,null).findViewById(R.id.old_pwd);
//                        new_pwd = inflater.inflate(R.layout.activity_pwd_dialog,null).findViewById(R.id.new_pwd);
//                        name = inflater.inflate(R.layout.activity_pwd_dialog,null).findViewById(R.id.pwd_dialog_name);
//                        Log.e("Pwd Dialog","onCreateView: " + name + " " + " " + old_pwd + " "+ new_pwd);
//                        Log.e("Pwd Dialog","onCreate: OK");
//                        String Old_pwd = old_pwd.getText().toString();
//                        String New_pwd = new_pwd.getText().toString();
//                        String Name = name.getText().toString();
//                        Log.e("Pwd Dialog","Old_pwd: " + Old_pwd + " Name: " + Name);
//                        List<Login> logins = loginDao.getAll();
//
//                        for (Login login : logins){
//                            Log.e("Pwd Dialog","Login:"+login.Name+"Pwd:"+login.Password);
//                            if(login.Password == Old_pwd && login.Name == Name){
//                                login.Password = New_pwd;
//                                Log.e("Pwd Dialog","Update: OK " + login.ID);
//                                loginDao.updateLogin(login);
//                            }
//                        }
//
//                    }
//                })
//                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        PwdDialog.this.getDialog().cancel();
//                    }
//                });
//        return builder.create();
//    }
}
