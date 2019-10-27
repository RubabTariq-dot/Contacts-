package com.example.l176310_a3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ContactGetter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_getter);
        requestPermission();
    }

    private void requestPermission(){

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS}, 1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
        Cursor cursor = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,null,
                null, null, ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " ASC");

        String s = "";
        while (cursor.moveToNext()) {
            int col =  cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI);
            String temp = cursor.getString(col);
            if(temp != null){
                ImageView i = findViewById(R.id.imageView);
                i.setImageURI(Uri.parse(temp));

                break;//32
                // 32

            }
            s += temp + " ";
            TextView txt = findViewById(R.id.textView2);
            txt.setText(s);
        }

    }
}


