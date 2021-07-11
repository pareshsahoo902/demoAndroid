package com.release.androidbatch2.BottomSheetFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.release.androidbatch2.R;

public class ImagePickerSheet extends BottomSheetDialogFragment {

    TextView choose , camera, saved;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_1, container, false);

        choose = view.findViewById(R.id.choose);
        camera = view.findViewById(R.id.pick);
        saved = view.findViewById(R.id.saved);



        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Choose a Image now!", Toast.LENGTH_SHORT).show();
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Click a Image now!", Toast.LENGTH_SHORT).show();
            }
        });

        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Select a Image now!", Toast.LENGTH_SHORT).show();
            }
        });





        return view;


    }
}
