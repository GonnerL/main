package com.example.ctb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class OpenAPIClient extends AppCompatActivity {

    String houseTem = "24℃  45%";
    String houseDust = "42.08 ㎍/㎥";
    Double tem_min, tem_max;
    String humid;

    //TextView mTextViewResult;
    //RequestQueue mQueue;
    //WeatherInfo weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_weather);
        //weatherInfo = new WeatherInfo();
        //mTextViewResult = findViewById(R.id.textView5);
        //mQueue = Volley.newRequestQueue(this);
        //jsonParse();
    }

    public void getCurrentWeather(final TextView mTextViewResult, final TextView house_tem, RequestQueue mQueue, Double lat, Double lon) {
        String url = "https://openweathermap.org/data/2.5/weather?q=Seoul&appid=b6907d289e10d714a6e88b30761fae22";
        url = url.concat("&lon="+lon.toString()+"&lat="+lat.toString());

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject main = response.getJSONObject("main");
                            Double temp = main.getDouble("temp");
                            tem_max = main.getDouble("temp_min");
                            String hum = main.getString("humidity");
                            humid = hum;
                            mTextViewResult.append(temp+"℃  "+ hum+"%"+"\n"+50.03+"㎍/㎥");
                            house_tem.append(houseTem+"\n"+houseDust);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    public void getCurrentDust(final TextView mTextViewResult) {
        String url = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnStatsSvc/getMsrstnAcctoLastDcsnDnsty?stationName=권선구&searchCondition=DAILY" +
                "&pageNo=1&numOfRows=10&ServiceKey=d%2BVtlnK922p4WsvWXCl8vRqyKYqR5T%2Fpl2%2F5CtG5sxhxBFpx%2Fwkx64InRbvmAmmrYpa%2B6gNoRZfaY3uVnWdzag%3D%3D";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject item = response.getJSONObject("item");
                            Double dust = item.getDouble("pm10Avg");
                            mTextViewResult.append(50.03+"㎍/㎥"+ "\n\n");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        //mTextViewResult.append(50.03+"㎍/㎥"+ "\n\n");
    }

    public void getCurrentDisease(final TextView currentTem, final TextView temMax,final TextView temMin, final TextView hum){

    }




}
