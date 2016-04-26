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
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import databaseLib.DbHelper;
import model.Payment;


public class PayActivity extends Activity implements View.OnClickListener {

    private static final String CONFIG= PayPalConfiguration.ENVIRONMENT_SANDBOX;
    public static final String CLIENT_ID="ARcm38acqubLq4y21qlxMXAEAsVYpnYPb6Unh4E3BdxkfXt8hjdOJx3QDyocwoGph0yPxYXTyCabKpDM";
    public static final int REQUEST_PAYMENT=1;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(CONFIG)
            .clientId(CLIENT_ID)
            .merchantName("mohamed maalej")
            .sandboxUserPassword("EKPxNh1-tTpvmjIiAHqU54eWnylwjmTDvYO3-qxkFf0EoBAsjC1nmLgF4eN5HFhdi0kPLFb0gK-1qKOe")
            .acceptCreditCards(true)
            ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_PAYMENT)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                PaymentConfirmation confirm = data.getParcelableExtra
                        (PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if(confirm == null)
                {

                    try
                    {

                        System.out.println("Responses " + confirm);
                        Log.i("Paypal Example Payments", confirm.toJSONObject().toString());
                        JSONObject obj = new JSONObject(confirm.toJSONObject().toString());
                        String paymentID =  obj.getJSONObject("response").getString("id");
                        System.out.println("payment id=="+paymentID);
                        Toast.makeText(getApplicationContext(),paymentID,Toast.LENGTH_LONG).show();;

                    }
                    catch(JSONException e)
                    {
                        Log.e("Payment demo ","failure occured",e);
                    }
                }
                else if(requestCode == Activity.RESULT_CANCELED)
                    Log.i("Paymentdemo","The user cancelled ");
                else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
                    Log.i("PaymentDemo","Invalid payment submitted");
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button1:
                EditText edAmount =(EditText) findViewById(R.id.editText4);
                EditText edCurrency =(EditText) findViewById(R.id.editText3);
                String amount = edAmount.getText().toString();
                String currency = edCurrency.getText().toString();
                PayPalPayment item = new PayPalPayment(new BigDecimal(Double.parseDouble(amount)),currency,"mohamed maalej",PayPalPayment.PAYMENT_INTENT_AUTHORIZE);
                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                Calendar calobj = Calendar.getInstance();
                String dateOfInsertion = df.format(calobj.getTime()).toString();
                Payment newPayment = new Payment(Double.parseDouble(amount),dateOfInsertion,currency);
                DbHelper dbh = new DbHelper(this);
                dbh.addPayment(newPayment);

                Intent in = new Intent(PayActivity.this, PaymentActivity.class);
                in.putExtra(PaymentActivity.EXTRA_PAYMENT, item);
                startActivityForResult(in,REQUEST_PAYMENT);
                break;

            case R.id.back:
                Intent goBack = new Intent(this, AppMenu.class);
                startActivity(goBack);
                finish();
                break;
        }
    }
}
