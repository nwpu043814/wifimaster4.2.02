package com.lantern.traffic.statistics.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.lantern.settings.R.drawable;

public class WaveView
  extends View
{
  private Drawable a;
  private int b;
  private int c;
  private int d;
  private float e;
  private long f;
  private long g;
  private long h;
  private boolean i;
  private boolean j;
  private int k;
  
  public WaveView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public WaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = getResources().getDrawable(R.drawable.traffic_ic_statistics_banner_bg);
    this.b = this.a.getIntrinsicWidth();
    this.c = this.a.getIntrinsicHeight();
    this.d = (-(int)(Math.random() * this.b));
    this.k = 0;
  }
  
  public final void a(int paramInt)
  {
    this.i = true;
    this.h = paramInt;
    paramInt = getWidth();
    if (paramInt > 0)
    {
      this.e = (paramInt / (float)this.h);
      this.f = SystemClock.elapsedRealtime();
      this.j = true;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.g == 0L) {
      this.g = this.f;
    }
    int i1 = getWidth();
    long l = SystemClock.elapsedRealtime();
    int n = (int)(l - this.g);
    int m = n;
    if (n > 100) {
      m = 10;
    }
    n = this.d;
    float f1 = this.e;
    this.d = ((int)(m * f1) + n);
    if (this.d >= 0) {
      this.d = (-this.b);
    }
    int i2 = this.d;
    m = this.b + this.d;
    n = this.c;
    this.a.setBounds(i2, 0, m, n);
    this.a.draw(paramCanvas);
    while ((i1 > 0) && (m < i1))
    {
      i2 = m - this.k;
      m = this.b + i2;
      this.a.setBounds(i2, 0, m, n);
      this.a.draw(paramCanvas);
    }
    this.g = l;
    if (this.i) {
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (n != 1073741824) {
      paramInt1 = this.b;
    }
    if (m != 1073741824) {
      paramInt2 = this.c;
    }
    setMeasuredDimension(paramInt1, paramInt2);
    paramInt1 = getWidth();
    if ((paramInt1 > 0) && (this.i) && (!this.j))
    {
      this.e = (paramInt1 / (float)this.h);
      this.f = SystemClock.elapsedRealtime();
      this.j = true;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/ui/widget/WaveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */