package com.golda.app.pvttraining.dz3;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    private float touchX;
    private float touchY;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            touchX = event.getX();
            touchY = event.getY();

            invalidate();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        float l1 = getWidth() * .05f;
//        float l2 = getHeight() * .05f;
//
//        RectF rect2 = new RectF();
//        rect2.top = l1;
//        rect2.left = l2;
//        rect2.right = rect2.top + l1;
//        rect2.bottom = rect2.left + l2;
//
//        Paint paint2 = new Paint();
//        paint2.setColor(Color.RED);
//        paint2.setAntiAlias(true);
//
//        canvas.drawRect(rect2, paint2);


//        float cx = getWidth() / 2;
//        float cy = getHeight() / 2;
//        float radius = Math.min(cy, cx);
//
//        Paint paint = new Paint();
//        paint.setColor(Color.BLUE);
//        paint.setAntiAlias(true);
//
//        float hey = Math.max(getWidth(), getHeight()) / 3;
//
//        canvas.drawCircle(cx, cy, radius, paint);

//        Paint paint2 = new Paint();
//        paint2.setColor(Color.RED);
//        paint2.setAntiAlias(true);
//
//        RectF rect = new RectF();
//        rect.left = 0;
//        rect.top = cy - hey / 3;
//        rect.right = getHeight();
//        rect.bottom = rect.top + hey;
//
//        canvas.drawRect(rect, paint2);

    }
}
