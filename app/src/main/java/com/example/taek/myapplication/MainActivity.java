package com.example.taek.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private DatePickerDialog.OnDateSetListener mDataSetListener1;
    private DatePickerDialog.OnDateSetListener mDataSetListener2;

    Button button2_2;
    Button button3_2;
    EditText text4_2;
    EditText text5_2;
    EditText text6_2;
    int radio8, radio9, radio10;
    RadioButton option8_1, option8_2, option9_1, option9_2, option10_1, option10_2;
    TextView text11_1;
    TabHost tabHost1;
    int sell_month, sell_day, sell_year;
    int buy_month, buy_day, buy_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2_2 =  (Button) findViewById(R.id.button2_2);
        button3_2 =  (Button) findViewById(R.id.button3_2);
        text4_2 =  (EditText) findViewById(R.id.text4_2);
        text5_2 =  (EditText) findViewById(R.id.text5_2);
        text6_2 =  (EditText) findViewById(R.id.text6_2);
        option8_1 = (RadioButton) findViewById(R.id.option8_1);
        option8_2 = (RadioButton) findViewById(R.id.option8_2);
        option9_1 = (RadioButton) findViewById(R.id.option9_1);
        option9_2 = (RadioButton) findViewById(R.id.option9_2);
        option10_1 = (RadioButton) findViewById(R.id.option10_1);
        option10_2 = (RadioButton) findViewById(R.id.option10_2);
        text11_1 =  (TextView) findViewById(R.id.text11_1);
        tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("TabSpec1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator("주택") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("TabSpec2") ;
        ts2.setContent(R.id.content1) ;
        ts2.setIndicator("토지") ;
        tabHost1.addTab(ts2) ;

        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("TabSpec3") ;
        ts3.setContent(R.id.content1) ;
        ts3.setIndicator("기타") ;
        tabHost1.addTab(ts3) ;

        tabHost1.setCurrentTabByTag("TabSpec2");
        tabHost1.setOnTabChangedListener(
                new TabHost.OnTabChangeListener() {
                    @Override
                    public void onTabChanged(String tabId) {
                        if(tabHost1.getCurrentTabTag().equals("TabSpec1"))
                        {
                            findViewById(R.id.linear8).setVisibility(View.GONE);
                            findViewById(R.id.linear9).setVisibility(View.VISIBLE);
                            findViewById(R.id.linear10).setVisibility(View.VISIBLE);
                        }
                        else if(tabHost1.getCurrentTabTag().equals("TabSpec2"))
                        {
                            findViewById(R.id.linear8).setVisibility(View.VISIBLE);
                            findViewById(R.id.linear9).setVisibility(View.GONE);
                            findViewById(R.id.linear10).setVisibility(View.GONE);
                        }
                        else if(tabHost1.getCurrentTabTag().equals("TabSpec3"))
                        {
                            findViewById(R.id.linear8).setVisibility(View.GONE);
                            findViewById(R.id.linear9).setVisibility(View.GONE);
                            findViewById(R.id.linear10).setVisibility(View.GONE);
                        }
                    }
                }
        );

        button2_2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Calendar cal = Calendar.getInstance();
                        int year = cal.get(Calendar.YEAR);
                        int month = cal.get(Calendar.MONTH);
                        int day = cal.get(Calendar.DAY_OF_MONTH);

                        DatePickerDialog dialog1 = new DatePickerDialog(
                                MainActivity.this,
                                android.R.style.Theme_Holo_Dialog_MinWidth,
                                mDataSetListener1,
                                year, month, day);

                        dialog1.show();
                    }
                }
        );

        button3_2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Calendar cal = Calendar.getInstance();
                        int year = cal.get(Calendar.YEAR);
                        int month = cal.get(Calendar.MONTH);
                        int day = cal.get(Calendar.DAY_OF_MONTH);

                        DatePickerDialog dialog2 = new DatePickerDialog(
                                MainActivity.this,
                                android.R.style.Theme_Holo_Dialog_MinWidth,
                                mDataSetListener2,
                                year, month, day);

                        dialog2.show();
                    }
                }
        );

        mDataSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String data = month + "/" + dayOfMonth + "/" + year;
                button2_2.setText(data);
                sell_month = month;
                sell_day = dayOfMonth;
                sell_year = year;
            }
        };

        mDataSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String data = month + "/" + dayOfMonth + "/" + year;
                button3_2.setText(data);
                buy_month = month;
                buy_day = dayOfMonth;
                buy_year = year;
            }
        };

        findViewById(R.id.button11_1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int SellPrice = Integer.parseInt(text4_2.getText().toString());
                        int BuyPrice = Integer.parseInt(text5_2.getText().toString());
                        int EtcPrice = Integer.parseInt(text6_2.getText().toString());
                        String result = ((Number)(SellPrice - BuyPrice - EtcPrice)).toString();

                        Intent cal_intent = new Intent(MainActivity.this, CalCulActivity.class);
                        cal_intent.putExtra("sell_month", sell_month);
                        cal_intent.putExtra("sell_day", sell_day);
                        cal_intent.putExtra("sell_year", sell_year);
                        cal_intent.putExtra("buy_month", buy_month);
                        cal_intent.putExtra("buy_day", buy_day);
                        cal_intent.putExtra("buy_year", buy_year);
                        cal_intent.putExtra("selling_price", SellPrice);
                        cal_intent.putExtra("buying_price", BuyPrice);
                        cal_intent.putExtra("etc_price", EtcPrice);

                        if(option8_1.isChecked() == true) radio8 = 1;
                        else if(option8_2.isChecked() == true) radio8 = 2;
                        else {
                            Toast toast = Toast.makeText(MainActivity.this, "비사업용 토지 여부를 선택하세요", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if(option9_1.isChecked() == true) radio9 = 1;
                        else if(option9_2.isChecked() == true) radio9 = 2;
                        else {
                            Toast toast = Toast.makeText(MainActivity.this, "1세대 1주택 여부를 선택하세요", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if(option10_1.isChecked() == true) radio10 = 1;
                        else if(option10_2.isChecked() == true) radio10 = 2;
                        else {
                            Toast toast = Toast.makeText(MainActivity.this, "2년 보유/거주 여부를 선택하세요", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        cal_intent.putExtra("radio8", radio8);
                        cal_intent.putExtra("radio9", radio9);
                        cal_intent.putExtra("radio10", radio10);

                        startActivity(cal_intent);
                    }
                }
        );
    }
}
