package com.lantern.core.config;

import android.content.Context;
import org.json.JSONObject;

public class Crty5Conf
  extends a
{
  private String e;
  private String f;
  
  public Crty5Conf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.e = paramJSONObject.optString("url");
      this.f = paramJSONObject.optString("md5");
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
  
  public final String d()
  {
    return this.e;
  }
  
  public final String e()
  {
    return this.f;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/Crty5Conf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */