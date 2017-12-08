package com.lantern.auth;

import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.o;

final class c
  implements com.bluefay.b.a
{
  c(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    paramObject = (com.lantern.auth.b.b)paramObject;
    h.a("SmsContent", new Object[] { ((com.lantern.auth.b.b)paramObject).a() });
    if (paramInt == 10)
    {
      h.c("Get SMS content network failed");
      a.a(this.a);
      a.a(this.a, 0, null);
    }
    for (;;)
    {
      return;
      if (("0".equals(((com.lantern.auth.b.b)paramObject).a())) && (!TextUtils.isEmpty(((com.lantern.auth.b.b)paramObject).c())) && (!TextUtils.isEmpty(((com.lantern.auth.b.b)paramObject).b())))
      {
        paramString = ((com.lantern.auth.b.b)paramObject).c();
        paramObject = ((com.lantern.auth.b.b)paramObject).b();
        a.b(this.a).a(paramString, (String)paramObject, "app_auto", com.lantern.core.c.getServer().k());
      }
      else
      {
        h.c("Get SMS content failed");
        a.a(this.a, 0, null);
        a.a(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */