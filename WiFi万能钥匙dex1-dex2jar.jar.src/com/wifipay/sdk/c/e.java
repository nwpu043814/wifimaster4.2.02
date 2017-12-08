package com.wifipay.sdk.c;

import android.widget.TextView;
import com.wifipay.sdk.app.g;

class e
  implements Runnable
{
  e(d paramd) {}
  
  public void run()
  {
    d.a(this.a, d.a(this.a) % 4);
    String str = ".";
    if (d.a(this.a) == 0) {
      str = "";
    }
    for (;;)
    {
      d.b(this.a);
      if (d.c(this.a) != null) {
        d.c(this.a).setText(str);
      }
      d.e(this.a).a(d.d(this.a), 400L);
      return;
      if (d.a(this.a) == 1) {
        str = ".";
      } else if (d.a(this.a) == 2) {
        str = "..";
      } else if (d.a(this.a) == 3) {
        str = "...";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */