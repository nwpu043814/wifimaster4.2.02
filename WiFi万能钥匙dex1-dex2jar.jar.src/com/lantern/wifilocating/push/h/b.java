package com.lantern.wifilocating.push.h;

import android.text.TextUtils;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public String A;
  public int B;
  public int C;
  public int D;
  public String E;
  public int F;
  public int[] G;
  public int H;
  public int I;
  public long J;
  public int K;
  public int L;
  public String a;
  public String b;
  public String c;
  public int d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public int p;
  public int q;
  public String r;
  public String s;
  public String t;
  public String u;
  public int v;
  public int w;
  public String x;
  public String y;
  public String z;
  
  public static b a(JSONObject paramJSONObject)
  {
    int i1 = 0;
    b localb = new b();
    localb.a = paramJSONObject.optString("sequence");
    localb.b = paramJSONObject.optString("sequenceType");
    localb.c = paramJSONObject.optString("requestId");
    localb.I = paramJSONObject.optInt("syt");
    localb.K = paramJSONObject.optInt("showLevel");
    localb.E = paramJSONObject.optString("from");
    localb.F = paramJSONObject.optInt("template");
    localb.L = paramJSONObject.optInt("dc");
    Object localObject1 = paramJSONObject.optJSONArray("positions");
    int i2;
    Object localObject2;
    if (localObject1 != null)
    {
      i2 = ((JSONArray)localObject1).length();
      if (i2 > 0) {
        localObject2 = new int[i2];
      }
    }
    for (;;)
    {
      String str;
      if (i1 < i2) {
        str = ((JSONArray)localObject1).optString(i1);
      }
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(str);
        localObject2[i1] = localJSONObject.optInt("position", -1);
        i1++;
        continue;
        localb.G = ((int[])localObject2);
        localb.H = paramJSONObject.optInt("status");
        localObject2 = paramJSONObject.optString("content");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        try
        {
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>((String)localObject2);
          localb.l = ((JSONObject)localObject1).optString("content");
          if (!TextUtils.isEmpty(localb.l)) {
            localb.l = URLDecoder.decode(localb.l, "UTF-8");
          }
          localb.h = ((JSONObject)localObject1).optString("title");
          if (!TextUtils.isEmpty(localb.h)) {
            localb.h = URLDecoder.decode(localb.h, "UTF-8");
          }
          localb.k = ((JSONObject)localObject1).optString("subTitle");
          if (!TextUtils.isEmpty(localb.k)) {
            localb.k = URLDecoder.decode(localb.k, "UTF-8");
          }
          localb.m = ((JSONObject)localObject1).optString("btn");
          if (!TextUtils.isEmpty(localb.m)) {
            localb.m = URLDecoder.decode(localb.m, "UTF-8");
          }
          localb.e = ((JSONObject)localObject1).optString("icon");
          localb.d = ((JSONObject)localObject1).optInt("showType");
          localb.n = ((JSONObject)localObject1).optString("imageUrl");
          localb.f = ((JSONObject)localObject1).optString("nw");
          localb.g = ((JSONObject)localObject1).optString("ne");
          localb.i = ((JSONObject)localObject1).optString("sw");
          localb.j = ((JSONObject)localObject1).optString("se");
          localb.J = ((JSONObject)localObject1).optLong("showTime");
          localb.o = ((JSONObject)localObject1).optString("misc");
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
        localObject2 = paramJSONObject.optJSONArray("rules");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {}
        try
        {
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>(((JSONArray)localObject2).getString(0));
          localb.B = ((JSONObject)localObject1).optInt("condition");
          localb.D = ((JSONObject)localObject1).optInt("notification");
          localb.C = ((JSONObject)localObject1).optInt("netMode");
          localObject1 = paramJSONObject.optJSONArray("events");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {}
          try
          {
            paramJSONObject = new org/json/JSONObject;
            paramJSONObject.<init>(((JSONArray)localObject1).getString(0));
            localb.p = paramJSONObject.optInt("act");
            localb.q = paramJSONObject.optInt("browser");
            localObject1 = paramJSONObject.optString("url");
            localb.r = ((String)localObject1);
            localb.u = ((String)localObject1);
            localb.s = paramJSONObject.optString("app");
            localb.t = paramJSONObject.optString("action");
            localb.w = paramJSONObject.optInt("confirm");
            localb.v = paramJSONObject.optInt("afterAct");
            localb.x = paramJSONObject.optString("appName");
            if (!TextUtils.isEmpty(localb.x)) {
              localb.x = URLDecoder.decode(localb.x, "UTF-8");
            }
            localb.y = paramJSONObject.optString("title");
            if (!TextUtils.isEmpty(localb.y)) {
              localb.y = URLDecoder.decode(localb.y, "UTF-8");
            }
            localb.z = paramJSONObject.optString("prompt");
            if (!TextUtils.isEmpty(localb.z)) {
              localb.z = URLDecoder.decode(localb.z, "UTF-8");
            }
          }
          catch (Exception paramJSONObject)
          {
            for (;;) {}
          }
          return localb;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */