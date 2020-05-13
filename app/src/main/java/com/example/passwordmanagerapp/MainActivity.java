package com.example.passwordmanagerapp;
//This is the main menu

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button generateNewPasswordButton;
    Button managePasswords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNewPasswordButton=findViewById(R.id.generateNewPasswordButton);

        generateNewPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), generateNewPassword.class);
                startActivity(intent);
            }
        });

        managePasswords=findViewById(R.id.managePasswordsButton);

        managePasswords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(), managePasswords.class);
                startActivity(intent);
            }
        });
    }
}
