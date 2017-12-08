package com.lantern.core.config;

import android.content.Context;
import org.json.JSONObject;

public class FeedNativeConf
  extends a
{
  private boolean e = true;
  private long f = 300000L;
  private long g = 3600000L;
  private long h = 3600000L;
  
  public FeedNativeConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.e = paramJSONObject.optBoolean("switch", true);
      this.f = paramJSONObject.optLong("refresh_time", 300000L);
      this.g = paramJSONObject.optLong("content_time", 3600000L);
      this.h = paramJSONObject.optLong("session_time", 3600000L);
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
  
  public final long e()
  {
    return this.f;
  }
  
  public final long f()
  {
    return this.g;
  }
  
  public final long g()
  {
    return this.h;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/FeedNativeConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */