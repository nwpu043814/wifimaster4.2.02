package com.bluefay.material;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public final class b
  extends ImageView
{
  private Animation.AnimationListener a;
  private int b;
  
  public b(Context paramContext)
  {
    super(paramContext);
    float f = getContext().getResources().getDisplayMetrics().density;
    int i = (int)(20.0F * f * 2.0F);
    int j = (int)(1.75F * f);
    int k = (int)(0.0F * f);
    this.b = ((int)(f * 3.5F));
    if (a()) {
      paramContext = new ShapeDrawable(new OvalShape());
    }
    for (;;)
    {
      paramContext.getPaint().setColor(-328966);
      setBackgroundDrawable(paramContext);
      return;
      paramContext = new ShapeDrawable(new a(this.b, i));
      setLayerType(1, paramContext.getPaint());
      paramContext.getPaint().setShadowLayer(this.b, k, j, 503316480);
      i = this.b;
      setPadding(i, i, i, i);
    }
  }
  
  private static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void a(Animation.AnimationListener paramAnimationListener)
  {
    this.a = paramAnimationListener;
  }
  
  public final void onAnimationEnd()
  {
    super.onAnimationEnd();
    if (this.a != null) {
      this.a.onAnimationEnd(getAnimation());
    }
  }
  
  public final void onAnimationStart()
  {
    super.onAnimationStart();
    if (this.a != null) {
      this.a.onAnimationStart(getAnimation());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!a()) {
      setMeasuredDimension(getMeasuredWidth() + this.b * 2, getMeasuredHeight() + this.b * 2);
    }
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    if ((getBackground() instanceof ShapeDrawable))
    {
      Resources localResources = getResources();
      ((ShapeDrawable)getBackground()).getPaint().setColor(localResources.getColor(paramInt));
    }
  }
  
  private final class a
    extends OvalShape
  {
    private RadialGradient b;
    private int c;
    private Paint d = new Paint();
    private int e;
    private boolean f = true;
    
    public a(int paramInt1, int paramInt2)
    {
      this.c = paramInt1;
      this.e = paramInt2;
      float f1 = this.e / 2;
      float f3 = this.e / 2;
      float f2 = this.c;
      this$1 = Shader.TileMode.CLAMP;
      this.b = new RadialGradient(f1, f3, f2, new int[] { 1023410176, 0 }, null, b.this);
      this.d.setShader(this.b);
    }
    
    public final void draw(Canvas paramCanvas, Paint paramPaint)
    {
      int j = b.this.getWidth();
      int i = b.this.getHeight();
      if (this.f) {
        paramCanvas.drawCircle(j / 2, i / 2, this.e / 2 + this.c, this.d);
      }
      paramCanvas.drawCircle(j / 2, i / 2, this.e / 2, paramPaint);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */