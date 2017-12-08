package com.lantern.core.imageloader.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.widget.ImageView;

final class ae
  extends BitmapDrawable
{
  private static final Paint e = new Paint();
  Drawable a;
  long b;
  boolean c;
  int d = 255;
  private final boolean f;
  private final float g;
  private final aa.d h;
  
  private ae(Context paramContext, Bitmap paramBitmap, Drawable paramDrawable, aa.d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext.getResources(), paramBitmap);
    this.f = paramBoolean2;
    this.g = paramContext.getResources().getDisplayMetrics().density;
    this.h = paramd;
    if ((paramd != aa.d.a) && (!paramBoolean1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.a = paramDrawable;
        this.c = true;
        this.b = SystemClock.uptimeMillis();
      }
      return;
    }
  }
  
  private static Path a(Point paramPoint, int paramInt)
  {
    Point localPoint2 = new Point(paramPoint.x + paramInt, paramPoint.y);
    Point localPoint1 = new Point(paramPoint.x, paramPoint.y + paramInt);
    Path localPath = new Path();
    localPath.moveTo(paramPoint.x, paramPoint.y);
    localPath.lineTo(localPoint2.x, localPoint2.y);
    localPath.lineTo(localPoint1.x, localPoint1.y);
    return localPath;
  }
  
  static void a(ImageView paramImageView, Context paramContext, Bitmap paramBitmap, aa.d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if ((localDrawable instanceof AnimationDrawable)) {
      ((AnimationDrawable)localDrawable).stop();
    }
    paramImageView.setImageDrawable(new ae(paramContext, paramBitmap, localDrawable, paramd, paramBoolean1, paramBoolean2));
  }
  
  static void a(ImageView paramImageView, Drawable paramDrawable)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if ((paramImageView.getDrawable() instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramImageView.getDrawable()).start();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (!this.c) {
      super.draw(paramCanvas);
    }
    for (;;)
    {
      if (this.f)
      {
        e.setColor(-1);
        paramCanvas.drawPath(a(new Point(0, 0), (int)(16.0F * this.g)), e);
        e.setColor(this.h.d);
        paramCanvas.drawPath(a(new Point(0, 0), (int)(15.0F * this.g)), e);
      }
      return;
      float f1 = (float)(SystemClock.uptimeMillis() - this.b) / 200.0F;
      if (f1 >= 1.0F)
      {
        this.c = false;
        this.a = null;
        super.draw(paramCanvas);
      }
      else
      {
        if (this.a != null) {
          this.a.draw(paramCanvas);
        }
        super.setAlpha((int)(f1 * this.d));
        super.draw(paramCanvas);
        super.setAlpha(this.d);
        if (Build.VERSION.SDK_INT <= 10) {
          invalidateSelf();
        }
      }
    }
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (this.a != null) {
      this.a.setBounds(paramRect);
    }
    super.onBoundsChange(paramRect);
  }
  
  public final void setAlpha(int paramInt)
  {
    this.d = paramInt;
    if (this.a != null) {
      this.a.setAlpha(paramInt);
    }
    super.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.a != null) {
      this.a.setColorFilter(paramColorFilter);
    }
    super.setColorFilter(paramColorFilter);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */