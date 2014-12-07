package com.mma.naksha;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mma.naksha.com.mma.naksha.dao.Dao;
import com.mma.naksha.com.mma.naksha.dao.User;
import com.mma.naksha.com.mma.naksha.dao.Webservices;


public class Register extends ActionBarActivity {
    String serverip = "192.168.0.8:8000";
    private Button regbtn;
    private EditText usertxt, passtxt, fullnametxt, mobiletxt, emailtxt;
    private String username="", password="", fullname="", mobileno="", email="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        regbtn=(Button)findViewById(R.id.regbtn);
        usertxt = (EditText)findViewById(R.id.usertxt);
        passtxt = (EditText)findViewById(R.id.passtxt);
        fullnametxt = (EditText)findViewById(R.id.fullnametxt);
        mobiletxt = (EditText)findViewById(R.id.mobiletxt);
        emailtxt = (EditText)findViewById(R.id.emailtxt);

        regbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("mm1", "Register");
                Toast.makeText(getApplicationContext(), "Register.", Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(Register.this, Login.class);
                myIntent.putExtra("user", "user1"); //Optional parameters
                Register.this.startActivity(myIntent);

            }
        });

        /**
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("mm1", "Register Click");
                Toast.makeText(getApplicationContext(), "Thank you for Register.", Toast.LENGTH_LONG).show();

            }
        });
    */



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
