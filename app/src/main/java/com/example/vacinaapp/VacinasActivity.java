package com.example.vacinaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializer;
import com.google.gson.stream.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.transform.stream.StreamResult;

import retrofit2.http.HTTP;


public class VacinasActivity extends AppCompatActivity {

    private VacinasAdapter vacinasAdapter;
    public static ArrayList<Vacina> vacinas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas);


        setTitle("Vacinas oficiais");

        VacinaApi.execute(new Runnable() {
            @Override
            public void run() {
                VacinaApi api = new VacinaApi();
                api.run();
            }
        });


//        vacinas = new ArrayList<Vacina>();
//
//        vacinas.add(new Vacina(1,"Varíola"));
//        vacinas.add(new Vacina(2,"Sarampo"));
//        vacinas.add(new Vacina(3,"Febre anarela"));
//        vacinas.add(new Vacina(4,"Rubéola"));

        //edtVacina = findViewById(R.id.edtVacina);
        RecyclerView listview  = (RecyclerView) findViewById(R.id.lstVacina);


        vacinasAdapter = new VacinasAdapter(vacinas,getApplicationContext());
        listview.setAdapter( vacinasAdapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        listview.setLayoutManager(layout);
    }




}
