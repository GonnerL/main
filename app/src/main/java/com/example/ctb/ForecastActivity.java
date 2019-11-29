package com.example.ctb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ForecastActivity extends AppCompatActivity {
    TextView degree, humid, temp_min, temp_max,risk,comment;
    RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        init();

        OpenAPIClient openAPIClient = new OpenAPIClient();
        openAPIClient.getCurrentDisease(mQueue, degree, temp_max,temp_min,humid,risk,comment);

    }

    public void init(){
        degree = (TextView)findViewById(R.id.degree);
        humid = (TextView)findViewById(R.id.hum);
        temp_max = (TextView)findViewById(R.id.temMax);
        temp_min = (TextView)findViewById(R.id.tempMin);
        mQueue = Volley.newRequestQueue(this);
        risk = findViewById(R.id.risk);
        comment = findViewById(R.id.comment);
    }
}
