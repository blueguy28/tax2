package com.example.taek.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.view.View;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    EditText text4_2;
    EditText text5_2;
    EditText text6_2;
    TextView text11_1;
    TabHost tabHost1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text4_2 =  (EditText) findViewById(R.id.text4_2);
        text5_2 =  (EditText) findViewById(R.id.text5_2);
        text6_2 =  (EditText) findViewById(R.id.text6_2);
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
                        }
                        else if(tabHost1.getCurrentTabTag().equals("TabSpec2"))
                        {
                            findViewById(R.id.linear8).setVisibility(View.VISIBLE);
                        }
                        else if(tabHost1.getCurrentTabTag().equals("TabSpec3"))
                        {
                            findViewById(R.id.linear8).setVisibility(View.GONE);
                        }
                    }
                }
        );

        findViewById(R.id.button11_1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int SellPrice = Integer.parseInt(text4_2.getText().toString());
                        int BuyPrice = Integer.parseInt(text5_2.getText().toString());
                        int EtcPrice = Integer.parseInt(text6_2.getText().toString());
                        String result = ((Number)(SellPrice - BuyPrice - EtcPrice)).toString();

                        text11_1.setText(result);

                        Intent cal_intent = new Intent(MainActivity.this, CalCulActivity.class);
                        cal_intent.putExtra(EXTRA_MESSAGE, result);
                        startActivity(cal_intent);
                    }
                }
        );
    }
}
