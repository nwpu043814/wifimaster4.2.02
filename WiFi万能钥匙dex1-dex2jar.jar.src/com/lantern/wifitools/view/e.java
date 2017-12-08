package com.lantern.wifitools.view;

import android.widget.ImageView;
import com.lantern.wifitools.R.drawable;

final class e
  implements Runnable
{
  e(LoadingView paramLoadingView, int paramInt, long paramLong) {}
  
  public final void run()
  {
    if (this.a == 1)
    {
      LoadingView.a(this.c).setImageResource(R.drawable.dot_alpha);
      LoadingView.b(this.c).setImageResource(R.drawable.dot);
      LoadingView.c(this.c).setImageResource(R.drawable.dot_alpha);
      if (LoadingView.d(this.c)) {
        break label169;
      }
      LoadingView.a(this.c, this.b + 300L, this.a);
    }
    for (;;)
    {
      return;
      if (this.a == 2)
      {
        LoadingView.a(this.c).setImageResource(R.drawable.dot_alpha);
        LoadingView.b(this.c).setImageResource(R.drawable.dot_alpha);
        LoadingView.c(this.c).setImageResource(R.drawable.dot);
        break;
      }
      LoadingView.a(this.c).setImageResource(R.drawable.dot);
      LoadingView.b(this.c).setImageResource(R.drawable.dot_alpha);
      LoadingView.c(this.c).setImageResource(R.drawable.dot_alpha);
      break;
      label169:
      LoadingView.a(this.c).setImageResource(R.drawable.dot_gray);
      LoadingView.b(this.c).setImageResource(R.drawable.dot_gray);
      LoadingView.c(this.c).setImageResource(R.drawable.dot_gray);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */