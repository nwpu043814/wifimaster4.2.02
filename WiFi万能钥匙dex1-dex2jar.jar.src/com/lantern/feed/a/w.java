package com.lantern.feed.a;

import android.os.Handler;
import android.os.Message;
import com.bluefay.b.a;
import com.bluefay.b.h;
import com.lantern.feed.b.n;
import java.util.HashMap;

final class w
  implements a
{
  w(m paramm, HashMap paramHashMap) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      h.a("loadPopAdFromNetInner success", new Object[0]);
      paramString = new n();
      paramString.a("cds004002");
      paramString.a(this.a);
      paramString.b((String)paramObject);
      paramObject = new Message();
      ((Message)paramObject).what = 41;
      ((Message)paramObject).obj = paramString;
      m.t(this.b).sendMessage((Message)paramObject);
    }
    for (;;)
    {
      return;
      h.a("loadPopAdFromNetInner failed", new Object[0]);
      paramString = new m.b(this.b, (byte)0);
      paramString.a = "call0";
      paramString.b = "cds004002";
      paramString.c = "-1";
      paramString.d = "network error";
      m.a(paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */