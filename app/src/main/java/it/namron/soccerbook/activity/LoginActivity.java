package it.namron.soccerbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import it.namron.soccerbook.R;
import it.namron.soccerbook.extra.Persona;

import static it.namron.soccerbook.constant.Constant.PERSONA_EXTRA;


public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button accedi;
    TextView accesso, registrazione;

    Persona persona = new Persona();



    TextView errore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        accedi = (Button) findViewById(R.id.accedi);
        accesso = (TextView) findViewById(R.id.accesso);
        registrazione = (TextView) findViewById(R.id.registrazione);


        errore = (TextView) findViewById(R.id.errore);
        errore.setVisibility(View.GONE);

        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {
                    updatePersona();

                    Intent showResults = new Intent(LoginActivity.this,
                            ShowResultsActivity.class);
                    showResults.putExtra(PERSONA_EXTRA, persona);
                    startActivity(showResults);
                }
            }
        });

        accesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePersona();

                Intent RecuperoDati = new Intent(LoginActivity.this,
                        RecuperoDatiActivity.class);
                startActivity(RecuperoDati);
            }
        });

        registrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePersona();

                Intent Registrazione = new Intent(LoginActivity.this,
                        RegistrazioneActivity.class);
                startActivity(Registrazione);
            }
        });

    }

    public void updatePersona() {
        persona.setEmail("" + email.getText());
        persona.setPassword("" + password.getText());
    }

    private boolean checkInput() {
        int errors = 0;

        if (email.getText() == null || email.getText().length() == 0) {
            email.setError("Inserire l'email");
            errors++;
        } else
            email.setError(null);

        if (password.getText() == null || password.getText().length() == 0) {
            password.setError("Inserire la password");
            errors++;
        } else
            password.setError(null);


        switch (errors) {
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
                errore.setText("Si sono verificati " + errors + " errori");
                break;
        }
        return errors == 0;
    }
}
