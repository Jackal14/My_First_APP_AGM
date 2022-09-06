package com.example.myfirstapp_agm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class CookieClicker extends AppCompatActivity {

    //Finds the cookie clicker text
    TextView countDisplay;
    public int counter = 0;

    int secondsPassed = 0;


    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie_clicker);

        //Starts timer
        myTimer.scheduleAtFixedRate(task, 1000, 1000);

        //Get shared preferences, get the int from the preference, set count = to what's stored
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        counter = sharedPref.getInt("count", 0);

        //Finds the text view that contains the cookie clicker text
        countDisplay = findViewById(R.id.textView3);
        countDisplay.setText(String.valueOf(counter));
    }

    //Called by onClick method on button, update cookie amount
    public void cookieClicked(View view)
    {
        //Get shared preferences, then the editor and save the new amount
        counter++;
        countDisplay.setText(String.valueOf(counter));
    }



    //When activity is stopped, save the current cookie amount
    @Override
    protected void onStop()
    {
        super.onStop();
        SharedPreferences sharedPref = getSharedPreferences("mypref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("count", counter);
        editor.apply();
    }


}