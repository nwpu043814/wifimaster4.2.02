package com.lantern.wifilocating.push.a.b;

import android.text.TextUtils;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.util.j;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  private String a = "2.0";
  private String b = "1.0";
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  
  private JSONObject c()
  {
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("sv", this.a);
        localJSONObject.put("iv", this.b);
        if (!TextUtils.isEmpty(this.c)) {
          localJSONObject.put("st", this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
          localJSONObject.put("seq", this.d);
        }
        if (!TextUtils.isEmpty(this.e)) {
          localJSONObject.put("rid", this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
          localJSONObject.put("stat", this.f);
        }
        if (TextUtils.isEmpty(this.j)) {
          continue;
        }
        localJSONObject.put("fg", this.j);
      }
      catch (Exception localException)
      {
        continue;
        localJSONObject.put("fg", 0);
        continue;
      }
      localJSONObject.put("dot", this.g);
      localJSONObject.put("pr", this.h);
      localJSONObject.put("syt", this.i);
      localJSONObject.put("cts", String.valueOf(System.currentTimeMillis()));
      return localJSONObject;
      if (!j.m(c.a())) {
        continue;
      }
      localJSONObject.put("fg", 1);
    }
  }
  
  public final JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(c());
    return localJSONArray;
  }
  
  public final void a(int paramInt)
  {
    this.c = String.valueOf(paramInt);
  }
  
  public final void a(String paramString)
  {
    this.c = paramString;
  }
  
  public final String b()
  {
    return c().toString();
  }
  
  public final void b(int paramInt)
  {
    this.d = String.valueOf(paramInt);
  }
  
  public final void b(String paramString)
  {
    this.d = paramString;
  }
  
  public final void c(int paramInt)
  {
    this.f = String.valueOf(paramInt);
  }
  
  public final void c(String paramString)
  {
    this.e = paramString;
  }
  
  public final void d(int paramInt)
  {
    this.g = String.valueOf(paramInt);
  }
  
  public final void d(String paramString)
  {
    this.f = paramString;
  }
  
  public final void e(int paramInt)
  {
    this.h = String.valueOf(paramInt);
  }
  
  public final void f(int paramInt)
  {
    this.i = String.valueOf(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */