package com.lantern.core.config;

import android.content.Context;
import org.json.JSONObject;

public abstract class a
{
  String a;
  protected Context b;
  protected long c = 0L;
  protected long d;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  protected void a() {}
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public final long b()
  {
    return this.c;
  }
  
  protected abstract void b(JSONObject paramJSONObject);
  
  public final long c()
  {
    return this.d;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */