package com.example.taek.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalCulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);

        Intent intent = new Intent(this.getIntent());
        int sell_month  = intent.getIntExtra("sell_month", 0);
        int sell_day  = intent.getIntExtra("sell_day", 0);
        int sell_year  = intent.getIntExtra("sell_year", 0);
        int buy_month  = intent.getIntExtra("buy_month", 0);
        int buy_day  = intent.getIntExtra("buy_day", 0);
        int buy_year  = intent.getIntExtra("buy_year", 0);
        int SellPrice = intent.getIntExtra("selling_price", 0);
        int BuyPrice = intent.getIntExtra("buying_price", 0);
        int EtcPrice = intent.getIntExtra("etc_price",0 );
        int radio8 = intent.getIntExtra("radio8", 0);
        int radio9 = intent.getIntExtra("radio9", 0);
        int radio10 = intent.getIntExtra("radio10", 0);

        ((TextView)findViewById(R.id.text_cal_1_2)).setText(String.valueOf(sell_month));
        ((TextView)findViewById(R.id.text_cal_2_2)).setText(String.valueOf(sell_day));
        ((TextView)findViewById(R.id.text_cal_3_2)).setText(String.valueOf(sell_year));

        ((TextView)findViewById(R.id.text_cal_4_2)).setText(String.valueOf(buy_month));
        ((TextView)findViewById(R.id.text_cal_5_2)).setText(String.valueOf(buy_day));
        ((TextView)findViewById(R.id.text_cal_6_2)).setText(String.valueOf(buy_year));

        ((TextView)findViewById(R.id.text_cal_7_2)).setText(String.valueOf(SellPrice));
        ((TextView)findViewById(R.id.text_cal_8_2)).setText(String.valueOf(BuyPrice));
        ((TextView)findViewById(R.id.text_cal_9_2)).setText(String.valueOf(EtcPrice));

        ((TextView)findViewById(R.id.text_cal_10_2)).setText(String.valueOf(radio8));
        ((TextView)findViewById(R.id.text_cal_11_2)).setText(String.valueOf(radio9));
        ((TextView)findViewById(R.id.text_cal_12_2)).setText(String.valueOf(radio10));

    }
}
