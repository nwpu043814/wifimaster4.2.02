package com.wifipay.framework.app.ui;

import android.app.Dialog;

class e
  implements Runnable
{
  e(d paramd) {}
  
  public void run()
  {
    if ((d.a(this.a) != null) && (d.a(this.a).isShowing()))
    {
      d.a(this.a).dismiss();
      d.a(this.a, null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */