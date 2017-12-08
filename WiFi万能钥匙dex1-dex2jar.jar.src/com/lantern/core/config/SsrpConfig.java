package com.lantern.core.config;

import android.content.Context;
import com.bluefay.b.h;
import org.json.JSONObject;

public class SsrpConfig
  extends a
{
  private boolean e = false;
  
  public SsrpConfig(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      h.a("SsrpConfig=" + paramJSONObject, new Object[0]);
      this.e = paramJSONObject.optBoolean("isshow");
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
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/SsrpConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */