package com.lantern.launcher.task;

import android.os.AsyncTask;
import com.bluefay.b.h;
import com.lantern.core.o;
import com.lantern.notifaction.o2o.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends AsyncTask<Void, Void, Integer>
{
  com.bluefay.b.a a;
  com.lantern.notifaction.o2o.c b;
  
  public a(com.bluefay.b.a parama)
  {
    this.a = parama;
  }
  
  private Integer a()
  {
    com.lantern.core.c.getServer().f("geto2oservice");
    this.b = new com.lantern.notifaction.o2o.c();
    str = com.lantern.notifaction.o2o.a.a();
    h.a("retMsg:%s", new Object[] { str });
    try
    {
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(str);
      j = ((JSONObject)localObject).optInt("retCd", -1);
      if (j == 0) {
        break label341;
      }
      i = 0;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject;
        ArrayList localArrayList;
        int k;
        h.a(localJSONException);
        h.a("retmsg:%s", new Object[] { str });
        int j = 30;
        continue;
        int i = 1;
      }
    }
    this.b.a(j);
    this.b.a(((JSONObject)localObject).optString("retMsg", ""));
    this.b.b(((JSONObject)localObject).optInt("count", 0));
    localObject = ((JSONObject)localObject).optJSONArray("result");
    j = i;
    if (localObject != null)
    {
      j = i;
      if (((JSONArray)localObject).length() > 0)
      {
        localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        k = ((JSONArray)localObject).length();
        for (j = 0; j < k; j++)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(j);
          if (localJSONObject != null)
          {
            b localb = new com/lantern/notifaction/o2o/b;
            localb.<init>();
            localb.a(localJSONObject.optString("iconUrl", ""));
            localb.b(localJSONObject.optString("name", ""));
            localb.c(localJSONObject.optString("url", ""));
            localb.a(localJSONObject.optInt("num", 0));
            localb.a(localJSONObject.optBoolean("showFlag", false));
            localb.c(localJSONObject.optInt("serviceType", 0));
            localb.a(localJSONObject.optLong("intervalTime", 0L));
            localb.b(localJSONObject.optInt("order", 0));
            localArrayList.add(localb);
          }
        }
        this.b.a(localArrayList);
        j = i;
      }
    }
    return Integer.valueOf(j);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/task/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */