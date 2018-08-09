package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.hencoder.hencoderpracticedraw2.R;

public class Practice04BitmapShaderView extends PracticeView{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    BitmapShader mBmpShader;
    Bitmap mBitmap = null;

    public Practice04BitmapShaderView(Context context) {
        super(context);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mBmpShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);


    }

    {
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setShader(mBmpShader);
        canvas.drawCircle(200, 200, 200, paint);
    }
}
