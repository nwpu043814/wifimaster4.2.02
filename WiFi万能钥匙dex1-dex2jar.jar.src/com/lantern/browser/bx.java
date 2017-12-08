package com.lantern.browser;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView.HitTestResult;
import com.bluefay.b.h;

final class bx
  extends Handler
{
  bx(WkBrowserWebView paramWkBrowserWebView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject2 = paramMessage.getData().getString("url");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramMessage.getData().getString("src");
    }
    int k = 0;
    j = 0;
    i = k;
    try
    {
      localObject2 = this.a.getHitTestResult();
      paramMessage = (Message)localObject1;
      if (localObject2 != null)
      {
        i = k;
        k = ((WebView.HitTestResult)localObject2).getType();
        paramMessage = (Message)localObject1;
        j = k;
        i = k;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          i = k;
          paramMessage = ((WebView.HitTestResult)localObject2).getExtra();
          j = k;
        }
      }
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        h.a(paramMessage);
        paramMessage = (Message)localObject1;
        j = i;
      }
    }
    if ((!TextUtils.isEmpty(paramMessage)) && (WkBrowserWebView.a(this.a) != null)) {
      WkBrowserWebView.a(this.a).a(j, paramMessage);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */