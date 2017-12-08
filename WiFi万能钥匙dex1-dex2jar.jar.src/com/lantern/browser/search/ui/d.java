package com.lantern.browser.search.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

final class d
  implements View.OnTouchListener
{
  d(WkSearchHistoryListView paramWkSearchHistoryListView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      WkSearchHistoryListView.a(this.a).setTextColor(-16611856);
    }
    for (;;)
    {
      return false;
      WkSearchHistoryListView.a(this.a).setTextColor(-3750202);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */