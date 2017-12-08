package com.wifipay.wallet.home.bill;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class CustomView
  extends ImageView
{
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_INSIDE;
  private static float b = 0.5F;
  private RectF c = new RectF();
  private float d = 0.0F;
  private Paint e;
  private Paint f;
  
  public CustomView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CustomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CustomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    super.setScaleType(a);
    this.e = new Paint();
    this.e.setStyle(Paint.Style.FILL);
    this.e.setAntiAlias(true);
    this.e.setColor(-1);
    this.f = new Paint();
    this.f.setStyle(Paint.Style.FILL);
    this.f.setAntiAlias(true);
    this.f.setColor(-1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {}
    for (;;)
    {
      return;
      float f1 = getWidth() / 2.0F;
      paramCanvas.drawCircle(f1, f1, getWidth() / 2.0F, this.f);
      f1 = (float)Math.asin(b - this.d) * 180.0F;
      paramCanvas.drawArc(this.c, f1, 2.0F * (90.0F - f1), false, this.e);
      super.onDraw(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    float f2 = getWidth() / 2.0F;
    float f1 = getWidth() / 2.0F;
    this.c.set(f2 - f1, f2 - f1, f2 + f1, f2 + f1);
  }
  
  public void setFillColor(int paramInt)
  {
    if (-1 != paramInt)
    {
      this.e.setColor(paramInt);
      invalidate();
    }
  }
  
  public void setPullScale(float paramFloat)
  {
    if (paramFloat < 0.0D) {
      paramFloat = 0.0F;
    }
    for (;;)
    {
      float f1 = paramFloat;
      if (paramFloat > 1.0D) {
        f1 = 1.0F;
      }
      if (this.d != f1)
      {
        this.d = f1;
        invalidate();
      }
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/CustomView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */