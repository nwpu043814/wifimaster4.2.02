package com.lantern.favorite.ui;

import com.lantern.favorite.a;

final class j
  implements Runnable
{
  j(FavoriteFragment paramFavoriteFragment, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    FavoriteFragment.a(this.c, FavoriteFragment.d(this.c).a(this.a));
    FavoriteFragment.e(this.c).sendEmptyMessageDelayed(1, this.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */