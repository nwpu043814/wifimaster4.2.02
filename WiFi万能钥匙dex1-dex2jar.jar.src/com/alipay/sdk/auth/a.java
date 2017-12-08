package com.alipay.sdk.auth;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

final class a
  implements DownloadListener
{
  a(AuthActivity paramAuthActivity) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString1 = Uri.parse(paramString1);
      paramString2 = new android/content/Intent;
      paramString2.<init>("android.intent.action.VIEW", paramString1);
      this.a.startActivity(paramString2);
      return;
    }
    catch (Throwable paramString1)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/auth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */