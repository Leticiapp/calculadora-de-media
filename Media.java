package com.example.appmultiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Media extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        TextView textViewAluno = findViewById(R.id.textViewAluno);
        TextView textViewFreq = findViewById(R.id.textViewFreq);
        TextView textViewMedia = findViewById(R.id.textViewMedia);
        TextView textViewSituacao = findViewById(R.id.textViewSituacao);

        Intent it = getIntent();
        if (it != null) {
            Bundle params = it.getExtras();

            if (params != null){
                String nome = params.getString("nome");
                Double media = params.getDouble("media");
                int freq = params.getInt("freq");

                textViewAluno.setText(nome.toUpperCase());
                textViewFreq.setText(String.valueOf(freq) + "%");
                textViewMedia.setText(String.valueOf(media));

                if (freq < 75)
                    textViewSituacao.setText("REPROVADO POR FALTA");
                else
                    if (media < 4)
                        textViewSituacao.setText("REPROVADO POR NOTA");
                    else
                        if (media >= 7)
                            textViewSituacao.setText("APROVADO");
                        else
                            textViewSituacao.setText("FINAL");
            }
        }
    }

    public void voltar(View view){

        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();

    }
}