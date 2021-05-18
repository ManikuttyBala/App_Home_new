package com.example.home_page;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp_page extends AppCompatActivity {

    Button SignUp,LogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_page);

        SignUp = findViewById(R.id.reg_btn);
        LogIn = findViewById(R.id.logIn_btn);
    /*    image = findViewById(R.id.logo_image);
        logoText= findViewById(R.id.welcome);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);*/

        SignUp.setOnClickListener(view -> {

            Intent intent = new Intent(SignUp_page.this, Login_page.class);
            startActivity(intent);


        });

        LogIn.setOnClickListener(view -> {

            Intent intent = new Intent(SignUp_page.this, Login_page.class);
            startActivity(intent);

        });



    }
}