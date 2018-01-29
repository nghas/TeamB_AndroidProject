package com.example.jeonghoon.ucsd;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Find_id_pw extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//타이틀바 제거
        setContentView(R.layout.find_id_pw);
    }


}