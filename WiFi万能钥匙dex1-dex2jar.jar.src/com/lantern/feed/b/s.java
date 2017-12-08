package com.lantern.feed.b;

import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.feed.d.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s
{
  public static List<t> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    ArrayList localArrayList;
    JSONObject localJSONObject;
    Object localObject1;
    int m;
    int i;
    do
    {
      do
      {
        for (;;)
        {
          return paramString;
          localArrayList = new ArrayList();
          try
          {
            localJSONObject = new org/json/JSONObject;
            localJSONObject.<init>(paramString);
            paramString = localJSONObject.optString("retCd", "");
            if ("0".equals(paramString)) {
              break;
            }
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            h.c(paramString + " " + localJSONObject.optString("retMsg", "") + " " + localJSONObject.optString("showMsg", ""));
            paramString = localArrayList;
          }
          catch (Exception paramString)
          {
            h.a(paramString);
            paramString = localArrayList;
          }
        }
        localObject1 = localJSONObject.optJSONArray("result");
        paramString = localArrayList;
      } while (localObject1 == null);
      m = ((JSONArray)localObject1).length();
      i = 0;
      paramString = localArrayList;
    } while (i >= m);
    Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
    if (localObject2 != null)
    {
      paramString = new com/lantern/feed/b/t;
      paramString.<init>();
      paramString.a(((JSONObject)localObject2).optInt("id"));
      if (((JSONObject)localObject2).optInt("isDefault", 0) != 1) {
        break label328;
      }
    }
    label328:
    for (boolean bool = true;; bool = false)
    {
      paramString.a(bool);
      paramString.d(d.a(((JSONObject)localObject2).optString("bgColor"), 0));
      paramString.a(localJSONObject.optDouble("opacity", 1.0D));
      paramString.e(d.a(((JSONObject)localObject2).optString("borderColor"), 0));
      int k = 10;
      int j = k;
      if (paramString.c() == 0)
      {
        j = k;
        if (paramString.d() == 0) {
          j = 12;
        }
      }
      paramString.c(j);
      localObject2 = ((JSONObject)localObject2).optString("textColor");
      j = -6710887;
      if (paramString.c() != 0) {
        j = 0;
      }
      paramString.b(d.a((String)localObject2, j));
      localArrayList.add(paramString);
      i++;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */