package android.support.v4.view;

import android.view.MenuItem;

class MenuItemCompat$IcsMenuVersionImpl$1
  implements MenuItemCompatIcs.SupportActionExpandProxy
{
  MenuItemCompat$IcsMenuVersionImpl$1(MenuItemCompat.IcsMenuVersionImpl paramIcsMenuVersionImpl, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener) {}
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return this.val$listener.onMenuItemActionCollapse(paramMenuItem);
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return this.val$listener.onMenuItemActionExpand(paramMenuItem);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/view/MenuItemCompat$IcsMenuVersionImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */