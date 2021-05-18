package com.example.home_page;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import static android.app.ActivityOptions.makeSceneTransitionAnimation;

public class Login_page extends AppCompatActivity {

    //variables
    Button callSignUp,login_btn;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_page);


//assigning variables
        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.logo_image);
        logoText= findViewById(R.id.welcome);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);


        callSignUp.setOnClickListener(view -> {

            Intent intent = new Intent(Login_page.this, SignUp_page.class);

            Pair[] pairs = new Pair[7];

            pairs[0] = new Pair<View,String>(image, "logo_image");
            pairs[1] = new Pair<View,String>(logoText, "logo_text");
            pairs[2] = new Pair<View,String>(sloganText, "logo_desc");
            pairs[3] = new Pair<View,String>(username, "username_tran");
            pairs[4] = new Pair<View,String>(password, "password_tran");
            pairs[5] = new Pair<View,String>(login_btn, "button_tran");
            pairs[6] = new Pair<View,String>(callSignUp, "login_signup_tran");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login_page.this, pairs);
            startActivity(intent, options.toBundle());

        });

        login_btn.setOnClickListener(view -> {

            Intent intent = new Intent(Login_page.this, Home_page.class);
            startActivity(intent);

        });


    }
}