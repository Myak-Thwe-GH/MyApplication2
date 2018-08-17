package com.example.user.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class LoginActivity extends Activity {
    TextView txt;
    Button btn;
    String url ="https://www.thecrazyprogrammer.com/wp-content/uploads/demo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt = (TextView)findViewById(R.id.txt);
        btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String s) {
                        txt.setText(s);
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        txt.setText("Some error occurred!!");
                    }
                });

                RequestQueue rQueue = Volley.newRequestQueue(LoginActivity.this);
            }
        });
    }
}