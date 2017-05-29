package com.example.fredy.platzigram.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.fredy.platzigram.R;

public class CreateAccountActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //llama a
        setToolbar(getResources().getString(R.string.tittle_create_user),true);
    }


    //soporte a toolbar
    public void setToolbar(String tittle, boolean upbtn){
        toolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        //dando soporte a titulo y boton de regreso
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upbtn);

    }
}
