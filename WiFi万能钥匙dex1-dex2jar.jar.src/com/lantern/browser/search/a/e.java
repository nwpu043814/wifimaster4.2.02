package com.lantern.browser.search.a;

import android.text.TextUtils;

final class e
  implements com.bluefay.b.a
{
  e(a parama, com.bluefay.b.a parama1) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramString = (String)paramObject;
      if (!TextUtils.isEmpty(paramString)) {
        a.b(this.b, paramString);
      }
    }
    if (!TextUtils.isEmpty(a.c(this.b))) {
      this.a.a(1, null, a.c(this.b));
    }
    for (;;)
    {
      return;
      this.a.a(0, null, null);
      a.d(this.b);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */