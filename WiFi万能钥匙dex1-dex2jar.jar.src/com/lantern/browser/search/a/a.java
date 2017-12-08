package com.lantern.browser.search.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.f;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private static a a;
  private static ScheduledThreadPoolExecutor e;
  private a b;
  private List<com.lantern.browser.search.b.c> c = new ArrayList();
  private Handler d = new Handler(Looper.getMainLooper(), new b(this));
  private String f;
  private String g;
  private List<com.lantern.browser.search.b.d> h = new ArrayList();
  private long i;
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  private void b(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramString);
        if (((JSONObject)localObject1).optInt("retCd", -1) == 0)
        {
          paramString = ((JSONObject)localObject1).optString("result");
          if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
          {
            Object localObject2 = c(paramString);
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              this.g = paramString;
              l();
              this.i = System.currentTimeMillis();
              localObject1 = new com/lantern/browser/c/c;
              paramString = f.a(com.lantern.core.c.getAppContext()).a("searchhost");
              if (!TextUtils.isEmpty(paramString)) {
                continue;
              }
              paramString = "https://searchcds.51y5.net/hotwords.do";
              localObject3 = new java/util/HashMap;
              ((HashMap)localObject3).<init>();
              ((HashMap)localObject3).put("token", localObject2);
              ((HashMap)localObject3).put("count", "10");
              localObject2 = new com/lantern/browser/search/a/d;
              ((d)localObject2).<init>(this);
              ((com.lantern.browser.c.c)localObject1).<init>(paramString, (Map)localObject3, (com.bluefay.b.a)localObject2);
              ((com.lantern.browser.c.c)localObject1).execute(new String[] { "" });
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        Object localObject3;
        h.a(paramString);
        continue;
      }
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      paramString = paramString + "hotwords.do";
    }
  }
  
  private static String c(String paramString)
  {
    String str = "";
    Object localObject = str;
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = str;
      if (paramString.contains("?"))
      {
        paramString = paramString.substring(paramString.indexOf("?") + 1).split("&");
        k = paramString.length;
      }
    }
    for (int j = 0;; j++)
    {
      localObject = str;
      if (j < k)
      {
        localObject = paramString[j].split("=");
        if (("token".equals(localObject[0])) && (localObject.length == 2)) {
          localObject = localObject[1];
        }
      }
      else
      {
        return (String)localObject;
      }
    }
  }
  
  private void i()
  {
    this.f = UUID.randomUUID().toString().replace("-", "");
    this.g = "";
    this.h.clear();
  }
  
  private static String j()
  {
    String str = f.a(com.lantern.core.c.getAppContext()).a("searchhost");
    if (TextUtils.isEmpty(str)) {}
    for (str = "https://searchcds.51y5.net/get_token.sec";; str = str + "get_token.sec") {
      return str;
    }
  }
  
  private void k()
  {
    h.a("schedulGenerateSearchUrl", new Object[0]);
    if ((e != null) && (!e.isShutdown())) {}
    for (;;)
    {
      return;
      if ((e == null) || (e.isShutdown())) {
        e = new ScheduledThreadPoolExecutor(1);
      }
      e.scheduleWithFixedDelay(new c(this), 0L, 3000L, TimeUnit.MILLISECONDS);
    }
  }
  
  private static void l()
  {
    h.a("stopGenerateSearchUrl", new Object[0]);
    if ((e != null) && (!e.isShutdown())) {
      e.shutdown();
    }
    e = null;
  }
  
  private HashMap<String, String> m()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appInfo", com.lantern.browser.search.c.a.a(com.lantern.core.c.getInstance().getApplicationContext()));
      localJSONObject.put("extInfo", com.lantern.browser.search.c.a.b(com.lantern.core.c.getInstance().getApplicationContext()));
      localJSONObject.put("serialId", this.f);
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis()));
      return com.lantern.core.c.getServer().a("cds011001", localJSONObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  public final com.lantern.browser.search.b.c a(int paramInt)
  {
    if (this.c != null)
    {
      int j = this.c.size();
      if ((paramInt < 0) || (paramInt >= j)) {}
    }
    for (com.lantern.browser.search.b.c localc = (com.lantern.browser.search.b.c)this.c.get(paramInt);; localc = null) {
      return localc;
    }
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    if (TextUtils.isEmpty(this.g)) {
      if (com.bluefay.a.e.c(com.lantern.core.c.getAppContext())) {
        new com.lantern.browser.c.c(j(), m(), new e(this, parama)).execute(new String[] { "" });
      }
    }
    for (;;)
    {
      return;
      parama.a(0, null, null);
      k();
      continue;
      parama.a(1, null, this.g);
    }
  }
  
  public final void a(a parama)
  {
    this.b = parama;
  }
  
  public final void a(com.lantern.browser.search.b.c paramc)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = paramc;
    this.d.sendMessage(localMessage);
  }
  
  public final void a(String paramString)
  {
    if ((this.i > 0L) && (System.currentTimeMillis() - this.i >= 3000000L)) {
      i();
    }
    if (this.b != null) {
      this.b.a(paramString);
    }
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (this.c != null))
    {
      localObject = this.c.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.equals(((com.lantern.browser.search.b.c)((Iterator)localObject).next()).a()));
    }
    for (;;)
    {
      com.lantern.analytics.a.e().onEvent("searun");
      return;
      localObject = new com.lantern.browser.search.b.c();
      ((com.lantern.browser.search.b.c)localObject).a(paramString);
      this.c.add(0, localObject);
      if (this.b != null) {
        this.b.c();
      }
    }
  }
  
  public final int b()
  {
    if (this.c != null) {}
    for (int j = this.c.size();; j = 0) {
      return j;
    }
  }
  
  public final void b(com.lantern.browser.search.b.c paramc)
  {
    if ((this.i > 0L) && (System.currentTimeMillis() - this.i >= 3000000L)) {
      i();
    }
    if (this.b != null)
    {
      String str = paramc.a();
      this.b.a(str);
    }
    if ((paramc != null) && (this.c != null) && (!this.c.contains(paramc)))
    {
      this.c.add(0, paramc);
      if (this.b != null) {
        this.b.c();
      }
    }
    com.lantern.analytics.a.e().onEvent("searun");
  }
  
  public final void c()
  {
    this.d.sendEmptyMessage(2);
  }
  
  public final void d()
  {
    if (this.b != null)
    {
      if ((this.h != null) && (this.h.size() > 0)) {
        this.b.d_();
      }
      if ((this.c != null) && (this.c.size() > 0)) {
        this.b.c_();
      }
    }
  }
  
  public final void e()
  {
    this.c.clear();
    String str = com.lantern.core.c.getInstance().getSharedPreferences("searchHistory", 0).getString("history", "");
    if (!TextUtils.isEmpty(str)) {
      this.c = com.lantern.browser.search.b.b.a(str);
    }
    i();
    k();
  }
  
  public final void f()
  {
    Object localObject2;
    if (this.c != null)
    {
      localObject2 = this.c;
      if (localObject2 != null) {
        break label69;
      }
    }
    for (Object localObject1 = "";; localObject1 = ((JSONArray)localObject1).toString())
    {
      com.lantern.core.c.getInstance().getSharedPreferences("searchHistory", 0).edit().putString("history", (String)localObject1).apply();
      l();
      this.f = "";
      this.g = "";
      this.i = 0L;
      return;
      label69:
      localObject1 = new JSONArray();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((JSONArray)localObject1).put(((com.lantern.browser.search.b.c)((Iterator)localObject2).next()).a());
      }
    }
  }
  
  public final String g()
  {
    String str = f.a().a("search");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return str;
      str = this.g;
    }
  }
  
  public final List<com.lantern.browser.search.b.d> h()
  {
    return this.h;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
    
    public abstract void c();
    
    public abstract void c_();
    
    public abstract void d();
    
    public abstract void d_();
    
    public abstract void e();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */