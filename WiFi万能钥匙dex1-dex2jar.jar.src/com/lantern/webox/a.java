package com.lantern.webox;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.core.config.d;
import com.lantern.core.g;
import com.lantern.core.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class a
{
  private Map<String, a> a = new HashMap();
  private a b;
  private WkBrowserWebView c;
  private boolean d;
  
  public a(WkBrowserWebView paramWkBrowserWebView)
  {
    a locala = new a((byte)0);
    locala.a = "AD0003";
    locala.b = "A!JqhZ#FZfrGKdn8";
    locala.c = "DoT9*pMgESQ0uRr@";
    locala.d = "0bpD7@XZIYCVjgU707Dy$n#5KqYoQNTm";
    this.a.put(locala.a, locala);
    this.c = paramWkBrowserWebView;
    this.c.a(new b(this));
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((paramString2.equals("init")) || (paramString2.equals("getJsApiVersion")) || (paramString2.equals("fetchInfo")) || (paramString2.equals("isAppInstalled")) || (paramString2.equals("getLocation")))
      {
        h.a("isApiAuthed " + paramString2 + " authed", new Object[0]);
        bool = true;
      }
      try
      {
        paramString1 = Uri.parse(paramString1.replaceAll(" ", "%20")).getHost();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          label144:
          Iterator localIterator;
          Object localObject;
          paramContext = null;
          h.a(paramString1);
        }
      }
      try
      {
        paramContext = d.a(paramContext).a("wkbrowser");
        if (paramContext == null) {
          break label370;
        }
        paramContext = paramContext.optString("jsapilists");
        if (TextUtils.isEmpty(paramContext)) {
          break label370;
        }
        paramContext = com.lantern.webox.c.b.a(paramContext);
      }
      catch (Exception localException)
      {
        paramContext = paramString1;
        paramString1 = localException;
        break;
        paramContext = null;
        break label214;
        break label154;
        paramContext = null;
        break label144;
      }
      if (paramContext != null) {
        break label367;
      }
      paramContext = com.lantern.webox.c.b.a("{'.51y5.com':['all'], '.51y5.net':['all'], '.y5store.com':['all'], '.lianwifi.com':['all'], '.wkanx.com':['all'], '.y5store.com':['all'], '.wifishenqi.com':['all'], '.wifi.com':['all'], '.lianwangtech.com':['all']}");
      label154:
      if (paramContext != null)
      {
        localIterator = paramContext.keySet().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (String)localIterator.next();
        } while (!paramString1.endsWith((String)localObject));
        paramContext = (List)paramContext.get(localObject);
        label214:
        if (paramContext != null)
        {
          localObject = paramContext.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              paramContext = (String)((Iterator)localObject).next();
              if ((paramContext.equals("all")) || (paramContext.equals(paramString2)))
              {
                paramContext = new java/lang/StringBuilder;
                paramContext.<init>("isApiAuthed ");
                h.a(paramString2 + " authed for " + paramString1, new Object[0]);
                bool = true;
                break;
              }
            }
          }
        }
      }
      paramContext = paramString1;
      h.a("isApiAuthed " + paramString2 + " NOT authed for " + paramContext, new Object[0]);
      bool = false;
    }
  }
  
  public final String a(String paramString)
  {
    if ((paramString == null) || (this.b == null)) {}
    for (paramString = "";; paramString = "AES:0:" + n.a(Uri.encode(paramString.trim(), "UTF-8"), this.b.b, this.b.c)) {
      return paramString;
    }
  }
  
  public final void a()
  {
    if (this.b != null) {}
    for (this.d = true;; this.d = false) {
      return;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3)
  {
    a locala = (a)this.a.get(paramString1);
    if ((locala != null) && (g.a(paramString1 + paramString2 + locala.d).equals(paramString3))) {
      this.b = locala;
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean b()
  {
    return this.d;
  }
  
  public final void c()
  {
    this.d = false;
  }
  
  public final void d()
  {
    this.b = null;
  }
  
  public final void e()
  {
    this.b = null;
    this.c = null;
    this.a.clear();
    this.a = null;
  }
  
  private static final class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */