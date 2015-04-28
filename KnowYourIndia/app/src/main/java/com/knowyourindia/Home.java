package com.knowyourindia;



import swipescreen.SimpleGestureFilter;
import swipescreen.SimpleGestureFilter.SimpleGestureListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MotionEvent;
//import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class Home extends Activity implements SimpleGestureListener , PartyFragment.ToolbarListener{
            private SimpleGestureFilter detector;
            private int v;
            private int h;
        @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_home);
                v=0;
                h=0;
                Fragment fragment= new HomeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
          			.replace(R.id.frame_container, fragment).commit();
                // Detect touched area 
                detector = new SimpleGestureFilter(this,this);
        }
          
    @Override
    public boolean dispatchTouchEvent(MotionEvent me){
        // Call onTouchEvent of SimpleGestureFilter class
         this.detector.onTouchEvent(me);
       return super.dispatchTouchEvent(me);
    }
    
    @Override
    public void onSwipe(int direction) {
      Fragment fragment = null;
      FragmentManager fragmentManager = getFragmentManager();       
      switch (direction) {
      case SimpleGestureFilter.SWIPE_DOWN :  //str = "Swipe Down";
      											if ((v<1) && (h==0))
      										   	v++;
      										   	break;
      case SimpleGestureFilter.SWIPE_UP :    //str = "Swipe Up";
      											if ((v>-1) && (h==0))
      											v--;
                                                break;
      case SimpleGestureFilter.SWIPE_RIGHT : //str = "Swipe Right";
      											if ((h>-1) && (v==0))
                                                h--;
      											break;
      case SimpleGestureFilter.SWIPE_LEFT :  //str = "Swipe Left";
      											if ((h<1) && (v==0))
                                                h++;
      											break;
      }
      //final TextView textViewToChange = (TextView) findViewById(R.id.textView1);
      	//textViewToChange.setText(str);
      if ((v==0) && (h==0)){
    	
    	  fragment= new HomeFragment();
      }
      else if ((v==1) && (h==0)){
    	  fragment= new NewsFragment();
      }
      else if ((v==0) && (h==-1)){
    	  fragment= new PartyFragment();
      }
      else if ((v==0) && (h==1)){
    	  fragment= new StumbleFragment();
      }
      else if ((v==-1) && (h==0)){
    	  fragment= new CandidateFragment();
      }
      if (fragment != null) {

    	  fragmentManager.beginTransaction()
				.replace(R.id.frame_container, fragment).commit();
      }
      
      
      
     }
      
     @Override
     public void onDoubleTap() {
        Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
     }
     @Override
     public void onButtonClick(String text) {
    		Fragment fragment=null;
    		FragmentManager fragmentManager = getFragmentManager();
    		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    		if (text=="AAP")
    			fragment= new AAPFragment();
    		else if (text=="AITC")
    			fragment= new AITCFragment();
    		else if (text=="BJP")
    			fragment= new BJPFragment();
    		else if (text=="BSP")
    			fragment= new BSPFragment();
    		else if (text=="DMK")
    			fragment= new DMKFragment();
    		else if (text=="INC")
    			fragment= new INCFragment();
    		else if (text=="JDU")
    			fragment= new JDUFragment();
    		else if (text=="SP")
        		fragment= new SPFragment();
    		if (fragment!= null)
    		{
            fragmentManager.beginTransaction()
      			.replace(R.id.frame_container, fragment).commit();
    		}
    	}
     
  }