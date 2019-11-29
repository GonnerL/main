package com.example.ctb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ForecastActivity extends AppCompatActivity {
    TextView degree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        degree = (TextView)findViewById(R.id.degree);
        degree.setText("10");

    }
}
