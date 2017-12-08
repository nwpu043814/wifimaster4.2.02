package com.linksure.apservice.ui.views.integration;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.linksure.apservice.R.styleable;

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
  private int h = -16777216;
  private int i = 0;
  private Bitmap j;
  private BitmapShader k;
  private int l;
  private int m;
  private float n;
  private float o;
  private boolean p;
  private boolean q;
  private final Paint r = new Paint();
  private final TextPaint s = new TextPaint();
  private String t;
  private boolean u = false;
  private Rect v = new Rect();
  
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
    try
    {
      this.i = paramContext.getDimensionPixelSize(0, 0);
      this.h = paramContext.getColor(1, -16777216);
      paramContext.recycle();
      a();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
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
        paramDrawable = (Drawable)localObject;
      }
    }
  }
  
  private void a()
  {
    super.setScaleType(a);
    this.p = true;
    if (this.q)
    {
      b();
      this.q = false;
    }
  }
  
  private void b()
  {
    float f2 = 0.0F;
    if (!this.p)
    {
      this.q = true;
      return;
    }
    float f1;
    float f3;
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
      this.o = Math.min((this.d.height() - this.i) / 2.0F, (this.d.width() - this.i) / 2.0F);
      this.c.set(this.i, this.i, this.d.width() - this.i, this.d.height() - this.i);
      this.n = Math.min(this.c.height() / 2.0F, this.c.width() / 2.0F);
      this.r.setColor(1711276032);
      this.r.setFlags(1);
      this.s.setFlags(1);
      this.s.setTextAlign(Paint.Align.CENTER);
      this.s.setColor(-1);
      this.s.setTextSize(getResources().getDisplayMetrics().density * 18.0F);
      this.e.set(null);
      if (this.l * this.c.height() <= this.c.width() * this.m) {
        break label446;
      }
      f1 = this.c.height() / this.m;
      f3 = (this.c.width() - this.l * f1) * 0.5F;
    }
    for (;;)
    {
      this.e.setScale(f1, f1);
      this.e.postTranslate((int)(f3 + 0.5F) + this.i, (int)(f2 + 0.5F) + this.i);
      this.k.setLocalMatrix(this.e);
      invalidate();
      break;
      break;
      label446:
      f1 = this.c.width() / this.l;
      float f4 = this.c.height();
      f2 = this.m;
      f3 = 0.0F;
      f2 = (f4 - f2 * f1) * 0.5F;
    }
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
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.n, this.f);
      if (this.i != 0)
      {
        paramCanvas.save();
        paramCanvas.rotate(20.0F, getWidth() / 2, getHeight() / 2);
        paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.o - 1.0F, this.g);
        paramCanvas.restore();
      }
      if ((this.u) && (this.t != null))
      {
        paramCanvas.drawArc(this.d, 40.0F, 100.0F, false, this.r);
        this.s.getTextBounds(this.t, 0, this.t.length(), this.v);
        paramCanvas.drawText(this.t, getWidth() / 2, (float)((3.0D + Math.cos(0.8726646304130554D)) * getHeight() / 4.0D + this.v.height() / 3), this.s);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/views/integration/CircleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */