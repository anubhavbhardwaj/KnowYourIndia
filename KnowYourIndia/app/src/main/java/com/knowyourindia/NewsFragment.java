package com.knowyourindia;

import com.devadvance.circularseekbar.CircularSeekBar;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsFragment extends Fragment {
	
	public NewsFragment(){}
@Override
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View myFragmentView = inflater.inflate(R.layout.news_fragment, container, false);
    	
        return myFragmentView;
        
    }
    
    
}