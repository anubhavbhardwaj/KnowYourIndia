package com.knowyourindia;

import com.knowyourindia.PartyFragment.ToolbarListener;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class StumbleFragment extends Fragment {
	
	private String facts[] = {"My name is Vikram Singh","AITC","BJP","BSP","DMK","INC","JDU","SP"};
	TextView t2;
    Button addFact;
	int randomInt=0,prevInt=0;
	public StumbleFragment(){}
	
	ToolbarListener activityCallback;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View myFragmentView = inflater.inflate(R.layout.stumble_fragment, container, false);
    	t2= (TextView) myFragmentView.findViewById(R.id.textView2);
        addFact = (Button)myFragmentView.findViewById(R.id.button);

        addFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity(), AddFact.class);
                getActivity().startActivity(intent2);
            }
        });

    	final Button button = (Button) myFragmentView.findViewById(R.id.button1);
    	button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Random randomGenerator = new Random();
            	while (randomInt==prevInt)
            	{randomInt = randomGenerator.nextInt(facts.length);}
            	prevInt= randomInt;
            	t2.setText(facts[randomInt]);
            }
        });
        return myFragmentView;
    }
}