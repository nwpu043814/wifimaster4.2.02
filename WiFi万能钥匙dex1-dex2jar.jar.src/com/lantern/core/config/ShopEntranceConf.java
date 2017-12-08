package com.lantern.core.config;

import android.content.Context;
import org.json.JSONObject;

public class ShopEntranceConf
  extends a
{
  private boolean e = false;
  
  public ShopEntranceConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.e = paramJSONObject.optBoolean("show", false);
    }
  }
  
  protected final void a()
  {
    this.e = false;
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
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/ShopEntranceConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */