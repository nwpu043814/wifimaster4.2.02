package com.lantern.browser;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Toast;
import com.bluefay.a.e;
import com.lantern.auth.WkParamsConfig;
import com.lantern.auth.g;
import com.lantern.auth.l;
import com.lantern.core.k;
import com.lantern.core.location.LocationCallBack;
import com.lantern.core.location.WkLocationManager;
import com.lantern.core.o;
import com.lantern.core.p;
import com.snda.wifilocating.wxapi.WXEntryActivity;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WkBrowserJsInterface
{
  private static final String JSON_BSSID = "bssid";
  private static final String JSON_SSID = "ssid";
  public static final String PARAM_KEY_HID = "appHid";
  public static final String PARAM_KEY_PAGE_INDEX = "pageIndex";
  public static final String PARAM_KEY_POSITION = "prositon";
  public static final String PARAM_KEY_READABLE_ID = "readableId";
  public static final String PARAM_KEY_SOURCE = "source";
  private static final String TAG = "JsInterfaceUtils";
  private static LocationCallBack mLocCallback;
  private static String mLocCb;
  private static WebView mLocWebView;
  private static String mLoginCb = "";
  private static com.bluefay.d.b mLoginMsgHandler;
  private static BroadcastReceiver mLoginReceiver;
  private static WebView mLoginWebView;
  private static Handler mMainHandler;
  private static String mRegisterCb = "";
  private static WebView mRegisterWebview;
  
  static
  {
    mLocCb = "";
    mLocWebView = null;
    mRegisterWebview = null;
    mLoginWebView = null;
  }
  
  public WkBrowserJsInterface()
  {
    mMainHandler = new Handler(Looper.getMainLooper());
    mLocCallback = new ac(this);
    mLoginReceiver = new al(this);
  }
  
  public static void appState(WebView paramWebView, String paramString1, String paramString2)
  {
    if (bp.a(paramWebView)) {
      return;
    }
    JSONArray localJSONArray2;
    JSONArray localJSONArray1;
    label78:
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString2))
    {
      localJSONArray2 = new JSONArray();
      localJSONArray1 = new JSONArray();
      String str2 = "," + paramString2 + ",";
      PackageManager localPackageManager = paramWebView.getContext().getPackageManager();
      Iterator localIterator = localPackageManager.getInstalledPackages(0).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
          paramString2 = localPackageInfo.packageName;
          if (str2.indexOf("," + paramString2 + ",") != -1)
          {
            localJSONObject = new JSONObject();
            try
            {
              localJSONArray2.put(paramString2);
              localJSONObject.put("pkg", paramString2);
              localJSONObject.put("vcode", localPackageInfo.versionCode);
              localJSONObject.put("vname", localPackageInfo.versionName);
              if ((localPackageInfo.applicationInfo.flags & 0x1) > 0) {
                localJSONObject.put("issys", true);
              }
            }
            catch (Exception paramString2)
            {
              label209:
              String str1;
              label227:
              com.bluefay.b.h.a(paramString2);
            }
            try
            {
              str1 = localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
              paramString2 = str1;
            }
            catch (Exception localException)
            {
              com.bluefay.b.h.a(localException);
              break label227;
            }
            if ((paramString2 != null) && (!paramString2.equalsIgnoreCase(""))) {
              break label413;
            }
            paramString2 = localPackageInfo.applicationInfo.packageName;
          }
        }
      }
    }
    label413:
    for (;;)
    {
      localJSONObject.put("name", paramString2);
      localJSONArray1.put(localJSONObject);
      break label78;
      break label78;
      localJSONObject.put("issys", false);
      break label209;
      if (localJSONArray2.length() > 0)
      {
        try
        {
          com.bluefay.b.h.a("JsInterfaceUtils", new Object[] { localJSONArray1.toString() });
          paramString2 = new java/lang/StringBuilder;
          paramString2.<init>();
          loadJs(paramWebView, paramString1 + "(" + localJSONArray2.toString() + "," + localJSONArray1.toString() + ");");
        }
        catch (Exception paramWebView)
        {
          com.bluefay.b.h.a(paramWebView);
        }
        break;
      }
      loadJs(paramWebView, paramString1 + "([],[]);");
      break;
      break;
    }
  }
  
  public static void authMobileDirect(WebView paramWebView, String paramString)
  {
    com.bluefay.b.h.a("authMobileDirect params " + paramString, new Object[0]);
    Object localObject;
    String str1;
    String str2;
    try
    {
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(paramString);
      str1 = ((JSONObject)localObject).optString("fromSource");
      paramString = ((JSONObject)localObject).optString("ext");
      str2 = ((JSONObject)localObject).optString("callback");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(paramString)))
      {
        if (!TextUtils.isEmpty(str2)) {
          runJavaScriptMethord(paramWebView, str2, new String[] { "0" });
        }
        return;
      }
    }
    catch (JSONException paramWebView)
    {
      for (;;)
      {
        paramWebView.printStackTrace();
      }
      com.lantern.analytics.a.e().onEvent("LoginStart", g.a(str1, null, null, com.lantern.core.c.getServer().k()));
      localObject = com.lantern.core.c.getServer().s();
      ((HashMap)localObject).put("ext", paramString);
      com.lantern.core.c.getServer().b("05000511", (HashMap)localObject);
      paramString = com.lantern.auth.h.c();
      if (!TextUtils.isEmpty(paramString)) {}
    }
    for (paramString = String.format("%s%s", new Object[] { "https://oauth.51y5.net", "/open-sso/fa.sec" });; paramString = String.format("%s%s", new Object[] { paramString, "/open-sso/fa.sec" }))
    {
      new com.lantern.browser.c.c(paramString, (Map)localObject, new ao(paramWebView, str1, str2)).execute(new String[] { "" });
      break;
    }
  }
  
  public static void browser(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        String str = paramString.replaceAll(" ", "%20");
        paramString = new android/content/Intent;
        paramString.<init>("wifi.intent.action.BROWSER", Uri.parse(str));
        paramString.addFlags(268435456);
        paramString.setPackage(paramWebView.getContext().getPackageName());
        paramWebView.getContext().startActivity(paramString);
      }
      catch (ActivityNotFoundException paramWebView) {}
    }
  }
  
  public static void cancelListener(WebView paramWebView)
  {
    com.bluefay.b.h.a("cancelListener", new Object[0]);
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      mLocCb = null;
      mLocWebView = null;
      WkLocationManager.getInstance(paramWebView.getContext()).removeLocationCallBack(mLocCallback);
    }
  }
  
  public static void closeBannerAd(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        ((WkBrowserWebView)paramWebView).b();
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void closeBrowser(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        paramWebView = ((WkBrowserWebView)paramWebView).b();
        if (paramWebView != null) {
          paramWebView.j();
        }
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void cltInfo(WebView paramWebView, String paramString)
  {
    cltInfo(paramWebView, paramString, "");
  }
  
  public static void cltInfo(WebView paramWebView, String paramString1, String paramString2)
  {
    int i = 0;
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      String[] arrayOfString = new String[10];
      arrayOfString[0] = "vcode";
      arrayOfString[1] = "vname";
      arrayOfString[2] = "chanid";
      arrayOfString[3] = "appid";
      arrayOfString[4] = "uhid";
      arrayOfString[5] = "dhid";
      arrayOfString[6] = "ph";
      arrayOfString[7] = "nick";
      arrayOfString[8] = "ii";
      arrayOfString[9] = "mac";
      Context localContext = paramWebView.getContext();
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("vcode", String.valueOf(k.b(localContext)));
        localJSONObject1.put("vname", k.a(localContext));
        localJSONObject1.put("chanid", k.l(localContext));
        localJSONObject1.put("appid", com.lantern.core.c.getServer().k());
        localJSONObject1.put("uhid", p.c(""));
        localJSONObject1.put("dhid", p.b(""));
        localJSONObject1.put("ph", "");
        localJSONObject1.put("nick", "");
        localJSONObject1.put("ii", k.c(localContext));
        localJSONObject1.put("mac", k.e(localContext));
        com.bluefay.b.h.a("cltInfo info.toString():" + localJSONObject1.toString(), new Object[0]);
        if (TextUtils.isEmpty(paramString2)) {
          loadJs(paramWebView, paramString1 + "(" + localJSONObject1.toString() + ")");
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          com.bluefay.b.h.a(localJSONException1);
        }
        JSONObject localJSONObject2 = new JSONObject();
        paramString2 = "," + paramString2 + ",";
        for (;;)
        {
          if (i < 10)
          {
            if (paramString2.indexOf(arrayOfString[i]) != -1) {}
            try
            {
              localJSONObject2.put(arrayOfString[i], localJSONObject1.get(arrayOfString[i]));
              i++;
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                com.bluefay.b.h.a(localJSONException2);
              }
            }
          }
        }
        if (localJSONObject2.length() <= 0) {
          loadJs(paramWebView, paramString1 + "({})");
        } else {
          loadJs(paramWebView, paramString1 + "(" + localJSONObject2.toString() + ")");
        }
      }
    }
  }
  
  private static Map<String, String> decodeParams(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      HashMap localHashMap = new HashMap();
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        if ((localJSONObject.has("tyep")) || (localJSONObject.has("type"))) {
          localHashMap.put("type", localJSONObject.getString("type"));
        }
        paramString = localHashMap;
        if (localJSONObject.has("data"))
        {
          localHashMap.put("data", localJSONObject.getString("data"));
          paramString = localHashMap;
        }
      }
      catch (Exception paramString)
      {
        com.bluefay.b.h.a(paramString);
        paramString = localHashMap;
      }
    }
  }
  
  public static void getAuthCode(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        String str1 = ((JSONObject)localObject).optString("thirdAppId");
        paramString = ((JSONObject)localObject).optString("scope");
        String str2 = ((JSONObject)localObject).optString("onResult");
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString)))
        {
          l locall = new com/lantern/auth/l;
          Context localContext = paramWebView.getContext();
          localObject = new com/lantern/browser/ak;
          ((ak)localObject).<init>(str2, paramWebView);
          locall.<init>(localContext, (com.bluefay.b.a)localObject);
          locall.a(str1, paramString);
        }
      }
      catch (Exception paramWebView)
      {
        paramWebView.printStackTrace();
      }
    }
  }
  
  public static void getBbxDetailHtml(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("WiFikey_bbx"))) {
        com.lantern.analytics.a.e().onEvent("bdload1");
      } else {
        com.lantern.analytics.a.e().onEvent("bdload2");
      }
    }
  }
  
  public static void getBbxHtml(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("WiFikey_bbx"))) {
        com.lantern.analytics.a.e().onEvent("bcload1");
      } else {
        com.lantern.analytics.a.e().onEvent("bload2");
      }
    }
  }
  
  public static void getHtml(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      paramWebView = (WkBrowserWebView)paramWebView;
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("javascript:WiFikey.openOrBrowse")) || (paramString.contains("/feed.css")))) {
        paramWebView.a(true);
      } else {
        paramWebView.a(false);
      }
    }
  }
  
  public static String getLaLo(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {
      paramWebView = "";
    }
    for (;;)
    {
      return paramWebView;
      paramWebView = com.lantern.core.c.getServer();
      if (paramWebView != null)
      {
        paramWebView = paramWebView.o() + "," + paramWebView.d() + "," + paramWebView.e();
      }
      else
      {
        com.bluefay.b.h.a("getLaLo null", new Object[0]);
        paramWebView = "";
      }
    }
  }
  
  public static int getOsVer(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (int i = -1;; i = Build.VERSION.SDK_INT) {
      return i;
    }
  }
  
  public static String getShareData(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {
      paramWebView = "";
    }
    for (;;)
    {
      return paramWebView;
      if (!TextUtils.isEmpty(paramString)) {
        paramWebView = PreferenceManager.getDefaultSharedPreferences(paramWebView.getContext()).getString(paramString, "");
      } else {
        paramWebView = "";
      }
    }
  }
  
  public static String getUserInfo(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView))
    {
      paramWebView = "";
      return paramWebView;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("vcode", String.valueOf(k.b(paramWebView.getContext())));
    ((HashMap)localObject).put("vname", k.a(paramWebView.getContext()));
    ((HashMap)localObject).put("chanid", k.l(paramWebView.getContext()));
    ((HashMap)localObject).put("appid", com.lantern.core.c.getServer().k());
    ((HashMap)localObject).put("uhid", p.c(""));
    paramWebView = p.e(paramWebView.getContext());
    if (paramWebView != null) {}
    for (;;)
    {
      ((HashMap)localObject).put("avatar", paramWebView);
      localObject = (String)((HashMap)localObject).get(paramString);
      com.bluefay.b.h.a("getUserInfo key:" + paramString + " ret:" + (String)localObject, new Object[0]);
      paramWebView = (WebView)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      paramWebView = "";
      break;
      paramWebView = "";
    }
  }
  
  public static String getWifiScanResult(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    JSONArray localJSONArray;
    for (paramWebView = "";; paramWebView = localJSONArray.toString())
    {
      return paramWebView;
      do
      {
        try
        {
          localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>();
          paramWebView = ((WifiManager)paramWebView.getContext().getSystemService("wifi")).getScanResults();
          if ((paramWebView != null) && (paramWebView.size() > 0))
          {
            Iterator localIterator = paramWebView.iterator();
            while (localIterator.hasNext())
            {
              paramWebView = (ScanResult)localIterator.next();
              JSONObject localJSONObject = new org/json/JSONObject;
              localJSONObject.<init>();
              if ((!TextUtils.isEmpty(paramWebView.SSID)) && (!TextUtils.isEmpty(paramWebView.BSSID)))
              {
                localJSONObject.put("ssid", paramWebView.SSID);
                localJSONObject.put("bssid", paramWebView.BSSID);
                localJSONArray.put(localJSONObject);
              }
            }
          }
        }
        catch (JSONException paramWebView)
        {
          com.bluefay.b.h.a(paramWebView);
          paramWebView = "";
        }
      } while (localJSONArray.length() <= 0);
    }
  }
  
  public static String getcltInfo(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {
      paramWebView = "";
    }
    for (;;)
    {
      return paramWebView;
      if (TextUtils.isEmpty(paramString))
      {
        paramWebView = "";
      }
      else if (paramString.equals("vcode"))
      {
        paramWebView = String.valueOf(k.b(paramWebView.getContext()));
      }
      else if (paramString.equals("vname"))
      {
        paramWebView = k.a(paramWebView.getContext());
      }
      else if (paramString.equals("chanid"))
      {
        paramWebView = k.l(paramWebView.getContext());
      }
      else if (paramString.equals("appid"))
      {
        paramWebView = com.lantern.core.c.getServer().k();
      }
      else if (paramString.equals("uhid"))
      {
        paramWebView = p.c("");
      }
      else if (paramString.equals("dhid"))
      {
        paramWebView = p.b("");
      }
      else if (paramString.equals("userToken"))
      {
        paramWebView = p.f(paramWebView.getContext());
      }
      else if (paramString.equals("ii"))
      {
        paramWebView = k.c(paramWebView.getContext());
      }
      else if (paramString.equals("mac"))
      {
        paramWebView = k.e(paramWebView.getContext());
      }
      else if (paramString.equals("ssid"))
      {
        paramWebView = bp.a(paramWebView.getContext());
        com.bluefay.b.h.a("getcltInfo ssid:" + paramWebView, new Object[0]);
      }
      else if (paramString.equals("bssid"))
      {
        paramWebView = bp.b(paramWebView.getContext());
        com.bluefay.b.h.a("getcltInfo bssid:" + paramWebView, new Object[0]);
      }
      else if (paramString.equals("ph"))
      {
        paramWebView = p.c(paramWebView.getContext());
      }
      else if (paramString.equals("nick"))
      {
        paramWebView = p.d(paramWebView.getContext());
      }
      else if ("osver".equals(paramString))
      {
        paramWebView = String.valueOf(Build.VERSION.SDK_INT);
      }
      else if ("netmode".equals(paramString))
      {
        paramWebView = k.n(paramWebView.getContext());
      }
      else if ("simop".equals(paramString))
      {
        paramWebView = bp.e(paramWebView.getContext());
      }
      else if ("manufacturer".equals(paramString))
      {
        paramWebView = Build.MANUFACTURER;
      }
      else if ("osvername".equals(paramString))
      {
        paramWebView = Build.VERSION.RELEASE;
      }
      else if ("model".equals(paramString))
      {
        paramWebView = Build.MODEL;
      }
      else if ("device".equals(paramString))
      {
        paramWebView = Build.DEVICE;
      }
      else if ("brand".equals(paramString))
      {
        paramWebView = Build.BRAND;
      }
      else if ("product".equals(paramString))
      {
        paramWebView = Build.PRODUCT;
      }
      else if ("androidid".equals(paramString))
      {
        paramWebView = k.g(paramWebView.getContext());
      }
      else
      {
        paramWebView = "";
      }
    }
  }
  
  public static void hideActionBar(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        paramWebView = ((WkBrowserWebView)paramWebView).b();
        if (paramWebView != null) {
          paramWebView.l();
        }
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void hideInputKeyBoard(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        ((InputMethodManager)paramWebView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramWebView.getWindowToken(), 0);
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void hideOptionMenu(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        paramWebView = ((WkBrowserWebView)paramWebView).b();
        if (paramWebView != null) {
          paramWebView.i();
        }
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static boolean isAppInstalled(WebView paramWebView, String paramString)
  {
    boolean bool = true;
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return bool;
      try
      {
        paramWebView = paramWebView.getContext().getPackageManager().getPackageInfo(paramString, 0);
        if (paramWebView != null) {
          continue;
        }
        bool = false;
      }
      catch (PackageManager.NameNotFoundException paramWebView)
      {
        for (;;)
        {
          paramWebView = null;
        }
      }
    }
  }
  
  private static boolean isFakeUser()
  {
    String str = p.c("");
    if (("a0000000000000000000000000000001".equalsIgnoreCase(str)) || (TextUtils.isEmpty(str))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String isGuest(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {
      paramWebView = "";
    }
    for (;;)
    {
      return paramWebView;
      if (isFakeUser()) {
        paramWebView = "1";
      } else {
        paramWebView = "-1";
      }
    }
  }
  
  public static boolean isWXAppInstalledAndSupported(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (boolean bool = false;; bool = WkWeiXinUtil.isWXAppInstalledAndSupported()) {
      return bool;
    }
  }
  
  private static void loadJs(WebView paramWebView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      com.bluefay.b.h.a("JsInterfaceUtils", new Object[] { paramString });
      if (paramWebView != null) {
        try
        {
          Handler localHandler = mMainHandler;
          am localam = new com/lantern/browser/am;
          localam.<init>(paramWebView, paramString);
          localHandler.post(localam);
        }
        catch (Exception paramWebView)
        {
          com.bluefay.b.h.a(paramWebView);
        }
      }
    }
  }
  
  public static void locationListener(WebView paramWebView, String paramString)
  {
    com.bluefay.b.h.a("locationListener cb:" + paramString, new Object[0]);
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      mLocCb = paramString;
      mLocWebView = paramWebView;
      WkLocationManager.getInstance(paramWebView.getContext()).addLocationCallBack(mLocCallback);
    }
  }
  
  public static void login(WebView paramWebView, String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        paramString = ((JSONObject)localObject).optString("thirdAppId");
        str1 = ((JSONObject)localObject).optString("scope");
        str2 = ((JSONObject)localObject).optString("appName");
        str3 = ((JSONObject)localObject).optString("appIcon");
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
        {
          e.a(R.string.browser_login_error);
          return;
        }
      }
      catch (Exception paramWebView)
      {
        Object localObject;
        String str1;
        String str2;
        String str3;
        paramWebView.printStackTrace();
        continue;
      }
      mLoginCb = ((JSONObject)localObject).optString("onResult");
      mLoginWebView = paramWebView;
      localObject = paramWebView.getContext();
      registerReceiver((Context)localObject);
      paramWebView = new com/lantern/auth/WkParamsConfig;
      paramWebView.<init>(paramString, str1, str2, str3);
      paramString = new android/content/Intent;
      paramString.<init>("wifi.intent.action.AUTH_MAIN");
      paramString.setPackage(((Context)localObject).getPackageName());
      paramString.addFlags(268435456);
      paramString.putExtra("key_params_config", paramWebView);
      paramString.putExtra("src", "html");
      e.a((Context)localObject, paramString);
    }
  }
  
  public static void onCompletedLatestNews(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        paramWebView = ((WkBrowserWebView)paramWebView).b();
        if (paramWebView != null) {
          paramWebView.f();
        }
      }
      catch (Exception paramWebView) {}
    }
  }
  
  public static void onLoading(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        paramWebView = ((WkBrowserWebView)paramWebView).b();
        if (paramWebView != null) {
          paramWebView.g();
        }
      }
      catch (Exception paramWebView) {}
    }
  }
  
  public static void openAppDetail(WebView paramWebView, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("wifi.intent.action.APPSTORE_DETAIL_MAIN");
        localIntent.putExtra("appHid", paramString1);
        localIntent.putExtra("readableId", paramString2);
        localIntent.putExtra("pageIndex", paramInt1);
        localIntent.putExtra("prositon", paramInt2);
        localIntent.putExtra("source", paramString3);
        localIntent.addFlags(268435456);
        localIntent.setPackage(paramWebView.getContext().getPackageName());
        paramWebView.getContext().startActivity(localIntent);
      }
      catch (Exception paramWebView) {}
    }
  }
  
  public static void openAppWall(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("wifi.intent.action.APPSTORE_MAIN");
        localIntent.setPackage(paramWebView.getContext().getPackageName());
        localIntent.addFlags(268435456);
        paramWebView.getContext().startActivity(localIntent);
      }
      catch (Exception paramWebView) {}
    }
  }
  
  public static void openOrBrowse(WebView paramWebView, String paramString1, String paramString2)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramString1))
      {
        Context localContext = paramWebView.getContext();
        try
        {
          PackageInfo localPackageInfo = localContext.getPackageManager().getPackageInfo(paramString1, 0);
          if (localPackageInfo != null) {
            try
            {
              paramWebView = localContext.getPackageManager().getLaunchIntentForPackage(paramString1);
              if (!TextUtils.isEmpty(paramString2))
              {
                paramWebView.putExtra("params", paramString2);
                paramWebView.addFlags(67108864);
              }
              localContext.startActivity(paramWebView);
            }
            catch (Exception paramWebView) {}
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Object localObject = null;
          }
        }
      }
      else
      {
        browser(paramWebView, paramString2);
      }
    }
  }
  
  public static void reRegister(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(p.c(""))) || (isFakeUser()))
      {
        mRegisterWebview = paramWebView;
        mRegisterCb = paramString;
        if (mLoginMsgHandler == null) {
          mLoginMsgHandler = new ap(new int[] { 128202 });
        }
        com.lantern.core.c.removeListener(mLoginMsgHandler);
        com.lantern.core.c.addListener(mLoginMsgHandler);
        try
        {
          paramString = new android/content/Intent;
          paramString.<init>("wifi.intent.action.ADD_ACCOUNT_MAIN");
          paramString.addFlags(268435456);
          paramString.setPackage(paramWebView.getContext().getPackageName());
          paramWebView.getContext().startActivity(paramString);
        }
        catch (Exception paramWebView) {}
      }
    }
  }
  
  public static void register(WebView paramWebView, String paramString)
  {
    Object localObject1 = null;
    if (bp.a(paramWebView)) {
      return;
    }
    if ((TextUtils.isEmpty(p.c(""))) || (isFakeUser())) {
      if (TextUtils.isEmpty(paramString)) {
        break label171;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(paramString);
        paramString = ((JSONObject)localObject2).optString("callback");
      }
      catch (Exception paramString)
      {
        Object localObject2;
        paramString = null;
        continue;
      }
      try
      {
        localObject2 = ((JSONObject)localObject2).optString("fromSource");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        continue;
      }
      mRegisterWebview = paramWebView;
      mRegisterCb = paramString;
      if (mLoginMsgHandler == null) {
        mLoginMsgHandler = new aq(new int[] { 128202 });
      }
      com.lantern.core.c.removeListener(mLoginMsgHandler);
      com.lantern.core.c.addListener(mLoginMsgHandler);
      try
      {
        paramString = new android/content/Intent;
        paramString.<init>("wifi.intent.action.ADD_ACCOUNT_MAIN");
        paramString.addFlags(268435456);
        paramString.setPackage(paramWebView.getContext().getPackageName());
        paramString.putExtra("fromSource", (String)localObject1);
        paramWebView.getContext().startActivity(paramString);
      }
      catch (Exception paramWebView) {}
      break;
      break;
      label171:
      paramString = null;
    }
  }
  
  private static void registerReceiver(Context paramContext)
  {
    try
    {
      paramContext.unregisterReceiver(mLoginReceiver);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("wifi.intent.action.AUTHSDK_MESSAGE");
      paramContext.registerReceiver(mLoginReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.bluefay.b.h.a(localException);
      }
    }
  }
  
  private static void runJavaScriptMethord(WebView paramWebView, String paramString, String... paramVarArgs)
  {
    paramString = "javascript:" + paramString + "('";
    for (int i = 0; i < paramVarArgs.length; i++)
    {
      String str = paramVarArgs[i];
      str = paramString + str;
      paramString = str;
      if (i != paramVarArgs.length - 1) {
        paramString = str + ", ";
      }
    }
    paramString = paramString + "')";
    try
    {
      paramWebView.loadUrl(paramString);
      return;
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void sendMessageTo(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          Object localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramString);
          String str = ((JSONObject)localObject).getString("subject");
          paramString = ((JSONObject)localObject).getString("content");
          localObject = ((JSONObject)localObject).getString("title");
          Handler localHandler = mMainHandler;
          as localas = new com/lantern/browser/as;
          localas.<init>(str, paramString, paramWebView, (String)localObject);
          localHandler.post(localas);
        }
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void sendSMS(WebView paramWebView, String paramString1, String paramString2)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      SmsManager localSmsManager;
      try
      {
        localSmsManager = SmsManager.getDefault();
        Context localContext = paramWebView.getContext();
        paramWebView = new android/content/Intent;
        paramWebView.<init>();
        paramWebView = PendingIntent.getBroadcast(localContext, 0, paramWebView, 0);
        if (paramString2.length() >= 70)
        {
          paramString2 = localSmsManager.divideMessage(paramString2).iterator();
          while (paramString2.hasNext()) {
            localSmsManager.sendTextMessage(paramString1, null, (String)paramString2.next(), paramWebView, null);
          }
        }
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
      localSmsManager.sendTextMessage(paramString1, null, paramString2, paramWebView, null);
    }
  }
  
  public static void sendSMSWithUI(WebView paramWebView, String paramString1, String paramString2)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("smsto:");
        localObject = Uri.parse(paramString1);
        paramString1 = new android/content/Intent;
        paramString1.<init>("android.intent.action.VIEW", (Uri)localObject);
        paramString1.putExtra("sms_body", paramString2);
        paramWebView.getContext().startActivity(paramString1);
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void sendWeixinOrSNS(WebView paramWebView, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      if (!WkWeiXinUtil.isWXAppInstalledAndSupported())
      {
        Toast.makeText(paramWebView.getContext(), R.string.browser_weixin_tips, 0).show();
      }
      else
      {
        WkWeiXinUtil.shareToWeiXin(paramInt, paramString3, paramString1, paramString2, paramString4);
        WXEntryActivity.setListener(new ar(paramInt));
        paramWebView = new HashMap();
        paramWebView.put("src", "web");
        paramWebView.put("title", paramString1);
        paramWebView.put("url", paramString3);
        paramWebView = new JSONObject(paramWebView).toString();
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          com.lantern.analytics.a.e().onEvent("cht", paramWebView);
          break;
        case 1: 
          com.lantern.analytics.a.e().onEvent("mmt", paramWebView);
          break;
        case 2: 
          com.lantern.analytics.a.e().onEvent("favo", paramWebView);
        }
      }
    }
  }
  
  public static void setOrientation(WebView paramWebView, int paramInt)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      paramWebView = (WkBrowserWebView)paramWebView;
      if (paramWebView.b() != null)
      {
        paramWebView = paramWebView.b().getActivity();
        if ((paramWebView != null) && (paramWebView.getRequestedOrientation() != paramInt)) {
          try
          {
            paramWebView.setRequestedOrientation(paramInt);
          }
          catch (Exception paramWebView)
          {
            com.bluefay.b.h.a(paramWebView);
          }
        }
      }
    }
  }
  
  public static void setShareData(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = com.lantern.webox.c.b.a(paramString);
        paramWebView = PreferenceManager.getDefaultSharedPreferences(paramWebView.getContext()).edit();
        paramString = paramString.entrySet().iterator();
        while (paramString.hasNext()) {
          try
          {
            Map.Entry localEntry = (Map.Entry)paramString.next();
            paramWebView.putString((String)localEntry.getKey(), String.valueOf(localEntry.getValue()));
          }
          catch (Exception localException)
          {
            com.bluefay.b.h.a(localException);
          }
        }
        paramWebView.commit();
      }
    }
  }
  
  public static void shareToWeiXin(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      Object localObject;
      try
      {
        if (WkWeiXinUtil.isWXAppInstalledAndSupported()) {
          break label86;
        }
        Toast.makeText(paramWebView.getContext(), R.string.browser_weixin_tips, 0).show();
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        if (!((JSONObject)localObject).has("callback")) {
          continue;
        }
        runJavaScriptMethord(paramWebView, ((JSONObject)localObject).getString("callback"), new String[] { "-2" });
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
      continue;
      label86:
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new java/lang/Thread;
        ae localae = new com/lantern/browser/ae;
        localae.<init>(paramString, paramWebView);
        ((Thread)localObject).<init>(localae);
        ((Thread)localObject).start();
      }
    }
  }
  
  public static void shareToWeixinCallback(WebView paramWebView, String paramString1, String paramString2, int paramInt)
  {
    new Thread(new ah(paramString1, paramWebView, paramInt, paramWebView.getContext(), paramString2)).start();
  }
  
  public static void showActionBar(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        paramWebView = ((WkBrowserWebView)paramWebView).b();
        if (paramWebView != null) {
          paramWebView.k();
        }
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void showInputKeyBoard(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        ((InputMethodManager)paramWebView.getContext().getSystemService("input_method")).toggleSoftInput(2, 0);
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void showOptionMenu(WebView paramWebView)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        paramWebView = ((WkBrowserWebView)paramWebView).b();
        if (paramWebView != null) {
          paramWebView.h();
        }
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static String signCustomParams(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {
      paramWebView = "";
    }
    o localo;
    do
    {
      return paramWebView;
      paramWebView = "";
      localo = com.lantern.core.c.getServer();
    } while (localo == null);
    HashMap localHashMap = new HashMap();
    Object localObject = com.lantern.webox.c.b.a(paramString);
    paramString = "00000000";
    paramWebView = paramString;
    if (localObject != null)
    {
      paramWebView = paramString;
      if (((Map)localObject).size() > 0)
      {
        paramWebView = ((Map)localObject).get("pid");
        if (!(paramWebView instanceof String)) {
          break label167;
        }
      }
    }
    label167:
    for (paramWebView = (String)paramWebView;; paramWebView = "00000000")
    {
      paramString = ((Map)localObject).entrySet().iterator();
      while (paramString.hasNext()) {
        try
        {
          localObject = (Map.Entry)paramString.next();
          localHashMap.put((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
        catch (Exception localException)
        {
          com.bluefay.b.h.a(localException);
        }
      }
      paramWebView = z.b(localo.b(paramWebView, localHashMap));
      break;
    }
  }
  
  public static String signParams(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {
      paramWebView = "";
    }
    o localo;
    do
    {
      return paramWebView;
      paramWebView = "";
      localo = com.lantern.core.c.getServer();
    } while (localo == null);
    HashMap localHashMap = new HashMap();
    paramWebView = localo.s();
    if (paramWebView.size() > 0)
    {
      paramWebView = paramWebView.entrySet().iterator();
      while (paramWebView.hasNext()) {
        try
        {
          Map.Entry localEntry = (Map.Entry)paramWebView.next();
          localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
        }
        catch (Exception localException1)
        {
          com.bluefay.b.h.a(localException1);
        }
      }
    }
    Object localObject = com.lantern.webox.c.b.a(paramString);
    paramString = "00300305";
    paramWebView = paramString;
    if (localObject != null)
    {
      paramWebView = paramString;
      if (((Map)localObject).size() > 0)
      {
        paramWebView = ((Map)localObject).get("pid");
        if (!(paramWebView instanceof String)) {
          break label247;
        }
      }
    }
    label247:
    for (paramWebView = (String)paramWebView;; paramWebView = "00300305")
    {
      paramString = ((Map)localObject).entrySet().iterator();
      while (paramString.hasNext()) {
        try
        {
          localObject = (Map.Entry)paramString.next();
          localHashMap.put((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
        catch (Exception localException2)
        {
          com.bluefay.b.h.a(localException2);
        }
      }
      paramWebView = z.b(localo.b(paramWebView, localHashMap));
      break;
    }
  }
  
  public static void startActivity(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      try
      {
        Intent localIntent = new android/content/Intent;
        localIntent.<init>(paramString);
        localIntent.setPackage(paramWebView.getContext().getPackageName());
        localIntent.addFlags(268435456);
        paramWebView.getContext().startActivity(localIntent);
      }
      catch (Exception paramWebView)
      {
        com.bluefay.b.h.a(paramWebView);
      }
    }
  }
  
  public static void trace(WebView paramWebView, String paramString)
  {
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      paramString = decodeParams(paramString);
      if (paramString != null)
      {
        paramWebView = (String)paramString.get("type");
        paramString = (String)paramString.get("data");
        com.lantern.analytics.a.e().onEvent(paramWebView, paramString);
      }
    }
  }
  
  private static void unRegisterReceiver(Context paramContext)
  {
    try
    {
      paramContext.unregisterReceiver(mLoginReceiver);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramContext);
      }
    }
  }
  
  public static void viewAppInMarket(WebView paramWebView, String paramString)
  {
    com.bluefay.b.h.a("JsInterfaceUtils", new Object[] { "viewAppInMarket:" + paramString });
    if (bp.a(paramWebView)) {}
    for (;;)
    {
      return;
      mMainHandler.post(new an(paramString, paramWebView));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/WkBrowserJsInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */