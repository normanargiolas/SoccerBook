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
import it.namron.soccerbook.dto.PrenotazioneItemDTO;

public class PrenotazioneItemAdapter extends RecyclerView.Adapter<PrenotazioneItemAdapter.PrenotazioneItemAdapterViewHolder> {


    private final Context mContext;
    private List<PrenotazioneItemDTO> mPrenotazioneItemDTO;

    private PrenotazioneItemAdapter.PrenotazioneItemAdapterListener listener;

    public void populateFields(List<PrenotazioneItemDTO> mPrenotazioneIListDTO) {
        this.mPrenotazioneItemDTO = mPrenotazioneIListDTO;
        notifyDataSetChanged();
    }

    public interface PrenotazioneItemAdapterListener {
        void onCancelFieldClicked(int position);
        void onInfoFieldClicked(int position);
    }

    public PrenotazioneItemAdapter(@NonNull Context context, List<PrenotazioneItemDTO> fieldDTO, @NonNull PrenotazioneItemAdapter.PrenotazioneItemAdapterListener listener) {
        this.listener = listener;
        mPrenotazioneItemDTO = fieldDTO;
        mContext = context;
    }

    @NonNull
    @Override
    public PrenotazioneItemAdapter.PrenotazioneItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        int layoutIdForListItem = R.layout.prenotazione_list_item;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parentViewGroup, shouldAttachToParentImmediately);
        PrenotazioneItemAdapter.PrenotazioneItemAdapterViewHolder viewHolder = new PrenotazioneItemAdapter.PrenotazioneItemAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PrenotazioneItemAdapter.PrenotazioneItemAdapterViewHolder fieldItemAdapterViewHolder, int position) {

        PrenotazioneItemDTO fieldItem = mPrenotazioneItemDTO.get(position);

        fieldItemAdapterViewHolder.fieldName.setText(fieldItem.getName());
        fieldItemAdapterViewHolder.fieldAddress.setText(fieldItem.getAddress());

        fieldItemAdapterViewHolder.fieldData.setText(fieldItem.getData());
        fieldItemAdapterViewHolder.fieldHour.setText(fieldItem.getHour());

        ImageView drawerIcon = new ImageView(mContext);
        drawerIcon.setImageDrawable(fieldItem.getDrawerIcon());
        fieldItemAdapterViewHolder.fieldImageIcon.setImageDrawable(drawerIcon.getDrawable());

        applyClickEvents(fieldItemAdapterViewHolder, position);

    }

    private void applyClickEvents(PrenotazioneItemAdapter.PrenotazioneItemAdapterViewHolder holder, final int position) {
        holder.fieldBtnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCancelFieldClicked(position);
            }
        });

        holder.fieldBtnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onInfoFieldClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (null == mPrenotazioneItemDTO) return 0;
        return mPrenotazioneItemDTO.size();
    }


    public class PrenotazioneItemAdapterViewHolder extends RecyclerView.ViewHolder {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        final TextView fieldAddress;
        final TextView fieldName;
        final TextView fieldData;
        final TextView fieldHour;
        final ImageView fieldImageIcon;

        final TextView fieldBtnSelect;
        final TextView fieldBtnInfo;


        public PrenotazioneItemAdapterViewHolder(View itemView) {
            super(itemView);

            fieldImageIcon = (ImageView) itemView.findViewById(R.id.field_image_icon);
            fieldAddress = (TextView) itemView.findViewById(R.id.field_address);
            fieldName = (TextView) itemView.findViewById(R.id.field_name);

            fieldData = (TextView) itemView.findViewById(R.id.field_date);
            fieldHour = (TextView) itemView.findViewById(R.id.field_hour);

            fieldBtnSelect = (TextView) itemView.findViewById(R.id.field_btn_cancella);
            fieldBtnInfo = (TextView) itemView.findViewById(R.id.field_btn_info);
        }


    }

}
