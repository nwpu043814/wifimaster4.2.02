package com.linksure.apservice.a;

import android.content.Context;
import com.linksure.apservice.a.a.e;
import com.linksure.apservice.a.c.ac;
import com.linksure.apservice.a.c.ao;
import com.linksure.apservice.a.c.q;
import com.linksure.apservice.a.c.t;
import com.linksure.apservice.a.c.v;

public final class i
{
  private static a a;
  private static f b;
  private static b c;
  private static g d;
  private static d e;
  private static c f;
  
  public static a a(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getApplicationContext();
      if (a == null)
      {
        paramContext = com.linksure.apservice.a.a.b.a((Context)localObject);
        com.linksure.apservice.a.b.a locala = com.linksure.apservice.a.b.b.a((Context)localObject);
        localObject = com.linksure.apservice.a.b.b.b((Context)localObject);
        com.linksure.apservice.a.c.a locala1 = new com/linksure/apservice/a/c/a;
        locala1.<init>(paramContext, locala, (com.linksure.apservice.a.b.d)localObject);
        a = locala1;
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static f b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationContext();
      if (b == null)
      {
        a locala = a(paramContext);
        e locale = com.linksure.apservice.a.a.b.b(paramContext);
        com.linksure.apservice.a.b.d locald = com.linksure.apservice.a.b.b.b(paramContext);
        com.linksure.apservice.a.a.f localf = com.linksure.apservice.a.a.b.e(paramContext);
        com.linksure.apservice.a.b.c localc = com.linksure.apservice.a.b.b.d(paramContext);
        com.linksure.apservice.a.a.g localg = com.linksure.apservice.a.a.b.a();
        ac localac = new com/linksure/apservice/a/c/ac;
        localac.<init>(paramContext, locala, locale, locald, localc, localf, localg);
        b = localac;
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static b c(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getApplicationContext();
      if (c == null)
      {
        paramContext = com.linksure.apservice.a.a.b.c((Context)localObject);
        localObject = com.linksure.apservice.a.b.b.a((Context)localObject);
        q localq = new com/linksure/apservice/a/c/q;
        localq.<init>(paramContext, (com.linksure.apservice.a.b.a)localObject);
        c = localq;
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static g d(Context paramContext)
  {
    try
    {
      Context localContext = paramContext.getApplicationContext();
      if (d == null)
      {
        paramContext = new com/linksure/apservice/a/c/ao;
        paramContext.<init>(localContext, com.lantern.core.c.getServer());
        d = paramContext;
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  public static d e(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationContext();
      if (e == null)
      {
        com.linksure.apservice.a.a.f localf = com.linksure.apservice.a.a.b.e(paramContext);
        com.linksure.apservice.a.b.c localc = com.linksure.apservice.a.b.b.d(paramContext);
        v localv = new com/linksure/apservice/a/c/v;
        localv.<init>(paramContext, localf, localc);
        e = localv;
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  public static c f(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationContext();
      if (f == null)
      {
        paramContext = com.linksure.apservice.a.a.b.d(paramContext);
        t localt = new com/linksure/apservice/a/c/t;
        localt.<init>(paramContext);
        f = localt;
      }
      paramContext = f;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */