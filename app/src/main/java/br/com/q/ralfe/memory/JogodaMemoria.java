package br.com.q.ralfe.memory;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

public class JogodaMemoria extends AppCompatActivity {

    // Verificar se pode ser public
    public int[][] jogada;
    int contJogadas = 0;
    int flagErro = 0;
    int par = 0;
    int r=0;
    int s=0;
    int n = 0;
    int ganhou=0;

    Button bClicado, b1Clicado, b2Clicado;
    Button bJogar, bLimpar;

    Button B00, B01, B02, B03, B10, B11, B12, B13, B20, B21, B22, B23, B30, B31, B32, B33;
    TextView tvMensagem;
    TableLayout tlMatrizJogo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogoda_memoria);

        tvMensagem = (TextView) findViewById(R.id.tvMensagem);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        //  String txt1 = extras.getString("txt1");
        //  TextView tvTxt2 = (TextView) findViewById(R.id.tvMensagem);
        //  tvTxt2.setText(txt1);

        bJogar = (Button) findViewById(R.id.bJogar);
        bLimpar = (Button) findViewById(R.id.bLimpar);

        B00 = (Button) findViewById(R.id.b00);
        B01 = (Button) findViewById(R.id.b01);
        B02 = (Button) findViewById(R.id.b02);
        B03 = (Button) findViewById(R.id.b03);
        B10 = (Button) findViewById(R.id.b10);
        B11 = (Button) findViewById(R.id.b11);
        B12 = (Button) findViewById(R.id.b12);
        B13 = (Button) findViewById(R.id.b13);
        B20 = (Button) findViewById(R.id.b20);
        B21 = (Button) findViewById(R.id.b21);
        B22 = (Button) findViewById(R.id.b22);
        B23 = (Button) findViewById(R.id.b23);
        B30 = (Button) findViewById(R.id.b30);
        B31 = (Button) findViewById(R.id.b31);
        B32 = (Button) findViewById(R.id.b32);
        B33 = (Button) findViewById(R.id.b33);

        tlMatrizJogo = (TableLayout) findViewById(R.id.tlMatrizJogo) ;

        jogada = new int[4][4];

        getJogada();

        bLimpar.setVisibility(View.INVISIBLE);
        Intent it = getIntent();
        n =  it.getIntExtra("num",1);


        //facil
        if(n==2){

            n=2;
            B20.setVisibility(View.INVISIBLE);
            B21.setVisibility(View.INVISIBLE);
            B22.setVisibility(View.INVISIBLE);
            B23.setVisibility(View.INVISIBLE);
            B30.setVisibility(View.INVISIBLE);
            B31.setVisibility(View.INVISIBLE);
            B32.setVisibility(View.INVISIBLE);
            B33.setVisibility(View.INVISIBLE);

            String txt1 = "FÁCIL";
            TextView tvTxt2 = (TextView) findViewById(R.id.tvMensagem);
            tvTxt2.setText(txt1);


        }
        //medio
        else if(n==3){
            n=3;
            B30.setVisibility(View.INVISIBLE);
            B31.setVisibility(View.INVISIBLE);
            B32.setVisibility(View.INVISIBLE);
            B33.setVisibility(View.INVISIBLE);

            String txt1 = "MÉDIO";
            TextView tvTxt2 = (TextView) findViewById(R.id.tvMensagem);
            tvTxt2.setText(txt1);

        }
        //dificil
        else if(n==4){
            n=4;

            String txt1 = "DIFÍCIL";
            TextView tvTxt2 = (TextView) findViewById(R.id.tvMensagem);
            tvTxt2.setText(txt1);

        }
    }

    void onClickJogar(View view) {


        int i = 0, j = 0;

        bClicado = (Button) findViewById(view.getId());
        switch (view.getId()) {

            case R.id.b00: i=0; j=0; break;
            case R.id.b01: i=0; j=1; break;
            case R.id.b02: i=0; j=2; break;
            case R.id.b03: i=0; j=3; break;
            case R.id.b10: i=1; j=0; break;
            case R.id.b11: i=1; j=1; break;
            case R.id.b12: i=1; j=2; break;
            case R.id.b13: i=1; j=3; break;
            case R.id.b20: i=2; j=0; break;
            case R.id.b21: i=2; j=1; break;
            case R.id.b22: i=2; j=2; break;
            case R.id.b23: i=2; j=3; break;
            case R.id.b30: i=3; j=0; break;
            case R.id.b31: i=3; j=1; break;
            case R.id.b32: i=3; j=2; break;
            case R.id.b33: i=3; j=3; break;

        }

        contJogadas++;

        // 1st number clicked
        if (par == 0) {

            if( flagErro == 1 ){

                b1Clicado.setText(String.valueOf(""));
                b2Clicado.setText(String.valueOf(""));

                flagErro = 0;

            }

            b1Clicado = bClicado;

            par = jogada[i][j];

            // Show Numbers
            b1Clicado.setTextColor(Color.BLUE);
            b1Clicado.setText(String.valueOf(jogada[i][j]));
            //tvMensagem.setText(String.valueOf(contJogadas));
        }

        // 2st number clicked
        else if (par == jogada[i][j]) {

            par = 0;
            b2Clicado = bClicado;

            b1Clicado.setTextColor(Color.BLUE);
            b2Clicado.setTextColor(Color.BLUE);
            b2Clicado.setText(String.valueOf(jogada[i][j]));

            ganhou=ganhou+1;
            //tvMensagem.setText(String.valueOf(contJogadas));

        } // 2st number clicked
        else if( (par != jogada[i][j]) && (par != 0) ){

            par = 0;
            flagErro = 1;

            b2Clicado = bClicado;

            // Show Numbers
            b2Clicado.setText(String.valueOf(jogada[i][j]));
            b1Clicado.setTextColor(Color.RED);
            b2Clicado.setTextColor(Color.RED);

            //sleep(1000);
            //try {
            //    Thread.sleep(700);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}

            //SystemClock.sleep(700);


            // Hide Numbers
            //b1Clicado.setText(String.valueOf(""));
            //b2Clicado.setText(String.valueOf(""));

        }
        if(n==2) {

            if (ganhou == 4) {
              //  bLimpar.setVisibility(View.VISIBLE);
                String txt1 = "VOCÊ GANHOU!!!";
                TextView tvTxt2 = (TextView) findViewById(R.id.tvMensagem);
                tvTxt2.setText(txt1);
            }
        }
        else if(n==3) {

            if (ganhou == 6) {
               // bLimpar.setVisibility(View.VISIBLE);
                String txt1 = "VOCÊ GANHOU!!!";
                TextView tvTxt2 = (TextView) findViewById(R.id.tvMensagem);
                tvTxt2.setText(txt1);
            }
        }
        else if(n==4) {

            if (ganhou == 8) {
              //  bLimpar.setVisibility(View.VISIBLE);
                String txt1 = "VOCÊ GANHOU!!!";
                TextView tvTxt2 = (TextView) findViewById(R.id.tvMensagem);
                tvTxt2.setText(txt1);
            }
        }
    }


    void onClickLimpar (){

        jogada = new int[4][4];
        LimpaTela();

    }

    void onClickJogarNovamente (View view){

        jogada = new int[4][4];


        LimpaTela();

        getJogada();

//        SystemClock.sleep(2000);
//
//        LimpaTela();

    }

    void onClickResolver(View view){



//        // zerar tabuleiro do jogo da velha
//        for (int i=0; i<4; i++){
//            for (int j=0; j<4; j++){
//                b1Clicado.setTextColor(Color.BLUE);
//                b1Clicado.setText(String.valueOf(jogada[i][j]));
//
//            }
//        }

        // zerar os botoes
        // tlMatrizJogo.getChildCount()
        Intent it = getIntent();
        int n =  it.getIntExtra("num",1);

//

        //for (int i=0; i<jogada.length; i++){
        for (int i=0; i<4; i++){

            TableRow linha = (TableRow) tlMatrizJogo.getChildAt(i);

            // linha.getChildCount();

            for (int j=0; j<4; j++){

                // pode testar com if (A instaceof B)
                Button bSolve = (Button) linha.getChildAt(j);
                bSolve.setText(String.valueOf(jogada[i][j]));

            }
        }

    }


    // Gera uma matriz de numero aleatório
    public int[][] getJogada() {

        // Criada e Inicializada Variavel
        //int[][] jogada = new int[4][4];

        // Gera uma matriz com valores fixos

            jogada = new int[][]{{1, 3, 4, 2}, {2, 4, 1, 3}, {5, 6, 6, 5}, {7, 8, 8, 7}};

        // }


        Random rlinha;
        Random rcoluna;
        int varTemp;
        int nLinha = 0;
        int nColuna = 0;
        rlinha = new Random();
        rcoluna = new Random();


//        // Percorre cada elemento da matriz para trocar a posição
        if (n == 2) {


            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {

                    // Gera uma posição aleatória dentro dos limites

                    nLinha = rlinha.nextInt(1) + 1;

                    nColuna = rcoluna.nextInt(3) + 1;


                    // Comuta os valores das posições (principal e aleatória) uma a uma
                    varTemp = jogada[i][j];
                    jogada[i][j] = jogada[nLinha][nColuna];
                    jogada[nLinha][nColuna] = varTemp;
                    // aleatorio = generator.nextInt(3) + 1;
                    //for(int h=0;h<2;h++){
                    //  for(int l=0;l<4;l++){
                    //    if(aleatorio==jogada[h][l]){
                    //      aleatorio=generator.nextInt(3)+1;

                    //}
                    //else {
                    //  jogada[h][l]=aleatorio;
                    //}
                    //}
                    //}
                    //jogada[i][j] = aleatorio;
                }
            }

        }
        else if(n==3){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {

                    // Gera uma posição aleatória dentro dos limites

                    nLinha = rlinha.nextInt(2) + 1;

                    nColuna = rcoluna.nextInt(3) + 1;


                    // Comuta os valores das posições (principal e aleatória) uma a uma
                    varTemp = jogada[i][j];
                    jogada[i][j] = jogada[nLinha][nColuna];
                    jogada[nLinha][nColuna] = varTemp;
                }
            }



        }
        else if(n==4){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    // Gera uma posição aleatória dentro dos limites

                    nLinha = rlinha.nextInt(2) + 1;

                    nColuna = rcoluna.nextInt(3) + 1;


                    // Comuta os valores das posições (principal e aleatória) uma a uma
                    varTemp = jogada[i][j];
                    jogada[i][j] = jogada[nLinha][nColuna];
                    jogada[nLinha][nColuna] = varTemp;
                }
            }



        }

        return jogada;
    }

    public void setJogada(int[][] jogada) {
        this.jogada = jogada;
    }


    // Gera uma matriz de numero aleatório
    public void LimpaTela() {

        // esconder botao e mensagem
        //bJogar.setVisibility(view.INVISIBLE);


        // zerar tabuleiro do jogo da velha
        for (int i=0; i<jogada.length; i++){
            for (int j=0; j<jogada.length; j++){
                jogada[i][j] = 0; // poderia unificar
            }
        }

        // zerar os botoes
        // tlMatrizJogo.getChildCount()
        for (int i=0; i<jogada.length; i++){
            TableRow linha = (TableRow) tlMatrizJogo.getChildAt(i);
            // linha.getChildCount()
            for (int j=0; j<jogada.length; j++){
                // pode testar com if (A instaceof B)
                Button bLimpar = (Button) linha.getChildAt(j);
                bLimpar.setText("");
                bLimpar.setTextColor(Color.BLACK);
            }
        }

    }



}
