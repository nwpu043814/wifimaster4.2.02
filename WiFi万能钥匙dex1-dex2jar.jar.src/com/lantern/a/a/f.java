package com.lantern.a.a;

import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.k;
import java.util.ArrayList;

final class f
  implements com.bluefay.b.a
{
  f(e parame) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject == null) || (TextUtils.isEmpty((String)paramObject))) {
      com.lantern.analytics.a.e().onEvent("kpAD_rnon");
    }
    for (;;)
    {
      return;
      com.lantern.analytics.a.e().onEvent("uadr");
      h.b("splash mCallback 1111");
      e.a(this.a);
      h.b("splash mCallback 2222");
      d locald = j.a((String)paramObject);
      paramString = e.b(this.a);
      this.a.b = false;
      e.a(this.a, locald, paramString);
      h.b("splash mCallback 3333");
      if ((e.c(this.a) != null) && (e.c(this.a).size() > 0))
      {
        e.a(this.a, (String)paramObject);
        e.b(this.a, k.l(e.d(this.a)));
        e.e(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */