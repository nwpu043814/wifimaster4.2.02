package com.lantern.auth.widget;

import android.app.Activity;
import com.bluefay.material.f;

public final class o
{
  private f a;
  
  public o(String paramString, Activity paramActivity)
  {
    this.a = new f(paramActivity);
    this.a.setCanceledOnTouchOutside(false);
    this.a.a(paramString);
    this.a.setOnCancelListener(new p(this, paramActivity));
  }
  
  public final void a()
  {
    this.a.show();
  }
  
  public final void b()
  {
    this.a.dismiss();
  }
  
  public final boolean c()
  {
    return this.a.isShowing();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/widget/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */