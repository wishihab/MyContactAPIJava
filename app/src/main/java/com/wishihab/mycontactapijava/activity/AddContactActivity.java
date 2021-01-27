package com.wishihab.mycontactapijava.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
import java.util.Random;

public class AddContactActivity extends AppCompatActivity {
    private ListView listcontact;
    private ListView listMain;
    private ArrayList<CRandomUser> arrayRandomUser, arr;
    private ArrayList<CMainUser> arrayMainUser, arrMain;
    private AdapterRandomUser adapter;
    private AdapterMainUser adapterMain;
    private RequestQueue requestQueue;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == android.R.id.home) finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);
        getSupportActionBar().setTitle("Tambah Kontak");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listcontact = (ListView)findViewById(R.id.list_contact);
        listcontact.setTextFilterEnabled(true);


        listcontact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CRandomUser temp = arrayRandomUser.get(position);
//                Intent i = new Intent(AddContactActivity.this, DetailContact.class);
//                i.putExtra("txtName", temp.getName());
//                i.putExtra("txtAge", temp.getAge());
//                i.putExtra("txtGender", temp.getGender());
//                i.putExtra("txtEmail", temp.getEmail());
//                i.putExtra("txtPhone", temp.getPhone());
//                i.putExtra("txtCell", temp.getCell());
//                i.putExtra("txtLocation", temp.getLocation());
//                i.putExtra("txtPictureLarge", temp.getPicturelarge());
//                startActivity(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(AddContactActivity.this);
                builder.setTitle("Tambahkan");
                builder.setMessage("Anda yakin ingin menambahkan.");

                builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        arrayMainUser = new ArrayList<>();
                        CRandomUser temp = arrayRandomUser.get(position);
                        CMainUser cMain = new CMainUser(temp.getName(), temp.getAge(), temp.getGender(), temp.getLocation(), temp.getEmail(), temp.getPhone(), temp.getCell(), temp.getPicturelarge(), temp.getPicturethum());

                        arrayMainUser.add(cMain);
                        dialog.dismiss();
                        finish();

                    }
                });

                builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequestRandomUser);
    }

    StringRequest stringRequestRandomUser = new StringRequest(Request.Method.GET, "https://randomuser.me/api?results=10&exc=login,registered,i", new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                arrayRandomUser = new ArrayList<>();

                JSONObject result = new JSONObject(response);

                JSONArray jsonArray = result.getJSONArray("results");


                for(int j=0; j< jsonArray.length(); j++) {
                    JSONObject item = jsonArray.getJSONObject(j);
                    JSONObject namedetail = item.getJSONObject("name");
                    String name = namedetail.getString("title") + " " + namedetail.getString("first") + " "+ namedetail.getString("last");
                    String gender = item.getString("gender");

                    JSONObject locationdetail = item.getJSONObject("location");
                    String location = locationdetail.getString("postcode") + locationdetail.getString("country");
                    String email = item.getString("email");

                    JSONObject dob = item.getJSONObject("dob");
                    String age = dob.getString("age").toString();
                    String phone = item.getString("phone");
                    String cell = item.getString("cell");

                    JSONObject picturedetail = item.getJSONObject("picture");
                    String picturelarge = picturedetail.getString("large");
                    String picturethum = picturedetail.getString("thumbnail");

                    CRandomUser c = new CRandomUser(name, age, gender, location, email, phone, cell, picturelarge, picturethum);
                    arrayRandomUser.add(c);

                    adapter = new AdapterRandomUser(getApplicationContext(), arrayRandomUser);
                    listcontact.setAdapter(adapter);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        }
    });

}