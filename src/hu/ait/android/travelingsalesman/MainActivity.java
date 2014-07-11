package hu.ait.android.travelingsalesman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnShowAnswer; 
	public int nPoints;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		
		return super.onCreateOptionsMenu(menu);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == R.id.btnHome) {
			Intent i = new Intent();
			i.setClass(this, HomeActivity.class);
			finish();
			startActivity(i);
		} else if (item.getItemId() == R.id.btnChangePoints) {
			Intent i = new Intent();
			i.setClass(this, EnterPointsActivity.class);
			finish();
			startActivity(i);
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (/*getIntent().getExtras() != null &&*/ getIntent().getExtras().containsKey(EnterPointsActivity.POINTS)) {
			nPoints = Integer.parseInt(getIntent().getStringExtra(EnterPointsActivity.POINTS));
		}
		
		final SalesmanView salesView = (SalesmanView) findViewById(R.id.salesView);
		salesView.setHostActivity(this);
		
		Button btnStart = (Button) findViewById(R.id.btnReset);
		btnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				salesView.resetGame();
			}
		});
		
		
		// TODO Show Answer - Hide Answer functionality
		btnShowAnswer = (Button) findViewById(R.id.btnShowAnswer);
		btnShowAnswer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				salesView.displayAnswer();
			}
		});
		
		Button btnNewGame = (Button) findViewById(R.id.btnNewGame);
		btnNewGame.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				salesView.newGame();
			}
		});
		
	}
	
	public void setAnswerButton(boolean bool) {
		if (bool) {
			btnShowAnswer.setText("Hide Answer");
		} else {
			btnShowAnswer.setText("Show Answer");
		}
	}
}
