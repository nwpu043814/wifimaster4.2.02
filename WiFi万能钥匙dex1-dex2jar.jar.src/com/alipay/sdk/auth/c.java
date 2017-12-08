package com.alipay.sdk.auth;

import android.webkit.WebView;

final class c
  implements Runnable
{
  c(AuthActivity paramAuthActivity, String paramString) {}
  
  public final void run()
  {
    try
    {
      WebView localWebView = AuthActivity.h(this.b);
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("javascript:");
      localWebView.loadUrl(this.a);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/auth/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */