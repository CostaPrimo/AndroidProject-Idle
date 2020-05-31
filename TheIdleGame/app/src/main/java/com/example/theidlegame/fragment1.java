package com.example.theidlegame;


import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.theidlegame.database.AppDatabase;
import com.example.theidlegame.database.Gathering;

public class fragment1 extends Fragment {

    private static final String TAG = "Fragment 1";
    protected AppDatabase db;
    protected Gathering gathering;
    private Button btn1fragment1;
    private Button btn2fragment1;
    private Button btn3fragment1;
    private Button btn4fragment1;
    private Button GatherGrass;
    private TextView GrassLabel;
    private TextView WoodLabel;
    private TextView WaterLabel;

    private int currentGrassCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1,container,false);
        db = AppDatabase.getAppDatabase(getActivity());
        btn1fragment1 = (Button) v.findViewById(R.id.btn1fragment1);
        btn2fragment1 = (Button) v.findViewById(R.id.btn2fragment1);
        btn3fragment1 = (Button) v.findViewById(R.id.btn3fragment1);
        btn4fragment1 = (Button) v.findViewById(R.id.btn4fragment1);
        GatherGrass = (Button) v.findViewById(R.id.gathergrassbtn);
        GrassLabel = (TextView) v.findViewById(R.id.GatherGrassLabel);
        WoodLabel = (TextView) v.findViewById(R.id.GatherWoodLabel);
        WaterLabel = (TextView) v.findViewById(R.id.CollectWaterLabel);
        Log.i("fragment created", "fragment1 onCreateView");

        btn1fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });
        btn2fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });
        btn3fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        btn4fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(3);
            }
        });
        GatherGrass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String currentText = GrassLabel.getText().toString();
                currentGrassCount = Integer.parseInt(currentText);
                currentGrassCount++;
                String returnText = currentGrassCount+"";
                GrassLabel.setText(returnText);
            }
        });
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (db.gatheringDAO().counGathers() == 0){
                    gathering = new Gathering();
                    gathering.key1 = "1";
                    gathering.grass = "0";
                    gathering.water = "0";
                    gathering.wood = "0";
                    db.gatheringDAO().insert(gathering);
                }
                else{
                    gathering = db.gatheringDAO().getGatherer();
                    GrassLabel.setText(gathering.grass);
                    WaterLabel.setText(gathering.water);
                    WoodLabel.setText(gathering.wood);
                }
            }
        });

        return v;
    }

    @Override
    public void onPause() {
        Log.i("fragment paused", "fragment 1 paused");
        super.onPause();
    }

    @Override
    public void onResume() {
        String returnText = currentGrassCount+"";
        GrassLabel.setText(returnText);
        super.onResume();
    }

    @Override
    public void onStop() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String currentGrass = GrassLabel.getText().toString();
                String currentWater = WaterLabel.getText().toString();
                String currentWood = WoodLabel.getText().toString();
                gathering.grass = currentGrass;
                gathering.wood = currentWood;
                gathering.water = currentWater;
                db.gatheringDAO().update(gathering);
            }
        });
        super.onStop();
    }
}
