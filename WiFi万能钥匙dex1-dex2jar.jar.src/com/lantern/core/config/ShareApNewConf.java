package com.lantern.core.config;

import android.content.Context;
import com.bluefay.b.h;
import org.json.JSONObject;

public class ShareApNewConf
  extends a
{
  private int e = 4;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  private boolean k = false;
  private boolean l = false;
  
  public ShareApNewConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.f = true;
      this.g = true;
      this.h = true;
      this.i = true;
      this.j = true;
      this.k = false;
    }
    for (;;)
    {
      return;
      if (paramInt == 2)
      {
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
      }
      else if (paramInt == 3)
      {
        this.f = true;
        this.g = true;
        this.h = false;
        this.i = false;
        this.j = true;
        this.k = false;
      }
      else if ((paramInt != 4) && (paramInt == 5))
      {
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = true;
      }
      else
      {
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = true;
        this.k = false;
      }
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        this.l = paramJSONObject.optBoolean("ssg", false);
        this.e = paramJSONObject.optInt("ssu", 4);
        a(this.e);
      }
      catch (Exception paramJSONObject)
      {
        h.a(paramJSONObject);
        a(4);
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
  
  public final boolean d()
  {
    return this.l;
  }
  
  public final boolean e()
  {
    return this.f;
  }
  
  public final boolean f()
  {
    return this.g;
  }
  
  public final boolean g()
  {
    return this.h;
  }
  
  public final boolean h()
  {
    return this.i;
  }
  
  public final boolean i()
  {
    return this.j;
  }
  
  public final boolean j()
  {
    return this.k;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/ShareApNewConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */