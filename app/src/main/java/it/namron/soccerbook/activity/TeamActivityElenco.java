package it.namron.soccerbook.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import it.namron.soccerbook.R;
import it.namron.soccerbook.adapter.TeamItemAdapter;
import it.namron.soccerbook.dto.TeamItemDTO;

import static it.namron.soccerbook.constant.Constant.WELCOME_USER_REQUEST;

public class TeamActivityElenco extends AppCompatActivity implements TeamItemAdapter.TeamItemAdapterListener {

    private RecyclerView mRecyclerView;
    private TeamItemAdapter mTeamItemAdapter;
    private List<TeamItemDTO> mTeamIListDTO = new ArrayList<>();

    private FloatingActionButton mTeamSelected;


    @Override
    public void onSelectedFieldClicked(int position) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_search);

        mRecyclerView = (RecyclerView) findViewById(R.id.app_list_team_recycler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        //The AppItemAdapter is responsible for displaying each item in the list.
        mTeamItemAdapter = new TeamItemAdapter(this, mTeamIListDTO, this);
        mRecyclerView.setAdapter(mTeamItemAdapter);

        mTeamSelected = (FloatingActionButton) findViewById(R.id.team_selected);
        mTeamSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                showPrenotazioneAtivity();


            }
        });


        //Ottiene la lista dei campi
        prepareListOfTeam();
        mTeamItemAdapter.populateFields(mTeamIListDTO);
    }


    private Intent makePrenotazioneIntent() {
        Class informazioniCampoActivity = InformazioniPrenotazioni.class;
        Intent intent = new Intent(getApplicationContext(), informazioniCampoActivity);
        return intent;
    }

    private void showPrenotazioneAtivity() {
        try {
            Intent appInfoIntent = makePrenotazioneIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareListOfTeam() {
        mTeamIListDTO.clear();
        TeamItemDTO teamItem;

        teamItem = new TeamItemDTO();
        teamItem.setTeamName("Squadra 1");
        teamItem.setTeamInfo("Informazioni squadra 1");
        teamItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.maglia));
        mTeamIListDTO.add(teamItem);

        teamItem = new TeamItemDTO();
        teamItem.setTeamName("Squadra 2");
        teamItem.setTeamInfo("Informazioni squadra 2");
        teamItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.maglia));
        mTeamIListDTO.add(teamItem);

        teamItem = new TeamItemDTO();
        teamItem.setTeamName("Squadra 3");
        teamItem.setTeamInfo("Informazioni squadra 3");
        teamItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.maglia));
        mTeamIListDTO.add(teamItem);

        teamItem = new TeamItemDTO();
        teamItem.setTeamName("Squadra 4");
        teamItem.setTeamInfo("Informazioni squadra 4");
        teamItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.maglia));
        mTeamIListDTO.add(teamItem);

        teamItem = new TeamItemDTO();
        teamItem.setTeamName("Squadra 5");
        teamItem.setTeamInfo("Informazioni squadra 5");
        teamItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.maglia));
        mTeamIListDTO.add(teamItem);

        teamItem = new TeamItemDTO();
        teamItem.setTeamName("Squadra 6");
        teamItem.setTeamInfo("Informazioni squadra 6");
        teamItem.setDrawerIcon(ContextCompat.getDrawable(this, R.drawable.maglia));
        mTeamIListDTO.add(teamItem);

    }
}
