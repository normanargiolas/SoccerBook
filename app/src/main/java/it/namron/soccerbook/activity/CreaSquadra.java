package it.namron.soccerbook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import it.namron.soccerbook.R;

import android.content.Intent;
import android.view.View;

import static it.namron.soccerbook.constant.Constant.WELCOME_USER_REQUEST;

public class CreaSquadra extends AppCompatActivity {


    private Button buttonID;
    private Button buttonVicinanze;
    private Button buttonContatti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creasquadra);

        buttonID = (Button) findViewById(R.id.button1);
        buttonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(CreaSquadra.this, "You clicked on ID", Toast.LENGTH_LONG).show();
                showSquadraActivity();
            }
        });

        buttonVicinanze = (Button) findViewById(R.id.button2);
        buttonVicinanze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(CreaSquadra.this, "You clicked on Vicinanze", Toast.LENGTH_LONG).show();
                showNuovaSquadraActivity();

            }
        });



    }
    private Intent makeSquadraIntent() {
        Class destinationActivity = FieldActivityElenco.class;
        Intent a = new Intent(getApplicationContext(), destinationActivity);
        return a;
    }

    private void showSquadraActivity() {
        try {
            Intent appInfoIntent = makeSquadraIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Intent makeNuovaSquadraIntent() {
        Class destinationActivity = CreaNuovaSquadra.class;
        Intent a = new Intent(getApplicationContext(), destinationActivity);
        return a;
    }

    private void showNuovaSquadraActivity() {
        try {
            Intent appInfoIntent = makeNuovaSquadraIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


