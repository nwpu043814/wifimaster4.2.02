package com.lantern.core.config;

import android.content.Context;
import com.lantern.core.k;
import org.json.JSONObject;

public class SplashConf
  extends a
{
  private int e;
  private String f;
  private long g;
  private long h;
  private String i;
  private long j;
  private String k;
  private boolean l;
  private String m;
  private boolean n = false;
  private String o;
  
  public SplashConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.e = paramJSONObject.optInt("id", 0);
      this.f = paramJSONObject.optString("url", "");
      this.g = paramJSONObject.optLong("st", 0L);
      this.h = paramJSONObject.optLong("et", 0L);
      this.i = paramJSONObject.optString("sm", "");
      this.j = paramJSONObject.optLong("d", 0L);
      this.k = paramJSONObject.optString("m", "");
      this.l = paramJSONObject.optBoolean("canSkip", false);
    }
  }
  
  protected final void a()
  {
    super.a();
    this.l = true;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    this.m = b.a(this.b, "ss_img", null);
    this.o = b.a(this.b, "ss_chanel", "");
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    this.o = k.l(this.b);
    if (this.o == null) {
      this.o = "";
    }
    b.b(this.b, "ss_chanel", this.o);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/SplashConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */