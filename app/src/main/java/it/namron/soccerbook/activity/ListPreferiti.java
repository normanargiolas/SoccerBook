package it.namron.soccerbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import it.namron.soccerbook.R;

import static it.namron.soccerbook.constant.Constant.WELCOME_USER_REQUEST;

public class ListPreferiti extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listacampi);


        String[] USERS = new String[]{"Ossigeno", "San Francesco", "Seminario", "Su Planu", "Girotondo", "San Siro", "Monte Poni", "Sardegna Arena", "Sant'Elia", "Amsicora", "San Paolo", "Meazza"};

        ListView usersList = (ListView) findViewById(R.id.listview_users);

        final ArrayAdapter<String> userArrayAdapter = new ArrayAdapter<>(this, R.layout.user_view, USERS);
        usersList.setAdapter(userArrayAdapter);

        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showNuovaSquadraActivity();
            }
        });
    }


    private Intent makeNuovaSquadraIntent() {
        Class destinationActivity = InformazioniPreferiti.class;
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
