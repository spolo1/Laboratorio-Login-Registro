package com.example.lab_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText use, password;
    private Button btnLogin;
    LoginDatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        use = (EditText) findViewById(R.id.e_Mail);
        password = (EditText) findViewById(R.id.passwd_login);
        myDb = new LoginDatabaseHelper(this);

    }
    public void btn_registro(View view){
        startActivity(new Intent(getApplicationContext(),Register.class));
    }


}