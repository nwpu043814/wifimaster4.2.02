package com.lantern.settings.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;

public class TouchImageView
  extends ImageView
{
  private View.OnTouchListener A = null;
  private e B = null;
  private float a;
  private Matrix b;
  private Matrix c;
  private int d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float[] i;
  private Context j;
  private c k;
  private ImageView.ScaleType l;
  private boolean m;
  private boolean n;
  private i o;
  private int p;
  private int q;
  private int r;
  private int s;
  private float t;
  private float u;
  private float v;
  private float w;
  private ScaleGestureDetector x;
  private GestureDetector y;
  private GestureDetector.OnDoubleTapListener z = null;
  
  public TouchImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt2;
    switch (paramInt1)
    {
    default: 
      i1 = paramInt2;
    }
    for (;;)
    {
      return i1;
      i1 = Math.min(paramInt3, paramInt2);
      continue;
      i1 = paramInt3;
    }
  }
  
  private PointF a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.b.getValues(this.i);
    float f4 = getDrawable().getIntrinsicWidth();
    float f3 = getDrawable().getIntrinsicHeight();
    float f1 = this.i[2];
    float f2 = this.i[5];
    f1 = (paramFloat1 - f1) * f4 / d();
    f2 = (paramFloat2 - f2) * f3 / e();
    paramFloat2 = f2;
    paramFloat1 = f1;
    if (paramBoolean)
    {
      paramFloat1 = Math.min(Math.max(f1, 0.0F), f4);
      paramFloat2 = Math.min(Math.max(f2, 0.0F), f3);
    }
    return new PointF(paramFloat1, paramFloat2);
  }
  
  private void a()
  {
    if ((this.b != null) && (this.q != 0) && (this.p != 0))
    {
      this.b.getValues(this.i);
      this.c.setValues(this.i);
      this.w = this.u;
      this.v = this.t;
      this.s = this.q;
      this.r = this.p;
    }
  }
  
  private void a(double paramDouble, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f2;
    float f1;
    float f3;
    if (paramBoolean)
    {
      f2 = this.g;
      f1 = this.h;
      f3 = this.a;
      this.a = ((float)(this.a * paramDouble));
      if (this.a <= f1) {
        break label93;
      }
      this.a = f1;
      paramDouble = f1 / f3;
    }
    for (;;)
    {
      this.b.postScale((float)paramDouble, (float)paramDouble, paramFloat1, paramFloat2);
      c();
      return;
      f2 = this.e;
      f1 = this.f;
      break;
      label93:
      if (this.a < f2)
      {
        this.a = f2;
        paramDouble = f2 / f3;
      }
    }
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, ImageView.ScaleType paramScaleType)
  {
    if (!this.n) {
      this.o = new i(paramFloat1, paramFloat2, paramFloat3, paramScaleType);
    }
    for (;;)
    {
      return;
      if (paramScaleType != this.l) {
        setScaleType(paramScaleType);
      }
      this.a = 1.0F;
      f();
      a(paramFloat1, this.p / 2, this.q / 2, true);
      this.b.getValues(this.i);
      this.i[2] = (-(d() * paramFloat2 - this.p * 0.5F));
      this.i[5] = (-(e() * paramFloat3 - this.q * 0.5F));
      this.b.setValues(this.i);
      b();
      setImageMatrix(this.b);
    }
  }
  
  private void a(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramFloat3 < paramInt3) {
      this.i[paramInt1] = ((paramInt3 - paramInt4 * this.i[0]) * 0.5F);
    }
    for (;;)
    {
      return;
      if (paramFloat1 > 0.0F)
      {
        this.i[paramInt1] = (-((paramFloat3 - paramInt3) * 0.5F));
      }
      else
      {
        paramFloat1 = (Math.abs(paramFloat1) + paramInt2 * 0.5F) / paramFloat2;
        this.i[paramInt1] = (-(paramFloat1 * paramFloat3 - paramInt3 * 0.5F));
      }
    }
  }
  
  private void a(Context paramContext)
  {
    super.setClickable(true);
    this.j = paramContext;
    this.x = new ScaleGestureDetector(paramContext, new g((byte)0));
    this.y = new GestureDetector(paramContext, new d((byte)0));
    this.b = new Matrix();
    this.c = new Matrix();
    this.i = new float[9];
    this.a = 1.0F;
    if (this.l == null) {
      this.l = ImageView.ScaleType.FIT_CENTER;
    }
    this.e = 1.0F;
    this.f = 3.0F;
    this.g = (0.75F * this.e);
    this.h = (1.25F * this.f);
    setImageMatrix(this.b);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.d = h.a;
    this.n = false;
    super.setOnTouchListener(new f((byte)0));
  }
  
  private static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = 0.0F;
    if (paramFloat3 <= paramFloat2)
    {
      paramFloat3 = paramFloat2 - paramFloat3;
      paramFloat2 = 0.0F;
      if (paramFloat1 >= paramFloat2) {
        break label36;
      }
      paramFloat2 = -paramFloat1 + paramFloat2;
    }
    for (;;)
    {
      return paramFloat2;
      paramFloat2 -= paramFloat3;
      paramFloat3 = 0.0F;
      break;
      label36:
      paramFloat2 = f1;
      if (paramFloat1 > paramFloat3) {
        paramFloat2 = -paramFloat1 + paramFloat3;
      }
    }
  }
  
  private void b()
  {
    this.b.getValues(this.i);
    float f1 = this.i[2];
    float f2 = this.i[5];
    f1 = b(f1, this.p, d());
    f2 = b(f2, this.q, e());
    if ((f1 != 0.0F) || (f2 != 0.0F)) {
      this.b.postTranslate(f1, f2);
    }
  }
  
  private void c()
  {
    b();
    this.b.getValues(this.i);
    if (d() < this.p) {
      this.i[2] = ((this.p - d()) / 2.0F);
    }
    if (e() < this.q) {
      this.i[5] = ((this.q - e()) / 2.0F);
    }
    this.b.setValues(this.i);
  }
  
  private float d()
  {
    return this.t * this.a;
  }
  
  private float e()
  {
    return this.u * this.a;
  }
  
  private void f()
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0)) {}
    while ((this.b == null) || (this.c == null)) {
      return;
    }
    int i3 = localDrawable.getIntrinsicWidth();
    int i2 = localDrawable.getIntrinsicHeight();
    float f4 = this.p / i3;
    float f6 = this.q / i2;
    float f1 = f6;
    float f2 = f4;
    float f5 = f6;
    float f3 = f4;
    label151:
    int i1;
    switch (1.a[this.l.ordinal()])
    {
    default: 
      throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    case 1: 
      f1 = 1.0F;
      f2 = 1.0F;
    case 5: 
      f3 = this.p - i3 * f2;
      f4 = this.q - i2 * f1;
      this.t = (this.p - f3);
      this.u = (this.q - f4);
      if (this.a != 1.0F)
      {
        i1 = 1;
        label211:
        if ((i1 != 0) || (this.m)) {
          break label314;
        }
        this.b.setScale(f2, f1);
        this.b.postTranslate(f3 / 2.0F, f4 / 2.0F);
        this.a = 1.0F;
      }
      break;
    }
    for (;;)
    {
      b();
      setImageMatrix(this.b);
      break;
      f1 = Math.max(f4, f6);
      f2 = f1;
      break label151;
      f5 = Math.min(1.0F, Math.min(f4, f6));
      f3 = f5;
      f1 = Math.min(f3, f5);
      f2 = f1;
      break label151;
      i1 = 0;
      break label211;
      label314:
      if ((this.v == 0.0F) || (this.w == 0.0F)) {
        a();
      }
      this.c.getValues(this.i);
      this.i[0] = (this.t / i3 * this.a);
      this.i[4] = (this.u / i2 * this.a);
      f1 = this.i[2];
      f3 = this.i[5];
      f2 = this.v;
      a(2, f1, this.a * f2, d(), this.r, this.p, i3);
      a(5, f3, this.w * this.a, e(), this.s, this.q, i2);
      this.b.setValues(this.i);
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool2 = false;
    this.b.getValues(this.i);
    float f1 = this.i[2];
    boolean bool1;
    if (d() < this.p) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (f1 >= -1.0F)
      {
        bool1 = bool2;
        if (paramInt < 0) {}
      }
      else if (Math.abs(f1) + this.p + 1.0F >= d())
      {
        bool1 = bool2;
        if (paramInt > 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.l;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.n = true;
    this.m = true;
    if (this.o != null)
    {
      a(this.o.a, this.o.b, this.o.c, this.o.d);
      this.o = null;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0)) {
      setMeasuredDimension(0, 0);
    }
    for (;;)
    {
      return;
      int i1 = localDrawable.getIntrinsicWidth();
      int i3 = localDrawable.getIntrinsicHeight();
      int i2 = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = View.MeasureSpec.getMode(paramInt1);
      int i4 = View.MeasureSpec.getSize(paramInt2);
      paramInt2 = View.MeasureSpec.getMode(paramInt2);
      this.p = a(paramInt1, i2, i1);
      this.q = a(paramInt2, i4, i3);
      setMeasuredDimension(this.p, this.q);
      f();
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.a = paramParcelable.getFloat("saveScale");
      this.i = paramParcelable.getFloatArray("matrix");
      this.c.setValues(this.i);
      this.w = paramParcelable.getFloat("matchViewHeight");
      this.v = paramParcelable.getFloat("matchViewWidth");
      this.s = paramParcelable.getInt("viewHeight");
      this.r = paramParcelable.getInt("viewWidth");
      this.m = paramParcelable.getBoolean("imageRendered");
      super.onRestoreInstanceState(paramParcelable.getParcelable("instanceState"));
    }
    for (;;)
    {
      return;
      super.onRestoreInstanceState(paramParcelable);
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instanceState", super.onSaveInstanceState());
    localBundle.putFloat("saveScale", this.a);
    localBundle.putFloat("matchViewHeight", this.u);
    localBundle.putFloat("matchViewWidth", this.t);
    localBundle.putInt("viewWidth", this.p);
    localBundle.putInt("viewHeight", this.q);
    this.b.getValues(this.i);
    localBundle.putFloatArray("matrix", this.i);
    localBundle.putBoolean("imageRendered", this.m);
    return localBundle;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    a();
    f();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    a();
    f();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    a();
    f();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    a();
    f();
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.A = paramOnTouchListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((paramScaleType == ImageView.ScaleType.FIT_START) || (paramScaleType == ImageView.ScaleType.FIT_END)) {
      throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    }
    if (paramScaleType == ImageView.ScaleType.MATRIX) {
      super.setScaleType(ImageView.ScaleType.MATRIX);
    }
    do
    {
      return;
      this.l = paramScaleType;
    } while (!this.n);
    paramScaleType = getDrawable();
    if (paramScaleType == null) {
      paramScaleType = null;
    }
    for (;;)
    {
      a(this.a, paramScaleType.x, paramScaleType.y, getScaleType());
      break;
      int i2 = paramScaleType.getIntrinsicWidth();
      int i1 = paramScaleType.getIntrinsicHeight();
      paramScaleType = a(this.p / 2, this.q / 2, true);
      paramScaleType.x /= i2;
      paramScaleType.y /= i1;
    }
  }
  
  private final class a
  {
    Scroller a;
    OverScroller b;
    boolean c;
    
    public a(Context paramContext)
    {
      if (Build.VERSION.SDK_INT < 9)
      {
        this.c = true;
        this.a = new Scroller(paramContext);
      }
      for (;;)
      {
        return;
        this.c = false;
        this.b = new OverScroller(paramContext);
      }
    }
  }
  
  private final class b
    implements Runnable
  {
    private long b;
    private float c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private AccelerateDecelerateInterpolator h = new AccelerateDecelerateInterpolator();
    private PointF i;
    private PointF j;
    
    b(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
    {
      TouchImageView.a(TouchImageView.this, TouchImageView.h.e);
      this.b = System.currentTimeMillis();
      this.c = TouchImageView.d(TouchImageView.this);
      this.d = paramFloat1;
      this.g = paramBoolean;
      PointF localPointF = TouchImageView.a(TouchImageView.this, paramFloat2, paramFloat3);
      this.e = localPointF.x;
      this.f = localPointF.y;
      this.i = TouchImageView.b(TouchImageView.this, this.e, this.f);
      this.j = new PointF(TouchImageView.i(TouchImageView.this) / 2, TouchImageView.k(TouchImageView.this) / 2);
    }
    
    public final void run()
    {
      float f1 = Math.min(1.0F, (float)(System.currentTimeMillis() - this.b) / 500.0F);
      float f6 = this.h.getInterpolation(f1);
      double d1 = (this.c + (this.d - this.c) * f6) / TouchImageView.d(TouchImageView.this);
      TouchImageView.a(TouchImageView.this, d1, this.e, this.f, this.g);
      float f5 = this.i.x;
      float f2 = this.j.x;
      float f7 = this.i.x;
      float f4 = this.i.y;
      float f3 = this.j.y;
      f1 = this.i.y;
      PointF localPointF = TouchImageView.b(TouchImageView.this, this.e, this.f);
      TouchImageView.m(TouchImageView.this).postTranslate(f5 + (f2 - f7) * f6 - localPointF.x, f4 + (f3 - f1) * f6 - localPointF.y);
      TouchImageView.q(TouchImageView.this);
      TouchImageView.this.setImageMatrix(TouchImageView.m(TouchImageView.this));
      if (TouchImageView.p(TouchImageView.this) != null) {
        TouchImageView.p(TouchImageView.this);
      }
      if (f6 < 1.0F) {
        TouchImageView.a(TouchImageView.this, this);
      }
      for (;;)
      {
        return;
        TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
      }
    }
  }
  
  private final class c
    implements Runnable
  {
    TouchImageView.a a;
    int b;
    int c;
    
    c(int paramInt1, int paramInt2)
    {
      TouchImageView.a(TouchImageView.this, TouchImageView.h.d);
      this.a = new TouchImageView.a(TouchImageView.this, TouchImageView.r(TouchImageView.this));
      TouchImageView.m(TouchImageView.this).getValues(TouchImageView.s(TouchImageView.this));
      int j = (int)TouchImageView.s(TouchImageView.this)[2];
      int i = (int)TouchImageView.s(TouchImageView.this)[5];
      int k;
      int m;
      int i1;
      int n;
      if (TouchImageView.j(TouchImageView.this) > TouchImageView.i(TouchImageView.this))
      {
        k = TouchImageView.i(TouchImageView.this) - (int)TouchImageView.j(TouchImageView.this);
        m = 0;
        if (TouchImageView.l(TouchImageView.this) <= TouchImageView.k(TouchImageView.this)) {
          break label174;
        }
        i1 = TouchImageView.k(TouchImageView.this) - (int)TouchImageView.l(TouchImageView.this);
        n = 0;
        label117:
        this$1 = this.a;
        if (!TouchImageView.this.c) {
          break label185;
        }
        TouchImageView.this.a.fling(j, i, paramInt1, paramInt2, k, m, i1, n);
      }
      for (;;)
      {
        this.b = j;
        this.c = i;
        return;
        m = j;
        k = j;
        break;
        label174:
        n = i;
        i1 = i;
        break label117;
        label185:
        TouchImageView.this.b.fling(j, i, paramInt1, paramInt2, k, m, i1, n);
      }
    }
    
    public final void a()
    {
      TouchImageView.a locala;
      if (this.a != null)
      {
        TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
        locala = this.a;
        if (!locala.c) {
          break label38;
        }
        locala.a.forceFinished(true);
      }
      for (;;)
      {
        return;
        label38:
        locala.b.forceFinished(true);
      }
    }
    
    public final void run()
    {
      if (TouchImageView.p(TouchImageView.this) != null) {
        TouchImageView.p(TouchImageView.this);
      }
      TouchImageView.a locala = this.a;
      if (locala.c) {}
      for (boolean bool = locala.a.isFinished(); bool; bool = locala.b.isFinished())
      {
        this.a = null;
        return;
      }
      locala = this.a;
      label90:
      int i;
      if (locala.c)
      {
        bool = locala.a.computeScrollOffset();
        if (!bool) {
          break label234;
        }
        locala = this.a;
        if (!locala.c) {
          break label236;
        }
        i = locala.a.getCurrX();
        label118:
        locala = this.a;
        if (!locala.c) {
          break label248;
        }
      }
      label234:
      label236:
      label248:
      for (int j = locala.a.getCurrY();; j = locala.b.getCurrY())
      {
        int k = this.b;
        int m = this.c;
        this.b = i;
        this.c = j;
        TouchImageView.m(TouchImageView.this).postTranslate(i - k, j - m);
        TouchImageView.n(TouchImageView.this);
        TouchImageView.this.setImageMatrix(TouchImageView.m(TouchImageView.this));
        TouchImageView.a(TouchImageView.this, this);
        break;
        locala.b.computeScrollOffset();
        bool = locala.b.computeScrollOffset();
        break label90;
        break;
        i = locala.b.getCurrX();
        break label118;
      }
    }
  }
  
  private final class d
    extends GestureDetector.SimpleOnGestureListener
  {
    private d() {}
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.a(TouchImageView.this) != null) {}
      for (boolean bool = TouchImageView.a(TouchImageView.this).onDoubleTap(paramMotionEvent);; bool = false)
      {
        if (TouchImageView.c(TouchImageView.this) == TouchImageView.h.a) {
          if (TouchImageView.d(TouchImageView.this) != TouchImageView.e(TouchImageView.this)) {
            break label97;
          }
        }
        label97:
        for (float f = TouchImageView.f(TouchImageView.this);; f = TouchImageView.e(TouchImageView.this))
        {
          paramMotionEvent = new TouchImageView.b(TouchImageView.this, f, paramMotionEvent.getX(), paramMotionEvent.getY(), false);
          TouchImageView.a(TouchImageView.this, paramMotionEvent);
          bool = true;
          return bool;
        }
      }
    }
    
    public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.a(TouchImageView.this) != null) {}
      for (boolean bool = TouchImageView.a(TouchImageView.this).onDoubleTapEvent(paramMotionEvent);; bool = false) {
        return bool;
      }
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (TouchImageView.b(TouchImageView.this) != null) {
        TouchImageView.b(TouchImageView.this).a();
      }
      TouchImageView.a(TouchImageView.this, new TouchImageView.c(TouchImageView.this, (int)paramFloat1, (int)paramFloat2));
      TouchImageView.a(TouchImageView.this, TouchImageView.b(TouchImageView.this));
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      TouchImageView.this.performLongClick();
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.a(TouchImageView.this) != null) {}
      for (boolean bool = TouchImageView.a(TouchImageView.this).onSingleTapConfirmed(paramMotionEvent);; bool = TouchImageView.this.performClick()) {
        return bool;
      }
    }
  }
  
  public static abstract interface e {}
  
  private final class f
    implements View.OnTouchListener
  {
    private PointF b = new PointF();
    
    private f() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      TouchImageView.g(TouchImageView.this).onTouchEvent(paramMotionEvent);
      TouchImageView.h(TouchImageView.this).onTouchEvent(paramMotionEvent);
      PointF localPointF = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((TouchImageView.c(TouchImageView.this) == TouchImageView.h.a) || (TouchImageView.c(TouchImageView.this) == TouchImageView.h.b) || (TouchImageView.c(TouchImageView.this) == TouchImageView.h.d)) {
        switch (paramMotionEvent.getAction())
        {
        }
      }
      for (;;)
      {
        TouchImageView.this.setImageMatrix(TouchImageView.m(TouchImageView.this));
        if (TouchImageView.o(TouchImageView.this) != null) {
          TouchImageView.o(TouchImageView.this).onTouch(paramView, paramMotionEvent);
        }
        if (TouchImageView.p(TouchImageView.this) != null) {
          TouchImageView.p(TouchImageView.this);
        }
        return true;
        this.b.set(localPointF);
        if (TouchImageView.b(TouchImageView.this) != null) {
          TouchImageView.b(TouchImageView.this).a();
        }
        TouchImageView.a(TouchImageView.this, TouchImageView.h.b);
        continue;
        if (TouchImageView.c(TouchImageView.this) == TouchImageView.h.b)
        {
          float f4 = localPointF.x;
          float f3 = this.b.x;
          float f2 = localPointF.y;
          float f1 = this.b.y;
          f3 = TouchImageView.a(f4 - f3, TouchImageView.i(TouchImageView.this), TouchImageView.j(TouchImageView.this));
          f1 = TouchImageView.a(f2 - f1, TouchImageView.k(TouchImageView.this), TouchImageView.l(TouchImageView.this));
          TouchImageView.m(TouchImageView.this).postTranslate(f3, f1);
          TouchImageView.n(TouchImageView.this);
          this.b.set(localPointF.x, localPointF.y);
          continue;
          TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
        }
      }
    }
  }
  
  private final class g
    extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private g() {}
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      TouchImageView.a(TouchImageView.this, paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY(), true);
      if (TouchImageView.p(TouchImageView.this) != null) {
        TouchImageView.p(TouchImageView.this);
      }
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      TouchImageView.a(TouchImageView.this, TouchImageView.h.c);
      return true;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      super.onScaleEnd(paramScaleGestureDetector);
      TouchImageView.a(TouchImageView.this, TouchImageView.h.a);
      int i = 0;
      TouchImageView.d(TouchImageView.this);
      float f = 0.0F;
      if (TouchImageView.d(TouchImageView.this) > TouchImageView.f(TouchImageView.this))
      {
        f = TouchImageView.f(TouchImageView.this);
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramScaleGestureDetector = new TouchImageView.b(TouchImageView.this, f, TouchImageView.i(TouchImageView.this) / 2, TouchImageView.k(TouchImageView.this) / 2, true);
          TouchImageView.a(TouchImageView.this, paramScaleGestureDetector);
        }
        return;
        if (TouchImageView.d(TouchImageView.this) < TouchImageView.e(TouchImageView.this))
        {
          f = TouchImageView.e(TouchImageView.this);
          i = 1;
        }
      }
    }
  }
  
  private static enum h {}
  
  private final class i
  {
    public float a;
    public float b;
    public float c;
    public ImageView.ScaleType d;
    
    public i(float paramFloat1, float paramFloat2, float paramFloat3, ImageView.ScaleType paramScaleType)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
      this.d = paramScaleType;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/TouchImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */