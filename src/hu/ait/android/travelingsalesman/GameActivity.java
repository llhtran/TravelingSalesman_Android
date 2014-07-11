package hu.ait.android.travelingsalesman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	public int nPoints;
	Button btnDone;
	TextView tvTimer, tvLevel;
	public int level;
	
	// 9 levels from 1 - 6
	public int[] timeCount = new int[7];
	private CountDownTimer Timer;
	
	SalesmanGameView salesGameView;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.game_menu, menu);
		
		
		return super.onCreateOptionsMenu(menu);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == R.id.btnGameHome) {
			Intent i = new Intent();
			i.setClass(this, HomeActivity.class);
			finish();
			startActivity(i);
		} else if (item.getItemId() == R.id.btnStartOver) {
			Timer.cancel();
			salesGameView.nPoints = 4;
			btnDone.setEnabled(true);
			salesGameView.newGame();
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		timeCount[0] = 0;
		timeCount[1] = 20; // 4 points
		timeCount[2] = 15; // 5 points
		timeCount[3] = 15; // 6 points
		timeCount[4] = 13; // 7 points
		timeCount[5] = 10; // 8 points
		timeCount[6] = 10; // 9 points
		
		btnDone = (Button) findViewById(R.id.btnDone);
		tvTimer = (TextView) findViewById(R.id.tvTimer);
		tvLevel = (TextView) findViewById(R.id.tvLevel);
		salesGameView = (SalesmanGameView) findViewById(R.id.salesGameView);
		salesGameView.setHostActivity(this);
		btnDone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				salesGameView.displayAnswer();
			}
		});
		
	}
	
	public void setTimer(int level) {
		Timer = new CountDownTimer(timeCount[level]*1000, 1000) {

		    public void onTick(long millisUntilFinished) {
		         tvTimer.setText("Time left: " + String.valueOf(millisUntilFinished / 1000) + " s");

		    }
		    public void onFinish() {
		    	// TODO Do something when time runs out
		    	salesGameView.displayAnswer();
		    }
		 }.start();
	}
	
	public void stopTimer() {
		Timer.cancel();
	}
	
	public void enableButton(boolean e) {
		btnDone.setEnabled(e);
	}
	
	public void setText(int lvl) {
		tvLevel.setText("Level: " + lvl);
	}
}
