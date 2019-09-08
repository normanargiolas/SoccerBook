package it.namron.soccerbook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import it.namron.soccerbook.R;
import it.namron.soccerbook.dto.TeamItemDTO;

public class TeamItemAdapter extends RecyclerView.Adapter<TeamItemAdapter.TeamItemAdapterViewHolder> {

    private final Context mContext;
    private List<TeamItemDTO> mTeamListItemDTO;
    private TeamItemAdapterListener listener;

    public void populateFields(List<TeamItemDTO> mTeamListItemDTO) {
        this.mTeamListItemDTO = mTeamListItemDTO;
        notifyDataSetChanged();
    }

    public interface TeamItemAdapterListener {
        void onSelectedFieldClicked(int position);
    }

    public TeamItemAdapter(@NonNull Context context, List<TeamItemDTO> teamDTO, @NonNull TeamItemAdapterListener listener) {
        this.listener = listener;
        mTeamListItemDTO = teamDTO;
        mContext = context;
    }


    @NonNull
    @Override
    public TeamItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parentViewGroup, int i) {
        int layoutIdForListItem = R.layout.team_list_item;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parentViewGroup, shouldAttachToParentImmediately);
        TeamItemAdapterViewHolder viewHolder = new TeamItemAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamItemAdapterViewHolder teamItemAdapterViewHolder, int position) {
        TeamItemDTO teamItem = mTeamListItemDTO.get(position);

        teamItemAdapterViewHolder.teamName.setText(teamItem.getTeamName());
        teamItemAdapterViewHolder.teamInfo.setText(teamItem.getTeamInfo());

        ImageView drawerIcon = new ImageView(mContext);
        drawerIcon.setImageDrawable(teamItem.getDrawerIcon());
        teamItemAdapterViewHolder.teamImageIcon.setImageDrawable(drawerIcon.getDrawable());

//        applyClickEvents(teamItemAdapterViewHolder, position);
    }

    @Override
    public int getItemCount() {
        if (null == mTeamListItemDTO) return 0;
        return mTeamListItemDTO.size();
    }


    public class TeamItemAdapterViewHolder extends RecyclerView.ViewHolder {

        final TextView teamInfo;
        final TextView teamName;
        final ImageView teamImageIcon;

        public TeamItemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            teamImageIcon = (ImageView) itemView.findViewById(R.id.team_icon);
            teamInfo = (TextView) itemView.findViewById(R.id.team_info);
            teamName = (TextView) itemView.findViewById(R.id.team_name);
        }

    }


}
