package com.zucc.circle.circleapp.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import com.zucc.circle.circleapp.R;

public class MyViewExample extends View {
    /**
     * 当一个bitmap 还未生成的时用来测量的宽度
     */
    private int mDefaultBitmapWidth;
    /**
     * 当一个bitmap 还未生成的时用来测量的高度
     */
    private int mDefaultBitmapHeight;
    /**
     * 用来绘制的Paint对象
     */
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    /**
     * 包含两个混合图片的Bitmap
     */
    private Bitmap mBitmap;
    /**
     * 用来生成XferMode的PorterDuff Mode
     */
    private PorterDuff.Mode mPorterDuffMode = PorterDuff.Mode.CLEAR;
    /**
     * 用来合并图片的XferMode
     */
    private Xfermode mXfermode = new PorterDuffXfermode(mPorterDuffMode);

    public MyViewExample(Context context) {
        super(context);
        initDefaultBitmapDimens();
    }
    public MyViewExample(Context context, AttributeSet attrs) {
        super(context,attrs);
        initDefaultBitmapDimens();
    }
    public MyViewExample(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDefaultBitmapDimens();
    }
    public MyViewExample(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initDefaultBitmapDimens();
    }
    public void setPorterDuffMode(PorterDuff.Mode mode) {
        if(mode == mPorterDuffMode) {
            return;
        }
        mPorterDuffMode = mode;
        mXfermode = new PorterDuffXfermode(mode);
        mBitmap = null;
        invalidate();
    }
    private void initDefaultBitmapDimens() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.shape1, options);
        mDefaultBitmapWidth = options.outWidth;
        mDefaultBitmapHeight = options.outHeight;
    }
    @Override
    public void onDraw(Canvas canvas) {
        if (mBitmap == null) {
            createBitmap();
        }
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            mBitmap = null;
        }
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //计算宽度
        int width;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if(specMode == MeasureSpec.EXACTLY) {
            width = specSize;
        }
        else {
            width = getPaddingLeft() + getPaddingRight() + mDefaultBitmapWidth;
            if(specMode == MeasureSpec.AT_MOST) {
                width = Math.min(width, specSize);
            }
        }
        //计算高度
        int height;
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        if(specMode == MeasureSpec.EXACTLY) {
            height = specSize;
        }
        else {
            height = getPaddingTop() + getPaddingBottom() + mDefaultBitmapHeight;
            if(specMode == MeasureSpec.AT_MOST) {
                height = Math.min(height, specSize);
            }
        }
        setMeasuredDimension(width, height);
    }
    private void createBitmap() {
        //准备Bitmap
        final int width = getWidth();
        final int height = getHeight();
        final Rect rect = new Rect();
        final int minDimen = Math.min(width, height);
        rect.right = minDimen;
        rect.bottom = minDimen;
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        final Canvas c = new Canvas(mBitmap);
        //创建目标Bitmap 然后绘制它
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.shape1);
        c.drawBitmap(b, null, rect, mPaint);
        //创建目标Bitmap 设置XferMode，然后绘制它
        b = BitmapFactory.decodeResource(getResources(), R.drawable.shape2);
        mPaint.setXfermode(mXfermode);
        c.drawBitmap(b, null, rect, mPaint);
        //去除XferMode
        mPaint.setXfermode(null);
    }
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof PorterDuffSavedState)) {
            // Not our saved state
            super.onRestoreInstanceState(state);
            return;
        }

        final PorterDuffSavedState ourState = (PorterDuffSavedState) state;
        super.onRestoreInstanceState(ourState.getSuperState());
        setPorterDuffMode(ourState.mode);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        final Parcelable superState = super.onSaveInstanceState();
        final PorterDuffSavedState ourState = new PorterDuffSavedState(superState);
        ourState.mode = mPorterDuffMode;
        return ourState;
    }

    private static class PorterDuffSavedState extends BaseSavedState {

        public PorterDuff.Mode mode;

        public PorterDuffSavedState(Parcel source) {
            super(source);
            mode = (PorterDuff.Mode) source.readSerializable();
        }

        public PorterDuffSavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeSerializable(mode);
        }
    }
}
