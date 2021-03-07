package com.example.paymentgateway;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    private final String API_KEY="rzp_test_THa3nttmy45p3R";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Checkout.preload(getApplicationContext());
    }

    public void paynow(View view) {

        /*Create Checkout */
        Checkout checkout=new Checkout();

        /*Set your API_KEY to checkout */

        checkout.setKeyID(API_KEY);

        /*Get Context from the Activity */
        Activity activity=this;


        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("name","GauravDahal");
            jsonObject.put("currency","INR");
            /*It is converting in paisa*/
            int a=100*5;
            jsonObject.put("amount","5000");

            checkout.open(activity,jsonObject); //or checkout.open((Activity)this,jsonObject)


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Your Payment Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();
    }
}