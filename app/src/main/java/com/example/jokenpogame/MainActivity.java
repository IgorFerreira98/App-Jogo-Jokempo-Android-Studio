package com.example.jokenpogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*REMOVE A BARRA DE TITULOS*/
        getSupportActionBar().hide();
        /*REMOVE A BARRA DE FERRAMENTAS*/
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
    }

    //Intenção para abrir a tela principal do jogo.
    public void btnIniciarJogo(View a){
        Intent newgame = new Intent(MainActivity.this,activitygame.class);

        //INICIAR A INTENÇÃO
        startActivity(newgame);
    }

}