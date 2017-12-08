package com.lantern.core.config;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DomainZenmenConf
  extends a
{
  private List<String> e;
  
  public DomainZenmenConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("cookie");
    } while ((paramJSONObject == null) || (paramJSONObject.length() == 0));
    if (this.e == null) {
      this.e = new ArrayList();
    }
    for (;;)
    {
      int i = 0;
      int j = paramJSONObject.length();
      while (i < j)
      {
        String str = paramJSONObject.optString(i, "");
        if (!TextUtils.isEmpty(str)) {
          this.e.add(str);
        }
        i++;
      }
      break;
      this.e.clear();
    }
  }
  
  protected final void a()
  {
    this.e = new ArrayList();
    this.e.add(".51y5.com");
    this.e.add(".51y5.net");
    this.e.add(".y5store.com");
    this.e.add(".lianwifi.com");
    this.e.add(".wkanx.com");
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  public final List<String> d()
  {
    return this.e;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/DomainZenmenConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */