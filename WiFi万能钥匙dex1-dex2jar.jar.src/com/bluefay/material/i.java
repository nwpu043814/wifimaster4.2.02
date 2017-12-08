package com.bluefay.material;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import bluefay.support.annotation.NonNull;
import java.util.ArrayList;

public final class i
  extends Drawable
  implements Animatable
{
  private static final Interpolator a = new LinearInterpolator();
  private static final Interpolator b = new a((byte)0);
  private static final Interpolator c = new c((byte)0);
  private static final Interpolator d = new AccelerateDecelerateInterpolator();
  private final int[] e = { -13388315, -6697984, 47923, -48060 };
  private final ArrayList<Animation> f = new ArrayList();
  private final b g;
  private float h;
  private Resources i;
  private View j;
  private Animation k;
  private float l;
  private double m;
  private double n;
  private Animation o;
  private final Drawable.Callback p = new n(this);
  
  public i(Context paramContext, View paramView)
  {
    this.j = paramView;
    this.i = paramContext.getResources();
    this.g = new b(this.p);
    this.g.a(this.e);
    paramContext = this.g;
    float f1 = this.i.getDisplayMetrics().density;
    this.m = (f1 * 40.0D);
    this.n = (f1 * 40.0D);
    paramContext.a(2.5F * f1);
    paramContext.a(8.75D * f1);
    paramContext.b();
    paramContext.a(10.0F * f1, f1 * 5.0F);
    paramContext.a((int)this.m, (int)this.n);
    b localb = this.g;
    paramView = new j(this, localb);
    paramView.setInterpolator(d);
    paramView.setDuration(666L);
    paramView.setAnimationListener(new k(this, localb));
    paramContext = new l(this, localb);
    paramContext.setRepeatCount(-1);
    paramContext.setRepeatMode(1);
    paramContext.setInterpolator(a);
    paramContext.setDuration(1333L);
    paramContext.setAnimationListener(new m(this, localb));
    this.o = paramView;
    this.k = paramContext;
  }
  
  public final void a()
  {
    this.g.a();
  }
  
  public final void a(float paramFloat)
  {
    this.g.e(paramFloat);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g.a(paramBoolean);
  }
  
  public final int b()
  {
    return this.g.d();
  }
  
  public final void b(float paramFloat)
  {
    this.g.b(0.0F);
    this.g.c(paramFloat);
  }
  
  public final void c(float paramFloat)
  {
    this.g.d(paramFloat);
  }
  
  final void d(float paramFloat)
  {
    this.h = paramFloat;
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i1 = paramCanvas.save();
    paramCanvas.rotate(this.h, localRect.exactCenterX(), localRect.exactCenterY());
    this.g.a(paramCanvas, localRect);
    paramCanvas.restoreToCount(i1);
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)this.n;
  }
  
  public final int getIntrinsicWidth()
  {
    return (int)this.m;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean isRunning()
  {
    ArrayList localArrayList = this.f;
    int i2 = localArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      Animation localAnimation = (Animation)localArrayList.get(i1);
      if ((!localAnimation.hasStarted()) || (localAnimation.hasEnded())) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1++;
      break;
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    this.g.a(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.g.a(paramColorFilter);
  }
  
  public final void start()
  {
    this.k.reset();
    this.g.l();
    if (this.g.i() != this.g.f()) {
      this.j.startAnimation(this.o);
    }
    for (;;)
    {
      return;
      this.g.b();
      this.g.m();
      this.j.startAnimation(this.k);
    }
  }
  
  public final void stop()
  {
    this.j.clearAnimation();
    d(0.0F);
    this.g.a(false);
    this.g.b();
    this.g.m();
  }
  
  private static final class a
    extends AccelerateDecelerateInterpolator
  {
    public final float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.max(0.0F, (paramFloat - 0.5F) * 2.0F));
    }
  }
  
  private static final class b
  {
    private final RectF a = new RectF();
    private final Paint b = new Paint();
    private final Paint c = new Paint();
    private final Drawable.Callback d;
    private float e = 0.0F;
    private float f = 0.0F;
    private float g = 0.0F;
    private float h = 5.0F;
    private float i = 2.5F;
    private int[] j;
    private int k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private Path p;
    private float q;
    private double r;
    private int s;
    private int t;
    private int u;
    private final Paint v = new Paint();
    private int w;
    
    public b(Drawable.Callback paramCallback)
    {
      this.d = paramCallback;
      this.b.setStrokeCap(Paint.Cap.SQUARE);
      this.b.setAntiAlias(true);
      this.b.setStyle(Paint.Style.STROKE);
      this.c.setStyle(Paint.Style.FILL);
      this.c.setAntiAlias(true);
    }
    
    private void n()
    {
      this.d.invalidateDrawable(null);
    }
    
    public final void a()
    {
      this.w = -328966;
    }
    
    public final void a(double paramDouble)
    {
      this.r = paramDouble;
    }
    
    public final void a(float paramFloat)
    {
      this.h = paramFloat;
      this.b.setStrokeWidth(paramFloat);
      n();
    }
    
    public final void a(float paramFloat1, float paramFloat2)
    {
      this.s = ((int)paramFloat1);
      this.t = ((int)paramFloat2);
    }
    
    public final void a(int paramInt)
    {
      this.u = paramInt;
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      float f1 = Math.min(paramInt1, paramInt2);
      if ((this.r <= 0.0D) || (f1 < 0.0F)) {}
      for (f1 = (float)Math.ceil(this.h / 2.0F);; f1 = (float)(f1 / 2.0F - this.r))
      {
        this.i = f1;
        return;
      }
    }
    
    public final void a(Canvas paramCanvas, Rect paramRect)
    {
      RectF localRectF = this.a;
      localRectF.set(paramRect);
      localRectF.inset(this.i, this.i);
      float f1 = (this.e + this.g) * 360.0F;
      float f2 = (this.f + this.g) * 360.0F - f1;
      this.b.setColor(this.j[this.k]);
      paramCanvas.drawArc(localRectF, f1, f2, false, this.b);
      if (this.o)
      {
        if (this.p != null) {
          break label358;
        }
        this.p = new Path();
        this.p.setFillType(Path.FillType.EVEN_ODD);
      }
      for (;;)
      {
        float f6 = (int)this.i / 2;
        float f3 = this.q;
        float f5 = (float)(this.r * Math.cos(0.0D) + paramRect.exactCenterX());
        float f4 = (float)(this.r * Math.sin(0.0D) + paramRect.exactCenterY());
        this.p.moveTo(0.0F, 0.0F);
        this.p.lineTo(this.s * this.q, 0.0F);
        this.p.lineTo(this.s * this.q / 2.0F, this.t * this.q);
        this.p.offset(f5 - f6 * f3, f4);
        this.p.close();
        this.c.setColor(this.j[this.k]);
        paramCanvas.rotate(f1 + f2 - 5.0F, paramRect.exactCenterX(), paramRect.exactCenterY());
        paramCanvas.drawPath(this.p, this.c);
        if (this.u < 255)
        {
          this.v.setColor(this.w);
          this.v.setAlpha(255 - this.u);
          paramCanvas.drawCircle(paramRect.exactCenterX(), paramRect.exactCenterY(), paramRect.width() / 2, this.v);
        }
        return;
        label358:
        this.p.reset();
      }
    }
    
    public final void a(ColorFilter paramColorFilter)
    {
      this.b.setColorFilter(paramColorFilter);
      n();
    }
    
    public final void a(boolean paramBoolean)
    {
      if (this.o != paramBoolean)
      {
        this.o = paramBoolean;
        n();
      }
    }
    
    public final void a(@NonNull int[] paramArrayOfInt)
    {
      this.j = paramArrayOfInt;
      this.k = 0;
    }
    
    public final void b()
    {
      this.k = 0;
    }
    
    public final void b(float paramFloat)
    {
      this.e = paramFloat;
      n();
    }
    
    public final void c()
    {
      this.k = ((this.k + 1) % this.j.length);
    }
    
    public final void c(float paramFloat)
    {
      this.f = paramFloat;
      n();
    }
    
    public final int d()
    {
      return this.u;
    }
    
    public final void d(float paramFloat)
    {
      this.g = paramFloat;
      n();
    }
    
    public final float e()
    {
      return this.h;
    }
    
    public final void e(float paramFloat)
    {
      if (paramFloat != this.q)
      {
        this.q = paramFloat;
        n();
      }
    }
    
    public final float f()
    {
      return this.e;
    }
    
    public final float g()
    {
      return this.l;
    }
    
    public final float h()
    {
      return this.m;
    }
    
    public final float i()
    {
      return this.f;
    }
    
    public final double j()
    {
      return this.r;
    }
    
    public final float k()
    {
      return this.n;
    }
    
    public final void l()
    {
      this.l = this.e;
      this.m = this.f;
      this.n = this.g;
    }
    
    public final void m()
    {
      this.l = 0.0F;
      this.m = 0.0F;
      this.n = 0.0F;
      b(0.0F);
      c(0.0F);
      d(0.0F);
    }
  }
  
  private static final class c
    extends AccelerateDecelerateInterpolator
  {
    public final float getInterpolation(float paramFloat)
    {
      return super.getInterpolation(Math.min(1.0F, 2.0F * paramFloat));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */