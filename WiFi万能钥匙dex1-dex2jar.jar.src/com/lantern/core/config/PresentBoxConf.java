package com.lantern.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

public class PresentBoxConf
  extends a
{
  private static String e = "pb_remind_last_show";
  private boolean f;
  private String g;
  private String h;
  private long i;
  private long j;
  private String k;
  private boolean l;
  private long m;
  
  public PresentBoxConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.f = paramJSONObject.optBoolean("switch", false);
      this.g = paramJSONObject.optString("lurl", "");
      this.h = paramJSONObject.optString("turl", "");
      this.i = paramJSONObject.optLong("st", 0L);
      this.j = paramJSONObject.optLong("et", 0L);
      this.k = paramJSONObject.optString("sm", "");
    }
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    paramJSONObject = this.b;
    String str = e;
    this.m = paramJSONObject.getSharedPreferences("config_extra_data", 0).getLong(str, 0L);
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  public final boolean d()
  {
    return this.f;
  }
  
  public final String e()
  {
    return this.h;
  }
  
  public final void f()
  {
    this.m = System.currentTimeMillis();
    Context localContext = this.b;
    String str = e;
    long l1 = this.m;
    localContext.getSharedPreferences("config_extra_data", 0).edit().putLong(str, l1).commit();
    this.l = true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/PresentBoxConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */