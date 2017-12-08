package com.lantern.favorite.ui;

import android.content.Intent;
import com.bluefay.b.a;
import com.lantern.core.favorite.WkSceneFavorite;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;

final class k
  implements a
{
  k(FavoriteFragment paramFavoriteFragment, bluefay.app.k paramk) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    this.a.dismiss();
    switch (((Integer)paramObject).intValue())
    {
    }
    for (;;)
    {
      return;
      WkWeiXinUtil.shareToWeiXin(0, FavoriteFragment.f(this.b).contentSrc, FavoriteFragment.f(this.b).srcName, "", FavoriteFragment.f(this.b).thumbnailLink);
      continue;
      WkWeiXinUtil.shareToWeiXin(1, FavoriteFragment.f(this.b).contentSrc, FavoriteFragment.f(this.b).srcName, "", FavoriteFragment.f(this.b).thumbnailLink);
      continue;
      paramString = new Intent(FavoriteFragment.g(this.b), FavoriteTags.class);
      paramString.putExtra("favId", FavoriteFragment.f(this.b).favId);
      this.b.startActivityForResult(paramString, 0);
      continue;
      FavoriteFragment.h(this.b);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */