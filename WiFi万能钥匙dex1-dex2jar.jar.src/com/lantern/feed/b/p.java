package com.lantern.feed.b;

import android.text.TextUtils;
import com.bluefay.b.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p
{
  public static a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      a locala = new a();
      Object localObject1 = new ArrayList();
      Object localObject2;
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(paramString);
        paramString = ((JSONObject)localObject2).optString("retCd", "");
        if ("0".equals(paramString)) {
          break label132;
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        h.c(paramString + " " + ((JSONObject)localObject2).optString("retMsg", "") + " " + ((JSONObject)localObject2).optString("showMsg", ""));
        paramString = locala;
      }
      catch (Exception paramString)
      {
        h.a(paramString);
        paramString = locala;
      }
      continue;
      label132:
      locala.a(((JSONObject)localObject2).optInt("search", 0));
      paramString = ((JSONObject)localObject2).optJSONArray("result");
      if (paramString != null)
      {
        int j = paramString.length();
        int i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = paramString.optJSONObject(i);
          if (localJSONObject != null)
          {
            localObject2 = new com/lantern/feed/b/o;
            ((o)localObject2).<init>();
            ((o)localObject2).a(localJSONObject.optString("id", ""));
            ((o)localObject2).b(localJSONObject.optString("channelTitle", ""));
            ((o)localObject2).c(localJSONObject.optString("channelUrl", ""));
            if (localJSONObject.optInt("isLink", 1) != 1) {
              break label269;
            }
          }
          label269:
          for (boolean bool = true;; bool = false)
          {
            ((o)localObject2).a(bool);
            ((List)localObject1).add(localObject2);
            i++;
            break;
          }
        }
      }
      locala.a((List)localObject1);
      paramString = locala;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */