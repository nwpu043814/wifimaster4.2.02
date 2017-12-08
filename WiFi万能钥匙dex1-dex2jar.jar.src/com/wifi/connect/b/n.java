package com.wifi.connect.b;

import android.os.AsyncTask;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.q;

final class n
  implements com.bluefay.b.a
{
  n(d paramd) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("EnableMobileNetwork retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    d.b(this.a);
    if (paramInt == 1)
    {
      c.getShareValue().c(true);
      new com.wifi.connect.d.d(d.c(this.a), d.d(this.a)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }
    for (;;)
    {
      return;
      try
      {
        paramInt = Integer.parseInt(paramString);
        if ((paramInt == 10003) || (paramInt == 10012))
        {
          com.lantern.analytics.a.e().onEvent("queryall_pop");
          this.a.a(d.d(this.a), paramInt);
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramInt = 10003;
        }
        d.d(this.a).a(0, paramString, null);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */