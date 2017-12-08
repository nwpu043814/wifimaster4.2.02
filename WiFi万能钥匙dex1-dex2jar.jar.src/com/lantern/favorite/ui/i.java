package com.lantern.favorite.ui;

import java.util.ArrayList;

final class i
  implements Runnable
{
  i(FavoriteFragment paramFavoriteFragment, ArrayList paramArrayList) {}
  
  public final void run()
  {
    if (FavoriteFragment.b(this.b) == null) {
      FavoriteFragment.a(this.b, new ArrayList());
    }
    FavoriteFragment.b(this.b).addAll(this.a);
    if (FavoriteFragment.b(this.b).size() <= 10) {
      FavoriteFragment.c(this.b).b(FavoriteFragment.b(this.b));
    }
    for (;;)
    {
      return;
      FavoriteFragment.c(this.b).b(FavoriteFragment.b(FavoriteFragment.b(this.b)));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */