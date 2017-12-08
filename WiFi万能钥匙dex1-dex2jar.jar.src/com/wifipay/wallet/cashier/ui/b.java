package com.wifipay.wallet.cashier.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class b
  implements Animation.AnimationListener
{
  b(PasswordActivity paramPasswordActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    switch (PasswordActivity.b(this.a))
    {
    }
    for (;;)
    {
      return;
      PasswordActivity.a(this.a, false);
      this.a.payFinish(0, null);
      continue;
      PasswordActivity.c(this.a);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    switch (PasswordActivity.b(this.a))
    {
    }
    for (;;)
    {
      return;
      PasswordActivity.a(this.a, true);
      this.a.runOnUiThread(new c(this));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */