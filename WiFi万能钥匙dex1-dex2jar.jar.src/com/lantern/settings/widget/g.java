package com.lantern.settings.widget;

import android.view.View;
import android.view.animation.Animation;

final class g
  implements Runnable
{
  g(e.a parama, View paramView) {}
  
  public final void run()
  {
    this.a.clearAnimation();
    e.a.a(this.b).cancel();
    this.a.startAnimation(e.a.a(this.b));
    this.a.postDelayed(this, 1500L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */