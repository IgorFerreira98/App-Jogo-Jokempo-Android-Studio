package com.example.jokenpogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class activitygame extends AppCompatActivity {



    RadioButton rbPedra, rbPapel, rbTesoura;
    TextView tvResultadoVitorias, tvResultadoDerrotas, tvResultadoEmpates, tvResultadoJogadas;
    Button btnNovoJogo, btnIntrucao;
    ImageView ivVoce, ivRobo;
    int iEscolhaRobo, iEscolhaJogador;
    Random Sorteio = new Random();
    int voce = 1, robo = 1, empate = 1, jogadas = 1;
    int[] img = {R.drawable.img_0,R.drawable.img_papel,R.drawable.img_pedra,R.drawable.img_tesoura};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*REMOVE A BARRA DE TITULOS*/
        getSupportActionBar().hide();
        /*REMOVE A BARRA DE FERRAMENTAS*/
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_activitygame);

        rbPedra = findViewById(R.id.rbPedra);
        rbPapel = findViewById(R.id.rbPapel);
        rbTesoura = findViewById(R.id.rbTesoura);
        tvResultadoVitorias = findViewById(R.id.tvResultadoVitorias);
        tvResultadoDerrotas = findViewById(R.id.tvResultadoDerrotas);
        tvResultadoEmpates = findViewById(R.id.tvResultadoEmpates);
        tvResultadoJogadas = findViewById(R.id.tvResultadoJogadas);
        btnNovoJogo = findViewById(R.id.btnNovoJogo);
        btnIntrucao = findViewById(R.id.btnInstrucao);
        ivRobo = findViewById(R.id.ivRobo);
        ivVoce = findViewById(R.id.ivVoce);
        tvResultadoJogadas.setText("0");
        tvResultadoDerrotas.setText("0");
        tvResultadoVitorias.setText("0");
        tvResultadoEmpates.setText("0");
        ivVoce.setImageResource(R.drawable.tela_padrao2);
        ivRobo.setImageResource(R.drawable.tela_padrao2);


    }


    //REGRA
    //1-Papel 2-Pedra 3-Tesoura

    //Jogador(1) Robo(2) = -1 Jogador Ganhou
    //Jogador(1) Robo(3) = -2 Robo Ganhou
    //Jogador(2) Robo(1) = 1 = Robo Ganhou
    //Jogador(2) Robo(3) = -1 Jogador Ganhou
    //Jogador(3) Robo(1) = 2 Jogador Ganhou
    //Jogador(3) Robo(2) = 1 Robo Ganhou

    public void rbPapel (View View) {
        iEscolhaJogador = 1;
        ivVoce.setImageResource(img[1]);
        roboEscolhe();
        verificacao();
    }

    public void rbPedra (View View) {
        iEscolhaJogador = 2;
        ivVoce.setImageResource(img[2]);
        roboEscolhe();
        verificacao();
    }

    public void rbTesoura (View View) {
        iEscolhaJogador = 3;
        ivVoce.setImageResource(img[3]);
        roboEscolhe();
        verificacao();
    }

    //Verificação da regra para definir vitórias, empates, derrotas e jogadas.
    public void verificacao() {

        if (iEscolhaRobo == iEscolhaJogador) {
            tvResultadoEmpates.setText(String.valueOf(empate++));
            tvResultadoJogadas.setText(String.valueOf(jogadas++));
        }else if (iEscolhaJogador - iEscolhaRobo == -1 || iEscolhaJogador - iEscolhaRobo == 2){
            tvResultadoVitorias.setText(String.valueOf(voce++));
            tvResultadoJogadas.setText(String.valueOf(jogadas++));
        }else {
            tvResultadoDerrotas.setText(String.valueOf(robo++));
            tvResultadoJogadas.setText(String.valueOf(jogadas++));
        }
    }

    //Método para sortear um número de 1 a 3 e colocar a imagem referente a escolha da maquina.
    public void roboEscolhe(){
        iEscolhaRobo = Sorteio.nextInt(3)+1;
        ivRobo.setImageResource(img[iEscolhaRobo]);

    }

    //Intenção para abrir a tela de instruções
    public void btnInstrucao(View View){
        Intent instrucao = new Intent(activitygame.this,activityInstrucao.class);


        startActivity(instrucao);
    }

    //Botão novo jogo, reseta pontos, imagens e desmarca radiobuttons.
    public void btnNovoJogo(View view) {
        tvResultadoJogadas.setText("0");
        tvResultadoDerrotas.setText("0");
        tvResultadoVitorias.setText("0");
        tvResultadoEmpates.setText("0");
        rbPedra.setChecked(false);
        rbPapel.setChecked(false);
        rbTesoura.setChecked(false);
        ivVoce.setImageResource(R.drawable.tela_padrao2);
        ivRobo.setImageResource(R.drawable.tela_padrao2);
        robo = 1;
        voce = 1;
        jogadas = 1;
        empate = 1;
    }



}
