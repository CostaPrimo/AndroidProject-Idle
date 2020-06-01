package com.example.theidlegame;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.theidlegame.database.AppDatabase;
import com.example.theidlegame.database.Research;

public class fragment2 extends Fragment {

    private static final String TAG = "Fragment 2";

    protected AppDatabase db;
    protected Research research;

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

    private boolean isunlocked1 = false;
    private boolean isunlocked2 = false;
    private boolean isunlocked3 = false;
    private boolean isunlocked4 = false;
    private boolean isunlocked5 = false;
    private boolean isunlocked6 = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2,container,false);
        db = AppDatabase.getAppDatabase(getActivity());
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

        btn1fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).passData("upgrade1", isunlocked1+"");
                ((MainActivity)getActivity()).passData("upgrade2", isunlocked2+"");
                ((MainActivity)getActivity()).passData("upgrade3", isunlocked3+"");
                ((MainActivity)getActivity()).passData("upgrade4", isunlocked4+"");
                ((MainActivity)getActivity()).passData("upgrade5", isunlocked5+"");
                ((MainActivity)getActivity()).passData("upgrade6", isunlocked6+"");
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });
        btn2fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).passData("upgrade1", isunlocked1+"");
                ((MainActivity)getActivity()).passData("upgrade2", isunlocked2+"");
                ((MainActivity)getActivity()).passData("upgrade3", isunlocked3+"");
                ((MainActivity)getActivity()).passData("upgrade4", isunlocked4+"");
                ((MainActivity)getActivity()).passData("upgrade5", isunlocked5+"");
                ((MainActivity)getActivity()).passData("upgrade6", isunlocked6+"");
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        btn3fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).passData("upgrade1", isunlocked1+"");
                ((MainActivity)getActivity()).passData("upgrade2", isunlocked2+"");
                ((MainActivity)getActivity()).passData("upgrade3", isunlocked3+"");
                ((MainActivity)getActivity()).passData("upgrade4", isunlocked4+"");
                ((MainActivity)getActivity()).passData("upgrade5", isunlocked5+"");
                ((MainActivity)getActivity()).passData("upgrade6", isunlocked6+"");
                ((MainActivity)getActivity()).setViewPager(4);
            }
        });
        btn4fragment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).passData("upgrade1", isunlocked1+"");
                ((MainActivity)getActivity()).passData("upgrade2", isunlocked2+"");
                ((MainActivity)getActivity()).passData("upgrade3", isunlocked3+"");
                ((MainActivity)getActivity()).passData("upgrade4", isunlocked4+"");
                ((MainActivity)getActivity()).passData("upgrade5", isunlocked5+"");
                ((MainActivity)getActivity()).passData("upgrade6", isunlocked6+"");
                ((MainActivity)getActivity()).setViewPager(6);
            }
        });
        upgrade1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int currentgrassCount = Integer.parseInt(((MainActivity)getActivity()).accessData("grass").toString());
                if(currentgrassCount>=500 && !isunlocked1){
                    isunlocked1 = true;
                    upgrade1.setClickable(false);
                }
            }
        });
        upgrade2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int currentwoodCount = Integer.parseInt(((MainActivity)getActivity()).accessData("wood").toString());
                if(currentwoodCount>=500 && !isunlocked2){
                    isunlocked2 = true;
                    upgrade2.setClickable(false);
                }
            }
        });
        upgrade3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int currentwaterCount = Integer.parseInt(((MainActivity)getActivity()).accessData("water").toString());
                if(currentwaterCount>=500 && !isunlocked3){
                    isunlocked3 = true;
                    upgrade3.setClickable(false);
                }
            }
        });
        upgrade4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int currentrockCount = Integer.parseInt(((MainActivity)getActivity()).accessData("rock").toString());
                if(currentrockCount>=500 && !isunlocked4){
                    isunlocked4 = true;
                    upgrade4.setClickable(false);
                }
            }
        });
        upgrade5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int currentcopperCount = Integer.parseInt(((MainActivity)getActivity()).accessData("copper").toString());
                if(currentcopperCount>=500 && !isunlocked5){
                    isunlocked5 = true;
                    upgrade5.setClickable(false);
                }
            }
        });
        upgrade6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int currentironCount = Integer.parseInt(((MainActivity)getActivity()).accessData("iron").toString());
                if(currentironCount>=500 && !isunlocked6){
                    isunlocked6 = true;
                    upgrade6.setClickable(false);
                }
            }
        });

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (db.researchDAO().countResearch() == 0){
                    research = new Research();
                    research.key1 = "1";
                    research.research1 = "false";
                    research.research2 = "false";
                    research.research3 = "false";
                    research.research4 = "false";
                    research.research5 = "false";
                    research.research6 = "false";
                    db.researchDAO().insert(research);
                }
                else{
                    research = db.researchDAO().getResearcher();
                    isunlocked1 = research.research1.equalsIgnoreCase("true");
                    isunlocked2 = research.research2.equalsIgnoreCase("true");
                    isunlocked3 = research.research3.equalsIgnoreCase("true");
                    isunlocked4 = research.research4.equalsIgnoreCase("true");
                    isunlocked5 = research.research5.equalsIgnoreCase("true");
                    isunlocked6 = research.research6.equalsIgnoreCase("true");
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (isunlocked1) {
                                upgrade1.setClickable(false);
                            }
                            if (isunlocked2) {
                                upgrade2.setClickable(false);
                            }
                            if (isunlocked3) {
                                upgrade3.setClickable(false);
                            }
                            if (isunlocked4) {
                                upgrade4.setClickable(false);
                            }
                            if (isunlocked5) {
                                upgrade5.setClickable(false);
                            }
                            if (isunlocked6) {
                                upgrade6.setClickable(false);
                            }
                        }
                    });
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
                research.research1 = isunlocked1+"";
                research.research2 = isunlocked2+"";
                research.research3 = isunlocked3+"";
                research.research4 = isunlocked4+"";
                research.research5 = isunlocked5+"";
                research.research6 = isunlocked6+"";
                db.researchDAO().update(research);
            }
        });
        super.onStop();
    }
}
