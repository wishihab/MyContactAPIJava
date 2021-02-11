package com.wishihab.mycontactapijava.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wishihab.mycontactapijava.R;
import com.wishihab.mycontactapijava.adapter.AdapterRandomUser;
import com.wishihab.mycontactapijava.dataset.CRandomUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class AddContactActivity extends AppCompatActivity {
    private ListView list_contact;
    private ArrayList<CRandomUser> arrayRandomUser;
    private AdapterRandomUser adapter;

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
        getSupportActionBar().setTitle("Add Contact");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list_contact = findViewById(R.id.list_contact);
        list_contact.setTextFilterEnabled(true);


        list_contact.setOnItemClickListener((parent, view, position, id) -> {


            AlertDialog.Builder builder = new AlertDialog.Builder(AddContactActivity.this);
            builder.setTitle("Informasi");
            builder.setMessage("TIDAK artinya menghapus, YA artinya lihat detail.");
            builder.setPositiveButton("YA", (dialog, which) -> {

                CRandomUser temp = arrayRandomUser.get(position);
                Intent i = new Intent(AddContactActivity.this, DetailContact.class);
                i.putExtra("txtPosition", arrayRandomUser.get(position).toString());
                i.putExtra("txtName", temp.getName());
                i.putExtra("txtAge", temp.getAge());
                i.putExtra("txtGender", temp.getGender());
                i.putExtra("txtEmail", temp.getEmail());
                i.putExtra("txtPhone", temp.getPhone());
                i.putExtra("txtCell", temp.getCell());
                i.putExtra("txtLocation", temp.getLocation());
                i.putExtra("txtPictureLarge", temp.getPicturelarge());
                startActivity(i);

                dialog.dismiss();
            });

            builder.setNegativeButton("TIDAK", (dialog, which) -> {
                arrayRandomUser.get(position);
                arrayRandomUser.remove(position);
                adapter.notifyDataSetChanged();
                // Do nothing
                dialog.dismiss();
            });

            AlertDialog alert = builder.create();
            alert.show();
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequestRandomUser);
    }

    final StringRequest stringRequestRandomUser = new StringRequest(Request.Method.GET, "https://randomuser.me/api?results=10&exc=login,registered,i", new Response.Listener<String>() {
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
                    String location = locationdetail.getString("postcode") + " " + locationdetail.getString("country");
                    String email = item.getString("email");

                    JSONObject dob = item.getJSONObject("dob");
                    String age = dob.getString("age");
                    String phone = item.getString("phone");
                    String cell = item.getString("cell");

                    JSONObject picturedetail = item.getJSONObject("picture");
                    String picturelarge = picturedetail.getString("large");
                    String picturethum = picturedetail.getString("thumbnail");

                    CRandomUser c = new CRandomUser(name, age, gender, location, email, phone, cell, picturelarge, picturethum);
                    arrayRandomUser.add(c);


                    adapter = new AdapterRandomUser(getApplicationContext(), arrayRandomUser);
                    list_contact.setAdapter(adapter);
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, error -> {
    });

}