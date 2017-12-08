package com.lantern.browser;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.config.d;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
{
  private String a;
  private boolean b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private int h;
  private long i;
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.i = paramLong;
  }
  
  public final void a(String paramString)
  {
    String str1 = paramString;
    if (!"INSTALLED".equals(paramString))
    {
      str1 = paramString;
      if (TextUtils.isEmpty(this.c)) {}
    }
    try
    {
      c.getAppContext().getPackageManager().getPackageInfo(this.c, 0);
      str1 = "INSTALLED";
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        String str2 = paramString;
      }
    }
    this.g = str1;
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    this.a = paramJSONObject.optString("url").trim();
    if (paramJSONObject.optInt("quiet") == 1) {}
    for (;;)
    {
      this.b = bool;
      this.c = paramJSONObject.optString("pkg");
      this.e = paramJSONObject.optString("md5");
      this.f = paramJSONObject.optString("appHid");
      this.i = Long.valueOf(paramJSONObject.optString("id", "0")).longValue();
      return;
      bool = false;
    }
  }
  
  public final long b()
  {
    return this.i;
  }
  
  public final boolean b(JSONObject paramJSONObject)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    String str = paramJSONObject.optString("appHid");
    h.a("parseJsapiJsonToData appHid:" + str, new Object[0]);
    boolean bool1;
    if (TextUtils.isEmpty(str)) {
      bool1 = bool2;
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return bool1;
          localObject = d.a(c.getAppContext()).a("download_js");
          bool1 = bool2;
        } while (localObject == null);
        localObject = ((JSONObject)localObject).optJSONArray("list");
        bool1 = bool2;
      } while (localObject == null);
      bool1 = bool2;
    } while (((JSONArray)localObject).length() <= 0);
    for (int j = 0;; j++)
    {
      bool1 = bool2;
      if (j >= ((JSONArray)localObject).length()) {
        break;
      }
      JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(j);
      if (str.equals(localJSONObject.optString("appHid")))
      {
        this.f = str;
        this.a = localJSONObject.optString("url");
        this.c = localJSONObject.optString("pkg");
        this.e = localJSONObject.optString("md5");
        bool1 = bool3;
        if (paramJSONObject.optInt("quiet") == 1) {
          bool1 = true;
        }
        this.b = bool1;
        bool1 = true;
        break;
      }
    }
  }
  
  public final String c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return this.b;
  }
  
  public final String e()
  {
    if (TextUtils.isEmpty(this.d)) {
      this.d = bp.f(this.a);
    }
    return this.d;
  }
  
  public final String f()
  {
    return this.e;
  }
  
  public final String g()
  {
    return this.f;
  }
  
  public final String h()
  {
    return this.g;
  }
  
  public final int i()
  {
    return this.h;
  }
  
  public final JSONObject j()
  {
    for (;;)
    {
      try
      {
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>();
        localJSONObject.put("url", this.a);
        if (!this.b) {
          continue;
        }
        j = 1;
        localJSONObject.put("quiet", j);
        localJSONObject.put("pkg", this.c);
        localJSONObject.put("md5", this.e);
        localJSONObject.put("appHid", this.f);
        localJSONObject.put("id", String.valueOf(this.i));
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject;
        int j;
        h.a(localException);
        Object localObject = null;
        continue;
      }
      return localJSONObject;
      j = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */