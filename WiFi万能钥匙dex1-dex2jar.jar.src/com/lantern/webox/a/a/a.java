package com.lantern.webox.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.cc;
import com.lantern.browser.j;
import com.lantern.browser.n;
import com.lantern.core.d.a.b;
import com.lantern.webox.a.a.a;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements com.lantern.webox.a.a
{
  private static String a(Context paramContext, String paramString1, String paramString2)
  {
    j localj = n.b().d(paramString1);
    localObject1 = "NOT_DOWNLOAD";
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty(paramString2)) {
      localObject2 = localObject1;
    }
    try
    {
      if (paramContext.getPackageManager().getApplicationInfo(paramString2, 8192) != null) {
        localObject2 = "INSTALLED";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Cursor localCursor;
        int i;
        String str;
        Object localObject3 = localObject1;
      }
    }
    localObject1 = localObject2;
    if (!"INSTALLED".equals(localObject2))
    {
      localObject1 = localObject2;
      if (localj != null)
      {
        localObject1 = new a.b();
        ((a.b)localObject1).a(new long[] { localj.b() });
        localCursor = new com.lantern.core.d.a(paramContext).a((a.b)localObject1);
        localObject1 = localObject2;
        if (localCursor != null)
        {
          localObject1 = localObject2;
          if (localCursor.moveToFirst())
          {
            i = localCursor.getColumnIndex("_data");
            localObject1 = null;
            paramContext = (Context)localObject1;
            if (i != -1)
            {
              str = localCursor.getString(i);
              paramContext = (Context)localObject1;
              if (!TextUtils.isEmpty(str))
              {
                paramContext = (Context)localObject1;
                if (Uri.parse(str) != null) {
                  paramContext = new File(Uri.parse(str).getPath());
                }
              }
            }
            localObject1 = localObject2;
            if (paramContext != null)
            {
              localObject1 = localObject2;
              if (paramContext.exists()) {
                switch (localCursor.getInt(localCursor.getColumnIndex("status")))
                {
                default: 
                  localObject1 = "PAUSED";
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localj != null) {
        localj.a((String)localObject1);
      }
      h.a("getAppStatus aAppHid:" + paramString1 + " aPkg:" + paramString2 + " appStatus:" + (String)localObject1, new Object[0]);
      return (String)localObject1;
      localObject1 = "DOWNLOADING";
      continue;
      localObject1 = "DOWNLOADED";
    }
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView, String paramString)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("activateApp json:");
      h.a(paramString, new Object[0]);
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(paramString);
      paramString = new com/lantern/browser/j;
      paramString.<init>();
      if (!paramString.b((JSONObject)localObject)) {}
      for (;;)
      {
        return;
        localObject = paramWkBrowserWebView.getContext();
        if (!(localObject instanceof Activity)) {
          break;
        }
        paramWkBrowserWebView = (Activity)localObject;
        n.b().a(paramWkBrowserWebView, paramString);
      }
    }
    catch (Exception paramWkBrowserWebView)
    {
      for (;;)
      {
        paramWkBrowserWebView.printStackTrace();
        continue;
        paramWkBrowserWebView = paramWkBrowserWebView.b();
        if (paramWkBrowserWebView != null) {
          paramWkBrowserWebView = paramWkBrowserWebView.getActivity();
        } else {
          paramWkBrowserWebView = null;
        }
      }
    }
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView, String paramString, a.a parama)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("getAppStatus json:");
        h.a(paramString, new Object[0]);
        localObject1 = new org/json/JSONArray;
        ((JSONArray)localObject1).<init>();
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>();
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(paramString);
        localJSONArray = ((JSONObject)localObject2).optJSONArray("appList");
        if ((localJSONArray == null) || (localJSONArray.length() == 0))
        {
          h.a("getActivateAppStatus appList is empty", new Object[0]);
          localJSONObject.put("appStatus", ((JSONArray)localObject1).toString());
          parama.a(localJSONObject.toString());
          return;
        }
      }
      catch (Exception paramWkBrowserWebView)
      {
        Object localObject1;
        JSONObject localJSONObject;
        Object localObject2;
        JSONArray localJSONArray;
        String str;
        h.a(paramWkBrowserWebView);
        continue;
      }
      if (i < localJSONArray.length())
      {
        paramString = localJSONArray.optJSONObject(i);
        str = paramString.optString("appHid");
        localObject2 = paramString.optString("pkg");
        if ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          paramString.put("status", a(paramWkBrowserWebView.getContext(), str, (String)localObject2));
          ((JSONArray)localObject1).put(paramString);
        }
        i++;
      }
      else
      {
        localJSONObject.put("appStatus", ((JSONArray)localObject1).toString());
        parama.a(((JSONArray)localObject1).toString());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */