package com.example.theidlegame;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment1 extends Fragment {

    private static final String TAG = "Fragment 1";
    private String returnText;

    private Button btn1fragment1;
    private Button btn2fragment1;
    private Button btn3fragment1;
    private Button btn4fragment1;

    private Button GatherGrass;
    private Button CollectGrass;
    private Button CollectWood;
    private Button CollectWater;

    private Button BuyZebra;

    private TextView GrassLabel;
    private TextView WoodLabel;
    private TextView WaterLabel;

    private int currentGrassCount = 0;
    private int currentWoodCount = 0;
    private int currentWaterCount = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1,container,false);
        btn1fragment1 = (Button) v.findViewById(R.id.btn1fragment1);
        btn2fragment1 = (Button) v.findViewById(R.id.btn2fragment1);
        btn3fragment1 = (Button) v.findViewById(R.id.btn3fragment1);
        btn4fragment1 = (Button) v.findViewById(R.id.btn4fragment1);

        GatherGrass = (Button) v.findViewById(R.id.gathergrassbtn);
        CollectGrass = (Button) v.findViewById(R.id.collectgrassbtn);
        CollectWood = (Button) v.findViewById(R.id.gatherwoodbtn);
        CollectWater = (Button) v.findViewById(R.id.collectwaterbtn);

        BuyZebra = (Button) v.findViewById(R.id.zebrabutton);

        GrassLabel = (TextView) v.findViewById(R.id.GatherGrassLabel);
        WoodLabel = (TextView) v.findViewById(R.id.GatherWoodLabel);
        WaterLabel = (TextView) v.findViewById(R.id.CollectWaterLabel);
        Log.i("fragment created", "fragment1 onCreateView");

        btn1fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).passData("grass", GrassLabel.getText());
                ((MainActivity)getActivity()).setViewPager(0);

            }
        });
        btn2fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).passData("grass", GrassLabel.getText());
                ((MainActivity)getActivity()).setViewPager(1);

            }
        });
        btn3fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).passData("grass", GrassLabel.getText());
                ((MainActivity)getActivity()).setViewPager(2);

            }
        });
        btn4fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).passData("grass", GrassLabel.getText());
                ((MainActivity)getActivity()).setViewPager(3);

            }
        });
        GatherGrass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO FIX THIS TO WORK RIGHT
                currentGrassCount++;
                returnText = currentGrassCount+"";
                GrassLabel.setText(returnText);
            }
        });
        CollectGrass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                //IF Grass > x... do
                currentGrassCount++;
                returnText = currentGrassCount+"";
                GrassLabel.setText(returnText);
            }
        });
        CollectWood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                //If Grass > y... do
                currentWoodCount++;
                returnText = currentWoodCount+"";
                WoodLabel.setText(returnText);
            }
        });
        CollectWater.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                //If wood > z... do
                currentWaterCount++;
                returnText = currentWaterCount+"";
                WaterLabel.setText(returnText);
            }
        });
        BuyZebra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                //If the planets are aligned...
                returnText = "You Bought a Zebra";
                BuyZebra.setText(returnText);
            }
        });
        return v;
    }

    @Override
    public void onPause() {
        Log.i("fragment paused", "fragment 1 paused");
        //TODO ADD SAVE TO DATABASE & TIME CHECK
        super.onPause();
    }

    @Override
    public void onResume() {
        //SetValuesCorrectly
        returnText = currentGrassCount+"";
        GrassLabel.setText(returnText);
        returnText = currentWoodCount+"";
        WoodLabel.setText(returnText);
        returnText = currentWaterCount+"";
        WaterLabel.setText(returnText);
        super.onResume();
    }
}
