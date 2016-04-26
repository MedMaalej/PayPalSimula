package com.example.root.paypaltest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import model.Payment;

/**
 * Created by sfaxiano on 17/06/2015.
 */
public class PaymentsListAdapter extends ArrayAdapter<Payment> {
    private Context context;

    private List<Payment> paymentsList;

    public PaymentsListAdapter(Context context, int resource, List<Payment> objects) {
        super(context, resource, objects);
        this.context = context;
        this.paymentsList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        final Payment pay= paymentsList.get(position);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        //TextView tx =(TextView)view.findViewById(R.id.tvUser);
        TextView tx2 =(TextView)view.findViewById(R.id.tvAmount);
        TextView tx3 =(TextView)view.findViewById(R.id.tvDateP);
        TextView tx4 =(TextView)view.findViewById(R.id.tvCurrency);



        //tx.setText(String.valueOf(pay.getUserId()));
        // On a un seul "Merchant account" donc pas la peine d'avoir plusieurs users
        tx2.setText(String.valueOf(pay.getPaymentAmount()));
        tx3.setText(pay.getPaymentCreationTime());
        tx4.setText(pay.getPaymentCurrency());




        return view;
    }
}
