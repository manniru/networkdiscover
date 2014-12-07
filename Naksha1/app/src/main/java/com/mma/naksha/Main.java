package com.mma.naksha;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Main extends ActionBarActivity {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button3);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("mm1", "Register");
                Toast.makeText(getApplicationContext(), "Register.", Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(Main.this, Register.class);
                myIntent.putExtra("user", "user1"); //Optional parameters
                Main.this.startActivity(myIntent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("mm1", "Login Click");
                Toast.makeText(getApplicationContext(), "Login.", Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(Main.this, Login.class);
                myIntent.putExtra("user", "user1"); //Optional parameters
                Main.this.startActivity(myIntent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
