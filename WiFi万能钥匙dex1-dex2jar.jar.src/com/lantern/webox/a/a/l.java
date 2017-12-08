package com.lantern.webox.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bluefay.b.h;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.cc;
import com.lantern.webox.a.g;

public final class l
  implements g
{
  public final void a(WkBrowserWebView paramWkBrowserWebView)
  {
    try
    {
      paramWkBrowserWebView = paramWkBrowserWebView.b();
      if (paramWkBrowserWebView != null) {
        paramWkBrowserWebView.j();
      }
      return;
    }
    catch (Exception paramWkBrowserWebView)
    {
      for (;;)
      {
        h.a(paramWkBrowserWebView);
      }
    }
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView, int paramInt)
  {
    paramInt = -paramInt;
    try
    {
      paramWkBrowserWebView.goBackOrForward(paramInt);
      return;
    }
    catch (Exception paramWkBrowserWebView)
    {
      for (;;)
      {
        h.a(paramWkBrowserWebView);
      }
    }
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView, String paramString)
  {
    try
    {
      paramString = paramString.replaceAll(" ", "%20");
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("wifi.intent.action.BROWSER", Uri.parse(paramString));
      localIntent.addFlags(268435456);
      localIntent.setPackage(paramWkBrowserWebView.getContext().getPackageName());
      paramWkBrowserWebView.getContext().startActivity(localIntent);
      return;
    }
    catch (Exception paramWkBrowserWebView)
    {
      for (;;)
      {
        h.a(paramWkBrowserWebView);
      }
    }
  }
  
  public final void b(WkBrowserWebView paramWkBrowserWebView)
  {
    try
    {
      paramWkBrowserWebView.b();
      return;
    }
    catch (Exception paramWkBrowserWebView)
    {
      for (;;)
      {
        h.a(paramWkBrowserWebView);
      }
    }
  }
  
  public final void b(WkBrowserWebView paramWkBrowserWebView, int paramInt)
  {
    try
    {
      paramWkBrowserWebView.goBackOrForward(paramInt);
      return;
    }
    catch (Exception paramWkBrowserWebView)
    {
      for (;;)
      {
        h.a(paramWkBrowserWebView);
      }
    }
  }
  
  public final void c(WkBrowserWebView paramWkBrowserWebView)
  {
    paramWkBrowserWebView = paramWkBrowserWebView.b();
    if (paramWkBrowserWebView != null) {
      paramWkBrowserWebView.h();
    }
  }
  
  public final void d(WkBrowserWebView paramWkBrowserWebView)
  {
    paramWkBrowserWebView = paramWkBrowserWebView.b();
    if (paramWkBrowserWebView != null) {
      paramWkBrowserWebView.i();
    }
  }
  
  public final void e(WkBrowserWebView paramWkBrowserWebView)
  {
    paramWkBrowserWebView = paramWkBrowserWebView.b();
    if (paramWkBrowserWebView != null) {
      paramWkBrowserWebView.k();
    }
  }
  
  public final void f(WkBrowserWebView paramWkBrowserWebView)
  {
    paramWkBrowserWebView = paramWkBrowserWebView.b();
    if (paramWkBrowserWebView != null) {
      paramWkBrowserWebView.l();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */