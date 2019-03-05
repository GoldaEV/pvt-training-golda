package com.golda.app.pvttraining.dz4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.Calendar;

public class Diagram extends View {
    private int height, width = 0;
    private int padding = 0;
    private int fontSize = 0;
    private int numeralSpacing = 0;
    private int radius = 0;
    private Paint paint;
    private boolean isInit;
    private int[] numbers = {5,5,10};
    private int[] percent;
    private RectF rectf = new RectF();

    public Diagram(Context context) {
        super(context);
    }

    public Diagram(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Diagram(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (!isInit) {
            initDiagram();
        }
        calculatePercent(numbers);
        drawDiagram(canvas);
        postInvalidateDelayed(500);
        invalidate();
    }

    private void initDiagram() {
        height = getHeight();
        width = getWidth();
        padding = numeralSpacing + 50;
        fontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 13,
                getResources().getDisplayMetrics());
        int min = Math.min(height, width);
        radius = min / 2 - padding;
        paint = new Paint();
        isInit = true;
    }

    private void calculatePercent(int[] numbers) {
        percent = new int[numbers.length];
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        for (int i = 0; i < percent.length; i++) {
            percent[i] = 360 / sum * numbers[i];
        }
    }

    private void drawDiagram(Canvas canvas) {
        paint.reset();
        paint.setColor(getResources().getColor(android.R.color.black));
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawArc(rectf, 90, 270, true, paint);
    }



}
