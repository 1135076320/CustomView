package com.cp1.customview.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class SimpleCircleView extends View {

    private Paint mPaint;

    public SimpleCircleView(Context context) {
        super(context);
        init();
    }

    public SimpleCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setARGB(0xEA, 0xFF, 0x56, 0);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(5f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int defaultWidth = 100;
        int defaultHeight = 100;

        if (widthMode == MeasureSpec.AT_MOST){
            widthSize = defaultWidth;
        }
        if (heightMode == MeasureSpec.AT_MOST){
            heightSize = defaultHeight;
        }
        setMeasuredDimension(widthSize,heightSize);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        // 设置圆的半径 = 宽,高最小值的2分之1
        int r = Math.min(width, height) / 2;

        // 画出圆（蓝色）
        // 圆心 = 控件的中央,半径 = 宽,高最小值的2分之1
        canvas.drawCircle(width / 2, height / 2, r, mPaint);
    }

}
