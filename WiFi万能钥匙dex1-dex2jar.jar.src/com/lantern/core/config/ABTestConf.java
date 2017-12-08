package com.lantern.core.config;

import android.content.Context;
import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public class ABTestConf
  extends a
{
  private JSONObject e;
  
  public ABTestConf(Context paramContext)
  {
    super(paramContext);
  }
  
  public final String a(String paramString)
  {
    if ((this.e != null) && (this.e.has(paramString))) {}
    for (;;)
    {
      try
      {
        paramString = this.e.getString(paramString);
        return paramString;
      }
      catch (JSONException paramString)
      {
        h.a(paramString);
      }
      paramString = null;
    }
  }
  
  protected final void a()
  {
    super.a();
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    this.e = paramJSONObject;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/ABTestConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */