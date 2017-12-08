package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.feed.b.k;

final class bk
  implements View.OnClickListener
{
  bk(bi parambi) {}
  
  public final void onClick(View paramView)
  {
    if (bi.c(this.a) != null) {
      bi.c(this.a).cancel();
    }
    this.a.dismiss();
    bi.a(this.a, bi.b(this.a).f());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */