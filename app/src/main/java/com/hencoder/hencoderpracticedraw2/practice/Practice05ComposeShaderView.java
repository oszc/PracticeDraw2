package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.hencoder.hencoderpracticedraw2.R;

public class Practice05ComposeShaderView extends PracticeView{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    ComposeShader mComposeShader;
    BitmapShader mBmpShaderSrc;
    BitmapShader mBmpShaderDst;
    Bitmap mBitmapSrc = null;
    Bitmap mBitmapDst = null;


    public Practice05ComposeShaderView(Context context) {
        super(context);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {

        mBitmapSrc= BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mBitmapDst= BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);

        mBmpShaderSrc = new BitmapShader(mBitmapSrc, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mBmpShaderDst = new BitmapShader(mBitmapDst, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        mComposeShader = new ComposeShader(mBmpShaderDst,mBmpShaderSrc, PorterDuff.Mode.SRC_IN);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setShader(mComposeShader);

        canvas.drawCircle(200, 200, 200, paint);
    }
}
