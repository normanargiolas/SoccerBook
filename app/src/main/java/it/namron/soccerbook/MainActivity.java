package it.namron.soccerbook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView homeImg;
    private ImageView palloneImg;
    private ImageView magliaImg;
    private ImageView campoImg;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    mTextMessage.setText("Home");
                    return true;
                case R.id.cerca_campo:
                    mTextMessage.setText("Cerca campo");
                    return true;
                case R.id.cerca_squadra:
                    mTextMessage.setText("Cerca squadra");
                    return true;
                case R.id.profilo:
                    mTextMessage.setText("Profilo");
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

        homeImg = (ImageView)findViewById(R.id.home_id);
        homeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked on Home", Toast.LENGTH_LONG).show();

            }
        });

        campoImg = (ImageView)findViewById(R.id.campo_id);
        campoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked on Campo", Toast.LENGTH_LONG).show();

            }
        });

        palloneImg = (ImageView)findViewById(R.id.pallone_id);
        palloneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked on Pallone", Toast.LENGTH_LONG).show();

            }
        });

        magliaImg = (ImageView)findViewById(R.id.maglia_id);
        magliaImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked on Maglia", Toast.LENGTH_LONG).show();

            }
        });


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




    }

}
