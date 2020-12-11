package com.example.listarpaises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.listarpaises.Adapter.Adaptadorpais;
import com.example.listarpaises.model.datos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue request;
    private StringRequest stringr;
    private ListView paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paises = (ListView)findViewById(R.id.lstListaPais);

        View header = getLayoutInflater().inflate(R.layout.ly_header, null);

        paises.addHeaderView(header);
        btnenviar();

    }
    public void btnenviar()
    {


        request = Volley.newRequestQueue(MainActivity.this);
        String URL = "https://api.covid19api.com/summary";

        stringr = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>()  {
            @Override
            public void onResponse(String response) {
                ArrayList<datos> pais = new ArrayList<datos>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("Countries");
                    pais = datos.JsonObjectsBuild(jsonArray);

                    Adaptadorpais adaptadorpais = new Adaptadorpais(MainActivity.this,pais);
                    paises.setAdapter(adaptadorpais);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Sucedió un error en la consulta. Intente nuevamente. \n Detalle del error: "+error.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
        request.add(stringr);
    }



}