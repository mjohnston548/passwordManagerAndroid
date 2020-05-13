package com.example.passwordmanagerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Date;

import java.util.Random;



public class generateNewPassword extends AppCompatActivity {

    Button managePasswordsButton, savePasswordButton,generateNewDigitsButton;

    EditText passwordBlock1,passwordBlock2,passwordBlock3,passwordBlock4,passwordBlock5;

    EditText websiteApp,usernameEmail;

    final static ArrayList<Password> passwordArrayList=new ArrayList<Password>();

    static ArrayList<String> usedPasswordCategories=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_new_password);

        passwordBlock1=findViewById(R.id.editText);
        passwordBlock2=findViewById(R.id.editText2);
        passwordBlock3=findViewById(R.id.editText3);
        passwordBlock4=findViewById(R.id.editText4);
        passwordBlock5=findViewById(R.id.editText5);

        websiteApp=findViewById(R.id.editText7);
        usernameEmail=findViewById(R.id.editText6);



        generateNewDigitsButton=findViewById(R.id.button3);
        generateNewDigitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText [] passwordBlockArray = new EditText[]{passwordBlock1, passwordBlock2, passwordBlock3, passwordBlock4, passwordBlock5};
                for (int i=1;i<6;i++){
                    digitGenerator(9,0,passwordBlockArray[i-1]);
                }
                // digitGenerator(9,0,passwordBlock1);



            }
        });
        //spinner configuration
        final Spinner spinner=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.passwordCategoriesArray,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);






        savePasswordButton=findViewById(R.id.button);
        savePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    //make the password object from entered data
                    Password newPassword=new Password(passwordBlock1.getText().toString()+
                            passwordBlock2.getText().toString()+passwordBlock3.getText().toString()+passwordBlock4.getText().toString()
                            +passwordBlock5.getText().toString(),usernameEmail.getText().toString(),websiteApp.getText().toString(),spinner.getSelectedItem().toString(),new Date());

                    passwordArrayList.add(newPassword);

                    //add the password category that the user selected to a persistent array
                    usedPasswordCategories.add(spinner.getSelectedItem().toString());
                    Toast.makeText(getApplicationContext(),"Password Stored",Toast.LENGTH_SHORT).show();

                    // clearing the user input fields
                    EditText [] textFieldsArray = new EditText[]{passwordBlock1, passwordBlock2, passwordBlock3, passwordBlock4, passwordBlock5,usernameEmail,websiteApp};
                    clearFields(textFieldsArray); //should reset spinner too
                    //maybe send user to manage passwords activity after storing password?


                    Intent intent=new Intent(getApplicationContext(),managePasswords.class);
                    startActivity(intent);

                }catch (IllegalArgumentException e){
                    Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });



        managePasswordsButton=findViewById(R.id.button4);
        managePasswordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),managePasswords.class);
                startActivity(intent);
            }
        });
    }

    public void digitGenerator(int max, int min, EditText passwordBlock){
        // First time on this course where ive written a function which takes a non-primitive type!
        Random rand=new Random();
        int randomNum=(int) rand.nextInt((max-min)+1)+min;
        int randomNum2=(int) rand.nextInt((max-min)+1)+min;
        passwordBlock.setText(String.valueOf(randomNum)+String.valueOf(randomNum2), TextView.BufferType.EDITABLE);
    }
    public void clearFields(EditText [] textFields){
        for (int i=0;i<textFields.length;i++){
            textFields[i].getText().clear();

        }

    }
    public static ArrayList<Password> getPasswordArray(){
        return passwordArrayList;
    }

    public static ArrayList<String> getPasswordCategoryArray(){return usedPasswordCategories;}
}
