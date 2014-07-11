package hu.ait.android.travelingsalesman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TutorialActivity extends Activity {

	ImageView fingerPoint1;
	TutorialDraw tutorialView;
	Button next1, btnTutHome, btnBack;
	TextView tvTutorial1, tvTutorial4;
	Animation swipe1, swipe2, swipe3, swipe4, hold, tut3s1, tut3s2, tut3s3, tut3s4, tut3hold;
	boolean start;
	AnimationListener tut1swipe1, tut1swipe2, tut2swipe1, tut2swipe2, tut2swipe3, tut3swipe1,
	tut3swipe2, tut3swipe3, tut3swipe4, tut3swipe5;
	View.OnClickListener click1, click2, click3, backClick1, backClick2, backClick3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		
		start = true;
		tutorialView = (TutorialDraw) findViewById(R.id.tutorialView);
		swipe1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.swipe_bottom_right);
		swipe2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.swipe_top_left);
		swipe3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.swipe_top_right);
		swipe4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.swipe4);
		tut3s1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tut3swipe1);
		tut3s2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tut3swipe2);
		tut3s3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tut3swipe3);
		tut3s4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tut3swipe4);
		tut3hold = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tut3hold);
		hold = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.hold_still);
		fingerPoint1 = (ImageView) findViewById(R.id.pointFinger1);
		next1 = (Button) findViewById(R.id.btnNext1);
		btnTutHome = (Button) findViewById(R.id.btnTutHome);
		btnBack = (Button) findViewById(R.id.btnBack);
		tvTutorial1 = (TextView) findViewById(R.id.tvTutorial1);
		tvTutorial4 = (TextView) findViewById(R.id.tvTut4);
		swipe1.setFillEnabled(true);
		swipe1.setFillAfter(true);
		swipe2.setFillEnabled(true);
		swipe2.setFillAfter(true);
		swipe3.setFillEnabled(true);
		swipe3.setFillAfter(true);
		swipe4.setFillEnabled(true);
		swipe4.setFillAfter(true);
		hold.setFillEnabled(true);
		hold.setFillAfter(true);
		tut3s1.setFillEnabled(true);
		tut3s1.setFillAfter(true);
		tut3s2.setFillEnabled(true);
		tut3s2.setFillAfter(true);
		tut3s3.setFillEnabled(true);
		tut3s3.setFillAfter(true);
		tut3s4.setFillEnabled(true);
		tut3s4.setFillAfter(true);
		tut3hold.setFillEnabled(true);
		tut3hold.setFillAfter(true);
		
		tut1swipe1 = new AnimationListener() {
			
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				if (!start) {
					tutorialView.invalidate();
				} else {
					start = false;
				}
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(swipe2);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		};
		tut1swipe2 = new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				tutorialView.invalidate();
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(swipe1);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		};
		tut2swipe1 = new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				tutorialView.invalidate();
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(swipe4);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

		};
		tut2swipe2 = new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				tutorialView.invalidate();
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(hold);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
	
		};
		tut2swipe3 = new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				tutorialView.invalidate();
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(swipe3);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

		};
		tut3swipe1 = new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				tutorialView.invalidate();
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(tut3s2);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		};
		tut3swipe2 = new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				tutorialView.invalidate();
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(tut3s3);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		};
		tut3swipe3 = new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				tutorialView.invalidate();
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(tut3s4);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		};
		tut3swipe4 = new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				tutorialView.invalidate();
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(tut3hold);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		};
		tut3swipe5 = new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				tutorialView.invalidate();
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				fingerPoint1.startAnimation(tut3s1);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
		};
		
		btnTutHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClass(TutorialActivity.this, HomeActivity.class);
				finish();
				startActivity(i);
			}
		});
		
		backClick1 = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClass(TutorialActivity.this, HomeActivity.class);
				finish();
				startActivity(i);
			}
		};
		
		click3 = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				prepTut4();
			}
		};
		
		click2 = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				prepTut3();
			}
		};
		
		backClick3 = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				prepTut2();
			}
		};
		
		click1 = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				prepTut2();
			}
		};
		
		backClick2 = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				prepTut1();
			}
		};
		
		prepTut1();
	}
	
	private void prepTut1() {
		swipe1.setAnimationListener(tut1swipe1);
		swipe2.setAnimationListener(tut1swipe2);
		swipe3.setAnimationListener(null);
		swipe4.setAnimationListener(null);
		hold.setAnimationListener(null);
		fingerPoint1.clearAnimation();
		tvTutorial1.setText("Swipe from one point to another to connect. Swipe again to disconnect.");
		tutorialView.beginTut1();
		next1.setOnClickListener(click1);
		btnBack.setOnClickListener(backClick1);
		fingerPoint1.startAnimation(swipe1);
	}
	
	private void prepTut2() {
		swipe1.setAnimationListener(null);
		swipe2.setAnimationListener(null);
		swipe3.setAnimationListener(tut2swipe1);
		swipe4.setAnimationListener(tut2swipe2);
		hold.setAnimationListener(tut2swipe3);
		tut3s1.setAnimationListener(null);
		tut3s2.setAnimationListener(null);
		tut3s3.setAnimationListener(null);
		tut3s4.setAnimationListener(null);
		tut3hold.setAnimationListener(null);
		fingerPoint1.clearAnimation();
		tvTutorial1.setText("Each point needs exactly two connections.");
		tutorialView.beginTut2();
		next1.setOnClickListener(click2);
		btnBack.setOnClickListener(backClick2);
		fingerPoint1.startAnimation(swipe3);
	}
	
	private void prepTut3() {
		swipe3.setAnimationListener(null);
		swipe4.setAnimationListener(null);
		hold.setAnimationListener(null);
		tut3s1.setAnimationListener(tut3swipe1);
		tut3s2.setAnimationListener(tut3swipe2);
		tut3s3.setAnimationListener(tut3swipe3);
		tut3s4.setAnimationListener(tut3swipe4);
		tut3hold.setAnimationListener(tut3swipe5);
		fingerPoint1.clearAnimation();
		fingerPoint1.setVisibility(0);
		tvTutorial1.setVisibility(0);
		next1.setVisibility(0);
		btnTutHome.setVisibility(8);
		tvTutorial4.setVisibility(8);
		tvTutorial1.setText("Find the shortest cycle to connect all the points to advance to next level.");
		tutorialView.beginTut3();
		next1.setOnClickListener(click3);
		btnBack.setOnClickListener(backClick3);
		fingerPoint1.startAnimation(tut3s1);
	}
	
	private void prepTut4() {
		tut3s1.setAnimationListener(null);
		tut3s2.setAnimationListener(null);
		tut3s3.setAnimationListener(null);
		tut3s4.setAnimationListener(null);
		tut3hold.setAnimationListener(null);
		fingerPoint1.clearAnimation();
		fingerPoint1.setVisibility(8);
		tvTutorial1.setVisibility(8);
		next1.setVisibility(8);
		tutorialView.beginTut4();
		btnBack.setVisibility(8);
		btnTutHome.setVisibility(0);
		tvTutorial4.setVisibility(0);
	}
	
}


