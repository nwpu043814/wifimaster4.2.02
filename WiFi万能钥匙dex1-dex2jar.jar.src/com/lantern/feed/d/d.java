package com.lantern.feed.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.k;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.core.q;
import com.lantern.feed.b.g;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static int a = 3000;
  private static int b = 3000;
  private static SharedPreferences c = PreferenceManager.getDefaultSharedPreferences(c.getAppContext());
  private static JSONObject d;
  private static JSONObject e;
  private static String f = "";
  private static float g;
  
  public static int a(float paramFloat)
  {
    return (int)(17.0F * paramFloat + 0.5F);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    if (g == 0.0F) {
      g = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(g * paramFloat + 0.5F);
  }
  
  public static int a(String paramString, int paramInt)
  {
    i = paramInt;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        i = paramInt;
        if (paramString.startsWith("#")) {
          if ((paramString.length() != 4) && (paramString.length() != 7))
          {
            i = paramInt;
            if (paramString.length() != 9) {}
          }
          else
          {
            String str1 = paramString;
            if (paramString.length() == 4)
            {
              str1 = paramString.substring(1, 2);
              String str2 = paramString.substring(2, 3);
              paramString = paramString.substring(3);
              StringBuilder localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>("#");
              str1 = e(str1) + e(str2) + e(paramString);
            }
            i = Color.parseColor(str1);
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
        i = paramInt;
      }
    }
    return i;
  }
  
  public static Intent a(Context paramContext, String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      try
      {
        Intent localIntent = Intent.parseUri(paramString, 1);
        paramString = (String)localObject;
        if (paramContext.getPackageManager().resolveActivity(localIntent, 0) != null)
        {
          localIntent.addCategory("android.intent.category.BROWSABLE");
          localIntent.setComponent(null);
          paramString = localIntent;
        }
      }
      catch (URISyntaxException paramContext)
      {
        h.c("Bad URI " + paramString + ": " + paramContext.getMessage());
        paramString = (String)localObject;
      }
    }
  }
  
  private static String a(char paramChar)
  {
    char[] arrayOfChar = new char[2];
    for (int i = 1; i >= 0; i--) {
      arrayOfChar[i] = paramChar;
    }
    return new String(arrayOfChar);
  }
  
  public static String a(String paramString, g paramg)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    for (;;)
    {
      return str;
      str = paramString;
      if (paramString.contains("%%CLICKPOS%%"))
      {
        str = paramString;
        if (paramg != null)
        {
          paramg = paramg.B();
          str = paramString;
          if (!TextUtils.isEmpty(paramg)) {
            str = paramString.replace("%%CLICKPOS%%", Uri.encode(paramg));
          }
        }
      }
    }
  }
  
  public static JSONObject a()
  {
    for (;;)
    {
      try
      {
        localObject = c.getString("httpauth_ssid", "");
        String str2 = c.getString("httpauth_bssid", "");
        if (("w".equals(d.getString("netModel"))) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)) && (((String)localObject).equals(d.getString("capSsid"))) && (str2.equals(d.getString("capBssid"))))
        {
          String str1 = c.getString("httpauth_appid", "");
          if (!TextUtils.isEmpty(str1))
          {
            localObject = new org/json/JSONObject;
            ((JSONObject)localObject).<init>();
            ((JSONObject)localObject).put("routeMerId", str1);
            ((JSONObject)localObject).put("routeCertType", "http");
            return (JSONObject)localObject;
          }
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)))
        {
          c.edit().putString("httpauth_ssid", "").apply();
          c.edit().putString("httpauth_bssid", "").apply();
          c.edit().putString("httpauth_appid", "").apply();
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        h.a(localException);
        continue;
      }
      localObject = null;
    }
  }
  
  public static JSONObject a(Context paramContext)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = c.getServer();
      Object localObject3;
      if ((d != null) && (TextUtils.isEmpty(d.optString("dhid", ""))))
      {
        localObject3 = ((ConnectivityManager)c.getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject3 != null) {}
        for (boolean bool = ((NetworkInfo)localObject3).isAvailable(); bool; bool = false) {
          for (int i = 3; (i > 0) && (!((o)localObject2).i()); i--) {
            ((o)localObject2).a("cds001001", false);
          }
        }
        d.put("dhid", ((o)localObject2).g());
      }
      if (d == null)
      {
        localObject3 = new org/json/JSONObject;
        ((JSONObject)localObject3).<init>();
        d = (JSONObject)localObject3;
        ((JSONObject)localObject3).put("lang", k.c());
        d.put("appId", ((o)localObject2).k());
        d.put("chanId", ((o)localObject2).b());
        d.put("origChanId", ((o)localObject2).c());
        d.put("verCode", String.valueOf(k.b(paramContext)));
        d.put("verName", k.a(paramContext));
        d.put("dhid", ((o)localObject2).g());
        d.put("imei", ((o)localObject2).f());
        d.put("feedVer", 1018);
      }
      d.put("mac", ((o)localObject2).r());
      d.put("mapSP", ((o)localObject2).o());
      d.put("longi", d());
      d.put("lati", c());
      d.put("uhid", ((o)localObject2).h());
      localObject2 = k.n(paramContext);
      d.put("netModel", localObject2);
      if (!"w".equals(localObject2)) {
        break label459;
      }
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext == null) {
        break label517;
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
        if (d.has("caller"))
        {
          d.remove("caller");
          continue;
          paramContext = null;
        }
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
    d.put("capBssid", localObject1);
    d.put("capSsid", localObject2);
    while (!TextUtils.isEmpty(f))
    {
      d.put("caller", f);
      return d;
      label459:
      d.put("capBssid", "");
      d.put("capSsid", "");
    }
  }
  
  public static void a(Context paramContext, g paramg, String paramString)
  {
    if (a(paramString))
    {
      Intent localIntent = new Intent("wifi.intent.action.BROWSER");
      String str2 = "";
      String str1 = paramString;
      if (paramg != null)
      {
        str1 = a(paramString, paramg);
        str2 = paramg.g();
      }
      localIntent.setData(Uri.parse(str1));
      localIntent.putExtra("src", "feed");
      if (!TextUtils.isEmpty(str2)) {
        localIntent.putExtra("title", str2);
      }
      localIntent.setPackage(paramContext.getPackageName());
      localIntent.addFlags(268435456);
      e.a(paramContext, localIntent);
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString))
    {
      bool = false;
      return bool;
    }
    String str = paramString;
    if (paramString.startsWith("wkb"))
    {
      str = paramString;
      if (!paramString.startsWith("wkb://"))
      {
        if (!paramString.startsWith("wkb//")) {
          break label98;
        }
        str = paramString.replaceFirst("//", "://");
      }
    }
    for (;;)
    {
      paramString = str.substring(6);
      str = paramString;
      if (!f(paramString)) {
        str = "http://" + paramString;
      }
      bool = f(str);
      break;
      label98:
      if ((paramString.startsWith("wkb:/")) && (!paramString.startsWith("wkb://"))) {
        str = paramString.replaceFirst(":/", "://");
      } else {
        str = paramString.replaceFirst("wkb", "wkb://");
      }
    }
  }
  
  public static float b(Context paramContext, float paramFloat)
  {
    if (g == 0.0F) {
      g = paramContext.getResources().getDisplayMetrics().density;
    }
    return g * paramFloat + 0.5F;
  }
  
  public static JSONObject b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (e == null)
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>();
          e = (JSONObject)localObject;
          ((JSONObject)localObject).put("os", "android");
          e.put("osApiLevel", String.valueOf(Build.VERSION.SDK_INT));
          e.put("osVersion", Build.VERSION.RELEASE);
          e.put("deviceType", 1);
          e.put("screenWidth", String.valueOf(paramContext.getResources().getDisplayMetrics().widthPixels));
          e.put("screenHeight", String.valueOf(paramContext.getResources().getDisplayMetrics().heightPixels));
          e.put("deviceVendor", Build.MANUFACTURER);
          e.put("deviceVersion", Build.MODEL);
          e.put("androidId", k.g(paramContext));
          e.put("screenDensity", String.valueOf(paramContext.getResources().getDisplayMetrics().density));
          e.put("appPkgName", paramContext.getPackageName());
          e.put("androidAdId", "");
          e.put("isOpenScreen", "0");
          e.put("isp", k.f(paramContext));
          e.put("screenOrientation", paramContext.getResources().getConfiguration().orientation);
        }
        Object localObject = c.getServer();
        if ((!"w".equals(k.n(paramContext))) || ((!TextUtils.isEmpty(((o)localObject).d())) && (!TextUtils.isEmpty(((o)localObject).e())))) {
          continue;
        }
        e.put("scanList", f());
      }
      catch (Exception paramContext)
      {
        h.a(paramContext);
        continue;
      }
      return e;
      if (e.has("scanList")) {
        e.remove("scanList");
      }
    }
  }
  
  public static void b()
  {
    b("");
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, null, paramString);
  }
  
  public static void b(String paramString)
  {
    Intent localIntent = new Intent("wifi.intent.action.SEARCH");
    localIntent.setPackage(c.getAppContext().getPackageName());
    localIntent.addFlags(268435456);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("kw", paramString);
    }
    e.a(c.getAppContext(), localIntent);
  }
  
  public static String c()
  {
    String str2 = c.getServer().d();
    Object localObject = str2;
    String str3;
    if (TextUtils.isEmpty(str2))
    {
      str3 = p.a("wk_sdk_loc", "");
      localObject = str2;
      if (TextUtils.isEmpty(str3)) {}
    }
    try
    {
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(str3);
      localObject = ((JSONObject)localObject).optString("lati");
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        String str1 = str2;
      }
    }
  }
  
  public static void c(String paramString)
  {
    f = paramString;
  }
  
  public static Spanned d(String paramString)
  {
    try
    {
      Spanned localSpanned = Html.fromHtml(paramString);
      paramString = localSpanned;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        paramString = new SpannableString(paramString);
      }
    }
    return paramString;
  }
  
  public static String d()
  {
    String str2 = c.getServer().e();
    Object localObject = str2;
    String str3;
    if (TextUtils.isEmpty(str2))
    {
      str3 = p.a("wk_sdk_loc", "");
      localObject = str2;
      if (TextUtils.isEmpty(str3)) {}
    }
    try
    {
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(str3);
      localObject = ((JSONObject)localObject).optString("longi");
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        String str1 = str2;
      }
    }
  }
  
  private static String e(String paramString)
  {
    int k = 0;
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    for (;;)
    {
      return (String)localObject;
      int m = paramString.length();
      localObject = paramString;
      if (m != 0) {
        if (m == 1)
        {
          localObject = a(paramString.charAt(0));
        }
        else
        {
          int n = m * 2;
          switch (m)
          {
          default: 
            localObject = new StringBuilder(n);
          }
          for (;;)
          {
            if (k < 2)
            {
              ((StringBuilder)localObject).append(paramString);
              k++;
              continue;
              localObject = a(paramString.charAt(0));
              break;
              int i = paramString.charAt(0);
              int j = paramString.charAt(1);
              paramString = new char[n];
              for (k = 2; k >= 0; k = k - 1 - 1)
              {
                paramString[k] = i;
                paramString[(k + 1)] = j;
              }
              localObject = new String(paramString);
              break;
            }
          }
          localObject = ((StringBuilder)localObject).toString();
        }
      }
    }
  }
  
  public static List<PackageInfo> e()
  {
    try
    {
      List localList = c.getAppContext().getPackageManager().getInstalledPackages(0);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  private static JSONArray f()
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
  
  private static boolean f(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      return bool1;
    }
    paramString = paramString.toLowerCase(Locale.getDefault());
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i >= 4) {
        break;
      }
      if (paramString.startsWith(new String[] { "http", "https", "file", "wkb" }[i]))
      {
        bool1 = true;
        break;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */