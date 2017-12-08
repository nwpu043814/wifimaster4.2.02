package com.alipay.c.a.a.c;

import android.content.Context;
import com.alipay.android.a.a.a.ag;
import com.alipay.android.a.a.a.f;
import com.alipay.android.a.a.a.p;
import org.json.JSONObject;

public final class b
  implements a
{
  private static b d = null;
  private static com.alipay.f.a.a.b.a.a.b e;
  private ag a = null;
  private com.alipay.f.a.a.a.a b = null;
  private com.alipay.f.a.a.b.a.a c = null;
  
  private b(Context paramContext, String paramString)
  {
    f localf = new f();
    localf.a(paramString);
    this.a = new p(paramContext);
    this.b = ((com.alipay.f.a.a.a.a)this.a.a(com.alipay.f.a.a.a.a.class, localf));
    this.c = ((com.alipay.f.a.a.b.a.a)this.a.a(com.alipay.f.a.a.b.a.a.class, localf));
  }
  
  public static b a(Context paramContext, String paramString)
  {
    try
    {
      if (d == null)
      {
        b localb = new com/alipay/c/a/a/c/b;
        localb.<init>(paramContext, paramString);
        d = localb;
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  public final com.alipay.f.a.a.b.a.a.b a(com.alipay.f.a.a.b.a.a.a parama)
  {
    if (this.c != null)
    {
      e = null;
      new Thread(new c(this, parama)).start();
      for (int i = 300000; (e == null) && (i >= 0); i -= 50) {
        Thread.sleep(50L);
      }
    }
    return e;
  }
  
  public final boolean a(String paramString)
  {
    boolean bool = false;
    if (com.alipay.c.a.a.a.a.a(paramString)) {
      return bool;
    }
    Object localObject;
    if (this.b != null) {
      localObject = null;
    }
    for (;;)
    {
      try
      {
        com.alipay.f.a.a.a.a locala = this.b;
        com.alipay.c.a.a.a.a.e(paramString);
        paramString = locala.a();
        if (!com.alipay.c.a.a.a.a.a(paramString)) {
          bool = ((Boolean)new JSONObject(paramString).get("success")).booleanValue();
        }
      }
      catch (Throwable paramString)
      {
        paramString = (String)localObject;
        continue;
      }
      bool = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */