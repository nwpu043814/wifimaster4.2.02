package com.lantern.core.config;

import android.content.Context;
import org.json.JSONObject;

public class RedDotConf
  extends a
{
  private boolean e;
  private boolean f;
  
  public RedDotConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.e = paramJSONObject.optBoolean("appbox", false);
      this.f = paramJSONObject.optBoolean("feed", false);
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
    return this.e;
  }
  
  public final boolean e()
  {
    return this.f;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/RedDotConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */