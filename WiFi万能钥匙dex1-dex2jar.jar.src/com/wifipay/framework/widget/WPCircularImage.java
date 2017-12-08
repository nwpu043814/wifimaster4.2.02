package com.wifipay.framework.widget;

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
import com.wifipay.R.styleable;
import com.wifipay.common.a.f;

public class WPCircularImage
  extends ImageView
{
  private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
  private final RectF c = new RectF();
  private final RectF d = new RectF();
  private final Matrix e = new Matrix();
  private final Paint f = new Paint();
  private final Paint g = new Paint();
  private int h = -16777216;
  private int i = 0;
  private Bitmap j;
  private BitmapShader k;
  private int l;
  private int m;
  private float n;
  private float o;
  private ColorFilter p;
  private boolean q;
  private boolean r;
  private boolean s;
  
  public WPCircularImage(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WPCircularImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WPCircularImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WPCircleImageView, paramInt, 0);
    this.i = paramContext.getDimensionPixelSize(R.styleable.WPCircleImageView_wifipay_border_width, 0);
    this.h = paramContext.getColor(R.styleable.WPCircleImageView_wifipay_border_color, -16777216);
    this.s = paramContext.getBoolean(R.styleable.WPCircleImageView_wifipay_border_overlay, false);
    paramContext.recycle();
    a();
  }
  
  private Bitmap a(Drawable paramDrawable)
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
        paramDrawable = (Drawable)localObject;
      }
    }
  }
  
  private void a()
  {
    super.setScaleType(a);
    this.q = true;
    if (this.r)
    {
      b();
      this.r = false;
    }
  }
  
  private void b()
  {
    if (!this.q) {
      this.r = true;
    }
    for (;;)
    {
      return;
      if (this.j != null)
      {
        this.k = new BitmapShader(this.j, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f.setAntiAlias(true);
        this.f.setShader(this.k);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setAntiAlias(true);
        this.g.setColor(this.h);
        this.g.setStrokeWidth(this.i);
        this.m = this.j.getHeight();
        this.l = this.j.getWidth();
        this.d.set(0.0F, 0.0F, getWidth(), getHeight());
        this.o = Math.min(this.d.height() / 2.0F - this.i, this.d.width() / 2.0F - this.i);
        this.c.set(this.d);
        if (!this.s) {
          this.c.inset(this.i, this.i);
        }
        this.n = Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F);
        c();
        invalidate();
      }
    }
  }
  
  private void c()
  {
    float f2 = 0.0F;
    this.e.set(null);
    float f3;
    float f1;
    if (this.l * this.c.height() > this.c.width() * this.m)
    {
      f3 = this.c.height() / this.m;
      f1 = (this.c.width() - this.l * f3) * 0.5F;
    }
    for (;;)
    {
      this.e.setScale(f3, f3);
      this.e.postTranslate((int)(f1 + 0.5F) + this.c.left, (int)(f2 + 0.5F) + this.c.top);
      this.k.setLocalMatrix(this.e);
      return;
      f3 = this.c.width() / this.l;
      f2 = this.c.height();
      float f4 = this.m;
      f1 = 0.0F;
      f2 = (f2 - f4 * f3) * 0.5F;
    }
  }
  
  public int getBorderColor()
  {
    return this.h;
  }
  
  public int getBorderWidth()
  {
    return this.i;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {}
    for (;;)
    {
      return;
      paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, this.n, this.f);
      if (this.i != 0) {
        paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, this.o, this.g);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("adjustViewBounds not supported.");
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    if (paramInt == this.h) {}
    for (;;)
    {
      return;
      this.h = paramInt;
      this.g.setColor(this.h);
      invalidate();
    }
  }
  
  public void setBorderColorResource(int paramInt)
  {
    setBorderColor(f.b(paramInt));
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    if (paramBoolean == this.s) {}
    for (;;)
    {
      return;
      this.s = paramBoolean;
      b();
    }
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.i) {}
    for (;;)
    {
      return;
      this.i = paramInt;
      b();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == this.p) {}
    for (;;)
    {
      return;
      this.p = paramColorFilter;
      this.f.setColorFilter(this.p);
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.j = paramBitmap;
    b();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.j = a(paramDrawable);
    b();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.j = a(getDrawable());
    b();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    this.j = a(getDrawable());
    b();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != a) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/WPCircularImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */