package com.lantern.favorite.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class h
  extends Handler
{
  h(PullToRefreshLayout paramPullToRefreshLayout, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = (int)(8.0D + 100.0D * Math.tan(1.5707963267948966D / this.a.getMeasuredHeight() * Math.abs(PullToRefreshLayout.a(this.a))));
    if ((!PullToRefreshLayout.b(this.a)) && (PullToRefreshLayout.c(this.a) == PullToRefreshLayout.b.c) && (-PullToRefreshLayout.a(this.a) <= PullToRefreshLayout.d(this.a)))
    {
      PullToRefreshLayout.a(this.a, -PullToRefreshLayout.d(this.a));
      PullToRefreshLayout.e(this.a);
      this.a.requestLayout();
    }
    for (;;)
    {
      return;
      if (PullToRefreshLayout.a(this.a) < 0)
      {
        PullToRefreshLayout.b(this.a, i);
        this.a.requestLayout();
        PullToRefreshLayout.f(this.a).sendEmptyMessage(0);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */