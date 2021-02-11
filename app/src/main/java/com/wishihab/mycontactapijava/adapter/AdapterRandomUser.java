package com.wishihab.mycontactapijava.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.wishihab.mycontactapijava.R;
import com.wishihab.mycontactapijava.dataset.CRandomUser;


import java.util.ArrayList;

public class AdapterRandomUser extends BaseAdapter {

    final Context context;
    final ArrayList<CRandomUser> randomUser;

    public AdapterRandomUser(Context context, ArrayList<CRandomUser> randomUser) {
        this.context = context;
        this.randomUser = randomUser;
    }

    @Override
    public int getCount() {
        return randomUser.size();
    }

    @Override
    public Object getItem(int position) {
        return randomUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_randomuser, null);
        }


        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtPhone = convertView.findViewById(R.id.txtPhone);
        TextView txtEmail = convertView.findViewById(R.id.txtEmail);
        String imageUri = randomUser.get(position).getPicturethum();

        ImageView imgLogo = convertView.findViewById(R.id.imgthum);

        Picasso.get().load(imageUri).noFade().into(imgLogo);

        txtName.setText(randomUser.get(position).getName());
        txtPhone.setText(randomUser.get(position).getPhone());
        txtEmail.setText(randomUser.get(position).getEmail());

        return convertView;
    }


}

