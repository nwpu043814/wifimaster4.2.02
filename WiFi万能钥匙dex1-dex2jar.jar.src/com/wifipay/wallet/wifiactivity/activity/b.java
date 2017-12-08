package com.wifipay.wallet.wifiactivity.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class b
  implements Animation.AnimationListener
{
  b(WifiActivitySMS paramWifiActivitySMS) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == WifiActivitySMS.d(this.a))
    {
      WifiActivitySMS.c(this.a).setVisibility(8);
      WifiActivitySMS.e(this.a);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == WifiActivitySMS.b(this.a)) {
      WifiActivitySMS.c(this.a).setVisibility(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifiactivity/activity/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */