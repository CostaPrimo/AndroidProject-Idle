package com.example.theidlegame;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmetn1 extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("fragment_exercise", "fragment1 onAttach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment_exercise", "fragment1 onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment_exercise", "fragment1 onStart");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragment_exercise", "fragment1 onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1,container,false);
        Log.i("fragment_exercise", "fragment1 onCreateView");
        return v;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("fragment_exercise", "fragment1 onDestroyView");
    }

    @Override
    public void onPause() {
        //DO NOTHING
        super.onPause();
        Log.i("fragment_exercise", "fragment1 onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("fragment_exercise", "fragment1 onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i("fragment_exercise", "fragment1 onViewStateRestored");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fragment_exercise", "ragment1 onActivityCreated");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment_exercise", "fragment1 onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment_exercise", "fragment1 onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment_exercise", "fragment1 onDestroy");
    }
}
