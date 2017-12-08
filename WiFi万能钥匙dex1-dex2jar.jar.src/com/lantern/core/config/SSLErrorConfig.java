package com.lantern.core.config;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SSLErrorConfig
  extends a
{
  private boolean e = false;
  private List<String> f;
  
  public SSLErrorConfig(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    boolean bool = true;
    int i = 0;
    if (paramJSONObject == null) {}
    label21:
    do
    {
      return;
      if (paramJSONObject.optInt("vali", 0) != 1) {
        break;
      }
      this.e = bool;
      paramJSONObject = paramJSONObject.optJSONArray("vlist");
    } while ((paramJSONObject == null) || (paramJSONObject.length() == 0));
    if (this.f == null) {
      this.f = new ArrayList();
    }
    for (;;)
    {
      int j = paramJSONObject.length();
      while (i < j)
      {
        String str = paramJSONObject.optString(i, "");
        if (!TextUtils.isEmpty(str)) {
          this.f.add(str);
        }
        i++;
      }
      break;
      bool = false;
      break label21;
      this.f.clear();
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
  
  public final List<String> e()
  {
    return this.f;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/SSLErrorConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */