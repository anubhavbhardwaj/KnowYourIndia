package com.knowyourindia;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

public class HomeFragment extends Fragment {
	
	public HomeFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	return inflater.inflate(R.layout.home_fragment, container, false);
        
    }
	public static HomeFragment newInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}