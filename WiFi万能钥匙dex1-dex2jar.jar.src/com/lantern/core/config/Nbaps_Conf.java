package com.lantern.core.config;

import android.content.Context;
import com.bluefay.b.h;
import org.json.JSONObject;

public class Nbaps_Conf
  extends a
{
  private int e = 5;
  
  public Nbaps_Conf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      h.a("Nbaps_Conf=" + paramJSONObject, new Object[0]);
      this.e = paramJSONObject.optInt("apnum", 5);
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
  
  public final int d()
  {
    return this.e;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/Nbaps_Conf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */