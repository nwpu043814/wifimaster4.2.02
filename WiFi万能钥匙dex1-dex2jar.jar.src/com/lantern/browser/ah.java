package com.lantern.browser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.lantern.analytics.a;
import com.lantern.core.favorite.IWkAPI;
import com.lantern.core.favorite.SendMessageToWk.Req;
import com.lantern.core.favorite.WkAPIFactory;
import com.lantern.core.favorite.WkSceneFavorite;
import com.snda.wifilocating.wxapi.WXEntryActivity;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

final class ah
  implements Runnable
{
  ah(String paramString1, WebView paramWebView, int paramInt, Context paramContext, String paramString2) {}
  
  public final void run()
  {
    Object localObject4 = null;
    try
    {
      Object localObject1 = new org/json/JSONObject;
      ((JSONObject)localObject1).<init>(this.a);
      if (localObject1 != null)
      {
        localObject5 = ((JSONObject)localObject1).optString("url");
        localObject3 = ((JSONObject)localObject1).optString("title");
        localObject2 = ((JSONObject)localObject1).optString("description");
        localObject4 = ((JSONObject)localObject1).optString("image");
        localObject1 = localObject5;
        localObject5 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject5 = this.b.getUrl();
        }
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = this.b.getTitle();
        }
        localObject3 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject3 = localObject1;
        }
        if (this.c == 100)
        {
          localObject2 = WkAPIFactory.createIWkAPI(this.b.getContext());
          localObject3 = new WkSceneFavorite();
          ((WkSceneFavorite)localObject3).srcName = this.b.getContext().getString(R.string.browser_favorite_url);
          ((WkSceneFavorite)localObject3).title = ((String)localObject1);
          ((WkSceneFavorite)localObject3).contentSrc = ((String)localObject5);
          ((WkSceneFavorite)localObject3).contentType = "text/html";
          ((WkSceneFavorite)localObject3).category = "url";
          ((WkSceneFavorite)localObject3).favTime = System.currentTimeMillis();
          ((WkSceneFavorite)localObject3).thumbnailLink = ((String)localObject4);
          localObject4 = new SendMessageToWk.Req();
          ((SendMessageToWk.Req)localObject4).mData = ((WkSceneFavorite)localObject3);
          ((IWkAPI)localObject2).sendReq((SendMessageToWk.Req)localObject4);
          WkBrowserJsInterface.access$300().post(new ai(this));
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("src", this.e);
          ((HashMap)localObject2).put("title", localObject1);
          ((HashMap)localObject2).put("url", localObject5);
          localObject1 = new JSONObject((Map)localObject2).toString();
          switch (this.c)
          {
          default: 
            
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject5;
        localJSONException.printStackTrace();
        String str = null;
        continue;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = BitmapFactory.decodeResource(this.d.getResources(), R.drawable.browser_share_weixin_logo);
          WkWeiXinUtil.shareToWeiXin(this.c, (String)localObject5, str, (String)localObject3, (Bitmap)localObject2);
          if (localObject2 != null) {
            ((Bitmap)localObject2).recycle();
          }
        }
        for (;;)
        {
          WXEntryActivity.setListener(new aj(this));
          break;
          WkWeiXinUtil.shareToWeiXin(this.c, (String)localObject5, str, (String)localObject3, (String)localObject4);
        }
        a.e().onEvent("cht", str);
        continue;
        a.e().onEvent("mmt", str);
        continue;
        a.e().onEvent("favo", str);
        continue;
        Object localObject2 = null;
        Object localObject3 = null;
        str = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */