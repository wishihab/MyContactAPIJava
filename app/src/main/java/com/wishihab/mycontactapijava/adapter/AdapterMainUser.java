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
import com.wishihab.mycontactapijava.dataset.CMainUser;

import java.util.ArrayList;

public class AdapterMainUser extends BaseAdapter {

    final Context context;
    final ArrayList<CMainUser> mainUser;

    public AdapterMainUser(Context context, ArrayList<CMainUser> mainUser) {
        this.context = context;
        this.mainUser = mainUser;
    }

    @Override
    public int getCount() {
        return mainUser.size();
    }

    @Override
    public Object getItem(int position) {
        return mainUser.get(position);
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
            convertView = mInflater.inflate(R.layout.list_mainuser, null);
        }


        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtPhone = convertView.findViewById(R.id.txtPhone);
        TextView txtEmail = convertView.findViewById(R.id.txtEmail);
        String imageUri = mainUser.get(position).getPicturethum();


        ImageView imgLogo = convertView.findViewById(R.id.imgthum);

        Picasso.get().load(imageUri).noFade().into(imgLogo);

        txtName.setText(mainUser.get(position).getName());
        txtPhone.setText(mainUser.get(position).getPhone());
        txtEmail.setText(mainUser.get(position).getEmail());

        return convertView;
    }


}

