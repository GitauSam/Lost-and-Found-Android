package com.zoatech.lostandfound.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zoatech.lostandfound.R;

import java.util.ArrayList;

public class LostnFoundFragment extends Fragment {

    private RecyclerView documentDetailsRecyclerview;

    private RelativeLayout relativeLayoutFoundDialog;

    ImageView imageViewFoundDialogCancel;

    private boolean FOUND;

    public LostnFoundFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lost_n_found, container, false);
        documentDetailsRecyclerview = view.findViewById(R.id.recycler_view_lostnfound);
        relativeLayoutFoundDialog = view.findViewById(R.id.relative_layout_found_dialog);
        imageViewFoundDialogCancel = view.findViewById(R.id.image_view_found_dialog_cancel);
        imageViewFoundDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayoutFoundDialog.setVisibility(View.GONE);
            }
        });
        FloatingActionButton floatingActionButtonReport = view.findViewById(R.id.fab_report);
        floatingActionButtonReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ReportActivity.class));
            }
        });
        showDialog();
        documentDetailsRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        documentDetailsRecyclerview.setHasFixedSize(true);

        setupRecyclerview();
        return view;
    }

    private void setupRecyclerview() {
        ArrayList<DocumentDetailsModel> detailsModels = new ArrayList<>();
        detailsModels.add(new DocumentDetailsModel(123456, "Passport", "Lost"));
        detailsModels.add(new DocumentDetailsModel(524656, "ID Card", "Lost"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(detailsModels);
        documentDetailsRecyclerview.setAdapter(adapter);
    }

    private void showDialog () {
        FOUND = true;
        if (!FOUND) {
            relativeLayoutFoundDialog.setVisibility(View.INVISIBLE);
        }
    }
}
