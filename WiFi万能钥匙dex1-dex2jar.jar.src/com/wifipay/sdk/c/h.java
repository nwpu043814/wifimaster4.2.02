package com.wifipay.sdk.c;

import android.app.Dialog;

class h
  implements Runnable
{
  h(g paramg) {}
  
  public void run()
  {
    if ((g.a(this.a) != null) && (g.a(this.a).isShowing()))
    {
      g.a(this.a).dismiss();
      g.a(this.a, null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */