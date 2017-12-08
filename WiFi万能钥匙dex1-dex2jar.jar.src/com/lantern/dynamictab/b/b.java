package com.lantern.dynamictab.b;

import android.text.TextUtils;
import com.lantern.analytics.a;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public String a;
  public String b;
  public String c;
  public String d;
  public int e;
  public boolean f = true;
  
  public static b a(String paramString1, String paramString2)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    label119:
    label165:
    label206:
    label252:
    label282:
    label312:
    for (;;)
    {
      return paramString1;
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString2);
        paramString2 = (String)localObject;
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
          paramString2 = null;
        }
        b localb = new b();
        localb.a = paramString1;
        localb.f = false;
        localb.b = paramString2.optString("icon");
        if (!TextUtils.isEmpty(localb.b)) {
          break label119;
        }
        localb.c = paramString2.optString("msg");
        localb.d = paramString2.optString("param");
        localb.e = paramString2.optInt("dotcount");
        if ((TextUtils.isEmpty(localb.b)) && (TextUtils.isEmpty(localb.c))) {
          break label165;
        }
        bool = true;
        localb.f = bool;
        Object localObject = "";
        if (TextUtils.isEmpty(localb.b)) {
          break label206;
        }
        localObject = "" + "_i";
        paramString2 = (String)localObject;
        if (!TextUtils.isEmpty(localb.b)) {
          break label252;
        }
        paramString2 = (String)localObject;
        if (TextUtils.isEmpty(localb.c)) {
          break label252;
        }
        paramString2 = (String)localObject + "_m";
        localObject = paramString2;
        if (!localb.f) {
          break label282;
        }
        localObject = paramString2 + "_n";
        paramString2 = (String)localObject;
        if (localb.e <= 0) {
          break label312;
        }
        paramString2 = (String)localObject + "_c";
        a.e().onEvent("dy_" + paramString1 + "_ss" + paramString2);
        paramString1 = localb;
      }
      if ((paramString2 == null) || (paramString2.length() == 0))
      {
        a.e().onEvent("dy_tp_err_json");
        paramString1 = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */