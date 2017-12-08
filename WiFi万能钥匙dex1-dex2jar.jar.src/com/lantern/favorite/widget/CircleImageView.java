package com.lantern.favorite.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.lantern.favorite.R.styleable;

public class CircleImageView
  extends ImageView
{
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private final RectF c = new RectF();
  private final RectF d = new RectF();
  private final Matrix e = new Matrix();
  private final Paint f = new Paint();
  private final Paint g = new Paint();
  private final Paint h = new Paint();
  private int i = -16777216;
  private int j = 0;
  private int k = 0;
  private Bitmap l;
  private BitmapShader m;
  private int n;
  private int o;
  private float p;
  private float q;
  private ColorFilter r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  
  public CircleImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleImageView, paramInt, 0);
    this.j = paramContext.getDimensionPixelSize(0, 0);
    this.i = paramContext.getColor(1, -16777216);
    this.u = paramContext.getBoolean(2, false);
    this.k = paramContext.getColor(3, 0);
    paramContext.recycle();
    a();
  }
  
  private static Bitmap a(Drawable paramDrawable)
  {
    Object localObject = null;
    if (paramDrawable == null) {
      paramDrawable = (Drawable)localObject;
    }
    for (;;)
    {
      return paramDrawable;
      if ((paramDrawable instanceof BitmapDrawable))
      {
        paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
        continue;
      }
      try
      {
        if ((paramDrawable instanceof ColorDrawable)) {}
        for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, b);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), b))
        {
          Canvas localCanvas = new android/graphics/Canvas;
          localCanvas.<init>(localBitmap);
          paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
          paramDrawable.draw(localCanvas);
          paramDrawable = localBitmap;
          break;
        }
      }
      catch (OutOfMemoryError paramDrawable)
      {
        paramDrawable.printStackTrace();
        paramDrawable = (Drawable)localObject;
      }
    }
  }
  
  private void a()
  {
    super.setScaleType(a);
    this.s = true;
    if (this.t)
    {
      d();
      this.t = false;
    }
  }
  
  private void b()
  {
    if (this.f != null) {
      this.f.setColorFilter(this.r);
    }
  }
  
  private void c()
  {
    if (this.v) {}
    for (this.l = null;; this.l = a(getDrawable()))
    {
      d();
      return;
    }
  }
  
  private void d()
  {
    float f1 = 0.0F;
    if (!this.s) {
      this.t = true;
    }
    for (;;)
    {
      return;
      if ((getWidth() == 0) && (getHeight() == 0)) {
        break label528;
      }
      if (this.l != null) {
        break;
      }
      invalidate();
    }
    this.m = new BitmapShader(this.l, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.f.setAntiAlias(true);
    this.f.setShader(this.m);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setAntiAlias(true);
    this.g.setColor(this.i);
    this.g.setStrokeWidth(this.j);
    this.h.setStyle(Paint.Style.FILL);
    this.h.setAntiAlias(true);
    this.h.setColor(this.k);
    this.o = this.l.getHeight();
    this.n = this.l.getWidth();
    RectF localRectF = this.d;
    int i3 = getWidth() - getPaddingLeft() - getPaddingRight();
    int i1 = getHeight() - getPaddingTop() - getPaddingBottom();
    int i2 = Math.min(i3, i1);
    float f2 = getPaddingLeft();
    f2 = (i3 - i2) / 2.0F + f2;
    float f3 = getPaddingTop();
    f3 = (i1 - i2) / 2.0F + f3;
    localRectF.set(new RectF(f2, f3, i2 + f2, i2 + f3));
    this.q = Math.min((this.d.height() - this.j) / 2.0F, (this.d.width() - this.j) / 2.0F);
    this.c.set(this.d);
    if ((!this.u) && (this.j > 0)) {
      this.c.inset(this.j - 1.0F, this.j - 1.0F);
    }
    this.p = Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F);
    b();
    this.e.set(null);
    if (this.n * this.c.height() > this.c.width() * this.o)
    {
      f2 = this.c.height() / this.o;
      f3 = (this.c.width() - this.n * f2) * 0.5F;
    }
    for (;;)
    {
      this.e.setScale(f2, f2);
      this.e.postTranslate((int)(f3 + 0.5F) + this.c.left, (int)(f1 + 0.5F) + this.c.top);
      this.m.setLocalMatrix(this.e);
      invalidate();
      break;
      label528:
      break;
      f2 = this.c.width() / this.n;
      f1 = this.c.height();
      float f4 = this.o;
      f3 = 0.0F;
      f1 = (f1 - f4 * f2) * 0.5F;
    }
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.v) {
      super.onDraw(paramCanvas);
    }
    for (;;)
    {
      return;
      if (this.l != null)
      {
        if (this.k != 0) {
          paramCanvas.drawCircle(this.c.centerX(), this.c.centerY(), this.p, this.h);
        }
        paramCanvas.drawCircle(this.c.centerX(), this.c.centerY(), this.p, this.f);
        if (this.j > 0) {
          paramCanvas.drawCircle(this.d.centerX(), this.d.centerY(), this.q, this.g);
        }
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("adjustViewBounds not supported.");
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == this.r) {}
    for (;;)
    {
      return;
      this.r = paramColorFilter;
      b();
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    c();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    c();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    c();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    c();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != a) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/widget/CircleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */