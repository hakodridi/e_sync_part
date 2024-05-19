package com.abdelhak.dridi.e_sync.activivties.auth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.abdelhak.dridi.e_sync.R;
import com.abdelhak.dridi.e_sync.activivties.SplashActivity;
import com.abdelhak.dridi.e_sync.activivties.teacher.TeacherHomeActivity;

public class LoginActivity extends AppCompatActivity {
    EditText usernameET, passwordET;
    ProgressDialog progress;
    ImageView eye, closedEye;
    boolean isPasswordShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progress = new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setCancelable(false);

        usernameET = findViewById(R.id.username_input);
        passwordET = findViewById(R.id.password_input);
        eye = findViewById(R.id.eye_btn);
        closedEye = findViewById(R.id.closed_eye_btn);

        isPasswordShowing = false;
        eye.setVisibility(View.VISIBLE);
        closedEye.setVisibility(View.GONE);

        eye.setOnClickListener(v->{
            if(!isPasswordShowing){
                isPasswordShowing = true;
                eye.setVisibility(View.GONE);
                closedEye.setVisibility(View.VISIBLE);
                passwordET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                passwordET.setSelection(passwordET.getText().length());
            }
        });

        closedEye.setOnClickListener(v->{
            if(isPasswordShowing){
                isPasswordShowing = false;
                eye.setVisibility(View.VISIBLE);
                closedEye.setVisibility(View.GONE);
                passwordET.setTransformationMethod(PasswordTransformationMethod.getInstance());
                passwordET.setSelection(passwordET.getText().length());
            }
        });




        findViewById(R.id.login_btn).setOnClickListener(v->{
            tryLogin();
        });
    }

    private void tryLogin() {
        String username = usernameET.getText().toString().trim();
        String password = passwordET.getText().toString();

        if(username.isEmpty()){
            usernameET.setError("Enter your username please");
            usernameET.requestFocus();
            return;
        }

        if(password.isEmpty()){
            passwordET.setError("Enter your password please");
            passwordET.requestFocus();
            return;
        }

        showProgressDialog();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismissProgressDialog();
                startActivity(new Intent(LoginActivity.this, TeacherHomeActivity.class));
                finish();
            }
        }, 1000);


    }


    private void showProgressDialog() {
        progress.show();
    }
    private void dismissProgressDialog() {
        if (progress.isShowing()) {
            progress.dismiss();
        }
    }
}