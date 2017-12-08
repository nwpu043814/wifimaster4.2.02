package com.lantern.browser;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.ProgressBar;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.browser.ui.WkBrowserAppStoreFragment;
import com.lantern.browser.ui.WkBrowserFragment;
import com.lantern.webox.event.WebEvent;
import com.lantern.webox.event.c;
import com.lantern.webox.handler.g;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class bh
  implements cc, c
{
  private Context a;
  private WkBrowserWebView b;
  private boolean c = true;
  private at d;
  private bn e;
  
  public bh(bn parambn, at paramat, Context paramContext)
  {
    this.e = parambn;
    this.d = paramat;
    this.a = paramContext;
    parambn = cb.a(this.a);
    parambn.setVerticalScrollBarEnabled(true);
    parambn.a(this);
    parambn.a(this);
    new WkBrowserJsInterface();
    this.b = parambn;
  }
  
  public final WkBrowserWebView a()
  {
    return this.b;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.d.a(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt, String paramString)
  {
    this.d.a(paramInt, paramString);
  }
  
  public final void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    this.d.n().a(paramValueCallback, paramString1, paramString2);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public final boolean a(WebView paramWebView, Message paramMessage)
  {
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(new WkBrowserTabWindow.1(this));
    ((WebView.WebViewTransport)paramMessage.obj).setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    if (!this.d.i().b())
    {
      WkBrowserFragment localWkBrowserFragment = this.d.q();
      if ((!(localWkBrowserFragment instanceof WkBrowserAppStoreFragment)) || (!((WkBrowserAppStoreFragment)localWkBrowserFragment).b(paramString))) {}
    }
    for (boolean bool = true;; bool = bp.b((WkBrowserWebView)paramWebView, paramString)) {
      return bool;
    }
  }
  
  public final at b()
  {
    return this.d;
  }
  
  public final String c()
  {
    return this.b.getTitle();
  }
  
  public final String d()
  {
    return this.b.getUrl();
  }
  
  public final void e()
  {
    this.b.d();
  }
  
  public final void f() {}
  
  public final void g() {}
  
  public final Activity getActivity()
  {
    if (this.d != null) {}
    for (Activity localActivity = this.d.r();; localActivity = null) {
      return localActivity;
    }
  }
  
  public final void h()
  {
    new Handler(Looper.getMainLooper()).post(new bi(this));
  }
  
  public final void i()
  {
    new Handler(Looper.getMainLooper()).post(new bj(this));
  }
  
  public final void j()
  {
    new Handler(Looper.getMainLooper()).post(new bk(this));
  }
  
  public final void k()
  {
    new Handler(Looper.getMainLooper()).post(new bl(this));
  }
  
  public final void l()
  {
    new Handler(Looper.getMainLooper()).post(new bm(this));
  }
  
  public final void m()
  {
    this.d.w();
  }
  
  public final void onWebEvent(WebEvent paramWebEvent)
  {
    switch (paramWebEvent.getType())
    {
    }
    for (;;)
    {
      return;
      if (this.c) {
        this.d.b().setVisibility(0);
      }
      this.b.j().a();
      this.d.a((String)paramWebEvent.getData());
      continue;
      if (this.c)
      {
        this.b.j().a();
        this.b.j().a(this.b);
        this.d.o();
        continue;
        if (this.c)
        {
          this.d.a(((Integer)paramWebEvent.getData()).intValue());
          continue;
          this.b.j().a(this.b);
          try
          {
            JSONObject localJSONObject = new org/json/JSONObject;
            localJSONObject.<init>();
            localJSONObject.put("url", this.b.getUrl());
            localJSONObject.put("title", this.b.getTitle());
            localJSONObject.put("cts", String.valueOf(System.currentTimeMillis()));
            a.e().b("005016", localJSONObject);
            if (!this.c) {
              continue;
            }
            this.d.b(paramWebEvent.getData().toString());
          }
          catch (Exception localException)
          {
            for (;;)
            {
              h.a(localException);
            }
          }
          h.a("onReceivedError " + paramWebEvent.getData().toString(), new Object[0]);
          Object localObject = (HashMap)paramWebEvent.getData();
          int i = Integer.valueOf((String)((HashMap)localObject).get("errorCode")).intValue();
          paramWebEvent = (String)((HashMap)localObject).get("failingUrl");
          localObject = (String)((HashMap)localObject).get("description");
          if (Pattern.compile("\\.(jpg|jpeg|gif|png|bmp|js|css)").matcher(paramWebEvent).find()) {
            h.a("onReceivedError ignore this error", new Object[0]);
          }
          if ((paramWebEvent.startsWith("http://")) || (paramWebEvent.startsWith("https://")) || (paramWebEvent.startsWith("file://")))
          {
            this.d.a(i, (String)localObject, paramWebEvent);
          }
          else
          {
            h.a("onReceivedError ignore this error", new Object[0]);
            continue;
            localObject = (HashMap)paramWebEvent.getData();
            paramWebEvent = (String)((HashMap)localObject).get("failingUrl");
            localObject = (String)((HashMap)localObject).get("httpCode");
            if ((paramWebEvent.startsWith("http://")) || (paramWebEvent.startsWith("https://")) || (paramWebEvent.startsWith("file://")))
            {
              this.d.a((String)localObject, paramWebEvent);
            }
            else
            {
              h.a("onReceivedHttpCodeError ignore this error", new Object[0]);
              continue;
              this.e.a(this);
              continue;
              paramWebEvent = paramWebEvent.getData().toString();
              if (Pattern.compile("\\.(jpg|jpeg|gif|png|bmp|js|css)").matcher(paramWebEvent).find())
              {
                this.b.j().a(this.b);
                this.d.u();
                continue;
                this.d.v();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */