package com.lantern.settings.a;

import android.os.Handler;
import android.os.Looper;

final class b
  implements com.bluefay.b.a
{
  b(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    new Handler(Looper.getMainLooper()).post(new c(this, paramInt));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */