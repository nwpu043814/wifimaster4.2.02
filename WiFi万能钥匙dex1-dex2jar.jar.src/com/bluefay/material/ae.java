package com.bluefay.material;

import android.content.Context;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public final class ae
  extends ImageView
{
  private Animation.AnimationListener a;
  
  public ae(Context paramContext)
  {
    super(paramContext);
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
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */