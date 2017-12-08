package com.lantern.favorite.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.lantern.favorite.R.drawable;
import com.lantern.favorite.flowlayout.TagFlowLayout;
import com.lantern.favorite.flowlayout.TagFlowLayout.b;
import com.lantern.favorite.flowlayout.a;
import java.util.ArrayList;
import java.util.Set;

final class p
  implements TagFlowLayout.b
{
  p(FavoriteTags paramFavoriteTags) {}
  
  public final boolean a(View paramView, int paramInt)
  {
    Object localObject = FavoriteTags.c(this.a).b();
    String str = (String)FavoriteTags.d(this.a).a(paramInt);
    boolean bool;
    if (TextUtils.isEmpty(str))
    {
      bool = false;
      return bool;
    }
    if (((Set)localObject).size() == 0)
    {
      paramView.setVisibility(8);
      FavoriteTags.a(this.a).remove(str);
      FavoriteTags.d(this.a).c();
    }
    for (;;)
    {
      bool = true;
      break;
      localObject = this.a.getResources().getDrawable(R.drawable.fav_hdrawable_remove);
      ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
      ((TextView)paramView).setPadding(this.a.a(20.0F), this.a.a(4.0F), this.a.a(6.0F), this.a.a(4.0F));
      if (FavoriteTags.e(this.a) != null)
      {
        FavoriteTags.e(this.a).setCompoundDrawables(null, null, null, null);
        FavoriteTags.e(this.a).setPadding(this.a.a(20.0F), this.a.a(4.0F), this.a.a(20.0F), this.a.a(4.0F));
      }
      FavoriteTags.a(this.a, (TextView)paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */