package com.alipay.c.a.a.c.a;

import com.alipay.c.a.a.a.a;
import java.util.Map;

public final class b
{
  public static c a(com.alipay.f.a.a.b.a.a.b paramb)
  {
    c localc = new c();
    if (paramb == null) {}
    for (paramb = null;; paramb = localc)
    {
      return paramb;
      localc.a = paramb.a;
      localc.b = paramb.b;
      paramb = paramb.c;
      if (paramb != null)
      {
        localc.c = ((String)paramb.get("apdid"));
        localc.d = ((String)paramb.get("apdidToken"));
        localc.g = ((String)paramb.get("dynamicKey"));
        localc.h = ((String)paramb.get("timeInterval"));
        localc.i = ((String)paramb.get("webrtcUrl"));
        localc.j = "";
        paramb = (String)paramb.get("drmSwitch");
        if (a.b(paramb))
        {
          if (paramb.length() > 0) {
            localc.e = paramb.charAt(0);
          }
          if (paramb.length() >= 3) {
            localc.f = paramb.charAt(2);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */