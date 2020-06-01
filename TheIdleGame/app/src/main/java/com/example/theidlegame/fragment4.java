package com.example.theidlegame;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment4 extends Fragment {

    private static final String TAG = "Fragment 4";
    CharSequence chsqn;

    private Button btn1fragment4;
    private Button btn2fragment4;
    private Button btn3fragment4;
    private Button btn4fragment4;

    private TextView grassValue;
    private TextView woodValue;
    private TextView waterValue;
    private TextView rockValue;
    private TextView copperValue;
    private TextView ironValue;
    private TextView diamondValue;
    private TextView titaniumValue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment4,container,false);
        btn1fragment4 = (Button) v.findViewById(R.id.btn1fragment4);
        btn2fragment4 = (Button) v.findViewById(R.id.btn2fragment4);
        btn3fragment4 = (Button) v.findViewById(R.id.btn3fragment4);
        btn4fragment4 = (Button) v.findViewById(R.id.btn4fragment4);

        grassValue = (TextView) v.findViewById(R.id.grassvalue);
        woodValue = (TextView) v.findViewById(R.id.woodvalue);
        waterValue = (TextView) v.findViewById(R.id.watervalue);
        rockValue = (TextView) v.findViewById(R.id.rockvalue);
        copperValue = (TextView) v.findViewById(R.id.coppervalue);
        ironValue = (TextView) v.findViewById(R.id.ironvalue);
        diamondValue = (TextView) v.findViewById(R.id.diamondvalue);
        titaniumValue = (TextView) v.findViewById(R.id.titaniumvalue);
        Log.i("fragment created", "fragment4 onCreateView");

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
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        btn3fragment4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(4);
            }
        });
        btn4fragment4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Nagivate to fragment
                ((MainActivity)getActivity()).setViewPager(6);
            }
        });
        return v;
    }

    @Override
    public void onPause() {
        Log.i("fragment paused", "fragment 4 paused");
        //TODO ADD SAVE TO DATABASE & TIME CHECK
        super.onPause();
    }

    @Override
    public void onResume() {
        //SetValuesCorrectly
        chsqn = ((MainActivity)getActivity()).accessData("grass");
        grassValue.setText(chsqn);
        chsqn = ((MainActivity)getActivity()).accessData("wood");
        woodValue.setText(chsqn);
        chsqn = ((MainActivity)getActivity()).accessData("water");
        waterValue.setText(chsqn);
        chsqn = ((MainActivity)getActivity()).accessData("rock");
        rockValue.setText(chsqn);
        chsqn = ((MainActivity)getActivity()).accessData("copper");
        copperValue.setText(chsqn);
        chsqn = ((MainActivity)getActivity()).accessData("iron");
        ironValue.setText(chsqn);
        chsqn = ((MainActivity)getActivity()).accessData("diamonds");
        diamondValue.setText(chsqn);
        chsqn = ((MainActivity)getActivity()).accessData("titanium");
        titaniumValue.setText(chsqn);
        super.onResume();
    }
}
