package com.example.lab_login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Register extends AppCompatActivity {

    private EditText name, user,email,paswd,confpaswd;
    private RadioButton man, wom;
    private Button regis;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText) findViewById(R.id.fullName);
        user = (EditText) findViewById(R.id.Usuario);
        email = (EditText) findViewById(R.id.e_mail);
        paswd = (EditText) findViewById(R.id.passwd);
        confpaswd = (EditText) findViewById(R.id.confpasswd);
        progressDialog = new ProgressDialog(this);
    }

    private void relacion(){
        man = findViewById(R.id.masc);
        wom = findViewById(R.id.fem);

        man.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String res = "Hombre";
            }
        });
        wom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String res = "Mujer";
            }
        });
    }


    public void retun (View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}