package com.bwie.asus.chenxiaoyang1203.ActivityClass;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class CurstomLayout extends LinearLayout {

    private int mChildMaxHeight;
    private int mHSpace=20;
    private int mVSpace=20;

    public CurstomLayout(Context context) {
        super(context);
    }

    public CurstomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //  测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);

        findMaxChildMaxHeight();

        int left=0,top=0;

        int childCount = getChildCount();

        for (int i=0;i<childCount;i++){
            View view = getChildAt(i);

            if (left!=0){
                if ((left+view.getMeasuredWidth())>sizeWidth){
                    top+=mChildMaxHeight+mVSpace;
                    left=0;
                }
            }
            left+=view.getMeasuredWidth()+mHSpace;


        }
        setMeasuredDimension(sizeWidth,(top+mChildMaxHeight)>sizeHeight?sizeHeight:top+mChildMaxHeight);
    }


    //布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxChildMaxHeight();
        int left=0,top=0;

        int childCount = getChildCount();

        for (int i=0;i<childCount;i++){
            View view = getChildAt(i);

            if (left!=0){
                if ((left+view.getMeasuredWidth())>getWidth()){
                    top+=mChildMaxHeight+mVSpace;
                    left=0;
                }
            }
            view.layout(top,left,left+view.getMeasuredWidth(),top+getMeasuredHeight());
            left+=view.getMeasuredWidth()+mHSpace;


        }
    }
    //画布
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    private void findMaxChildMaxHeight() {
        mChildMaxHeight=0;

        int childCount = getChildCount();

        for (int i=0;i<childCount;i++){
            View view = getChildAt(i);
            if (view.getMeasuredHeight()>mChildMaxHeight){
                mChildMaxHeight=view.getMeasuredHeight();
            }
        }
    }
}
