package com.lantern.browser.search.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;

final class l
  implements View.OnTouchListener
{
  l(WkSearchTitleBar paramWkSearchTitleBar) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (WkSearchTitleBar.b(this.a)) {
        WkSearchTitleBar.c(this.a).setTextColor(-1);
      }
      break;
    }
    for (;;)
    {
      return false;
      WkSearchTitleBar.c(this.a).setTextColor(-8796930);
      continue;
      if (WkSearchTitleBar.f(this.a).getText().toString().trim().length() > 0) {
        WkSearchTitleBar.c(this.a).setTextColor(-1);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */