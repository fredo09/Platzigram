package com.example.fredy.platzigram.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fredy.platzigram.R;
import com.example.fredy.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * Created by Fredy on 26/05/2017.
 */

public class PictureAdaterRecyclerView extends RecyclerView.Adapter<PictureAdaterRecyclerView.PictureViewHolder> {

    //atrubutos a crear
    private ArrayList<Picture> pictures; //objetos creados del pojo
    private int resoruce; //compomentes del card view
    private Activity activity; //traer imegnes de internet

    public PictureAdaterRecyclerView(ArrayList<Picture> pictures, int resoruce, Activity activity) {
        this.pictures = pictures;
        this.resoruce = resoruce;
        this.activity = activity;
    }

    //infla los componentes que hay en la vista del XML
    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resoruce,parent,false); //inflamos el contenido de codigo
        return new PictureViewHolder(view);//enviamos ala clase
    }

    //Asocia los elemetos con el codigo java
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture=pictures.get(position);
        holder.username.setText(picture.getUserName());
        holder.times_card.setText(picture.getTime());
        holder.likes_number.setText(picture.getLikes_number());
    }

    //optiene el tamaño de l array y lo recorre
    @Override
    public int getItemCount() {
        return pictures.size();
    }

    //clase para asosiar los elementos que hay en el cardview
    public  class PictureViewHolder extends RecyclerView.ViewHolder {

        //creando atributos
        private ImageView picture_Card;
        private TextView username;
        private TextView likes_number;
        private TextView times_card;

        public PictureViewHolder(View itemView) {
            super(itemView);

            //asociando
            picture_Card=(ImageView) itemView.findViewById(R.id.imgCard);
            username=(TextView)itemView.findViewById(R.id.userNameCard);
            likes_number=(TextView) itemView.findViewById(R.id.cantidad_likescard);
            times_card=(TextView)itemView.findViewById(R.id.timeword_card);

        }
    }
}
