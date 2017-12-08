package com.lantern.feed.ui;

import android.content.Context;
import android.text.TextUtils;
import android.widget.HorizontalScrollView;
import com.lantern.feed.a.m;
import com.lantern.feed.b.o;

final class bz
  extends HorizontalScrollView
{
  bz(WkFeedTabLabel paramWkFeedTabLabel, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((WkFeedTabLabel.a(this.a) != null) && (!WkFeedTabLabel.a(this.a).c()))
    {
      paramInt3 = WkFeedTabLabel.b(this.a).getChildCount();
      paramInt2 = 0;
      if (paramInt2 < paramInt3)
      {
        bx localbx = (bx)WkFeedTabLabel.b(this.a).getChildAt(paramInt2);
        if ((!localbx.a().e()) && (WkFeedTabLabel.a(this.a, localbx.getLeft() - paramInt1, localbx.getRight() - paramInt1)))
        {
          localbx.a().f();
          if (!TextUtils.isEmpty(WkFeedTabLabel.c(this.a))) {
            break label139;
          }
          m.a().a(localbx.a());
        }
        for (;;)
        {
          paramInt2++;
          break;
          label139:
          com.lantern.feed.channel.a.a.a().a(localbx.a());
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */