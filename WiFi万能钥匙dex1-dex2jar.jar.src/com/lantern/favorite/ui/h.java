package com.lantern.favorite.ui;

import bluefay.app.k;
import com.bluefay.a.e;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.favorite.R.string;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;

final class h
  implements com.bluefay.b.a
{
  h(FavoriteDetails paramFavoriteDetails, k paramk) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    this.a.dismiss();
    switch (((Integer)paramObject).intValue())
    {
    }
    for (;;)
    {
      return;
      if (com.bluefay.a.a.c(this.b.getApplication()))
      {
        FavoriteDetails.d(this.b);
      }
      else
      {
        e.a(this.b.getString(R.string.network_exception));
        continue;
        WkWeiXinUtil.shareToWeiXin(0, FavoriteDetails.e(this.b).contentSrc, FavoriteDetails.e(this.b).srcName, "", FavoriteDetails.e(this.b).thumbnailLink);
        continue;
        WkWeiXinUtil.shareToWeiXin(1, FavoriteDetails.e(this.b).contentSrc, FavoriteDetails.e(this.b).srcName, "", FavoriteDetails.e(this.b).thumbnailLink);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */