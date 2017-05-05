package br.com.q.ralfe.memory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int request_code = 1;
    String strNivel;
    Button bClicado;
    int number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogoda_memoria);
        setContentView(R.layout.activity_main);

    }

    public void onClickbEnviar(View view) {

        //EditText etTxt1 = (EditText) findViewById(R.id.etTexto1);

       // Intent i = new Intent(this, JogodaMemoria.class);
        Intent it = new Intent(this, JogodaMemoria.class);

        // chama atividade usando intent i; não espera retorno

        // exemplo se precisar selecionar um botão entre vários chamando o mesmo método onClick

        bClicado = (Button) findViewById(view.getId());

        switch (view.getId()){
            case R.id.bFacil:

                //  strNivel = "Facil";
               // i.putExtra("txt1", strNivel);
               // startActivity(i);
                number=2;
                it.putExtra("num", number);
                startActivity(it);

                break;
            case R.id.bMedio:

                //  strNivel = "Medio";
                //  i.putExtra("txt1", strNivel);
                //  startActivity(i);
                number=3;
                it.putExtra("num", number);
                startActivity(it);

                break;
            case R.id.bDificil:

                //  strNivel = "Dificil";
                //  i.putExtra("txt1", strNivel);
                // startActivity(i);
                number=4;
                it.putExtra("num", number);
                startActivity(it);

                break;
        }
    }

    public void onClickbPerguntar (View view) {
        //EditText etTxt1 = (EditText) findViewById(R.id.etTexto1);
        //String strTxt1 = etTxt1.getText().toString();

        //  Intent i = new Intent(this, JogodaMemoria.class);
        Intent it = new Intent(this, JogodaMemoria.class);


        switch (view.getId()) {
            case R.id.bFacil:

                // strNivel = "Facil";
                //  i.putExtra("txt1", strNivel);
                //  startActivityForResult(i, request_code);
                number=2;
                it.putExtra("num", number);
                startActivity(it);
                break;
            case R.id.bMedio:

                //  strNivel = "Medio";
                // i.putExtra("txt1", strNivel);
                // startActivityForResult(i, request_code);
                number=3;
                it.putExtra("num", number);
                startActivity(it);
                break;
            case R.id.bDificil:

                //  strNivel = "Dificil";
                //  i.putExtra("txt1", strNivel);
                // startActivityForResult(i, request_code);
                number=4;
                it.putExtra("num", number);
                startActivity(it);
                break;
            // chama atividade usando intent i;  espera retorno
            // request_code é um int usado para verificar o retorno da activity
        }
    }

    // metodo obrigatorio, nome e assinatura, para pegar o retorno da activity
    protected void onActivityResult (int requestCode, int resultCode, Intent dados) {
        if ((requestCode ==  request_code) && (resultCode == RESULT_OK)){
            //TextView tvResposta= (TextView) findViewById(R.id.tvResposta);
            //String strResposta = dados.getExtras().getString("txt2");
            //tvResposta.setText(strResposta);
        }
    }




}
