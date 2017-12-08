package com.linksure.apservice.ui.views.integration;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ClipZoomImageView
  extends ImageView
  implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener
{
  public static float a = 4.0F;
  private static float b = 2.0F;
  private float c = 1.0F;
  private boolean d = true;
  private final float[] e = new float[9];
  private ScaleGestureDetector f = null;
  private final Matrix g = new Matrix();
  private GestureDetector h;
  private boolean i;
  private int j;
  private float k;
  private float l;
  private boolean m;
  private int n;
  private int o;
  
  public ClipZoomImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClipZoomImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.h = new GestureDetector(paramContext, new c(this));
    this.f = new ScaleGestureDetector(paramContext, this);
    setOnTouchListener(this);
  }
  
  private RectF c()
  {
    Matrix localMatrix = this.g;
    RectF localRectF = new RectF();
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      localRectF.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
    }
    return localRectF;
  }
  
  private void d()
  {
    float f2 = 0.0F;
    float f3 = 0.0F;
    RectF localRectF = c();
    int i2 = getWidth();
    int i1 = getHeight();
    if (localRectF.width() + 0.01D >= i2 - this.o * 2) {
      if (localRectF.left > this.o)
      {
        f1 = -localRectF.left + this.o;
        if (localRectF.right >= i2 - this.o) {}
      }
    }
    for (float f1 = i2 - this.o - localRectF.right;; f1 = 0.0F)
    {
      if (localRectF.height() + 0.01D >= i1 - e() * 2)
      {
        f2 = f3;
        if (localRectF.top > e()) {
          f2 = -localRectF.top + e();
        }
        if (localRectF.bottom < i1 - e()) {
          f2 = i1 - e() - localRectF.bottom;
        }
      }
      this.g.postTranslate(f1, f2);
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  private int e()
  {
    return (getHeight() - (getWidth() - this.o * 2)) / 2;
  }
  
  public final float a()
  {
    this.g.getValues(this.e);
    return this.e[0];
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
  
  public void onGlobalLayout()
  {
    Drawable localDrawable;
    if (this.d)
    {
      localDrawable = getDrawable();
      if (localDrawable != null) {}
    }
    else
    {
      return;
    }
    int i3 = getWidth();
    int i1 = getHeight();
    int i4 = localDrawable.getIntrinsicWidth();
    int i5 = localDrawable.getIntrinsicHeight();
    int i2 = getWidth() - this.o * 2;
    float f1;
    if ((i4 > i2) && (i5 < i2)) {
      f1 = i2 * 1.0F / i5;
    }
    for (;;)
    {
      label81:
      float f2;
      if ((i4 < i2) && (i5 > i2)) {
        f2 = i2 * 1.0F / i4;
      }
      for (;;)
      {
        this.c = f2;
        b = this.c * 2.0F;
        a = this.c * 4.0F;
        this.g.postTranslate((i3 - i4) / 2, (i1 - i5) / 2);
        this.g.postScale(f2, f2, getWidth() / 2, getHeight() / 2);
        setImageMatrix(this.g);
        this.d = false;
        break;
        if ((i5 > i2) && (i4 < i2))
        {
          f1 = i2 * 1.0F / i4;
          break label81;
        }
        if ((i4 <= i2) || (i5 <= i2)) {
          break label328;
        }
        f1 = Math.max(i2 * 1.0F / i4, i2 * 1.0F / i5);
        break label81;
        if ((i5 < i2) && (i4 > i2))
        {
          f2 = i2 * 1.0F / i5;
        }
        else
        {
          f2 = f1;
          if (i4 < i2)
          {
            f2 = f1;
            if (i5 < i2) {
              f2 = Math.max(i2 * 1.0F / i4, 1.0F * i2 / i5);
            }
          }
        }
      }
      label328:
      f1 = 1.0F;
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f3 = a();
    float f2 = paramScaleGestureDetector.getScaleFactor();
    if (getDrawable() == null) {}
    for (;;)
    {
      return true;
      if (((f3 < a) && (f2 > 1.0F)) || ((f3 > this.c) && (f2 < 1.0F)))
      {
        float f1 = f2;
        if (f2 * f3 < this.c) {
          f1 = this.c / f3;
        }
        f2 = f1;
        if (f1 * f3 > a) {
          f2 = a / f3;
        }
        this.g.postScale(f2, f2, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        d();
        setImageMatrix(this.g);
      }
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    float f3 = 0.0F;
    if (this.h.onTouchEvent(paramMotionEvent)) {}
    float f4;
    float f5;
    for (;;)
    {
      return true;
      this.f.onTouchEvent(paramMotionEvent);
      int i2 = paramMotionEvent.getPointerCount();
      int i1 = 0;
      f1 = 0.0F;
      f2 = 0.0F;
      while (i1 < i2)
      {
        f2 += paramMotionEvent.getX(i1);
        f1 += paramMotionEvent.getY(i1);
        i1++;
      }
      f4 = f2 / i2;
      f5 = f1 / i2;
      if (i2 != this.n)
      {
        this.m = false;
        this.k = f4;
        this.l = f5;
      }
      this.n = i2;
      switch (paramMotionEvent.getAction())
      {
      default: 
        break;
      case 1: 
      case 3: 
        this.n = 0;
      }
    }
    float f1 = f4 - this.k;
    float f2 = f5 - this.l;
    if (!this.m)
    {
      if (Math.sqrt(f1 * f1 + f2 * f2) >= this.j) {
        bool = true;
      }
      this.m = bool;
    }
    if ((this.m) && (getDrawable() != null))
    {
      paramView = c();
      if (paramView.width() > getWidth() - this.o * 2) {
        break label324;
      }
      f1 = 0.0F;
    }
    label324:
    for (;;)
    {
      if (paramView.height() <= getHeight() - e() * 2) {
        f2 = f3;
      }
      for (;;)
      {
        this.g.postTranslate(f1, f2);
        d();
        setImageMatrix(this.g);
        this.k = f4;
        this.l = f5;
        break;
      }
    }
  }
  
  private final class a
    implements Runnable
  {
    private float b;
    private float c;
    private float d;
    private float e;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      this.b = paramFloat1;
      this.d = paramFloat2;
      this.e = paramFloat3;
      if (ClipZoomImageView.this.a() < this.b) {}
      for (this.c = 1.07F;; this.c = 0.93F) {
        return;
      }
    }
    
    public final void run()
    {
      ClipZoomImageView.c(ClipZoomImageView.this).postScale(this.c, this.c, this.d, this.e);
      ClipZoomImageView.d(ClipZoomImageView.this);
      ClipZoomImageView.this.setImageMatrix(ClipZoomImageView.c(ClipZoomImageView.this));
      float f = ClipZoomImageView.this.a();
      if (((this.c > 1.0F) && (f < this.b)) || ((this.c < 1.0F) && (this.b < f))) {
        ClipZoomImageView.this.postDelayed(this, 16L);
      }
      for (;;)
      {
        return;
        f = this.b / f;
        ClipZoomImageView.c(ClipZoomImageView.this).postScale(f, f, this.d, this.e);
        ClipZoomImageView.d(ClipZoomImageView.this);
        ClipZoomImageView.this.setImageMatrix(ClipZoomImageView.c(ClipZoomImageView.this));
        ClipZoomImageView.a(ClipZoomImageView.this, false);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/integration/ClipZoomImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */