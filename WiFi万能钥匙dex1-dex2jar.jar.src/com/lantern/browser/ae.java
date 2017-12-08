package com.lantern.browser;

import android.text.TextUtils;
import android.webkit.WebView;
import com.lantern.analytics.a;
import com.snda.wifilocating.wxapi.OnWeChatResponse;
import com.snda.wifilocating.wxapi.WXEntryActivity;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class ae
  implements Runnable
{
  ae(String paramString, WebView paramWebView) {}
  
  public final void run()
  {
    try
    {
      localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(this.a);
      if (!localJSONObject.has("type")) {
        break label245;
      }
      i = localJSONObject.getInt("type");
      if (localJSONObject.has("callback"))
      {
        str2 = localJSONObject.getString("callback");
        if (!TextUtils.isEmpty(str2))
        {
          localObject1 = new com/lantern/browser/af;
          ((af)localObject1).<init>(this, str2, i);
          WXEntryActivity.setListener((OnWeChatResponse)localObject1);
        }
      }
      if (!localJSONObject.has("url")) {
        break label303;
      }
      localObject1 = bp.d(localJSONObject.getString("url"));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        int i;
        Object localObject1;
        String str3;
        label245:
        continue;
        a.e().onEvent("mmt", localException);
        continue;
        a.e().onEvent("favo", localException);
        continue;
        Object localObject2 = "";
        continue;
        String str2 = "";
        continue;
        label303:
        String str1 = "www.wifi.com";
      }
    }
    if (localJSONObject.has("title"))
    {
      str2 = localJSONObject.getString("title");
      if (localJSONObject.has("content"))
      {
        localObject2 = localJSONObject.getString("content");
        str3 = "";
        if (localJSONObject.has("img")) {
          str3 = localJSONObject.getString("img");
        }
        WkWeiXinUtil.shareToWeiXin(i, (String)localObject1, str2, (String)localObject2, str3);
        localObject2 = new java/util/HashMap;
        ((HashMap)localObject2).<init>();
        ((HashMap)localObject2).put("src", "web");
        ((HashMap)localObject2).put("title", str2);
        ((HashMap)localObject2).put("url", localObject1);
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((Map)localObject2);
        localObject1 = ((JSONObject)localObject1).toString();
        switch (i)
        {
        default: 
        case 0: 
          for (;;)
          {
            return;
            i = 1;
            break;
            a.e().onEvent("cht", (String)localObject1);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */