package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.hencoder.hencoderpracticedraw2.R;

public class Practice07ColorMatrixColorFilterView extends PracticeView{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    ColorMatrixColorFilter filter;
    Bitmap bitmap;

    public Practice07ColorMatrixColorFilterView(Context context) {
        super(context);
    }

    public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice07ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        filter = new ColorMatrixColorFilter(matrix);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

        // 使用 setColorFilter() 设置一个 ColorMatrixColorFilter
        // 用 ColorMatrixColorFilter.setSaturation() 把饱和度去掉
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColorFilter(filter);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
