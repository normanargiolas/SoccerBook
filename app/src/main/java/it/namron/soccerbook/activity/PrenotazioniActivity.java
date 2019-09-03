package it.namron.soccerbook.activity;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import it.namron.soccerbook.R;
import it.namron.soccerbook.adapter.PrenotazioneItemAdapter;
import it.namron.soccerbook.dto.PrenotazioneItemDTO;

public class PrenotazioniActivity extends AppCompatActivity implements  PrenotazioneItemAdapter.PrenotazioneItemAdapterListener{

    private Toast mToast;

    private RecyclerView mRecyclerView;
    private PrenotazioneItemAdapter mPrenotazioneItemAdapter;
    private List<PrenotazioneItemDTO> mPrenotazioneIListDTO = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_prenotazioni);

        mRecyclerView = (RecyclerView) findViewById(R.id.app_list_fields_booked_recycler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        //The AppItemAdapter is responsible for displaying each item in the list.
        mPrenotazioneItemAdapter = new PrenotazioneItemAdapter(this, mPrenotazioneIListDTO, this);
        mRecyclerView.setAdapter(mPrenotazioneItemAdapter);


        //Ottiene la lista dei campi
        prepareListOfPrenotazioni();
        mPrenotazioneItemAdapter.populateFields(mPrenotazioneIListDTO);
    }

    private void prepareListOfPrenotazioni() {
        mPrenotazioneIListDTO.clear();
        PrenotazioneItemDTO fieldItem;

        fieldItem = new PrenotazioneItemDTO();
        fieldItem.setName("Campo Prenotato 1");
        fieldItem.setAddress("Address Campo Prenotato 1");
        fieldItem.setData("Data: 13 Agosto 2019");
        fieldItem.setHour("Ora : 18.30");
        fieldItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.campo1));

        mPrenotazioneIListDTO.add(fieldItem);

        fieldItem = new PrenotazioneItemDTO();
        fieldItem.setName("Campo Prenotato 2");
        fieldItem.setAddress("Address Campo Prenotato 2");
        fieldItem.setData("Data: 14 Agosto 2019");
        fieldItem.setHour("Ora : 19.30");
        fieldItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.campo1));
        mPrenotazioneIListDTO.add(fieldItem);

        fieldItem = new PrenotazioneItemDTO();
        fieldItem.setName("Campo Prenotato 3");
        fieldItem.setAddress("Address Campo Prenotato 3");
        fieldItem.setData("Data: 15 Agosto 2019");
        fieldItem.setHour("Ora : 20.30");
        fieldItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.campo1));
        mPrenotazioneIListDTO.add(fieldItem);
    }

    @Override
    public void onSelectedFieldClicked(int position) {
        if (mToast != null) {
            mToast.cancel();
        }
        String toastMessage = "Item #" + position + " clicked.";
        mToast = Toast.makeText(PrenotazioniActivity.this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }

    @Override
    public void onInfoFieldClicked(int position) {
        if (mToast != null) {
            mToast.cancel();
        }
        String toastMessage = "Item #" + position + " clicked.";
        mToast = Toast.makeText(PrenotazioniActivity.this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }
}
