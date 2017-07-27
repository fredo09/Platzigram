package com.example.fredy.platzigram.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fredy.platzigram.Adapter.PictureAdaterRecyclerView;
import com.example.fredy.platzigram.R;
import com.example.fredy.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    View view;
    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_home, container, false);
        setToolbar(getResources().getString(R.string.tab_home),false,view); //lamando al metodo
        setRecyclerview();

        //formade ver la lista vertical
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager); //agregando el manejador

        //instancia del adapter
        PictureAdaterRecyclerView pictureAdaterRecyclerView=
                new PictureAdaterRecyclerView(createpicture(),R.layout.cardview_picture,getActivity());

        //asignando el adaptador
        recyclerView.setAdapter(pictureAdaterRecyclerView);
        return view;
    }
    //Llamado al recyclerview
    public void setRecyclerview(){
        recyclerView=(RecyclerView)view.findViewById(R.id.my_picturerecyclerview);
    }

    //llenando el picture class
    public ArrayList<Picture> createpicture(){
        ArrayList<Picture> pictures=new ArrayList<>();
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","alfredo","2 dias","100 Me Gusta"));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Gomez","10 dias","1 Me Gusta"));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Memo","5 dias","10 Me Gusta"));
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Pepe","100 dias","1000 Me Gusta"));
        return pictures;
    }



    //soporte del toolbar
    public void setToolbar(String tittle, boolean upbtn,View view){
      Toolbar  toolbar=(Toolbar)view.findViewById(R.id.my_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //dando soporte a titulo y boton de regreso con el fragments
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upbtn);

    }

}
