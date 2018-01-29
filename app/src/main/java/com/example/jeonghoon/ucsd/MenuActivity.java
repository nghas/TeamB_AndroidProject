package com.example.jeonghoon.ucsd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    //Attribute for user profile
    Intent menuOptionIntent;

    WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initWebView();

        /* real-time AQI monitoring */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//메뉴
        getMenuInflater().inflate(R.menu.menu_mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {//메뉴
        int curId=item.getItemId();

        switch (curId) {
            case R.id.menuLogout:
                Toast.makeText(this, "LogOut-Intent", Toast.LENGTH_SHORT).show();
                menuOptionIntent=new Intent(MenuActivity.this, LoginActivity.class);
                break;
            case R.id.menuSetting:
                Toast.makeText(this, "Setting-Fragment", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        if(menuOptionIntent!=null)startActivity(menuOptionIntent);

        return super.onOptionsItemSelected(item);
    }
    private void initWebView() {
        String url = "file:///android_asset/chartaqi.html";
        //google chart
        //String sendChart="volt|10:01:00,222.1,10:01:01,223.0,10:01:02,222.8,10:01:03,222.2";  //data

        webView=(WebView)findViewById(R.id.webViewAQI);
        webView.scrollTo(400,550);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setBackgroundColor(Color.TRANSPARENT);

        webView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                return (event.getAction()==MotionEvent.ACTION_MOVE);
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(url);
        //webView.loadUrl("javascript:setMessage('" + sendChart + "')");
    }
}
