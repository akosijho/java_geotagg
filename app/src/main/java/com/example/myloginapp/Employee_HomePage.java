package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Employee_HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home_page);

        MaterialButton NewAddRecord_btn = (MaterialButton) findViewById(R.id.btn_newAddRecord);
        MaterialButton Records_btn = (MaterialButton) findViewById(R.id.btn_Records);

        NewAddRecord_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Employee_HomePage.this,"clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Forms.class);
                startActivity(intent);
            }
        });

        Records_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Employee_HomePage.this,"clicked",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Reports.class);
                startActivity(intent);
            }
        });

    }
}