/**
 * Copyright (C) 2014 The KnowboxTeacher Project
 */
package com.example.zhaozhu.second_as_practise.widgets_prac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhaozhu.second_as_practise.R;


/**
 * 自适应圆形进度条
 *
 */
public class CircleProgressBar extends View {

	private Paint mProgressBgPaint;
	private Paint mProgressPaint;
	private Paint mPercentPaint;

	private RectF mProgressRectF;

	private float mDensity = 1;
	private int mProgress = 0;

	public CircleProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CircleProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public CircleProgressBar(Context context) {
		super(context);
		init();
	}

	private void init() {
		mDensity = getResources().getDisplayMetrics().density;
		mProgressRectF = new RectF();
		mProgressBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mProgressBgPaint.setAntiAlias(true);
		mProgressBgPaint.setStrokeWidth(1f * mDensity);
		mProgressBgPaint.setStyle(Paint.Style.STROKE);
		mProgressBgPaint.setStrokeCap(Paint.Cap.ROUND);
		mProgressBgPaint.setStrokeJoin(Paint.Join.ROUND);
//		mProgressBgPaint.setColor(Color.WHITE);
		mProgressBgPaint.setColor(Color.RED);

		mProgressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mProgressPaint.setAntiAlias(true);
		mProgressPaint.setStrokeWidth(1f * mDensity);
		mProgressPaint.setStyle(Paint.Style.STROKE);
		mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
		mProgressPaint.setStrokeJoin(Paint.Join.ROUND);
		mProgressPaint.setColor(getResources().getColor(R.color.color_main));

		mPercentPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPercentPaint.setColor(0xff3dcab1);
		mPercentPaint.setTextSize(18 * mDensity);
	}

	public void setLineColor(int color) {
		mProgressBgPaint.setColor(color);
		invalidate();
	}

	public void setStrokeWidth(int width) {
		mProgressBgPaint.setStrokeWidth(width);
		invalidate();
	}

	public void setProgress(int progress) {
		this.mProgress = progress;
		invalidate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		refreshRectF();
		drawProgress(canvas);
	}

	private void drawProgress(Canvas canvas) {
		canvas.drawArc(mProgressRectF, 0, 360, false, mProgressBgPaint);
		canvas.drawArc(mProgressRectF, -90, mProgress * 3.6f, false, mProgressPaint);
	}

	private void refreshRectF() {
		int d = getWidth();
		float padding = mProgressBgPaint.getStrokeWidth() + 4 * mDensity;
		if (getHeight() < d) {
			d = getHeight();
		}
		mProgressRectF.set(padding + (getWidth() - d) / 2, padding
				+ (getHeight() - d) / 2, d - padding + (getWidth() - d) / 2, d
				- padding + (getHeight() - d) / 2);
	}
}
