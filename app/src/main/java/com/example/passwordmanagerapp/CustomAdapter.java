package com.example.passwordmanagerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Password> {


    public CustomAdapter( Context context, ArrayList<Password> passwordArrayList) {
        super(context,R.layout.custom_row,passwordArrayList);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View customView=  layoutInflater.inflate(R.layout.custom_row,parent,false);

        Password passwordObject=getItem(position);
        TextView websiteAppText=(TextView) customView.findViewById(R.id.textView19);
        TextView usernameEmailText=(TextView) customView.findViewById(R.id.textView20);
        TextView passwordText=(TextView) customView.findViewById(R.id.textView21);
        TextView dateCreatedText=(TextView) customView.findViewById(R.id.textView22);

        websiteAppText.setText(passwordObject.getWebsiteApp());
        usernameEmailText.setText(passwordObject.getUsernameEmail());
        passwordText.setText(passwordObject.getPasswordDigits().substring(0,2)+"******"+passwordObject.getPasswordDigits().substring(8));

        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String date=sdf.format(passwordObject.getPasswordDateCreated());
        dateCreatedText.setText(date);






        return customView;
    }
}
