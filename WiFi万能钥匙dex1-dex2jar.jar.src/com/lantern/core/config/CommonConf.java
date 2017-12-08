package com.lantern.core.config;

import android.content.Context;
import org.json.JSONObject;

public class CommonConf
  extends a
{
  private JSONObject e;
  
  public CommonConf(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
  }
  
  public final JSONObject d()
  {
    return this.e;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/CommonConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */