package com.lantern.webox.a.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.Formatter;
import bluefay.app.k.a;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.browser.R.string;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.browser.n;
import com.lantern.core.c;
import com.lantern.core.config.d;
import com.lantern.core.d.a.c;
import com.lantern.webox.a.k;
import com.lantern.webox.domain.WebDownRequest;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o
  implements k
{
  private void b(WkBrowserWebView paramWkBrowserWebView, WebDownRequest paramWebDownRequest)
  {
    new Handler(Looper.getMainLooper()).post(new s(this, paramWkBrowserWebView));
    n localn = n.b();
    String str = paramWebDownRequest.getUrl();
    paramWebDownRequest.getUserAgent();
    localn.a(str, paramWebDownRequest.getContentDisposition(), paramWebDownRequest.getMimetype());
    new Handler(Looper.getMainLooper()).post(new t(this, paramWkBrowserWebView));
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView, WebDownRequest paramWebDownRequest)
  {
    int k = 0;
    Object localObject1 = Environment.getExternalStorageState();
    if (!((String)localObject1).equals("mounted")) {
      new Handler(Looper.getMainLooper()).post(new p(this, (String)localObject1, paramWkBrowserWebView));
    }
    for (;;)
    {
      return;
      Object localObject2 = paramWkBrowserWebView.getContext();
      if (!e.c((Context)localObject2))
      {
        e.a(R.string.browser_download_not_connect_network);
      }
      else
      {
        Object localObject3 = Uri.parse(paramWebDownRequest.getUrl());
        localObject1 = "";
        if (localObject3 != null) {
          localObject1 = ((Uri)localObject3).getHost();
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          e.a(R.string.browser_download_url_invalid);
        }
        else
        {
          localObject3 = d.a(paramWkBrowserWebView.getContext()).a("download_wl");
          int i = k;
          if (localObject3 != null) {
            localObject3 = ((JSONObject)localObject3).optJSONArray("list");
          }
          for (int j = 0;; j++)
          {
            i = k;
            if (j < ((JSONArray)localObject3).length())
            {
              if (((String)localObject1).contains(((JSONArray)localObject3).optString(j))) {
                i = 1;
              }
            }
            else
            {
              if (i == 0) {
                break label192;
              }
              b(paramWkBrowserWebView, paramWebDownRequest);
              break;
            }
          }
          label192:
          q localq = new q(this, paramWkBrowserWebView, paramWebDownRequest);
          localObject3 = new r(this);
          localObject1 = "";
          if (e.b((Context)localObject2))
          {
            com.lantern.analytics.a.e().onEvent("dlmw");
            localObject1 = paramWkBrowserWebView.getContext().getResources().getString(R.string.browser_download_mobile_network) + "\n\n";
          }
          localObject2 = (String)localObject1 + paramWebDownRequest.getFilename() + "\n";
          localObject1 = localObject2;
          if (paramWebDownRequest.getContentLength() > 0L) {
            localObject1 = (String)localObject2 + paramWkBrowserWebView.getContext().getResources().getString(R.string.browser_download_tip_size) + Formatter.formatShortFileSize(paramWkBrowserWebView.getContext(), paramWebDownRequest.getContentLength());
          }
          paramWkBrowserWebView = new k.a(paramWkBrowserWebView.getContext());
          paramWkBrowserWebView.a(R.string.browser_download_tip_title);
          paramWkBrowserWebView.b((CharSequence)localObject1);
          paramWkBrowserWebView.a(R.string.browser_download_confirm, localq).b(R.string.browser_download_cancel, (DialogInterface.OnClickListener)localObject3);
          paramWkBrowserWebView.d();
          com.lantern.analytics.a.e().onEvent("brohold");
        }
      }
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      String str1 = localJSONObject.optString("url");
      if (TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        return;
        String str2 = localJSONObject.optString("icon");
        Object localObject = localJSONObject.optString("name");
        paramString = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramString = bp.f(str1);
        }
        localObject = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject = UUID.randomUUID().toString();
        }
        boolean bool = localJSONObject.optBoolean("onlyWifi");
        paramString = new com/lantern/core/d/a$c;
        paramString.<init>(Uri.parse(str1));
        if (!TextUtils.isEmpty(str2)) {
          paramString.a(str2);
        }
        paramString.b("/WifiMasterKey/apk", (String)localObject);
        if (bool) {
          paramString.a();
        }
        localObject = new com/lantern/core/d/a;
        ((com.lantern.core.d.a)localObject).<init>(c.getAppContext());
        bp.a(((com.lantern.core.d.a)localObject).a(paramString));
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */