package com.example.theidlegame;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.theidlegame.database.AppDatabase;
import com.example.theidlegame.database.Mining;

public class fragment3 extends Fragment {

    private static final String TAG = "Fragment 3";

    protected AppDatabase db;
    protected Mining mining;

    private String returnText;
    private Button btn1fragment3;
    private Button btn2fragment3;
    private Button btn3fragment3;
    private Button btn4fragment3;

    private Button RockButton;
    private Button CopperButton;
    private Button IronButton;
    private Button DiamondButton;
    private Button TitaniumButton;

    private TextView RockLabel;
    private TextView CopperLabel;
    private TextView IronLabel;
    private TextView DiamondLabel;
    private TextView TitaniumLabel;

    private int rockCount = 0;
    private int copperCount = 0;
    private int ironCount = 0;
    private int diamondCount = 0;
    private int titaniumCount = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3,container,false);
        db = AppDatabase.getAppDatabase(getActivity());
        btn1fragment3 = (Button) v.findViewById(R.id.btn1fragment3);
        btn2fragment3 = (Button) v.findViewById(R.id.btn2fragment3);
        btn3fragment3 = (Button) v.findViewById(R.id.btn3fragment3);
        btn4fragment3 = (Button) v.findViewById(R.id.btn4fragment3);

        RockButton = (Button) v.findViewById(R.id.gatherrockbtn);
        CopperButton = (Button) v.findViewById(R.id.gathercopperbtn);
        IronButton = (Button) v.findViewById(R.id.gatherironbtn);
        DiamondButton = (Button) v.findViewById(R.id.gatherdiamondbtn);
        TitaniumButton = (Button) v.findViewById(R.id.gathertitaniumbtn);

        RockLabel = (TextView) v.findViewById(R.id.MineRockLabel);
        CopperLabel = (TextView) v.findViewById(R.id.MineCopperLabel);
        IronLabel = (TextView) v.findViewById(R.id.MineIronLabel);
        DiamondLabel = (TextView) v.findViewById(R.id.MineDiamondsLabel);
        TitaniumLabel = (TextView) v.findViewById(R.id.MineTitaniumLabel);

        btn1fragment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).passData("rock", RockLabel.getText());
                ((MainActivity)getActivity()).passData("copper", CopperLabel.getText());
                ((MainActivity)getActivity()).passData("iron", IronLabel.getText());
                ((MainActivity)getActivity()).passData("diamonds", DiamondLabel.getText());
                ((MainActivity)getActivity()).passData("titanium", TitaniumLabel.getText());
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });
        btn2fragment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).passData("rock", RockLabel.getText());
                ((MainActivity)getActivity()).passData("copper", CopperLabel.getText());
                ((MainActivity)getActivity()).passData("iron", IronLabel.getText());
                ((MainActivity)getActivity()).passData("diamonds", DiamondLabel.getText());
                ((MainActivity)getActivity()).passData("titanium", TitaniumLabel.getText());
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        btn3fragment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).passData("rock", RockLabel.getText());
                ((MainActivity)getActivity()).passData("copper", CopperLabel.getText());
                ((MainActivity)getActivity()).passData("iron", IronLabel.getText());
                ((MainActivity)getActivity()).passData("diamonds", DiamondLabel.getText());
                ((MainActivity)getActivity()).passData("titanium", TitaniumLabel.getText());
                ((MainActivity)getActivity()).setViewPager(4);
            }
        });
        btn4fragment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).passData("rock", RockLabel.getText());
                ((MainActivity)getActivity()).passData("copper", CopperLabel.getText());
                ((MainActivity)getActivity()).passData("iron", IronLabel.getText());
                ((MainActivity)getActivity()).passData("diamonds", DiamondLabel.getText());
                ((MainActivity)getActivity()).passData("titanium", TitaniumLabel.getText());
                ((MainActivity)getActivity()).setViewPager(6);
            }
        });

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (db.miningDAO().countMiners() == 0){
                    mining = new Mining();
                    mining.key1 = "1";
                    mining.stone = "0";
                    mining.copper = "0";
                    mining.iron = "0";
                    mining.diamond = "0";
                    mining.titanium = "0";
                    db.miningDAO().insert(mining);
                }
                else{
                    mining = db.miningDAO().getMiner();
                    rockCount = Integer.parseInt(mining.stone);
                    copperCount = Integer.parseInt(mining.copper);
                    ironCount = Integer.parseInt(mining.iron);
                    diamondCount = Integer.parseInt(mining.diamond);
                    titaniumCount = Integer.parseInt(mining.titanium);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // This code will always run on the UI thread, therefore is safe to modify UI elements.
                            RockLabel.setText(rockCount+"");
                            CopperLabel.setText(copperCount+"");
                            IronLabel.setText(ironCount+"");
                            DiamondLabel.setText(diamondCount+"");
                            TitaniumLabel.setText(titaniumCount+"");

                        }
                    });
                }
            }
        });


        RockButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                rockCount++;
                returnText = rockCount+"";
                RockLabel.setText(returnText);
                if(rockCount>=2 && !CopperButton.isClickable()){
                    CopperButton.setClickable(true);
                }
            }
        });
        CopperButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(rockCount>=2) {
                    copperCount++;
                    returnText = copperCount + "";
                    CopperLabel.setText(returnText);
                    rockCount-=2;
                    returnText = rockCount + "";
                    RockLabel.setText(returnText);
                }
                if(rockCount<2){
                    CopperButton.setClickable(false);
                }
                if(copperCount>=3 && !IronButton.isClickable()){
                    IronButton.setClickable(true);
                }
            }
        });
        IronButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(copperCount>=3) {
                    ironCount++;
                    returnText = ironCount + "";
                    IronLabel.setText(returnText);
                    copperCount-=3;
                    returnText = copperCount+"";
                    CopperLabel.setText(returnText);
                }
                if(copperCount<3 && !IronButton.isClickable()){
                    IronButton.setClickable(false);
                }
                if(ironCount>=4 && !DiamondButton.isClickable()){
                    DiamondButton.setClickable(true);
                }
            }
        });
        DiamondButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(ironCount>=4) {
                    diamondCount++;
                    returnText = diamondCount + "";
                    DiamondLabel.setText(returnText);
                    ironCount-=4;
                    returnText = ironCount+"";
                    IronLabel.setText(returnText);
                }
                if(ironCount<4){
                    DiamondButton.setClickable(false);
                }
                if(diamondCount>=5 && !TitaniumButton.isClickable()){
                    TitaniumButton.setClickable(true);
                }
            }
        });
        TitaniumButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(diamondCount>=5) {
                    titaniumCount++;
                    returnText = titaniumCount + "";
                    TitaniumLabel.setText(returnText);
                    diamondCount-=5;
                    returnText= diamondCount + "";
                    DiamondLabel.setText(returnText);
                }
                if(diamondCount<5){
                    TitaniumButton.setClickable(false);
                }
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        if(rockCount<2){
            CopperButton.setClickable(false);
        }
        if(copperCount<3){
            IronButton.setClickable(false);
        }
        if(ironCount<4){
            DiamondButton.setClickable(false);
        }
        if(diamondCount<5){
            TitaniumButton.setClickable(false);
        }
        returnText = rockCount+"";
        RockLabel.setText(returnText);
        returnText = copperCount+"";
        CopperLabel.setText(returnText);
        returnText = ironCount+"";
        IronLabel.setText(returnText);
        returnText = diamondCount+"";
        DiamondLabel.setText(returnText);
        returnText = titaniumCount+"";
        TitaniumLabel.setText(returnText);
        super.onResume();
    }

    @Override
    public void onStop() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String currentStone = RockLabel.getText().toString();
                String currentCopper = CopperLabel.getText().toString();
                String currentIron = IronLabel.getText().toString();
                String currentDiamond = DiamondLabel.getText().toString();
                String currentTitanium = TitaniumLabel.getText().toString();
                mining.stone = currentStone;
                mining.copper = currentCopper;
                mining.iron = currentIron;
                mining.diamond = currentDiamond;
                mining.titanium = currentTitanium;
                db.miningDAO().update(mining);
            }
        });
        super.onStop();
    }
}
