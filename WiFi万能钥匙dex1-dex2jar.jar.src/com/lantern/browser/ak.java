package com.lantern.browser;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bluefay.b.a;

final class ak
  implements a
{
  ak(String paramString, WebView paramWebView) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(this.a))
    {
      if (paramInt != 1) {
        break label38;
      }
      WkBrowserJsInterface.access$700(this.b, this.a, new String[] { (String)paramObject });
    }
    for (;;)
    {
      return;
      label38:
      WkBrowserJsInterface.access$700(this.b, this.a, new String[] { "" });
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */