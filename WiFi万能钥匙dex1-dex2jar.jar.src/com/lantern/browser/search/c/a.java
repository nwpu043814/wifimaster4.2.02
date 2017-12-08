package com.lantern.browser.search.c;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.k;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import com.lantern.core.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static JSONObject a;
  private static JSONObject b;
  
  private static JSONArray a()
  {
    localJSONArray = new JSONArray();
    try
    {
      ArrayList localArrayList = c.getShareValue().a();
      int j = localArrayList.size();
      int i = j;
      if (j > 5) {
        i = 5;
      }
      for (j = 0; j < i; j++)
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>();
        if ((!TextUtils.isEmpty(((WkAccessPoint)localArrayList.get(j)).a)) && (!TextUtils.isEmpty(((WkAccessPoint)localArrayList.get(j)).b)))
        {
          localJSONObject.put("ssid", ((WkAccessPoint)localArrayList.get(j)).a);
          localJSONObject.put("bssid", ((WkAccessPoint)localArrayList.get(j)).b);
          localJSONArray.put(localJSONObject);
        }
      }
      return localJSONArray;
    }
    catch (JSONException localJSONException)
    {
      h.a(localJSONException);
    }
  }
  
  public static JSONObject a(Context paramContext)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = c.getServer();
      if ((a != null) && (TextUtils.isEmpty(a.optString("dhid", "")))) {
        a.put("dhid", ((o)localObject2).g());
      }
      if (a == null)
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>();
        a = localJSONObject;
        localJSONObject.put("lang", k.c());
        a.put("appId", ((o)localObject2).k());
        a.put("chanId", ((o)localObject2).b());
        a.put("origChanId", ((o)localObject2).c());
        a.put("verCode", String.valueOf(k.b(paramContext)));
        a.put("verName", k.a(paramContext));
        a.put("dhid", ((o)localObject2).g());
        a.put("imei", ((o)localObject2).f());
      }
      a.put("mac", ((o)localObject2).r());
      a.put("mapSP", ((o)localObject2).o());
      a.put("longi", ((o)localObject2).e());
      a.put("lati", ((o)localObject2).d());
      a.put("uhid", ((o)localObject2).h());
      localObject2 = k.n(paramContext);
      a.put("netModel", localObject2);
      if (!"w".equals(localObject2)) {
        break label327;
      }
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext == null) {
        break label360;
      }
      localObject1 = o.d(paramContext.getSSID());
      paramContext = o.c(paramContext.getBSSID());
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject2;
        h.a(paramContext);
        continue;
        paramContext = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = paramContext;
    if (paramContext == null) {
      localObject1 = "";
    }
    a.put("capBssid", localObject1);
    a.put("capSsid", localObject2);
    for (;;)
    {
      return a;
      label327:
      a.put("capBssid", "");
      a.put("capSsid", "");
    }
  }
  
  public static JSONObject b(Context paramContext)
  {
    try
    {
      if (b == null)
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>();
        b = (JSONObject)localObject;
        ((JSONObject)localObject).put("os", "android");
        b.put("osApiLevel", String.valueOf(Build.VERSION.SDK_INT));
        b.put("osVerion", Build.VERSION.RELEASE);
        b.put("deviceType", 1);
        b.put("screenWidth", String.valueOf(paramContext.getResources().getDisplayMetrics().widthPixels));
        b.put("screenHeight", String.valueOf(paramContext.getResources().getDisplayMetrics().heightPixels));
        b.put("deviceVendor", Build.MANUFACTURER);
        b.put("deviceVersion", Build.MODEL);
        b.put("androidId", k.g(paramContext));
        b.put("screenDensity", String.valueOf(paramContext.getResources().getDisplayMetrics().density));
        b.put("appPkgName", paramContext.getPackageName());
        b.put("androidAdId", "");
        b.put("isOpenScreen", "0");
        b.put("isp", k.f(paramContext));
        b.put("screenOrientation", paramContext.getResources().getConfiguration().orientation);
      }
      Object localObject = c.getServer();
      if (("w".equals(k.n(paramContext))) && ((TextUtils.isEmpty(((o)localObject).d())) || (TextUtils.isEmpty(((o)localObject).e())))) {
        b.put("scanList", a());
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
      }
    }
    return b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */