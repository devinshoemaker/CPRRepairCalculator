package com.devinshoe.cprrepaircalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ocCalculate(View v) {
        final double shippingCost = 25;
        final double labor = 35;
        double partCost;
        double phoneValue;
        double phoneValueMarkup;
        double repairCost;
        BigDecimal repairCostInDollars;
        String repairCostInString;
        EditText etPartsPrice = (EditText) findViewById(R.id.etPartsPrice);
        EditText etPhoneValue = (EditText) findViewById(R.id.etPhoneValue);
        TextView tvRepairCost = (TextView) findViewById(R.id.tvRepairCost);
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        nf.setMinimumFractionDigits(2);

        partCost = Double.parseDouble(etPartsPrice.getText().toString());
        phoneValue = Double.parseDouble(etPhoneValue.getText().toString());

        phoneValueMarkup = calculatePhoneValueMarkup(phoneValue);

        repairCost = (partCost + shippingCost + labor + phoneValueMarkup);

        tvRepairCost.setText(String.valueOf(nf.format(repairCost)));
    }

    private double calculatePhoneValueMarkup(double phoneValue) {
        double phoneValueMarkup = 0;

        if (phoneValue <= 100) {
            phoneValueMarkup = 10;
        }
        else if (phoneValue > 100 && phoneValue <= 200) {
            phoneValueMarkup = 20;
        }
        else if (phoneValue > 200 && phoneValue <= 300) {
            phoneValueMarkup = 30;
        }
        else if (phoneValue > 300 && phoneValue <= 400) {
            phoneValueMarkup = 40;
        }
        else if (phoneValue > 400) {
            phoneValueMarkup = 50;
        }

        return phoneValueMarkup;
    }

}
