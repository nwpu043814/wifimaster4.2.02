package com.lantern.browser.comment.d;

import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
{
  public static j a(JSONObject paramJSONObject)
  {
    j localj = new j();
    localj.f(paramJSONObject.optString("userImg"));
    localj.b(paramJSONObject.optString("comment"));
    localj.a(paramJSONObject.optString("newsCommentId"));
    localj.e(paramJSONObject.optString("dhid"));
    localj.b(paramJSONObject.optInt("down"));
    localj.c(paramJSONObject.optString("nickname"));
    localj.d(paramJSONObject.optInt("sequence"));
    localj.a(paramJSONObject.optLong("createDt"));
    localj.d(paramJSONObject.optString("uhid"));
    localj.a(paramJSONObject.optInt("up"));
    localj.e(paramJSONObject.optInt("state"));
    localj.f(paramJSONObject.optInt("delStatus"));
    localj.g(paramJSONObject.optString("newsId"));
    return localj;
  }
  
  public static k a(String paramString1, String paramString2)
  {
    Object localObject4 = null;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new HashMap();
      paramString1.put("newsId", paramString2);
      a.e().onEvent("ddhotl_f", new JSONObject(paramString1).toString());
      paramString1 = (String)localObject4;
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return paramString1;
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramString1);
        paramString1 = ((JSONObject)localObject1).optString("retCd", "");
        if ("0".equals(paramString1)) {
          break label182;
        }
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        h.c(paramString1 + " " + ((JSONObject)localObject1).optString("retMsg", ""));
        paramString1 = new java/util/HashMap;
        paramString1.<init>();
        paramString1.put("newsId", paramString2);
        paramString2 = a.e();
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramString1);
        paramString2.onEvent("ddhotl_f", ((JSONObject)localObject1).toString());
        paramString1 = (String)localObject4;
      }
      catch (Exception paramString1)
      {
        h.a(paramString1);
        paramString1 = (String)localObject4;
      }
      continue;
      label182:
      if (((JSONObject)localObject1).optBoolean("cmt", true)) {
        break;
      }
      paramString1 = new java/util/HashMap;
      paramString1.<init>();
      paramString1.put("newsId", paramString2);
      paramString2 = a.e();
      localObject1 = new org/json/JSONObject;
      ((JSONObject)localObject1).<init>(paramString1);
      paramString2.onEvent("ddhotn_s", ((JSONObject)localObject1).toString());
      h.c("forbidden comment");
      paramString1 = (String)localObject4;
    }
    JSONArray localJSONArray1 = ((JSONObject)localObject1).getJSONArray("result");
    if (localJSONArray1 != null)
    {
      int k = localJSONArray1.length();
      if (k > 0)
      {
        k localk = new com/lantern/browser/comment/d/k;
        localk.<init>();
        int i = 0;
        for (paramString1 = null; i < k; paramString1 = (String)localObject2)
        {
          JSONArray localJSONArray2 = localJSONArray1.optJSONArray(i);
          localObject2 = paramString1;
          if (localJSONArray2 != null)
          {
            int m = localJSONArray2.length();
            int j = 0;
            localObject1 = null;
            while (j < m)
            {
              JSONObject localJSONObject = localJSONArray2.optJSONObject(j);
              Object localObject3 = localObject1;
              localObject2 = paramString1;
              if (localJSONObject != null)
              {
                localObject3 = localObject1;
                localObject2 = paramString1;
                if (localJSONObject.optInt("state") == 0)
                {
                  localObject2 = paramString1;
                  if (paramString1 == null)
                  {
                    localObject2 = new java/util/ArrayList;
                    ((ArrayList)localObject2).<init>();
                  }
                  paramString1 = (String)localObject1;
                  if (localObject1 == null)
                  {
                    paramString1 = new java/util/ArrayList;
                    paramString1.<init>();
                  }
                  paramString1.add(a(localJSONObject));
                  localObject3 = paramString1;
                }
              }
              j++;
              localObject1 = localObject3;
              paramString1 = (String)localObject2;
            }
            localObject2 = paramString1;
            if (paramString1 != null)
            {
              localObject2 = paramString1;
              if (localObject1 != null)
              {
                paramString1.add(localObject1);
                localObject2 = paramString1;
              }
            }
          }
          i++;
        }
        localk.a(paramString1);
        paramString1 = localk;
        label471:
        if ((paramString1 != null) && (paramString1.a() != null) && (!paramString1.a().isEmpty()))
        {
          localObject1 = new java/util/HashMap;
          ((HashMap)localObject1).<init>();
          ((Map)localObject1).put("newsId", paramString2);
          paramString2 = a.e();
          localObject2 = new org/json/JSONObject;
          ((JSONObject)localObject2).<init>((Map)localObject1);
          paramString2.onEvent("ddhotd_s", ((JSONObject)localObject2).toString());
        }
      }
    }
    for (;;)
    {
      break;
      localObject1 = new java/util/HashMap;
      ((HashMap)localObject1).<init>();
      ((Map)localObject1).put("newsId", paramString2);
      localObject2 = a.e();
      paramString2 = new org/json/JSONObject;
      paramString2.<init>((Map)localObject1);
      ((a)localObject2).onEvent("ddhotn_s", paramString2.toString());
      continue;
      paramString1 = null;
      break label471;
      paramString1 = null;
    }
  }
  
  public static String a(j paramj)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("userImg", paramj.k());
      localJSONObject.put("sequence", paramj.m());
      localJSONObject.put("newsCommentId", paramj.a());
      localJSONObject.put("comment", paramj.b());
      localJSONObject.put("nickname", paramj.c());
      localJSONObject.put("createDt", paramj.d());
      localJSONObject.put("up", paramj.e());
      localJSONObject.put("down", paramj.f());
      localJSONObject.put("uped", paramj.g());
      localJSONObject.put("uhid", paramj.i());
      localJSONObject.put("dhid", paramj.j());
      localJSONObject.put("state", paramj.o());
      localJSONObject.put("delStatus", paramj.p());
      localJSONObject.put("newsId", paramj.n());
      paramj = localJSONObject.toString();
      return paramj;
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        paramj = null;
      }
    }
  }
  
  public static List<i> a(JSONArray paramJSONArray, String paramString)
  {
    if (paramJSONArray != null)
    {
      int k = paramJSONArray.length();
      int i = 0;
      for (Object localObject1 = null;; localObject1 = localObject2)
      {
        localObject2 = localObject1;
        if (i >= k) {
          break;
        }
        Object localObject4 = paramJSONArray.optJSONArray(i);
        if (localObject4 != null)
        {
          int m = ((JSONArray)localObject4).length();
          int j = 0;
          for (localObject2 = null;; localObject2 = localObject3)
          {
            localObject3 = localObject2;
            if (j >= m) {
              break;
            }
            JSONObject localJSONObject = ((JSONArray)localObject4).optJSONObject(j);
            localObject3 = localObject2;
            if (localJSONObject != null)
            {
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = new ArrayList();
              }
              ((List)localObject3).add(a(localJSONObject));
            }
            j++;
          }
        }
        Object localObject3 = null;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject4 = new i();
          ((i)localObject4).a(paramString);
          ((i)localObject4).a((List)localObject3);
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((List)localObject2).add(localObject4);
        }
        i++;
      }
    }
    Object localObject2 = null;
    return (List<i>)localObject2;
  }
  
  public static List<i> a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    return a(paramJSONObject.optJSONArray(paramString1), paramString2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */