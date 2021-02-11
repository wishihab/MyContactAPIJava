package com.wishihab.mycontactapijava.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wishihab.mycontactapijava.R;
import com.wishihab.mycontactapijava.dataset.CMainUser;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CMainUser> arrayMainUser;

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "OnResume", Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Kelola Kontak");

        ListView listMain = findViewById(R.id.list_main);
        listMain.setTextFilterEnabled(true);

        Button butAddContact = findViewById(R.id.butAddContact);
        butAddContact.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, AddContactActivity.class);
            startActivity(i);
        });

        arrayMainUser = new ArrayList<>();

        listMain.setOnItemClickListener((parent, view, position, id) -> {

            CMainUser temp = arrayMainUser.get(position);
            Intent i = new Intent(MainActivity.this, DetailContact.class);
            i.putExtra("txtName", temp.getName());
            i.putExtra("txtAge", temp.getAge());
            i.putExtra("txtGender", temp.getGender());
            i.putExtra("txtEmail", temp.getEmail());
            i.putExtra("txtPhone", temp.getPhone());
            i.putExtra("txtCell", temp.getCell());
            i.putExtra("txtLocation", temp.getLocation());
            i.putExtra("txtPictureLarge", temp.getPicturelarge());
            startActivity(i);

        });

    }
}