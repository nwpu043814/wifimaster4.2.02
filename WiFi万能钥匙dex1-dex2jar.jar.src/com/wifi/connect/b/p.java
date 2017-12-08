package com.wifi.connect.b;

import android.os.AsyncTask;
import com.bluefay.b.a;
import com.bluefay.b.h;
import com.wifi.connect.d.b;

final class p
  implements a
{
  p(d paramd) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("CheckInternet retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if ((paramObject instanceof Integer))
    {
      if (((Integer)paramObject).intValue() == 1) {
        break label107;
      }
      if (!d.g(this.a)) {
        break label82;
      }
      d.h(this.a).b = System.currentTimeMillis();
      d.d(this.a).a(0, "10014", null);
    }
    for (;;)
    {
      return;
      label82:
      new b(d.i(this.a)).execute(new String[0]);
      continue;
      label107:
      d.h(this.a).b = System.currentTimeMillis();
      new com.wifi.connect.d.d(d.c(this.a), d.d(this.a)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */