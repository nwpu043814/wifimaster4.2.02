package com.lantern.wifitools.speedtest;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.wifitools.R.color;
import com.lantern.wifitools.R.styleable;
import com.lantern.wifitools.examination.r;

public class SpeedProgressBar
  extends View
{
  private Paint a;
  private float b;
  private int c;
  private float d;
  private boolean e = false;
  private float f = 0.0F;
  private boolean g = false;
  private boolean h = false;
  private TextView i;
  private TextView j;
  private SpeedTestPoint k;
  private int l = 0;
  private Context m;
  private int n;
  private Bundle o;
  private RectF p;
  
  public SpeedProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SpeedProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.m = paramContext;
  }
  
  public SpeedProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.m = paramContext;
    this.a = new Paint();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SpeedProgressBar);
    this.c = paramContext.getInteger(5, 270);
    this.n = ((int)(this.m.getResources().getDisplayMetrics().density * 109.0F));
    this.b = ((int)(this.m.getResources().getDisplayMetrics().density * 45.0F));
    this.p = new RectF();
    paramContext.recycle();
  }
  
  private long b()
  {
    long l1;
    if (this.d >= 270.0F) {
      l1 = 10485760L;
    }
    for (;;)
    {
      h.a("getSpeedValue mSweep:" + this.d + " value:" + l1, new Object[0]);
      return l1;
      if (this.d >= 216.0F) {
        l1 = (1048576.0F + (this.d - 216.0F) * 9437184.0F / 54.0F);
      } else if (this.d >= 162.0F) {
        l1 = ((this.d - 162.0F) * 587776.0F / 54.0F + 460800.0F);
      } else {
        l1 = (this.d * 460800.0F / 162.0F);
      }
    }
  }
  
  public final void a()
  {
    if (this.k != null) {
      this.k.a();
    }
  }
  
  public final void a(double paramDouble, SpeedTestPoint paramSpeedTestPoint, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramDouble < 0.0D) {
      return;
    }
    for (;;)
    {
      float f1;
      try
      {
        this.k = paramSpeedTestPoint;
        this.g = paramBoolean;
        if (paramDouble > 1.048576E7D)
        {
          f1 = 270.0F;
          paramSpeedTestPoint = new java/lang/StringBuilder;
          paramSpeedTestPoint.<init>("getProgress inputValue:");
          h.a(paramDouble + " progress:" + f1, new Object[0]);
          float f2 = f1;
          if (f1 > this.c) {
            f2 = this.c;
          }
          if (f2 <= this.c)
          {
            this.f = f2;
            if (this.f > this.d) {
              bool = true;
            }
            this.e = bool;
            if (!paramBoolean) {
              this.h = false;
            }
          }
          invalidate();
          break;
        }
      }
      finally {}
      if (paramDouble > 1048576.0D) {
        f1 = (float)(216.0D + (paramDouble - 1048576.0D) * 54.0D / 9437184.0D);
      } else if (paramDouble > 460800.0D) {
        f1 = (float)((paramDouble - 460800.0D) * 54.0D / 587776.0D + 162.0D);
      } else {
        f1 = (float)(paramDouble * 162.0D / 460800.0D);
      }
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    this.o = paramBundle;
  }
  
  public final void a(TextView paramTextView1, TextView paramTextView2)
  {
    this.g = false;
    this.d = 0.0F;
    this.f = 0.0F;
    this.i = paramTextView1;
    this.i.setText("");
    this.j = paramTextView2;
    this.j.setText("");
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getWidth() / 2;
    this.a.setColor(getResources().getColor(R.color.test_speed_color_progress));
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.b);
    this.a.setAntiAlias(true);
    this.p.set(i1 - this.n, i1 - this.n, this.n + i1, i1 + this.n);
    paramCanvas.drawArc(this.p, 45.0F, -(270.0F - this.d), false, this.a);
    if (this.k != null) {
      this.k.a(this.d);
    }
    if ((this.d > 0.0F) && (((this.i != null) && (this.l % 5 == 0)) || (this.h)))
    {
      String str = r.a((int)b() / 1024, this.m);
      paramCanvas = str.substring(0, str.length() - 3);
      str = str.substring(str.length() - 3, str.length());
      this.i.setText(paramCanvas);
      this.j.setText(str);
      if ((this.h) && (this.o != null)) {
        this.o.putInt("speed", (int)b() / 1024);
      }
      this.l = 0;
    }
    if (!this.h) {
      if (this.e)
      {
        this.d += 2.0F;
        if ((this.d > this.f) || (this.d >= 270.0F)) {
          this.e = false;
        }
        if (!this.g) {
          break label462;
        }
        if (this.d != this.f) {
          break label411;
        }
      }
    }
    for (;;)
    {
      return;
      this.d = ((float)(this.d - 0.1D));
      if (this.d >= 0.0F) {
        break;
      }
      this.d = 0.0F;
      break;
      if (this.d == this.f) {
        break;
      }
      if (this.e)
      {
        this.d += 2.0F;
        break;
      }
      this.d -= 2.0F;
      break;
      label411:
      if (((!this.e) && (this.d < this.f)) || ((this.e) && (this.d > this.f))) {
        this.d = this.f;
      }
      this.h = true;
      label462:
      if (!this.h) {
        this.l += 1;
      }
      invalidate();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/speedtest/SpeedProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */