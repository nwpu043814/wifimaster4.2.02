package com.lantern.webox.handler;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import com.bluefay.b.h;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.c.a;
import com.lantern.browser.cc;
import com.lantern.browser.d;
import com.lantern.webox.b.e;
import com.lantern.webox.b.f;
import com.lantern.webox.c.b;
import com.lantern.webox.event.WebEvent;

public final class g
  extends d
{
  private f a;
  private WkBrowserWebView b;
  private e c = new e(getClass());
  
  public g(WkBrowserWebView paramWkBrowserWebView, String paramString, Class paramClass)
  {
    super(paramString, paramClass);
    this.b = paramWkBrowserWebView;
    this.a = new f();
    paramWkBrowserWebView.setWebChromeClient(this);
  }
  
  public final void onCloseWindow(WebView paramWebView)
  {
    super.onCloseWindow(paramWebView);
    paramWebView = (WkBrowserWebView)paramWebView;
    paramWebView.a(new WebEvent(paramWebView, 10));
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    new StringBuilder("onCreateWindow: ").append(paramMessage.toString());
    if (this.b.b() != null) {}
    for (paramBoolean1 = this.b.b().a(paramWebView, paramMessage);; paramBoolean1 = true)
    {
      return paramBoolean1;
      ((WebView.WebViewTransport)paramMessage.obj).setWebView(paramWebView);
      paramMessage.sendToTarget();
    }
  }
  
  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramQuotaUpdater.updateQuota(2L * paramLong2);
  }
  
  /* Error */
  public final void onGeolocationPermissionsShowPrompt(String paramString, android.webkit.GeolocationPermissions.Callback paramCallback)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 119	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   4: invokevirtual 122	android/net/Uri:getHost	()Ljava/lang/String;
    //   7: astore 5
    //   9: new 124	java/util/ArrayList
    //   12: astore 4
    //   14: aload 4
    //   16: invokespecial 125	java/util/ArrayList:<init>	()V
    //   19: aload_0
    //   20: getfield 30	com/lantern/webox/handler/g:b	Lcom/lantern/browser/WkBrowserWebView;
    //   23: invokevirtual 129	com/lantern/browser/WkBrowserWebView:getContext	()Landroid/content/Context;
    //   26: invokestatic 134	com/lantern/core/config/d:a	(Landroid/content/Context;)Lcom/lantern/core/config/d;
    //   29: ldc -120
    //   31: invokevirtual 139	com/lantern/core/config/d:a	(Ljava/lang/Class;)Lcom/lantern/core/config/a;
    //   34: checkcast 136	com/lantern/core/config/LocationWhiteListConf
    //   37: astore 6
    //   39: aload 6
    //   41: ifnull +77 -> 118
    //   44: aload 6
    //   46: invokevirtual 143	com/lantern/core/config/LocationWhiteListConf:d	()Ljava/util/List;
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull +60 -> 113
    //   56: aload 4
    //   58: invokeinterface 149 1 0
    //   63: astore 4
    //   65: aload 4
    //   67: invokeinterface 155 1 0
    //   72: ifeq +41 -> 113
    //   75: aload 5
    //   77: aload 4
    //   79: invokeinterface 159 1 0
    //   84: checkcast 161	java/lang/String
    //   87: invokevirtual 165	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifeq -25 -> 65
    //   93: iconst_1
    //   94: istore_3
    //   95: aload_2
    //   96: aload_1
    //   97: iload_3
    //   98: iconst_0
    //   99: invokeinterface 171 4 0
    //   104: return
    //   105: astore_1
    //   106: aload_1
    //   107: invokestatic 176	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   110: goto -6 -> 104
    //   113: iconst_0
    //   114: istore_3
    //   115: goto -20 -> 95
    //   118: goto -67 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	g
    //   0	121	1	paramString	String
    //   0	121	2	paramCallback	android.webkit.GeolocationPermissions.Callback
    //   94	21	3	bool	boolean
    //   12	66	4	localObject	Object
    //   7	69	5	str	String
    //   37	8	6	localLocationWhiteListConf	com.lantern.core.config.LocationWhiteListConf
    // Exception table:
    //   from	to	target	type
    //   0	39	105	java/lang/Exception
    //   44	51	105	java/lang/Exception
    //   56	65	105	java/lang/Exception
    //   65	93	105	java/lang/Exception
    //   95	104	105	java/lang/Exception
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if ((this.a != null) && (paramString2.startsWith("__jsi:")))
    {
      paramString1 = paramString2.substring(6);
      h.a("onJsPrompt " + paramString1, new Object[0]);
      paramWebView = f.a((WkBrowserWebView)paramWebView, b.a(paramString1));
      if (paramWebView == null)
      {
        paramWebView = "";
        paramJsPromptResult.confirm(paramWebView);
      }
    }
    for (boolean bool = true;; bool = super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult))
    {
      return bool;
      paramWebView = paramWebView.toString();
      break;
    }
  }
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    WkBrowserWebView localWkBrowserWebView = (WkBrowserWebView)paramWebView;
    if (!TextUtils.isEmpty(paramWebView.getUrl())) {
      localWkBrowserWebView.d(paramWebView.getUrl());
    }
    if (paramInt >= 90) {
      a.c(localWkBrowserWebView.getUrl(), localWkBrowserWebView.l());
    }
    localWkBrowserWebView.a(new WebEvent(localWkBrowserWebView, 1, Integer.valueOf(paramInt)));
  }
  
  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramQuotaUpdater.updateQuota(2L * paramLong1);
  }
  
  public final void onReceivedIcon(WebView paramWebView, Bitmap paramBitmap)
  {
    paramWebView = (WkBrowserWebView)paramWebView;
    paramWebView.a(new WebEvent(paramWebView, 2, paramBitmap));
  }
  
  public final void onReceivedTitle(WebView paramWebView, String paramString)
  {
    paramWebView = (WkBrowserWebView)paramWebView;
    paramWebView.b(paramString);
    paramWebView.a(new WebEvent(paramWebView, 3, paramString));
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback)
  {
    if (this.b.b() != null) {
      this.b.b().a(paramValueCallback, "", "");
    }
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString)
  {
    if (this.b.b() != null) {
      this.b.b().a(paramValueCallback, paramString, "");
    }
  }
  
  public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (this.b.b() != null) {
      this.b.b().a(paramValueCallback, paramString1, paramString2);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/handler/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */