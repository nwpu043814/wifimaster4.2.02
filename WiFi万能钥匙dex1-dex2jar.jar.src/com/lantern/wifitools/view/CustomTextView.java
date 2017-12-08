package com.lantern.wifitools.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextView
  extends TextView
{
  private int a;
  private ValueAnimator b;
  
  public CustomTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CustomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public CustomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setTypeface(Typeface.createFromAsset(paramContext.getAssets(), "fonts/Avenir_0.ttf"));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (this.b != null) {
      this.b.cancel();
    }
    this.b = ValueAnimator.ofInt(new int[] { this.a, paramInt1 });
    this.b.setDuration(paramInt2);
    this.b.addUpdateListener(new d(this));
    this.b.start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/view/CustomTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */