package com.lantern.photochoose.crop.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
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
import com.bluefay.b.h;

public class CropZoomableImageView
  extends ImageView
  implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private float a = 4.0F;
  private float b = 2.0F;
  private float c = 1.0F;
  private final float[] d = new float[9];
  private boolean e = true;
  private ScaleGestureDetector f = null;
  private final Matrix g = new Matrix();
  private GestureDetector h;
  private boolean i;
  private int j;
  private boolean k = true;
  private boolean l = true;
  private int m = 0;
  private int n;
  private float o;
  private float p;
  private int q;
  private boolean r;
  
  public CropZoomableImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CropZoomableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropZoomableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.f = new ScaleGestureDetector(paramContext, this);
    setOnTouchListener(this);
    this.j = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.m = ((int)TypedValue.applyDimension(1, this.m, getResources().getDisplayMetrics()));
    this.h = new GestureDetector(paramContext, new a(this));
  }
  
  private void d()
  {
    float f2 = 0.0F;
    float f3 = 0.0F;
    RectF localRectF = e();
    int i1 = getWidth();
    int i2 = getHeight();
    if (localRectF.width() >= i1 - this.m * 2) {
      if (localRectF.left > this.m)
      {
        f1 = -localRectF.left + this.m;
        if (localRectF.right >= i1 - this.m) {}
      }
    }
    for (float f1 = i1 - localRectF.right - this.m;; f1 = 0.0F)
    {
      if (localRectF.height() >= i2 - this.n * 2)
      {
        f2 = f3;
        if (localRectF.top > 0.0F) {
          f2 = -localRectF.top + this.n;
        }
        if (localRectF.bottom < i2 - this.n) {
          f2 = i2 - localRectF.bottom - this.n;
        }
      }
      if (localRectF.width() < i1) {
        f1 = i1 * 0.5F - localRectF.right + localRectF.width() * 0.5F;
      }
      if (localRectF.height() < i2) {
        f2 = i2 * 0.5F - localRectF.bottom + localRectF.height() * 0.5F;
      }
      this.g.postTranslate(f1, f2);
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  private RectF e()
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
  
  public final void a()
  {
    this.e = true;
  }
  
  public final Bitmap b()
  {
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    draw(new Canvas(localBitmap));
    return Bitmap.createBitmap(localBitmap, this.m, this.n, getWidth() - this.m * 2, getHeight() - this.n * 2);
  }
  
  public final float c()
  {
    this.g.getValues(this.d);
    return this.d[0];
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
    if (this.e)
    {
      localDrawable = getDrawable();
      if (localDrawable != null) {
        break label19;
      }
    }
    for (;;)
    {
      return;
      label19:
      h.c("drawable.intrinsicWidth:" + localDrawable.getIntrinsicWidth() + ",drawable.intrinsicHeight:" + localDrawable.getIntrinsicHeight());
      int i1 = getWidth();
      int i2 = getHeight();
      int i3 = localDrawable.getIntrinsicWidth();
      int i4 = localDrawable.getIntrinsicHeight();
      float f1 = Math.max(i1 * 1.0F / i3, i1 * 1.0F / i4);
      this.c = f1;
      this.a = (this.c * 4.0F);
      this.b = (this.c * 2.0F);
      this.n = ((getHeight() - (getWidth() - this.m * 2)) / 2);
      this.g.postTranslate((i1 - i3) / 2, (i2 - i4) / 2);
      this.g.postScale(f1, f1, getWidth() / 2, getHeight() / 2);
      setImageMatrix(this.g);
      this.e = false;
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f3 = c();
    float f2 = paramScaleGestureDetector.getScaleFactor();
    if (getDrawable() == null) {}
    for (;;)
    {
      return true;
      if (((f3 < this.a) && (f2 > 1.0F)) || ((f3 > this.c) && (f2 < 1.0F)))
      {
        float f1 = f2;
        if (f2 * f3 < this.c) {
          f1 = this.c / f3;
        }
        f2 = f1;
        if (f1 * f3 > this.a) {
          f2 = this.a / f3;
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
      if (i2 != this.q)
      {
        this.r = false;
        this.o = f4;
        this.p = f5;
      }
      this.q = i2;
      switch (paramMotionEvent.getAction())
      {
      default: 
        break;
      case 1: 
      case 3: 
        this.q = 0;
      }
    }
    float f1 = f4 - this.o;
    float f2 = f5 - this.p;
    boolean bool;
    if (!this.r)
    {
      if (Math.sqrt(f1 * f1 + f2 * f2) >= this.j)
      {
        bool = true;
        label208:
        this.r = bool;
      }
    }
    else if (this.r)
    {
      paramView = e();
      if (getDrawable() != null)
      {
        this.k = true;
        this.l = true;
        if (paramView.width() >= getWidth() - this.m * 2) {
          break label535;
        }
        this.l = false;
        f1 = 0.0F;
      }
    }
    label535:
    for (;;)
    {
      if (paramView.height() < getHeight() - this.n * 2)
      {
        this.k = false;
        f2 = 0.0F;
      }
      for (;;)
      {
        this.g.postTranslate(f1, f2);
        paramView = e();
        float f6 = getWidth();
        float f7 = getHeight();
        if ((paramView.top > this.n) && (this.k)) {}
        for (f1 = -paramView.top + this.n;; f1 = 0.0F)
        {
          f2 = f1;
          if (paramView.bottom < f7 - this.n)
          {
            f2 = f1;
            if (this.k) {
              f2 = f7 - paramView.bottom - this.n;
            }
          }
          f1 = f3;
          if (paramView.left > this.m)
          {
            f1 = f3;
            if (this.l) {
              f1 = -paramView.left + this.m;
            }
          }
          f3 = f1;
          if (paramView.right < f6 - this.m)
          {
            f3 = f1;
            if (this.l) {
              f3 = f6 - paramView.right - this.m;
            }
          }
          this.g.postTranslate(f3, f2);
          setImageMatrix(this.g);
          this.p = f5;
          this.o = f4;
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
      if (CropZoomableImageView.this.c() < this.b) {}
      for (this.c = 1.07F;; this.c = 0.93F) {
        return;
      }
    }
    
    public final void run()
    {
      CropZoomableImageView.e(CropZoomableImageView.this).postScale(this.c, this.c, this.d, this.e);
      CropZoomableImageView.f(CropZoomableImageView.this);
      CropZoomableImageView.this.setImageMatrix(CropZoomableImageView.e(CropZoomableImageView.this));
      float f = CropZoomableImageView.this.c();
      if (((this.c > 1.0F) && (f < this.b)) || ((this.c < 1.0F) && (this.b < f))) {
        CropZoomableImageView.this.postDelayed(this, 16L);
      }
      for (;;)
      {
        return;
        f = this.b / f;
        CropZoomableImageView.e(CropZoomableImageView.this).postScale(f, f, this.d, this.e);
        CropZoomableImageView.f(CropZoomableImageView.this);
        CropZoomableImageView.this.setImageMatrix(CropZoomableImageView.e(CropZoomableImageView.this));
        CropZoomableImageView.a(CropZoomableImageView.this, false);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/crop/view/CropZoomableImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */