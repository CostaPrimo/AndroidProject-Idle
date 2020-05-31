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

import org.w3c.dom.Text;

public class fragment3 extends Fragment {

    private static final String TAG = "Fragment 3";
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

        Log.i("fragment created", "fragment3 onCreateView");

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
        RockButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                rockCount++;
                returnText = rockCount+"";
                RockLabel.setText(returnText);
            }
        });
        CopperButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                copperCount++;
                returnText = copperCount+"";
                CopperLabel.setText(returnText);
            }
        });
        IronButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                ironCount++;
                returnText = ironCount+"";
                IronLabel.setText(returnText);
            }
        });
        DiamondButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                diamondCount++;
                returnText = diamondCount+"";
                DiamondLabel.setText(returnText);
            }
        });
        TitaniumButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO
                titaniumCount++;
                returnText = titaniumCount+"";
                TitaniumLabel.setText(returnText);
            }
        });
        return v;
    }

    @Override
    public void onPause() {
        Log.i("fragment paused", "fragment 3 paused");
        //TODO ADD SAVE TO DATABASE & TIME CHECK
        super.onPause();
    }

    @Override
    public void onResume() {
        //SetValuesCorrectly
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
}
