package com.lantern.browser.comment.e;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.a;
import com.bluefay.b.d;
import com.lantern.browser.comment.d.m;
import com.lantern.core.c;
import com.lantern.core.f;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends AsyncTask<Void, Void, Void>
{
  private a a;
  private int b;
  private String c;
  private m d;
  
  public e(a parama)
  {
    this.a = parama;
  }
  
  private Void a()
  {
    Object localObject2 = c.getServer().s();
    Object localObject1 = f.b();
    if (localObject1 != null) {
      localObject1 = String.format("%s%s", new Object[] { localObject1, "/comment/comment/defaultProfile.do" });
    }
    for (;;)
    {
      localObject2 = d.a((String)localObject1, (Map)localObject2);
      this.b = 0;
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)localObject2);
        if ("0".equals(((JSONObject)localObject1).optString("retCd")))
        {
          localObject2 = new com/lantern/browser/comment/d/m;
          ((m)localObject2).<init>();
          this.b = 1;
          ((m)localObject2).b(a((JSONObject)localObject1, "nicknames"));
          ((m)localObject2).a(a((JSONObject)localObject1, "avatars"));
          this.d = ((m)localObject2);
        }
        for (;;)
        {
          return null;
          localObject1 = String.format("%s%s", new Object[] { "http://comment.51y5.net", "/comment/comment/defaultProfile.do" });
          break;
          this.c = ((JSONObject)localObject1).getString("retMsg");
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private static List<String> a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = null;
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    paramJSONObject = (JSONObject)localObject;
    if (localJSONArray != null)
    {
      int j = localJSONArray.length();
      paramJSONObject = (JSONObject)localObject;
      if (j > 0)
      {
        paramString = new ArrayList();
        for (int i = 0;; i++)
        {
          paramJSONObject = paramString;
          if (i >= j) {
            break;
          }
          paramJSONObject = localJSONArray.optString(i);
          if (!TextUtils.isEmpty(paramJSONObject)) {
            paramString.add(paramJSONObject);
          }
        }
      }
    }
    return paramJSONObject;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */