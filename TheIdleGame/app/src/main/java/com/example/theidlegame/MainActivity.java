package com.example.theidlegame;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;


public class MainActivity extends AppCompatActivity {

    private StatePagerAdapter  statePagerAdapter;
    private ViewPager viewPager;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statePagerAdapter = new StatePagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.mainpage);
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewpager){
        StatePagerAdapter adapter = new StatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment1(), "Fragment 1");
        adapter.addFragment(new Fragment(), "Dummy1");
        adapter.addFragment(new fragment2(), "Fragment 2");
        adapter.addFragment(new Fragment(), "Dummy2");
        adapter.addFragment(new fragment3(), "Fragment 3");
        adapter.addFragment(new Fragment(), "Dummy3");
        adapter.addFragment(new fragment4(), "Fragment 4");
        viewpager.setAdapter(adapter);
    }

    public void resetBundle(){
        bundle = new Bundle();
    }

    public void passData(String key, CharSequence value){
        if(bundle==null){
            resetBundle();
            bundle.putCharSequence(key, value);
        }
        else{
            bundle.putCharSequence(key, value);
        }
    }

    public CharSequence accessData(String key){
        if(bundle==null){
            return "0";
        }
        else {
            if (bundle.containsKey(key)) {
                return bundle.getCharSequence(key);
            }
            else{
                return "0";
            }
        }
    }

    public void setViewPager(int index){
        viewPager.setCurrentItem(index);
    }

}