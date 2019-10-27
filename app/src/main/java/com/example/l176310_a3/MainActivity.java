package com.example.l176310_a3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    CheckBox rememberMe;
    ImageView contact;
    Button signIn;
    SharedPreferences sharedpreferences;
    String username_;
    String password_;
    public static String username="abc";
    public static String password="abc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main);

        user=(EditText)findViewById(R.id.username);
        pass=(EditText) findViewById(R.id.password);
        rememberMe=(CheckBox)findViewById(R.id.remMe);
        //contact=(ImageView)findViewById(R.id.contact) ;

        signIn=(Button)findViewById(R.id.signIn);
        sharedpreferences =getSharedPreferences("My Preference", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);

        if(sharedpreferences.getString(username_,"").isEmpty() && sharedpreferences.getString(password_,"").isEmpty()) {
            signIn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    boolean trigger = false;
                    if (user.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this,
                                R.string.usernameIn, Toast.LENGTH_LONG).show();
                        trigger = true;
                    }

                    if (pass.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this,
                                R.string.passIn, Toast.LENGTH_LONG).show();
                        trigger = true;
                    }

                    if (rememberMe.isChecked() && trigger == false) {
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(username_, user.getText().toString());
                        editor.putString(password_, pass.getText().toString());
                        editor.apply();
                        Toast.makeText(MainActivity.this,
                                "Nice", Toast.LENGTH_LONG).show();

                    }

                    if (trigger == false) {
                        Intent goToHome = new Intent(MainActivity.this, HomePage.class);

                        goToHome.putExtra(username,sharedpreferences.getString(username,null));
                        goToHome.putExtra(password,sharedpreferences.getString(password,null));

                        startActivity(goToHome);
                    }

                }
            });
        }
        else{

            Intent goToHome = new Intent(MainActivity.this, HomePage.class);
            goToHome.putExtra(username,user.getText());
            startActivity(goToHome);
        }
    }
}
