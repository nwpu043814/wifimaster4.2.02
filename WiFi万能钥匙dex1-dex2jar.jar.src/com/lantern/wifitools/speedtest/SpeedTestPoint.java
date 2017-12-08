package com.lantern.wifitools.speedtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import com.lantern.wifitools.R.drawable;

public class SpeedTestPoint
  extends View
{
  private float a;
  private int b;
  private Paint c;
  private Bitmap d;
  private int e;
  
  public SpeedTestPoint(Context paramContext)
  {
    super(paramContext);
  }
  
  public SpeedTestPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SpeedTestPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a()
  {
    if ((this.d != null) && (!this.d.isRecycled())) {
      this.d.recycle();
    }
    this.d = null;
  }
  
  public final void a(float paramFloat)
  {
    this.a = paramFloat;
    postInvalidate();
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredWidth() / 2;
    if (this.c == null)
    {
      this.c = new Paint();
      this.c.setAntiAlias(true);
    }
    if (((this.d == null) || (this.d.isRecycled())) && (this.b != 0)) {}
    for (this.d = BitmapFactory.decodeResource(getResources(), this.b);; this.d = BitmapFactory.decodeResource(getResources(), R.drawable.wifispeed_blueline)) {
      do
      {
        Bitmap localBitmap = this.d;
        paramCanvas.save();
        paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        paramCanvas.rotate(this.a, i, i);
        paramCanvas.drawBitmap(localBitmap, this.e, this.e, this.c);
        paramCanvas.restore();
        return;
      } while ((this.d != null) && (!this.d.isRecycled()));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/speedtest/SpeedTestPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */