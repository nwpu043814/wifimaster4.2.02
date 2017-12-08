package com.lantern.feed.b;

import android.text.TextUtils;
import android.util.SparseArray;
import com.lantern.feed.d.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private static SparseArray<List<r>> a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString2)) {}
    SparseArray localSparseArray;
    for (paramString1 = (String)localObject1;; paramString1 = localSparseArray) {
      for (;;)
      {
        return paramString1;
        localSparseArray = new SparseArray();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        try
        {
          JSONArray localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>(paramString2);
          int j = localJSONArray.length();
          int i = 0;
          if (i < j)
          {
            Object localObject2 = localJSONArray.optJSONObject(i);
            r localr;
            if (localObject2 != null)
            {
              localr = new com/lantern/feed/b/r;
              localr.<init>();
              localr.b(paramInt);
              localr.a(((JSONObject)localObject2).optString("text", ""));
              localr.a(((JSONObject)localObject2).optInt("id", 0));
              localr.d(((JSONObject)localObject2).optString("img", ""));
              paramString2 = ((JSONObject)localObject2).optString("align", "l");
              localObject2 = ((JSONObject)localObject2).optString("url", "");
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!"l".equals(paramString2))) {
                break label192;
              }
              localArrayList2.add(localr);
            }
            for (;;)
            {
              i++;
              break;
              label192:
              localr.b((String)localObject2);
              localr.c(paramString1);
              localArrayList1.add(localr);
            }
          }
          if (localSparseArray.size() <= 0) {}
        }
        catch (Exception paramString1)
        {
          com.bluefay.b.h.a(paramString1);
          if (localArrayList2.size() > 0) {
            localSparseArray.put(0, localArrayList2);
          }
          if (localArrayList1.size() > 0) {
            localSparseArray.put(1, localArrayList1);
          }
          paramString1 = (String)localObject1;
        }
      }
    }
  }
  
  private static g a(JSONObject paramJSONObject)
  {
    g localg = new g();
    int j = Integer.valueOf(paramJSONObject.optString("type", "1")).intValue();
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    localg.a(i);
    j = Integer.valueOf(paramJSONObject.optString("template", "100")).intValue();
    i = j;
    if (j < 100) {
      i = 100;
    }
    localg.b(i);
    localg.a(paramJSONObject.optString("id", ""));
    localg.a(paramJSONObject.optBoolean("repeat", false));
    localg.c(paramJSONObject.optInt("bgTemp"));
    localg.m(paramJSONObject.optInt("contentType"));
    Object localObject1 = paramJSONObject.optString("dc");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localg.a(b((String)localObject1));
    }
    localg.a(e(paramJSONObject.optString("dislike")));
    paramJSONObject = paramJSONObject.optJSONArray("item");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      i = 0;
      if (i < paramJSONObject.length())
      {
        JSONObject localJSONObject1 = paramJSONObject.optJSONObject(i);
        if (localJSONObject1 == null) {
          com.bluefay.b.h.c("error, item is null");
        }
        for (;;)
        {
          i++;
          break;
          localObject1 = new h();
          ((h)localObject1).g(localg.a());
          ((h)localObject1).a(localJSONObject1.optString("title", ""));
          String str = localJSONObject1.optString("imgs", "");
          if (!TextUtils.isEmpty(str)) {
            localObject2 = new ArrayList();
          }
          try
          {
            JSONArray localJSONArray = new org/json/JSONArray;
            localJSONArray.<init>(str);
            k = localJSONArray.length();
            for (j = 0; j < k; j++)
            {
              JSONObject localJSONObject2 = localJSONArray.optJSONObject(j);
              if (localJSONObject2 != null)
              {
                str = localJSONObject2.optString("url", "");
                if (!TextUtils.isEmpty(str)) {
                  ((List)localObject2).add(str);
                }
                ((h)localObject1).c(localJSONObject2.optInt("h"));
                ((h)localObject1).d(localJSONObject2.optInt("w"));
              }
            }
            ((h)localObject1).a((List)localObject2);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              int k;
              com.bluefay.b.h.a(localJSONException);
              continue;
              boolean bool = false;
            }
          }
          Object localObject2 = localJSONObject1.optJSONObject("video");
          if (localObject2 != null)
          {
            ((h)localObject1).b(Integer.valueOf(((JSONObject)localObject2).optString("dura", "0")).intValue());
            ((h)localObject1).d(((JSONObject)localObject2).optString("src", ""));
          }
          localObject2 = localJSONObject1.optString("tags", "");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((h)localObject1).a(a(localg.a(), localg.f(), (String)localObject2));
          }
          ((h)localObject1).b(String.valueOf(c.a(localJSONObject1.optString("feedTime", ""))));
          k = Integer.valueOf(localJSONObject1.optString("feedType", "101")).intValue();
          j = k;
          if (k < 101) {
            j = 101;
          }
          ((h)localObject1).a(j);
          ((h)localObject1).c(localJSONObject1.optString("url", ""));
          ((h)localObject1).e(localJSONObject1.optString("closeUrl", ""));
          ((h)localObject1).f(localJSONObject1.optString("nt", ""));
          ((h)localObject1).h(localJSONObject1.optString("digest", ""));
          ((h)localObject1).i(localJSONObject1.optString("tel", ""));
          ((h)localObject1).j(localJSONObject1.optString("dist", ""));
          localObject2 = localJSONObject1.optString("subDc");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((h)localObject1).b(b((String)localObject2));
          }
          localObject2 = localJSONObject1.optString("itemId", "");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((h)localObject1).g((String)localObject2);
          }
          localObject2 = localJSONObject1.optJSONObject("app");
          if (localObject2 != null)
          {
            ((h)localObject1).n(((JSONObject)localObject2).optString("name"));
            ((h)localObject1).o(((JSONObject)localObject2).optString("pkg"));
            ((h)localObject1).p(((JSONObject)localObject2).optString("icon"));
          }
          ((h)localObject1).m(localJSONObject1.optString("dlUrl"));
          ((h)localObject1).k(localJSONObject1.optString("btnTxt"));
          ((h)localObject1).l(localJSONObject1.optString("deeplinkUrl"));
          ((h)localObject1).t(localJSONObject1.optString("headImg"));
          ((h)localObject1).u(localJSONObject1.optString("headLandUrl"));
          ((h)localObject1).q(localJSONObject1.optString("address"));
          localObject2 = localJSONObject1.optJSONArray("detailLink");
          if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            localObject2 = ((JSONArray)localObject2).optJSONObject(0);
            if (localObject2 != null)
            {
              ((h)localObject1).r(((JSONObject)localObject2).optString("text"));
              ((h)localObject1).s(((JSONObject)localObject2).optString("url"));
            }
          }
          localObject2 = localJSONObject1.optString("upTags");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((h)localObject1).a(d((String)localObject2));
          }
          localJSONObject1 = localJSONObject1.optJSONObject("service");
          if (localJSONObject1 != null)
          {
            ((h)localObject1).x(localJSONObject1.optString("serviceId"));
            ((h)localObject1).w(localJSONObject1.optString("type"));
            ((h)localObject1).v(localJSONObject1.optString("score", "0"));
            if (localJSONObject1.optInt("isAtten") != 1) {
              break label971;
            }
            bool = true;
            ((h)localObject1).a(bool);
          }
          localg.a((h)localObject1);
        }
      }
    }
    else
    {
      label971:
      com.bluefay.b.h.c("error, item array is null");
    }
    localg.Y();
    return localg;
  }
  
  public static i a(String paramString)
  {
    int j = 0;
    i locali = new i();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return locali;
      locali.a(paramString);
      Object localObject1;
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramString);
        paramString = ((JSONObject)localObject1).optString("retCd", "");
        if ("0".equals(paramString)) {
          break label129;
        }
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        com.bluefay.b.h.c(paramString + " " + ((JSONObject)localObject1).optString("retMsg", "") + " " + ((JSONObject)localObject1).optString("showMsg", ""));
      }
      catch (Exception paramString)
      {
        com.bluefay.b.h.a(paramString);
      }
      continue;
      label129:
      paramString = ((JSONObject)localObject1).optString("customInfo", "");
      if (!TextUtils.isEmpty(paramString))
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(paramString);
        locali.a((JSONObject)localObject2);
      }
      Object localObject2 = ((JSONObject)localObject1).optJSONArray("delIds");
      int k;
      int i;
      if (localObject2 != null)
      {
        k = ((JSONArray)localObject2).length();
        paramString = new java/util/ArrayList;
        paramString.<init>();
        for (i = 0; i < k; i++) {
          paramString.add(((JSONArray)localObject2).getString(i));
        }
        locali.b(paramString);
      }
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("adBackup");
      if (localJSONArray != null)
      {
        localObject2 = new java/util/ArrayList;
        ((ArrayList)localObject2).<init>();
        k = localJSONArray.length();
        for (i = 0; i < k; i++)
        {
          paramString = localJSONArray.optJSONObject(i);
          if (paramString != null) {
            ((List)localObject2).add(a(paramString));
          }
        }
        locali.c((List)localObject2);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("hotwords");
      if (localObject2 != null)
      {
        k = ((JSONArray)localObject2).length();
        paramString = new java/util/ArrayList;
        paramString.<init>();
        for (i = 0; i < k; i++) {
          paramString.add(((JSONArray)localObject2).getString(i));
        }
        locali.d(paramString);
      }
      paramString = ((JSONObject)localObject1).optJSONArray("result");
      if (paramString != null)
      {
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        k = paramString.length();
        for (i = j; i < k; i++)
        {
          localObject2 = paramString.optJSONObject(i);
          if (localObject2 != null) {
            ((List)localObject1).add(a((JSONObject)localObject2));
          }
        }
        locali.a((List)localObject1);
      }
      else
      {
        com.bluefay.b.h.c("error, result is null");
      }
    }
  }
  
  public static SparseArray<List<b>> b(String paramString)
  {
    SparseArray localSparseArray = new SparseArray();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      paramString = localJSONObject.optString("show", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(1, paramString);
        }
      }
      paramString = localJSONObject.optString("inview", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(2, paramString);
        }
      }
      paramString = localJSONObject.optString("click", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(3, paramString);
        }
      }
      paramString = localJSONObject.optString("videoS", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(7, paramString);
        }
      }
      paramString = localJSONObject.optString("videoE", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(8, paramString);
        }
      }
      paramString = localJSONObject.optString("downloading", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(6, paramString);
        }
      }
      paramString = localJSONObject.optString("downloaded", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(4, paramString);
        }
      }
      paramString = localJSONObject.optString("installed", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(5, paramString);
        }
      }
      paramString = localJSONObject.optString("dial", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(9, paramString);
        }
      }
      paramString = localJSONObject.optString("deep", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = c(paramString);
        if ((paramString != null) && (paramString.size() > 0)) {
          localSparseArray.put(10, paramString);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramString);
      }
    }
    return localSparseArray;
  }
  
  private static List<b> c(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      ArrayList localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new org/json/JSONArray;
        localJSONArray.<init>(paramString);
        int j = localJSONArray.length();
        for (;;)
        {
          paramString = localArrayList;
          if (i >= j) {
            break;
          }
          JSONObject localJSONObject = localJSONArray.optJSONObject(i);
          if (localJSONObject != null)
          {
            paramString = new com/lantern/feed/b/b;
            paramString.<init>();
            paramString.b(localJSONObject.optString("first", ""));
            paramString.c(localJSONObject.optString("other", ""));
            paramString.a(localJSONObject.optString("url", ""));
            paramString.a(localJSONObject.optBoolean("pos", false));
            localArrayList.add(paramString);
          }
          i++;
        }
      }
      catch (JSONException paramString)
      {
        com.bluefay.b.h.a(paramString);
        paramString = localArrayList;
      }
    }
  }
  
  private static r d(String paramString)
  {
    try
    {
      Object localObject = new org/json/JSONArray;
      ((JSONArray)localObject).<init>(paramString);
      if (((JSONArray)localObject).length() <= 0) {
        break label64;
      }
      localObject = ((JSONArray)localObject).optJSONObject(0);
      if (localObject == null) {
        break label64;
      }
      paramString = new com/lantern/feed/b/r;
      paramString.<init>();
      paramString.a(((JSONObject)localObject).optString("text", ""));
      paramString.a(((JSONObject)localObject).optInt("id", 0));
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramString);
        label64:
        paramString = null;
      }
    }
    return paramString;
  }
  
  private static List<d> e(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>(paramString);
      if (localJSONArray.length() > 0)
      {
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        for (int i = 0;; i++)
        {
          paramString = localArrayList;
          if (i >= localJSONArray.length()) {
            break;
          }
          paramString = localJSONArray.optJSONObject(i);
          if (paramString != null)
          {
            d locald = new com/lantern/feed/b/d;
            locald.<init>();
            locald.b(paramString.optString("text"));
            locald.a(paramString.optString("id"));
            localArrayList.add(locald);
          }
        }
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      com.bluefay.b.h.a(paramString);
      paramString = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */