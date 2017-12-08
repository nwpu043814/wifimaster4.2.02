package com.wifi.connect.model;

import android.text.TextUtils;
import com.lantern.core.model.WkAccessPoint;
import java.io.Serializable;

public final class d
  implements Serializable
{
  private String a;
  private String b;
  
  public d(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.a = str;
    this.b = paramString1;
  }
  
  public final boolean a(WkAccessPoint paramWkAccessPoint)
  {
    if ((!TextUtils.isEmpty(this.a)) && (this.a.equals(paramWkAccessPoint.a())) && (this.b.equals(paramWkAccessPoint.b()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof d)) {
      if ((((d)paramObject).a.equals(this.a)) && (((d)paramObject).b.equals(this.b))) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = super.equals(paramObject);
    }
  }
  
  public final int hashCode()
  {
    return this.a.hashCode() + this.b.hashCode();
  }
  
  public final String toString()
  {
    return this.a + " " + this.b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */