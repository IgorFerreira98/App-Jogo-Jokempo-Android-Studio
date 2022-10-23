package com.example.jokenpogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class activityInstrucao extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*REMOVE A BARRA DE TITULOS*/
        getSupportActionBar().hide();
        /*REMOVE A BARRA DE FERRAMENTAS*/
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_instrucao);


    }

    //Criando intenção para voltar para a tela do jogo
    public void btnVoltar(View View){
        Intent voltar = new Intent(activityInstrucao.this,activitygame.class);

        startActivity(voltar);
    }
}