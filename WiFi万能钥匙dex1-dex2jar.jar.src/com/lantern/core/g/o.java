package com.lantern.core.g;

import android.text.TextUtils;
import com.bluefay.b.h;
import com.bluefay.d.a;
import com.lantern.core.c;
import com.lantern.core.config.ShopEntranceConf;
import com.lantern.core.config.d;
import com.lantern.core.p;
import org.json.JSONObject;

public final class o
{
  private static o a;
  private b b = null;
  private a c;
  
  public static o a()
  {
    if (a == null) {
      a = new o();
    }
    return a;
  }
  
  public final void a(a parama)
  {
    this.c = parama;
    if ((this.b != null) && (!TextUtils.isEmpty(this.b.a))) {
      this.c.a(this.b);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new com/lantern/core/g/o$b;
        ((b)localObject).<init>(this);
        this.b = ((b)localObject);
        p.o(a.getAppContext(), paramString);
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        this.b.a = ((JSONObject)localObject).optString("logo");
        this.b.b = ((JSONObject)localObject).optString("logoMD5");
        this.b.c = ((JSONObject)localObject).optString("pushTime");
        paramString = (ShopEntranceConf)d.a(c.getInstance()).a(ShopEntranceConf.class);
        if ((paramString != null) && (paramString.d())) {
          k.a().a(k.b.x);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
    if ((this.c != null) && (this.b != null)) {
      this.c.a(this.b);
    }
  }
  
  public final void b()
  {
    Object localObject2 = p.c(a.getAppContext(), "shopmsg", "msg", "");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      Object localObject1 = new org/json/JSONObject;
      ((JSONObject)localObject1).<init>((String)localObject2);
      localObject2 = new com/lantern/core/g/o$b;
      ((b)localObject2).<init>(this);
      this.b = ((b)localObject2);
      this.b.a = ((JSONObject)localObject1).optString("logo");
      this.b.b = ((JSONObject)localObject1).optString("logoMD5");
      this.b.c = ((JSONObject)localObject1).optString("pushTime");
      localObject1 = (ShopEntranceConf)d.a(c.getInstance()).a(ShopEntranceConf.class);
      if ((localObject1 != null) && (((ShopEntranceConf)localObject1).d())) {
        k.a().a(k.b.x);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
    if ((this.c != null) && (this.b != null)) {
      this.c.a(this.b);
    }
  }
  
  public final void c()
  {
    p.o(a.getAppContext(), "");
    k.a().b(k.b.x);
    this.b = null;
  }
  
  public static abstract interface a
  {
    public abstract void a(o.b paramb);
  }
  
  public final class b
  {
    public String a = "";
    public String b = "";
    public String c = "";
    
    public b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */