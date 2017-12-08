package com.bluefay.material;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

final class n
  implements Drawable.Callback
{
  n(i parami) {}
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.invalidateSelf();
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.a.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.a.unscheduleSelf(paramRunnable);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */