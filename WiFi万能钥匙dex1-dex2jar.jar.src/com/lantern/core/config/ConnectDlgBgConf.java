package com.lantern.core.config;

import android.content.Context;
import com.bluefay.b.h;
import org.json.JSONObject;

public class ConnectDlgBgConf
  extends a
{
  private String e;
  private String f;
  
  public ConnectDlgBgConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      h.a("ConnectDlgBg_Conf=" + paramJSONObject, new Object[0]);
      this.e = paramJSONObject.optString("bgurl");
      this.f = paramJSONObject.optString("sign");
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/ConnectDlgBgConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */