package com.example.root.paypaltest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import databaseLib.DbHelper;
import model.Payment;


public class TransactionsList extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions_list);
        DbHelper dbh = new DbHelper(this);
        ListView listViewPayments = (ListView) findViewById(R.id.listPayments);
        List<Payment> listOfPayments = dbh.getAllPayments();

        Collections.reverse(listOfPayments);
        PaymentsListAdapter
                adapter = new PaymentsListAdapter(getApplicationContext(),R.layout.list_item,listOfPayments);
        listViewPayments.setAdapter(adapter);
        Button back = (Button) findViewById(R.id.btn_back);
        back.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transactions_list, menu);
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
        int id = view.getId();
        switch (id)
        {
            case R.id.btn_back:
                Intent back = new Intent(this, AppMenu.class);
                startActivity(back);
                finish();
        }
    }
}
