package hu.ait.android.travelingsalesman;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPointsActivity extends Activity {

	public static final String POINTS = "number_points";
	
	EditText enterPoints;
	Button btnSendPoints;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_points);
		
		
		enterPoints = (EditText) findViewById(R.id.enterPoints);
		btnSendPoints = (Button) findViewById(R.id.btnSendPoints);
		btnSendPoints.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (enterPoints.getText().toString().length() > 0) {
					//startIntent();
					if (Integer.parseInt(enterPoints.getText().toString()) > 9) {
						AlertDialog.Builder alert = new AlertDialog.Builder
								(new ContextThemeWrapper(EnterPointsActivity.this, android.R.style.Theme_Black));
						alert.setTitle("Warning!");
						alert.setMessage(
								"If the number of points you enter is larger than 9,"
								+ " the provided answer may not always be the optimal solution.").
								setCancelable(true).
								setPositiveButton("Continue", new DialogInterface.OnClickListener() {
									
									@Override
									public void onClick(DialogInterface arg0, int arg1) {
										startIntent();
									}
								}).
								setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
									
									@Override
									public void onClick(DialogInterface dialog, int which) {
										dialog.cancel();
									}
								});
						AlertDialog alertDialog = alert.create();
						alertDialog.show();
					} else {
						startIntent();
					}
				} else {
					Toast.makeText(getApplicationContext(), "Please enter an integer!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}
	
	private void startIntent() {
		Intent i = new Intent();
		i.setClass(EnterPointsActivity.this, MainActivity.class);
		i.putExtra(POINTS, enterPoints.getText().toString());
		startActivity(i);
	}
}
