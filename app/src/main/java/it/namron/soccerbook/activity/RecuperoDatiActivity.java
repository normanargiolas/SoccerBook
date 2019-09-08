package it.namron.soccerbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

import it.namron.soccerbook.R;
import it.namron.soccerbook.extra.Persona;

import static it.namron.soccerbook.constant.Constant.PERSONA_EXTRA;

public class RecuperoDatiActivity extends AppCompatActivity {

    Persona persona;
    EditText email;
    Button invia;
    TextView errore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recupero_dati);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(
                PERSONA_EXTRA
        );

        if (obj instanceof Persona) {
            persona = (Persona) obj;
        } else {
            persona = new Persona();
        }

        email = (EditText) findViewById(R.id.email);
        invia = (Button) findViewById(R.id.invia);

        errore = (TextView) findViewById(R.id.errore);
        errore.setVisibility(View.GONE);


        invia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {
                    updatePersona();
                    Intent RecuperoDati = new Intent(RecuperoDatiActivity.this,
                            InviaDatiActivity.class);
                    startActivity(RecuperoDati);
                }
            }
        });

    }

    public void updatePersona ()
    {

        persona.setEmail("" + email.getText());
    }


    private boolean checkInput ()
    {
        int errors = 0;

        if (email.getText() == null || email.getText().length() == 0) {
            email.setError("Inserire l'email");
            errors++;
        } else
            email.setError(null);


        switch (errors) {
            case 0:
                errore.setVisibility(View.GONE);
                errore.setText("");
                break;
            case 1:
                errore.setVisibility(View.VISIBLE);
                errore.setText("Si è verificato un errore");
                break;
        }
        return errors == 0;
    }


}
