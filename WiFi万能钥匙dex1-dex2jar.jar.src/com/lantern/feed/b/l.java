package com.lantern.feed.b;

import android.text.TextUtils;
import com.bluefay.b.h;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
{
  public static m a(String paramString)
  {
    Object localObject = null;
    boolean bool = false;
    if (TextUtils.isEmpty(paramString))
    {
      h.a("parseJsonToData aData is invalid", new Object[0]);
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      try
      {
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        if (!localJSONObject.has("retCd")) {
          break label140;
        }
        paramString = localJSONObject.optString("retCd", "");
        if ("0".equals(paramString)) {
          break label140;
        }
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        h.c(paramString + " " + localJSONObject.optString("retMsg", "") + " " + localJSONObject.optString("showMsg", ""));
        paramString = (String)localObject;
      }
      catch (Exception paramString)
      {
        h.a(paramString);
        paramString = (String)localObject;
      }
      continue;
      label140:
      JSONObject localJSONObject = localJSONObject.optJSONObject("result");
      if (localJSONObject != null)
      {
        paramString = new com/lantern/feed/b/m;
        paramString.<init>();
        int i = localJSONObject.optInt("id");
        if (i <= 0)
        {
          h.a("parseJsonToData id is invalid", new Object[0]);
          paramString = (String)localObject;
        }
        else
        {
          paramString.a(i);
          int k = localJSONObject.optInt("type");
          if ((k != 1) && (k != 2))
          {
            h.a("parseJsonToData type is invalid", new Object[0]);
            paramString = (String)localObject;
          }
          else
          {
            paramString.b(k);
            label248:
            int m;
            int j;
            if (k == 1)
            {
              paramString.a(localJSONObject.optString("htmlUrl"));
              if (localJSONObject.optInt("showCloseButton", 1) == 1) {
                bool = true;
              }
              paramString.a(bool);
              paramString.c(localJSONObject.optInt("autoCloseDelay"));
              paramString.c(localJSONObject.optString("dateStart"));
              paramString.d(localJSONObject.optString("dateEnd"));
              paramString.e(localJSONObject.optString("timeStart"));
              paramString.f(localJSONObject.optString("timeEnd"));
              paramString.g(localJSONObject.optInt("dayInterval"));
              paramString.i(localJSONObject.optInt("countPerday"));
              paramString.f(localJSONObject.optInt("countMax"));
              m = localJSONObject.optInt("width");
              i = localJSONObject.optInt("height");
              j = localJSONObject.optInt("scale");
              if (k != 1) {
                break label490;
              }
              j = Math.min(Math.max(0, m), 100);
              i = Math.min(Math.max(0, i), 100);
              paramString.d(j);
              paramString.e(i);
            }
            for (;;)
            {
              paramString.j(localJSONObject.optInt("curTotalCount", 0));
              paramString.k(localJSONObject.optInt("curCountForDays", 0));
              paramString.g(localJSONObject.optString("lastDate", ""));
              break;
              if (k != 2) {
                break label248;
              }
              paramString.a(localJSONObject.optString("imgUrl"));
              paramString.b(localJSONObject.optString("imgLinkUrl"));
              break label248;
              label490:
              if (k == 2)
              {
                paramString.d(m);
                paramString.e(i);
                paramString.h(Math.min(Math.max(0, j), 100));
              }
            }
          }
        }
      }
      else
      {
        paramString = new m();
      }
    }
  }
  
  public static String a(m paramm)
  {
    int i = 1;
    if ((paramm == null) || (paramm.a() == 0))
    {
      paramm = "";
      return paramm;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new org/json/JSONObject;
        localJSONObject1.<init>();
        JSONObject localJSONObject2 = new org/json/JSONObject;
        localJSONObject2.<init>();
        localJSONObject2.put("id", paramm.a());
        int j = paramm.b();
        localJSONObject2.put("type", j);
        if (j == 1)
        {
          localJSONObject2.put("htmlUrl", paramm.c());
          if (!paramm.l()) {
            break label299;
          }
          localJSONObject2.put("showCloseButton", i);
          localJSONObject2.put("autoCloseDelay", paramm.i());
          localJSONObject2.put("dateStart", paramm.e());
          localJSONObject2.put("dateEnd", paramm.f());
          localJSONObject2.put("timeStart", paramm.g());
          localJSONObject2.put("timeEnd", paramm.h());
          localJSONObject2.put("dayInterval", paramm.n());
          localJSONObject2.put("countPerday", paramm.q());
          localJSONObject2.put("countMax", paramm.m());
          localJSONObject2.put("curTotalCount", paramm.r());
          localJSONObject2.put("curCountForDays", paramm.s());
          localJSONObject2.put("lastDate", paramm.p());
          localJSONObject2.put("scale", paramm.o());
          localJSONObject1.put("result", localJSONObject2);
          paramm = localJSONObject1.toString();
          break;
        }
        if (j != 2) {
          continue;
        }
        localJSONObject2.put("imgUrl", paramm.c());
        localJSONObject2.put("imgLinkUrl", paramm.d());
        continue;
      }
      catch (Exception paramm)
      {
        h.a(paramm);
        paramm = "";
      }
      label299:
      i = 0;
    }
  }
  
  public static k b(String paramString)
  {
    for (;;)
    {
      try
      {
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        if (!localJSONObject.has("retCd")) {
          continue;
        }
        localObject1 = localJSONObject.optString("retCd", "");
        if ("0".equals(localObject1)) {
          continue;
        }
        paramString = new java/lang/StringBuilder;
        paramString.<init>();
        h.c((String)localObject1 + " " + localJSONObject.optString("retMsg", "") + " " + localJSONObject.optString("showMsg", ""));
        paramString = null;
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        Object localObject1;
        Object localObject2;
        h.a(paramString);
        paramString = null;
        continue;
      }
      return paramString;
      localJSONObject = localJSONObject.optJSONObject("result");
      if (localJSONObject == null) {
        continue;
      }
      paramString = new com/lantern/feed/b/k;
      paramString.<init>();
      localObject1 = localJSONObject.optJSONArray("subAds");
      if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
      {
        paramString = null;
      }
      else
      {
        localObject1 = ((JSONArray)localObject1).optJSONObject(0);
        if (localObject1 == null)
        {
          paramString = null;
        }
        else
        {
          localObject2 = ((JSONObject)localObject1).optJSONArray("imgUrls");
          if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0))
          {
            paramString = null;
          }
          else
          {
            localObject2 = (String)((JSONArray)localObject2).opt(0);
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramString = null;
            }
            else
            {
              paramString.c(((JSONObject)localObject1).optString("creativeId"));
              paramString.a((String)localObject2);
              paramString.b(((JSONObject)localObject1).optString("url"));
              paramString.a(localJSONObject.optLong("dura"));
              paramString.a(localJSONObject.optBoolean("skip"));
              paramString.c(localJSONObject.optInt("width"));
              paramString.b(localJSONObject.optInt("height"));
              paramString.b(localJSONObject.optLong("interval"));
              paramString.a(j.b(localJSONObject.optString("dc")));
              paramString.a(j.b(((JSONObject)localObject1).optString("subDc")));
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */