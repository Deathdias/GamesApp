package com.example.my_project.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class DeleteDialog extends DialogFragment {
    private MyDatabase database;
    private LoginDao loginDao;
    private EditText password, name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dlt_dialog, container,false);
        password = view.findViewById(R.id.delete_password);
        name = view.findViewById(R.id.delete_name);
        return view;
    }
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.activity_dlt_dialog,null))
                .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        database = MyApplication.getInstance().getDatabase();
                        loginDao = database.loginDao();
                        String Pwd = password.getText().toString();
                        String Name = name.getText().toString();
                        List<Login> logins = loginDao.getAll();
                        for (Login login : logins){
                            if(login.Password.equals(Pwd) && login.Name.equals(Name)){
                                Log.e("Pwd Dialog","Delete: OK " + login.ID);
                                loginDao.deleteLogin(login);
                            }
                        }

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DeleteDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
