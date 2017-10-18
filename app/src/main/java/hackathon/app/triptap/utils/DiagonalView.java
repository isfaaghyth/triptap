package hackathon.app.triptap.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import hackathon.app.triptap.R;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public class DiagonalView extends View {

    private Paint bgPaint;

    public DiagonalView(Context context) {
        super(context);
        init();
    }

    public DiagonalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DiagonalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        bgPaint = new Paint();
        bgPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(getResources().getColor(R.color.colorPrimary));
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int h = getMeasuredHeight();
        int w = getMeasuredWidth();

        Path path = new Path();
        path.lineTo(w, 0);
        path.lineTo(w, h - 120);
        path.lineTo(0, h/1.5f);
        path.close();
        canvas.drawPath(path,bgPaint);
    }
}
