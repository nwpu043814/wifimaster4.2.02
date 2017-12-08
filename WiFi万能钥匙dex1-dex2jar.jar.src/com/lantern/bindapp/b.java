package com.lantern.bindapp;

import android.os.Handler;
import android.os.Message;
import com.bluefay.b.h;
import java.util.ArrayList;

final class b
  implements com.bluefay.b.a
{
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.a("retCode:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      if (paramObject != null) {
        break label113;
      }
      paramObject = new ArrayList();
    }
    label113:
    for (;;)
    {
      if (a.b()) {
        com.lantern.analytics.a.e().onEvent("bndrd10");
      }
      if (a.c() != null) {
        a.a(com.lantern.bindapp.c.a.a(a.c(), (ArrayList)paramObject));
      }
      for (;;)
      {
        paramString = new Message();
        paramString.what = 2;
        paramString.arg1 = 1;
        a.d().sendMessage(paramString);
        a.d().sendEmptyMessage(3);
        return;
        a.a((ArrayList)paramObject);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/bindapp/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */