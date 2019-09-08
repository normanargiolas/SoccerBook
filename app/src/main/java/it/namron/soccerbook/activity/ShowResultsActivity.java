package it.namron.soccerbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

import it.namron.soccerbook.R;
import it.namron.soccerbook.extra.Persona;

import static it.namron.soccerbook.constant.Constant.LOGIN_EXTRA;
import static it.namron.soccerbook.constant.Constant.PERSONA_EXTRA;

public class ShowResultsActivity extends AppCompatActivity {

    Persona persona;
    TextView email;
    Button indietro;
    TextView accesso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(
                PERSONA_EXTRA
        );

        if (obj instanceof Persona) {
            persona = (Persona) obj;
        } else {
            persona = new Persona();
        }

        email = (TextView) findViewById(R.id.email);
        indietro = (Button) findViewById(R.id.indietro);
        accesso = (TextView) findViewById(R.id.accesso);

        email.setText("Benvenuto " + persona.getEmail());

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent showResults = new Intent(ShowResultsActivity.this,
                        MainActivity.class);
                showResults.putExtra(LOGIN_EXTRA, true);
                startActivity(showResults);
            }
        });
    }


}
