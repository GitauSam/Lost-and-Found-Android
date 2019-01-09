package com.zoatech.lostandfound.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoatech.lostandfound.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    //private Context context;
    private ArrayList<DocumentDetailsModel> detailsModels;

    RecyclerViewAdapter( ArrayList<DocumentDetailsModel> detailsModels) {
        //this.context = context;
        this.detailsModels = detailsModels;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView document_type, document_no, document_status;

        private MyViewHolder(View itemView) {
            super(itemView);

            document_type = itemView.findViewById(R.id.text_view_document_type);
            document_no = itemView.findViewById(R.id.text_view_document_number);
            document_status = itemView.findViewById(R.id.text_view_document_status);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doument_details_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        DocumentDetailsModel model = detailsModels.get(position);

        holder.document_type.setText(model.getType());
        holder.document_no.setText(String.valueOf(model.getId_number()));
        holder.document_status.setText(model.getStatus());

    }

    @Override
    public int getItemCount() {
        return detailsModels.size();
    }
}
