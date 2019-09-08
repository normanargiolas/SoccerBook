package it.namron.soccerbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import it.namron.soccerbook.R;

import static it.namron.soccerbook.constant.Constant.LOGIN_EXTRA;
import static it.namron.soccerbook.constant.Constant.WELCOME_USER_REQUEST;


public class MainActivity extends AppCompatActivity {

    boolean LOGIN = false;

    private TextView mTextMessage;
    private ImageView prenotazioniImg;
    private ImageView palloneImg;
    private ImageView magliaImg;
    private ImageView campoImg;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    showProfiloActivity();
                    return true;
                case R.id.prenotazioni:
                    showPrenotazioniAtivity();
                    return true;
                case R.id.campo_id:
                    showSearchFieldsActivity();
                    return true;
                case R.id.maglia_id:
                    showSquadraActivity();
                    return true;
                case R.id.profilo:
                    showProfiloActivity();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        checkLogin();


        prenotazioniImg = (ImageView) findViewById(R.id.home_id);
        prenotazioniImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "You clicked on Home", Toast.LENGTH_LONG).show();
                if (LOGIN) {
                    showPrenotazioniAtivity();
                } else {
                    showLoginAtivity();
                }
            }
        });

        campoImg = (ImageView) findViewById(R.id.campo_id);
        campoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "You clicked on Campo", Toast.LENGTH_LONG).show();
                if (LOGIN) {
                    showSearchFieldsActivity();
                } else {
                    showLoginAtivity();
                }
            }
        });

        palloneImg = (ImageView) findViewById(R.id.pallone_id);
        palloneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "You clicked on Pallone", Toast.LENGTH_LONG).show();
                if (LOGIN) {
                    showPreferitiActivity();
                } else {
                    showLoginAtivity();
                }
            }
        });

        magliaImg = (ImageView) findViewById(R.id.maglia_id);
        magliaImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "You clicked on Maglia", Toast.LENGTH_LONG).show();
                if (LOGIN) {
                    showSquadraActivity();
                } else {
                    showLoginAtivity();
                }
            }
        });


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void checkLogin() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            LOGIN = bundle.getBoolean(LOGIN_EXTRA);
        }
    }

    private Intent makeFieldsIntent() {
        Class destinationActivity = SearchFieldsActivity.class;
        Intent intent = new Intent(getApplicationContext(), destinationActivity);
        return intent;
    }

    private Intent makePrenotazioniIntent() {
        Class prenotazioniActivity = PrenotazioniActivity.class;
        Intent intent = new Intent(getApplicationContext(), prenotazioniActivity);
        return intent;
    }

    private void showPrenotazioniAtivity() {
        try {
            Intent appInfoIntent = makePrenotazioniIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSearchFieldsActivity() {
        try {
            Intent appInfoIntent = makeFieldsIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Intent makeLoginIntent() {
        Class destinationActivity = LoginActivity.class;
        Intent a = new Intent(getApplicationContext(), destinationActivity);
        return a;
    }

    private void showLoginAtivity() {
        try {
            Intent appInfoIntent = makeLoginIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Intent makeSquadraIntent() {
        Class destinationActivity = CreaSquadra.class;
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

    private Intent makeProfiloIntent() {
        Class destinationActivity = ProfileClass.class;
        Intent a = new Intent(getApplicationContext(), destinationActivity);
        return a;
    }

    private void showProfiloActivity() {
        try {
            Intent appInfoIntent = makeProfiloIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Intent makePreferitiIntent() {
        Class destinationActivity = ListPreferiti.class;
        Intent intent = new Intent(getApplicationContext(), destinationActivity);
        return intent;
    }

    private void showPreferitiActivity() {
        try {
            Intent appInfoIntent = makePreferitiIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
