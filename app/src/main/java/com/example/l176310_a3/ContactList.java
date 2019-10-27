package com.example.l176310_a3;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import java.util.ArrayList;


public class ContactList extends AppCompatActivity {
    public static String sendName="abc";
    public static String sendNumber="abc";
    public static String sendMail="abc";
    public static String sendImage;
    public static ContactsDatabase db;
    ArrayList<ContactPer> userList=new ArrayList<>();
    ArrayList<Contact> cList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        getContacts();

        ListView list= findViewById(R.id.mobile_list);
        list.setAdapter(new Adapter(this,cList));
        list.setOnItemClickListener(messageClickedHandler);;



    }
    private void getContacts()
    {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS}, 1);

            }
        }

        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER
                ,ContactsContract.Contacts.PHOTO_URI, ContactsContract.CommonDataKinds.Email.DATA  };
        String selection=null;
        String[] selectionArgs=null;
        String sortOrder=null;
        ContentResolver contentResolver=getContentResolver();
        Cursor cursor=contentResolver.query(uri, projection,selection
                ,selectionArgs,ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " ASC");


        int id=0;
        while(cursor.moveToNext())
        {

            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number =cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String imageUri =cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
            String email = cursor.getString( cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
           // cList.add(name+"\n"+number+"\n"+email+"\n"+imageUri+"\n");  //array list of String type
            ContactPer user=new ContactPer();
            user.name=name;
            user.number=number;
            user.id=id++;
            user.image=imageUri;
            user.email=email;
            userList.add(user);
        }




        db = Room.databaseBuilder(getApplicationContext(),
                ContactsDatabase.class, "Contacts").allowMainThreadQueries().build();
        for (int i=0;i<userList.size();i++)
        {
            db.DBsql().insert(userList.get(i));
        }

    }
    private AdapterView.OnItemClickListener messageClickedHandler=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent goToViewContact=new Intent(ContactList.this, ViewContact.class);
            String passName=userList.get(position).name;
            String passNumber=userList.get(position).number;
            String passMail=userList.get(position).email;
            String passImage=userList.get(position).image;

            goToViewContact.putExtra(sendName,passName);
            goToViewContact.putExtra(sendNumber,passNumber);
            goToViewContact.putExtra(sendMail,passMail);
            goToViewContact.putExtra(sendImage,passImage);

            startActivity(goToViewContact);
        }
    };

}
