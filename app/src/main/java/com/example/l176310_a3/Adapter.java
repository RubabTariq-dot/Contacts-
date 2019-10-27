package com.example.l176310_a3;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.l176310_a3.ContactList.db;

public class Adapter extends BaseAdapter {
    private Context context;

    private List<ContactPer> list;

    public  Adapter(Context context, ArrayList<Contact> arrayList) {
        this.context = context;

        this.list= db.DBsql().getAll();
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public ContactPer getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ContactPer model = list.get(position);
        ViewHodler holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.contact_row, parent, false);
            holder = new ViewHodler();
            holder.contactImage = (ImageView) convertView.findViewById(R.id.contactImage);
            holder.contactName = (TextView) convertView.findViewById(R.id.contactName);
// holder.contactEmail = (TextView) convertView.findViewById(R.id.email);
// holder.contactNumber = (TextView) convertView.findViewById(R.id.phone);
            convertView.setTag(holder);
        }
        else
        {

            holder = (ViewHodler) convertView.getTag();
        }

        if (!model.getContactName().equals("") && model.getContactName() != null) {
            holder.contactName.setText(model.getContactName());
// NAME=model.getName();
        } else {
            holder.contactName.setText(R.string.noName);
        }


        if ( model.getContactPhoto() != null) {
            holder.contactImage.setImageURI(Uri.parse(model.getContactPhoto()));
// NAME=model.getName();
        } else {
            holder.contactImage.setImageURI(null);
        }
        return convertView;

    }

    // View holder to hold views
    private class ViewHodler {
        ImageView contactImage;
        TextView contactName, contactNumber, contactEmail;
    }
}

