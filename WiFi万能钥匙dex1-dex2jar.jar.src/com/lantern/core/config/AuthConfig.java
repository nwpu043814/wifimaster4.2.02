package com.lantern.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.o;
import org.json.JSONObject;

public class AuthConfig
  extends a
{
  private int e = 2;
  private int f = 2;
  private int g = 2;
  private int h = 1;
  private int i = 2;
  private long j = 10000L;
  private long k = 10000L;
  private long l = 10000L;
  private double m = 0.0D;
  private double n = 0.0D;
  private double o = 0.0D;
  private double p = 0.0D;
  
  public AuthConfig(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    h.a("AuthConfig confJson " + paramJSONObject, new Object[0]);
    if (paramJSONObject != null)
    {
      this.e = paramJSONObject.optInt("ul_type_oa", 2);
      this.f = paramJSONObject.optInt("ul_type_al", 2);
      this.g = paramJSONObject.optInt("ul_type_sl", 2);
      this.h = paramJSONObject.optInt("dl_type", 1);
      this.m = paramJSONObject.optDouble("min_lat", 0.0D);
      this.n = paramJSONObject.optDouble("max_lat", 0.0D);
      this.o = paramJSONObject.optDouble("min_lon", 0.0D);
      this.p = paramJSONObject.optDouble("max_lon", 0.0D);
      this.i = paramJSONObject.optInt("verify_sim", 2);
      this.j = paramJSONObject.optLong("umc_login_to", 10000L);
      this.k = paramJSONObject.optLong("umc_oauth_to", 10000L);
      this.l = paramJSONObject.optLong("umc_auto_to", 10000L);
    }
  }
  
  private boolean l()
  {
    boolean bool2 = false;
    String str1 = c.getServer().d();
    String str2 = c.getServer().e();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str1)) {
      if (!TextUtils.isEmpty(str2)) {
        break label46;
      }
    }
    for (bool1 = bool2;; bool1 = true) {
      for (;;)
      {
        return bool1;
        try
        {
          label46:
          double d2 = Double.parseDouble(str1);
          double d1 = Double.parseDouble(str2);
          bool1 = bool2;
          if (d2 <= this.n)
          {
            bool1 = bool2;
            if (d2 >= this.m)
            {
              bool1 = bool2;
              if (d1 <= this.p)
              {
                d2 = this.o;
                bool1 = bool2;
                if (d1 < d2) {}
              }
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  public final int d()
  {
    if ((l()) && (this.e != 4)) {}
    for (int i1 = 1;; i1 = this.e) {
      return i1;
    }
  }
  
  public final int e()
  {
    if ((l()) && (this.f != 4)) {}
    for (int i1 = 1;; i1 = this.f) {
      return i1;
    }
  }
  
  public final int f()
  {
    if ((l()) && (this.g != 4)) {}
    for (int i1 = 1;; i1 = this.g) {
      return i1;
    }
  }
  
  public final int g()
  {
    if (l()) {}
    for (int i1 = 1;; i1 = this.h) {
      return i1;
    }
  }
  
  public final boolean h()
  {
    boolean bool = true;
    if (this.i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public final long i()
  {
    return this.j;
  }
  
  public final long j()
  {
    return this.k;
  }
  
  public final long k()
  {
    return this.l;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/AuthConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */