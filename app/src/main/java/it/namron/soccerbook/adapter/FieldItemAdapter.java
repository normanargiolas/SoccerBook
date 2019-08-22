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
import it.namron.soccerbook.dto.FieldItemDTO;

public class FieldItemAdapter extends RecyclerView.Adapter<FieldItemAdapter.FieldItemAdapterViewHolder> {

    private final Context mContext;
    private List<FieldItemDTO> mFieldItemDTO;

    private FieldItemAdapterListener listener;

    public interface FieldItemAdapterListener {
        void onSelectedFieldClicked(int position);
        void onInfoFieldClicked(int position);

    }

    public FieldItemAdapter(@NonNull Context context, @NonNull FieldItemAdapterListener listener, List<FieldItemDTO> directoryDTO) {
        this.listener = listener;
        mFieldItemDTO = directoryDTO;
        mContext = context;
    }

    @NonNull
    @Override
    public FieldItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        int layoutIdForListItem = R.layout.fild_list_item;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parentViewGroup, shouldAttachToParentImmediately);
        FieldItemAdapterViewHolder viewHolder = new FieldItemAdapterViewHolder(view);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull FieldItemAdapterViewHolder fieldItemAdapterViewHolder, int position) {

        FieldItemDTO fieldItem = mFieldItemDTO.get(position);

        fieldItemAdapterViewHolder.fieldName.setText(fieldItem.getName());
        fieldItemAdapterViewHolder.fieldAddress.setText(fieldItem.getAddress());

        ImageView drawerIcon = new ImageView(mContext);
        drawerIcon.setImageDrawable(fieldItem.getDrawerIcon());
        fieldItemAdapterViewHolder.fieldImageIcon.setImageDrawable(drawerIcon.getDrawable());

        applyClickEvents(fieldItemAdapterViewHolder, position);

    }

    private void applyClickEvents(FieldItemAdapterViewHolder holder, final int position) {
        holder.fieldBtnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSelectedFieldClicked(position);
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
        return 0;
    }


    public class FieldItemAdapterViewHolder extends RecyclerView.ViewHolder {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        final TextView fieldAddress;
        final TextView fieldName;
        final ImageView fieldImageIcon;

        final TextView fieldBtnSelect;
        final TextView fieldBtnInfo;


        public FieldItemAdapterViewHolder(View itemView) {
            super(itemView);

            fieldImageIcon = (ImageView) itemView.findViewById(R.id.field_image_icon);
            fieldAddress = (TextView) itemView.findViewById(R.id.field_address);
            fieldName = (TextView) itemView.findViewById(R.id.field_name);

            fieldBtnSelect = (TextView) itemView.findViewById(R.id.field_btn_select);
            fieldBtnInfo = (TextView) itemView.findViewById(R.id.field_btn_info);
        }


    }
}
