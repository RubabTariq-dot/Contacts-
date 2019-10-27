package com.example.l176310_a3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.l176310_a3.ContactList.sendImage;
import static com.example.l176310_a3.ContactList.sendMail;
import static com.example.l176310_a3.ContactList.sendName;
import static com.example.l176310_a3.ContactList.sendNumber;

public class ViewContact extends AppCompatActivity {

    ImageView iView;
    TextView name_;
    TextView number_;
    TextView mail_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_contact);
        Intent lastIntent=getIntent();
        String username_=lastIntent.getStringExtra(sendName);
        String userNumber=lastIntent.getStringExtra(sendNumber);
        String mail=lastIntent.getStringExtra(sendMail);
        String im=lastIntent.getStringExtra(sendImage);
        iView=(ImageView) findViewById(R.id.pic);
        name_=findViewById(R.id.name);
        number_=findViewById(R.id.number);
        mail_=findViewById(R.id.mail);

        //iView.setImageBitmap(sendImage);
        name_.setText(username_);
        number_.setText(userNumber);
        mail_.setText(mail);

    }
}
