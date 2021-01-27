package com.wishihab.mycontactapijava.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wishihab.mycontactapijava.R;
import com.wishihab.mycontactapijava.adapter.AdapterMainUser;
import com.wishihab.mycontactapijava.adapter.AdapterRandomUser;
import com.wishihab.mycontactapijava.dataset.CMainUser;
import com.wishihab.mycontactapijava.dataset.CRandomUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listMain;
    private Button butAddContact;
    private ArrayList<CMainUser> arrayMainUser;
    private ArrayList<CRandomUser> arrayRandomUser;
    private AdapterMainUser adapterMain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Kelola Kontak");

        listMain = (ListView)findViewById(R.id.list_main);
        listMain.setTextFilterEnabled(true);

        butAddContact = (Button)findViewById(R.id.butAddContact);
        butAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(i);
            }
        });

        listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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

            }
        });

    }
}