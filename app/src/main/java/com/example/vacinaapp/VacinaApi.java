package com.example.vacinaapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class VacinaApi extends AsyncTask implements Runnable {


    @Override
    public void run() {


                    try {

                        URL url = new URL("http://186.237.59.67/api/vacinas");
                        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                        httpConn.setRequestMethod("GET");
                        InputStream inputStream = httpConn.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String line = bufferedReader.readLine();

                        JSONArray jsonArray = new JSONArray( line );

                        VacinasActivity.vacinas.clear();

                        for ( int i = 0; i < jsonArray.length(); i++){

                            String jsonString  =  jsonArray.getString(i);

                            JSONObject mainObject = new JSONObject(jsonString);

                            String nome = mainObject.getString("nome");
                            Log.i("LOG", nome);


                            Vacina vacina = new Vacina(i,nome);
                            VacinasActivity.vacinas.add(vacina);
                        }

                        httpConn.disconnect();

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

    }


    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }
}
