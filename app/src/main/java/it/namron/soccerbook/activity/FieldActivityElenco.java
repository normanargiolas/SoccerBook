package it.namron.soccerbook.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import it.namron.soccerbook.R;
import it.namron.soccerbook.adapter.FieldItemAdapter;
import it.namron.soccerbook.dto.FieldItemDTO;

import static it.namron.soccerbook.constant.Constant.WELCOME_USER_REQUEST;

public class FieldActivityElenco extends AppCompatActivity implements FieldItemAdapter.FieldItemAdapterListener {

    private Toast mToast;

    private RecyclerView mRecyclerView;
    private FieldItemAdapter mFieldItemAdapter;
    private List<FieldItemDTO> mFieldIListDTO = new ArrayList<>();


    private void prepareListOffields() {

        mFieldIListDTO.clear();
        FieldItemDTO fieldItem;

        fieldItem = new FieldItemDTO();
        fieldItem.setName("Squadra1");
        fieldItem.setAddress("Componenti squadra 1");
        fieldItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.campo1));

        mFieldIListDTO.add(fieldItem);

        fieldItem = new FieldItemDTO();
        fieldItem.setName("Squadra 2");
        fieldItem.setAddress("Address Campo 2");
        fieldItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.campo1));
        mFieldIListDTO.add(fieldItem);

        fieldItem = new FieldItemDTO();
        fieldItem.setName("Squadra 3");
        fieldItem.setAddress("Address Campo 3");
        fieldItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.campo1));
        mFieldIListDTO.add(fieldItem);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        mRecyclerView = (RecyclerView) findViewById(R.id.app_list_fields_recycler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        //The AppItemAdapter is responsible for displaying each item in the list.
        mFieldItemAdapter = new FieldItemAdapter(this, mFieldIListDTO, this);
        mRecyclerView.setAdapter(mFieldItemAdapter);


        //Ottiene la lista dei campi
        prepareListOffields();
        mFieldItemAdapter.populateFields(mFieldIListDTO);
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
        String toastMessage = "Item #" + position + " clicked FieldActivityElenco.";
        mToast = Toast.makeText(FieldActivityElenco.this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }

    /**
     * This method is used to notify from onBindViewHolder that implement
     * FieldItemAdapterListener has clicked.
     */
    @Override
    public void onInfoFieldClicked(int position) {

        showInformazioniAtivity();
    }


    private Intent makeInformazioniIntent() {
        Class informazioniCampoActivity = InformazioniCampoActivity.class;
        Intent intent = new Intent(getApplicationContext(), informazioniCampoActivity);
        return intent;
    }

    private void showInformazioniAtivity() {
        try {
            Intent appInfoIntent = makeInformazioniIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
