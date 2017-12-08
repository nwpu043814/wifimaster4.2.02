package com.linksure.apservice.a.a.c;

import com.linksure.apservice.a.d.a;
import com.linksure.apservice.a.d.e;
import com.linksure.apservice.a.d.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  public static a a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    a locala;
    for (paramJSONObject = null;; paramJSONObject = locala)
    {
      return paramJSONObject;
      locala = new a();
      locala.a = paramJSONObject.optString("serviceAccountId");
      locala.b = paramJSONObject.optString("name");
      locala.o = paramJSONObject.optString("logo");
      locala.c = paramJSONObject.optInt("type");
      locala.g = paramJSONObject.optBoolean("follow");
      locala.i = paramJSONObject.optBoolean("frozen");
      locala.h = paramJSONObject.optBoolean("black");
      locala.j = paramJSONObject.optBoolean("pushSwitch", true);
      locala.k = paramJSONObject.optBoolean("top", false);
      locala.e = paramJSONObject.optInt("followCount");
      locala.p = paramJSONObject.optString("serviceTel");
      locala.q = paramJSONObject.optString("introduce");
      locala.n = a(paramJSONObject.optJSONArray("menuList"));
      locala.r = paramJSONObject.optString("industry");
      locala.s = paramJSONObject.optString("principalInfo");
    }
  }
  
  private static List<e> a(JSONArray paramJSONArray)
  {
    Object localObject;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      localObject = null;
    }
    int j;
    ArrayList localArrayList;
    int i;
    do
    {
      return (List<e>)localObject;
      j = paramJSONArray.length();
      localArrayList = new ArrayList(j);
      i = 0;
      localObject = localArrayList;
    } while (i >= j);
    JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
    if (localJSONObject == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i++;
      break;
      localObject = new e();
      ((e)localObject).a = localJSONObject.optString("menuId");
      ((e)localObject).b = localJSONObject.optString("menuName");
      ((e)localObject).c = localJSONObject.optString("url");
      ((e)localObject).d = a(localJSONObject.optJSONArray("childs"));
    }
  }
  
  public static f b(JSONObject paramJSONObject)
  {
    f localf = new f();
    localf.e = paramJSONObject.optString("serviceAccountId");
    localf.b = paramJSONObject.optInt("type");
    localf.g = System.currentTimeMillis();
    if (localf.b != 1) {
      if (localf.b == 2) {
        localf.d = c(paramJSONObject.optJSONObject("content"));
      }
    }
    for (;;)
    {
      return localf;
      if (localf.b == 5) {
        localf.d = d(paramJSONObject);
      } else if (localf.b == 7) {
        localf.d = e(paramJSONObject);
      } else if (localf.b == 8) {
        localf.d = f(paramJSONObject);
      } else {
        localf.d = paramJSONObject.optString("content");
      }
    }
  }
  
  private static String c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("thumb", paramJSONObject.optString("thumb"));
        localJSONObject.put("origin", paramJSONObject.optString("origin"));
        paramJSONObject = localJSONObject.toString();
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
  }
  
  private static String d(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("title", paramJSONObject.optString("title"));
        localJSONObject.put("image", paramJSONObject.optString("coverImg"));
        localJSONObject.put("link", paramJSONObject.optString("content"));
        localJSONObject.put("pageId", paramJSONObject.optString("pageId"));
        paramJSONObject = localJSONObject.toString();
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
  }
  
  private static String e(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("pageList", paramJSONObject.optJSONArray("pageList"));
        paramJSONObject = localJSONObject.toString();
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
  }
  
  private static String f(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("title", paramJSONObject.optString("title"));
        localJSONObject.put("summary", paramJSONObject.optString("summary"));
        localJSONObject.put("content", paramJSONObject.optString("content"));
        localJSONObject.put("url", paramJSONObject.optString("url"));
        paramJSONObject = localJSONObject.toString();
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */