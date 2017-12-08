package com.lantern.browser.search.ui;

import android.widget.ProgressBar;
import com.lantern.browser.bd.a;

final class b
  extends bd.a
{
  b(WkSearchFragment paramWkSearchFragment) {}
  
  public final void a(int paramInt)
  {
    WkSearchFragment.a(this.a, paramInt);
    WkSearchFragment.d(this.a).setProgress(Math.max(WkSearchFragment.b(this.a), WkSearchFragment.c(this.a)));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */