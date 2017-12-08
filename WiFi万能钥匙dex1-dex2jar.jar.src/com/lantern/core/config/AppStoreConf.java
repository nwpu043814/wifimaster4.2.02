package com.lantern.core.config;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.R.string;
import com.lantern.core.c;
import com.lantern.core.o;
import org.json.JSONObject;

public class AppStoreConf
  extends a
{
  private boolean e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private int k;
  private String l;
  private String m;
  
  public AppStoreConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.e = paramJSONObject.optBoolean("appbox", false);
      this.f = paramJSONObject.optString("appboxurl", "");
      this.g = paramJSONObject.optString("appdetailurl", "");
      this.h = paramJSONObject.optString("title", "");
      this.l = paramJSONObject.optString("mapclassname", "com.snda.wifimap.ui.MapActivityNew");
      this.j = paramJSONObject.optString("mappkgname", "com.snda.wifimap");
      this.m = paramJSONObject.optString("mapsin", "736d285cf89bc5d450d3ba33c136b2bb");
      this.i = paramJSONObject.optString("mapurl", "http://static.51y5.net/apk/WifiMapT3.apk");
      this.k = paramJSONObject.optInt("mapversion", 2);
    }
  }
  
  protected final void a()
  {
    super.a();
    if ("samsung".equals(c.getServer().b())) {}
    for (this.e = false;; this.e = true)
    {
      this.f = "http://static.wkanx.com/bbx/v1/index.html";
      this.g = "http://static.wkanx.com/bbx/v1/detail.html";
      this.l = "com.snda.wifimap.ui.MapActivityNew";
      this.j = "com.snda.wifimap";
      this.m = "736d285cf89bc5d450d3ba33c136b2bb";
      this.i = "http://static.51y5.net/apk/WifiMapT3.apk";
      this.k = 2;
      return;
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
  
  public final String e()
  {
    return this.f;
  }
  
  public final String f()
  {
    return this.g;
  }
  
  public final String g()
  {
    if (TextUtils.isEmpty(this.h))
    {
      if (!"samsung".equals(c.getServer().b())) {
        break label65;
      }
      this.h = "推荐";
    }
    for (;;)
    {
      try
      {
        Resources localResources1 = c.getInstance().getResources();
        if (localResources1 != null) {
          this.h = localResources1.getString(R.string.config_appstore_title_samsung);
        }
      }
      catch (Exception localException1)
      {
        h.a(localException1);
        continue;
      }
      return this.h;
      label65:
      this.h = "应用设置";
      try
      {
        Resources localResources2 = c.getInstance().getResources();
        if (localResources2 != null) {
          this.h = localResources2.getString(R.string.config_appstore_title);
        }
      }
      catch (Exception localException2)
      {
        h.a(localException2);
      }
    }
  }
  
  public final String h()
  {
    return this.i;
  }
  
  public final String i()
  {
    return this.j;
  }
  
  public final int j()
  {
    return this.k;
  }
  
  public final String k()
  {
    return this.l;
  }
  
  public final String l()
  {
    return this.m;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/AppStoreConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */