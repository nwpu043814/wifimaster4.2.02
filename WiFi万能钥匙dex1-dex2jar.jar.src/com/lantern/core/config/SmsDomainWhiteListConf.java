package com.lantern.core.config;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SmsDomainWhiteListConf
  extends a
{
  private List<String> e;
  
  public SmsDomainWhiteListConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    JSONArray localJSONArray;
    do
    {
      return;
      localJSONArray = paramJSONObject.optJSONArray("domains");
    } while ((localJSONArray == null) || (localJSONArray.length() == 0));
    if (this.e == null) {
      this.e = new ArrayList();
    }
    for (;;)
    {
      int i = 0;
      int j = localJSONArray.length();
      while (i < j)
      {
        paramJSONObject = localJSONArray.optString(i, "");
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.e.add(paramJSONObject);
        }
        i++;
      }
      break;
      this.e.clear();
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
  
  public final List<String> d()
  {
    return this.e;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/SmsDomainWhiteListConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */