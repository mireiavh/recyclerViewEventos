package com.mireia.recyclerviewejercicioeventos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.FoodViewHolder>{

    // Interfaz para que otra actividad pueda capturar el evento de click
    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }

    // Datos
    private ArrayList<Food> coleccion;
    // Capturador de eventos de click
    private OnItemClickListener itemClickListener;

    // Constructor que recibe los datos y el listener
    public MiAdaptador(ArrayList<Food> coleccion, OnItemClickListener itemClickListener) {
        this.coleccion = coleccion;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MiAdaptador.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MiAdaptador.FoodViewHolder foodViewHolder =
                new FoodViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.food_card,parent,false)
                );
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.FoodViewHolder holder, int position) {
        Food food = coleccion.get(position);
        holder.imageView.setImageResource(food.getImage());
        holder.tv_title.setText(food.getTitle());
        holder.tv_getit.setText(food.getGetit().toString());
    }

    @Override
    public int getItemCount() {
        return coleccion.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView tv_title;
        TextView tv_getit;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            // Para propagar el evento de click a nuestra actividad
            itemView.setOnClickListener(this);

            // Referencias a los elementos de la vista
            imageView = itemView.findViewById(R.id.imageView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_getit = itemView.findViewById(R.id.tv_getit);


        }

        /**
         * Called when a view has been clicked.
         * @param v The view that was clicked.
         *          Propaga el evento hacía fuera, así podemos capturarlo en el punto
         *          que queramos de nuestra aplicación
         */
        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());

        }
    }

}
