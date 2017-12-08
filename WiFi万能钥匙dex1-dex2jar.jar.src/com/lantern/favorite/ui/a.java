package com.lantern.favorite.ui;

import android.app.FragmentManager;
import android.util.Log;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.favorite.b.a.a;
import com.lantern.favorite.c.c;
import java.util.ArrayList;

final class a
  implements a.a
{
  a(FavoriteActivity paramFavoriteActivity) {}
  
  public final void a(ArrayList<WkSceneFavorite> paramArrayList)
  {
    if ((c.a().length() == 0) && (this.a.h != 0))
    {
      FavoriteFragment localFavoriteFragment = (FavoriteFragment)this.a.getFragmentManager().findFragmentByTag(FavoriteFragment.class.getName());
      if (localFavoriteFragment != null) {
        localFavoriteFragment.a(paramArrayList);
      }
    }
    Log.i("king", "total=" + this.a.g);
    Log.i("king", "pull=" + this.a.h);
    if ((this.a.g != this.a.h) && (this.a.g != 0)) {
      FavoriteActivity.a(this.a, this.a.i, this.a.h);
    }
    for (;;)
    {
      return;
      FavoriteActivity.a(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */