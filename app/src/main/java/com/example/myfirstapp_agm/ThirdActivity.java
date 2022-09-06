package com.example.myfirstapp_agm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void cookieClicker(View view)
    {
        Intent cookieClicker = new Intent(this, CookieClicker.class);
        startActivity(cookieClicker);
    }
}