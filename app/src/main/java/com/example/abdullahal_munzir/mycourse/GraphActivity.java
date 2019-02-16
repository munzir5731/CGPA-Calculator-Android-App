package com.example.abdullahal_munzir.mycourse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    String [] labels_12 = new String[] {"1'st","2'nd","3'rd","4'th","5'th","6'th","7'th", "8'th", "9'th", "10'th", "11'th", "12'th", "CGPA"};
    String [] labels_8 = new String[] {"1'st","2'nd","3'rd","4'th","5'th","6'th","7'th", "8'th","CGPA"};
    private static final String SETTINGS_PREFS_NAME = "settingsPrefsFile";
    private int nOfSem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = this.getIntent().getExtras();
        float [] sgpa = b.getFloatArray("sgpa");

        BarChart chart = (BarChart) findViewById(R.id.chart);
        TextView result_view = findViewById(R.id.result_view);

        SharedPreferences set_prefs = getSharedPreferences(SETTINGS_PREFS_NAME, MODE_PRIVATE);
        if(set_prefs.getBoolean("key", false)) {
            nOfSem = 12;
            chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels_12));
        }
        else{
            nOfSem=8;
            chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels_8));
        }

        String cgpa = new DecimalFormat("##.##").format(sgpa[nOfSem]);
        int total_credit = (int)sgpa[nOfSem+1];
        result_view.setText("CGPA : "+cgpa+"\nTotal Credit : "+total_credit);

        chart.getDescription().setEnabled(false);
        ArrayList<BarEntry> entries = new ArrayList<>();


        int Xvalue=0;
        for (int i=0; i<=nOfSem; i++){
                entries.add(new BarEntry(Xvalue, sgpa[i]));
                Xvalue++;
        }

        BarDataSet set = new BarDataSet(entries, "Semester");
        //set.setDrawValues(true);

        set.setColors(new int[]{R.color.Cyan , R.color.Purple, R.color.Orange, R.color.Blue,R.color.Yellow,R.color.Green,R.color.Pink,R.color.Lime,R.color.Magenta,R.color.Teal,R.color.Lavender,R.color.Brown,R.color.Red} , getApplicationContext());
        set.setValueFormatter(new MyValueFormatter());

        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setLabelRotationAngle(-45);
        //xAxis.setTextSize(14);


        YAxis left = chart.getAxisLeft();
        YAxis yAxis = chart.getAxisLeft();
        chart.getAxisRight().setEnabled(false); // no right axis
        yAxis.setAxisMaximum(4f);
        yAxis.setAxisMinimum(1.5f);

        //chart.setPinchZoom();
        chart.animateY(3000, Easing.EasingOption.EaseOutCubic);

        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        chart.setData(data);
        chart.setFitBars(true); // make the x-axis fit exactly all bars
        chart.invalidate(); // refresh


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class MyValueFormatter implements IValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("#.##"); // use one decimal
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            // write your logic here
            return mFormat.format(value);
        }
    }

}
