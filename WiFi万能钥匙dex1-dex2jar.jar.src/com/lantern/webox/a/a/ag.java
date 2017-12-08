package com.lantern.webox.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.browser.R.drawable;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.core.imageloader.f;
import com.lantern.webox.a.i;
import com.lantern.webox.c.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag
  implements i
{
  private a a = new a((byte)0);
  
  private static void b(Context paramContext, String paramString1, boolean paramBoolean, Bitmap paramBitmap, String paramString2)
  {
    if (paramContext == null) {}
    String str;
    do
    {
      return;
      str = paramString1;
      if (paramString1 == null) {
        str = paramContext.getApplicationInfo().name;
      }
    } while (TextUtils.isEmpty(paramString2));
    paramString1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    paramString1.putExtra("duplicate", paramBoolean);
    paramString1.putExtra("android.intent.extra.shortcut.NAME", str);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramString1.putExtra("android.intent.extra.shortcut.ICON", paramBitmap);
    }
    for (;;)
    {
      paramBitmap = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
      paramBitmap.setPackage(paramContext.getPackageName());
      paramBitmap.addFlags(268468224);
      paramBitmap.putExtra("location", "shortcut");
      paramString1.putExtra("android.intent.extra.shortcut.INTENT", paramBitmap);
      paramContext.sendBroadcast(paramString1);
      break;
      paramString1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, R.drawable.browser_game_shortcut));
    }
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView, String paramString)
  {
    boolean bool = false;
    Object localObject3 = b.a(paramString);
    String str1 = (String)((Map)localObject3).get("action");
    paramString = (String)((Map)localObject3).get("className");
    String str2 = (String)((Map)localObject3).get("ext");
    Object localObject1 = (String)((Map)localObject3).get("callback");
    Object localObject2 = ((Map)localObject3).get("type");
    localObject3 = ((Map)localObject3).get("startactivityforresult");
    if ((localObject2 instanceof Integer)) {}
    for (int i = ((Integer)localObject2).intValue();; i = 0)
    {
      if ((localObject3 instanceof Boolean)) {
        bool = ((Boolean)localObject3).booleanValue();
      }
      for (;;)
      {
        try
        {
          localObject2 = new android/content/Intent;
          ((Intent)localObject2).<init>();
          ((Intent)localObject2).setPackage(paramWkBrowserWebView.getContext().getPackageName());
          if (!TextUtils.isEmpty(str2)) {
            ((Intent)localObject2).putExtra("ext", str2);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((Intent)localObject2).putExtra("callback", (String)localObject1);
          }
          localObject1 = paramWkBrowserWebView.getContext();
          if ((i != 0) && (i != 1)) {
            continue;
          }
          if (!TextUtils.isEmpty(str1))
          {
            ((Intent)localObject2).setAction(str1);
            if (i != 0) {
              continue;
            }
            if ((!bool) || (!(localObject1 instanceof Activity))) {
              continue;
            }
            ((Activity)localObject1).startActivityForResult((Intent)localObject2, 11002);
            return;
          }
        }
        catch (Exception paramWkBrowserWebView)
        {
          h.a(paramWkBrowserWebView);
          continue;
          paramWkBrowserWebView.getContext().startActivity((Intent)localObject2);
          continue;
          paramWkBrowserWebView.getContext().startService((Intent)localObject2);
          continue;
          if (i != 2) {
            continue;
          }
          if (TextUtils.isEmpty(str1)) {
            continue;
          }
          ((Intent)localObject2).setAction(str1);
          paramWkBrowserWebView.getContext().sendBroadcast((Intent)localObject2);
          continue;
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((Intent)localObject2).setClassName(paramWkBrowserWebView.getContext(), paramString);
        }
      }
    }
  }
  
  public final void b(WkBrowserWebView paramWkBrowserWebView, String paramString)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    Context localContext = com.lantern.core.c.getAppContext();
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramString);
        str1 = ((JSONObject)localObject1).optString("name", null);
        bool2 = bool3;
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            bool1 = ((JSONObject)localObject1).optBoolean("duplicate", false);
            bool2 = bool1;
            paramString = ((JSONObject)localObject1).optString("icon", null);
          }
          catch (JSONException localJSONException2)
          {
            String str3;
            String str2;
            paramString = null;
            bool1 = bool2;
            continue;
          }
          try
          {
            str3 = ((JSONObject)localObject1).optString("url", null);
            localObject1 = paramString;
            paramString = str3;
            if (!TextUtils.isEmpty(paramString)) {
              continue;
            }
            return;
          }
          catch (JSONException localJSONException3) {}
        }
        localJSONException1 = localJSONException1;
        str1 = null;
        paramString = null;
        bool1 = bool2;
      }
      str3 = null;
      str2 = paramString;
      paramString = str3;
      continue;
      if ((e.c(localContext)) && (!TextUtils.isEmpty(str2)) && (URLUtil.isNetworkUrl(str2)))
      {
        this.a.a(new ah(this, localContext, str1, bool1, paramString));
        com.lantern.core.imageloader.c.a(localContext, str2, this.a);
      }
      for (;;)
      {
        paramString = new HashMap();
        paramString.put("url", paramWkBrowserWebView.getUrl());
        a.e().onEvent("brostct", new JSONObject(paramString).toString());
        break;
        b(localContext, str1, bool1, null, paramString);
      }
      paramString = null;
      Object localObject2 = null;
      String str1 = null;
    }
  }
  
  private static final class a
    implements f
  {
    private ag.b a;
    
    public final void a()
    {
      if (this.a != null)
      {
        this.a.a();
        this.a = null;
      }
    }
    
    public final void a(Bitmap paramBitmap)
    {
      if (this.a != null)
      {
        this.a.a(paramBitmap);
        this.a = null;
      }
    }
    
    public final void a(ag.b paramb)
    {
      this.a = paramb;
    }
  }
  
  private static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(Bitmap paramBitmap);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */