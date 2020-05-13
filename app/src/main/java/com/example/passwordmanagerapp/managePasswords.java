package com.example.passwordmanagerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class managePasswords extends AppCompatActivity {

    Button generateNewPasswordButton;

    ArrayList<Password> passwordArray=generateNewPassword.getPasswordArray();
    ArrayList<String> usedCategories=generateNewPassword.getPasswordCategoryArray();
    ListAdapter passwordAdapter;
    ListView passwordListView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_passwords);






        passwordAdapter =new CustomAdapter(this,passwordArray);
        passwordListView= (ListView) findViewById(R.id.listView);
        passwordListView.setAdapter(passwordAdapter);

        //spinner setup
        spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.passwordCategoriesArray,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Password> updatedPasswords = new ArrayList<Password>();
                if(spinner.getSelectedItem().toString().equals("Uncategorised")){
                    updatedPasswords = passwordArray;
                }else {
                    if (usedCategories.contains(spinner.getSelectedItem().toString())) {

                        for (int j = 0; j < passwordArray.size(); j++) {
                            if (passwordArray.get(j).getPasswordCategory().equals(spinner.getSelectedItem().toString())) {
                                updatedPasswords.add(passwordArray.get(j));

                            }
                        }
                    }
                }
                passwordAdapter = new CustomAdapter(getApplicationContext(), updatedPasswords);
                passwordListView.setAdapter(passwordAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





























        generateNewPasswordButton=findViewById(R.id.button2);
        generateNewPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),generateNewPassword.class);
                startActivity(intent);
            }
        });
    }

}
