package com.analysis.model;

import android.content.Context;
import android.os.Build;
import com.analysis.common.upload.h;
import com.analysis.common.upload.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements com.analysis.common.a, k, Serializable
{
  private static final long m = -6657983101267502427L;
  public String f;
  public int g;
  public Map<String, String> h;
  public String i;
  public String j;
  public String k;
  public Context l;
  
  public d(Context paramContext, String paramString1, int paramInt, Map<String, String> paramMap, String paramString2, String paramString3, String paramString4)
  {
    this.f = paramString1;
    this.g = paramInt;
    this.h = paramMap;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramString4;
    this.l = paramContext;
  }
  
  private d(String paramString, int paramInt, Map<String, String> paramMap)
  {
    this.f = paramString;
    this.g = paramInt;
    this.h = paramMap;
  }
  
  public final void a(h paramh)
  {
    if (com.analysis.common.tools.c.a(paramh.d)) {
      paramh.d = new ArrayList();
    }
    paramh.d.add(this);
  }
  
  public final String toString()
  {
    JSONObject localJSONObject1 = new JSONObject();
    int n;
    JSONObject localJSONObject2;
    try
    {
      localJSONObject1.put("platform", "android");
      localJSONObject1.put("session_id", this.i);
      localJSONObject1.put("event_duration", this.g);
      localJSONObject1.put("event_id", this.f);
      localJSONObject1.put("login_name", this.j);
      localJSONObject1.put("sdk_version", com.analysis.common.c.d());
      localJSONObject1.put("app_version", com.analysis.common.c.c(this.l));
      localJSONObject1.put("device_brand", Build.BRAND);
      localJSONObject1.put("device_model", Build.MODEL);
      localJSONObject1.put("appId", this.k);
      if (this.h == null)
      {
        n = 0;
        Iterator localIterator;
        if ((n != 0) && (this.h.size() > 0))
        {
          localJSONObject2 = new org/json/JSONObject;
          localJSONObject2.<init>();
          localIterator = this.h.entrySet().iterator();
        }
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localJSONObject2.put((String)localEntry.getKey(), localEntry.getValue());
          continue;
          com.analysis.common.tools.a.a("ALInterface", "event = " + localJSONObject1.toString());
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    for (;;)
    {
      return localJSONObject1.toString();
      n = 1;
      break;
      localJSONObject1.put("event_properties", localJSONObject2);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */