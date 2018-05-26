package ru.lenarlenar.vkmessenger.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.lenarlenar.vkmessenger.R;
import ru.lenarlenar.vkmessenger.model.DialogHeader;

/**
 * Created by zvezdy.lord on 26.05.18.
 */

public class DialogsAdapter extends RecyclerView.Adapter<DialogsAdapter.ViewHolder> {

    private List<DialogHeader> dialogHeaders;
    void setItems(List<DialogHeader> dialogHeaders){
        this.dialogHeaders = dialogHeaders;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DialogsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialogheader, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogsAdapter.ViewHolder holder, int position) {
        DialogHeader header = dialogHeaders.get(position);
        holder.dialogHeader.setText(header.getMessage().getBody());
    }

    @Override
    public int getItemCount() {
        return dialogHeaders != null ? dialogHeaders.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textView_dialogHeader)
        TextView dialogHeader;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
