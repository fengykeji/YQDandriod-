package com.ccsoft.yunqudao.utils;



import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;


import com.ccsoft.yunqudao.R;

import java.util.ArrayList;
import java.util.Collections;

public class SeatTable1 extends View {
    private final boolean DBG = false;

    Paint paint = new Paint();
    Paint lineNumberPaint;
    float lineNumberTxtHeight;

    private ArrayList<ArrayList<String>> textList;

    public void setLineNumbers(ArrayList<String> lineNumbers) {
        this.lineNumbers = lineNumbers;
        invalidate();
    }

    ArrayList<String> lineNumbers = new ArrayList<>();

    Paint.FontMetrics lineNumberPaintFontMetrics;
    Matrix matrix = new Matrix();

    int spacing;
    int verSpacing;
    int numberWidth;
    int row;
    int column;

    Bitmap seatBitmap;
    Bitmap checkedSeatBitmap;
    Bitmap seatSoldBitmap;
    Bitmap floorBitmap;

    int lastX;
    int lastY;

    int seatBitmapWidth;
    int seatBitmapHeight;

    private SeatChecker seatChecker;

    int txt_color;
    int seatCheckedResID;
    int seatSoldResID;
    int seatAvailableResID;

    boolean isOnClick;

    private static final int SEAT_TYPE_SOLD = 1;
    private static final int SEAT_TYPE_AVAILABLE = 3;
    private static final int SEAT_TYPE_NOT_AVAILABLE = 4;
    private static final int SEAT_TYPE_ORDER = 5;


    private int downX, downY;
    private boolean pointer;

    Paint pathPaint;
    RectF rectF;

    private float mScaleX = 1;
    private float mScaleY = 1;

    private float defaultImgW = 180;
    private float defaultImgH = 100;

    private int seatWidth;
    private int seatHeight;

    private float[] originalValues = new float[9];
    private float[] changingValues = new float[9];

    public SeatTable1(Context context) {
        super(context);
    }

    public SeatTable1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SeatTableView);
        txt_color = typedArray.getColor(R.styleable.SeatTableView_txt_color, Color.WHITE);
        seatCheckedResID = typedArray.getResourceId(R.styleable.SeatTableView_seat_checked, R.mipmap.yuding);
        seatSoldResID = typedArray.getResourceId(R.styleable.SeatTableView_overview_sold, R.mipmap.yishou);
        seatAvailableResID = typedArray.getResourceId(R.styleable.SeatTableView_seat_available, R.mipmap.weishou);
        typedArray.recycle();
    }

    public SeatTable1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void init() {
        spacing = (int) dip2Px(5);
        verSpacing = (int) dip2Px(10);

        floorBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.louceng);

        seatBitmap = BitmapFactory.decodeResource(getResources(), seatAvailableResID);

        mScaleX = defaultImgW / seatBitmap.getWidth();
        mScaleY = defaultImgH / seatBitmap.getHeight();

        seatWidth = (int) (seatBitmap.getWidth() * mScaleX);
        seatHeight = (int) (seatBitmap.getHeight() * mScaleY);

        checkedSeatBitmap = BitmapFactory.decodeResource(getResources(), seatCheckedResID);
        seatSoldBitmap = BitmapFactory.decodeResource(getResources(), seatSoldResID);

        seatBitmapWidth = (int) (column * seatBitmap.getWidth() * mScaleX + (column - 1) * spacing);
        seatBitmapHeight = (int) (row * seatBitmap.getHeight() * mScaleY + (row - 1) * verSpacing);
        paint.setColor(Color.RED);
        numberWidth = floorBitmap.getWidth();

        pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pathPaint.setStyle(Paint.Style.FILL);
        pathPaint.setColor(Color.parseColor("#e2e2e2"));

        rectF = new RectF();

        lineNumberPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        lineNumberPaint.setColor(bacColor);
        lineNumberPaint.setTextSize(getResources().getDisplayMetrics().density * 12);
        lineNumberTxtHeight = lineNumberPaint.measureText("4");
        lineNumberPaintFontMetrics = lineNumberPaint.getFontMetrics();
        lineNumberPaint.setTextAlign(Paint.Align.CENTER);

        if (lineNumbers == null) {
            lineNumbers = new ArrayList<>();
        } else if (lineNumbers.size() <= 0) {
            for (int i = 0; i < row; i++) {
                lineNumbers.add(String.valueOf((i + 1)));
            }
        }

        matrix.postTranslate(numberWidth + spacing, verSpacing);
        matrix.getValues(originalValues);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        long startTime = System.currentTimeMillis();
        if (row <= 0 || column == 0) {
            return;
        }

        drawSeat(canvas);
        drawNumber(canvas);

        if (DBG) {
            long drawTime = System.currentTimeMillis() - startTime;
            Log.d("drawTime", "totalDrawTime:" + drawTime);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        int y = (int) event.getY();
        int x = (int) event.getX();
        int minOffset = 0;
        matrix.getValues(changingValues);

        gestureDetector.onTouchEvent(event);
        int pointerCount = event.getPointerCount();
        if (pointerCount > 1) {
            pointer = true;
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                pointer = false;
                downX = x;
                downY = y;
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!isOnClick) {
                    int downDX = Math.abs(x - downX);
                    int downDY = Math.abs(y - downY);
                    if ((downDX > minOffset || downDY > minOffset) && !pointer) {
                        int dx = x - lastX;
                        int dy = y - lastY;

                        float cxv = changingValues[2];
                        float cyv = changingValues[5];
                        float oxv = originalValues[2];
                        float oyv = originalValues[5];
                        float xOffset = seatBitmapWidth - Math.abs(changingValues[2]);
                        float yOffset = seatBitmapHeight - Math.abs(changingValues[5]);

//                        float overflowX = dx/20f;
//                        float overflowY = dy/20f;

                        float overflowX = 0;
                        float overflowY = 0;

                        if ((cxv > oxv || xOffset < getWidth()) && (cyv > oyv || yOffset < getHeight())) {
                            matrix.postTranslate(overflowX, overflowY);
                        } else if ((cxv > oxv || xOffset < getWidth()) && (cyv < oyv || yOffset > getHeight())) {
                            matrix.postTranslate(overflowX, dy);
                        } else if ((cxv < oxv || xOffset > getWidth()) && (cyv > oyv || yOffset < getHeight())) {
                            matrix.postTranslate(dx, overflowY);
                        } else {
                            matrix.postTranslate(dx, dy);
                        }
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                int downDX = Math.abs(x - downX);
                int downDY = Math.abs(y - downY);
                if ((downDX > minOffset || downDY > minOffset) && !pointer) {
                    autoScroll();
                }
                break;
        }
        isOnClick = false;
        lastY = y;
        lastX = x;

        return true;
    }

    Matrix tempMatrix = new Matrix();

    void drawSeat(Canvas canvas) {
        long startTime = System.currentTimeMillis();
        float translateX = getTranslateX();
        float translateY = getTranslateY();

        for (int i = 0; i < row; i++) {
            float top = i * seatBitmap.getHeight() * mScaleY + i * verSpacing + translateY;

            float bottom = top + seatBitmap.getHeight() * mScaleY;
            if (bottom < 0 || top > getHeight()) {
                continue;
            }

            for (int j = 0; j < column; j++) {
                float left = j * seatBitmap.getWidth() * mScaleX + j * spacing + translateX;

                float right = (left + seatBitmap.getWidth() * mScaleX);
                if (right < 0 || left > getWidth()) {
                    continue;
                }

                int seatType = getSeatType(i, j);
                tempMatrix.setTranslate(left, top);
                tempMatrix.postScale(mScaleX, mScaleY, left, top);

                switch (seatType) {
                    case SEAT_TYPE_AVAILABLE:
                        canvas.drawBitmap(seatBitmap, tempMatrix, paint);
                        drawText(canvas, i, j, top, left);
                        break;
                    case SEAT_TYPE_NOT_AVAILABLE:
                        break;
                    case SEAT_TYPE_ORDER:
                        canvas.drawBitmap(checkedSeatBitmap, tempMatrix, paint);
                        drawText(canvas, i, j, top, left);
                        break;
                    case SEAT_TYPE_SOLD:
                        canvas.drawBitmap(seatSoldBitmap, tempMatrix, paint);
                        drawText(canvas, i, j, top, left);
                        break;
                }
            }
        }

        if (DBG) {
            long drawTime = System.currentTimeMillis() - startTime;
            Log.d("drawTime", "seatDrawTime:" + drawTime);
        }
    }

    private int getSeatType(int row, int column) {

        if (seatChecker != null) {
            if (!seatChecker.isValidSeat(row, column)) {
                return SEAT_TYPE_NOT_AVAILABLE;
            } else if (seatChecker.isSold(row, column)) {
                return SEAT_TYPE_SOLD;
            } else if (seatChecker.isOrder(row, column)) {
                return SEAT_TYPE_ORDER;
            }
        }

        return SEAT_TYPE_AVAILABLE;
    }

    /**
     * 绘制选中座位的行号列号
     *
     * @param row
     * @param column
     */
    private void drawText(Canvas canvas, int row, int column, float top, float left) {
        String txt = "";
        if (textList != null)
            txt = textList.get(row).get(column);

        TextPaint txtPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        txtPaint.setColor(txt_color);
        txtPaint.setTypeface(Typeface.DEFAULT_BOLD);
        txtPaint.setTextSize(seatHeight / 3);

        float txtWidth = txtPaint.measureText(txt);
        float startX = left + seatWidth / 2 - txtWidth / 2;

        canvas.drawText(txt, startX, getBaseLine(txtPaint, top, top + seatHeight), txtPaint);

        if (DBG) {
            Log.d("drawTest:", "top:" + top);
        }
    }

    int bacColor = Color.parseColor("#727272");

    /**
     * 绘制行号
     */
    void drawNumber(Canvas canvas) {
        long startTime = System.currentTimeMillis();
        int translateY = (int) getTranslateY();

        Matrix matrix1 = new Matrix();

        for (int i = 0; i < row; i++) {
            float left = 0;
            float top = i * seatHeight + i * verSpacing + translateY;
            float bottom = i * seatHeight + i * verSpacing + seatHeight + translateY;
            float baseline = (bottom + top - lineNumberPaintFontMetrics.bottom - lineNumberPaintFontMetrics.top) / 2;

            matrix1.setTranslate(left, top);
            matrix1.postScale(mScaleX, mScaleX, left, top);
            canvas.drawBitmap(floorBitmap, matrix1, paint);
            canvas.drawText(lineNumbers.get(i), numberWidth / 2, baseline, lineNumberPaint);
        }

        if (DBG) {
            long drawTime = System.currentTimeMillis() - startTime;
            Log.d("drawTime", "drawNumberTime:" + drawTime);
        }
    }

    /**
     * 自动回弹
     * 整个大小不超过控件大小的时候:
     * 往左边滑动,自动回弹到行号右边
     * 往右边滑动,自动回弹到右边
     * 往上,下滑动,自动回弹到顶部
     * <p>
     * 整个大小超过控件大小的时候:
     * 往左侧滑动,回弹到最右边,往右侧滑回弹到最左边
     * 往上滑动,回弹到底部,往下滑动回弹到顶部
     */
    private void autoScroll() {
        float currentSeatBitmapWidth = seatBitmapWidth;
        float currentSeatBitmapHeight = seatBitmapHeight;
        float moveYLength = 0;
        float moveXLength = 0;

        //处理左右滑动的情况
        if (currentSeatBitmapWidth < getWidth()) {
            if (getTranslateX() < 0) {
                //计算要移动的距离

                if (getTranslateX() < 0) {
                    moveXLength = (-getTranslateX()) + numberWidth + spacing;
                } else {
                    moveXLength = numberWidth + spacing - getTranslateX();
                }

            }
        } else {

            if (getTranslateX() < 0 && getTranslateX() + currentSeatBitmapWidth > getWidth()) {

            } else {
                //往左侧滑动
                if (getTranslateX() + currentSeatBitmapWidth < getWidth()) {
                    moveXLength = getWidth() - (getTranslateX() + currentSeatBitmapWidth);
                } else {
                    //右侧滑动
                    moveXLength = -getTranslateX() + numberWidth + spacing;
                }
            }

        }

        float startYPosition = verSpacing;

        //处理上下滑动
        if (currentSeatBitmapHeight < getHeight()) {

            if (getTranslateY() < startYPosition) {
                moveYLength = startYPosition - getTranslateY();
            } else {
                moveYLength = -(getTranslateY() - (startYPosition));
            }

        } else {

            if (getTranslateY() < 0 && getTranslateY() + currentSeatBitmapHeight > getHeight()) {

            } else {
                //往上滑动
                if (getTranslateY() + currentSeatBitmapHeight < getHeight()) {
                    moveYLength = getHeight() - (getTranslateY() + currentSeatBitmapHeight);
                } else {
                    moveYLength = -(getTranslateY() - (startYPosition));
                }
            }
        }

        Point start = new Point();
        start.x = (int) getTranslateX();
        start.y = (int) getTranslateY();

        Point end = new Point();
        end.x = (int) (start.x + moveXLength);
        end.y = (int) (start.y + moveYLength);

        moveAnimate(start, end);

    }

    float[] m = new float[9];

    private float getTranslateX() {
        matrix.getValues(m);
        return m[2];
    }

    private float getTranslateY() {
        matrix.getValues(m);
        return m[5];
    }

    private float dip2Px(float value) {
        return getResources().getDisplayMetrics().density * value;
    }

    private float getBaseLine(Paint p, float top, float bottom) {
        Paint.FontMetrics fontMetrics = p.getFontMetrics();
        int baseline = (int) ((bottom + top - fontMetrics.bottom - fontMetrics.top) / 2);
        return baseline;
    }

    private void moveAnimate(Point start, Point end) {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new MoveEvaluator(), start, end);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        MoveAnimation moveAnimation = new MoveAnimation();
        valueAnimator.addUpdateListener(moveAnimation);
        valueAnimator.setDuration(400);
        valueAnimator.start();
    }

    private void move(Point p) {
        float x = p.x - getTranslateX();
        float y = p.y - getTranslateY();
        matrix.postTranslate(x, y);
        invalidate();
    }

    class MoveAnimation implements ValueAnimator.AnimatorUpdateListener {

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            Point p = (Point) animation.getAnimatedValue();

            move(p);
        }
    }

    class MoveEvaluator implements TypeEvaluator {

        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            Point startPoint = (Point) startValue;
            Point endPoint = (Point) endValue;
            int x = (int) (startPoint.x + fraction * (endPoint.x - startPoint.x));
            int y = (int) (startPoint.y + fraction * (endPoint.y - startPoint.y));
            return new Point(x, y);
        }
    }


    public void setData(int row, int column) {
        this.row = row;
        this.column = column;
        init();
        invalidate();
    }

    public void setText(ArrayList<ArrayList<String>> textList) {
        this.textList = textList;
    }

    public void setSeatSize(int width, int height) {
        this.defaultImgW = width;
        this.defaultImgH = height;
    }

    GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            isOnClick = true;
            int x = (int) e.getX();
            int y = (int) e.getY();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    int tempX = (int) (j * seatWidth + j * spacing + getTranslateX());
                    int maxTemX = tempX + seatWidth;

                    int tempY = (int) ((i * seatHeight + i * verSpacing) + getTranslateY());
                    int maxTempY = tempY + seatHeight;

                    if (seatChecker != null && seatChecker.isValidSeat(i, j) && !seatChecker.isSold(i, j) && !seatChecker.isOrder(i, j)) {
                        if (x >= tempX && x <= maxTemX && y >= tempY && y <= maxTempY) {
                            if (seatChecker != null) {
                                seatChecker.checked(i, j);
                            }
                            break;
                        }
                    }
                }
            }

            return super.onSingleTapConfirmed(e);
        }
    });

    public interface SeatChecker {
        /**
         * 是否可选
         *
         * @param row
         * @param column
         * @return
         */
        boolean isValidSeat(int row, int column);

        /**
         * 是否预定
         *
         * @param row
         * @param column
         * @return
         */
        boolean isOrder(int row, int column);

        /**
         * 是否已售
         *
         * @param row
         * @param column
         * @return
         */
        boolean isSold(int row, int column);

        void checked(int row, int column);

    }

    public void setSeatChecker(SeatChecker seatChecker) {
        this.seatChecker = seatChecker;
        invalidate();
    }
}

