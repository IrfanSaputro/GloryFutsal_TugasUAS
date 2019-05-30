package com.example.futsalglory;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ListFragment extends Fragment {
    private Button btnGoToActivity;
    private Button btnGoToActivity2;
//    private Button btnGoToActivity3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnGoToActivity = (Button) view.findViewById(R.id.btn_detail1);
        btnGoToActivity2 = (Button) view.findViewById(R.id.btn_detail2);
//        btnGoToActivity3 = (Button) view.findViewById(R.id.btn_detail3);

        btnGoToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailLapangan.class);
                getActivity().startActivity(intent);
            }
        });
        btnGoToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailLapangan2.class);
                getActivity().startActivity(intent);
            }
        });
//        btnGoToActivity3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), DetailLapangan3.class);
//                getActivity().startActivity(intent);
//            }
//        });
    }
}

