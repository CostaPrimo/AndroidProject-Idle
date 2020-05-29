package com.example.theidlegame;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment3 extends Fragment {

    private static final String TAG = "Fragment 3";

    private Button btn1fragment3;
    private Button btn2fragment3;
    private Button btn3fragment3;
    private Button btn4fragment3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3,container,false);
        btn1fragment3 = (Button) v.findViewById(R.id.btn1fragment3);
        btn2fragment3 = (Button) v.findViewById(R.id.btn2fragment3);
        btn3fragment3 = (Button) v.findViewById(R.id.btn3fragment3);
        btn4fragment3 = (Button) v.findViewById(R.id.btn4fragment3);
        Log.i("fragment created", "fragment1 onCreateView");

        btn1fragment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });
        btn2fragment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });
        btn3fragment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        btn4fragment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(3);
            }
        });

        return v;
    }
}
