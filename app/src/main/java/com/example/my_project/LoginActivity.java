package com.example.my_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_project.Application.MyApplication;
import com.example.my_project.database.MyDatabase;
import com.example.my_project.database.Login;
import com.example.my_project.database.LoginDao;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginActivity extends AppCompatActivity{
    Button SignIn, SignUp;
    EditText name,password;
    @SerializedName("MyId")
    public int myId;
    MyDatabase database;
    LoginDao loginDao;
//    DbHelper dbHelper;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignIn = findViewById(R.id.sign_in_button);
        SignUp = findViewById(R.id.sign_up_button);
        name = findViewById(R.id.sign_in_name);
        password = findViewById(R.id.sign_in_pwd);

        database = MyApplication.getInstance().getDatabase();
        // Достаем база данных
        loginDao = database.loginDao();

        SignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String Name =name.getText().toString();
                String Password = password.getText().toString();
                Login login = new Login();
                login.Name = Name;
                login.Password = Password;
                // импортируем то что вели в EditView
                loginDao.insertLogin(login);
                // через Dao добавляем в таблицу
            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Password = password.getText().toString();
                List<Login> logins = loginDao.getAll();
                // проверка
                for (Login login : logins){
                    Log.e("Login",login.ID + " " + login.Name + " " + login.Password);
                    if(login.Name.equals(Name) && login.Password.equals(Password)){
                        Log.e("Login","Check: OK " + login.ID);
                        myId = login.ID;
                        Log.e("Login","MyId: " + myId);
                        GoToMainActivity();
                    }
                }
            }
        });
    }
    public void GoToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public int getId(){
        return myId;
    }
    public void setId(int id){
        this.myId = id;
    }
}
