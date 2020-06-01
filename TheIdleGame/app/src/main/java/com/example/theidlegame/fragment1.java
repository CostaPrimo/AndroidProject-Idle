package com.example.theidlegame;

import android.os.AsyncTask;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.theidlegame.database.AppDatabase;
import com.example.theidlegame.database.Gathering;

public class fragment1 extends Fragment {

    private static final String TAG = "Fragment 1";

    protected AppDatabase db;
    protected Gathering gathering;

    private String returnText;

    private Button btn1fragment1;
    private Button btn2fragment1;
    private Button btn3fragment1;
    private Button btn4fragment1;

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
        db = AppDatabase.getAppDatabase(getActivity());
        btn1fragment1 = (Button) v.findViewById(R.id.btn1fragment1);
        btn2fragment1 = (Button) v.findViewById(R.id.btn2fragment1);
        btn3fragment1 = (Button) v.findViewById(R.id.btn3fragment1);
        btn4fragment1 = (Button) v.findViewById(R.id.btn4fragment1);

        CollectGrass = (Button) v.findViewById(R.id.collectgrassbtn);
        CollectWood = (Button) v.findViewById(R.id.gatherwoodbtn);
        CollectWater = (Button) v.findViewById(R.id.collectwaterbtn);

        BuyZebra = (Button) v.findViewById(R.id.zebrabutton);

        GrassLabel = (TextView) v.findViewById(R.id.GatherGrassLabel);
        WoodLabel = (TextView) v.findViewById(R.id.GatherWoodLabel);
        WaterLabel = (TextView) v.findViewById(R.id.CollectWaterLabel);

        btn1fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).passData("grass", GrassLabel.getText());
                ((MainActivity)getActivity()).passData("wood", WoodLabel.getText());
                ((MainActivity)getActivity()).passData("water", WaterLabel.getText());
                ((MainActivity)getActivity()).setViewPager(0);

            }
        });
        btn2fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).passData("grass", GrassLabel.getText());
                ((MainActivity)getActivity()).passData("wood", WoodLabel.getText());
                ((MainActivity)getActivity()).passData("water", WaterLabel.getText());
                ((MainActivity)getActivity()).setViewPager(2);

            }
        });
        btn3fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).passData("grass", GrassLabel.getText());
                ((MainActivity)getActivity()).passData("wood", WoodLabel.getText());
                ((MainActivity)getActivity()).passData("water", WaterLabel.getText());
                ((MainActivity)getActivity()).setViewPager(4);

            }
        });
        btn4fragment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).passData("grass", GrassLabel.getText());
                ((MainActivity)getActivity()).passData("wood", WoodLabel.getText());
                ((MainActivity)getActivity()).passData("water", WaterLabel.getText());
                ((MainActivity)getActivity()).setViewPager(6);

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
                    currentGrassCount = Integer.parseInt(gathering.grass);
                    currentWoodCount = Integer.parseInt(gathering.wood);
                    currentWaterCount = Integer.parseInt(gathering.water);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(currentGrassCount<10){
                                CollectWood.setClickable(false);
                            }
                            if(currentWoodCount<5){
                                CollectWater.setClickable(false);
                            }
                            int tempcount = Integer.parseInt(((MainActivity)getActivity()).accessData("titanium").toString());
                            if(tempcount<1000){
                                BuyZebra.setClickable(false);
                                BuyZebra.setBackgroundColor(Color.parseColor("#f1f1f1"));
                            }
                            else {
                                BuyZebra.setBackgroundColor(Color.parseColor("#aa0000"));
                            }
                            returnText = currentGrassCount+"";
                            GrassLabel.setText(returnText);
                            returnText = currentWoodCount+"";
                            WoodLabel.setText(returnText);
                            returnText = currentWaterCount+"";
                            WaterLabel.setText(returnText);
                        }
                    });
                }
            }
        });

        CollectGrass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                currentGrassCount++;
                if(((MainActivity)getActivity()).accessData("upgrade1").toString().equalsIgnoreCase("true")){
                    currentGrassCount+=4;
                }
                returnText = currentGrassCount+"";
                GrassLabel.setText(returnText);
                if(currentGrassCount>=10 && !CollectWood.isClickable()){
                    CollectWood.setClickable(true);
                }
            }
        });
        CollectWood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (currentGrassCount >= 10) {
                    currentWoodCount++;
                    if(((MainActivity)getActivity()).accessData("upgrade2").toString().equalsIgnoreCase("true")){
                        currentWoodCount+=2;
                    }
                    currentGrassCount-=10;
                    returnText = currentWoodCount + "";
                    WoodLabel.setText(returnText);
                    returnText = currentGrassCount+"";
                    GrassLabel.setText(returnText);
                }
                if (currentGrassCount<10){
                    CollectWood.setClickable(false);
                }
                if(currentWoodCount>=5 && !CollectWater.isClickable()){
                    CollectWater.setClickable(true);
                }
            }
        });
        CollectWater.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(currentWoodCount>=5) {
                    currentWaterCount++;
                    returnText = currentWaterCount + "";
                    WaterLabel.setText(returnText);
                    currentWoodCount-=5;
                    returnText = currentWoodCount+"";
                    WoodLabel.setText(returnText);
                }
                if(currentWoodCount<5){
                    CollectWater.setClickable(false);
                }
            }
        });
        BuyZebra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //If the planets are aligned...
                returnText = "You Bought a Zebra";
                BuyZebra.setText(returnText);
                int tempint = Integer.parseInt(((MainActivity)getActivity()).accessData("titanium").toString());
                tempint-=1000;
                returnText = tempint+"";
                ((MainActivity)getActivity()).passData("titanium", returnText);
            }
        });
        return v;
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
