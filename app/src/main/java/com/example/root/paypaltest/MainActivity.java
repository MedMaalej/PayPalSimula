package com.example.root.paypaltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import databaseLib.DbHelper;
import model.Payment;
import model.User;


public class MainActivity extends Activity implements View.OnClickListener {
    DbHelper dbh ;
    EditText login ;
    EditText password ;
    Button btn_login,btn_cancel ;
    String name;
    String pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh = new DbHelper(this);
        login = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        btn_login = (Button) findViewById(R.id.button);
        btn_login.setOnClickListener(this);

        //User testUser = new User("Maalej","maalejmedti@gmail.com");
        //dbh.addUser(testUser);
        //Payment testPayment = new Payment(1,"12/06/2014","17/06/2015",1,145.450,"TND");
        //Payment testPayment2 = new Payment(2,"12/06/2015","25/06/2015",1,115.450,"USD");

        //dbh.addPayment(testPayment);
        //dbh.addPayment(testPayment2);
        //Payment payment3 = new Payment(2,3,"12/06/2014","17/06/2015",0,200,"EUR");


        //dbh.updatePayment(payment3);
        //dbh.deletePayment(2);
        //dbh.getAllPayments();
        dbh.deleteAllPayments();
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

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId)
        {
            case R.id.button:
                name = login.getText().toString();
                pwd = password.getText().toString();
                if(name.equals("admin") && (pwd.equals("admin")))
                {
                    Intent connect = new Intent(this, AppMenu.class);
                    startActivity(connect);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Bad credentials",
                            Toast.LENGTH_LONG).show();
                }

                break;

            default:
                break;

        }

    }
}
