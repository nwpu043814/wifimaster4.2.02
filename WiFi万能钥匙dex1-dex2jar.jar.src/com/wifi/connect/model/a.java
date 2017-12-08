package com.wifi.connect.model;

import android.text.TextUtils;
import com.lantern.core.model.WkAccessPoint;
import java.io.Serializable;

public final class a
  implements Serializable
{
  private String a;
  private String b;
  private int c;
  private String d;
  private long e;
  private boolean f = false;
  
  public a(AccessPointKey paramAccessPointKey)
  {
    this.a = paramAccessPointKey.a();
    this.b = paramAccessPointKey.b();
    this.c = paramAccessPointKey.c;
    this.e = System.currentTimeMillis();
    this.d = paramAccessPointKey.n;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final Integer b()
  {
    int j = 0;
    int i = j;
    if (this.d != null)
    {
      i = j;
      if (TextUtils.isEmpty(this.d.trim())) {}
    }
    try
    {
      i = Integer.parseInt(this.d.trim());
      return Integer.valueOf(i);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i = j;
      }
    }
  }
  
  public final boolean c()
  {
    if (System.currentTimeMillis() > this.e + 1296000000L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */