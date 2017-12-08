package com.linksure.apservice.a.c;

import android.os.Message;
import android.util.Log;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

public final class a
  extends com.linksure.apservice.a.e.c
  implements com.linksure.apservice.a.a
{
  private static Comparator<com.linksure.apservice.a.d.a> e = new j();
  private com.linksure.apservice.a.a.a a;
  private com.linksure.apservice.a.b.a b;
  private com.linksure.apservice.a.b.d c;
  private a d = new a();
  
  public a(com.linksure.apservice.a.a.a parama, com.linksure.apservice.a.b.a parama1, com.linksure.apservice.a.b.d paramd)
  {
    this.a = parama;
    this.b = parama1;
    this.c = paramd;
  }
  
  static void a(String paramString, boolean paramBoolean)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 128500;
    localMessage.obj = b(paramString, paramBoolean);
    com.lantern.core.c.dispatch(localMessage);
    Log.e("--->", "send message:" + localMessage.what + " content:" + localMessage.obj);
  }
  
  private com.linksure.apservice.a.d.a b(String paramString)
  {
    com.linksure.apservice.a.d.a locala = this.a.c(paramString);
    if (locala.g) {}
    try
    {
      this.b.a(locala);
      return locala;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        this.b.a(locala.a, locala);
      }
    }
  }
  
  private static String b(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    int i;
    if (paramBoolean) {
      i = 1;
    }
    try
    {
      for (;;)
      {
        localJSONObject.put("stat", i);
        localJSONObject.put("apsId", paramString);
        return localJSONObject.toString();
        i = 0;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public final com.linksure.apservice.b.a a()
  {
    return this.d.a;
  }
  
  public final void a(com.linksure.apservice.a.d.f paramf, int paramInt)
  {
    Log.e("--->", "update latest message:" + paramf + " unread:" + paramInt);
    com.linksure.apservice.a.f.b.a(new o(this, paramf, paramInt));
  }
  
  public final void a(com.linksure.apservice.a.h<List<com.linksure.apservice.b.a>> paramh)
  {
    com.linksure.apservice.a.f.b.b(new m(this, new com.linksure.apservice.a.j(paramh)));
  }
  
  public final void a(String paramString)
  {
    com.linksure.apservice.a.f.b.a(new c(this, paramString));
  }
  
  public final void a(String paramString, int paramInt, com.linksure.apservice.a.h<List<com.linksure.apservice.b.a>> paramh)
  {
    com.linksure.apservice.a.f.b.b(new f(this, paramString, paramInt, new com.linksure.apservice.a.j(paramh)));
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, com.linksure.apservice.a.h<Boolean> paramh)
  {
    com.linksure.apservice.a.f.b.b(new d(this, paramString1, paramInt, paramString2, new com.linksure.apservice.a.j(paramh)));
  }
  
  public final void a(String paramString, com.linksure.apservice.a.h<String> paramh)
  {
    com.linksure.apservice.a.f.b.b(new k(this, paramString, new com.linksure.apservice.a.j(paramh)));
  }
  
  public final void a(boolean paramBoolean, com.linksure.apservice.a.h<List<com.linksure.apservice.b.a>> paramh)
  {
    paramh = new com.linksure.apservice.a.j(paramh);
    if (!paramBoolean) {
      com.linksure.apservice.a.f.b.a(new b(this, paramh));
    }
    for (;;)
    {
      return;
      com.linksure.apservice.a.f.b.b(new i(this, paramh));
    }
  }
  
  public final void a(boolean paramBoolean, String paramString, com.linksure.apservice.a.h<com.linksure.apservice.b.a> paramh)
  {
    paramh = new com.linksure.apservice.a.j(paramh);
    if (!paramBoolean)
    {
      com.linksure.apservice.a.d.a locala = this.b.a(paramString);
      if (locala != null)
      {
        paramString = com.linksure.apservice.a.f.d.a(locala);
        paramh.a(paramString);
        this.d.a(paramString);
      }
    }
    for (;;)
    {
      return;
      paramh.a(new com.linksure.apservice.a.d.a.b("not found:" + paramString));
      continue;
      com.linksure.apservice.a.f.b.b(new n(this, paramString, paramh));
    }
  }
  
  public final long b()
  {
    return this.b.b();
  }
  
  public final void b(com.linksure.apservice.a.h<List<com.linksure.apservice.b.b>> paramh)
  {
    com.linksure.apservice.a.f.b.b(new g(this, new com.linksure.apservice.a.j(paramh)));
  }
  
  public final void b(String paramString, int paramInt, com.linksure.apservice.a.h<List<com.linksure.apservice.b.c>> paramh)
  {
    com.linksure.apservice.a.f.b.b(new h(this, paramString, paramInt, new com.linksure.apservice.a.j(paramh)));
  }
  
  public final void b(String paramString, com.linksure.apservice.a.h<Boolean> paramh)
  {
    com.linksure.apservice.a.f.b.b(new l(this, paramString, new com.linksure.apservice.a.j(paramh)));
  }
  
  public final void c(String paramString, com.linksure.apservice.a.h<Double> paramh)
  {
    com.linksure.apservice.a.f.b.b(new e(this, paramString, new com.linksure.apservice.a.j(paramh)));
  }
  
  public final class a
  {
    com.linksure.apservice.b.a a;
    
    public a() {}
    
    private void a()
    {
      com.linksure.apservice.a.f.b.c(new p(this));
    }
    
    public final void a(com.linksure.apservice.b.a parama)
    {
      this.a = parama;
      if (parama != null) {
        a();
      }
    }
    
    public final void a(String paramString, boolean paramBoolean)
    {
      if ((this.a != null) && (this.a.k.equals(paramString)))
      {
        this.a.e = paramBoolean;
        a();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */