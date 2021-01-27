package com.wishihab.mycontactapijava.adapter;

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
import com.wishihab.mycontactapijava.dataset.CRandomUser;

import java.util.ArrayList;

public class AdapterMainUser extends BaseAdapter {

    Context context;
    ArrayList<CMainUser> mainUser;
    String id;

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_mainuser, null);
        }


        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);
        TextView txtEmail = (TextView) convertView.findViewById(R.id.txtEmail);
        String imageUri = mainUser.get(position).getPicturethum();

        id = mainUser.get(position).getEmail();

        ImageView imgLogo = (ImageView)convertView.findViewById(R.id.imgthum);

        Picasso.with(imgLogo.getContext()).load(imageUri).noFade().into(imgLogo);

        txtName.setText(mainUser.get(position).getName());
        txtPhone.setText(mainUser.get(position).getPhone());
        txtEmail.setText(mainUser.get(position).getEmail());

        return convertView;
    }


}
