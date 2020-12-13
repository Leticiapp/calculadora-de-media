package com.example.appmultiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculaMedia(View view) {
        EditText nomeA = findViewById(R.id.editTextNome);
        EditText nota1A = findViewById(R.id.editTextNota1);
        EditText nota2A = findViewById(R.id.editTextNota2);
        EditText freqA = findViewById(R.id.editTextFrequencia);

        if ((nomeA.length() == 0) || (nota1A.length() == 0) || (nota2A.length() == 0) || (freqA.length() == 0))
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        else {
            Double N1 = Double.parseDouble(nota1A.getText().toString());
            Double N2 = Double.parseDouble(nota2A.getText().toString());
            int FQ = Integer.parseInt(freqA.getText().toString());

            if ((N1 < 0) || (N2 < 0) || (N1 > 10) || (N2 > 10))
                Toast.makeText(this, "A nota deve ser de 0 a 10!", Toast.LENGTH_SHORT).show();
            else
                if ((FQ < 0) || (FQ > 100))
                    Toast.makeText(this, "A frequencia deve ser de 0 a 100!", Toast.LENGTH_SHORT).show();
                else{
                    String NM = nomeA.getText().toString();
                    Double MD = (N1 + N2) / 2 ;

                    Intent it = new Intent(this, Media.class);
                    Bundle params = new Bundle();

                    params.putString("nome", NM);
                    params.putDouble("media", MD);
                    params.putInt("freq", FQ);

                    it.putExtras(params);
                    startActivity(it);
                    finish();


                }
        }
    }
}