package com.zucc.circle.circleapp.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class LearnView extends View{
    Paint mPaint = new Paint();
    Path mPath = new Path(); // 初始化 Path 对象
    public LearnView(Context context) {
        super(context);
    }

    public LearnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LearnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*-----------设置画笔颜色-----------*/
        // mPaint.setColor(Color.RED);
        /*-----------设置画笔风格-----------*/
        /*
        1.STROKE:边框
        2.FILL:填充
        3;FILL AND STROKE:既画线又填充
        */
        //mPaint.setStyle(Paint.Style.STROKE);
        /*----------设置画笔线宽 （单位: 像素）-----------*/
        /*
        PS:只在 2 和 3 风格下有效
        */
        //mPaint.setStrokeWidth(20);
        /*-----------开启抗锯齿-----------*/
        // mPaint.setAntiAlias(true);
        /*-----------Canvas DrawXXX（）方法-----------*/
        /*
        1.drawCircle(float centerX, float centerY, float radius, Paint paint) 画圆
        2.drawRect(float left, float top, float right, float bottom, Paint paint) 画矩形
        3.drawPoint(float x, float y, Paint paint) 画点
        4.drawPoints(float[] pts, int offset, int count, Paint paint) / drawPoints(float[] pts, Paint paint) 画点（批量）
        5.drawOval(float left, float top, float right, float bottom, Paint paint) 画椭圆
        6.drawLine(float startX, float startY, float stopX, float stopY, Paint paint) 画线
        7.drawLines(float[] pts, int offset, int count, Paint paint) / drawLines(float[] pts, Paint paint) 画线（批量）
        8.drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, Paint paint) 画圆角矩形
        9.drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint) 绘制弧形或扇形
        10.drawPath(Path path, Paint paint) 画自定义图形
         */
        //canvas.drawCircle(300, 300, 200, mPaint);
        //canvas.drawRect(0, 0, 300, 300,mPaint);
//        mPaint.setColor(Color.RED);
//        mPath.addArc(200, 200, 400, 400, -225, 225);
//        mPath.arcTo(400, 200, 600, 400, -180, 225, false);
//        mPath.lineTo(400, 542);
//        canvas.drawPath(mPath, mPaint);
        /*-----------Path  addXXX()方法介绍-----------*/
        /*
        1.addCircle(float x, float y, float radius, Direction dir) 添加圆  (Direction 为方向，CW顺时针，CCW逆时针)
        2.addOval(float left, float top, float right, float bottom, Direction dir) / addOval(RectF oval, Direction dir) 添加椭圆
        3.addRect(float left, float top, float right, float bottom, Direction dir) / addRect(RectF rect, Direction dir) 添加矩形
        4.addPath(Path path) 添加另一个 Path
         */
        /*-----------Path  xxxTo()方法介绍-----------*/
        /*
        1.lineTo(float x, float y) / rLineTo(float x, float y) 画直线
        2.quadTo(float x1, float y1, float x2, float y2) / rQuadTo(float dx1, float dy1, float dx2, float dy2) 画二次贝塞尔曲线
        3.cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) / rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) 画三次贝塞尔曲线
        4.moveTo(float x, float y) / rMoveTo(float x, float y) 移动到目标位置
        5.arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo) / arcTo(RectF oval, float startAngle, float sweepAngle) 画弧形
        6.
         */
        mPath.addCircle(300, 300, 200, Path.Direction.CCW);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


}
