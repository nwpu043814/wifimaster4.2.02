package com.wifi.connect.a;

import android.text.TextUtils;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.model.AccessPoint;
import com.wifi.connect.model.AccessPointAlias;
import com.wifi.connect.model.e;
import java.util.HashMap;

public final class a
{
  private static a a;
  private HashMap<e, AccessPointAlias> b = new HashMap();
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public final AccessPointAlias a(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramWkAccessPoint.a, paramWkAccessPoint.c);
      paramWkAccessPoint = (AccessPointAlias)localHashMap.get(locale);
      return paramWkAccessPoint;
    }
    finally {}
  }
  
  public final AccessPointAlias a(String paramString, int paramInt)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramString, paramInt);
      paramString = (AccessPointAlias)localHashMap.get(locale);
      return paramString;
    }
    finally {}
  }
  
  public final String a(AccessPoint paramAccessPoint)
  {
    paramAccessPoint = (AccessPointAlias)this.b.get(new e(paramAccessPoint.a(), paramAccessPoint.c));
    if ((paramAccessPoint != null) && (!TextUtils.isEmpty(paramAccessPoint.l))) {}
    for (paramAccessPoint = paramAccessPoint.l;; paramAccessPoint = "") {
      return paramAccessPoint;
    }
  }
  
  public final void a(String paramString, AccessPointAlias paramAccessPointAlias)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramString, paramAccessPointAlias.c);
      localHashMap.put(locale, paramAccessPointAlias);
      return;
    }
    finally {}
  }
  
  public final String b(AccessPoint paramAccessPoint)
  {
    paramAccessPoint = (AccessPointAlias)this.b.get(new e(paramAccessPoint.a(), paramAccessPoint.c));
    if ((paramAccessPoint != null) && (!TextUtils.isEmpty(paramAccessPoint.n))) {}
    for (paramAccessPoint = paramAccessPoint.n;; paramAccessPoint = "") {
      return paramAccessPoint;
    }
  }
  
  public final void b()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally {}
  }
  
  public final boolean b(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      HashMap localHashMap = this.b;
      e locale = new com/wifi/connect/model/e;
      locale.<init>(paramWkAccessPoint.a, paramWkAccessPoint.c);
      boolean bool = localHashMap.containsKey(locale);
      return bool;
    }
    finally {}
  }
  
  public final boolean b(String paramString, int paramInt)
  {
    if (paramInt > 0) {}
    for (;;)
    {
      try
      {
        HashMap localHashMap = this.b;
        e locale = new com/wifi/connect/model/e;
        locale.<init>(paramString, paramInt);
        paramString = (AccessPointAlias)localHashMap.get(locale);
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.n)))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public final String c(AccessPoint paramAccessPoint)
  {
    paramAccessPoint = (AccessPointAlias)this.b.get(new e(paramAccessPoint.a(), paramAccessPoint.c));
    if ((paramAccessPoint != null) && (!TextUtils.isEmpty(paramAccessPoint.o))) {}
    for (paramAccessPoint = paramAccessPoint.o;; paramAccessPoint = "") {
      return paramAccessPoint;
    }
  }
  
  public final boolean c(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = this.b;
        e locale = new com/wifi/connect/model/e;
        locale.<init>(paramString, paramInt);
        paramString = (AccessPointAlias)localHashMap.get(locale);
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.n)))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */