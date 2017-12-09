package com.lantern.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.c.d.a.a.a.c.a;
import com.c.d.a.a.a.c.a.a;
import com.lantern.core.g.i;
import com.snda.wifilocating.support.SDCardConifg;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
{
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f = "";
  protected String g;
  protected Context h;
  protected String i;
  protected String j;
  protected String k;
  protected String l = "";
  protected String m = "";
  protected String n = "b";
  private boolean o;
  private int p = -1;
  private int q = -1;
  
  public o() {}
  
  public o(Context paramContext)
  {
    this.h = paramContext;
    this.b = com.bluefay.a.c.c(this.h);
    this.g = com.bluefay.a.c.e(this.h);
    this.e = k.l(this.h);
    h.b("imei:%s,mac:%s,channel:%s", new Object[] { this.b, this.g, this.e });
    this.f = p.a(this.h, "sdk_device", "init_channel", "");
    if (this.f.length() == 0)
    {
      String str = k.m(c.getAppContext());
      paramContext = ".wkchannel";
      if (str != null) {
        paramContext = ".wkchannel" + str;
      }
      paramContext = com.bluefay.b.b.a(new File(Environment.getExternalStorageDirectory(), paramContext).getAbsolutePath());
      if (paramContext != null)
      {
        str = n.c(new String(paramContext), "YJm8T!uw2Wo^Yi80", "T9&m6OHpo%AYm$oM");
        paramContext = str;
        if (!TextUtils.isEmpty(str)) {
          paramContext = str.trim();
        }
        this.f = paramContext;
        h.a("orgchannel:" + this.f);
        if ((this.f == null) || (this.f.length() <= 0)) {
          break label417;
        }
        p.f(this.h, this.f);
      }
    }
    else
    {
      label275:
      this.c = p.b(this.h, "");
      if (this.c.length() != 0) {
        break label478;
      }
      this.p = 0;
      this.c = p.b();
      h.a("sddhid:" + this.c);
      if ((this.c == null) || (this.c.length() <= 0)) {
        break label470;
      }
      this.q = 1;
      p.c(this.h, this.c);
    }
    for (;;)
    {
      if (!g(this.c)) {
        this.c = "";
      }
      this.d = p.d(this.h, "");
      if (this.d.length() == 0) {
        this.d = "a0000000000000000000000000000001";
      }
      return;
      paramContext = "";
      break;
      label417:
      h.a("new user channel:" + this.e);
      p.f(this.h, this.e);
      p.e(this.e);
      this.f = this.e;
      break label275;
      label470:
      this.q = 0;
      continue;
      label478:
      this.p = 1;
    }
  }
  
  public static int a(Context paramContext)
  {
    try
    {
      i1 = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 1).uid;
      return i1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        int i1 = -1;
      }
    }
  }
  
  public static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    String str = b.a();
    h.a("getRequest pid:%s func:%s", new Object[] { paramString, str });
    if ("A".equals(str))
    {
      com.lantern.analytics.a.e().onEvent("pber_" + str + "_" + paramString);
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      if ("B".equals(str))
      {
        paramString = com.lantern.core.h.b.a(true, false, "a", paramString, paramArrayOfByte);
      }
      else if ("C".equals(str))
      {
        paramString = com.lantern.core.h.b.a(true, true, b.b(), paramString, paramArrayOfByte);
      }
      else if ("D".equals(str))
      {
        paramString = com.lantern.core.h.b.a(false, true, b.b(), paramString, paramArrayOfByte);
      }
      else
      {
        com.lantern.analytics.a.e().onEvent("pber_" + str + "_" + paramString);
        paramString = (String)localObject;
      }
    }
  }
  
  public static byte[] a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = com.lantern.core.h.b.a(true, true, b.b(), paramString, paramArrayOfByte);; paramString = a(paramString, paramArrayOfByte)) {
      return paramString;
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    String str = b.a();
    if ("B".equals(str)) {
      paramArrayOfByte = b(paramArrayOfByte, paramString, false, true);
    }
    for (;;)
    {
      return paramArrayOfByte;
      if ("C".equals(str))
      {
        paramArrayOfByte = b(paramArrayOfByte, paramString, true, true);
      }
      else if ("D".equals(str))
      {
        paramArrayOfByte = b(paramArrayOfByte, paramString, true, false);
      }
      else
      {
        com.lantern.analytics.a.e().onEvent("pbed_" + paramString);
        paramArrayOfByte = null;
      }
    }
  }


  //PWD byte數組拆解组装逻辑，前面6个字节是header。
  public static com.lantern.core.h.a b(String paramString, byte[] paramArrayOfByte)
  {
    h.a("getResponse pid:%s", new Object[] { paramString });
    paramString = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, paramString, 0, 4);
    int i2;
    if (com.lantern.core.h.b.a(paramString) == 0)
    {
      i2 = paramArrayOfByte[4];
      int i1 = paramArrayOfByte[5];
      paramString = new byte[paramArrayOfByte.length - 6];
      System.arraycopy(paramArrayOfByte, 6, paramString, 0, paramString.length);
      paramArrayOfByte = c.getServer().a(paramString, new String(new byte[] { i1 }));
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        com.lantern.analytics.a.e().onEvent("pbed");
        paramString = new com.lantern.core.h.a(-2, null);
        return paramString;
      }
      if (i2 != 1) {
        break label311;
      }
      paramArrayOfByte = com.lantern.d.a.b(paramArrayOfByte);
    }
    label311:
    for (;;)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        com.lantern.analytics.a.e().onEvent("pbez");
        paramString = new com.lantern.core.h.a(-3, null);
        break;
      }
      int i4 = paramArrayOfByte[0];
      int i3 = 1;
      paramString = null;
      i2 = 0;
      while (i2 < i4)
      {
        paramString = new byte[4];
        System.arraycopy(paramArrayOfByte, i3, paramString, 0, 4);
        i3 += 4;
        byte[] arrayOfByte = new byte[4];
        System.arraycopy(paramArrayOfByte, i3, arrayOfByte, 0, 4);
        int i5 = i3 + 4;
        arrayOfByte = new byte[com.lantern.core.h.b.a(arrayOfByte)];
        System.arraycopy(paramArrayOfByte, i5, arrayOfByte, 0, arrayOfByte.length);
        i3 = arrayOfByte.length;
        h.a("response pid:" + com.lantern.core.h.b.a(paramString));
        paramString = new com.lantern.core.h.a(0, arrayOfByte);
        i2++;
        i3 += i5;
      }
      break;
      paramString = new byte[paramArrayOfByte.length - 4];
      System.arraycopy(paramArrayOfByte, 4, paramString, 0, paramString.length);
      paramString = new com.lantern.core.h.a(-1, paramString);
      break;
    }
  }
  
  public static com.lantern.core.h.a b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    h.a("getResponse pid:%s", new Object[] { paramString });
    paramString = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, paramString, 0, 4);
    int i2;
    if (com.lantern.core.h.b.a(paramString) == 0)
    {
      i2 = paramArrayOfByte[4];
      int i1 = paramArrayOfByte[5];
      paramString = new byte[paramArrayOfByte.length - 6];
      System.arraycopy(paramArrayOfByte, 6, paramString, 0, paramString.length);
      if (paramBoolean) {}
      for (paramString = c.getServer().b(paramString, new String(new byte[] { i1 }), true, true); (paramString == null) || (paramString.length == 0); paramString = c.getServer().a(paramString, new String(new byte[] { i1 })))
      {
        com.lantern.analytics.a.e().onEvent("pbed");
        paramString = new com.lantern.core.h.a(-2, null);
        return paramString;
      }
      if (i2 != 1) {
        break label346;
      }
    }
    label346:
    for (paramArrayOfByte = com.lantern.d.a.b(paramString);; paramArrayOfByte = paramString)
    {
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      {
        com.lantern.analytics.a.e().onEvent("pbez");
        paramString = new com.lantern.core.h.a(-3, null);
        break;
      }
      int i4 = paramArrayOfByte[0];
      int i3 = 1;
      paramString = null;
      i2 = 0;
      while (i2 < i4)
      {
        paramString = new byte[4];
        System.arraycopy(paramArrayOfByte, i3, paramString, 0, 4);
        i3 += 4;
        byte[] arrayOfByte = new byte[4];
        System.arraycopy(paramArrayOfByte, i3, arrayOfByte, 0, 4);
        int i5 = i3 + 4;
        arrayOfByte = new byte[com.lantern.core.h.b.a(arrayOfByte)];
        System.arraycopy(paramArrayOfByte, i5, arrayOfByte, 0, arrayOfByte.length);
        i3 = arrayOfByte.length;
        h.a("response pid:" + com.lantern.core.h.b.a(paramString));
        paramString = new com.lantern.core.h.a(0, arrayOfByte);
        i2++;
        i3 += i5;
      }
      break;
      paramString = new byte[paramArrayOfByte.length - 4];
      System.arraycopy(paramArrayOfByte, 4, paramString, 0, paramString.length);
      paramString = new com.lantern.core.h.a(-1, paramString);
      break;
    }
  }
  
  private byte[] b(Context paramContext)
  {
    Object localObject1 = k.d(paramContext);
    com.c.e.a.a.a.a.a.a.a locala = com.c.e.a.a.a.a.a.a.l();
    if (localObject1 != null) {}
    for (;;)
    {
      locala.a((String)localObject1);
      locala.b("Android");
      locala.c(Build.VERSION.RELEASE);
      locala.d(String.valueOf(Build.VERSION.SDK_INT));
      locala.e(k.a(paramContext));
      locala.f(String.valueOf(k.j(paramContext)));
      locala.g(String.valueOf(k.k(paramContext)));
      locala.h(Build.FINGERPRINT);
      locala.i(Build.MANUFACTURER);
      locala.j(Build.MODEL);
      locala.k(k.g(paramContext));
      locala.l("2.0");
      try
      {
        localObject1 = WkSecretKeyNativeNew.s7(this.h);
        h.a((String)localObject1, new Object[0]);
        paramContext = new org/json/JSONObject;
        paramContext.<init>((String)localObject1);
        localObject1 = paramContext.keys();
        while (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          Object localObject2 = paramContext.get(str);
          if ((localObject2 instanceof String)) {
            locala.a(str, (String)localObject2);
          }
        }
        return ((com.c.e.a.a.a.a.a.a)locala.c()).b();
      }
      catch (Exception paramContext)
      {
        h.a(paramContext);
        com.lantern.analytics.a.e().onEvent("s7err");
      }
      localObject1 = "";
    }
  }
  
  private byte[] b(byte[] paramArrayOfByte, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    h.a("dtype:%s so:%s fix:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1) {
      if ("l".equals(paramString)) {
        paramArrayOfByte = WkSecretKeyNativeNew.s13(paramArrayOfByte, paramBoolean2, this.h);
      }
    }
    for (;;)
    {
      return paramArrayOfByte;
      if ("k".equals(paramString))
      {
        paramArrayOfByte = WkSecretKeyNativeNew.s17(paramArrayOfByte, paramBoolean2, this.h);
      }
      else if ("a".equals(paramString))
      {
        paramArrayOfByte = WkSecretKeyNativeNew.s11(paramArrayOfByte, this.h);
      }
      else if ("r".equals(paramString))
      {
        h.c("no r decrypt");
        com.lantern.analytics.a.e().onEvent("pbed_" + paramString + "_" + paramBoolean1 + "_" + paramBoolean2);
        paramArrayOfByte = null;
      }
      else if (!"n".equals(paramString))
      {
        com.lantern.analytics.a.e().onEvent("pbed_" + paramString + "_" + paramBoolean1 + "_" + paramBoolean2);
        paramArrayOfByte = null;
        continue;
        if ("l".equals(paramString))
        {
          h.c("l is native, not java");
          com.lantern.analytics.a.e().onEvent("pbed_" + paramString + "_" + paramBoolean1 + "_" + paramBoolean2);
          paramArrayOfByte = null;
        }
        else if ("a".equals(paramString))
        {
          paramArrayOfByte = n.b(paramArrayOfByte, this.i, this.j);
        }
        else if ("r".equals(paramString))
        {
          h.c("r is native, not java");
          com.lantern.analytics.a.e().onEvent("pbed_" + paramString + "_" + paramBoolean1 + "_" + paramBoolean2);
          paramArrayOfByte = null;
        }
        else if (!"n".equals(paramString))
        {
          com.lantern.analytics.a.e().onEvent("pbed_" + paramString + "_" + paramBoolean1 + "_" + paramBoolean2);
          paramArrayOfByte = null;
        }
      }
    }
  }
  
  public static String c(String paramString)
  {
    String str;
    if (!"\000\000:\000\000:\000\000:\000\000:\000\000:\000\000".equals(paramString))
    {
      str = paramString;
      if (!"00:00:00:00:00:00".equals(paramString)) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
  
  public static String d(String paramString)
  {
    int i1 = 0;
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      int i2 = paramString.length();
      str = paramString;
      if (i2 > 1)
      {
        str = paramString;
        if (paramString.charAt(0) == '"')
        {
          str = paramString;
          if (paramString.charAt(i2 - 1) == '"') {
            str = paramString.substring(1, i2 - 1);
          }
        }
      }
    }
    if ((TextUtils.isEmpty(str)) || (str.startsWith("0x")) || (str.startsWith("0X")) || (str.equalsIgnoreCase("<unknown ssid>")) || (str.equalsIgnoreCase("null"))) {
      i1 = 1;
    }
    if (i1 != 0) {}
    for (paramString = "";; paramString = str.replaceAll("\000|\001|\002|\003|\004|\005|\006|\007", "*")) {
      return paramString;
    }
  }
  
  private HashMap<String, String> d(String paramString, HashMap<String, String> paramHashMap)
  {
    String str = new JSONObject(paramHashMap).toString();
    paramHashMap.clear();
    try
    {
      paramHashMap.put("appId", this.a);
      paramHashMap.put("pid", paramString);
      paramHashMap.put("ed", n.b(str, this.i, this.j));
      paramHashMap.put("et", "a");
      paramHashMap.put("st", "m");
      paramHashMap.put("sign", g.a(paramHashMap, this.k));
      paramHashMap.put("pv", "1.0");
      return paramHashMap;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
  }
  
  private static boolean g(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() != 0)
      {
        if (paramString.length() <= 32) {
          break label34;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      label34:
      int i1 = 0;
      label36:
      if (i1 < paramString.length())
      {
        int i2 = paramString.charAt(i1);
        if (((i2 >= 48) && (i2 <= 57)) || ((i2 >= 97) && (i2 <= 122)) || ((i2 >= 65) && (i2 <= 90))) {}
        for (i2 = 1;; i2 = 0)
        {
          bool1 = bool2;
          if (i2 == 0) {
            break;
          }
          i1++;
          break label36;
        }
      }
      bool1 = true;
    }
  }
  
  private void h(String paramString)
  {
    h.a("dhid:" + paramString, new Object[0]);
    if (paramString != null)
    {
      this.c = paramString;
      p.c(this.h, paramString);
      if ((paramString != null) && (paramString.length() != 0)) {
        break label53;
      }
    }
    for (;;)
    {
      return;
      label53:
      String str = k.m(c.getAppContext());
      Object localObject = ".wkcid";
      if (str != null) {
        localObject = ".wkcid" + str;
      }
      localObject = new File(Environment.getExternalStorageDirectory(), (String)localObject);
      paramString = n.a(paramString, "YJm8T!uw2Wo^Yi80", "T9&m6OHpo%AYm$oM");
      com.bluefay.b.b.a(((File)localObject).getAbsolutePath(), paramString.getBytes());
    }
  }
  
  private static boolean i(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || ("000000000000000".equals(paramString))) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private boolean j(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      int i1;
      Object localObject2;
      try
      {
        boolean bool2 = WkSecretKeyNativeNew.s1(this.h);
        if (bool2) {
          return bool1;
        }
        i1 = y();
        if (i1 == 1)
        {
          localObject1 = com.lantern.analytics.a.e();
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("intpb_");
          ((com.lantern.analytics.a)localObject1).onEvent(paramString + "_y");
          continue;
        }
        localObject2 = com.lantern.analytics.a.e();
      }
      finally {}
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("intpb_");
      ((com.lantern.analytics.a)localObject2).onEvent(paramString + "_n_" + i1);
      bool1 = false;
    }
  }
  
  private String x()
  {
    String str = f.c();
    Context localContext;
    HashMap localHashMap;
    Object localObject2;
    if (str != null)
    {
      str = String.format("%s%s", new Object[] { str, "/device/fa.sec" });
      localContext = this.h;
      localHashMap = s();
      localHashMap.put("pid", "00200201");
      localObject2 = k.d(localContext);
      if (localObject2 == null) {
        break label265;
      }
    }
    for (;;)
    {
      localHashMap.put("sim", localObject2);
      localHashMap.put("os", "Android");
      localHashMap.put("osVer", Build.VERSION.RELEASE);
      localHashMap.put("osVerCode", String.valueOf(Build.VERSION.SDK_INT));
      localHashMap.put("wkVer", k.a(localContext));
      localHashMap.put("scrl", String.valueOf(k.j(localContext)));
      localHashMap.put("scrs", String.valueOf(k.k(localContext)));
      localHashMap.put("misc", Build.FINGERPRINT);
      localHashMap.put("manuf", Build.MANUFACTURER);
      localHashMap.put("model", Build.MODEL);
      localHashMap.put("aid", k.g(localContext));
      str = com.bluefay.b.d.a(str, b("00200201", localHashMap));
      if ((str != null) && (str.length() != 0)) {
        break label271;
      }
      str = null;
      return str;
      str = String.format("%s%s", new Object[] { "http://init.51y5.net", "/device/fa.sec" });
      break;
      label265:
      localObject2 = "";
    }
    label271:
    h.a("JSON:" + str, new Object[0]);
    for (;;)
    {
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(str);
        if ("0".equals(((JSONObject)localObject2).getString("retCd"))) {
          break label392;
        }
        i1 = 0;
        if (!((JSONObject)localObject2).has("retMsg")) {
          break label387;
        }
        str = ((JSONObject)localObject2).getString("retMsg");
        h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(i1), str });
        if (i1 == 1) {
          str = ((JSONObject)localObject2).getString("dhid");
        }
      }
      catch (JSONException localJSONException)
      {
        h.a(localJSONException);
        localObject1 = null;
      }
      break;
      label387:
      Object localObject1 = null;
      continue;
      label392:
      int i1 = 1;
    }
  }
  
  private int y()
  {
    Object localObject1 = f.a(this.h).a("host", "http://init.51y5.net");
    int i1;
    if ("A".equals(b.a()))
    {
      localObject1 = String.format("%s%s", new Object[] { localObject1, "/device/fa.sec" });
      localObject1 = e.a((String)localObject1, com.lantern.core.h.b.a(true, true, "r", "00200003", b(this.h)));
      if ((localObject1 != null) && (localObject1.length != 0)) {
        break label120;
      }
      i1 = 10;
    }
    for (;;)
    {
      return i1;
      localObject1 = String.format("%s%s", new Object[] { localObject1, "/device/fcompb.pgs" });
      break;
      label120:
      h.a(com.bluefay.b.c.a((byte[])localObject1), new Object[0]);
      try
      {
        Object localObject2 = b("00200003", (byte[])localObject1);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("response:");
        h.a(localObject2, new Object[0]);
        if (((com.lantern.core.h.a)localObject2).c())
        {
          localObject1 = ((com.lantern.core.h.a)localObject2).g();
          if (localObject1 != null)
          {
            localObject1 = com.c.c.a.a.a.a.a.a.a.a((byte[])localObject1);
            String str = ((com.c.c.a.a.a.a.a.a.a)localObject1).m();
            boolean bool1 = ((com.c.c.a.a.a.a.a.a.a)localObject1).n();
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>("dhid:");
            h.a(str, new Object[0]);
            if ((this.c == null) || (this.c.length() == 0) || (bool1)) {
              h(str);
            }
            boolean bool2 = WkSecretKeyNativeNew.s9(((com.c.c.a.a.a.a.a.a.a)localObject1).l(), this.h);
            bool1 = WkSecretKeyNativeNew.s1(this.h);
            if ((bool2) && (bool1)) {
              i1 = 1;
            } else {
              i1 = 33;
            }
          }
          else
          {
            i1 = 32;
          }
        }
        else
        {
          i1 = 31;
        }
      }
      catch (Exception localException)
      {
        h.a(localException);
        i1 = 30;
      }
    }
  }
  
  public final String a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (f.a().a("gzip", true)) {}
    for (paramString = com.bluefay.b.d.a(d(paramString, paramHashMap));; paramString = com.bluefay.b.d.a(c(paramString, paramHashMap))) {
      return paramString;
    }
  }
  
  public final HashMap<String, String> a(String paramString, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = new HashMap();
    try
    {
      paramJSONObject.put("appId", this.a);
      paramJSONObject.put("pid", paramString);
      paramJSONObject.put("ed", n.a(Uri.encode(str.trim(), "UTF-8"), this.i, this.j));
      paramJSONObject.put("et", "a");
      paramJSONObject.put("st", "m");
      paramJSONObject.put("sign", g.a(paramJSONObject, this.k));
      return paramJSONObject;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
  }
  
  public final HashMap<String, String> a(HashMap<String, String> paramHashMap)
  {
    try
    {
      paramHashMap.put("st", "m");
      paramHashMap.put("sign", g.a(paramHashMap, this.k));
      return paramHashMap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  public final void a()
  {
    Object localObject2;
    Object localObject1;
    if (!this.o)
    {
      this.o = true;
      if (this.p != -1)
      {
        localObject2 = com.lantern.analytics.a.e();
        localObject1 = new StringBuilder("actrdid_");
        if (this.p != 1) {
          break label107;
        }
        str = "y";
        ((com.lantern.analytics.a)localObject2).onEvent(str);
      }
      if (this.q != -1)
      {
        localObject1 = com.lantern.analytics.a.e();
        localObject2 = new StringBuilder("actrdsd_");
        if (this.q != 1) {
          break label114;
        }
      }
    }
    label107:
    label114:
    for (String str = "y";; str = "n")
    {
      ((com.lantern.analytics.a)localObject1).onEvent(str);
      return;
      str = "n";
      break;
    }
  }
  
  public final void a(com.lantern.core.model.g paramg)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("userinfo:");
      h.a(paramg, new Object[0]);
      if ((j()) && (!this.d.equals(paramg.b))) {
        p();
      }
      this.d = paramg.b;
      p.e(this.h, this.d);
      p.a(this.h, paramg.a);
      p.h(this.h, paramg.c);
      p.i(this.h, paramg.d);
      p.k(this.h, paramg.g);
      p.l(this.h, paramg.h);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.l = paramString1;
      this.m = paramString2;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramString3;
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBoolean = j(paramString);
    }
    for (;;)
    {
      return paramBoolean;
      paramString = f(paramString);
      if ((paramString == null) || (paramString.length() == 0)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
    }
  }
  
  public final byte[] a(boolean paramBoolean, String paramString)
  {
    h.b("usefix:%s type:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    c.a.a locala = c.a.l();
    locala.a(this.a);
    locala.b(this.c);
    try
    {
      locala.d(String.valueOf(this.h.getPackageManager().getPackageInfo(this.h.getPackageName(), 0).versionCode));
      locala.e(this.e);
      locala.f(k.c());
      if (i(this.b))
      {
        locala.g(this.b);
        if (!paramBoolean) {
          break label238;
        }
        locala.a(0);
        locala.c(paramString);
        return ((c.a)locala.c()).b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        continue;
        h.a("old:" + this.b);
        this.b = com.bluefay.a.c.c(this.h);
        h.a("fix:" + this.b);
        if (this.b != null) {}
        for (String str = this.b;; str = "")
        {
          locala.g(str);
          break;
        }
        label238:
        locala.a(1);
      }
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    h.a("etype:%s so:%s fix:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    Object localObject = null;
    if (paramBoolean1) {
      if ("l".equals(paramString)) {
        paramArrayOfByte = WkSecretKeyNativeNew.s12(paramArrayOfByte, paramBoolean2, this.h);
      }
    }
    for (;;)
    {
      return paramArrayOfByte;
      if ("k".equals(paramString))
      {
        paramArrayOfByte = WkSecretKeyNativeNew.s16(paramArrayOfByte, paramBoolean2, this.h);
      }
      else if ("a".equals(paramString))
      {
        paramArrayOfByte = WkSecretKeyNativeNew.s10(paramArrayOfByte, this.h);
      }
      else if ("r".equals(paramString))
      {
        paramArrayOfByte = WkSecretKeyNativeNew.s8(paramArrayOfByte, this.h);
      }
      else
      {
        com.lantern.analytics.a.e().onEvent("pbee_" + paramString + "_" + paramBoolean1 + "_" + paramBoolean2);
        paramArrayOfByte = (byte[])localObject;
        continue;
        if ("l".equals(paramString))
        {
          h.c("l is native, not java");
          com.lantern.analytics.a.e().onEvent("pbee_" + paramString + "_" + paramBoolean1 + "_" + paramBoolean2);
          paramArrayOfByte = (byte[])localObject;
        }
        else if ("a".equals(paramString))
        {
          paramArrayOfByte = n.a(paramArrayOfByte, this.i, this.j);
        }
        else if ("r".equals(paramString))
        {
          h.c("r is native, not java");
          com.lantern.analytics.a.e().onEvent("pbee_" + paramString + "_" + paramBoolean1 + "_" + paramBoolean2);
          paramArrayOfByte = (byte[])localObject;
        }
        else
        {
          com.lantern.analytics.a.e().onEvent("pbee_" + paramString + "_" + paramBoolean1 + "_" + paramBoolean2);
          paramArrayOfByte = (byte[])localObject;
        }
      }
    }
  }
  
  public final String b()
  {
    return this.e;
  }
  
  public final HashMap<String, String> b(String paramString, HashMap<String, String> paramHashMap)
  {
    String str = new JSONObject(paramHashMap).toString();
    paramHashMap.clear();
    try
    {
      paramHashMap.put("appId", this.a);
      paramHashMap.put("pid", paramString);
      paramHashMap.put("ed", n.a(Uri.encode(str.trim(), "UTF-8"), this.i, this.j));
      paramHashMap.put("et", "a");
      paramHashMap.put("st", "m");
      paramHashMap.put("sign", g.a(paramHashMap, this.k));
      return paramHashMap;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
  }
  
  public final void b(String paramString)
  {
    h.a("dhid:" + paramString, new Object[0]);
    if (paramString != null)
    {
      this.c = paramString;
      p.c(this.h, paramString);
      if ((paramString != null) && (paramString.length() != 0)) {
        break label53;
      }
    }
    for (;;)
    {
      return;
      label53:
      String str = k.m(c.getAppContext());
      Object localObject = ".wkcid";
      if (str != null) {
        localObject = ".wkcid" + str;
      }
      localObject = new File(Environment.getExternalStorageDirectory(), (String)localObject);
      if (!((File)localObject).exists())
      {
        paramString = n.a(paramString, "YJm8T!uw2Wo^Yi80", "T9&m6OHpo%AYm$oM");
        com.bluefay.b.b.a(((File)localObject).getAbsolutePath(), paramString.getBytes());
      }
    }
  }
  
  public final boolean b(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = WkSecretKeyNativeNew.s0(this.h);
      com.lantern.analytics.a locala = com.lantern.analytics.a.e();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("intpbc_");
      locala.onEvent(paramString1 + "_" + paramString2);
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final String c()
  {
    return this.f;
  }
  
  @Deprecated
  public final HashMap<String, String> c(String paramString, HashMap<String, String> paramHashMap)
  {
    com.lantern.core.model.d locald = i.a().a(paramString);
    String str3 = new JSONObject(paramHashMap).toString();
    paramHashMap.clear();
    Object localObject = com.lantern.core.g.n.b();
    String str1 = ((com.lantern.core.model.f)localObject).b;
    String str2 = ((com.lantern.core.model.f)localObject).c;
    localObject = ((com.lantern.core.model.f)localObject).d;
    if (locald != null)
    {
      str1 = locald.a();
      str2 = locald.b();
      localObject = locald.c();
      h.a("dnKey,ak:%s", new Object[] { str1 });
    }
    try
    {
      paramHashMap.put("appId", this.a);
      paramHashMap.put("pid", paramString);
      paramHashMap.put("ed", WkSecretKeyNative.a(Uri.encode(str3.trim(), "UTF-8"), str1, str2, c.getAppContext()).trim());//encrypt
      paramHashMap.put("et", "a");
      paramHashMap.put("st", "m");
      paramHashMap.put("sign", g.b(paramHashMap, (String)localObject));
      return paramHashMap;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
      }
    }
  }
  
  public final String d()
  {
    return this.m;
  }
  
  public final String e()
  {
    return this.l;
  }
  
  public final void e(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      this.n = paramString;
    }
  }
  
  public final String f()
  {
    return this.b;
  }
  
  /* Error */
  @Deprecated
  public final String f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 163	com/lantern/core/o:c	Ljava/lang/String;
    //   6: ifnull +22 -> 28
    //   9: aload_0
    //   10: getfield 163	com/lantern/core/o:c	Ljava/lang/String;
    //   13: invokevirtual 87	java/lang/String:length	()I
    //   16: ifle +12 -> 28
    //   19: aload_0
    //   20: getfield 163	com/lantern/core/o:c	Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   32: invokestatic 853	com/lantern/core/p:i	(Landroid/content/Context;)Z
    //   35: ifeq +32 -> 67
    //   38: aload_0
    //   39: invokevirtual 856	com/lantern/core/o:t	()V
    //   42: aload_0
    //   43: getfield 163	com/lantern/core/o:c	Ljava/lang/String;
    //   46: ifnull +21 -> 67
    //   49: aload_0
    //   50: getfield 163	com/lantern/core/o:c	Ljava/lang/String;
    //   53: invokevirtual 87	java/lang/String:length	()I
    //   56: ifle +11 -> 67
    //   59: aload_0
    //   60: getfield 163	com/lantern/core/o:c	Ljava/lang/String;
    //   63: astore_1
    //   64: goto -40 -> 24
    //   67: aload_0
    //   68: invokespecial 858	com/lantern/core/o:x	()Ljava/lang/String;
    //   71: astore_2
    //   72: aload_2
    //   73: invokestatic 173	com/lantern/core/o:g	(Ljava/lang/String;)Z
    //   76: ifeq +49 -> 125
    //   79: aload_0
    //   80: aload_2
    //   81: invokespecial 668	com/lantern/core/o:h	(Ljava/lang/String;)V
    //   84: invokestatic 229	com/lantern/analytics/a:e	()Lcom/lantern/analytics/a;
    //   87: astore_3
    //   88: new 99	java/lang/StringBuilder
    //   91: astore_2
    //   92: aload_2
    //   93: ldc_w 860
    //   96: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_3
    //   100: aload_2
    //   101: aload_1
    //   102: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc_w 548
    //   108: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 236	com/lantern/analytics/a:onEvent	(Ljava/lang/String;)V
    //   117: aload_0
    //   118: getfield 163	com/lantern/core/o:c	Ljava/lang/String;
    //   121: astore_1
    //   122: goto -98 -> 24
    //   125: invokestatic 229	com/lantern/analytics/a:e	()Lcom/lantern/analytics/a;
    //   128: astore_3
    //   129: new 99	java/lang/StringBuilder
    //   132: astore_2
    //   133: aload_2
    //   134: ldc_w 860
    //   137: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload_3
    //   141: aload_2
    //   142: aload_1
    //   143: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 862
    //   149: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokevirtual 236	com/lantern/analytics/a:onEvent	(Ljava/lang/String;)V
    //   158: goto -41 -> 117
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	o
    //   0	166	1	paramString	String
    //   71	71	2	localObject	Object
    //   87	54	3	locala	com.lantern.analytics.a
    // Exception table:
    //   from	to	target	type
    //   2	24	161	finally
    //   28	64	161	finally
    //   67	117	161	finally
    //   117	122	161	finally
    //   125	158	161	finally
  }
  
  public final String g()
  {
    return this.c;
  }
  
  public final String h()
  {
    return this.d;
  }
  
  public final boolean i()
  {
    if ((this.c != null) && (this.c.length() > 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean j()
  {
    if ((this.d != null) && (this.d.length() > 0) && (!this.d.equals("a0000000000000000000000000000001"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final String k()
  {
    return this.a;
  }
  
  public final String l()
  {
    return this.i;
  }
  
  public final String m()
  {
    return this.j;
  }
  
  public final String n()
  {
    return this.k;
  }
  
  public final String o()
  {
    return this.n;
  }
  
  /* Error */
  public final void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 864
    //   5: invokestatic 155	com/bluefay/b/h:a	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   12: invokestatic 869	com/lantern/core/config/d:a	(Landroid/content/Context;)Lcom/lantern/core/config/d;
    //   15: ldc_w 871
    //   18: invokevirtual 874	com/lantern/core/config/d:a	(Ljava/lang/Class;)Lcom/lantern/core/config/a;
    //   21: checkcast 871	com/lantern/core/config/WalletConf
    //   24: invokevirtual 876	com/lantern/core/config/WalletConf:d	()Z
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +34 -> 63
    //   32: new 878	android/content/Intent
    //   35: astore_2
    //   36: aload_2
    //   37: ldc_w 880
    //   40: invokespecial 881	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   43: aload_2
    //   44: aload_0
    //   45: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   48: invokevirtual 195	android/content/Context:getPackageName	()Ljava/lang/String;
    //   51: invokevirtual 885	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   54: pop
    //   55: aload_0
    //   56: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   59: aload_2
    //   60: invokevirtual 889	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   63: aload_0
    //   64: ldc -77
    //   66: putfield 177	com/lantern/core/o:d	Ljava/lang/String;
    //   69: aload_0
    //   70: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   73: ldc 31
    //   75: invokestatic 722	com/lantern/core/p:e	(Landroid/content/Context;Ljava/lang/String;)V
    //   78: aload_0
    //   79: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   82: ldc 31
    //   84: invokestatic 725	com/lantern/core/p:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   87: pop
    //   88: aload_0
    //   89: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   92: ldc 31
    //   94: invokestatic 728	com/lantern/core/p:h	(Landroid/content/Context;Ljava/lang/String;)V
    //   97: aload_0
    //   98: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   101: ldc 31
    //   103: invokestatic 731	com/lantern/core/p:i	(Landroid/content/Context;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   110: ldc 31
    //   112: invokestatic 891	com/lantern/core/p:g	(Landroid/content/Context;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   119: ldc 31
    //   121: invokestatic 734	com/lantern/core/p:k	(Landroid/content/Context;Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 48	com/lantern/core/o:h	Landroid/content/Context;
    //   128: ldc 31
    //   130: invokestatic 738	com/lantern/core/p:l	(Landroid/content/Context;Ljava/lang/String;)V
    //   133: new 110	java/io/File
    //   136: astore_2
    //   137: aload_2
    //   138: invokestatic 116	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: ldc_w 893
    //   144: invokespecial 119	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   147: aload_2
    //   148: invokevirtual 811	java/io/File:exists	()Z
    //   151: ifeq +8 -> 159
    //   154: aload_2
    //   155: invokevirtual 896	java/io/File:delete	()Z
    //   158: pop
    //   159: aload_0
    //   160: monitorexit
    //   161: return
    //   162: astore_2
    //   163: ldc_w 898
    //   166: invokestatic 429	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   169: goto -106 -> 63
    //   172: astore_2
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_2
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	o
    //   27	2	1	bool	boolean
    //   35	120	2	localObject1	Object
    //   162	1	2	localException	Exception
    //   172	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	63	162	java/lang/Exception
    //   2	28	172	finally
    //   32	63	172	finally
    //   63	159	172	finally
    //   163	169	172	finally
  }
  
  public final boolean q()
  {
    boolean bool2 = false;
    boolean bool1;
    if ("a0000000000000000000000000000001".equals(p.d(this.h, "a0000000000000000000000000000001"))) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (!TextUtils.isEmpty(p.f(this.h)))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(p.c(this.h))) {
          bool1 = true;
        }
      }
    }
  }
  
  public final String r()
  {
    if ((this.g == null) || (this.g.length() == 0))
    {
      WifiInfo localWifiInfo = ((WifiManager)this.h.getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null) {
        this.g = localWifiInfo.getMacAddress();
      }
    }
    return this.g;
  }
  
  public final HashMap<String, String> s()
  {
    Object localObject2 = null;
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", this.a);
    localHashMap.put("lang", k.c());
    try
    {
      Object localObject1 = this.h.getPackageManager().getPackageInfo(this.h.getPackageName(), 0);
      localHashMap.put("verName", ((PackageInfo)localObject1).versionName);
      localHashMap.put("verCode", String.valueOf(((PackageInfo)localObject1).versionCode));
      localHashMap.put("chanId", this.e);
      localHashMap.put("origChanId", this.f);
      if (i(this.b))
      {
        localHashMap.put("imei", this.b);
        localObject1 = r();
        if (localObject1 == null) {
          break label460;
        }
        localHashMap.put("mac", localObject1);
        localHashMap.put("dhid", this.c);
        localHashMap.put("uhid", this.d);
        localObject1 = k.n(this.h);
        localHashMap.put("netModel", localObject1);
        if (!"w".equals(localObject1)) {
          break label466;
        }
        localObject1 = ((WifiManager)this.h.getSystemService("wifi")).getConnectionInfo();
        if (localObject1 == null) {
          break label491;
        }
        localObject2 = d(((WifiInfo)localObject1).getSSID());
        localObject1 = c(((WifiInfo)localObject1).getBSSID());
        Object localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = "";
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localHashMap.put("capBssid", localObject2);
        localHashMap.put("capSsid", localObject3);
        localHashMap.put("userToken", p.f(this.h));
        localHashMap.put("mapSP", this.n);
        localHashMap.put("longi", this.l);
        localHashMap.put("lati", this.m);
        localHashMap.put("ts", System.currentTimeMillis());
        return localHashMap;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        continue;
        h.a("old:" + this.b);
        this.b = com.bluefay.a.c.c(this.h);
        h.a("fix:" + this.b);
        if (this.b != null) {}
        for (String str = this.b;; str = "")
        {
          localHashMap.put("imei", str);
          break;
        }
        label460:
        str = "";
        continue;
        label466:
        localHashMap.put("capBssid", "");
        localHashMap.put("capSsid", "");
        continue;
        label491:
        str = null;
      }
    }
  }
  
  public final void t()
  {
    label379:
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(this.c);
        if (!bool) {
          return;
        }
        if (!p.b(this.h, "sdk_device", "check_low_ver_data", true))
        {
          h.a("already checked low version data", new Object[0]);
          continue;
        }
        h.a("start check low version data", new Object[0]);
      }
      finally {}
      p.c(this.h, "sdk_device", "check_low_ver_data", false);
      String str3 = p.b();
      Object localObject3 = PreferenceManager.getDefaultSharedPreferences(this.h);
      String str1 = ((SharedPreferences)localObject3).getString("dhid", "");
      Object localObject2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject2 = SDCardConifg.getInstance().getDhid();
        h.a("read dhid from v3 sdcard:[%s]", new Object[] { localObject2 });
      }
      String str2 = ((SharedPreferences)localObject3).getString("uhid", "");
      str1 = ((SharedPreferences)localObject3).getString("mobile_num", "");
      String str4 = ((SharedPreferences)localObject3).getString("apkstartdate", "");
      localObject3 = ((SharedPreferences)localObject3).getString("init_channel", "");
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        h.a("get init channel from 3.0:%s", new Object[] { localObject3 });
        this.f = ((String)localObject3);
        p.f(this.h, (String)localObject3);
        p.e((String)localObject3);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        h.a("get dhid from 3.0:%s", new Object[] { localObject2 });
        if ((str3 != null) && (!str3.equals(localObject2))) {
          p();
        }
        b((String)localObject2);
      }
      if ((!TextUtils.isEmpty(str2)) && (!"a0000000000000000000000000000001".equals(str2)) && (!TextUtils.isEmpty(str1)))
      {
        str3 = k.d(this.h);
        h.a("get uhid from 3.0:%s", new Object[] { str2 });
        localObject2 = new com/lantern/core/model/g;
        ((com.lantern.core.model.g)localObject2).<init>();
        ((com.lantern.core.model.g)localObject2).b = str2;
        ((com.lantern.core.model.g)localObject2).a = str1;
        ((com.lantern.core.model.g)localObject2).c = str3;
        a((com.lantern.core.model.g)localObject2);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str4)) {
          break label379;
        }
        p.n(this.h, str4);
        break;
        p();
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Init Channel:" + this.f + " Channel:" + this.e);
    localStringBuilder.append("\n");
    localStringBuilder.append("DHID:" + this.c + " UHID:" + this.d);
    return localStringBuilder.toString();
  }
  
  public final byte[] u()
  {
    Object localObject2 = null;
    com.c.d.a.a.a.a.a.a locala = com.c.d.a.a.a.a.a.l();
    locala.d(this.a);
    locala.c(k.c());
    try
    {
      Object localObject1 = this.h.getPackageManager().getPackageInfo(this.h.getPackageName(), 0);
      locala.j(((PackageInfo)localObject1).versionName);
      locala.f(String.valueOf(((PackageInfo)localObject1).versionCode));
      locala.g(this.e);
      locala.h(this.f);
      if (i(this.b))
      {
        locala.i(this.b);
        localObject1 = r();
        if (localObject1 == null) {
          break label408;
        }
        locala.e((String)localObject1);
        locala.a(this.c);
        locala.b(this.d);
        localObject1 = k.n(this.h);
        locala.m((String)localObject1);
        if (!"w".equals(localObject1)) {
          break label414;
        }
        localObject1 = ((WifiManager)this.h.getSystemService("wifi")).getConnectionInfo();
        if (localObject1 == null) {
          break label433;
        }
        localObject2 = d(((WifiInfo)localObject1).getSSID());
        localObject1 = c(((WifiInfo)localObject1).getBSSID());
        Object localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = "";
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        locala.l((String)localObject2);
        locala.k((String)localObject3);
        locala.r(p.f(this.h));
        locala.q(this.n);
        locala.o(this.l);
        locala.p(this.m);
        locala.n(System.currentTimeMillis());
        return ((com.c.d.a.a.a.a.a)locala.c()).b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        continue;
        h.a("old:" + this.b);
        this.b = com.bluefay.a.c.c(this.h);
        h.a("fix:" + this.b);
        if (this.b != null) {}
        for (String str = this.b;; str = "")
        {
          locala.i(str);
          break;
        }
        label408:
        str = "";
        continue;
        label414:
        locala.l("");
        locala.k("");
        continue;
        label433:
        str = null;
      }
    }
  }
  
  public final String v()
  {
    String str = f.a(this.h).a("host", "http://ap.51y5.net");
    if ("A".equals(b.a())) {}
    for (str = String.format("%s%s", new Object[] { str, "/ap/fa.sec" });; str = String.format("%s%s", new Object[] { str, "/ap/fcompb.pgs" })) {
      return str;
    }
  }
  
  public final String w()
  {
    String str = f.a(this.h).a("host", "http://dc.51y5.net");
    if ("A".equals(b.a())) {}
    for (str = String.format("%s%s", new Object[] { str, "/dc/fa.scmd" });; str = String.format("%s%s", new Object[] { str, "/dc/fcompb.pgs" })) {
      return str;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */