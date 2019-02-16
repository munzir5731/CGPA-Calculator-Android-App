package com.example.abdullahal_munzir.mycourse;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edit_sgpa1, edit_sgpa2, edit_sgpa3, edit_sgpa4, edit_sgpa5, edit_sgpa6, edit_sgpa7, edit_sgpa8, edit_sgpa9, edit_sgpa10, edit_sgpa11, edit_sgpa12, edit_credit1,edit_credit2, edit_credit3, edit_credit4, edit_credit5, edit_credit6, edit_credit7, edit_credit8, edit_credit9, edit_credit10, edit_credit11, edit_credit12;
    private ArrayList<EditText> sgpaList = new ArrayList<>();
    private ArrayList<EditText> creditList = new ArrayList<>();
    private String[]pre_name_sgpa= new String[]{"sgpa1","sgpa2","sgpa3","sgpa4","sgpa5","sgpa6","sgpa7","sgpa8","sgpa9","sgpa10","sgpa11","sgpa12"};
    private String[]pre_name_credit= new String[]{ "credit1", "credit2", "credit3", "credit4", "credit5", "credit6", "credit7", "credit8", "credit9", "credit10", "credit11", "credit12"};
    private String [] s_sgpa = new String[12];
    private String [] s_credit = new String[12];
    private float [] sgpa = new float[14];
    private float [] credit = new float[12];
    private String test_sgpa, test_credit;
    private static final String MY_PREFS_NAME = "MyPrefsFile";
    private static final String SETTINGS_PREFS_NAME = "settingsPrefsFile";
    private int nOfSem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_logo_32dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout layout7 = findViewById(R.id.layout7);
        LinearLayout layout8 = findViewById(R.id.layout8);
        LinearLayout layout9 = findViewById(R.id.layout9);
        LinearLayout layout10 = findViewById(R.id.layout10);
        LinearLayout layout11 = findViewById(R.id.layout11);
        LinearLayout layout12 = findViewById(R.id.layout12);
        Button btn_Calculate = findViewById(R.id.btn_calculate);

        edit_sgpa1 = findViewById(R.id.edit_sgpa1);
        edit_sgpa2 = findViewById(R.id.edit_sgpa2);
        edit_sgpa3 = findViewById(R.id.edit_sgpa3);
        edit_sgpa4 = findViewById(R.id.edit_sgpa4);
        edit_sgpa5 = findViewById(R.id.edit_sgpa5);
        edit_sgpa6 = findViewById(R.id.edit_sgpa6);
        edit_sgpa7 = findViewById(R.id.edit_sgpa7);
        edit_sgpa8 = findViewById(R.id.edit_sgpa8);
        edit_sgpa9 = findViewById(R.id.edit_sgpa9);
        edit_sgpa10 = findViewById(R.id.edit_sgpa10);
        edit_sgpa11 = findViewById(R.id.edit_sgpa11);
        edit_sgpa12 = findViewById(R.id.edit_sgpa12);

        edit_credit1 = findViewById(R.id.edit_credit1);
        edit_credit2 = findViewById(R.id.edit_credit2);
        edit_credit3 = findViewById(R.id.edit_credit3);
        edit_credit4 = findViewById(R.id.edit_credit4);
        edit_credit5 = findViewById(R.id.edit_credit5);
        edit_credit6 = findViewById(R.id.edit_credit6);
        edit_credit7 = findViewById(R.id.edit_credit7);
        edit_credit8 = findViewById(R.id.edit_credit8);
        edit_credit9 = findViewById(R.id.edit_credit9);
        edit_credit10 = findViewById(R.id.edit_credit10);
        edit_credit11 = findViewById(R.id.edit_credit11);
        edit_credit12 = findViewById(R.id.edit_credit12);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences set_prefs = getSharedPreferences(SETTINGS_PREFS_NAME, MODE_PRIVATE);

        if(set_prefs.getBoolean("key", false)){
            sgpaList.add(edit_sgpa1);
            sgpaList.add(edit_sgpa2);
            sgpaList.add(edit_sgpa3);
            sgpaList.add(edit_sgpa4);
            sgpaList.add(edit_sgpa5);
            sgpaList.add(edit_sgpa6);
            sgpaList.add(edit_sgpa7);
            sgpaList.add(edit_sgpa8);
            sgpaList.add(edit_sgpa9);
            sgpaList.add(edit_sgpa10);
            sgpaList.add(edit_sgpa11);
            sgpaList.add(edit_sgpa12);

            creditList.add(edit_credit1);
            creditList.add(edit_credit2);
            creditList.add(edit_credit3);
            creditList.add(edit_credit4);
            creditList.add(edit_credit5);
            creditList.add(edit_credit6);
            creditList.add(edit_credit7);
            creditList.add(edit_credit8);
            creditList.add(edit_credit9);
            creditList.add(edit_credit10);
            creditList.add(edit_credit11);
            creditList.add(edit_credit12);
            nOfSem = 12;

        }

        else {
            layout9.setVisibility(View.GONE);
            layout10.setVisibility(View.GONE);
            layout11.setVisibility(View.GONE);
            layout12.setVisibility(View.GONE);

            sgpaList.add(edit_sgpa1);
            sgpaList.add(edit_sgpa2);
            sgpaList.add(edit_sgpa3);
            sgpaList.add(edit_sgpa4);
            sgpaList.add(edit_sgpa5);
            sgpaList.add(edit_sgpa6);
            sgpaList.add(edit_sgpa7);
            sgpaList.add(edit_sgpa8);

            creditList.add(edit_credit1);
            creditList.add(edit_credit2);
            creditList.add(edit_credit3);
            creditList.add(edit_credit4);
            creditList.add(edit_credit5);
            creditList.add(edit_credit6);
            creditList.add(edit_credit7);
            creditList.add(edit_credit8);

            nOfSem = 8;
        }


        for (int i= 0; i<nOfSem; i++){
            sgpaList.get(i).setText(prefs.getString(pre_name_sgpa[i], ""));
            creditList.get(i).setText(prefs.getString(pre_name_credit[i], ""));
        }


        btn_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                float total_credit =0, mult=0, result;

                for (int i=0; i<nOfSem; i++){
                    test_sgpa =sgpaList.get(i).getText().toString();
                    Log.d("list"+i, "onClick: "+test_sgpa);
                    if(test_sgpa.isEmpty() || test_sgpa.equals(".")){
                        s_sgpa[i]="0";
                        sgpaList.get(i).setText("");
                    }
                    else {s_sgpa[i]= test_sgpa;}

                    test_credit= creditList.get(i).getText().toString();
                    if(test_credit.isEmpty() || test_credit.equals(".")){
                        s_credit[i]="0";
                        creditList.get(i).setText("");
                    }
                    else {s_credit[i]= test_credit;}
                    Log.d("list"+i, "onClick: after "+test_sgpa);
                    sgpa[i]=Float.parseFloat(s_sgpa[i]);
                    credit[i]=Float.parseFloat(s_credit[i]);


                    mult = mult+(credit[i]*sgpa[i]);
                    total_credit = total_credit+ credit[i];

                    editor.putString(pre_name_sgpa[i], s_sgpa[i]);    // Saving String
                    editor.putString(pre_name_credit[i], s_credit[i]);    // Saving String
                    editor.apply();


                }


                if(total_credit != 0) {
                    result = mult / total_credit;

                sgpa[nOfSem] = result;
                sgpa[nOfSem+1] = total_credit;

                    Bundle b = new Bundle();
                    b.putFloatArray("sgpa", sgpa);
                    Intent i = new Intent(getApplicationContext(), GraphActivity.class);
                    i.putExtras(b);
                    startActivity(i);
                    overridePendingTransition(R.transition.enter, R.transition.exit);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please add credit", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    public void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case R.id.action_clearSgpa_field:
                for (int i= 0; i<nOfSem; i++){
                    sgpaList.get(i).setText("");
                }
                return true;
            case R.id.action_clearCredit_field:
                for (int i= 0; i<nOfSem; i++){
                    creditList.get(i).setText("");
                }
                return true;

            case R.id.action_clearAll_field:
                for (int i= 0; i<nOfSem; i++){
                    sgpaList.get(i).setText("");
                    creditList.get(i).setText("");
                }
                return true;

            case R.id.action_settings:
                Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(i);
                return true;

            case R.id.action_about:
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_new)
                .setTitle("EXIT?")
                .setMessage("To save the entered value please tap the calculate button. If don't all entered value will be lost!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
