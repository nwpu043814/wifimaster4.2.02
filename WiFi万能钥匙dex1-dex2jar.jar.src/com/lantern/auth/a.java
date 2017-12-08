package com.lantern.auth;

import android.content.Context;
import com.bluefay.b.h;
import com.lantern.core.config.AuthConfig;
import com.lantern.core.k;
import com.lantern.core.o;
import com.lantern.core.p;

public final class a
{
  private static a b;
  AuthConfig a = null;
  private Context c;
  private com.lantern.auth.utils.b d;
  private com.bluefay.b.a e = new b(this);
  private com.bluefay.b.a f = new c(this);
  private com.bluefay.b.a g = new d(this);
  private com.bluefay.b.a h = new e(this);
  private com.bluefay.b.a i = new f(this);
  
  private a(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static a a()
  {
    if (b == null) {
      throw new IllegalArgumentException("Agent need init first");
    }
    return b;
  }
  
  public static a a(Context paramContext)
  {
    if (b == null) {
      b = new a(paramContext.getApplicationContext());
    }
    return b;
  }
  
  private int c()
  {
    int j;
    if (!com.bluefay.a.a.c(this.c))
    {
      h.a("No Network");
      j = 1;
    }
    for (;;)
    {
      return j;
      if (!com.lantern.auth.utils.a.b(this.c))
      {
        h.a("No SIM card");
        j = 2;
      }
      else
      {
        String str1 = k.d(this.c);
        if ((str1 == null) || (str1.length() == 0))
        {
          h.a("No SIM Serial Number");
          j = 3;
        }
        else
        {
          String str2 = p.d(this.c, "");
          if (str2.length() > 0)
          {
            h.a("uhid exsit:" + str2);
            str2 = com.bluefay.a.d.c(com.bluefay.d.a.getAppContext(), "sdk_device", "simserialnumber", "");
            if ((str2.length() > 0) && (str1.equals(str2)))
            {
              j = 6;
            }
            else
            {
              h.a("SIM not same, register again");
              j = 5;
            }
          }
          else if (!"86".equals(com.lantern.auth.utils.a.a(this.c)))
          {
            h.a("Not china SIM, can't register");
            j = 4;
          }
          else
          {
            j = 7;
          }
        }
      }
    }
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    if (parama != null) {
      this.e = parama;
    }
    this.a = ((AuthConfig)com.lantern.core.config.d.a(this.c).a(AuthConfig.class));
    if (this.a == null) {
      this.a = new AuthConfig(this.c);
    }
    int j = c();
    if (j != 7)
    {
      if (j == 5) {
        com.lantern.core.c.getServer().p();
      }
    }
    else
    {
      if (this.a.e() != 4) {
        break label132;
      }
      this.e.a(0, null, null);
    }
    for (;;)
    {
      return;
      if (j == 6)
      {
        this.e.a(0, null, null);
      }
      else
      {
        this.e.a(0, null, null);
        continue;
        label132:
        com.lantern.analytics.a.e().onEvent("LoginStart", g.a("app_auto", null, null, com.lantern.core.c.getServer().k()));
        if ((this.a.e() == 2) && (com.lantern.auth.utils.a.c(this.c)))
        {
          com.lantern.auth.a.a.a(this.c, this.h, false, 4, "app_auto", com.lantern.core.c.getServer().k());
        }
        else
        {
          if (this.d == null) {
            this.d = new com.lantern.auth.utils.b(this.c, this.g);
          }
          new com.lantern.auth.c.b(this.f, "app_auto", com.lantern.core.c.getServer().k()).execute(new String[0]);
        }
      }
    }
  }
  
  public final void b()
  {
    if (c() == 5) {
      com.lantern.core.c.getServer().p();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */