package com.lantern.wifitools.signaldetector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.wifitools.R.styleable;
import com.lantern.wifitools.speedtest.SpeedTestPoint;

public class SignalProgressBar
  extends View
{
  private float A;
  private int B;
  private boolean C;
  private int D;
  private TextView E;
  private SpeedTestPoint F;
  private int a = 0;
  private Paint b;
  private Paint c;
  private RectF d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j = -1;
  private boolean k;
  private int l;
  private int m;
  private Paint n;
  private Paint o;
  private Paint p;
  private boolean q = true;
  private Handler r;
  private boolean s;
  private int t;
  private int u;
  private float v;
  private float w = 1.0F;
  private boolean x = true;
  private boolean y = true;
  private boolean z = true;
  
  public SignalProgressBar(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public SignalProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SpeedProgressBar);
    this.i = paramContext.getInt(5, 100);
    this.t = this.i;
    this.k = paramContext.getBoolean(8, true);
    if (!this.k)
    {
      this.c.setStyle(Paint.Style.STROKE);
      this.p.setStyle(Paint.Style.STROKE);
      this.n.setStyle(Paint.Style.STROKE);
    }
    this.l = paramContext.getInt(12, -5);
    this.q = paramContext.getBoolean(11, true);
    this.B = paramContext.getColor(0, -16711936);
    this.A = paramContext.getDimension(1, 15.0F);
    this.C = paramContext.getBoolean(13, true);
    this.D = paramContext.getColor(14, -7829368);
    this.f = paramContext.getColor(10, -16711936);
    this.e = paramContext.getInt(9, 0);
    if (this.k) {
      this.e = 0;
    }
    this.c.setStrokeWidth(this.e);
    this.p.setStrokeWidth(this.e);
    this.n.setStrokeWidth(this.e);
    this.n.setColor(this.D);
    this.c.setColor(this.f);
    this.p.setColor(this.f);
    paramContext.recycle();
  }
  
  private void b()
  {
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(0.0F);
    this.e = 0;
    this.f = 52224;
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setStrokeWidth(this.e);
    this.c.setColor(this.f);
    this.p = new Paint();
    this.p.setAntiAlias(true);
    this.p.setStyle(Paint.Style.FILL);
    this.p.setStrokeWidth(this.e);
    this.p.setColor(this.f);
    this.n = new Paint();
    this.n.setAntiAlias(true);
    this.n.setStyle(Paint.Style.FILL);
    this.n.setStrokeWidth(this.e);
    this.o = new Paint();
    this.o.setStyle(Paint.Style.STROKE);
    this.o.setAntiAlias(true);
    this.o.setStrokeWidth(0.0F);
    this.o.setTypeface(Typeface.DEFAULT_BOLD);
    this.g = -90;
    this.h = 0;
    this.i = 100;
    this.t = 100;
    this.k = true;
    this.q = true;
    this.l = 0;
    this.m = 0;
    this.d = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.u = 100;
    this.v = 0.0F;
    this.s = false;
    this.r = new c(this);
  }
  
  public final void a()
  {
    if (this.F != null) {
      this.F.a();
    }
  }
  
  public final void a(int paramInt)
  {
    float f1 = paramInt;
    try
    {
      this.v = f1;
      this.m = paramInt;
      if (this.m < 0) {
        this.m = 0;
      }
      if (this.m > this.i) {
        this.m = this.i;
      }
      postInvalidate();
      return;
    }
    finally {}
  }
  
  public final void a(TextView paramTextView)
  {
    this.E = paramTextView;
  }
  
  public final void a(SpeedTestPoint paramSpeedTestPoint)
  {
    this.F = paramSpeedTestPoint;
  }
  
  public final void b(int paramInt)
  {
    try
    {
      this.j = paramInt;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("SignalProgressBar mInitProgress:");
      h.a(this.j, new Object[0]);
      this.s = true;
      this.x = true;
      this.t = this.i;
      this.r.removeMessages(256);
      this.r.sendEmptyMessage(256);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.x)
    {
      if (this.q) {
        paramCanvas.drawArc(this.d, 135.0F, 275.0F, this.k, this.n);
      }
      float f1 = this.m / this.i;
      float f2 = 275.0F * f1;
      paramCanvas.drawArc(this.d, 50.0F, -(275.0F - f2), this.k, this.p);
      float f3 = this.h / this.i;
      int i1 = (int)(f1 * 100.0F);
      if (this.F != null) {
        this.F.a(f2);
      }
      if (this.E != null) {
        this.E.setText(i1 + "%");
      }
      paramCanvas.drawArc(this.d, 135.0F, 275.0F * f3, this.k, this.c);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.l != 0) {
      this.d.set(0.0F, 0.0F, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      int i2 = getPaddingLeft();
      int i1 = getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      this.d.set(i2 + this.e / 2, paramInt3 + this.e / 2, paramInt1 - i1 - this.e / 2, paramInt2 - paramInt4 - this.e / 2);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/signaldetector/SignalProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */