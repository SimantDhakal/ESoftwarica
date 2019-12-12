package com.simant.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    CheckBox checkBox;
    ImageButton imgBtnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        imgBtnSignup = (ImageButton) findViewById(R.id.signup);

        // check whether email is logged in or not
        SharedPreferences sharedPreferences = getSharedPreferences("email", MODE_PRIVATE);
        String emailStr = sharedPreferences.getString("email", "");
        String passwordStr = sharedPreferences.getString("password", "");

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (emailStr.equals("simant@gmail.com") || passwordStr.equals("123456")) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }

        imgBtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("simant@gmail.com") || password.getText().toString().equals("123456")) {
                    signin();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter valid credentail!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void signin() {
        SharedPreferences sharedPreferences = getSharedPreferences("email", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
