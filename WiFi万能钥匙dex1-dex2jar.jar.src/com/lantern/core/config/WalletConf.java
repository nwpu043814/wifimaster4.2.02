package com.lantern.core.config;

import android.content.Context;
import org.json.JSONObject;

public class WalletConf
  extends a
{
  private int e = 4;
  private String f = "https://wifi.com";
  private String g = "";
  private String h = "";
  private int i = 2;
  
  public WalletConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.e = paramJSONObject.optInt("show_mode", 4);
      this.f = paramJSONObject.optString("guide_url", "https://wifi.com");
      this.g = paramJSONObject.optString("act_icon", "");
      this.h = paramJSONObject.optString("act_summary", "");
      this.i = paramJSONObject.optInt("act_mode", 2);
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
    if (this.e != 4) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public final String f()
  {
    return this.f;
  }
  
  public final String g()
  {
    return this.g;
  }
  
  public final String h()
  {
    return this.h;
  }
  
  public final boolean i()
  {
    boolean bool = true;
    if (this.i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/WalletConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */