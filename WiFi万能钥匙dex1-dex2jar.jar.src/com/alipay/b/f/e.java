package com.alipay.b.f;

import android.content.Context;
import org.json.JSONObject;

public final class e
{
  public static f a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      Object localObject = com.alipay.b.h.a.a(paramContext, "device_feature_prefs_name", "device_feature_prefs_key");
      paramContext = (Context)localObject;
      if (com.alipay.c.a.a.a.a.a((String)localObject)) {
        paramContext = com.alipay.b.h.a.a("device_feature_file_name", "device_feature_file_key");
      }
      if (com.alipay.c.a.a.a.a.a(paramContext)) {
        paramContext = null;
      } else {
        try
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramContext);
          paramContext = new com/alipay/b/f/f;
          paramContext.<init>();
          paramContext.a(((JSONObject)localObject).getString("imei"));
          paramContext.b(((JSONObject)localObject).getString("imsi"));
          paramContext.c(((JSONObject)localObject).getString("mac"));
          paramContext.d(((JSONObject)localObject).getString("bluetoothmac"));
          paramContext.e(((JSONObject)localObject).getString("gsi"));
        }
        catch (Exception paramContext)
        {
          com.alipay.b.c.a.a(paramContext);
          paramContext = null;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */