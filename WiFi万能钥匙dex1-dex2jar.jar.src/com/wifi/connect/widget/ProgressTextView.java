package com.wifi.connect.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.lantern.connect.R.color;

public class ProgressTextView
  extends TextView
{
  private LinearGradient a;
  private Matrix b;
  private int c = 0;
  private boolean d = false;
  private Runnable e = null;
  private long f;
  private float g;
  private float h;
  private String i;
  private float j = 0.0F;
  
  public ProgressTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProgressTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProgressTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    this.e = new c(this);
    postDelayed(this.e, 50L);
  }
  
  public final void a()
  {
    this.d = true;
    if (this.e == null)
    {
      this.f = System.nanoTime();
      c();
    }
  }
  
  public final void a(String paramString)
  {
    super.setText(paramString);
    if (!getText().toString().equals(this.i))
    {
      this.g = 0.0F;
      this.h = getPaint().measureText(getText().toString());
    }
    this.i = getText().toString();
  }
  
  public final void b()
  {
    this.d = false;
    if (this.e != null)
    {
      removeCallbacks(this.e);
      this.e = null;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.drawColor(getResources().getColor(R.color.main_blue));
    TextPaint localTextPaint = getPaint();
    if (this.d) {}
    for (LinearGradient localLinearGradient = this.a;; localLinearGradient = null)
    {
      localTextPaint.setShader(localLinearGradient);
      if (this.d)
      {
        int k = (int)((System.nanoTime() - this.f) % 1000000000L * (this.c * 2) / 1000000000L);
        this.b.setTranslate(k, 0.0F);
        this.a.setLocalMatrix(this.b);
        if (this.e == null) {
          c();
        }
      }
      paramCanvas.drawText(getText().toString(), this.g, getTextSize() + getPaddingTop(), getPaint());
      return;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c != getMeasuredWidth())
    {
      this.c = getMeasuredWidth();
      float f1 = -this.c;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.a = new LinearGradient(f1, 0.0F, 0.0F, 0.0F, new int[] { 872415231, -1, 872415231 }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
      this.b = new Matrix();
    }
    setClickable(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
    case 0: 
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.j = paramMotionEvent.getRawX();
      }
    }
    float f3 = paramMotionEvent.getRawX();
    float f2 = this.g;
    f2 = f3 - this.j + f2;
    f3 = this.h - getWidth();
    if (f2 < -f3) {
      f1 = -f3;
    }
    for (;;)
    {
      this.g = f1;
      invalidate();
      break;
      if (f2 <= 0.0F) {
        f1 = f2;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/ProgressTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */