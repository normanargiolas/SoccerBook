package it.namron.soccerbook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import it.namron.soccerbook.R;
import it.namron.soccerbook.adapter.FieldItemAdapter;

public class FieldsActivity extends AppCompatActivity implements
        FieldItemAdapter.FieldItemAdapterListener {

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
                Toast.makeText(FieldsActivity.this, "You clicked on Cerca", Toast.LENGTH_LONG).show();

            }
        });
    }

    /**
     * This method is used to notify from onBindViewHolder that implement
     * FieldItemAdapterListener has clicked.
     */
    @Override
    public void onSelectedFieldClicked(int position) {

        if (mToast != null) {
            mToast.cancel();
        }
        String toastMessage = "Item #" + position + " clicked.";
        mToast = Toast.makeText(FieldsActivity.this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }

    /**
     * This method is used to notify from onBindViewHolder that implement
     * FieldItemAdapterListener has clicked.
     */
    @Override
    public void onInfoFieldClicked(int position) {

        if (mToast != null) {
            mToast.cancel();
        }
        String toastMessage = "Item #" + position + " clicked.";
        mToast = Toast.makeText(FieldsActivity.this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }

}
