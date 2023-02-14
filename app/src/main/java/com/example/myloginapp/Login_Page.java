package com.example.myloginapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Login_Page extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth auth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        auth = FirebaseAuth.getInstance();
        TextView username =(TextView) findViewById(R.id.et_username);
        TextView password =(TextView) findViewById(R.id.et_password);

        MaterialButton loginbtn = (MaterialButton)  findViewById(R.id.btn_login);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(Login_Page.this,"LOGIN FAILED!",Toast.LENGTH_SHORT).show();
                }else{
                    login(username.getText().toString(), password.getText().toString());
                }
//                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
//                    //correct
//                    Toast.makeText(Login_Page.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), Admin_HomePage.class);
//                    startActivity(intent);
//
//                }else if(username.getText().toString().equals("head") && password.getText().toString().equals("head")) {
//                    Toast.makeText(Login_Page.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), Head_HomePage.class);
//                    startActivity(intent);
//
//                }else if (username.getText().toString().equals("employee") && password.getText().toString().equals("employee")){
//                    Toast.makeText(Login_Page.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(), Employee_HomePage.class);
//                    startActivity(intent);
//
//                }else
//                    //incorrect
//                    Toast.makeText(Login_Page.this,"LOGIN FAILED!",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void login(String username, String password){
        username = username+"@geo.com";
        auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
//                            updateUI(user);


                    Intent intent = new Intent(getApplicationContext(), Employee_HomePage.class);
                    startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login_Page.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
    }
}


