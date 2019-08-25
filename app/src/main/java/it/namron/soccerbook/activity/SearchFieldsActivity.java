package it.namron.soccerbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import it.namron.soccerbook.R;

import static it.namron.soccerbook.constant.Constant.WELCOME_USER_REQUEST;

public class SearchFieldsActivity extends AppCompatActivity {

    private ImageView mCercaComune;
    private ImageView mCercaNome;
    private ImageView mCercaDistanza;

    private Toast mToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_layout);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mCercaNome = (ImageView) findViewById(R.id.lente_nome_image_view);
        mCercaComune = (ImageView) findViewById(R.id.lente_comune_image_view);
        mCercaDistanza = (ImageView) findViewById(R.id.lente_distanza_image_view);


        mCercaNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result", "Tutto ok");
//                setResult(Activity.RESULT_OK, returnIntent);
//                finish();
//                Toast.makeText(SearchFieldsActivity.this, "You clicked on Cerca Per Nome", Toast.LENGTH_LONG).show();
                showFieldsActivity();
            }
        });

        mCercaComune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result", "Tutto ok");
//                setResult(Activity.RESULT_OK, returnIntent);
//                finish();
                Toast.makeText(SearchFieldsActivity.this, "You clicked on Cerca Per Comune", Toast.LENGTH_LONG).show();

            }
        });

        mCercaDistanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result", "Tutto ok");
//                setResult(Activity.RESULT_OK, returnIntent);
//                finish();
                Toast.makeText(SearchFieldsActivity.this, "You clicked on Cerca Per Distanza", Toast.LENGTH_LONG).show();

            }
        });
    }

    private Intent makeFieldsIntent() {
        Class destinationActivity = FieldsActivity.class;
        Intent intent = new Intent(getApplicationContext(), destinationActivity);
        return intent;
    }

    private void showFieldsActivity() {
        try {
            Intent appInfoIntent = makeFieldsIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
