package com.analysis.common.upload;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  long a;
  int b;
  int c;
  int d;
  String e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  String l;
  Context m;
  i n;
  
  public a(Context paramContext)
  {
    this.m = paramContext.getApplicationContext();
    this.n = i.a(this.m);
    this.a = System.currentTimeMillis();
    if ("Wi-Fi".equals(com.analysis.common.c.h(this.m)[0])) {}
    for (int i1 = 1;; i1 = 3)
    {
      this.b = i1;
      this.c = Integer.valueOf(com.analysis.common.c.c(this.m).replaceAll("\\.", "")).intValue();
      this.d = 0;
      this.f = 64535;
      this.g = 1;
      this.h = com.analysis.common.c.i(this.m);
      this.j = 0;
      this.k = 0;
      return;
    }
  }
  
  private static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("v=2&c", paramString);
    return localHashMap;
  }
  
  private void a()
  {
    if (com.analysis.common.tools.c.a(this.n)) {
      this.n = i.a(this.m);
    }
    this.n.a(new b(this), new c(this));
  }
  
  private void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  private void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  private String b()
  {
    return this.a + "\t" + this.b + "\t" + this.c + "\t" + this.d + "\t" + this.e + "\t" + this.f + "\t" + this.g + "\t" + this.m.getSharedPreferences("sp_general_config", 0).getInt("app_city", 33) + "\t" + this.h + "\t" + this.i + "\t" + this.j + "\t" + this.k + "\t" + this.l + "\n";
  }
  
  private void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  private void b(String paramString)
  {
    this.l = paramString;
  }
  
  private int c()
  {
    return this.m.getSharedPreferences("sp_general_config", 0).getInt("app_city", 33);
  }
  
  private void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  private void c(String paramString)
  {
    this.e = paramString;
  }
  
  private int d()
  {
    return this.h;
  }
  
  private void d(int paramInt)
  {
    this.i = paramInt;
  }
  
  private String e()
  {
    return this.l;
  }
  
  private long f()
  {
    return this.a;
  }
  
  private int g()
  {
    return this.b;
  }
  
  private int h()
  {
    return this.c;
  }
  
  private int i()
  {
    return this.d;
  }
  
  private void j()
  {
    this.d = 0;
  }
  
  private String k()
  {
    return this.e;
  }
  
  private int l()
  {
    return this.f;
  }
  
  private void m()
  {
    this.f = 64535;
  }
  
  private int n()
  {
    return this.g;
  }
  
  private void o()
  {
    this.g = 1;
  }
  
  private int p()
  {
    return this.i;
  }
  
  private int q()
  {
    return this.j;
  }
  
  private void r()
  {
    this.j = 0;
  }
  
  private int s()
  {
    return this.k;
  }
  
  private void t()
  {
    this.k = 0;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */