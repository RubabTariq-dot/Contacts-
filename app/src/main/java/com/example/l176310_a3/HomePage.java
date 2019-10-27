package com.example.l176310_a3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.l176310_a3.MainActivity.username;

public class HomePage extends AppCompatActivity {

    TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent lastIntent=getIntent();
        String username_=lastIntent.getStringExtra(username);
        mText=findViewById(R.id.text12);
        mText.setText(username_+" "+ R.string.loggedIn);
    }

    public void Contacts(View view) {
        Intent intent=new Intent(HomePage.this,ContactList.class);
        startActivity(intent);
    }
//    public void Add_Contact(View view) {
//        Intent intent = new Intent(HomePage.this, AddContact.class);
//        startActivity(intent);
//    }
    public void Delete_Contact(View view) {
        Intent intent = new Intent(HomePage.this, DeleteContact.class);
        startActivity(intent);
    }

}
