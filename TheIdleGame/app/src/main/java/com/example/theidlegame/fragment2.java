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

public class fragment2 extends Fragment {

    private static final String TAG = "Fragment 2";

    private Button btn1fragment2;
    private Button btn2fragment2;
    private Button btn3fragment2;
    private Button btn4fragment2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2,container,false);
        btn1fragment2 = (Button) v.findViewById(R.id.btn1fragment2);
        btn2fragment2 = (Button) v.findViewById(R.id.btn2fragment2);
        btn3fragment2 = (Button) v.findViewById(R.id.btn3fragment2);
        btn4fragment2 = (Button) v.findViewById(R.id.btn4fragment2);
        Log.i("fragment created", "fragment1 onCreateView");

        btn1fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });
        btn2fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });
        btn3fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        btn4fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(3);
            }
        });

        return v;
    }
}
