package com.lantern.browser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import com.lantern.analytics.a;
import com.lantern.core.favorite.IWkAPI;
import com.lantern.core.favorite.SendMessageToWk.Req;
import com.lantern.core.favorite.WkAPIFactory;
import com.lantern.core.favorite.WkSceneFavorite;
import com.snda.wifilocating.wxapi.WXEntryActivity;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class ay
  implements Runnable
{
  ay(at paramat, WkBrowserWebView paramWkBrowserWebView, int paramInt, String paramString) {}
  
  public final void run()
  {
    Object localObject1 = this.a.getUrl();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.d.a())
    {
      localObject2 = localObject1;
      if (at.a(this.d, (String)localObject1)) {
        localObject2 = URLDecoder.decode(((String)localObject1).substring(at.k(this.d).length() + 5));
      }
      if (((String)localObject2).length() > 64)
      {
        localObject1 = ((String)localObject2).substring(0, 64) + "...";
        localObject3 = this.a.getContext().getString(R.string.wifi_master_key);
        if (this.b != 100) {
          break label437;
        }
        localObject3 = WkAPIFactory.createIWkAPI(this.a.getContext());
        localObject4 = new WkSceneFavorite();
        ((WkSceneFavorite)localObject4).srcName = this.a.getContext().getString(R.string.browser_favorite_url);
        ((WkSceneFavorite)localObject4).title = ((String)localObject1);
        ((WkSceneFavorite)localObject4).contentSrc = ((String)localObject2);
        ((WkSceneFavorite)localObject4).contentType = "text/html";
        ((WkSceneFavorite)localObject4).category = "url";
        ((WkSceneFavorite)localObject4).favTime = System.currentTimeMillis();
        ((WkSceneFavorite)localObject4).thumbnailLink = null;
        SendMessageToWk.Req localReq = new SendMessageToWk.Req();
        localReq.mData = ((WkSceneFavorite)localObject4);
        ((IWkAPI)localObject3).sendReq(localReq);
        at.l(this.d).post(new az(this));
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("src", this.c);
        ((HashMap)localObject3).put("title", localObject1);
        ((HashMap)localObject3).put("url", localObject2);
        localObject1 = new JSONObject((Map)localObject3).toString();
        switch (this.b)
        {
        }
      }
    }
    for (;;)
    {
      return;
      localObject3 = localObject2;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      if (!TextUtils.isEmpty(this.a.getTitle()))
      {
        localObject3 = this.a.getTitle();
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
      }
      if (!TextUtils.isEmpty(this.a.a()))
      {
        localObject3 = this.a.a();
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
      }
      if (((String)localObject1).length() > 64)
      {
        localObject3 = ((String)localObject1).substring(0, 64) + "...";
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
      }
      localObject2 = localObject1;
      break;
      label437:
      if (TextUtils.isEmpty(null))
      {
        localObject4 = BitmapFactory.decodeResource(at.d(this.d).getResources(), R.drawable.browser_share_weixin_logo);
        WkWeiXinUtil.shareToWeiXin(this.b, (String)localObject2, (String)localObject1, (String)localObject3, (Bitmap)localObject4);
        if (localObject4 != null) {
          ((Bitmap)localObject4).recycle();
        }
      }
      for (;;)
      {
        WXEntryActivity.setListener(new ba(this));
        break;
        WkWeiXinUtil.shareToWeiXin(this.b, (String)localObject2, (String)localObject1, (String)localObject3, null);
      }
      a.e().onEvent("cht", (String)localObject1);
      continue;
      a.e().onEvent("mmt", (String)localObject1);
      continue;
      a.e().onEvent("favo", (String)localObject1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */