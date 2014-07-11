package hu.ait.android.travelingsalesman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		Button btnStartGame = (Button) findViewById(R.id.btnStartGame);
		btnStartGame.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClass(HomeActivity.this, GameActivity.class);
				startActivity(i);
			}
		});
		
		Button btnPractice = (Button) findViewById(R.id.btnPractice);
		btnPractice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent();
				i.setClass(HomeActivity.this, EnterPointsActivity.class);
				startActivity(i);
			}
		});
		
		Button btnTutorial = (Button) findViewById(R.id.btnTutorial);
		btnTutorial.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.setClass(HomeActivity.this, TutorialActivity.class);
				startActivity(i);
			}
		});

	}
}
