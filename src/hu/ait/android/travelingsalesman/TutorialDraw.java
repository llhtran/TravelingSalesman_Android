package hu.ait.android.travelingsalesman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class TutorialDraw extends View {
	
	Paint paintLine;
	Paint paintCircle;
	Paint paintCircleStroke;
	Paint paintHighLight;
	Paint paintAnswer;
	
	int step;
	boolean clear;
	int tutScreen;
	
	public TutorialDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		beginTut1();
		
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
		
		if (tutScreen == 1) {
			if (step == 1) {
				canvas.drawCircle(75, 55, 10, paintCircleStroke);
				canvas.drawCircle(75, 55, 3, paintCircle);
				
				canvas.drawCircle(225, 155, 10, paintCircleStroke);
				canvas.drawCircle(225, 155, 3, paintCircle);
				
				canvas.drawCircle(75, 55, 15, paintHighLight);
				step = 2;
			} else {
				canvas.drawCircle(75, 55, 10, paintCircleStroke);
				canvas.drawCircle(75, 55, 3, paintCircle);
				
				canvas.drawCircle(225, 155, 10, paintCircleStroke);
				canvas.drawCircle(225, 155, 3, paintCircle);
				
				canvas.drawLine(75, 55, 225, 155, paintLine);
				canvas.drawCircle(225, 155, 15, paintHighLight);
				step = 1;
			}
		} else if (tutScreen == 2) {
			if (step == 1) {
				canvas.drawCircle(75, 155, 10, paintCircleStroke);
				canvas.drawCircle(75, 155, 3, paintCircle);
				canvas.drawCircle(75, 155, 15, paintHighLight);
				
				canvas.drawCircle(150, 55, 10, paintCircleStroke);
				canvas.drawCircle(150, 55, 3, paintCircle);
				
				canvas.drawCircle(225, 100, 10, paintCircleStroke);
				canvas.drawCircle(225, 100, 3, paintCircle);
				step = 2;
			} else if (step == 2) {
				canvas.drawCircle(75, 155, 10, paintCircleStroke);
				canvas.drawCircle(75, 155, 3, paintCircle);
				
				canvas.drawLine(75, 155, 150, 55, paintLine);
				
				canvas.drawCircle(150, 55, 10, paintCircleStroke);
				canvas.drawCircle(150, 55, 3, paintCircle);
				canvas.drawCircle(150, 55, 15, paintHighLight);
				
				canvas.drawCircle(225, 100, 10, paintCircleStroke);
				canvas.drawCircle(225, 100, 3, paintCircle);
				step = 3;
			} else {
				canvas.drawCircle(75, 155, 10, paintCircleStroke);
				canvas.drawCircle(75, 155, 3, paintCircle);
				
				canvas.drawLine(75, 155, 150, 55, paintLine);
				
				canvas.drawCircle(150, 55, 10, paintCircleStroke);
				canvas.drawCircle(150, 55, 3, paintCircle);
				canvas.drawCircle(150, 55, 10, paintCircle);
				
				canvas.drawLine(150, 55, 225, 100, paintLine);
				
				canvas.drawCircle(225, 100, 10, paintCircleStroke);
				canvas.drawCircle(225, 100, 3, paintCircle);
				canvas.drawCircle(225, 100, 15, paintHighLight);
				step = 1;
			}
		} else if (tutScreen == 3) {
			if (step == 1) {
				canvas.drawCircle(75, 55, 10, paintCircleStroke);
				canvas.drawCircle(75, 55, 3, paintCircle);
				canvas.drawCircle(75, 55, 15, paintHighLight);
				
				canvas.drawCircle(90, 155, 10, paintCircleStroke);
				canvas.drawCircle(90, 155, 3, paintCircle);
				
				canvas.drawCircle(165, 140, 10, paintCircleStroke);
				canvas.drawCircle(165, 140, 3, paintCircle);
				
				canvas.drawCircle(255, 80, 10, paintCircleStroke);
				canvas.drawCircle(255, 80, 3, paintCircle);
				
				step++;
			} else if (step == 2) {
				canvas.drawCircle(75, 55, 10, paintCircleStroke);
				canvas.drawCircle(75, 55, 3, paintCircle);
				
				canvas.drawLine(75, 55, 90, 155, paintLine);
				
				canvas.drawCircle(90, 155, 10, paintCircleStroke);
				canvas.drawCircle(90, 155, 3, paintCircle);
				canvas.drawCircle(90, 155, 15, paintHighLight);
				
				canvas.drawCircle(165, 140, 10, paintCircleStroke);
				canvas.drawCircle(165, 140, 3, paintCircle);
				
				canvas.drawCircle(255, 80, 10, paintCircleStroke);
				canvas.drawCircle(255, 80, 3, paintCircle);
				
				step++;
			} else if (step == 3) {
				canvas.drawCircle(75, 55, 10, paintCircleStroke);
				canvas.drawCircle(75, 55, 3, paintCircle);
				
				canvas.drawLine(75, 55, 90, 155, paintLine);
				
				canvas.drawCircle(90, 155, 10, paintCircleStroke);
				canvas.drawCircle(90, 155, 3, paintCircle);
				canvas.drawCircle(90, 155, 10, paintCircle);
				
				canvas.drawLine(90, 155, 165, 140, paintLine);
				
				canvas.drawCircle(165, 140, 10, paintCircleStroke);
				canvas.drawCircle(165, 140, 3, paintCircle);
				canvas.drawCircle(165, 140, 15, paintHighLight);
				
				canvas.drawCircle(255, 80, 10, paintCircleStroke);
				canvas.drawCircle(255, 80, 3, paintCircle);
				step++;
			} else if (step == 4) {
				canvas.drawCircle(75, 55, 10, paintCircleStroke);
				canvas.drawCircle(75, 55, 3, paintCircle);
				
				canvas.drawLine(75, 55, 90, 155, paintLine);
				
				canvas.drawCircle(90, 155, 10, paintCircleStroke);
				canvas.drawCircle(90, 155, 3, paintCircle);
				canvas.drawCircle(90, 155, 10, paintCircle);
				
				canvas.drawLine(90, 155, 165, 140, paintLine);
				
				canvas.drawCircle(165, 140, 10, paintCircleStroke);
				canvas.drawCircle(165, 140, 3, paintCircle);
				canvas.drawCircle(165, 140, 10, paintCircle);
				
				canvas.drawLine(165, 140, 255, 80, paintLine);
				
				canvas.drawCircle(255, 80, 10, paintCircleStroke);
				canvas.drawCircle(255, 80, 3, paintCircle);
				canvas.drawCircle(255, 80, 15, paintHighLight);
				step++;
			} else {
				canvas.drawCircle(75, 55, 10, paintCircleStroke);
				canvas.drawCircle(75, 55, 10, paintCircle);
				canvas.drawCircle(75, 55, 15, paintHighLight);
				
				canvas.drawLine(75, 55, 90, 155, paintLine);
				
				canvas.drawCircle(90, 155, 10, paintCircleStroke);
				canvas.drawCircle(90, 155, 10, paintCircle);
				
				canvas.drawLine(90, 155, 165, 140, paintLine);
				
				canvas.drawCircle(165, 140, 10, paintCircleStroke);
				canvas.drawCircle(165, 140, 10, paintCircle);
				
				canvas.drawLine(165, 140, 255, 80, paintLine);
				
				canvas.drawCircle(255, 80, 10, paintCircleStroke);
				canvas.drawCircle(255, 80, 10, paintCircle);
				
				canvas.drawLine(255, 80, 75, 55, paintLine);
				step = 1;
			}
		}
		
	}
	
	public void beginTut1() {
		tutScreen = 1;
		step = 1;
	}
	
	public void beginTut2() {
		tutScreen = 2;
		step = 1;
	}
	
	public void beginTut3() {
		tutScreen = 3;
		step = 1;
	}
	
	public void beginTut4() {
		tutScreen = 4;
		invalidate();
	}
}
