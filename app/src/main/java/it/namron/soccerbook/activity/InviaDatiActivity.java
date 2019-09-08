package it.namron.soccerbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

import it.namron.soccerbook.R;
import it.namron.soccerbook.extra.Persona;

import static it.namron.soccerbook.constant.Constant.PERSONA_EXTRA;


public class InviaDatiActivity extends AppCompatActivity {

    Persona persona;
    Button indietro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invia_dati);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(
                PERSONA_EXTRA
        );

        indietro = (Button)findViewById(R.id.indietro);


        if(obj instanceof Persona)
        {
            persona = (Persona)obj;
        }
        else{
            persona = new Persona();
        }

        //username.setText("Recupero");

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent InviaDati = new Intent(InviaDatiActivity.this,
                        LoginActivity.class);
                startActivity(InviaDati);
            }
        });
    }


}
