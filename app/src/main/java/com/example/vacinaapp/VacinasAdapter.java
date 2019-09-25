package com.example.vacinaapp;

import android.content.Context;
import android.os.Build;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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
        final VacinasAdapterViewHolder holder = new VacinasAdapterViewHolder(view);

        holder.nomeVacina.setOnLongClickListener(new View.OnLongClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Loongo click",Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        /*holder.nomeVacina.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                switch ( event.getAction() ){

                    case  DragEvent.ACTION_DRAG_STARTED:

                    Toast.makeText(v.getContext(),"Inicio do arrasto...", Toast.LENGTH_LONG).show();

                    break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        Toast.makeText(v.getContext(),"Fim do arrasto...", Toast.LENGTH_LONG).show();
                    break;
                }

                return false;
            }
        });*/


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

    /**
     * Obtém a lista de vacinas
     * @return
     */
    public ArrayList<Vacina> getVacinas(){
        return this.vacinas;
    }


}
