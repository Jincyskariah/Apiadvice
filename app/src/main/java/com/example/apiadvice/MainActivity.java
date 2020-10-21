package com.example.apiadvice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    AsyncHttpClient asyncHttpClient;
    RequestParams requestParams;
    String url="https://api.adviceslip.com/advice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asyncHttpClient=new AsyncHttpClient();
        requestParams=new RequestParams();

        asyncHttpClient.get(url,requestParams,new JsonHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        JSONObject jsonObject=response;
                        try {
                            JSONObject obj=jsonObject.getJSONObject("slip");

                                String name = obj.getString("advice");


                               // Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );

    }
}
