package com.example.fredy.platzigram.view;

//import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.fredy.platzigram.R;

public class PictureDetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detalle);

        setToolbar("Detalle",true);
    }

    //soporte del toolbar
    public void setToolbar(String tittle, boolean upbtn){
        Toolbar toolbar=(Toolbar)findViewById(R.id.my_toolbar2);
       // CollapsingToolbarLayout collapsingToolbarLayout= (CollapsingToolbarLayout)findViewById(R.id.my_collapsing);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upbtn);

    }
}
