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


public class RegistrazioneActivity extends AppCompatActivity {

    Persona persona;
    EditText email, password, rpassword;
    Button registrati;
    TextView errore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione);

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
        password = (EditText) findViewById(R.id.password);
        rpassword = (EditText) findViewById(R.id.rpassword);
        registrati = (Button) findViewById(R.id.registrati);


        errore = (TextView) findViewById(R.id.errore);
        errore.setVisibility(View.GONE);


        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {
                    updatePersona();
                    Intent Registrazione = new Intent(RegistrazioneActivity.this,
                            RegistratiActivity.class);
                    startActivity(Registrazione);
                }
            }
        });

    }

    public void updatePersona()
    {
        persona.setEmail(""+email.getText());
        persona.setPassword(""+password.getText());
        persona.setPassword(""+rpassword.getText());
    }


    private boolean checkInput()
    {
        int errors = 0;


        if(email.getText()==null || email.getText().length()==0) {
            email.setError("Inserire l'email");
            errors++;
        }
        else
            email.setError(null);

        if(password.getText()==null || password.getText().length()==0) {
            password.setError("Inserire la password");
            errors++;
        }
        else
            password.setError(null);

        if(rpassword.getText()==null || rpassword.getText().length()==0) {
            rpassword.setError("Inserire la password");
            errors++;
        }
        else if (password.getText().toString().equals(rpassword.getText().toString())) {
            rpassword.setError(null);
        }
        else {
            rpassword.setError("Le password inserite non sono uguali");
            errors++;
        }



        switch (errors){
            case 0:
                errore.setVisibility(View.GONE);
                errore.setText("");
                break;
            case 1:
                errore.setVisibility(View.VISIBLE);
                errore.setText("Si è verificato un errore");
                break;
            default:
                errore.setVisibility(View.VISIBLE);
                errore.setText("Si sono verificati " + errors+" errori" );
                break;
        }
        return errors==0;
    }


}
