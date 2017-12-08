package com.lantern.webox.handler;

import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.bluefay.b.h;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.webox.a.k;
import com.lantern.webox.b.e;
import com.lantern.webox.d;
import com.lantern.webox.domain.WebAppConfig;
import com.lantern.webox.domain.WebDownRequest;
import java.util.Iterator;
import java.util.List;

public final class b
  implements DownloadListener
{
  private WkBrowserWebView a;
  private e b = new e(getClass());
  
  public b(WkBrowserWebView paramWkBrowserWebView)
  {
    this.a = paramWkBrowserWebView;
    this.a.setDownloadListener(this);
  }
  
  private void a(WebDownRequest paramWebDownRequest)
  {
    WebAppConfig localWebAppConfig = this.a.e();
    if (!localWebAppConfig.isDownloadEnabled()) {
      h.a("download disabled", new Object[0]);
    }
    for (;;)
    {
      return;
      if ((a(localWebAppConfig.getDownloadWhiteList(), paramWebDownRequest.getFilename())) || (!a(localWebAppConfig.getDownloadBlackList(), paramWebDownRequest.getFilename()))) {
        ((k)d.a(k.class)).a(this.a, paramWebDownRequest);
      } else {
        h.a("download has been blocked: " + paramWebDownRequest.getFilename(), new Object[0]);
      }
    }
  }
  
  private static boolean a(List<String> paramList, String paramString)
  {
    boolean bool;
    if (paramList == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext()) {
          if (paramString.matches((String)paramList.next()))
          {
            bool = true;
            break;
          }
        }
      }
      bool = false;
    }
  }
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    WebDownRequest localWebDownRequest = new WebDownRequest();
    localWebDownRequest.setUrl(paramString1);
    localWebDownRequest.setUserAgent(paramString2);
    localWebDownRequest.setContentDisposition(paramString3);
    localWebDownRequest.setMimetype(paramString4);
    localWebDownRequest.setCookies(CookieManager.getInstance().getCookie(paramString1));
    String str = bp.f(paramString1);
    paramString2 = str;
    if (TextUtils.isEmpty(bp.e(str))) {
      paramString2 = URLUtil.guessFileName(paramString1, paramString3, paramString4);
    }
    localWebDownRequest.setFilename(paramString2);
    localWebDownRequest.setContentLength(paramLong);
    if (this.a.e() == null)
    {
      paramString1 = new c(this, localWebDownRequest);
      this.a.a(paramString1);
    }
    for (;;)
    {
      return;
      a(localWebDownRequest);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/handler/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */