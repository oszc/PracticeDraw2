package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.hencoder.hencoderpracticedraw2.R;

public class Practice06LightingColorFilterView extends PracticeView{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    LightingColorFilter removeRedFilter;
    LightingColorFilter enhanceGreenFilter;

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        removeRedFilter = new LightingColorFilter(0x00ffff,0);
        enhanceGreenFilter = new LightingColorFilter(0xffffff,0x002000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

        // 第一个 LightingColorFilter：去掉红色部分
        paint.setColorFilter(removeRedFilter);
        canvas.drawBitmap(bitmap, 0, 0, paint);

        // 第二个 LightingColorFilter：增强绿色部分
        paint.setColorFilter(enhanceGreenFilter);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
