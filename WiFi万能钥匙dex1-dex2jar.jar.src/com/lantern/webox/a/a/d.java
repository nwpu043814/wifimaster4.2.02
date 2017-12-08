package com.lantern.webox.a.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import bluefay.app.k.a;
import com.lantern.analytics.a;
import com.lantern.browser.R.string;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.browser.l;
import com.lantern.browser.n;
import com.lantern.browser.z;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.webox.domain.AppStoreQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class d
  implements com.lantern.webox.a.d
{
  private Object a = new Object();
  
  private static void e(WkBrowserWebView paramWkBrowserWebView, AppStoreQuery paramAppStoreQuery)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("appid", paramAppStoreQuery.getAppHid());
    ((HashMap)localObject).put("tab", String.valueOf(paramAppStoreQuery.getTab()));
    ((HashMap)localObject).put("position", String.valueOf(paramAppStoreQuery.getPosition()));
    a.e().onEvent("bdlcli", new JSONObject((Map)localObject).toString());
    localObject = new com.lantern.browser.k();
    ((com.lantern.browser.k)localObject).a(paramAppStoreQuery.getAppHid());
    ((com.lantern.browser.k)localObject).d(paramAppStoreQuery.getPackageName());
    ((com.lantern.browser.k)localObject).c(paramAppStoreQuery.getTitle() + ".apk");
    ((com.lantern.browser.k)localObject).g(paramAppStoreQuery.getIcon());
    if (!TextUtils.isEmpty(paramAppStoreQuery.getApkURL())) {
      ((com.lantern.browser.k)localObject).e(paramAppStoreQuery.getApkURL());
    }
    for (;;)
    {
      ((com.lantern.browser.k)localObject).h(paramAppStoreQuery.getCompletedURL());
      ((com.lantern.browser.k)localObject).i(paramAppStoreQuery.getInstalledURL());
      n.b().b((com.lantern.browser.k)localObject);
      return;
      paramWkBrowserWebView = paramWkBrowserWebView.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("http://appstore.51y5.net/appstore/appdown.do");
      localStringBuilder.append("?");
      HashMap localHashMap = new HashMap();
      localHashMap.put("capSsid", bp.a(paramWkBrowserWebView));
      localHashMap.put("capBssid", bp.b(paramWkBrowserWebView));
      localHashMap.put("mac", com.lantern.core.k.e(paramWkBrowserWebView));
      localHashMap.put("appId", c.getServer().k());
      localHashMap.put("chanId", com.lantern.core.k.l(paramWkBrowserWebView));
      localHashMap.put("dhid", p.b(""));
      localHashMap.put("uhid", p.c(""));
      localHashMap.put("imei", com.lantern.core.k.c(paramWkBrowserWebView));
      localHashMap.put("lang", com.lantern.core.k.c());
      localHashMap.put("lati", c.getServer().d());
      localHashMap.put("longi", c.getServer().e());
      localHashMap.put("mapSP", c.getServer().o());
      localHashMap.put("netModel", com.lantern.core.k.n(paramWkBrowserWebView));
      localHashMap.put("origChanId", p.d(""));
      localHashMap.put("pid", "appdown");
      localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("userToken", "");
      localHashMap.put("verCode", String.valueOf(com.lantern.core.k.b(paramWkBrowserWebView)));
      localHashMap.put("verName", com.lantern.core.k.a(paramWkBrowserWebView));
      localHashMap.put("storeId", paramAppStoreQuery.getStoreId());
      localHashMap.put("readableId", paramAppStoreQuery.getReadableId());
      localHashMap.put("appHid", paramAppStoreQuery.getAppHid());
      localHashMap.put("pageIndex", String.valueOf(paramAppStoreQuery.getPageIndex()));
      localHashMap.put("position", String.valueOf(paramAppStoreQuery.getPosition()));
      localHashMap.put("dPos", String.valueOf(paramAppStoreQuery.getdPos()));
      localStringBuilder.append(z.b(localHashMap));
      ((com.lantern.browser.k)localObject).e(localStringBuilder.toString().trim());
    }
  }
  
  public final List<Object> a(WkBrowserWebView paramWkBrowserWebView, List<AppStoreQuery> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      AppStoreQuery localAppStoreQuery = (AppStoreQuery)localIterator.next();
      paramList = l.a().c(localAppStoreQuery.getAppHid());
      HashMap localHashMap = new HashMap();
      localHashMap.put("packageName", localAppStoreQuery.getPackageName());
      localHashMap.put("appHid", localAppStoreQuery.getAppHid());
      if (paramList != null)
      {
        com.bluefay.b.h.a("readAppStatus packageName:" + paramList.d() + " status:" + paramList.f(), new Object[0]);
        localHashMap.put("status", paramList.f());
      }
      for (;;)
      {
        localLinkedList.add(localHashMap);
        break;
        com.lantern.browser.k localk = new com.lantern.browser.k();
        localk.a(localAppStoreQuery.getAppHid());
        localk.d(localAppStoreQuery.getPackageName());
        str = "NOT_DOWNLOAD";
        paramList = str;
        try
        {
          if (paramWkBrowserWebView.getContext().getPackageManager().getApplicationInfo(localAppStoreQuery.getPackageName(), 8192) != null) {
            paramList = "INSTALLED";
          }
        }
        catch (Exception paramList)
        {
          for (;;)
          {
            paramList = str;
          }
        }
        localk.f(paramList);
        localArrayList.add(localk);
        com.bluefay.b.h.a("readAppStatus no apkInfo packageName:" + localAppStoreQuery.getPackageName() + " STATE_NOT_DOWNLOAD", new Object[0]);
        localHashMap.put("status", paramList);
      }
    }
    if (localArrayList.size() > 0) {
      new Thread(new e(this, localArrayList)).start();
    }
    return localLinkedList;
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView)
  {
    try
    {
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("wifi.intent.action.APPSTORE_MAIN");
      localIntent.setPackage(paramWkBrowserWebView.getContext().getPackageName());
      localIntent.addFlags(268435456);
      paramWkBrowserWebView.getContext().startActivity(localIntent);
      return;
    }
    catch (Exception paramWkBrowserWebView)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramWkBrowserWebView);
      }
    }
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView, AppStoreQuery paramAppStoreQuery)
  {
    Context localContext = paramWkBrowserWebView.getContext();
    if (!com.bluefay.a.e.c(localContext))
    {
      com.bluefay.a.e.a(R.string.browser_download_not_connect_network);
      return;
    }
    for (;;)
    {
      synchronized (this.a)
      {
        Object localObject2 = l.a().c(paramAppStoreQuery.getAppHid());
        if ((localObject2 == null) || (TextUtils.isEmpty(((com.lantern.browser.k)localObject2).f())) || (((com.lantern.browser.k)localObject2).f().equals("NOT_DOWNLOAD")) || (((com.lantern.browser.k)localObject2).f().equals("DOWNLOAD_FAIL")))
        {
          localObject2 = new com/lantern/webox/a/a/f;
          ((f)localObject2).<init>(this, paramWkBrowserWebView, paramAppStoreQuery);
          g localg = new com/lantern/webox/a/a/g;
          localg.<init>(this);
          if (!com.bluefay.a.e.b(localContext)) {
            break label186;
          }
          paramAppStoreQuery = new bluefay/app/k$a;
          paramAppStoreQuery.<init>(paramWkBrowserWebView.getContext());
          paramAppStoreQuery.a(R.string.browser_download_tip_title);
          paramAppStoreQuery.b(R.string.browser_download_mobile_network);
          paramAppStoreQuery.a(R.string.browser_download_confirm, (DialogInterface.OnClickListener)localObject2).b(R.string.browser_download_cancel, localg);
          paramAppStoreQuery.d();
          a.e().onEvent("dlmw");
        }
      }
      label186:
      e(paramWkBrowserWebView, paramAppStoreQuery);
    }
  }
  
  public final void a(AppStoreQuery paramAppStoreQuery)
  {
    paramAppStoreQuery = l.a().c(paramAppStoreQuery.getAppHid());
    if (paramAppStoreQuery != null) {
      n.b().c(paramAppStoreQuery);
    }
  }
  
  public final void b(WkBrowserWebView paramWkBrowserWebView, AppStoreQuery paramAppStoreQuery)
  {
    Context localContext = paramWkBrowserWebView.getContext();
    if (!com.bluefay.a.e.c(localContext)) {
      com.bluefay.a.e.a(R.string.browser_download_not_connect_network);
    }
    for (;;)
    {
      return;
      com.lantern.browser.k localk = l.a().c(paramAppStoreQuery.getAppHid());
      if (localk != null)
      {
        paramAppStoreQuery = new h(this, localk);
        i locali = new i(this);
        if (com.bluefay.a.e.b(localContext))
        {
          paramWkBrowserWebView = new k.a(paramWkBrowserWebView.getContext());
          paramWkBrowserWebView.a(R.string.browser_download_tip_title);
          paramWkBrowserWebView.b(R.string.browser_download_mobile_network);
          paramWkBrowserWebView.a(R.string.browser_download_confirm, paramAppStoreQuery).b(R.string.browser_download_cancel, locali);
          paramWkBrowserWebView.d();
          a.e().onEvent("dlmw");
        }
        else
        {
          n.b().d(localk);
        }
      }
    }
  }
  
  public final void b(AppStoreQuery paramAppStoreQuery)
  {
    a.e().onEvent("binscli", paramAppStoreQuery.getAppHid());
    com.lantern.browser.k localk = l.a().c(paramAppStoreQuery.getAppHid());
    if (localk != null)
    {
      a.e().onEvent("binssta0", paramAppStoreQuery.getAppHid());
      n.b().e(localk);
    }
  }
  
  public final void c(WkBrowserWebView paramWkBrowserWebView, AppStoreQuery paramAppStoreQuery)
  {
    try
    {
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("wifi.intent.action.APPSTORE_DETAIL_MAIN");
      localIntent.putExtra("appHid", paramAppStoreQuery.getAppHid());
      localIntent.setPackage(paramWkBrowserWebView.getContext().getPackageName());
      localIntent.addFlags(268435456);
      paramWkBrowserWebView.getContext().startActivity(localIntent);
      return;
    }
    catch (Exception paramWkBrowserWebView)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramWkBrowserWebView);
      }
    }
  }
  
  public final void c(AppStoreQuery paramAppStoreQuery)
  {
    a.e().onEvent("bopcli");
    n.b().c(paramAppStoreQuery.getPackageName());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */