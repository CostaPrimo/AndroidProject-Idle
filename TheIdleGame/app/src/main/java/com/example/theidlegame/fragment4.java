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

public class fragment4 extends Fragment {

    private static final String TAG = "Fragment 4";

    private Button btn1fragment4;
    private Button btn2fragment4;
    private Button btn3fragment4;
    private Button btn4fragment4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment4,container,false);
        btn1fragment4 = (Button) v.findViewById(R.id.btn1fragment4);
        btn2fragment4 = (Button) v.findViewById(R.id.btn2fragment4);
        btn3fragment4 = (Button) v.findViewById(R.id.btn3fragment4);
        btn4fragment4 = (Button) v.findViewById(R.id.btn4fragment4);
        Log.i("fragment created", "fragment1 onCreateView");

        btn1fragment4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });
        btn2fragment4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });
        btn3fragment4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        btn4fragment4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(3);
            }
        });

        return v;
    }
}
