package com.wishihab.mycontactapijava.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.wishihab.mycontactapijava.R;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    @Click(R.id.butAddContact)
    void myButton(){
        Intent i = new Intent(MainActivity.this, AddContactActivity.class);
        startActivity(i);
    }



}