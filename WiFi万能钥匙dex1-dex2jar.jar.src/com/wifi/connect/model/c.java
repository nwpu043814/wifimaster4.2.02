package com.wifi.connect.model;

import android.text.TextUtils;
import com.bluefay.b.h;
import com.c.a.a.a.c.a.a.a.b.a;
import com.c.a.a.a.c.a.a.a.b.a.a;
import com.lantern.core.h.a;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.model.e;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  extends e
{
  private ArrayList<AccessPointKey> a = new ArrayList();
  private ArrayList<PluginAp> b = new ArrayList();
  private ArrayList<WebAuthAp> c = new ArrayList();
  private ArrayList<AccessPointAlias> d = new ArrayList();
  private Map<String, AccessPointAlias> e = null;
  private ArrayList<HttpAuthAp> f = new ArrayList();
  private String g;
  private long h;
  
  private static WkAccessPoint a(ArrayList<WkAccessPoint> paramArrayList, String paramString1, String paramString2)
  {
    paramString1 = new WkAccessPoint(paramString1, paramString2);
    int i = paramArrayList.indexOf(paramString1);
    if (i >= 0) {
      paramString1 = (WkAccessPoint)paramArrayList.get(i);
    }
    return paramString1;
  }
  
  public static c a(ArrayList<WkAccessPoint> paramArrayList, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    com.lantern.core.c.getServer();
    paramArrayOfByte = o.b(paramVarArgs[0], paramArrayOfByte);
    if (!paramArrayOfByte.c())
    {
      paramArrayList = new c();
      paramArrayList.a(paramArrayOfByte.a());
      paramArrayList.b(paramArrayOfByte.b());
      h.a("mResponse:" + paramArrayOfByte, new Object[0]);
    }
    for (;;)
    {
      return paramArrayList;
      com.bluefay.b.c.a(paramArrayOfByte.g());
      b.a locala = b.a.a(paramArrayOfByte.g());
      paramArrayOfByte = new c();
      ArrayList localArrayList2 = paramArrayOfByte.d;
      ArrayList localArrayList3 = paramArrayOfByte.b;
      ArrayList localArrayList1 = paramArrayOfByte.a;
      paramVarArgs = paramArrayOfByte.f;
      paramArrayOfByte.g = locala.m();
      paramArrayOfByte.a("0");
      Iterator localIterator = locala.l().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        b.a.a locala1 = (b.a.a)((Map.Entry)localObject).getValue();
        if (locala1.y().equals("3"))
        {
          localObject = new HttpAuthAp(a(paramArrayList, locala1.l(), (String)((Map.Entry)localObject).getKey()), Integer.parseInt(locala1.y()));
          ((HttpAuthAp)localObject).a(locala1.l());
          ((HttpAuthAp)localObject).b(Integer.parseInt(locala1.r()));
          ((HttpAuthAp)localObject).a(Integer.parseInt(locala1.y()));
          paramVarArgs.add(localObject);
        }
        else if (!TextUtils.isEmpty(locala1.p()))
        {
          AccessPointAlias localAccessPointAlias = new AccessPointAlias(a(paramArrayList, locala1.l(), (String)((Map.Entry)localObject).getKey()));
          localAccessPointAlias.g = locala1.q();
          localAccessPointAlias.e = locala1.p();
          localAccessPointAlias.f = locala1.m();
          localAccessPointAlias.h = locala1.o();
          localAccessPointAlias.k = locala1.E();
          localAccessPointAlias.b = ((String)((Map.Entry)localObject).getKey());
          localAccessPointAlias.a = locala1.l();
          localAccessPointAlias.n = locala1.H();
          localAccessPointAlias.l = locala1.F();
          localAccessPointAlias.j = locala1.D();
          localAccessPointAlias.o = locala1.n();
          if (TextUtils.isEmpty(localAccessPointAlias.o)) {
            localAccessPointAlias.o = "0";
          }
          localAccessPointAlias.p = locala1.r();
          localArrayList2.add(localAccessPointAlias);
          if ("0".equals(locala1.r()))
          {
            localObject = new AccessPointKey(a(paramArrayList, locala1.l(), (String)((Map.Entry)localObject).getKey()));
            if (!TextUtils.isEmpty(locala1.m()))
            {
              ((AccessPointKey)localObject).e = locala1.m();
              ((AccessPointKey)localObject).f = 1;
            }
            ((AccessPointKey)localObject).g = locala1.r();
            ((AccessPointKey)localObject).i = locala1.C();
            ((AccessPointKey)localObject).j = locala1.D();
            ((AccessPointKey)localObject).k = locala1.E();
            ((AccessPointKey)localObject).l = locala1.F();
            ((AccessPointKey)localObject).m = locala1.G();
            ((AccessPointKey)localObject).h = locala1.A();
            ((AccessPointKey)localObject).g = locala.m();
            ((AccessPointKey)localObject).n = locala1.n();
            if (TextUtils.isEmpty(((AccessPointKey)localObject).n)) {
              ((AccessPointKey)localObject).n = "0";
            }
            ((AccessPointKey)localObject).o = locala1.H();
            ((AccessPointKey)localObject).p = locala1.B();
            localArrayList1.add(localObject);
          }
        }
        else if (!TextUtils.isEmpty(locala1.x()))
        {
          localObject = new PluginAp(a(paramArrayList, locala1.l(), (String)((Map.Entry)localObject).getKey()), Integer.parseInt(locala1.y()));
          ((PluginAp)localObject).e = Long.parseLong(locala1.t());
          ((PluginAp)localObject).i = locala1.u();
          ((PluginAp)localObject).f = Integer.parseInt(locala1.v());
          ((PluginAp)localObject).l = locala1.w();
          ((PluginAp)localObject).h = Integer.parseInt(locala1.y());
          ((PluginAp)localObject).j = locala1.x();
          ((PluginAp)localObject).g = Integer.parseInt(locala1.s());
          ((PluginAp)localObject).k = locala1.z();
          localArrayList3.add(localObject);
        }
        else
        {
          localObject = new AccessPointKey(a(paramArrayList, locala1.l(), (String)((Map.Entry)localObject).getKey()));
          if (!TextUtils.isEmpty(locala1.m()))
          {
            ((AccessPointKey)localObject).e = locala1.m();
            ((AccessPointKey)localObject).f = 1;
          }
          ((AccessPointKey)localObject).i = locala1.C();
          ((AccessPointKey)localObject).j = locala1.D();
          ((AccessPointKey)localObject).l = locala1.F();
          ((AccessPointKey)localObject).m = locala1.G();
          ((AccessPointKey)localObject).k = locala1.E();
          ((AccessPointKey)localObject).p = locala1.B();
          ((AccessPointKey)localObject).h = locala1.A();
          ((AccessPointKey)localObject).g = locala.m();
          ((AccessPointKey)localObject).n = locala1.n();
          if (TextUtils.isEmpty(((AccessPointKey)localObject).n)) {
            ((AccessPointKey)localObject).n = "0";
          }
          ((AccessPointKey)localObject).o = locala1.H();
          localArrayList1.add(localObject);
        }
      }
      paramArrayList = paramArrayOfByte;
    }
  }
  
  public final long g()
  {
    return this.h;
  }
  
  public final int h()
  {
    return this.a.size();
  }
  
  public final String i()
  {
    return this.g;
  }
  
  public final boolean j()
  {
    if ((this.a.size() > 0) || (this.b.size() > 0) || (this.c.size() > 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final ArrayList<AccessPointKey> k()
  {
    return this.a;
  }
  
  public final ArrayList<PluginAp> l()
  {
    return this.b;
  }
  
  public final ArrayList<WebAuthAp> m()
  {
    return this.c;
  }
  
  public final ArrayList<AccessPointAlias> n()
  {
    return this.d;
  }
  
  public final ArrayList<HttpAuthAp> o()
  {
    return this.f;
  }
  
  public final String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */