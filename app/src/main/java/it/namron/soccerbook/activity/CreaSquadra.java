package it.namron.soccerbook.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import it.namron.soccerbook.R;
import it.namron.soccerbook.adapter.FieldItemAdapter;
import it.namron.soccerbook.dto.FieldItemDTO;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
                Toast.makeText(CreaSquadra.this, "You clicked on Vicinanze", Toast.LENGTH_LONG).show();

            }
        });


        buttonContatti = (Button) findViewById(R.id.button3);
        buttonContatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreaSquadra.this, "You clicked on Contatti", Toast.LENGTH_LONG).show();

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

}


