package com.alipay.sdk.app.a;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.f.a.c;
import com.alipay.sdk.j.h;
import java.io.IOException;

final class b
  implements Runnable
{
  b(Context paramContext, String paramString) {}
  
  public final void run()
  {
    c localc = new c();
    try
    {
      String str = h.b(this.a, "alipay_cashier_statistic_record", null);
      if ((!TextUtils.isEmpty(str)) && (localc.a(this.a, str) != null)) {
        h.a(this.a, "alipay_cashier_statistic_record");
      }
      try
      {
        if (!TextUtils.isEmpty(this.b)) {
          localc.a(this.a, this.b);
        }
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          h.a(this.a, "alipay_cashier_statistic_record", this.b);
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;) {}
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */