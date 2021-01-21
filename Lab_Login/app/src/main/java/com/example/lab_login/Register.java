package com.example.lab_login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class Register extends AppCompatActivity {

    private LoginDatabaseHelper myDB;
    private EditText name, usr,email,paswd,confpaswd;
    private RadioButton man, wom;
    private Button regis, verdata;
    private int gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDB = new LoginDatabaseHelper(this);

        name = (EditText) findViewById(R.id.fullName);
        usr = (EditText) findViewById(R.id.Usuario);
        email = (EditText) findViewById(R.id.e_mail);
        paswd = (EditText) findViewById(R.id.passwd);
        confpaswd = (EditText) findViewById(R.id.confpasswd);
        man = (RadioButton) findViewById(R.id.masc);
        regis =(Button) findViewById(R.id.button);
        verdata = (Button) findViewById(R.id.verdata);
        myDB.initData();
        addData();
        viewAll();


    }
    public void addData (){
        regis.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.inserData(name.getText().toString(),usr.getText().toString(),email.getText().toString(),paswd.getText().toString(),"1");

                        if(isInserted) {
                            Toast.makeText(Register.this , "Data Inserted", LENGTH_LONG).show();
                            //startActivity(new Intent (getApplicationContext(),MainActivity.class));
                        }
                        else {
                            Toast.makeText(Register.this , "Data not Inserted", LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

    public void viewAll() {
        verdata.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDB.getAllData();
                        if(res.getCount() == 0) {
                            showMessage("Error", "No Data found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id:" + res.getString(0)+ "\n");
                            buffer.append("Name:" + res.getString(1)+ "\n");
                            buffer.append("UserName:" + res.getString(2)+ "\n");
                            buffer.append("EMail:" + res.getString(3)+ "\n");
                            buffer.append("Password:" + res.getString(4)+ "\n");
                            buffer.append("Gender:" + res.getString(0)+ "\n");
                        }
                        showMessage("Data", buffer.toString());
                    }
                });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }








     public void retun (View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}