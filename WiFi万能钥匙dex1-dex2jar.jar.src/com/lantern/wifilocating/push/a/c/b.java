package com.lantern.wifilocating.push.a.c;

import com.lantern.wifilocating.push.d.g;
import com.lantern.wifilocating.push.util.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  private boolean a;
  private String b;
  private JSONObject c;
  private JSONArray d;
  
  public b()
  {
    this.a = false;
  }
  
  public b(String paramString, JSONArray paramJSONArray)
  {
    this.a = true;
    this.b = paramString;
    this.d = paramJSONArray;
  }
  
  private static HashMap<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = g.d().e();
    if ((localHashMap == null) || (localHashMap.size() == 0)) {}
    for (paramString1 = null;; paramString1 = g.a(localHashMap))
    {
      return paramString1;
      localHashMap.put("pid", "00500101");
      localHashMap.put("dcType", paramString1);
      localHashMap.put("msg", paramString2);
      h.b("map:" + localHashMap);
      g.d();
    }
  }
  
  private static JSONArray a(List<com.lantern.wifilocating.push.a.b.b> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.lantern.wifilocating.push.a.b.b localb = (com.lantern.wifilocating.push.a.b.b)paramList.next();
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(localb.c);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONArray;
  }
  
  private static void a()
  {
    h.a("upload all start");
    Object localObject1 = com.lantern.wifilocating.push.a.a.c().a().a();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      h.c("dc files count is 0");
      return;
    }
    Iterator localIterator = ((List)localObject1).iterator();
    label46:
    com.lantern.wifilocating.push.a.b.b localb;
    Object localObject2;
    String str;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label316;
      }
      localObject1 = (String)localIterator.next();
      if (!"005001".equals(localObject1)) {
        break label310;
      }
      List localList = com.lantern.wifilocating.push.a.a.c().a().a((String)localObject1);
      if ((localList == null) || (localList.size() == 0))
      {
        h.b("dctype:%s PushEventItem count is 0", new Object[] { localObject1 });
      }
      else
      {
        int k = localList.size();
        label219:
        for (int j = 0; j < k; j++)
        {
          localb = (com.lantern.wifilocating.push.a.b.b)localList.get(j);
          localObject2 = localb.c;
          str = com.lantern.wifilocating.push.a.c.a();
          localObject2 = a((String)localObject1, (String)localObject2);
          if (localObject2 == null) {
            break label318;
          }
          str = com.lantern.wifilocating.push.d.c.a(str, (Map)localObject2);
          h.b("JSON:" + str);
          if ((str != null) && (str.length() != 0)) {
            break label225;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        label225:
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(str);
        boolean bool = "0".equals(((JSONObject)localObject2).getString("retCd"));
        if (!bool) {
          break label318;
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        h.a(localJSONException);
        i = 30;
        continue;
      }
      h.b("retcode=%s", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break label219;
      }
      com.lantern.wifilocating.push.a.a.c().a().a((String)localObject1, localb.a);
      break label219;
      label310:
      a((String)localObject1);
      break label46;
      label316:
      break;
      label318:
      int i = 0;
    }
  }
  
  private static void a(String paramString)
  {
    List localList = com.lantern.wifilocating.push.a.a.c().a().a(paramString);
    if ((localList == null) || (localList.size() == 0)) {
      h.b("dctype:%s PushEventItem count is 0", new Object[] { paramString });
    }
    int i;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    for (;;)
    {
      return;
      int k = (localList.size() + 20 - 1) / 20;
      for (int j = 0; j < k; j++)
      {
        i = localList.size();
        localObject1 = new ArrayList();
        int m = Math.min(i, (j + 1) * 20);
        for (i = j * 20; i < m; i++) {
          ((ArrayList)localObject1).add(localList.get(i));
        }
        h.b("page:%s count:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((ArrayList)localObject1).size()) });
        localObject3 = a((List)localObject1).toString();
        localObject2 = com.lantern.wifilocating.push.a.c.a();
        localObject3 = a(paramString, (String)localObject3);
        if (localObject3 == null) {
          break label342;
        }
        localObject3 = com.lantern.wifilocating.push.d.c.a((String)localObject2, (Map)localObject3);
        h.b("JSON:" + (String)localObject3);
        if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
          break label227;
        }
      }
    }
    for (;;)
    {
      try
      {
        label227:
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>((String)localObject3);
        boolean bool = "0".equals(((JSONObject)localObject2).getString("retCd"));
        if (!bool) {
          break label342;
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        h.a(localJSONException);
        i = 30;
        continue;
      }
      h.b("retcode=%s", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.lantern.wifilocating.push.a.b.b)((Iterator)localObject1).next();
        com.lantern.wifilocating.push.a.a.c().a().a(paramString, ((com.lantern.wifilocating.push.a.b.b)localObject2).a);
      }
      else
      {
        break;
        label342:
        i = 0;
      }
    }
  }
  
  public final void run()
  {
    Object localObject;
    String str;
    int i;
    if (this.a)
    {
      h.a("upload one start");
      if (this.c != null)
      {
        localObject = a(this.b, this.c.toString());
        str = com.lantern.wifilocating.push.a.c.a();
        if (localObject == null) {
          break label237;
        }
        str = com.lantern.wifilocating.push.d.c.a(str, (Map)localObject);
        h.b("JSON:" + str);
        if ((str != null) && (str.length() != 0)) {
          break label232;
        }
        i = 10;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(str);
        boolean bool = "0".equals(((JSONObject)localObject).getString("retCd"));
        if (bool) {
          i = 1;
        }
      }
      catch (JSONException localJSONException)
      {
        h.a(localJSONException);
        i = 30;
        continue;
        if (this.d == null) {
          continue;
        }
        com.lantern.wifilocating.push.a.a.c().a().a(this.b, this.d);
        continue;
      }
      h.b("retcode=%s", new Object[] { Integer.valueOf(i) });
      if (i != 1)
      {
        if (this.c != null) {
          com.lantern.wifilocating.push.a.a.c().a().a(this.b, this.c);
        }
      }
      else
      {
        return;
        if (this.d == null) {
          break label230;
        }
        localObject = a(this.b, this.d.toString());
        break;
      }
      a();
      continue;
      label230:
      continue;
      label232:
      i = 0;
      continue;
      label237:
      i = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/a/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */