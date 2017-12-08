package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import com.lantern.feed.R.dimen;
import com.lantern.feed.R.drawable;
import com.lantern.feed.b.r;
import com.lantern.feed.d.d;

public final class cc
  extends View
{
  private static float d;
  private static float e;
  public r a;
  public Paint b = new Paint();
  private Rect c = new Rect();
  private float f;
  private float g;
  
  public cc(Context paramContext)
  {
    super(paramContext);
    this.b.setAntiAlias(true);
    this.b.setTextAlign(Paint.Align.CENTER);
    setBackgroundResource(R.drawable.feed_tag_bg);
  }
  
  public final void a(r paramr)
  {
    this.a = paramr;
    float f1;
    float f2;
    if (this.a.d() != 0)
    {
      this.b.setTextSize(getResources().getDimension(R.dimen.feed_tag_small_text_size));
      if (d == 0.0F) {
        d = d.b(getContext(), 1.0F);
      }
      if (e == 0.0F) {
        e = d.b(getContext(), 5.0F);
      }
      this.b.setColor(paramr.b());
      this.b.setAlpha((int)(this.a.h() * 255.0D));
      f1 = this.b.measureText(this.a.a());
      f2 = (float)Math.ceil(this.b.getFontMetrics().descent - this.b.getFontMetrics().ascent);
      if (this.a.d() == 0) {
        break label339;
      }
      float f4 = e;
      float f3 = d;
      f1 += f4;
      f2 += f3;
    }
    label256:
    label332:
    label339:
    for (;;)
    {
      paramr = getBackground();
      if ((paramr instanceof GradientDrawable))
      {
        paramr = (GradientDrawable)paramr;
        int i = this.a.c();
        paramr.setColor(i);
        if (i != 0) {
          paramr.setAlpha((int)(this.a.h() * 255.0D));
        }
        if (this.a.d() == 0) {
          paramr.setStroke(d.a(getContext(), 0.5F), this.a.c());
        }
      }
      else
      {
        if ((f2 == this.g) && (f1 == this.f)) {
          break label332;
        }
        this.g = f2;
        this.f = f1;
        requestLayout();
      }
      for (;;)
      {
        return;
        this.b.setTextSize(getResources().getDimension(R.dimen.feed_tag_text_size));
        break;
        paramr.setStroke(d.a(getContext(), 0.5F), this.a.d());
        break label256;
        postInvalidate();
      }
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.a())))
    {
      this.c.set(0, 0, getWidth(), getHeight());
      Paint.FontMetricsInt localFontMetricsInt = this.b.getFontMetricsInt();
      float f2 = this.c.top;
      float f1 = (this.g - (float)Math.ceil(localFontMetricsInt.descent - localFontMetricsInt.ascent)) / 2.0F;
      float f3 = localFontMetricsInt.ascent;
      paramCanvas.drawText(this.a.a(), this.c.centerX(), f2 + f1 - f3, this.b);
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension((int)this.f, (int)this.g);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */