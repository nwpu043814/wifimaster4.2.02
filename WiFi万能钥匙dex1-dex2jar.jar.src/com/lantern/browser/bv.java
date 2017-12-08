package com.lantern.browser;

import android.content.Context;
import android.widget.Toast;

final class bv
  implements Runnable
{
  bv(Context paramContext) {}
  
  public final void run()
  {
    Toast.makeText(this.a, "注入的js拉取失败", 0).show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */