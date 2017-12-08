package com.lantern.photochoose.crop.view;

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
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ZoomableImageView
  extends ImageView
  implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private float a = 1.0F;
  private final float[] b = new float[9];
  private boolean c = true;
  private ScaleGestureDetector d = null;
  private final Matrix e = new Matrix();
  private GestureDetector f;
  private boolean g;
  private int h;
  private boolean i = true;
  private boolean j = true;
  private float k;
  private float l;
  private int m;
  private boolean n;
  
  public ZoomableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ZoomableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.d = new ScaleGestureDetector(paramContext, this);
    setOnTouchListener(this);
    this.h = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.f = new GestureDetector(paramContext, new b(this));
  }
  
  private void b()
  {
    float f2 = 0.0F;
    float f3 = 0.0F;
    RectF localRectF = c();
    int i1 = getWidth();
    int i2 = getHeight();
    if (localRectF.width() >= i1) {
      if (localRectF.left > 0.0F)
      {
        f1 = -localRectF.left;
        if (localRectF.right >= i1) {}
      }
    }
    for (float f1 = i1 - localRectF.right;; f1 = 0.0F)
    {
      if (localRectF.height() >= i2)
      {
        f2 = f3;
        if (localRectF.top > 0.0F) {
          f2 = -localRectF.top;
        }
        if (localRectF.bottom < i2) {
          f2 = i2 - localRectF.bottom;
        }
      }
      if (localRectF.width() < i1) {
        f1 = i1 * 0.5F - localRectF.right + localRectF.width() * 0.5F;
      }
      if (localRectF.height() < i2) {
        f2 = i2 * 0.5F - localRectF.bottom + localRectF.height() * 0.5F;
      }
      this.e.postTranslate(f1, f2);
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  private RectF c()
  {
    Matrix localMatrix = this.e;
    RectF localRectF = new RectF();
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      localRectF.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
    }
    return localRectF;
  }
  
  public final float a()
  {
    this.e.getValues(this.b);
    return this.b[0];
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
    if (this.c)
    {
      localDrawable = getDrawable();
      if (localDrawable != null) {}
    }
    else
    {
      return;
    }
    int i4 = getWidth();
    int i3 = getHeight();
    int i1 = localDrawable.getIntrinsicWidth();
    int i2 = localDrawable.getIntrinsicHeight();
    if ((i1 > i4) && (i2 <= i3)) {}
    for (float f2 = i4 * 1.0F / i1;; f2 = 1.0F)
    {
      float f1 = f2;
      if (i2 > i3)
      {
        f1 = f2;
        if (i1 <= i4) {
          f1 = i3 * 1.0F / i2;
        }
      }
      f2 = f1;
      if (i1 > i4)
      {
        f2 = f1;
        if (i2 > i3) {
          f2 = Math.min(i1 * 1.0F / i4, 1.0F * i2 / i3);
        }
      }
      this.a = f2;
      this.e.postTranslate((i4 - i1) / 2, (i3 - i2) / 2);
      this.e.postScale(f2, f2, getWidth() / 2, getHeight() / 2);
      setImageMatrix(this.e);
      this.c = false;
      break;
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
      if (((f3 < 4.0F) && (f2 > 1.0F)) || ((f3 > this.a) && (f2 < 1.0F)))
      {
        float f1 = f2;
        if (f2 * f3 < this.a) {
          f1 = this.a / f3;
        }
        f2 = f1;
        if (f1 * f3 > 4.0F) {
          f2 = 4.0F / f3;
        }
        this.e.postScale(f2, f2, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        b();
        setImageMatrix(this.e);
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
    float f3 = 0.0F;
    if (this.f.onTouchEvent(paramMotionEvent)) {}
    float f4;
    float f5;
    for (;;)
    {
      return true;
      this.d.onTouchEvent(paramMotionEvent);
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
      if (i2 != this.m)
      {
        this.n = false;
        this.k = f4;
        this.l = f5;
      }
      this.m = i2;
      switch (paramMotionEvent.getAction())
      {
      default: 
        break;
      case 1: 
      case 3: 
        this.m = 0;
      }
    }
    float f1 = f4 - this.k;
    float f2 = f5 - this.l;
    boolean bool;
    if (!this.n)
    {
      if (Math.sqrt(f1 * f1 + f2 * f2) >= this.h)
      {
        bool = true;
        label208:
        this.n = bool;
      }
    }
    else if (this.n)
    {
      paramView = c();
      if (getDrawable() != null)
      {
        this.i = true;
        this.j = true;
        if (paramView.width() >= getWidth()) {
          break label477;
        }
        this.j = false;
        f1 = 0.0F;
      }
    }
    label477:
    for (;;)
    {
      if (paramView.height() < getHeight())
      {
        this.i = false;
        f2 = 0.0F;
      }
      for (;;)
      {
        this.e.postTranslate(f1, f2);
        paramView = c();
        float f6 = getWidth();
        float f7 = getHeight();
        if ((paramView.top > 0.0F) && (this.i)) {}
        for (f1 = -paramView.top;; f1 = 0.0F)
        {
          f2 = f1;
          if (paramView.bottom < f7)
          {
            f2 = f1;
            if (this.i) {
              f2 = f7 - paramView.bottom;
            }
          }
          f1 = f3;
          if (paramView.left > 0.0F)
          {
            f1 = f3;
            if (this.j) {
              f1 = -paramView.left;
            }
          }
          f3 = f1;
          if (paramView.right < f6)
          {
            f3 = f1;
            if (this.j) {
              f3 = f6 - paramView.right;
            }
          }
          this.e.postTranslate(f3, f2);
          setImageMatrix(this.e);
          this.l = f5;
          this.k = f4;
          break;
          bool = false;
          break label208;
        }
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
      if (ZoomableImageView.this.a() < this.b) {}
      for (this.c = 1.07F;; this.c = 0.93F) {
        return;
      }
    }
    
    public final void run()
    {
      ZoomableImageView.c(ZoomableImageView.this).postScale(this.c, this.c, this.d, this.e);
      ZoomableImageView.d(ZoomableImageView.this);
      ZoomableImageView.this.setImageMatrix(ZoomableImageView.c(ZoomableImageView.this));
      float f = ZoomableImageView.this.a();
      if (((this.c > 1.0F) && (f < this.b)) || ((this.c < 1.0F) && (this.b < f))) {
        ZoomableImageView.this.postDelayed(this, 16L);
      }
      for (;;)
      {
        return;
        f = this.b / f;
        ZoomableImageView.c(ZoomableImageView.this).postScale(f, f, this.d, this.e);
        ZoomableImageView.d(ZoomableImageView.this);
        ZoomableImageView.this.setImageMatrix(ZoomableImageView.c(ZoomableImageView.this));
        ZoomableImageView.a(ZoomableImageView.this, false);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/crop/view/ZoomableImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */