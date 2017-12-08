package com.lantern.wifitools.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class AnimTextView
  extends TextView
{
  private ValueAnimator a;
  private float b;
  
  public AnimTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a()
  {
    this.a = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.a.setDuration(1600L);
    this.a.addUpdateListener(new a(this));
    this.a.setEvaluator(new b(this));
    this.a.setInterpolator(new LinearInterpolator());
    this.a.setRepeatCount(-1);
    this.a.start();
  }
  
  public final void b()
  {
    if (this.a != null) {
      this.a.cancel();
    }
    this.a = ValueAnimator.ofFloat(new float[] { this.b, 0.0F });
    this.a.setDuration(100L);
    this.a.addUpdateListener(new c(this));
    this.a.start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/view/AnimTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */