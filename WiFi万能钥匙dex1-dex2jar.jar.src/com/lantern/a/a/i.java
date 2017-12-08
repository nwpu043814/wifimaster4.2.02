package com.lantern.a.a;

import android.text.TextUtils;
import com.bluefay.b.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class i
  implements com.bluefay.b.a
{
  i(e parame) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    int i = 0;
    if ((paramObject == null) || (TextUtils.isEmpty((String)paramObject)))
    {
      if (e.f(this.a) != null) {
        e.f(this.a).a(paramInt, paramString, e.g(this.a));
      }
      return;
    }
    com.lantern.analytics.a.e().onEvent("vadr");
    e.a(this.a, null);
    paramObject = (String)paramObject;
    h.a("valid ad json" + (String)paramObject, new Object[0]);
    Object localObject;
    if (!e.h(this.a)) {
      for (;;)
      {
        try
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>((String)paramObject);
          localObject = ((JSONObject)localObject).optJSONObject("dsp");
          if (localObject != null)
          {
            paramObject = ((JSONObject)localObject).optString("name");
            if ((((JSONObject)localObject).optInt("status") == 0) && (e.i(this.a) != null) && (e.i(this.a).size() > 0) && (i < e.i(this.a).size()))
            {
              localObject = (a)e.i(this.a).get(i);
              if ((localObject == null) || (!((a)localObject).d.endsWith((String)paramObject)) || (((a)localObject).a == null)) {
                continue;
              }
              e.a(this.a, (c)((a)localObject).a.get(0));
            }
          }
        }
        catch (JSONException paramObject)
        {
          label247:
          h.a((Exception)paramObject);
          continue;
        }
        if (e.f(this.a) == null) {
          break;
        }
        e.f(this.a).a(paramInt, paramString, e.g(this.a));
        break;
        i++;
      }
    }
    label517:
    for (;;)
    {
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>((String)paramObject);
        paramObject = ((JSONObject)localObject).optJSONArray("idlist");
        if ((paramObject == null) || (((JSONArray)paramObject).length() == 0)) {
          break;
        }
        int m = ((JSONArray)paramObject).length();
        int j = 0;
        i = 0;
        if (j >= m) {
          break label247;
        }
        localObject = ((JSONArray)paramObject).optJSONObject(j);
        if ((localObject != null) || (((JSONObject)localObject).length() <= 0))
        {
          int n = ((JSONObject)localObject).optInt("idea");
          if ((((JSONObject)localObject).optInt("status") != 0) || (e.i(this.a) == null) || (e.i(this.a).size() <= 0)) {
            break label517;
          }
          int k = 0;
          if (k >= e.i(this.a).size()) {
            break label517;
          }
          localObject = (a)e.i(this.a).get(k);
          if ((localObject != null) && (((a)localObject).b == n) && (((a)localObject).a != null))
          {
            e.a(this.a, (c)((a)localObject).a.get(0));
            i = 1;
            if (i == 1) {
              break label247;
            }
            j++;
            continue;
          }
          k++;
          continue;
        }
      }
      catch (JSONException paramObject)
      {
        h.a((Exception)paramObject);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */