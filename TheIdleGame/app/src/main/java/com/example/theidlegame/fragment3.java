package com.example.theidlegame;

import android.content.Context;
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

import com.example.theidlegame.database.AppDatabase;
import com.example.theidlegame.database.Mining;

public class fragment3 extends Fragment {

    private static final String TAG = "Fragment 3";
    protected AppDatabase db;
    protected Mining mining;
    private Button btn1fragment3;
    private Button btn2fragment3;
    private Button btn3fragment3;
    private Button btn4fragment3;
    private TextView MineRockLabel;
    private TextView MineCopperLabel;
    private TextView MineIronLabel;
    private TextView MineDiamondsLabel;
    private TextView MineTitaniumLabel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3,container,false);
        btn1fragment3 = (Button) v.findViewById(R.id.btn1fragment3);
        btn2fragment3 = (Button) v.findViewById(R.id.btn2fragment3);
        btn3fragment3 = (Button) v.findViewById(R.id.btn3fragment3);
        btn4fragment3 = (Button) v.findViewById(R.id.btn4fragment3);
        MineRockLabel = (TextView) v.findViewById(R.id.MineRockLabel);
        MineCopperLabel = (TextView) v.findViewById(R.id.MineCopperLabel);
        MineIronLabel = (TextView) v.findViewById(R.id.MineIronLabel);
        MineDiamondsLabel = (TextView) v.findViewById(R.id.MineDiamondsLabel);
        MineTitaniumLabel = (TextView) v.findViewById(R.id.MineTitaniumLabel);
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

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (db.gatheringDAO().counGathers() == 0){
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
                    MineRockLabel.setText(mining.stone);
                    MineCopperLabel.setText(mining.copper);
                    MineIronLabel.setText(mining.iron);
                    MineDiamondsLabel.setText(mining.diamond);
                    MineTitaniumLabel.setText((mining.titanium));
                }
            }
        });

        return v;
    }


    @Override
    public void onStop() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String currentStone = MineRockLabel.getText().toString();
                String currentCopper = MineCopperLabel.getText().toString();
                String currentIron = MineIronLabel.getText().toString();
                String currentDiamond = MineDiamondsLabel.getText().toString();
                String currentTitanium = MineTitaniumLabel.getText().toString();
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
