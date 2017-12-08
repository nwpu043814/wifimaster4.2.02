package com.lantern.webox.a.a;

import android.text.TextUtils;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.a.h.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m
  implements com.lantern.webox.a.h
{
  public final void a(WkBrowserWebView paramWkBrowserWebView, String paramString, h.a parama)
  {
    i = 0;
    for (;;)
    {
      try
      {
        localJSONObject2 = new org/json/JSONObject;
        localJSONObject2.<init>();
        localJSONObject1 = new org/json/JSONObject;
        localJSONObject1.<init>();
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(paramString);
        paramString = ((JSONObject)localObject).optJSONArray("jsApiList");
        if ((paramString == null) || (paramString.length() == 0))
        {
          com.bluefay.b.h.a("checkJsApi apiList is empty", new Object[0]);
          localJSONObject2.put("checkResult", localJSONObject1.toString());
          parama.a(localJSONObject2.toString());
          return;
        }
      }
      catch (Exception paramWkBrowserWebView)
      {
        JSONObject localJSONObject2;
        JSONObject localJSONObject1;
        com.bluefay.b.h.a(paramWkBrowserWebView);
        continue;
        if (i >= paramString.length()) {
          continue;
        }
        Object localObject = paramString.optString(i);
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool) {
          continue;
        }
        try
        {
          paramWkBrowserWebView.getClass().getDeclaredMethod((String)localObject, new Class[] { String.class });
          localJSONObject1.put((String)localObject, true);
          i++;
        }
        catch (Exception localException)
        {
          localJSONObject1.put((String)localObject, false);
          continue;
        }
        localJSONObject2.put("checkResult", localJSONObject1.toString());
        parama.a(localJSONObject1.toString());
        continue;
      }
      paramWkBrowserWebView = paramWkBrowserWebView.a("jsi:wifikey");
      if (paramWkBrowserWebView != null) {
        continue;
      }
      com.bluefay.b.h.a("can not find service wifikey", new Object[0]);
      localJSONObject2.put("checkResult", localJSONObject1.toString());
      parama.a(localJSONObject1.toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */