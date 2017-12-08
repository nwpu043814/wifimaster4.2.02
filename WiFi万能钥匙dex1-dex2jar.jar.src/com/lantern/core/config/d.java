package com.lantern.core.config;

import android.content.Context;
import com.bluefay.b.h;
import org.json.JSONObject;

public class d
{
  private static d a;
  private c b;
  private Context c;
  private boolean d = false;
  private com.bluefay.b.a e = new e(this);
  
  private d(Context paramContext)
  {
    h.a("------------------ConfigurationManager init------------------", new Object[0]);
    this.c = paramContext;
    this.b = new c(this.c);
  }
  
  public static d a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        d locald = new com/lantern/core/config/d;
        locald.<init>(paramContext.getApplicationContext());
        a = locald;
      }
      return a;
    }
    finally {}
  }
  
  public final <T extends a> T a(Class<T> paramClass)
  {
    return this.b.a(paramClass);
  }
  
  public final JSONObject a(String paramString)
  {
    return this.b.b(paramString);
  }
  
  public final void a()
  {
    this.b.c();
  }
  
  public final void a(String paramString, Class<? extends a> paramClass)
  {
    this.b.a(paramString, paramClass);
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        boolean bool = this.d;
        if (bool) {
          return;
        }
        if (paramBoolean) {
          break label66;
        }
        if (System.currentTimeMillis() - this.b.a() < 7200000L)
        {
          if (i != 0) {
            break label66;
          }
          h.a("not need update!", new Object[0]);
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label66:
      h.a("do update,force:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      this.d = true;
      JSONObject localJSONObject = this.b.b();
      com.lantern.analytics.a.e().onEvent("cfgreq");
      com.lantern.core.config.a.a locala = new com/lantern/core/config/a/a;
      locala.<init>(this.e, localJSONObject);
      locala.execute(new Void[0]);
    }
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    boolean bool1 = false;
    if (paramJSONObject == null) {}
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = this.b.a(paramJSONObject, true);
        bool1 = bool2;
      }
      catch (Exception paramJSONObject)
      {
        h.a(paramJSONObject);
      }
    }
  }
  
  public final void b(String paramString)
  {
    this.b.a(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */