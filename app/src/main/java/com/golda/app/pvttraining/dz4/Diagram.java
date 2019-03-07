package com.golda.app.pvttraining.dz4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.Random;

public class Diagram extends View {
    private int height, width = 0;
    private int padding = 0;
    private int fontSize = 0;
    private Paint paint;
    private boolean isInit;
    private int[] numbers = {5, 10, 5};
    private RectF rectf;
    private Rect rect = new Rect();

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
        drawDiagram(canvas);
    }

    private void initDiagram() {
        height = getHeight();
        width = getWidth();
        padding = 50;
        fontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 13,
                getResources().getDisplayMetrics());
        int min = Math.min(height, width);
        paint = new Paint();
        isInit = true;
    }

    private void getRandomColor() {
        Random rnd = new Random();
        paint.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    private void drawDiagram(Canvas canvas) {
        paint.reset();
        paint.setAntiAlias(true);
        rectf = new RectF(padding,padding, width-padding, height-padding);
        float sumArray = 0;
        float startAngle = 0;
        for (int ma : numbers) {
            sumArray += ma;
        }

        for (int number : numbers) {
            getRandomColor();
            float angle = 360 / sumArray * number;
            canvas.drawArc(rectf, startAngle, angle, true, paint);
            drawText(canvas, startAngle + angle / 2, number );
            drawMarker(canvas, startAngle + angle / 2);
            startAngle += angle;
        }
    }

    private void drawText(Canvas canvas, double angle, int number) {
        double radians = Math.toRadians(angle-7);
        paint.setTextSize(fontSize);
        String tmp = String.valueOf(number);
        paint.getTextBounds(tmp, 0, tmp.length(), rect);
        int x = (int) (width / 2 + Math.cos(radians) * (width/2 - padding/2) - rect.width() / 2);
        int y = (int) (height / 2 + Math.sin(radians) * (height/2 - padding/2) + rect.height() / 2);
        canvas.drawText(tmp, x, y, paint);
    }

    private void drawMarker(Canvas canvas, double angle) {
        paint.setStrokeWidth(5);
        double radians = Math.toRadians(angle);
        int x = (int) (width / 2 + Math.cos(radians) * (width/2 - padding/2));
        int y = (int) (height / 2 + Math.sin(radians) * (height/2 - padding/2));
        canvas.drawLine(width/2, height / 2, x, y, paint);
        canvas.drawCircle(x, y, 10, paint);
    }
}
