package	com.knowyourindia;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.devadvance.circularseekbar.CircularSeekBar;
import com.devadvance.circularseekbar.CircularSeekBar.OnCircularSeekBarChangeListener;

public class PartyFragment extends Fragment implements OnCircularSeekBarChangeListener {
	
	
	private String parties[] = {"AAP","AITC","BJP","BSP","DMK","INC","JDU","SP"};
	TextView t2;
	private static int k=(360/8);
	private int seekvalue;
	public PartyFragment(){}
	//ToolbarListener activityCallback;
	
	ToolbarListener activityCallback;
	
	public interface ToolbarListener {
        public void onButtonClick(String text);
	}
	
	@Override
	public void onAttach(Activity activity) {
	      super.onAttach(activity);
	      try {
	          activityCallback = (ToolbarListener) activity;
	      } catch (ClassCastException e) {
	          throw new ClassCastException(activity.toString()
	                  + " must implement ToolbarListener");
	      }
	}
	
    @Override
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    	View myFragmentView = inflater.inflate(R.layout.party_fragment, container, false);
    	final CircularSeekBar seekbar = (CircularSeekBar) myFragmentView.findViewById(R.id.circularSeekBar1);
    	t2= (TextView) myFragmentView.findViewById(R.id.textView1);
    	final Button button = (Button) myFragmentView.findViewById(R.id.button1);
	        button.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                buttonClicked(v);
	            }
	        });
    	
    	seekbar.setOnSeekBarChangeListener( this );
    	
        return myFragmentView;
        
    }
    
    public void buttonClicked (View view) {
    	activityCallback.onButtonClick(t2.getText().toString());
    	//Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
    	//startActivity(browserIntent);
	}
    

	@Override
	public void onProgressChanged(CircularSeekBar circularSeekBar,
			int progress, boolean fromUser) {
		 //TODO Auto-generated method stub
		 seekvalue = progress;
		 int q=0;
		 if ((seekvalue>0) && (seekvalue<360)){
			q= seekvalue/k;
			t2.setText(parties[q]);
		}
		
		
	}


	@Override
	public void onStopTrackingTouch(CircularSeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStartTrackingTouch(CircularSeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}