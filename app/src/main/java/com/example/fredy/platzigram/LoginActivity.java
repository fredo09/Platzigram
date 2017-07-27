package com.example.fredy.platzigram;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.fredy.platzigram.view.ContainerActivity;
import com.example.fredy.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkInternetStatePermission();
    }

    //Metodo para ir a crear usuario
    public void irNuevoUsuario(View view){
        Intent intent=new Intent(this,CreateAccountActivity.class);
        startActivity(intent);
       // Toast toast=Toast.makeText(this,"Click en crear usuario", Toast.LENGTH_LONG);
        //toast.show();
    }

   //Login
    public void Login(View view){
        Intent intent=new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

    //Checa si el persimo esta en el archivo manifest y si esta activado manda un mensaje de confirmacion
    private void checkInternetStatePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.INTERNET);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para Accesar a internet");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para accesar a internet");
        }
    }
}
