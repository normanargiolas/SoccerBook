package it.namron.soccerbook.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import it.namron.soccerbook.R;

public class FieldsActivity extends AppCompatActivity {

    private ImageView mCercaComune;
    private ImageView mCercaNome;
    private ImageView mCercaDistanza;

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
            }
        });
    }

}
