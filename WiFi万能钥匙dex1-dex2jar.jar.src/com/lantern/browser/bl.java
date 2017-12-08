package com.lantern.browser;

import com.lantern.browser.ui.WkBrowserFragment;

final class bl
  implements Runnable
{
  bl(bh parambh) {}
  
  public final void run()
  {
    WkBrowserFragment localWkBrowserFragment = bh.a(this.a).q();
    if (localWkBrowserFragment != null) {
      localWkBrowserFragment.f();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */