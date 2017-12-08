package com.lantern.wifilocating.push.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.util.i;
import com.lantern.wifilocating.push.util.j;
import com.lantern.wifilocating.push.util.n;
import org.json.JSONObject;

public final class l
  extends d
{
  public l()
  {
    super(e.f);
  }
  
  public final void b() {}
  
  public final void b(JSONObject paramJSONObject)
  {
    int m = 0;
    int j = 0;
    for (;;)
    {
      try
      {
        i = paramJSONObject.optInt("et");
        localObject2 = paramJSONObject.optString("content");
        if (i == 0)
        {
          paramJSONObject = (JSONObject)localObject2;
          if (!TextUtils.isEmpty(paramJSONObject)) {
            continue;
          }
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject2;
        int n;
        Context localContext;
        int i1;
        long l;
        continue;
        int i = 1;
        continue;
        locala.e(2);
        continue;
        com.lantern.wifilocating.push.a.b.a locala = new com/lantern/wifilocating/push/a/b/a;
        locala.<init>();
        locala.a(((com.lantern.wifilocating.push.h.d)localObject2).a());
        locala.b(n);
        locala.c(paramJSONObject);
        locala.c(i1);
        locala.d(1);
        locala.e(1);
        locala.f(1);
        com.lantern.wifilocating.push.f.a.a("012003", locala.a(), 1, k);
        int k = 0;
        continue;
        k = 1;
        continue;
        paramJSONObject = null;
        Object localObject1 = null;
        continue;
      }
      if (i == 2)
      {
        paramJSONObject = com.lantern.wifilocating.push.util.d.a().b();
        if (paramJSONObject != null)
        {
          localObject1 = paramJSONObject.f;
          paramJSONObject = paramJSONObject.g;
          if ((localObject1 == null) || (paramJSONObject == null)) {
            paramJSONObject = null;
          }
        }
        else
        {
          paramJSONObject = j.d(i.c(c.a()));
          if (paramJSONObject == null) {
            continue;
          }
          localObject1 = paramJSONObject.d();
          paramJSONObject = paramJSONObject.e();
          continue;
        }
        paramJSONObject = n.b((String)localObject2, (String)localObject1, paramJSONObject);
      }
      else
      {
        paramJSONObject = null;
        continue;
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramJSONObject);
        ((JSONObject)localObject1).put("syt", 1);
        i = ((JSONObject)localObject1).optInt("sequenceType", -1);
        k = ((JSONObject)localObject1).optInt("dc");
        localObject2 = com.lantern.wifilocating.push.h.d.a(i);
        if (localObject2 == null) {
          continue;
        }
        n = ((JSONObject)localObject1).optInt("sequence", 0);
        localContext = c.a();
        i = i.a(localContext, com.lantern.wifilocating.push.util.d.c(), (com.lantern.wifilocating.push.h.d)localObject2);
        paramJSONObject = ((JSONObject)localObject1).optString("requestId");
        i1 = ((JSONObject)localObject1).optInt("status");
        if (i >= n) {
          continue;
        }
        if (i + 1 != n) {
          continue;
        }
        i = 0;
        if (i1 == 1) {
          j = 1;
        }
        locala = new com/lantern/wifilocating/push/a/b/a;
        locala.<init>();
        locala.a(((com.lantern.wifilocating.push.h.d)localObject2).a());
        locala.b(n);
        locala.c(paramJSONObject);
        locala.c(i1);
        locala.d(1);
        locala.f(1);
        if (j == 0) {
          continue;
        }
        if (((JSONObject)localObject1).has("remainingTime"))
        {
          l = ((JSONObject)localObject1).optLong("remainingTime");
          ((JSONObject)localObject1).remove("remainingTime");
          ((JSONObject)localObject1).put("exp", l + System.currentTimeMillis());
        }
        locala.e(1);
        com.lantern.wifilocating.push.f.a.a("012003", locala.a(), 1, k);
        m = j;
        k = i;
        if (i == 0)
        {
          i.a(localContext, com.lantern.wifilocating.push.util.d.c(), (com.lantern.wifilocating.push.h.d)localObject2, n);
          k = i;
          m = j;
        }
        if (m != 0)
        {
          paramJSONObject = new com/lantern/wifilocating/push/f/a/a;
          paramJSONObject.<init>(a.a.b, localObject1);
          com.lantern.wifilocating.push.f.f.a(paramJSONObject);
        }
        if (k != 0)
        {
          paramJSONObject = new com/lantern/wifilocating/push/f/a/a;
          paramJSONObject.<init>(a.a.d);
          com.lantern.wifilocating.push.f.f.a(paramJSONObject);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */