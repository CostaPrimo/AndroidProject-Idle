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

    private Button upgrade1;
    private Button upgrade2;
    private Button upgrade3;
    private Button upgrade4;
    private Button upgrade5;
    private Button upgrade6;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2,container,false);
        btn1fragment2 = (Button) v.findViewById(R.id.btn1fragment2);
        btn2fragment2 = (Button) v.findViewById(R.id.btn2fragment2);
        btn3fragment2 = (Button) v.findViewById(R.id.btn3fragment2);
        btn4fragment2 = (Button) v.findViewById(R.id.btn4fragment2);
        upgrade1 = (Button) v.findViewById(R.id.upgrade1);
        upgrade2 = (Button) v.findViewById(R.id.upgrade2);
        upgrade3 = (Button) v.findViewById(R.id.upgrade3);
        upgrade4 = (Button) v.findViewById(R.id.upgrade4);
        upgrade5 = (Button) v.findViewById(R.id.upgrade5);
        upgrade6 = (Button) v.findViewById(R.id.upgrade6);
        Log.i("fragment created", "fragment2 onCreateView");

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
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        btn3fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(4);
            }
        });
        btn4fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(6);
            }
        });
        upgrade1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
        upgrade2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
        upgrade3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
        upgrade4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
        upgrade5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
        upgrade6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        return v;
    }
    @Override
    public void onPause() {
        Log.i("fragment paused", "fragment 2 paused");
        //TODO ADD SAVE TO DATABASE & TIME CHECK
        super.onPause();
    }

    @Override
    public void onResume() {
        //SetValuesCorrectly
        super.onResume();
    }
}
