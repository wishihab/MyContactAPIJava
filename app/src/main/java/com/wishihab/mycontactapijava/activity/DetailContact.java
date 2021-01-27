package com.wishihab.mycontactapijava.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.wishihab.mycontactapijava.R;

public class DetailContact extends AppCompatActivity {

    private String txtNamei, txtAgei, txtGenderi, txtEmaili, txtPhonei, txtCelli, txtLocationi, txtPictureLargei;
    private TextView txtName, txtAge, txtGender, txtEmail, txtPhone, txtCell, txtLocation;

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

        txtNamei = getIntent().getStringExtra("txtName");
        txtAgei = getIntent().getStringExtra("txtAge");
        txtGenderi = getIntent().getStringExtra("txtGender");
        txtEmaili = getIntent().getStringExtra("txtEmail");
        txtPhonei = getIntent().getStringExtra("txtPhone");
        txtCelli = getIntent().getStringExtra("txtCell");
        txtLocationi = getIntent().getStringExtra("txtLocation");
        txtPictureLargei = getIntent().getStringExtra("txtPictureLarge");

        ImageView ivBasicImage = (ImageView) findViewById(R.id.pictureLarge);
        Picasso.with(DetailContact.this).load(txtPictureLargei).noFade().into(ivBasicImage);

        txtName = (TextView)findViewById(R.id.txtName);
        txtAge = (TextView)findViewById(R.id.txtAge);
        txtGender = (TextView)findViewById(R.id.txtGender);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtPhone = (TextView)findViewById(R.id.txtPhone);
        txtCell = (TextView)findViewById(R.id.txtCell);
        txtLocation = (TextView)findViewById(R.id.txtLocation);

        txtName.setText(txtNamei);
        txtAge.setText(txtAgei);
        txtGender.setText(txtGenderi);
        txtEmail.setText(txtEmaili);
        txtPhone.setText(txtPhonei);
        txtCell.setText(txtCelli);
        txtLocation.setText(txtLocationi);


    }
}