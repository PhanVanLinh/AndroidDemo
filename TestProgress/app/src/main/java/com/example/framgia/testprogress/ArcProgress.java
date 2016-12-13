package com.example.framgia.testprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class ArcProgress extends View {
    private final String SUFFIX_TEXT = "%";
    private final int DEFAULT_PROGRESS = 0;
    private final int DEFAULT_MAX_PROGRESS = 100;
    private int width;
    private int height;

    // Paint
    private Paint surroundPaint;
    private Paint progressUnfinishedPaint;
    private Paint progressFinishedPaint;
    protected Paint textTitlePaint;
    protected Paint textProgressPaint;
    protected Paint textDescriptionPaint;
    protected Paint bottomImagePaint;
    private  Paint pointImagePaint;

    // Rect
    private RectF rectFProgress = new RectF();
    private RectF rectFSurround = new RectF();

    // Surround line
    private float surroundStrokeWidth;

    // Progress
    private float progressStrokeWidth;
    private float progressPadding;
    private float textProgressSize;
    private int textProgressColor;
    private int unfinishedStrokeColor;
    private float arcAngle;
    private int progress;
    private int max;

    // Text Title
    private String textTitle;
    private float textTitleSize;
    private int textTitleColor;
    private float textTitleMarginBottom;

    // Text Description
    private String textDescription;
    private float textDescriptionSize;
    private int textDescriptionColor;
    private float textDescriptionMarginTop;

    // Image bottom
    private Bitmap bitmapBottom;
    private float imageBottomWidth;
    private float imageBottomHeight;
    private float imageBottomMarginBottom;

    // Image point
    private Bitmap bitmapPoint;
    private float imagePointWidth;
    private float imagePointHeight;

    public ArcProgress(Context context) {
        this(context, null);
    }

    public ArcProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ArcProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        defaultConfig();

        initBitmap();
        initPainters();

        initByAttributeSet(context, attrs, defStyleAttr);
    }

    private void defaultConfig() {
        textTitle = "目標歩数";
        textDescription = "6025 steps";

        arcAngle = (int) 360 * 0.8f;

        surroundStrokeWidth = getContext().getResources().getDimension(R.dimen.dp_2);
        progressStrokeWidth = getContext().getResources().getDimension(R.dimen.dp_10);
        progressPadding = getContext().getResources().getDimension(R.dimen.dp_10);

        textProgressColor = Color.WHITE;
        textTitleColor = Color.DKGRAY;
        textDescriptionColor = Color.RED;

        textProgressSize = getContext().getResources().getDimension(R.dimen.sp_18);
        textTitleSize = getContext().getResources().getDimension(R.dimen.sp_14);
        textDescriptionSize = getDimension(R.dimen.sp_14);

        textTitleMarginBottom = getDimension(R.dimen.dp_36);
        textDescriptionMarginTop = getDimension(R.dimen.dp_20);

        imageBottomWidth = getDimension(R.dimen.dp_34);
        imageBottomHeight = getDimension(R.dimen.dp_38);
        imageBottomMarginBottom = getDimension(R.dimen.dp_1);

        imagePointWidth = getDimension(R.dimen.dp_20);
        imagePointHeight = getDimension(R.dimen.dp_20);

        unfinishedStrokeColor = Color.DKGRAY;
    }

    private void initByAttributeSet(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray attributes = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.ArcProgress, defStyleAttr, 0);

        setMax(attributes.getInt(R.styleable.ArcProgress_arc_max, DEFAULT_MAX_PROGRESS));
        setProgress(attributes.getInt(R.styleable.ArcProgress_arc_progress, DEFAULT_PROGRESS));
        attributes.recycle();
    }

    private void initBitmap() {
        bitmapPoint =
                BitmapFactory.decodeResource(getContext().getResources(), R.drawable.dummy_point);
        bitmapBottom = BitmapFactory.decodeResource(getContext().getResources(),
                R.drawable.dummy_progress_foot);
    }

    private float getDimension(int dimenId) {
        return getContext().getResources().getDimension(dimenId);
    }

    protected void initPainters() {
        surroundPaint = new Paint();
        surroundPaint.setAntiAlias(true);
        surroundPaint.setStrokeWidth(2);
        surroundPaint.setStyle(Paint.Style.STROKE);
        surroundPaint.setStrokeCap(Paint.Cap.ROUND);

        progressUnfinishedPaint = new Paint();
        progressUnfinishedPaint.setAntiAlias(true);
        progressUnfinishedPaint.setStrokeWidth(progressStrokeWidth);
        progressUnfinishedPaint.setStyle(Paint.Style.STROKE);
        progressUnfinishedPaint.setStrokeCap(Paint.Cap.ROUND);

        progressFinishedPaint = new Paint();
        progressFinishedPaint.setAntiAlias(true);
        progressFinishedPaint.setStrokeWidth(progressStrokeWidth);
        progressFinishedPaint.setStyle(Paint.Style.STROKE);
        progressFinishedPaint.setStrokeCap(Paint.Cap.ROUND);

        textTitlePaint = new TextPaint();
        textTitlePaint.setColor(textTitleColor);
        textTitlePaint.setTextSize(textTitleSize);
        textTitlePaint.setAntiAlias(true);

        textProgressPaint = new TextPaint();
        textProgressPaint.setColor(textProgressColor);
        textProgressPaint.setTextSize(textProgressSize);
        textProgressPaint.setAntiAlias(true);

        textDescriptionPaint = new TextPaint();
        textDescriptionPaint.setColor(textDescriptionColor);
        textDescriptionPaint.setTextSize(textDescriptionSize);
        textDescriptionPaint.setAntiAlias(true);

        bottomImagePaint = new TextPaint();
        bottomImagePaint.setAntiAlias(true);

        pointImagePaint = new Paint();
        pointImagePaint.setAntiAlias(true);
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    public int getProgress() {
        return progress;
    }

    public String getProgressInString() {
        return progress + SUFFIX_TEXT;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        if (this.progress > max) {
            this.progress = max;
        }
        invalidate();
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        if (max > 0) {
            this.max = max;
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        rectFSurround.set(surroundStrokeWidth / 2f, surroundStrokeWidth / 2f,
                width - surroundStrokeWidth / 2f, height - surroundStrokeWidth / 2f);

        rectFProgress.set(progressStrokeWidth / 2f + progressPadding,
                progressStrokeWidth / 2f + progressPadding,
                width - progressStrokeWidth / 2f - progressPadding,
                height - progressStrokeWidth / 2f - progressPadding);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float startAngle = 270 - arcAngle / 2f;
        float finishedSweepAngle = (int)(progress / (float) getMax() * arcAngle);

        drawSurroundArcLine(canvas, startAngle);

        drawUnFinishedArcProgress(canvas, startAngle);

        drawFinishedArcProgress(canvas, startAngle, finishedSweepAngle);

        float textProgressBaseline =
                height / 2 - (textProgressPaint.ascent() + textProgressPaint.descent()) / 2;
        drawTextInCenterHorizontal(canvas, getProgressInString(), textProgressPaint,
                textProgressBaseline);

        // For draw text title
        float textTitleBaseline = textProgressBaseline - textTitleMarginBottom;
        drawTextInCenterHorizontal(canvas, textTitle, textTitlePaint, textTitleBaseline);

        // For draw text description
        float textDescriptionBaseline = textProgressBaseline + textDescriptionMarginTop;
        drawTextInCenterHorizontal(canvas, textDescription, textDescriptionPaint,
                textDescriptionBaseline);

        drawBottomImage(canvas);

        drawPoint(canvas, startAngle, finishedSweepAngle);

        // For testing
//        try {
//            Thread.sleep(500);
//            progress += 1;
//            invalidate();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private void drawSurroundArcLine(Canvas canvas, float startAngle) {
        canvas.drawArc(rectFSurround, startAngle, arcAngle, false, surroundPaint);
    }

    private void drawUnFinishedArcProgress(Canvas canvas, float startAngle) {
        progressUnfinishedPaint.setColor(unfinishedStrokeColor);
        canvas.drawArc(rectFProgress, startAngle, arcAngle, false, progressUnfinishedPaint);
    }

    private void drawFinishedArcProgress(Canvas canvas, float startAngle,
            float finishedSweepAngle) {
        int[] colors = { Color.parseColor("#4fbdb5"), Color.parseColor("#bd3c49") };
        float[] positions = { 0, 1 };
        SweepGradient gradient = new SweepGradient(width / 2, height / 2, colors, positions);

        Matrix matrix = new Matrix();
        matrix.setRotate(90, width / 2, height / 2);
        gradient.setLocalMatrix(matrix);
//        progressFinishedPaint.setStyle(Paint.Style.FILL);
        progressFinishedPaint.setShader(gradient);

        canvas.drawArc(rectFProgress, startAngle, finishedSweepAngle, false, progressFinishedPaint);
    }

    private void drawTextInCenterHorizontal(Canvas canvas, String text, Paint paint,
            float baseline) {
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, width / 2.0f, baseline, paint);
    }

    private void drawBottomImage(Canvas canvas) {
        float left = (width - imageBottomWidth) / 2.0f;
        float top = height - imageBottomHeight - imageBottomMarginBottom;
        RectF dst = new RectF(left, top, left + imageBottomWidth, top + imageBottomHeight);
        canvas.drawBitmap(bitmapBottom, null, dst, null);
    }

    private void drawPoint(Canvas canvas, float startAngle, float finishedSweepAngle) {
        float radius = width / 2f - progressPadding - progressStrokeWidth/2;

        Point point = calculateXy(startAngle + finishedSweepAngle, radius);

        float top = height / 2 + point.getY() - imagePointHeight / 2;
        float left = width / 2 + point.getX() - imagePointWidth / 2;

        RectF imagePointDst = new RectF(left, top, left + imagePointWidth, top + imagePointHeight);
        canvas.drawBitmap(bitmapPoint, null, imagePointDst, null);
    }

    private Point calculateXy(float angle, float radius) {
        float x = 0, y = 0;
        if (angle > 360) {
            angle = angle % 360;
        }
        if (angle <= 90) {
            x = (float) Math.cos(Math.toRadians(angle)) * radius;
            y = (float) Math.sin(Math.toRadians(angle)) * radius;
        } else if (angle <= 180) {
            x = (float) -(Math.cos(Math.toRadians(180 - angle)) * radius);
            y = (float) Math.sin(Math.toRadians(180 - angle)) * radius;
        } else if (angle <= 270) {
            x = (float) -(Math.cos(Math.toRadians(angle - 180)) * radius);
            y = (float) -(Math.sin(Math.toRadians(angle - 180)) * radius);
        } else if (angle <= 360) {
            x = (float) Math.cos(Math.toRadians(360 - angle)) * radius;
            y = (float) -(Math.sin(Math.toRadians(360 - angle)) * radius);
        }
        return new Point(x, y);
    }

    /*
     * This method is not using yet
     */
    public int getTextHeight(Paint paint, String text) {
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, 1, bounds);
        int height = bounds.bottom + bounds.height();
        return height;
    }

    private class Point {
        private float x;
        private float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
    }
}
