package com.lantern.feed.a;

import android.os.Handler;
import android.os.Message;
import com.bluefay.b.a;
import com.bluefay.b.h;
import com.lantern.feed.b.n;

final class y
  implements a
{
  y(m paramm) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      h.a("loadTagTemplateFromNetInner success", new Object[0]);
      paramString = new n();
      paramString.a("cds003001");
      paramString.b((String)paramObject);
      paramObject = new Message();
      ((Message)paramObject).what = 30;
      ((Message)paramObject).obj = paramString;
      m.t(this.a).sendMessage((Message)paramObject);
    }
    for (;;)
    {
      return;
      h.a("loadTagTemplateFromNetInner failed retry", new Object[0]);
      this.a.f();
      paramString = new m.b(this.a, (byte)0);
      paramString.a = "call0";
      paramString.b = "cds003001";
      paramString.c = "-1";
      paramString.d = "network error";
      m.a(paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */