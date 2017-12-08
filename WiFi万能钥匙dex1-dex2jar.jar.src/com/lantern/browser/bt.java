package com.lantern.browser;

import android.content.Context;
import android.widget.Toast;

final class bt
  implements Runnable
{
  bt(Context paramContext) {}
  
  public final void run()
  {
    Toast.makeText(this.a, "注入的js拉取成功", 0).show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */