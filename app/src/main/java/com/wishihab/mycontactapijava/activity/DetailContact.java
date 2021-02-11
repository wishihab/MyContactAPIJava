package com.wishihab.mycontactapijava.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.wishihab.mycontactapijava.R;

public class DetailContact extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == android.R.id.home) finish();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);
        getSupportActionBar().setTitle("Rincian Kontak");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String txtNamei = getIntent().getStringExtra("txtName");
        String txtAgei = getIntent().getStringExtra("txtAge");
        String txtGenderi = getIntent().getStringExtra("txtGender");
        String txtEmaili = getIntent().getStringExtra("txtEmail");
        String txtPhonei = getIntent().getStringExtra("txtPhone");
        String txtCelli = getIntent().getStringExtra("txtCell");
        String txtLocationi = getIntent().getStringExtra("txtLocation");
        String txtPictureLargei = getIntent().getStringExtra("txtPictureLarge");

        ImageView ivBasicImage = findViewById(R.id.pictureLarge);
        Picasso.get().load(txtPictureLargei).noFade().into(ivBasicImage);

        TextView txtName = findViewById(R.id.txtName);
        TextView txtAge = findViewById(R.id.txtAge);
        TextView txtGender = findViewById(R.id.txtGender);
        TextView txtEmail = findViewById(R.id.txtEmail);
        TextView txtPhone = findViewById(R.id.txtPhone);
        TextView txtCell = findViewById(R.id.txtCell);
        TextView txtLocation = findViewById(R.id.txtLocation);
        Button butDelete = findViewById(R.id.butDelete);

        txtName.setText(txtNamei);
        txtAge.setText(txtAgei);
        txtGender.setText(txtGenderi);
        txtEmail.setText(txtEmaili);
        txtPhone.setText(txtPhonei);
        txtCell.setText(txtCelli);
        txtLocation.setText(txtLocationi);

        butDelete.setOnClickListener(v -> {
        });


    }
}