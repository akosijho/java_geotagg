package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Login_Page extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView username =(TextView) findViewById(R.id.et_username);
        TextView password =(TextView) findViewById(R.id.et_password);

        MaterialButton loginbtn = (MaterialButton)  findViewById(R.id.btn_login);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    //correct
                    Toast.makeText(Login_Page.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Admin_HomePage.class);
                    startActivity(intent);

                }else if(username.getText().toString().equals("head") && password.getText().toString().equals("head")) {
                    Toast.makeText(Login_Page.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Head_HomePage.class);
                    startActivity(intent);

                }else if (username.getText().toString().equals("employee") && password.getText().toString().equals("employee")){
                    Toast.makeText(Login_Page.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Employee_HomePage.class);
                    startActivity(intent);

                }else
                    //incorrect
                    Toast.makeText(Login_Page.this,"LOGIN FAILED!",Toast.LENGTH_SHORT).show();

            }
        });
    }
}