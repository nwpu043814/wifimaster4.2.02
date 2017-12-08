package com.lantern.favorite.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;

public class PhotoView
  extends ImageView
{
  private float A;
  private float B;
  private float C = 1.0F;
  private int D;
  private int E;
  private float F;
  private float G;
  private RectF H = new RectF();
  private RectF I = new RectF();
  private RectF J = new RectF();
  private RectF K = new RectF();
  private RectF L = new RectF();
  private PointF M = new PointF();
  private PointF N = new PointF();
  private PointF O = new PointF();
  private f P = new f();
  private RectF Q;
  private a R;
  private long S;
  private Runnable T;
  private View.OnLongClickListener U;
  private b V = new c(this);
  private ScaleGestureDetector.OnScaleGestureListener W = new d(this);
  private Runnable Z = new e(this);
  private int a;
  private GestureDetector.OnGestureListener aa = new f(this);
  private int b;
  private float c;
  private int d = 0;
  private int e = 0;
  private int f = 500;
  private Matrix g = new Matrix();
  private Matrix h = new Matrix();
  private Matrix i = new Matrix();
  private Matrix j = new Matrix();
  private i k;
  private GestureDetector l;
  private ScaleGestureDetector m;
  private View.OnClickListener n;
  private ImageView.ScaleType o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t = false;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public PhotoView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private static int a(Drawable paramDrawable)
  {
    int i2 = paramDrawable.getIntrinsicWidth();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = paramDrawable.getMinimumWidth();
    }
    i2 = i1;
    if (i1 <= 0) {
      i2 = paramDrawable.getBounds().width();
    }
    return i2;
  }
  
  private void a(RectF paramRectF)
  {
    int i3 = 1;
    int i2 = 0;
    int i1;
    if (paramRectF.width() <= this.H.width()) {
      if (Math.abs(Math.round(paramRectF.left) - (this.H.width() - paramRectF.width()) / 2.0F) < 1.0F)
      {
        i1 = 1;
        if (i1 != 0) {
          break label334;
        }
        i1 = -(int)((this.H.width() - paramRectF.width()) / 2.0F - paramRectF.left);
      }
    }
    for (;;)
    {
      label79:
      if (paramRectF.height() <= this.H.height()) {
        if (Math.abs(Math.round(paramRectF.top) - (this.H.height() - paramRectF.height()) / 2.0F) < 1.0F) {
          label125:
          if (i3 == 0) {
            i2 = -(int)((this.H.height() - paramRectF.height()) / 2.0F - paramRectF.top);
          }
        }
      }
      for (;;)
      {
        if ((i1 != 0) || (i2 != 0))
        {
          if (!this.P.c.isFinished()) {
            this.P.c.abortAnimation();
          }
          this.P.a(-i1, -i2);
        }
        return;
        i1 = 0;
        break;
        if (paramRectF.left > this.H.left)
        {
          i1 = (int)(paramRectF.left - this.H.left);
          break label79;
        }
        if (paramRectF.right >= this.H.right) {
          break label334;
        }
        i1 = (int)(paramRectF.right - this.H.right);
        break label79;
        i3 = 0;
        break label125;
        if (paramRectF.top > this.H.top) {
          i2 = (int)(paramRectF.top - this.H.top);
        } else if (paramRectF.bottom < this.H.bottom) {
          i2 = (int)(paramRectF.bottom - this.H.bottom);
        }
      }
      label334:
      i1 = 0;
    }
  }
  
  private static int b(Drawable paramDrawable)
  {
    int i2 = paramDrawable.getIntrinsicHeight();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = paramDrawable.getMinimumHeight();
    }
    i2 = i1;
    if (i1 <= 0) {
      i2 = paramDrawable.getBounds().height();
    }
    return i2;
  }
  
  private void c()
  {
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.o == null) {
      this.o = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.k = new i(this.V);
    this.l = new GestureDetector(getContext(), this.aa);
    this.m = new ScaleGestureDetector(getContext(), this.W);
    float f1 = getResources().getDisplayMetrics().density;
    this.d = ((int)(30.0F * f1));
    this.e = ((int)(f1 * 140.0F));
    this.a = 30;
    this.b = 300;
    this.c = 2.5F;
  }
  
  private void d()
  {
    float f2 = 1.0F;
    if (!this.q) {}
    while (!this.r) {
      return;
    }
    this.g.reset();
    this.h.reset();
    this.w = false;
    Drawable localDrawable = getDrawable();
    int i2 = getWidth();
    int i1 = getHeight();
    int i4 = a(localDrawable);
    int i5 = b(localDrawable);
    this.I.set(0.0F, 0.0F, i4, i5);
    int i3 = (i2 - i4) / 2;
    int i6 = (i1 - i5) / 2;
    if (i4 > i2) {}
    for (float f1 = i2 / i4;; f1 = 1.0F)
    {
      if (i5 > i1) {
        f2 = i1 / i5;
      }
      if (f1 < f2)
      {
        label133:
        this.g.reset();
        this.g.postTranslate(i3, i6);
        this.g.postScale(f1, f1, this.M.x, this.M.y);
        this.g.mapRect(this.I);
        this.F = (this.I.width() / 2.0F);
        this.G = (this.I.height() / 2.0F);
        this.N.set(this.M);
        this.O.set(this.N);
        g();
        switch (1.a[this.o.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.u = true;
        if ((this.R != null) && (System.currentTimeMillis() - this.S < this.f)) {
          a(this.R);
        }
        this.R = null;
        break;
        f1 = f2;
        break label133;
        if ((this.q) && (this.r))
        {
          localDrawable = getDrawable();
          i1 = a(localDrawable);
          i2 = b(localDrawable);
          if ((i1 > this.H.width()) || (i2 > this.H.height()))
          {
            f1 = i1 / this.J.width();
            f2 = i2 / this.J.height();
            if (f1 > f2) {}
            for (;;)
            {
              this.C = f1;
              this.h.postScale(this.C, this.C, this.M.x, this.M.y);
              g();
              f();
              break;
              f1 = f2;
            }
            if ((this.J.width() < this.H.width()) || (this.J.height() < this.H.height()))
            {
              f1 = this.H.width() / this.J.width();
              f2 = this.H.height() / this.J.height();
              if (f1 > f2) {}
              for (;;)
              {
                this.C = f1;
                this.h.postScale(this.C, this.C, this.M.x, this.M.y);
                g();
                f();
                break;
                f1 = f2;
              }
              if ((this.J.width() > this.H.width()) || (this.J.height() > this.H.height()))
              {
                f1 = this.H.width() / this.J.width();
                f2 = this.H.height() / this.J.height();
                if (f1 < f2) {}
                for (;;)
                {
                  this.C = f1;
                  this.h.postScale(this.C, this.C, this.M.x, this.M.y);
                  g();
                  f();
                  break;
                  f1 = f2;
                }
                e();
                continue;
                e();
                f1 = -this.J.top;
                this.h.postTranslate(0.0F, f1);
                g();
                f();
                this.E = ((int)(f1 + this.E));
                continue;
                e();
                f1 = this.H.bottom - this.J.bottom;
                this.E = ((int)(this.E + f1));
                this.h.postTranslate(0.0F, f1);
                g();
                f();
                continue;
                f2 = this.H.width() / this.J.width();
                f1 = this.H.height() / this.J.height();
                this.h.postScale(f2, f1, this.M.x, this.M.y);
                g();
                f();
              }
            }
          }
        }
      }
    }
  }
  
  private void e()
  {
    if (this.J.width() < this.H.width())
    {
      this.C = (this.H.width() / this.J.width());
      this.h.postScale(this.C, this.C, this.M.x, this.M.y);
      g();
      f();
    }
  }
  
  private void f()
  {
    Drawable localDrawable = getDrawable();
    int i2 = a(localDrawable);
    int i1 = b(localDrawable);
    this.I.set(0.0F, 0.0F, i2, i1);
    this.g.set(this.i);
    this.g.mapRect(this.I);
    this.F = (this.I.width() / 2.0F);
    this.G = (this.I.height() / 2.0F);
    this.C = 1.0F;
    this.D = 0;
    this.E = 0;
    this.h.reset();
  }
  
  private void g()
  {
    boolean bool2 = true;
    this.i.set(this.g);
    this.i.postConcat(this.h);
    setImageMatrix(this.i);
    this.h.mapRect(this.J, this.I);
    if (this.J.width() > this.H.width())
    {
      bool1 = true;
      this.y = bool1;
      if (this.J.height() <= this.H.height()) {
        break label105;
      }
    }
    label105:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.z = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void a()
  {
    this.t = true;
  }
  
  public final void a(a parama)
  {
    if (this.u)
    {
      this.h.reset();
      g();
      this.C = 1.0F;
      this.D = 0;
      this.E = 0;
      a locala = b();
      float f2 = parama.b.width() / locala.b.width();
      float f1 = parama.b.height() / locala.b.height();
      if (f2 < f1)
      {
        f1 = f2;
        f2 = parama.a.left + parama.a.width() / 2.0F;
        float f3 = parama.a.top + parama.a.height() / 2.0F;
        float f4 = locala.a.left + locala.a.width() / 2.0F;
        float f5 = locala.a.top;
        f5 = locala.a.height() / 2.0F + f5;
        this.h.reset();
        this.h.postTranslate(f2 - f4, f3 - f5);
        this.h.postScale(f1, f1, f2, f3);
        this.h.postRotate(parama.g, f2, f3);
        g();
        this.N.set(f2, f3);
        this.O.set(f2, f3);
        this.P.a((int)-(f2 - f4), (int)-(f3 - f5));
        this.P.a(f1, 1.0F);
        this.P.b((int)parama.g, 0);
        if ((parama.c.width() < parama.b.width()) || (parama.c.height() < parama.b.height()))
        {
          f2 = parama.c.width() / parama.b.width();
          f3 = parama.c.height() / parama.b.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (parama.h != ImageView.ScaleType.FIT_START) {
            break label487;
          }
          parama = new e();
          label392:
          this.P.a(f1, f2, 1.0F - f1, 1.0F - f2, this.b / 3, parama);
          this.j.setScale(f1, f2, (this.J.left + this.J.right) / 2.0F, parama.a());
          this.j.mapRect(this.P.l, this.J);
          this.Q = this.P.l;
        }
        this.P.a();
      }
    }
    for (;;)
    {
      return;
      break;
      label487:
      if (parama.h == ImageView.ScaleType.FIT_END)
      {
        parama = new b();
        break label392;
      }
      parama = new d();
      break label392;
      this.R = parama;
      this.S = System.currentTimeMillis();
    }
  }
  
  public final void a(a parama, Runnable paramRunnable)
  {
    float f2;
    float f1;
    if (this.u)
    {
      this.P.b();
      this.D = 0;
      this.E = 0;
      float f4 = parama.a.left;
      float f3 = parama.a.width() / 2.0F;
      float f5 = parama.a.top;
      float f6 = parama.a.height() / 2.0F;
      this.N.set(this.J.left + this.J.width() / 2.0F, this.J.top + this.J.height() / 2.0F);
      this.O.set(this.N);
      this.h.postRotate(-this.B, this.N.x, this.N.y);
      this.h.mapRect(this.J, this.I);
      f2 = parama.b.width() / this.I.width();
      f1 = parama.b.height() / this.I.height();
      if (f2 <= f1) {
        break label499;
      }
      f1 = f2;
      this.h.postRotate(this.B, this.N.x, this.N.y);
      this.h.mapRect(this.J, this.I);
      this.B %= 360.0F;
      this.P.a((int)(f4 + f3 - this.N.x), (int)(f5 + f6 - this.N.y));
      this.P.a(this.C, f1);
      f localf = this.P;
      int i1 = (int)this.B;
      int i2 = (int)parama.g;
      int i3 = this.b * 2 / 3;
      localf.f.startScroll(i1, 0, i2 - i1, 0, i3);
      if ((parama.c.width() < parama.a.width()) || (parama.c.height() < parama.a.height()))
      {
        f1 = parama.c.width() / parama.a.width();
        f3 = parama.c.height() / parama.a.height();
        if (f1 <= 1.0F) {
          break label502;
        }
        f1 = 1.0F;
        label429:
        f2 = f3;
        if (f3 > 1.0F) {
          f2 = 1.0F;
        }
        if (parama.h != ImageView.ScaleType.FIT_START) {
          break label505;
        }
        parama = new e();
      }
    }
    for (;;)
    {
      postDelayed(new g(this, f1, f2, parama), this.b / 2);
      this.T = paramRunnable;
      this.P.a();
      return;
      label499:
      break;
      label502:
      break label429;
      label505:
      if (parama.h == ImageView.ScaleType.FIT_END) {
        parama = new b();
      } else {
        parama = new d();
      }
    }
  }
  
  public final boolean a(float paramFloat)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.J.width() <= this.H.width()) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (paramFloat < 0.0F)
      {
        bool1 = bool2;
        if (Math.round(this.J.left) - paramFloat >= this.H.left) {}
      }
      else if (paramFloat > 0.0F)
      {
        bool1 = bool2;
        if (Math.round(this.J.right) - paramFloat <= this.H.right) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public final a b()
  {
    RectF localRectF = new RectF();
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] += getLeft();
    arrayOfInt[1] += getTop();
    localRectF.set(arrayOfInt[0] + this.J.left, arrayOfInt[1] + this.J.top, arrayOfInt[0] + this.J.right, arrayOfInt[1] + this.J.bottom);
    return new a(localRectF, this.J, this.H, this.I, this.M, this.C, this.B, this.o);
  }
  
  public final boolean b(float paramFloat)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.J.height() <= this.H.height()) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (paramFloat < 0.0F)
      {
        bool1 = bool2;
        if (Math.round(this.J.top) - paramFloat >= this.H.top) {}
      }
      else if (paramFloat > 0.0F)
      {
        bool1 = bool2;
        if (Math.round(this.J.bottom) - paramFloat <= this.H.bottom) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.p) {}
    for (boolean bool = true;; bool = a(paramInt)) {
      return bool;
    }
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    if (this.p) {}
    for (boolean bool = true;; bool = b(paramInt)) {
      return bool;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f2;
    float f3;
    float f1;
    if (this.t)
    {
      int i1 = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.p = true;
      }
      this.l.onTouchEvent(paramMotionEvent);
      this.k.onTouchEvent(paramMotionEvent);
      this.m.onTouchEvent(paramMotionEvent);
      if (((i1 == 1) || (i1 == 3)) && (!this.P.a))
      {
        if ((this.x) || (this.B % 90.0F != 0.0F))
        {
          f2 = (int)(this.B / 90.0F) * 90;
          f3 = this.B % 90.0F;
          if (f3 <= 45.0F) {
            break label364;
          }
          f1 = f2 + 90.0F;
          this.P.b((int)this.B, (int)f1);
          this.B = f1;
        }
        f1 = this.C;
        if (this.C >= 1.0F) {
          break label384;
        }
        this.P.a(this.C, 1.0F);
        f1 = 1.0F;
        label180:
        f3 = this.J.left + this.J.width() / 2.0F;
        f2 = this.J.top + this.J.height() / 2.0F;
        this.N.set(f3, f2);
        this.O.set(f3, f2);
        this.D = 0;
        this.E = 0;
        this.j.reset();
        this.j.postTranslate(-this.I.left, -this.I.top);
        this.j.postTranslate(f3 - this.F, f2 - this.G);
        this.j.postScale(f1, f1, f3, f2);
        this.j.postRotate(this.B, f3, f2);
        this.j.mapRect(this.K, this.I);
        a(this.K);
        this.P.a();
      }
    }
    for (boolean bool = true;; bool = super.dispatchTouchEvent(paramMotionEvent))
    {
      return bool;
      label364:
      f1 = f2;
      if (f3 >= -45.0F) {
        break;
      }
      f1 = f2 - 90.0F;
      break;
      label384:
      if (this.C <= this.c) {
        break label180;
      }
      f1 = this.c;
      this.P.a(this.C, this.c);
      break label180;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.Q != null)
    {
      paramCanvas.clipRect(this.Q);
      this.Q = null;
    }
    super.draw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.q)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    Object localObject = getDrawable();
    int i2 = a((Drawable)localObject);
    int i1 = b((Drawable)localObject);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new ViewGroup.LayoutParams(-2, -2);
    }
    label103:
    label120:
    float f1;
    float f2;
    if (((ViewGroup.LayoutParams)localObject).width == -1)
    {
      if (i6 == 0) {
        break label247;
      }
      paramInt1 = i4;
      if (((ViewGroup.LayoutParams)localObject).height != -1) {
        break label253;
      }
      if (i5 == 0) {
        break label288;
      }
      paramInt2 = i3;
      i4 = paramInt1;
      i3 = paramInt2;
      if (this.v)
      {
        i4 = paramInt1;
        i3 = paramInt2;
        if (i2 / i1 != paramInt1 / paramInt2)
        {
          f1 = paramInt2 / i1;
          f2 = paramInt1 / i2;
          if (f1 >= f2) {
            break label294;
          }
          label177:
          if (((ViewGroup.LayoutParams)localObject).width != -1) {
            break label300;
          }
          label186:
          if (((ViewGroup.LayoutParams)localObject).height != -1) {
            break label310;
          }
          i3 = paramInt2;
        }
      }
    }
    for (i4 = paramInt1;; i4 = paramInt1)
    {
      setMeasuredDimension(i4, i3);
      break;
      paramInt1 = i4;
      if (i6 == 1073741824) {
        break label103;
      }
      if (i6 == Integer.MIN_VALUE)
      {
        paramInt1 = i4;
        if (i2 > i4) {
          break label103;
        }
        paramInt1 = i2;
        break label103;
      }
      label247:
      paramInt1 = i2;
      break label103;
      label253:
      paramInt2 = i3;
      if (i5 == 1073741824) {
        break label120;
      }
      if (i5 == Integer.MIN_VALUE)
      {
        paramInt2 = i3;
        if (i1 > i3) {
          break label120;
        }
        paramInt2 = i1;
        break label120;
      }
      label288:
      paramInt2 = i1;
      break label120;
      label294:
      f1 = f2;
      break label177;
      label300:
      paramInt1 = (int)(i2 * f1);
      break label186;
      label310:
      i3 = (int)(i1 * f1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.H.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.M.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.r)
    {
      this.r = true;
      d();
    }
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    super.setAdjustViewBounds(paramBoolean);
    this.v = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    int i2 = 0;
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null) {
      this.q = false;
    }
    label92:
    label95:
    for (;;)
    {
      return;
      if (((paramDrawable.getIntrinsicHeight() <= 0) || (paramDrawable.getIntrinsicWidth() <= 0)) && ((paramDrawable.getMinimumWidth() <= 0) || (paramDrawable.getMinimumHeight() <= 0)))
      {
        i1 = i2;
        if (paramDrawable.getBounds().width() > 0) {
          if (paramDrawable.getBounds().height() > 0) {
            break label92;
          }
        }
      }
      for (int i1 = i2;; i1 = 1)
      {
        if (i1 == 0) {
          break label95;
        }
        if (!this.q) {
          this.q = true;
        }
        d();
        break;
      }
    }
  }
  
  public void setImageResource(int paramInt)
  {
    Object localObject = null;
    try
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      localObject = localDrawable;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    setImageDrawable((Drawable)localObject);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.n = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.U = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == ImageView.ScaleType.MATRIX) {}
    for (;;)
    {
      return;
      if (paramScaleType != this.o)
      {
        this.o = paramScaleType;
        if (this.u) {
          d();
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract float a();
  }
  
  public final class b
    implements PhotoView.a
  {
    public b() {}
    
    public final float a()
    {
      return PhotoView.o(PhotoView.this).bottom;
    }
  }
  
  private final class c
    implements Interpolator
  {
    private Interpolator b = new DecelerateInterpolator();
    
    private c() {}
    
    public final float getInterpolation(float paramFloat)
    {
      float f = paramFloat;
      if (this.b != null) {
        f = this.b.getInterpolation(paramFloat);
      }
      return f;
    }
  }
  
  public final class d
    implements PhotoView.a
  {
    public d() {}
    
    public final float a()
    {
      return (PhotoView.o(PhotoView.this).top + PhotoView.o(PhotoView.this).bottom) / 2.0F;
    }
  }
  
  public final class e
    implements PhotoView.a
  {
    public e() {}
    
    public final float a()
    {
      return PhotoView.o(PhotoView.this).top;
    }
  }
  
  private final class f
    implements Runnable
  {
    boolean a;
    OverScroller b;
    OverScroller c;
    Scroller d;
    Scroller e;
    Scroller f;
    PhotoView.a g;
    int h;
    int i;
    int j;
    int k;
    RectF l = new RectF();
    PhotoView.c m = new PhotoView.c(PhotoView.this, (byte)0);
    
    f()
    {
      this$1 = PhotoView.this.getContext();
      this.b = new OverScroller(PhotoView.this, this.m);
      this.d = new Scroller(PhotoView.this, this.m);
      this.c = new OverScroller(PhotoView.this, this.m);
      this.e = new Scroller(PhotoView.this, this.m);
      this.f = new Scroller(PhotoView.this, this.m);
    }
    
    private void c()
    {
      PhotoView.b(PhotoView.this).reset();
      PhotoView.b(PhotoView.this).postTranslate(-PhotoView.C(PhotoView.this).left, -PhotoView.C(PhotoView.this).top);
      PhotoView.b(PhotoView.this).postTranslate(PhotoView.v(PhotoView.this).x, PhotoView.v(PhotoView.this).y);
      PhotoView.b(PhotoView.this).postTranslate(-PhotoView.D(PhotoView.this), -PhotoView.E(PhotoView.this));
      PhotoView.b(PhotoView.this).postRotate(PhotoView.q(PhotoView.this), PhotoView.v(PhotoView.this).x, PhotoView.v(PhotoView.this).y);
      PhotoView.b(PhotoView.this).postScale(PhotoView.z(PhotoView.this), PhotoView.z(PhotoView.this), PhotoView.u(PhotoView.this).x, PhotoView.u(PhotoView.this).y);
      PhotoView.b(PhotoView.this).postTranslate(PhotoView.F(PhotoView.this), PhotoView.G(PhotoView.this));
      PhotoView.f(PhotoView.this);
    }
    
    private void d()
    {
      if (this.a) {
        PhotoView.this.post(this);
      }
    }
    
    final void a()
    {
      this.a = true;
      d();
    }
    
    final void a(float paramFloat1, float paramFloat2)
    {
      this.d.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.I(PhotoView.this));
    }
    
    final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, PhotoView.a parama)
    {
      this.e.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
      this.g = parama;
    }
    
    final void a(int paramInt1, int paramInt2)
    {
      this.j = 0;
      this.k = 0;
      this.b.startScroll(0, 0, paramInt1, paramInt2, PhotoView.I(PhotoView.this));
    }
    
    final void b()
    {
      PhotoView.this.removeCallbacks(this);
      this.b.abortAnimation();
      this.d.abortAnimation();
      this.c.abortAnimation();
      this.f.abortAnimation();
      this.a = false;
    }
    
    final void b(int paramInt1, int paramInt2)
    {
      this.f.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.I(PhotoView.this));
    }
    
    public final void run()
    {
      int i2 = 1;
      int i3 = 0;
      if (this.d.computeScrollOffset()) {
        PhotoView.g(PhotoView.this, this.d.getCurrX() / 10000.0F);
      }
      for (int i1 = 0;; i1 = 1)
      {
        int i4;
        int i6;
        int i5;
        if (this.b.computeScrollOffset())
        {
          i4 = this.b.getCurrX();
          i6 = this.j;
          i5 = this.b.getCurrY();
          i1 = this.k;
          PhotoView.a(PhotoView.this, i4 - i6);
          PhotoView.b(PhotoView.this, i5 - i1);
          this.j = this.b.getCurrX();
          this.k = this.b.getCurrY();
          i1 = 0;
        }
        if (this.c.computeScrollOffset())
        {
          i4 = this.c.getCurrX();
          i5 = this.h;
          i6 = this.c.getCurrY();
          i1 = this.i;
          this.h = this.c.getCurrX();
          this.i = this.c.getCurrY();
          PhotoView.a(PhotoView.this, i4 - i5);
          PhotoView.b(PhotoView.this, i6 - i1);
          i1 = 0;
        }
        if (this.f.computeScrollOffset())
        {
          PhotoView.d(PhotoView.this, this.f.getCurrX());
          i1 = 0;
        }
        if ((this.e.computeScrollOffset()) || (PhotoView.K(PhotoView.this) != null))
        {
          float f2 = this.e.getCurrX() / 10000.0F;
          float f1 = this.e.getCurrY() / 10000.0F;
          PhotoView.B(PhotoView.this).setScale(f2, f1, (PhotoView.o(PhotoView.this).left + PhotoView.o(PhotoView.this).right) / 2.0F, this.g.a());
          PhotoView.B(PhotoView.this).mapRect(this.l, PhotoView.o(PhotoView.this));
          if (f2 == 1.0F)
          {
            this.l.left = PhotoView.p(PhotoView.this).left;
            this.l.right = PhotoView.p(PhotoView.this).right;
          }
          if (f1 == 1.0F)
          {
            this.l.top = PhotoView.p(PhotoView.this).top;
            this.l.bottom = PhotoView.p(PhotoView.this).bottom;
          }
          PhotoView.b(PhotoView.this, this.l);
        }
        if (i1 == 0)
        {
          c();
          d();
          return;
        }
        this.a = false;
        i1 = i3;
        if (PhotoView.l(PhotoView.this))
        {
          if (PhotoView.o(PhotoView.this).left > 0.0F)
          {
            PhotoView.e(PhotoView.this, PhotoView.o(PhotoView.this).left);
            label507:
            i1 = 1;
          }
        }
        else
        {
          if (!PhotoView.m(PhotoView.this)) {
            break label723;
          }
          if (PhotoView.o(PhotoView.this).top <= 0.0F) {
            break label660;
          }
          PhotoView.f(PhotoView.this, PhotoView.o(PhotoView.this).top);
          i1 = i2;
        }
        label660:
        label723:
        for (;;)
        {
          if (i1 != 0) {
            c();
          }
          PhotoView.this.invalidate();
          if (PhotoView.L(PhotoView.this) == null) {
            break;
          }
          PhotoView.L(PhotoView.this).run();
          PhotoView.M(PhotoView.this);
          break;
          if (PhotoView.o(PhotoView.this).right >= PhotoView.p(PhotoView.this).width()) {
            break label507;
          }
          PhotoView.c(PhotoView.this, (int)(PhotoView.p(PhotoView.this).width() - PhotoView.o(PhotoView.this).right));
          break label507;
          i1 = i2;
          if (PhotoView.o(PhotoView.this).bottom < PhotoView.p(PhotoView.this).height())
          {
            PhotoView.d(PhotoView.this, (int)(PhotoView.p(PhotoView.this).height() - PhotoView.o(PhotoView.this).bottom));
            i1 = i2;
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/widget/PhotoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */