package com.sigma.temitest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentFirst extends Fragment {

    private MainActivity mainActivity = (MainActivity) getActivity();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){
            mainActivity = (MainActivity) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_1p, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Button homepage = (Button) getView().findViewById(R.id.homepage_btn);
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Web.class);
                intent.putExtra("url", "https://ee.snu.ac.kr/");
                intent.putExtra("language", true);
                startActivity(intent);
            }
        });

        final Button building = (Button) getView().findViewById(R.id.building_btn);
        building.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Web.class);
                intent.putExtra("url", "https://ee.snu.ac.kr/about/contact#tel");
                intent.putExtra("language", true);
                startActivity(intent);
            }
        });

        final Button map = (Button) getView().findViewById(R.id.map_btn);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Web.class);
                intent.putExtra("url", "http://map.snu.ac.kr/web/main.action");
                intent.putExtra("language", true);
                startActivity(intent);
            }
        });

    }

}