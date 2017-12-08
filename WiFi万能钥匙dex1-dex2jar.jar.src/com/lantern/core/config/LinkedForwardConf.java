package com.lantern.core.config;

import android.content.Context;
import org.json.JSONObject;

public class LinkedForwardConf
  extends a
{
  private int e;
  private String f;
  private int g;
  
  public LinkedForwardConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.e = paramJSONObject.optInt("enabled", 1);
      this.f = paramJSONObject.optString("url", "http://wifi02.51y5.net/wifi/apromote.do");
      this.g = paramJSONObject.optInt("pull", 2);
    }
  }
  
  protected final void a()
  {
    super.a();
    this.e = 1;
    this.f = "http://wifi02.51y5.net/wifi/apromote.do";
    this.g = 2;
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
    return this.f;
  }
  
  public final int e()
  {
    return this.g;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/LinkedForwardConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */