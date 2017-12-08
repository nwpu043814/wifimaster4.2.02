package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.feed.b.m;

final class bq
  implements View.OnClickListener
{
  bq(bm parambm) {}
  
  public final void onClick(View paramView)
  {
    if (bm.c(this.a) != null) {
      bm.c(this.a).cancel();
    }
    this.a.dismiss();
    bm.a(this.a, bm.b(this.a).d());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */