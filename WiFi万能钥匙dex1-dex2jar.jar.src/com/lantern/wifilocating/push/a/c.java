package com.lantern.wifilocating.push.a;

import android.text.TextUtils;
import com.lantern.wifilocating.push.util.g;

public final class c
{
  public static String a()
  {
    String str = g.f();
    if (str != null) {}
    for (str = String.format("%s%s", new Object[] { str, "/dc/hou.scmd" });; str = String.format("%s%s", new Object[] { "http://push-dc.51y5.net", "/dc/hou.scmd" })) {
      for (;;)
      {
        return str;
        try
        {
          str = ((com.lantern.wifilocating.push.c.a)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.a.class)).b();
          boolean bool = TextUtils.isEmpty(str);
          if (!bool) {}
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */