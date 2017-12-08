package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.text.TextUtils;
import android.view.View;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.d.d;

public final class ck
  extends View
{
  private Paint a = new Paint();
  private Paint b;
  private String c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private int i;
  private float j;
  private float k;
  private Path l;
  
  public ck(Context paramContext)
  {
    super(paramContext);
    this.a.setAntiAlias(true);
    this.a.setTextSize(d.b(paramContext, 10.0F));
    this.a.setColor(getResources().getColor(R.color.white));
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setColor(getResources().getColor(R.color.white));
    this.d = ((float)Math.ceil(this.a.getFontMetrics().descent - this.a.getFontMetrics().ascent));
    this.f = this.a.getFontMetrics().descent;
    this.g = d.b(paramContext, 3.0F);
    this.h = d.b(paramContext, 7.0F);
    this.i = d.a(paramContext, 20.0F);
    this.j = d.b(paramContext, 5.0F);
    this.k = d.b(paramContext, 7.0F);
    this.l = new Path();
    setBackgroundResource(R.drawable.feed_video_time_bg);
  }
  
  public final void a(String paramString)
  {
    this.c = paramString;
    if (!TextUtils.isEmpty(this.c)) {
      this.e = this.a.measureText(this.c);
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    if (!TextUtils.isEmpty(this.c))
    {
      int m = getHeight();
      float f1 = (m - this.k) / 2.0F;
      this.l.moveTo(this.h, f1);
      this.l.lineTo(this.h + this.j, this.k / 2.0F + f1);
      this.l.lineTo(this.h, f1 + this.k);
      this.l.close();
      paramCanvas.drawPath(this.l, this.b);
      float f6 = this.h;
      float f2 = this.j;
      float f3 = this.g;
      float f4 = m;
      float f5 = (m - this.d) / 2.0F;
      f1 = this.f;
      paramCanvas.drawText(this.c, f6 + f2 + f3, f4 - f5 - f1, this.a);
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = 0;
    if (!TextUtils.isEmpty(this.c))
    {
      paramInt2 = (int)(this.j + this.e + this.g + this.h * 2.0F);
      paramInt1 = this.i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */