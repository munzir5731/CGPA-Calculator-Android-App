package com.example.abdullahal_munzir.mycourse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Abdullah Al-Munzir on 12-Aug-18.
 */

public class SplashScreen extends AppCompatActivity {

    private static final String MY_PREFS_NAME = "isFirstTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        if(prefs.getBoolean("key", true)){
            Intent intent = new Intent(SplashScreen.this, FirstTimeActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();

        }

    }
}