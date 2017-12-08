package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.g;
import org.json.JSONObject;

public final class d
{
  static e cw;
  private static b cx = ;
  private static JSONObject cz = new JSONObject();
  String c = null;
  Integer cy = null;
  
  public d(Context paramContext)
  {
    try
    {
      u(paramContext);
      this.cy = l.F(paramContext.getApplicationContext());
      this.c = g.r(paramContext).b();
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        cx.b(paramContext);
      }
    }
  }
  
  private static e u(Context paramContext)
  {
    try
    {
      if (cw == null)
      {
        e locale = new com/tencent/wxop/stat/b/e;
        locale.<init>(paramContext.getApplicationContext(), (byte)0);
        cw = locale;
      }
      paramContext = cw;
      return paramContext;
    }
    finally {}
  }
  
  public final void a(JSONObject paramJSONObject, Thread paramThread)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (cw != null) {
          cw.a(localJSONObject, paramThread);
        }
        r.a(localJSONObject, "cn", this.c);
        if (this.cy != null) {
          localJSONObject.put("tn", this.cy);
        }
        if (paramThread == null)
        {
          paramJSONObject.put("ev", localJSONObject);
          if ((cz != null) && (cz.length() > 0)) {
            paramJSONObject.put("eva", cz);
          }
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        cx.b(paramJSONObject);
        continue;
      }
      paramJSONObject.put("errkv", localJSONObject.toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */