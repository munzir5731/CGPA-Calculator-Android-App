package com.example.abdullahal_munzir.mycourse;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FirstTimeActivity extends Activity {

    private static final String MY_PREFS_NAME = "settingsPrefsFile";
    private static final String CHECK_PREFS_NAME = "isFirstTime";
    private RadioGroup radioGroup;
    private RadioButton twelve, eight;
    private Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);

        final SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        final SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        final SharedPreferences.Editor check_editor = getSharedPreferences(CHECK_PREFS_NAME, MODE_PRIVATE).edit();

        radioGroup = findViewById(R.id.semester_radio_group);
        twelve = findViewById(R.id.twelve_semester_system);
        eight = findViewById(R.id.eight_semester_system);
        btn_go = findViewById(R.id.btn_go);

        if(prefs.getBoolean("key", false)){
            twelve.setChecked(true);
        }
        else{eight.setChecked(true);}


        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("key", false);    // Saving boolean
                editor.apply();
                recreate();
            }
        });

        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("key", true);
                editor.apply();
                recreate();
            }
        });

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check_editor.putBoolean("key", false);    // Saving boolean
                check_editor.apply();
                recreate();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.transition.enter, R.transition.exit);
                finish();
            }
        });

    }
}
