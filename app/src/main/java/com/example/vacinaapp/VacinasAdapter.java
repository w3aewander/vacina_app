package com.example.vacinaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VacinasAdapter extends RecyclerView.Adapter {

    private ArrayList<Vacina> vacinas;
    private Context context;

    public VacinasAdapter(ArrayList<Vacina> vacinas, Context context) {
        this.vacinas = vacinas;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.vacinas = vacinas;
        this.context = context;


        View view = LayoutInflater.from(context).inflate(R.layout.vacina_item, parent, false);
        VacinasAdapterViewHolder holder = new VacinasAdapterViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final VacinasAdapterViewHolder holder =  (VacinasAdapterViewHolder) viewHolder;
        final Vacina vacina = vacinas.get(position) ;


        //holder.nomeVacina.setText(String.valueOf( vacina.getId() ));
        holder.nomeVacina.setText(vacina.getNome().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return vacinas.size();
    }

    public ArrayList<Vacina> getVacinas(){
        return this.vacinas;
    }
}
