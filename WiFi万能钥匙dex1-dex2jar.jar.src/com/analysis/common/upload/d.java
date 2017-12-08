package com.analysis.common.upload;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  int a;
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  Context i;
  i j;
  
  public d(Context paramContext)
  {
    this.i = paramContext.getApplicationContext();
    this.j = i.a(this.i);
    this.a = 1;
    this.b = com.analysis.common.c.c(this.i);
    this.c = com.analysis.common.c.d();
    this.d = "wallet";
    this.f = "error";
  }
  
  private void a(String paramString)
  {
    this.g = paramString;
  }
  
  private Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mt", this.a);
    localHashMap.put("av", this.b);
    localHashMap.put("pv", this.c);
    localHashMap.put("m", this.d);
    localHashMap.put("msg", this.e);
    localHashMap.put("l", this.f);
    localHashMap.put("d", this.g);
    localHashMap.put("memo", this.h);
    return localHashMap;
  }
  
  private void b(String paramString)
  {
    this.f = paramString;
  }
  
  private int c()
  {
    return this.a;
  }
  
  private void c(String paramString)
  {
    this.e = paramString;
  }
  
  private void d()
  {
    this.a = 1;
  }
  
  private void d(String paramString)
  {
    this.d = paramString;
  }
  
  private String e()
  {
    return this.g;
  }
  
  private void e(String paramString)
  {
    this.b = paramString;
  }
  
  private String f()
  {
    return this.f;
  }
  
  private void f(String paramString)
  {
    this.c = paramString;
  }
  
  private String g()
  {
    return this.e;
  }
  
  private void g(String paramString)
  {
    this.h = paramString;
  }
  
  private String h()
  {
    return this.d;
  }
  
  private String i()
  {
    return this.b;
  }
  
  private String j()
  {
    return this.c;
  }
  
  private String k()
  {
    return this.h;
  }
  
  public final void a()
  {
    if (com.analysis.common.tools.c.a(this.j)) {
      this.j = i.a(this.i);
    }
    this.j.a(new e(this), new f(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */