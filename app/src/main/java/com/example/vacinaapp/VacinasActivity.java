package com.example.vacinaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;


public class VacinasActivity extends AppCompatActivity {

    private VacinasAdapter vacinasAdapter;
    private ArrayList<Vacina> vacinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacinas);


        setTitle("Vacinas oficiais");

        vacinas = new ArrayList<Vacina>();
        vacinas.add(new Vacina(1,"Varíola"));
        vacinas.add(new Vacina(2,"Sarampo"));
        vacinas.add(new Vacina(3,"Febre anarela"));

        //edtVacina = findViewById(R.id.edtVacina);
        RecyclerView listview  = (RecyclerView) findViewById(R.id.lstVacina);


        vacinasAdapter = new VacinasAdapter(vacinas,this);
        listview.setAdapter( vacinasAdapter);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        listview.setLayoutManager(layout);
    }


}
