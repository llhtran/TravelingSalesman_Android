package hu.ait.android.travelingsalesman;

import java.util.ArrayList;
import java.util.Random;

import android.R.integer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SalesmanView extends View {

	//Paint paintBg;
	Paint paintLine;
	Paint paintCircle;
	Paint paintCircleStroke;
	Paint paintHighLight;
	Paint paintAnswer;
	
	private ArrayList<Point> points = new ArrayList<Point>();
	
	private boolean[][] lines;
	
	private boolean[][] answer;
	
	private int hover;
	private int start;
	private int end;
	private boolean drag = false;
	private boolean play = false;
	private float min = 1000000000;
	private int nPoints;
	private int[] highLight;
	
	private boolean begin = true;
	public boolean showAnswer = false;
	
	private MainActivity hostActivity;
	
	public void setHostActivity(MainActivity hostActivity) {
		this.hostActivity = hostActivity;
		nPoints = hostActivity.nPoints;
		lines = new boolean[nPoints][nPoints];
		answer = new boolean[nPoints][nPoints];
		highLight = new int[nPoints];
		for (int i = 0; i < nPoints ; i++) {
			for (int j = 0 ; j < nPoints ; j++) {
				lines[i][j] = false;
			}
		}
		for (int i = 0; i<nPoints;i++) {
			highLight[i] = 0;
		}
	}

	// what's the difference between constructor w or w/o AtributeSet?
	public SalesmanView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Set up view
		
		paintLine = new Paint();
		paintLine.setColor(Color.parseColor("#F5F5DC"));
		paintLine.setStyle(Style.FILL);
		paintLine.setAlpha(80);
		paintLine.setStrokeWidth(5);
		
		paintCircle = new Paint();
		paintCircle.setColor(Color.parseColor("#F5F5DC"));
		paintCircle.setStyle(Style.FILL);
		paintCircle.setStrokeWidth(5);
		
		paintCircleStroke = new Paint();
		paintCircleStroke.setColor(Color.parseColor("#F5F5DC"));
		paintCircleStroke.setStyle(Style.STROKE);
		paintCircleStroke.setStrokeWidth(3);
		
		paintHighLight = new Paint();
		paintHighLight.setColor(Color.parseColor("#ff0059"));
		paintHighLight.setStyle(Style.STROKE);
		paintHighLight.setStrokeWidth(3);
		
		paintAnswer = new Paint();
		paintAnswer.setColor(Color.parseColor("#4040CC"));
		paintAnswer.setStyle(Style.STROKE);
		paintAnswer.setStrokeWidth(5);
		
	}
		
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		// initializing the game for the first time
		// a better place to put this?
		if (begin) {
			newGame();
			begin = false;
		}
		
		// draw board
		// TODO set margins
		//canvas.drawRect(0, 0, getWidth(), getHeight(), paintBg);
		
		// draw circles
		for (int i = 0 ; i < nPoints ; i++) {
			canvas.drawCircle(points.get(i).x, points.get(i).y, 10, paintCircleStroke);
			canvas.drawCircle(points.get(i).x, points.get(i).y, 3, paintCircle);
			if (highLight[i]==2) {
				canvas.drawCircle(points.get(i).x, points.get(i).y, 10, paintCircle);
			}
		}
		
		// draw lines
		for (int i = 0; i < nPoints ; i++) {
			for (int j = 0 ; j < nPoints ; j++) {
				if (lines[i][j]) {
					canvas.drawLine(points.get(i).x, points.get(i).y, points.get(j).x, points.get(j).y, paintLine);
					play = true;
				}
			}
		}
		
		// draw highlights for selected circles
		if (drag) {
			canvas.drawCircle(points.get(hover).x, points.get(hover).y, 15, paintHighLight);
		}
		
		if (showAnswer) {
			for (int i = 0; i < nPoints ; i++) {
				for (int j = 0 ; j < nPoints ; j++) {
					if (answer[i][j]) {
						canvas.drawLine(points.get(i).x, points.get(i).y, points.get(j).x, points.get(j).y, paintAnswer);
					}
				}
			}
			paintAnswer.setStyle(Style.FILL);
			for (int i = 0 ; i < nPoints ; i++) {
				canvas.drawCircle(points.get(i).x, points.get(i).y, 7, paintAnswer);
			}
			paintAnswer.setStyle(Style.STROKE);
		}
		
	}	
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// 
		int width = MeasureSpec.getSize(widthMeasureSpec);
		int height = MeasureSpec.getSize(heightMeasureSpec);
		
		// TODO do the magic
		//
		int d = width == 0 ? height : height == 0 ? width : width < height ? width : height; 
		setMeasuredDimension(d,d);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction()==MotionEvent.ACTION_DOWN) {
			float startX = event.getX();
			float startY = event.getY();
			
			for (int i = 0 ; i< nPoints ; i++) {
				if ((points.get(i).x - 10 < startX && startX < points.get(i).x + 10) &&
						(points.get(i).y - 10 < startY && startY < points.get(i).y + 10)) {
					hover = i;
					start = i;
					drag = true;
					invalidate();
				}	
			}
		}
		else if (event.getAction()==MotionEvent.ACTION_MOVE) {
			float endX = event.getX();
			float endY = event.getY();
			
			for (int i = 0 ; i< nPoints ; i++) {
				if ((points.get(i).x - 10 < endX && endX < points.get(i).x + 10) &&
						(points.get(i).y - 10 < endY && endY < points.get(i).y + 10)) {
					hover = i;
					end = i;
					invalidate();
					if (drag) {
						if (start != end) {
							if (lines[start][end] == false) {
								lines[start][end] = lines[end][start] = true;
								highLight[start]++;
								highLight[end]++;
							} else {
								lines[start][end] = lines[end][start] = false;
								highLight[start]--;
								highLight[end]--;
							}	
						}
						invalidate();
						start = end;
					}
				}
			}
		}
		else if (event.getAction()==MotionEvent.ACTION_UP) {
			float endX = event.getX();
			float endY = event.getY();
			
			for (int i = 0 ; i< nPoints ; i++) {
				if ((points.get(i).x - 10 < endX && endX < points.get(i).x + 10) &&
						(points.get(i).y - 10 < endY && endY < points.get(i).y + 10)) {
					end = i;
					invalidate();
					if (drag) {
						if (start != end) {
							if (lines[start][end] == false) {
								lines[start][end] = lines[end][start] = true;
							} else {
								lines[start][end] = lines[end][start] = false;
							}	
						}
						drag = false;
						invalidate();
					}
				} else {
					drag = false;
					invalidate();
				}
			}
		}
		return true;
	}
	
	public void newGame() {
		points.clear();
		Random r = new Random();
		// Point p = new Point();
	
		for (int i = 0 ; i < nPoints ; i++ ) {
			Point p = new Point();
			p.x = r.nextInt(getWidth() - 20) + 10;
			p.y = r.nextInt(getHeight() - 20) + 10;
			points.add(p);
		}
		min = 1000000000;
		int[] array = new int[nPoints]; 
		for (int i = 0; i<nPoints; i++) {
			array[i] = i;
		}
		Solver solve = new Solver();
		solve.execute(array);
		resetGame();
		invalidate();
	}
	
	private class Solver extends AsyncTask<int[], Void, Void> {

		@Override
		protected Void doInBackground(int[]... params) {
			answerSecond(params[0], 0, nPoints);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			//Toast.makeText(hostActivity, "Answer is ready!", Toast.LENGTH_SHORT).show();
		}
	}
	
	private void answerSecond(int[] array, int startIndex, int total) {
		// base case
		if (startIndex == total - 1) {
			// TODO got full array, try for min now!
			
			// prepping array of distances between points
			float tempMin = 0;
			float[][] d = new float[total][total];
			float dx, dy;
			for (int i = 0; i<total; i++) {
				for (int j = 0; j<total; j++) {
					dx = points.get(i).x - points.get(j).x;
					dy = points.get(i).y - points.get(j).y;
					d[i][j] = d[j][i] = (float) (dx*dx + dy*dy);
				}
			}
			
			for (int i = 0; i < total - 1; i++) {
				tempMin = tempMin + d[array[i]][array[i+1]];
			}
			tempMin = tempMin + d[array[total-1]][array[0]];
			if (tempMin < min) {
				min = tempMin;
				// clearing answer array
				for (int q = 0; q<total;q++) {
					for (int r = 0; r<total;r++) {
						answer[q][r] = false;
					}
				}
				// filling with answers
				for (int i = 0; i < total - 1; i++) {
					answer[array[i]][array[i+1]] = answer[array[i+1]][array[i]] = true;
				}
				answer[array[total-1]][array[0]] = answer[array[0]][array[total-1]] = true;
			}
		}
		
		// initializing array with 100s since we're not going to play a game with >100 points
		int[] temp = new int[total];
		int tempTrack;
		for (int i = 0; i <total; i++) {
			temp[i] = 100; // 100 is the dummy number
		}
		
		// copying up until index where need to start permutating
		for (int i = 0; i < startIndex; i++) {
			temp[i] = array[i];
		}
		
		for (int i = startIndex; i < total; i++) {
			// looping through remaining elements for temp.get(startIndex)
			temp[startIndex] = array[i];
			tempTrack = startIndex + 1;
			// copying the remaining number into the rest of the array
			for (int j = startIndex; j < total; j++) {
				if (array[j] != temp[startIndex]) {
					temp[tempTrack] = array[j];
					tempTrack++;
				}
			}
			answerSecond(temp, startIndex + 1, total);
		}
	}
	
	public void displayAnswer() {
		// display the shortest tour
		boolean win = true;
		if (!showAnswer) {
			showAnswer = true;
			// Log.d("TravelingSalesman","Start printing here!");
			for (int q = 0; q<nPoints;q++) {
				for (int r = 0; r<nPoints;r++) {
					
					if (answer[q][r] != lines[q][r]) {
						win = false;
					/*	Log.d("TravelingSalesman","0");
					} else {
						Log.d("TravelingSalesman","1");*/
					}
				}
			}
			if (win)  {
				Toast.makeText(hostActivity, "YOU GOT IT!", Toast.LENGTH_SHORT).show();
			}
		} else {
			showAnswer = false;
		}
		hostActivity.setAnswerButton(showAnswer);
		invalidate(); 
	}
	
	public void resetGame() {
		for (int i = 0; i < nPoints ; i++) {
			highLight[i] = 0;
			for (int j = 0 ; j < nPoints ; j++) {
				lines[i][j] = false;
			}
		}
		play = false;
		drag = false;
		showAnswer = false;
		hostActivity.setAnswerButton(showAnswer);
		invalidate();
	}
	
}

	
